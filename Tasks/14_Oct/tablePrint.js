// const num = Number(require('fs').readFileSync(0, 'utf8'));
// for (let i = 1; i <= 10; i++){
//     console.log(`${ num } x ${ i } = ${ num*i}`);
// }
//prints in multiple lines



const num = Number(require('fs').readFileSync(0, 'utf8'));
for (let i = 1; i <= 10; i++) {
    process.stdout.write(`${num} x ${i} = ${num * i}` + ' ');
}
// prints in single line - but sdet platform not accepting, don't know why



// const num = Number(require('fs').readFileSync(0, 'utf8').trim());
// let result = [];
// for (let i = 1; i <= 10; i++) {
//     result.push(`${num} x ${i} = ${num * i}`);
// }
// console.log(result.join(" "));
//also prints in single line - - but sdet platform not accepting, don't know why
