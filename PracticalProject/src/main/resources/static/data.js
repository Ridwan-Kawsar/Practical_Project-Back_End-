'use strict';
document.getElementById('pokemonForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const pokemon = {
        name: form.name.value,
        pokemonType: form.pokemonType.value,
        pokemonSpecies: form.pokemonSpecies.value,
        pokemonHealth: form.pokemonHealth.value,
        pokemonAttack: form.pokemonAttack.value,
        pokemonDefence: form.pokemonDefence.value
    }

    axios.post("http://localhost:8080/createPokemon", pokemon)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.name.focus();
            form.reset();
            console.log("success");
            renderPokemons();
        })
        .catch(err => console.error(err));

    console.log("pokemon: ", pokemon);
});

document.getElementById('pokemonsSearch').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    axios.get(`http://localhost:8080/getPokemonByName/${form.searchName.value}`)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.searchName.focus();
            form.reset();
            console.log("success");
            var existingSearchDiv = document.getElementById('searchPokemonsDiv');
            if (existingSearchDiv != null) {
                existingSearchDiv.remove();
            }
            for (let pokemon of res.data) {
                const pokemonCol = document.createElement("div");
                pokemonCol.id = "searchPokemonsDiv";
                pokemonCol.className = "col-12";

                const pokemonCard = document.createElement("div");
                pokemonCard.className = "card";
                pokemonCard.style.textAlign="center";
                pokemonCol.appendChild(pokemonCard);

                const pokemonDiv = document.createElement("div");
                pokemonDiv.className = "card-body";
                pokemonCard.appendChild(pokemonDiv);

                const pokemonName = document.createElement("h2");
                pokemonName.innerText = pokemon.name;
                pokemonDiv.appendChild(pokemonName);

                const pokemonType = document.createElement("p");
                pokemonType.innerText = pokemon.type;
                pokemonDiv.appendChild(pokemonType);

                const pokemonSpecies = document.createElement("p");
                pokemonSpecies.innerText = pokemon.species;
                pokemonDiv.appendChild(pokemonSpecies);

                const pokemonHealth = document.createElement("p");
                pokemonHealth.innerText = pokemon.health;
                pokemonDiv.appendChild(pokemonHealth);

                const pokemonAttack = document.createElement("p");
                pokemonAttack.innerText = pokemon.attack;
                pokemonDiv.appendChild(pokemonAttack);

                const pokemonDefence = document.createElement("p");
                pokemonDefence.innerText = pokemon.defence;
                pokemonDiv.appendChild(pokemonDefence);

                output.prepend(pokemonCol);
            }
        })
        .catch(err => console.error(err));

    
});

const output = document.getElementById('output');

function renderPokemons() {
    axios.get("http://localhost:8080/getPokemons")
        .then(res => {
            console.log("pokemons: ", res.data);
            output.innerHTML = "";
            for (let pokemon of res.data) {
                const pokemonCol = document.createElement("div");
                pokemonCol.className = "col-4";

                const pokemonCard = document.createElement("div");
                pokemonCard.className = "card";
                pokemonCard.style.textAlign="center";
                pokemonCol.appendChild(pokemonCard);

                const pokemonDiv = document.createElement("div");
                pokemonDiv.className = "card-body";
                pokemonCard.appendChild(pokemonDiv);

                const pokemonName = document.createElement("h2");
                pokemonName.innerText = pokemon.name;
                pokemonDiv.appendChild(pokemonName);

                const pokemonType = document.createElement("p");
                pokemonType.innerText = pokemon.type;
                pokemonDiv.appendChild(pokemonType);

                const pokemonSpecies = document.createElement("p");
                pokemonSpecies.innerText = pokemon.species;
                pokemonDiv.appendChild(pokemonSpecies);

                const pokemonHealth = document.createElement("p");
                pokemonHealth.innerText = pokemon.health;
                pokemonDiv.appendChild(pokemonHealth);

                const pokemonAttack = document.createElement("p");
                pokemonAttack.innerText = pokemon.attack;
                pokemonDiv.appendChild(pokemonAttack);

                const pokemonDefence = document.createElement("p");
                pokemonDefence.innerText = pokemon.defence;
                pokemonDiv.appendChild(pokemonDefence);

                const pokemonUpdate = document.createElement('button');
                pokemonUpdate.innerText = "Update";
                pokemonUpdate.classList.add("btn", "btn-secondary", "m-2");
                pokemonUpdate.addEventListener("click", () => {
                    if (confirm('Are you sure?')) {
                            console.log(updatepokemon(pokemon.id));
                    } else {
                    console.log("You pressed cancel");
                    }
                });
                

                pokemonDiv.appendChild(pokemonUpdate);

                output.appendChild(pokemonCol);

                const pokemonDelete = document.createElement("button");
                pokemonDelete.innerText = "Delete";
                pokemonDelete.classList.add("btn", "btn-danger");
                pokemonDelete.addEventListener("click", () => {

                    if (confirm('Are you sure?')) {
                            console.log(deletepokemon(pokemon.id));
                    } else {
                    console.log("You pressed cancel");
                    }
                });

                pokemonDiv.appendChild(pokemonDelete);

                output.appendChild(pokemonCol);
            }
        })
        .catch(err => console.error(err));
}

