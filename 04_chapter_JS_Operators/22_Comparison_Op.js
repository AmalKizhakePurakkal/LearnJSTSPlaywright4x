// ==   -> loose comparison - checks either datatype or value
// ===  -> strict comparison - checks both datatype and value

console.log(5 == "5"); // loose comparison - value
console.log(5 === "5"); // strict comparison - value & datatype

// ! -> not char
console.log(5 != "5"); // loose comparison
console.log(5 !== "5"); // strict comparison
// here "!==" actual means !=== like strict comparison

console.log(5 === 5); // true