// Topic: null vs undefined in JavaScript

/*
SIMPLE DEFINITIONS:

undefined  ->  A variable exists, but it has not been assigned any value yet.
                JavaScript itself sets this automatically.

null       ->  A variable exists, but the developer explicitly assigns 
                "no value" or "empty".
                It is intentional absence of any value.
*/

var x;
console.log(x); // undefined

var audi = null;
console.log(audi); //null, since it's explicitly assigned to the identifier "audi"

// --------------------------------------------------------
// 1. undefined
// --------------------------------------------------------

let userName; // declared but not assigned
console.log(userName); // undefined
console.log(typeof userName); // undefined

function greet() {
    // no return statement
}
console.log(greet()); // since there is no return statement, it's considered as undefined.

let a;
a = 10;
console.log(a); // value assigned to a will be displayed

// --------------------------------------------------------
// 2. null
// --------------------------------------------------------
let profilePicture = null;
console.log(profilePicture); // null
console.log(typeof profilePicture); // "object"   <-- known JS quirk!

/*
  | Feature              | undefined                     | null                           |
  |----------------------|-------------------------------|--------------------------------|
  | Meaning              | Not assigned yet              | Intentionally empty            |
  | Who sets it?         | JavaScript automatically      | Developer manually             |
  | Type                 | undefined                     | object (historical bug in JS)  |
  | ==  comparison       | null == undefined  -> true    |                                |
  | === comparison       | null === undefined -> false   |                                |
*/