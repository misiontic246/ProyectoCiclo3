//const URL_API = "http://localhost:8080/horas";
const URL_API = "http://localhost:8080/horas/range?";



async function get_horas(fecha_1 = null, fecha_2 = null) {
    url = URL_API;
    if (fecha_1 != null && fecha_2 != null) {
        param = new URLSearchParams({ fecha_1: fecha_1, fecha_2: fecha_2 })
        url = url + param;

    }
    console.log(url);
    //Enviar petición
    const resp = await fetch(url);
    //Obtener datos de la peticion
    const horas_empleados = await resp.json();
    return horas_empleados;
}

function listar_horas_empleados(horas_empleados) {
    let tbody = document.getElementById("tbody");
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
    console.log(tr_body);
    tbody.innerHTML = tr_body;
}

async function main() {

    const horas_empleados = await get_horas();
    listar_horas_empleados(horas_empleados);
}

async function filtro_fechas_empleados(event) {
    event.preventDefault();
    const form = event.target;
    const horas_empleados = await get_horas(form.fecha_1.value, from.fecha_2.value);
    listar_horas_empleados(horas_empleados);

}

main();