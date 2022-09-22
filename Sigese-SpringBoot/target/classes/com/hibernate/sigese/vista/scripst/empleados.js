const URL_API = "http://localhost:8080/empleados";

async function get_empleados() {
    //Enviar petición
    const resp = await fetch(URL_API);
    //Obtener datos de la peticion
    const empleados = await resp.json();
    return empleados;
}

function listar_empleados(empleados) {
    const tbody = document.getElementById("tbody");
    let tr_body = "";
    //Iterar sobre empleados
    for (let i = 0; i < empleados.length; i++) {
        const obj = empleados[i];
        tr_body += `
        <tr>
            <td>${obj.id}</td>
            <td>${obj.tipo_documento}</td>
            <td>${obj.identificacion}</td>
            <td>${obj.primer_nombre} ${obj.segundo_nombre} ${obj.primer_apellido} ${obj.segundo_apellido}</td>
            <td>${obj.area_empleado}</td>
            <td>${obj.estado_empleado}</td>
            <td>
            <button class = "btn btn-warning" onclick = 'update(${JSON.stringify(obj)})'>Actualizar</button>
            &nbsp;
            <button class = "btn btn-danger" onclick = delete_empleado(${obj.id})>Eliminar</button> 
            </td>
        </tr>
        `
    }
    tbody.innerHTML = tr_body;
}

function update(empleado) {
    window.location.href = `formulario.html?empleado=${JSON.stringify(empleado)} `;

}

async function delete_empleado(id) {
    //Enviar peticion
    const resp = await fetch(`${URL_API}/${id}`, {
        method: 'DELETE'
    });
    const text = await resp.text();
    alert(text);
    main();
}

async function main() {
    const empleados = await get_empleados();
    listar_empleados(empleados);
}

main();