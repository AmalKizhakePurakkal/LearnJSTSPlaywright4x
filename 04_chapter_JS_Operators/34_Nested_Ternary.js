// Nested Ternary
// Has multiple conditions
// age = 26;
// age > 18 -> Go Goa, age > 25 -> Drink

let age = 26;

let is_Amal_enjoy = (age > 18) ? (age > 25 ? "Goa and Drink" : "No Drink, Only Goa") : "No Goa";
console.log(`Amal can enjoy ${is_Amal_enjoy}`);
