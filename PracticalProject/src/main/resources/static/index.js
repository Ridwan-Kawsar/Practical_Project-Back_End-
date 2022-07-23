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

    axios.post("http://localhost:8080/createPokedex", pokemon)
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
    axios.get("http://localhost:8080/getPokedex")
        .then(res => {
            console.log("pokemon: ", res.data);
            output.innerHTML = "";
            for (let pokemon of res.data) {
                const column = document.createElement("div");
                column.className = "col-3";

                const pokemonCard = document.createElement("div");
                pokemonCard.className = "card";
                column.appendChild(pokemonCard);

                const cardBody = document.createElement("div");
                cardBody.className = "card-body";
                pokemonCard.appendChild(cardBody);

                const header = document.createElement("h2");
                header.innerText = pokemon.name;
                cardBody.appendChild(header);

                const pokemonType = document.createElement("p");
                pokemonType.innerText = pokemon.type;
                cardBody.appendChild(pokemonType);

                const pokemonSpecies = document.createElement("p");
                pokemonSpecies.innerText = pokemon.species;
                cardBody.appendChild(pokemonSpecies);

                const pokemonHeight = document.createElement("p");
                pokemonHeight.innerText = pokemon.height + " m";
                cardBody.appendChild(pokemonHeight);

                const pokemonWeight = document.createElement("p");
                pokemonWeight.innerText = pokemon.weight + " kg";
                cardBody.appendChild(pokemonWeight);

                const updateButton = document.createElement("button");
                updateButton.innerText = "Update";
                updateButton.classList.add("click", "btn-alert");
                updateButton.addEventListener("click", function () {
                    alert("Confirm update entry?")
                    updatePokemon(pokemon.id);
                });

                cardBody.appendChild(updateButton);

                const deleteButton = document.createElement("button");
                deleteButton.innerText = "Delete";
                deleteButton.classList.add("click", "btn-danger");
                deleteButton.addEventListener("click", function () {
                    alert("Confirm delete entry?")
                    deletePokemon(pokemon.id);
                });

                cardBody.appendChild(deleteButton);

                output.appendChild(column);
            }
        })
        .catch(err => console.error(err));
}

function deletePokemon(id) {
    axios.delete("http://localhost:8080/removePokedex/" + id)
        .then(res => {
            console.log(res);
            renderPokedex();
        })
        .catch(err => console.error(err));
}

function updatePokemon(id) {
    axios.delete("http://localhost:8080/updatePokedex/" + id)
        .then(res => {
            console.log(res);
            renderPokedex();
        })
        .catch(err => console.error(err));
}

renderPokedex();