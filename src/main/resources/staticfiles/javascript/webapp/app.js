// Get references to HTML elements
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');

// Function to add a new task
function addTask() {
  const taskText = taskInput.value.trim();

  if (taskText !== '') {
    const li = document.createElement('li');
    li.innerHTML = `
      <span>${taskText}</span>
      <span class="delete-btn" onclick="removeTask(this)">Delete</span>
    `;
    taskList.appendChild(li);
    taskInput.value = '';
  }
}

// Function to remove a task
function removeTask(element) {
  const li = element.parentElement;
  li.remove();
}
