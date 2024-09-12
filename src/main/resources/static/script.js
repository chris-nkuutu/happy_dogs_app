async function getPersons(){

   const response = await fetch("/api/persons");

   const persons = await response.json();

   console.log(persons);

   const personsUl = document.getElementById("persons");

   for (const person of persons){
       personsUl.innerHTML += `<li>${person.name} </li>`;

   }

}
getPersons();

document.getElementById("save-button").addEventListener("click", async () => {
    const inputValue = document.getElementById("name-input").value;
    const personJson = JSON.stringify({name: inputValue})
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    await fetch("/api/persons",{
        method: "POST",
        headers: myHeaders,
        body: personJson
    });

    if (response.ok) {
        // Clear input and refresh persons
        document.getElementById("name-input").value = '';
        await getPersons(); // Ensure getPersons is awaited if it's async
        console.log("Person saved successfully");
    } else {
        console.error("Failed to save person");
    }
});