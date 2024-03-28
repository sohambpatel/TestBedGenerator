// Code smell: Inconsistent naming conventions
const myNumber = 42;
const MyString = "Hello, World!";

// Code smell: Mixing synchronous and asynchronous code
function fetchData(url) {
  let data;
  fetch(url)
    .then(response => response.json())
    .then(result => {
      data = result;
    });
  return data; // This won't work as expected due to the asynchronous nature of fetch
}

// Code smell: Unhandled promise rejection
async function getUserInfo(userId) {
  const response = await fetch(`/api/users/${userId}`);
  const user = await response.json();
  return user;
}

// Code smell: Too many parameters
function calculateTotal(price, quantity, discount, taxRate, shippingCost) {
  // ... calculation logic ...
}

// Code smell: Repeated code
function processItem(item) {
  console.log("Processing item: " + item);
}

function processItemList(items) {
  for (const item of items) {
    processItem(item);
  }
}

// Code smell: Lack of proper error handling
function divide(a, b) {
  return a / b;
}

// Code smell: Inefficient loop
function sumArrayElements(arr) {
  let total = 0;
  for (let i = 0; i < arr.length; i++) {
    total = total + arr[i];
  }
  return total;
}

// Code smell: Unused variable
function doSomething() {
  const unusedVar = "I'm unused";
  console.log("Doing something...");
}

// Code smell: Magic numbers
function calculateArea(radius) {
  return 3.14 * radius * radius; // Use a constant for the magic number
}

// Code smell: Improper handling of truthy/falsy values
function checkValue(value) {
  if (value == true) {
    console.log("Value is true");
  } else {
    console.log("Value is false");
  }
}

// Code smell: Lack of comments and documentation
function complexFunction(a, b, c) {
  // ... complex logic without any explanation ...
  return result;
}
