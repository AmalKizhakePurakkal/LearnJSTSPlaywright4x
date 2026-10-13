let env = "staging";
let baseUrl = env === "prod"
    ? "https://api.example.com"
    : "https://staging-api.example.com";
console.log(baseUrl);

// here condition is false