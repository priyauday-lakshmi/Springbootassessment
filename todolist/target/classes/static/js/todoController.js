const displayTodoAPI = `http://localhost:8080/todo/all`;
const addTodoAPI = `http://localhost:8080/todo/add`;

let todoControllerList = [];


const renderTodoHTML = ()=>{

    let todoDisplay = `
                   <tr style="background-color: aquamarine;">
                        <th>Title</th>
                        <th>Description</th>

                    </tr>`;


    for(let i =0; i < todoControllerList.length;i++){
        todoDisplay += `
                            <tr>
                                <td>${todoControllerList[i].title}</td>
                                <td>${todoControllerList[i].description}</td>
                            </tr>`;
    }
    console.log(todoDisplay);
    document.querySelector("#table>table").innerHTML = todoDisplay;
}


const displayTodo= ()=>{
    todoControllerList = [];
    fetch(displayTodoAPI)
        .then((resp)=>resp.json())
        .then((data)=>{

            console.log("RecieveData");
            console.log(data);

            data.forEach((todo,index)=>{
                const todoObj = {
                    id: todo.id,
                    title: todo.title,
                    description: todo.description
                }
                todoControllerList.push(todoObj);
            })
            renderTodoHTML();
        })

}


const addTodo = (title, description)=>{

   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);


    fetch(addTodoAPI, {
        method :'POST',
        body : formData
    })
    .then((response)=>{
            console.log(response.status); // Will show you the status - 200 ok, 500, 404
            if (response.ok) {
                alert("Successfully Added Customer!")
                displayTodo();
            }
            else {
               alert("Something went wrong. Please try again")
            }
    })
    .catch((error)=>{

        console.log("error : " + error);
        alert("Error adding to the database");

    })

}




newTodoForm.addEventListener('submit', (event)=>{

    event.preventDefault();

    const title = document.querySelector("#newname").value;
    const description = document.querySelector("newdescription").value;


    addTodo(title,description);
});
