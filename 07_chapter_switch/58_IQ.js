let status = 0;
console.log(typeof status);
switch (status){
    case false:
        console.log("false matched");
        break;
    case 0:
        console.log("0 matched");
        break;
}

// switch uses strict comparison (===) so answer is 0
