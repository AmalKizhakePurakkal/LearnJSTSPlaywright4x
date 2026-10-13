let a = 10;
console.log(++a + a + a++);
console.log(a);

// ++a  -> value will be 11
// a    -> value will be 11
// a++  -> value will be 11
//      -> Also rewrites the value of "a" from 11 to 12
