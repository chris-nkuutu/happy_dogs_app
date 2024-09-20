// Fetch and display persons from the API
async function getPersons() {
    const response = await fetch("/api/persons", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const persons = await response.json();
        const personsList = document.getElementById("persons");
        personsList.innerHTML = ''; // Clear the current list

        // Loop through each person and create a list item with a delete button
        persons.forEach(person => {
            const listItem = document.createElement("li");
            listItem.textContent = person.name;

            // Create a delete button for each person
            const deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";

            // Add event listener to the delete button
            deleteButton.addEventListener("click", () => deletePerson(person.id));

            // Append the delete button to the list item
            listItem.appendChild(deleteButton);

            // Add the list item to the unordered list
            personsList.appendChild(listItem);
        });
    } else {
        console.error("Failed to fetch persons");
    }
}

// Save a new person
document.getElementById("save-button").addEventListener("click", async () => {
    const inputValue = document.getElementById("name-input").value;
    const personJson = JSON.stringify({ name: inputValue });
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const response = await fetch("/api/persons", {
        method: "POST",
        headers: myHeaders,
        body: personJson
    });

    if (response.ok) {
        // Clear the input field and refresh the list of persons
        document.getElementById("name-input").value = '';
        await getPersons(); // Refresh the list after saving
        console.log("Person saved successfully");
    } else {
        console.error("Failed to save person");
    }
});

// Function to delete a person by ID
async function deletePerson(id) {
    const response = await fetch(`/api/persons/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        console.log(`Person with ID ${id} deleted`);
        await getPersons(); // Refresh the list after deletion
    } else {
        console.error(`Failed to delete person with ID ${id}`);
    }
}

// Initial fetch of persons when the page loads
getPersons();
