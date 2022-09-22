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
    clear(from);

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

function clear(form) {
    form.id_cargo_empleado.value = '';
    form.tipo_documento.value = '';
    form.identificacion.value = '';
    form.primer_nombre.value = '';
    form.segundo_nombre.value = '';
    form.primer_apellido.value = '';
    form.segundo_apellido.value = '';
    form.area_empleado.value = '';
    from.estado_empleado.value = '';
}

function set_from(form, empleado) {
    form.id_cargo_empleado.value = empleado.id_cargo_empleado;
    form.tipo_documento.value = empleado.tipo_documento;
    form.identificacion.value = empleado.identificacion;
    form.primer_nombre.value = empleado.primer_nombre;
    form.segundo_nombre.value = empleado.segundo_nombre;
    form.primer_apellido.value = empleado.primer_apellido;
    form.segundo_apellido.value = empleado.segundo_apellido;
    form.area_empleado.value = empleado.area_empleado;
    from.estado_empleado.value = empleado.estado_empleado;
}

function get_params() {
    const search = window.location.search;
    const url = new URLSearchParams(search);
    const param_empleado = url.get("empleado");
    if (param_empleado) {
        const empleado = JSON.parse(param_empleado);
        const form = document.getElementById("from");
        set_from(from, empleado);
    }

    console.log(empleado);
}

get_params();