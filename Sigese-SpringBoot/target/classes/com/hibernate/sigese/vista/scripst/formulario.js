const URL_API = "http://localhost:8080/empleados";

function get_data_from(event) {
    //Indicar que no recargue pagina
    event.preventDefault();
    const form = event.target;
    const empleado = {
        id_cargo_empleado: form.id_cargo_empleado.value,
        tipo_documento: form.tipo_documento.value,
        identificacion: form.identificacion.value,
        primer_nombre: form.primer_nombre.value,
        segundo_nombre: form.segundo_nombre.value,
        primer_apellido: form.primer_apellido.value,
        segundo_apellido: form.segundo_apellido.value,
        area_empleado: form.area_empleado.value,
        estado_empleado: from.estado_empleado.value
    }
    create(empleado);

}

async function create(empleado) {
    //Enviar peticion
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(empleado)
    });

    const text = await resp.text();
    alert(text);
}