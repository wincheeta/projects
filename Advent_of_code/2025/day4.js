const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'day4.txt');

let lines = fs.existsSync(filePath) 
    ? fs.readFileSync(filePath, 'utf8')
        .split(/\r?\n/)
        .map(line => line.split('')) // <--- THIS IS THE KEY FIX
    : []; 
let result = 1;
let total = 0;
while (result > 0){
    result = 0; 
    for (let i = 0; i < lines.length; i++) {
        for (let j = 0; j < lines[i].length; j++) {
            if (lines[i][j] === '.') {
                continue;
            } else {
                let sum = 0;

                for (let a = -1; a < 2; a++) {

                    if (lines[i - 1]?.[j + a] === "@") sum++; // Top row
                    if (lines[i + 1]?.[j + a] === "@") sum++; // Bottom row
                    if (lines[i]?.[j + a] === "@") sum++;     // Current row
                }
                if (sum <= 4) {
                    result++;
                    lines[i][j] = '.';
                }
            }
        }
    }
    console.log(lines);
    total += result;
}
console.log(total); 