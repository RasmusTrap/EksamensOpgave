const requestObject = {
    method: "GET",
    "content-type": "application/json",
    redirect: "follow"
}

function fetchKommune() {
    fetch("http://localhost:8080/alleKommuner", requestObject)
        .then(response => response.json())
        .then(kommune => loadKommune(kommune));
}


fetchKommune();

function loadKommune(kommune) {
    const kommuneDiv = document.getElementById('innerKommune');

    kommune.forEach(kommune => {

        const kommuneElement = document.createElement('div');
        const kommuneNavn = document.createElement('h1');
        const kommuneSmittede = document.createElement('p');
        const kommuneIndbyggere = document.createElement('p');
        const smittetryk = document.createElement('p');

        kommuneNavn.innerText = `Kommune: ${kommune.kommuneNavn}`;
        kommuneSmittede.innerText = `Antal Smittede: ${kommune.smittede}`;
        kommuneIndbyggere.innerText = `Antal Indbyggere: ${kommune.indbyggere}`;
        let smitteUdregning = (kommune.smittede/kommune.indbyggere)*100000;
        smittetryk.innerText = `Smittetryk: ${Math.trunc(smitteUdregning)}`;

        kommuneElement.className = "kommuneElement";

        kommuneElement.append(kommuneNavn);
        kommuneElement.append(kommuneSmittede);
        kommuneElement.append(kommuneIndbyggere);
        kommuneElement.append(smittetryk);

        kommuneDiv.append(kommuneElement);


    })

    }
