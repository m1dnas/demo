package com.cfe.demo.utils.dgi;

import org.apache.xml.security.encryption.EncryptedData;
import org.apache.xml.security.encryption.EncryptedKey;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.EncryptionConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.Key;


public class XMLEncryption {
    static {
        org.apache.xml.security.Init.init();
    }

    private static Document parseFile(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("El archivo no se encontró: " + fileName);
        }

        System.out.println("Contenido del archivo antes de analizar:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        Document document = db.parse(file);
        return document;
    }

    private static SecretKey generateSymmetricKey() throws Exception {
        String jceAlgorithmName = "DESede";
        KeyGenerator keyGenerator = KeyGenerator.getInstance(jceAlgorithmName);
        return keyGenerator.generateKey();
    }

    private static void writeDocToFile(Document doc, String fileName) throws Exception {
        FileOutputStream outStream = new FileOutputStream(new File(fileName));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, new StreamResult(outStream));
        outStream.close();
    }

    public static void encrypt(String source, String target, String ns, String element,
                               // como nombre de clave (keyName) se debe utilizar CERT_DGI_EFACTURA
                               Key publicKey, String keyName ) throws Exception {
        // Lee XML desde archivo
        Document document = parseFile(source);
        System.out.println(document);

        System.out.println("Acà tenemos: " + document.getDocumentElement().getElementsByTagNameNS(
                ns, element).item(0));
        System.out.println("LOS ATTRIBUTES: " + document.getAttributes());
        System.out.println(document.getChildNodes().getLength());
        System.out.println("EL PRIMER CHILD: " + document.getFirstChild().toString());
        System.out.println("EL text content: " + document.getTextContent());
        System.out.println("El get document element: " + document.getDocumentElement());
        System.out.println("El document namespaceURI: " + document.getNamespaceURI());
        System.out.println("LOS CHILD NODES: " + document.getChildNodes());

        // Genera clave simétrica para TripleDes
        Key symmetricKey = generateSymmetricKey();

        // Inicializa cifrador para cifrar la clave simétrica
        XMLCipher keyCipher = XMLCipher.getInstance(XMLCipher.RSA_v1dot5);
        keyCipher.init(XMLCipher.WRAP_MODE, publicKey);

        // Cifra la clave simetrica
        EncryptedKey encryptedKey = keyCipher
                .encryptKey(document, symmetricKey);

        // Especifica el elemento del documento XML a cifrar
        Element rootElement = document.getDocumentElement();
        Element elementToEncrypt = rootElement;
        if (element != null) {
            elementToEncrypt = (Element) rootElement.getElementsByTagNameNS(
                    ns, element).item(0);
            if (elementToEncrypt == null) {
                System.err.println("No se encuentra el elemento: " + element);
            }
        }

        // Inicializa cifrador para cifrar el Elemento XML
        XMLCipher xmlCipher = XMLCipher.getInstance(XMLCipher.TRIPLEDES);
        xmlCipher.init(XMLCipher.ENCRYPT_MODE, symmetricKey);

        // Agrega informacion de la clave de cifrado
        EncryptedData encryptedDataElement = xmlCipher.getEncryptedData();
        KeyInfo innerKeyInfo = new KeyInfo(document);
        innerKeyInfo.addKeyName(keyName);
        encryptedKey.setKeyInfo(innerKeyInfo);
        KeyInfo keyInfo = new KeyInfo(document);
        keyInfo.add(encryptedKey);
        encryptedDataElement.setKeyInfo(keyInfo);

        System.out.println(document + " ----- " + elementToEncrypt.getTagName());

        // Cifra
        xmlCipher.doFinal(document, elementToEncrypt);

        // Escribe el resultado en el archivo destino
        writeDocToFile(document, target);
    }

    public static void decrypt(String source, String target, Key privateKey)
                                throws Exception {
        // Lee XML desde archivo
        Document document = parseFile(source);

        // Obtiene el Elemento XML con datos cifrados
        String namespaceURI = EncryptionConstants.EncryptionSpecNS;
        String localName = EncryptionConstants._TAG_ENCRYPTEDDATA;
        Element encryptedDataElement = (Element) document
                .getElementsByTagNameNS(namespaceURI, localName).item(0);

        // Se desencripta la clave simétrica
        XMLCipher xmlCipher = XMLCipher.getInstance();
        xmlCipher.init(XMLCipher.DECRYPT_MODE, null);
        xmlCipher.setKEK(privateKey);

        // Se reemplaza el nodo encriptado con la información desencriptada
        xmlCipher.doFinal(document, encryptedDataElement);

        // Escribe el resultado en el archivo destino
        writeDocToFile(document, target);
    }

}
