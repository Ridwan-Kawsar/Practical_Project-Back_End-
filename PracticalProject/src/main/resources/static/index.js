'use strict';

const output = document.getElementById('output');

document.getElementById('pokedexForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const pokemon = {
        name: form.name.value, // form.name = id from html (line 23)
        type: form.type.value,
        species: form.species.value,
        health: form.health.value,
        attack: form.attack.value,
        defence: form.defence.value
    }

    axios.post("http://localhost:8080/createPokemon", pokemon)
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
    axios.get("http://localhost:8080/getPokemon")
        .then(res => {
            console.log("pokemon: ", res.data);
            output.innerHTML = "";
            for (let pokemon of res.data) {
                const column = document.createElement("div");
                column.className = "col-5";

                const pokemonCard = document.createElement("div");
                pokemonCard.className = "card";
                column.appendChild(pokemonCard);

                const cardBody = document.createElement("div");
                cardBody.className = "card-body";
                pokemonCard.appendChild(cardBody);

                const cardData = document.createElement("div");
                cardData.className = "card-data";
                cardBody.appendChild(cardData);

                const header = document.createElement("h2");
                header.innerText = pokemon.name;
                cardData.appendChild(header);

                const pokemonType = document.createElement("p");
                pokemonType.innerText = "Type: " + pokemon.type;
                cardData.appendChild(pokemonType);

                const pokemonSpecies = document.createElement("p");
                pokemonSpecies.innerText = "Species: " + pokemon.species;
                cardData.appendChild(pokemonSpecies);

                const pokemonHealth = document.createElement("p");
                pokemonHealth.innerText = pokemon.health + " HP";
                cardData.appendChild(pokemonHealth);

                const pokemonAttack = document.createElement("p");
                pokemonAttack.innerText = pokemon.attack + " ATT";
                cardData.appendChild(pokemonAttack);

                const pokemonDefence = document.createElement("p");
                pokemonDefence.innerText = pokemon.defence + " DEF";
                cardData.appendChild(pokemonDefence);

                const updateButton = document.createElement("button");
                updateButton.innerText = "Update";
                updateButton.classList.add("click", "btn-alert");
                updateButton.addEventListener("click", function () {
                    if (confirm('Are you sure you would like to update entry?')){
                        console.log(updatePokemon(pokemon.id))
                    } else {
                        console.log("Update request cancelled");
                    }
                });

                cardBody.appendChild(updateButton);

                const deleteButton = document.createElement("button");
                deleteButton.innerText = "Delete";
                deleteButton.classList.add("click", "btn-danger");
                deleteButton.addEventListener("click", function () {
                    if (confirm('Are you sure you would like to delete entry?')){
                        console.log(deletePokemon(pokemon.id))
                    } else {
                        console.log("Delete request cancelled");
                    }
                });

                cardBody.appendChild(deleteButton);

                output.appendChild(column);
            }
        })
        .catch(err => console.error(err));
}

function deletePokemon(id) {
    axios.delete("http://localhost:8080/removePokemon/" + id)
        .then(res => {
            console.log(res);
            renderPokedex();
        })
        .catch(err => console.error(err));
}

function updatePokemon(id) {
    const updatedName = document.getElementById("name").value
    const updatedSpecies = document.getElementById("species").value
    const updatedType = document.getElementById("type").value
    const updatedHealth = document.getElementById("health").value
    const updatedAttack = document.getElementById("attack").value
    const updatedDefence = document.getElementById("defence").value
    axios.patch(`http://localhost:8080/updatePokemon/${id}?name=${updatedName}&species=${updatedSpecies}&type=${updatedType}&health=${updatedHealth}&attack=${updatedAttack}&defence=${updatedDefence}`)
        .then(res => {
            axios.post("http://localhost:8080/createPokemon", res.data)
                .then(res => {
                    console.log("RESPONSE: ", res);
                    renderPokedex();
                })
                .catch(err => console.error(err));
        })
}

renderPokedex();