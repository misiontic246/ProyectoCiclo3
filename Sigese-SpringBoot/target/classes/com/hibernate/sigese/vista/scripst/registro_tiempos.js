const URL_API = "http://localhost:8080/tiempos";

function get_data_from(event) {;
    //Indicar que no recargue pagina
    event.preventDefault();
    const form = event.target;
    const tiempo = {
        identificacion: form.identificacion.value,
    }
    create_tiempo(tiempo);
    clear(form);
}

async function create_tiempo(tiempo) {
    //Enviar peticion
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(tiempo)
    });

    const text = await resp.text();
    alert(text);
}

function clear(form) {
    form.identificacion.value = '';

}