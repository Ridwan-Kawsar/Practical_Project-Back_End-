'use strict';

const output = document.getElementById('output');

document.getElementById('pokedexForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const pokemon = {
        name: form.name.value, // form.name = id from html (line 23)
        type: form.type.value,
        species: form.species.value,
        height: form.height.value,
        weight: form.weight.value,
    }

    axios.post("/createPokedex", pokemon)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.name.focus();
            form.reset();
            renderPokedex();
        })
        .catch(err => console.error(err));

    console.log("pokemon: ", pokemon);
});

function renderPokedex() {
    axios.get("/getPokedex")
        .then(res => {
            console.log("pokemon: ", res.data);
            output.innerHTML = "";
            for (let pokemon of res.data) {
                const column = document.createElement("div");
                column.className = "col";

                const pokemonCard = document.createElement("div");
                pokemonCard.className = "card";
                column.appendChild(pokemonCard);

                const cardBody = document.createElement("div");
                cardBody.className = "card-body";
                pokemonCard.appendChild(cardBody);

                const header = document.createElement("h2");
                pokemonName.innerText = pokemon.name;
                cardBody.appendChild(header);

                const pokemonAttributes = document.createElement("p");
                pokemonAttributes.innerText = pokemon.height + " m";
                cardBody.appendChild(pokemonAttributes);

                const updateButton = document.createElement("p");
                updateButton.innerText = "update";
                updateButton.classList.add("btn", "btn-alert");
                cardBody.appendChild(updateButton);

                const deleteButton = document.createElement("button");
                deleteButton.innerText = "Delete";
                deleteButton.addEventListener("click", function () {
                    deletePokemon(pokemon.id);
                });

                cardBody.appendChild(deleteButton);

                output.appendChild(column);
            }
        })
        .catch(err => console.error(err));
}

function deletePokemon(id) {
    axios.delete("/removePokedex/" + id)
        .then(res => {
            console.log(res);
            renderPokedex();
        })
        .catch(err => console.error(err));
}

renderPokedex();