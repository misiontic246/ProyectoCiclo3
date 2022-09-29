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
    let text = "";
    if (resp.status == 200) {
        json = await resp.json();
        console.log(json);
        if (json.fecha_salida == null) {
            text = "Turno Abierto: " + Date(json.fecha_entrada);
        } else {
            text = "Turno Cerrado: " + Date(json.fecha_salida);
        }
    } else {
        text = "Identificacion Invalida"
    }
    const myModal = new bootstrap.Modal(document.getElementById("exampleModal"), {})
    element = document.getElementById("exampleModalContent");
    element.innerHTML = text;
    myModal.show();
}

function clear(form) {
    form.identificacion.value = '';
}