const URL_API = "http://localhost:8080/horas";
//const URL_API = "http://localhost:8080/horas/range";



async function get_horas() {
    //Enviar petición
    const resp = await fetch(URL_API);
    //Obtener datos de la peticion
    const horas_empleados = await resp.json();
    return horas_empleados;
}

function listar_horas_empleados(horas_empleados) {
    const tbody = document.getElementById("tbody");
    let tr_body = "";
    //Iterar sobre empleados
    for (let i = 0; i < horas_empleados.length; i++) {
        const obj = horas_empleados[i];
        tr_body += `
        <tr>
            <td>${obj.tipo_documento} ${obj.identificacion}</td>
            <td>${obj.primer_nombre} ${obj.segundo_nombre} ${obj.primer_apellido} ${obj.segundo_apellido}</td>
            <td>${obj.fecha_registro}</td>
            <td>${obj.horas_trabajadas} Horas </td>
        </tr>
        `
    }
    tbody.innerHTML = tr_body;
}

async function main() {
    const horas_empleados = await get_horas();
    listar_horas_empleados(horas_empleados);
}


main();