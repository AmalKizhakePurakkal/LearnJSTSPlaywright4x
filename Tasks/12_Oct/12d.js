let i = 1; 
let r = i++ > 1 ? i++ : ++i; 
console.log(r, i);

/*
i=1

i=2,3,4,4,5
r=1,3
my calc


but real output in vscode equals r=3 & i=3

*/