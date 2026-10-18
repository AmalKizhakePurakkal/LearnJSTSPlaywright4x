let score = Number(require('fs').readFileSync(0,'utf8').trim())
if (score > 100 || score < 0) {
    console.log("Invalid score");
} else {
    if (score >= 90) {
        console.log("A");
    }
    else if (score >= 80 && score < 90) {
        console.log("B");
    }
    else if (score >= 70 && score < 80) {
        console.log("C");
    }
    else if (score >= 60 && score < 70) {
        console.log("Grade D - Average");
    }
    else if (score < 60) {
        console.log("F");
    }
}