const requestObject = {
    method: "GET",
    "content-type": "application/json",
    redirect: "follow"
}

function fetchSogn() {
    fetch("http://localhost:8080/alleSogne", requestObject)
        .then(response => response.json())
        .then(sogn => loadSogn(sogn));
}


fetchSogn();

function createSogn(){

    let navn = document.getElementById("navn");
    let sognekode = document.getElementById("sognekode");
    let kommune = document.getElementById("kommune");
    let smittetryk = document.getElementById("smittetryk");
    let nedlukning = document.getElementById("nedlukning");

        let checkbox = document.getElementById("checkbox");
        let nedlukningsDato = document.getElementById("nedlukning");

        if (checkbox.checked && nedlukningsDato.value === ""){
            alert("Udfyld venligst en dato for nedlukning af sognet");
        }else{
            if (nedlukningsDato.value === "" && checkbox.checked === false){
                let nySogn = {
                    "navn": `${navn.value}`,
                    "sognekode": `${sognekode.value}`,
                    "kommune": `${kommune.value}`,
                    "smittetryk": `${smittetryk.value}`,
                    "nedlukning": `Sognet er ikke lukket ned`,
                };
                postNySogn(nySogn);
            }else{
                let nySogn = {
                    "navn": `${navn.value}`,
                    "sognekode": `${sognekode.value}`,
                    "kommune": `${kommune.value}`,
                    "smittetryk": `${smittetryk.value}`,
                    "nedlukning": `Sognet lukker den ${nedlukning.value}`,
                };
                postNySogn(nySogn);
            }

            function postNySogn(nySogn){
                let body = JSON.stringify(nySogn);
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
                if (confirm("Nyt sogn er oprettet!")){
                    location.reload()
                }
            }


        }
    }

    function loadSogn(sogn) {
        const sognDiv = document.getElementById('sognID');

        sogn.forEach(sogn => {

            const sognElement = document.createElement('div');
            const sognNavn = document.createElement('h1');
            const sogneKode = document.createElement('p');
            const kommune = document.createElement('p');
            const smittetryk = document.createElement('p');
            const nedlukning = document.createElement('p');
            const opdaterKnap = document.createElement('button');
            const sletKnap = document.createElement('button');


            sognNavn.innerText = sogn.navn;
            sogneKode.innerText = sogn.sognekode;
            kommune.innerText = sogn.kommune;
            smittetryk.innerText = sogn.smittetryk;
            nedlukning.innerText = sogn.nedlukning;


            opdaterKnap.setAttribute("value", sogn.id);
            opdaterKnap.id = sogn.id;
            opdaterKnap.innerHTML = "Opdater Sogn";
            sletKnap.setAttribute("value", sogn.id);
            sletKnap.id = sogn.id;
            sletKnap.innerHTML = "Slet Sogn";


            sognElement.className = "sognElement";
            sletKnap.className = "sletSogn";

            sognElement.append(sognNavn);
            sognElement.append(sogneKode);
            sognElement.append(kommune);
            sognElement.append(smittetryk);
            sognElement.append(nedlukning);
            sognElement.append(sletKnap);
            sognElement.append(opdaterKnap);

            sognDiv.append(sognElement);


            sletKnap.onclick = function () {
                let sognIdSlet = sletKnap.id;

                let sletSogn = {
                    "id": `$sognIdSlet`
                };

                let body = JSON.stringify(sletSogn);
                const URL = `http://localhost:8080//sletSogn/${sognIdSlet}`;

                const requestOptions = {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    method: "DELETE",
                    body: body
                };


                fetch(URL, requestOptions)
                    .then(response => response.json())
                    .then(data => {
                        console.log("success", data)
                    })
                    .catch((error) => {
                        console.log("Error:", error)
                    });
                window.alert("Din sogn bliver slettet nu");
                location.reload();
            }


            opdaterKnap.onclick = function () {

                location.href = '/opdater';
                localStorage.setItem("id", sogn.id);

            }

        })

}
function kommuneKnap(){
    location.href = "/kommune";
}
