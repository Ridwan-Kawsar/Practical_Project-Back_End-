'use strict';

const output = document.getElementById('output');

document.getElementById('fantasyF1Form').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const f1 = {
        teamPrinciple: form.f1TeamPrinciple.value,
        engineProvider: form.f1EngineProvider.value,
        teamName: form.f1TeamName.value,
        driverOne: form.f1DriverOne.value,
        driverTwo: form.f1DriverTwo.value,
    }

    axios.post("/createFantasyF1", f1)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.fantasyF1TeamPrinciple.focus();
            form.reset();
            renderFantasyF1();
        })
        .catch(err => console.error(err));

    console.log("f1: ", f1);
});

function renderFantasyF1() {
    axios.get("/getFantasyF1")
        .then(res => {
            console.log("f1: ", res.data);
            output.innerHTML = "";
            for (let f1 of res.data) {
                const f1Col = document.createElement("div");
                f1Col.className = "col";

                const f1Card = document.createElement("div");
                f1Card.className = "card";
                f1Col.appendChild(f1Card);

                const f1Div = document.createElement("div");
                f1Div.className = "card-body";
                f1Card.appendChild(f1Div);

                const f1Name = document.createElement("h2");
                f1TeamPrinciple.innerText = f1.teamPrinciple;
                f1Div.appendChild(f1TeamPrinciple);

                const dinoAge = document.createElement("p");
                dinoAge.innerText = dino.age + " years old.";
                dinoDiv.appendChild(dinoAge);

                const dinoSpecies = document.createElement("p");
                dinoSpecies.innerText = dino.species;
                dinoSpecies.classList.add("btn", "btn-alert");
                dinoDiv.appendChild(dinoSpecies);

                const f1Delete = document.createElement("button");
                f1Delete.innerText = "DESTROY";
                f1Delete.addEventListener("click", function () {
                    deleteF1(f1.id);
                });

                f1Div.appendChild(fantasyF1Delete);

                output.appendChild(f1Col);
            }
        })
        .catch(err => console.error(err));
}

function deleteFantasyF1(id) {
    axios.delete("/removeFantasyF1/" + id)
        .then(res => {
            console.log(res);
            renderF1();
        })
        .catch(err => console.error(err));
}


renderDinos();