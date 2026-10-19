// diff btw do while and while


// while - always checks condition first
let a = 10;
while(a < 10){
    console.log("while loop",a);
    a++;
}
// code doesn't execute


// do - executes atleast once only then checks condition
let b = 10;
do {
    console.log("do-while loop",b);
    b++;
} while(b < 10);
// code executes atleast once
