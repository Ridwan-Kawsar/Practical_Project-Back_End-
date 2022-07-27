'use strict';

document.getElementById('PokemonSearch').addEventListener("submit", function (event) {
    event.preventDefault();
    
    const form = event.target;
    
    axios.get(`http://localhost:8080/getPokemonByName/${form.searchPokemonName.value}`)
    .then(res => {
    console.log("RESPONSE: ", res);
    form.searchPokemonName.focus();
    form.reset();
    console.log("success");
    var existingSearchDiv = document.getElementById('PokemonSearch');
    if (existingSearchDiv != null) {
    existingSearchDiv.remove();
    }
    
    for (let [pokemon] of res.data) {
    const column = document.createElement("div");
    column.id = "PokemonSearch";
    column.className = "col-10";

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

                output.appendChild(column);
            }
        })
        .catch(err => console.error(err));
})