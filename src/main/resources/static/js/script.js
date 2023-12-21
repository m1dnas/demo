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
