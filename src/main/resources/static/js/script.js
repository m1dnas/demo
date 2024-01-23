let productoCount = 1;
let totalCompra = 0;

function agregarProducto() {
    const productosDiv = document.getElementById('productos');
    const productoItem = document.createElement('div');
    productoItem.className = 'producto-item';
    productoItem.innerHTML = `
    <hr>
    <h3>Producto ${productoCount}</h3>
    <label for="cantidad${productoCount}">Cantidad:</label>
    <input type="number" id="cantidad${productoCount}" placeholder="Cantidad" onchange="calcularTotal()">

    <label for="nombreProducto${productoCount}">Nombre del Producto:</label>
    <input type="text" id="nombreProducto${productoCount}" placeholder="Nombre del Producto">

    <label for="precio${productoCount}">Precio:</label>
    <input type="number" id="precio${productoCount}" placeholder="Precio" onchange="calcularTotal()">

    <label for="tasaIVA${productoCount}">Tasa de IVA:</label>
    <input type="number" id="tasaIVA${productoCount}" placeholder="Tasa de IVA" onchange="calcularTotal()">

    <label for="total${productoCount}" class="total">Total:</label>
    <span id="total${productoCount}">0.00</span>
  `;

    productosDiv.appendChild(productoItem);
    productoCount++;
}

function calcularTotal() {
    let total = 0;

    for (let i = 1; i < productoCount; i++) {
        const cantidad = parseFloat(document.getElementById(`cantidad${i}`).value) || 0;
        const precio = parseFloat(document.getElementById(`precio${i}`).value) || 0;
        const productoTotal = cantidad * precio;
        total += productoTotal;
        document.getElementById(`total${i}`).innerText = productoTotal.toFixed(2);
    }

    totalCompra = total;
    document.getElementById('totalValue').innerText = totalCompra.toFixed(2);
}

async function logIn() {
    let data = {};
    data.email = document.getElementById('email').value;
    data.password = document.getElementById('password').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const response = await request.text();
    if (response != "FAIL") {
        localStorage.token = response;
        localStorage.email = data.email;
        window.location.href = 'home.html';
    } else {
        alert("Incorrect log in");
    }
}

async function sendXML() {
    let data = {};

    data.tipoCFE = document.getElementById('tipoCFE').value;
    data.formaPago = document.getElementById('formaPago').value;
    data.moneda = document.getElementById('moneda').value;
    data.cliente = document.getElementById('cliente').value;
    data.tipoDocumento = document.getElementById('tipoDocumento').value;
    data.documento = document.getElementById('documento').value;
    data.cantidad = productoCount;

    const productos = document.getElementsByName('producto-item');
    let informacionProductos= [];

    for (let i = 1; i <= productos.length; i++) {
        //const producto = productos[i];
        let cantidad = document.getElementById('cantidad${' + i + '}').value;
        let nombreProducto = document.getElementById('nombreProducto${' + i + '}').value;
        let precio = document.getElementById('precio${' + i + '}');
        let tasaIVA = document.getElementById('tasaIVA${' + i + '}');

        let productoInfo = {
            item: i,
            cantidad: cantidad,
            nombreProducto: nombreProducto,
            precio: precio,
            tasaIVA: tasaIVA
        }
        informacionProductos.push(productoInfo);
    }

    data.items = informacionProductos;

    const request = await fetch('api/xml', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    /*
    const response = await request.text();
    if (response != "FAIL") {
        console.log("Pago aceptado");
        //localStorage.token = response;
        //localStorage.email = data.email;
        //window.location.href = 'home.html';
    } else {
        console.log("Pago rechazado");
        //alert("Pago rechazado");
    }*/
    console.log(informacionProductos);
}