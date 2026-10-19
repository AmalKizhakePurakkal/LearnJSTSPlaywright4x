const input = require('fs').readFileSync(0, 'utf8').trim().split(/\s+/);

if (input.length !== 3 || input.some(value => value === '')){
    console.log("Invalid input: Enter exactly three values.");
} else {
    const [a, b, c] = input.map(Number);
    if((a<=0 || b<=0 || c<=0) || a+b<=c || b+c<=a || c+a<=b){
        console.log("Invalid input")
    } else {
        if(a===b && b===c){
            console.log("Equilateral")
        } else if (a===b || b===c || c===a){
            console.log("Isosceles")
        } else{
            console.log("Scalene")
        }
    }
}


// require('fs').readFileSync(0, 'utf8') --> reads input as string
// trim() --> remove surrounding whitespace
// split(/\s+/) --> Splits string at one or more whitespace characters. The string is split at each space, creating an array containing three words.
// map(Number) --> converts each string into a number