function updatePokemon(id) {
    const updateName = document.getElementById("name").value
    const updateType = document.getElementById("type").value
    const updateSpecies = document.getElementById("species").value
    const updateHealth = document.getElementById("health").value
    const updateAttack = document.getElementById("attack").value
    const updateDefence = document.getElementById("defence").value
    
    axios.patch(`http://localhost:8080/updatePokemon/${id}?name=${updateName}&type=${updateType}&species=${updateSpecies}&health=${updateHealth}&attack=${updateAttack}&defence=${updateDefence}`)
    
            .then(res => {
                console.log("RESPONSE: ", res);
                renderPokemons();
            }).catch(err => console.error(err));
        }

function deletePokemon(id) {
    axios.delete("http://localhost:8080/removePokemon/" + id)
        .then(res => {
            console.log(res);
            renderPokemons();
        })
        .catch(err => console.error(err));
}


renderPokemons();

//=================================================================================================================================================================================


// 'use strict';

// const output = document.getElementById('output');

// document.getElementById('pokedexForm').addEventListener("submit", function (event) {
//     event.preventDefault();

//     const form = event.target;

//     const pokemon = {
//         name: form.name.value, // form.name = id from html (line 23)
//         type: form.type.value,
//         species: form.species.value,
//         health: form.health.value,
//         attack: form.attack.value,
//         defence: form.defence.value
//     }

//     axios.post("http://localhost:8080/createPokemon", pokemon)
//         .then(res => {
//             console.log("RESPONSE: ", res);
//             form.name.focus();
//             form.reset();
//             renderPokedex();
//         })
//         .catch(err => console.error(err));

//     console.log("pokemon: ", pokemon);
// });

// document.getElementById('pokedexForm').addEventListener("submit", function (event) {
//     event.preventDefault();

//     const form = event.target;

//     axios.get(`http://localhost:8080/getPokemonByName/${form.searchPokemonName.value}`)
//         .then(res => {
//             console.log("RESPONSE: ", res);
//             form.searchPokemonName.focus();
//             form.reset();
//             console.log("success");
//             var existingSearchDiv = document.getElementById('searchPokemonDiv');
//             if (existingSearchDiv != null) {
//                 existingSearchDiv.remove();
//             }
//            for (let pokemon of res.data) {
//                 const column = document.createElement("div");
//                 column.className = "col-3";

//                 const pokemonCard = document.createElement("div");
//                 pokemonCard.className = "card";
//                 column.appendChild(pokemonCard);

//                 const cardBody = document.createElement("div");
//                 cardBody.className = "card-body";
//                 pokemonCard.appendChild(cardBody);

//                 const header = document.createElement("h2");
//                 header.innerText = pokemon.name;
//                 cardBody.appendChild(header);

//                 const pokemonType = document.createElement("p");
//                 pokemonType.innerText = "Type: " + pokemon.type;
//                 cardBody.appendChild(pokemonType);

//                 const pokemonSpecies = document.createElement("p");
//                 pokemonSpecies.innerText = "Species: " + pokemon.species;
//                 cardBody.appendChild(pokemonSpecies);

