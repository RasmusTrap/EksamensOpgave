
let sognId = localStorage.getItem("id");

const requestObject = {
    method : "GET",
    "content-type" : "application/json",
    redirect : "follow"
}

function fetchSogn() {
    fetch(`http://localhost:8080/enkeltSogn/${sognId}`, requestObject)
        .then(response => response.json())
        .then(sogn => opdaterSogn(sogn));
}

fetchSogn();

function opdaterSogn(sogn) {

    document.getElementById("navn").value = sogn.navn;
    document.getElementById("sognekode").value = sogn.sognekode;
    document.getElementById("kommune").value = sogn.kommune;
    document.getElementById("smittetryk").value = sogn.smittetryk;

}

function opdater(){

    let checkbox = document.getElementById("checkbox");
    let nedlukningsDato = document.getElementById("nedlukning");

    if (checkbox.checked === true && nedlukningsDato.value === "") {
        alert("Udfyld venligst en dato for nedlukning af sognet");
    } else {
        if (nedlukningsDato.value === "" && checkbox.checked === false) {
            console.log("peng");
            let opdaterSogn = {
                "id": `${sognId}`,
                "navn": `${document.getElementById("navn").value}`,
                "sognekode": `${document.getElementById("sognekode").value}`,
                "kommune": `${document.getElementById("kommune").value}`,
                "smittetryk": `${document.getElementById("smittetryk").value}`,
                "nedlukning": `Sognet er ikke lukket ned`
            };
            opdaterPost(opdaterSogn);
        } else {
            console.log("hvad");
            let opdaterSogn = {
                "id": `${sognId}`,
                "navn": `${document.getElementById("navn").value}`,
                "sognekode": `${document.getElementById("sognekode").value}`,
                "kommune": `${document.getElementById("kommune").value}`,
                "smittetryk": `${document.getElementById("smittetryk").value}`,
                "nedlukning": `Sognet lukker den ${document.getElementById("nedlukning").value}`,
            };
            opdaterPost(opdaterSogn);
        }
    }

function opdaterPost(opdaterSogn) {
    let body = JSON.stringify(opdaterSogn);
    const URL = "http://localhost:8080/opretSogn";

    const postObject = {
        headers: {
            'Content-Type': 'application/json',
        },
        method: "POST",
        body: body,
        credentials: "include"
    };

    fetch(URL, postObject)
        .then(response => response.json())
        .then(data => {
            console.log("Succes", data)
        }).catch((error) => {
        console.log("error", error)
    });
    if (confirm("sogn er opdateret!")){
        location.href = '/';
    }
}
}