//                 const pokemonHealth = document.createElement("p");
//                 pokemonHealth.innerText = pokemon.health + " HP";
//                 cardBody.appendChild(pokemonHealth);

//                 const pokemonAttack = document.createElement("p");
//                 pokemonAttack.innerText = pokemon.attack + " ATT";
//                 cardBody.appendChild(pokemonAttack);

//                 const pokemonDefence = document.createElement("p");
//                 pokemonDefence.innerText = pokemon.defence + " DEF";
//                 cardBody.appendChild(pokemonDefence);

//                 output.prepend(column);
//             }
//         })
//         .catch(err => console.error(err));

    
// });

// const output = document.getElementById('output');

// function renderPokedex() {
//     axios.get("http://localhost:8080/getPokemon")
//         .then(res => {
//             console.log("pokemon: ", res.data);
//             output.innerHTML = "";
//             for (let pokemon of res.data) {
//                 const column = document.createElement("div");
//                 column.className = "col-3";

//                 const pokemonCard = document.createElement("div");
//                 pokemonCard.className = "card";
//                 column.appendChild(pokemonCard);

//                 const cardBody = document.createElement("div");
//                 cardBody.className = "card-body";
//                 pokemonCard.appendChild(cardBody);

//                 const header = document.createElement("h2");
//                 header.innerText = pokemon.name;
//                 cardBody.appendChild(header);

//                 const pokemonType = document.createElement("p");
//                 pokemonType.innerText = "Type: " + pokemon.type;
//                 cardBody.appendChild(pokemonType);

//                 const pokemonSpecies = document.createElement("p");
//                 pokemonSpecies.innerText = "Species: " + pokemon.species;
//                 cardBody.appendChild(pokemonSpecies);

//                 const pokemonHealth = document.createElement("p");
//                 pokemonHealth.innerText = pokemon.health + " HP";
//                 cardBody.appendChild(pokemonHealth);

//                 const pokemonAttack = document.createElement("p");
//                 pokemonAttack.innerText = pokemon.attack + " ATT";
//                 cardBody.appendChild(pokemonAttack);

//                 const pokemonDefence = document.createElement("p");
//                 pokemonDefence.innerText = pokemon.defence + " DEF";
//                 cardBody.appendChild(pokemonDefence);

//                 const updateButton = document.createElement("button");
//                 updateButton.innerText = "Update";
//                 updateButton.classList.add("click", "btn-alert");
//                 updateButton.addEventListener("click", function () {
//                     if (confirm('Are you sure you would like to update entry?')){
//                         console.log(updatePokemon(pokemon.id))
//                     } else {
//                         console.log("Update request cancelled");
//                     }
//                 });

//                 cardBody.appendChild(updateButton);

//                 const deleteButton = document.createElement("button");
//                 deleteButton.innerText = "Delete";
//                 deleteButton.classList.add("click", "btn-danger");
//                 deleteButton.addEventListener("click", function () {
//                     if (confirm('Are you sure you would like to delete entry?')){
//                         console.log(deletePokemon(pokemon.id))
//                     } else {
//                         console.log("Delete request cancelled");
//                     }
//                 });

//                 cardBody.appendChild(deleteButton);

//                 output.appendChild(column);
//             }
//         })
//         .catch(err => console.error(err));
// }

// function deletePokemon(id) {
//     axios.delete("http://localhost:8080/removePokemon/" + id)
//         .then(res => {
//             console.log(res);
//             renderPokedex();
//         })
//         .catch(err => console.error(err));
// }

// function updatePokemon(id) {
//     const updatedName = document.getElementById("name").value
//     const updatedSpecies = document.getElementById("species").value
//     const updatedType = document.getElementById("type").value
//     const updatedHealth = document.getElementById("health").value
//     const updatedAttack = document.getElementById("attack").value
//     const updatedDefence = document.getElementById("defence").value
//     axios.patch(`http://localhost:8080/updatePokemon/${id}?name=${updatedName}&species=${updatedSpecies}&type=${updatedType}&health=${updatedHealth}&attack=${updatedAttack}&defence=${updatedDefence}`)
//                 .then(res => {
//                     console.log("RESPONSE: ", res);
//                     renderPokedex();
//                 })
//                 .catch(err => console.error(err));
//         }
// renderPokedex();