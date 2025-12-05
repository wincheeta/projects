import fs from 'fs';

const lines = fs.readFileSync('./day3.txt', 'utf-8').split('\n').filter(line => line.trim());
// console.log(lines);

let length = lines[0].length;
let out = 0;

let out1 = 0;
for (let i = 0; i<lines.length; i++) {
    let bank = ""
    let pos = 0
    let b = [0,-1];
    for (let j = 0; j<12; j++) {
        b = findJoltageFrom(lines[i], b[1]+1, 12 - j);
        // console.log(b, pos);
        // console.log(findJoltageFrom(lines[i], pos+1, 12 - j))

        bank += b[0].toString();
    }
    console.log(bank);
    out += parseInt(bank);
}

function findJoltageFrom(line, start, end) {
    let max= 0
    let pos = 0
    let length = line.length;
    for (let j = start; j<length-end; j++) {
        if (parseInt(line[j]) > max) {
            max = parseInt(line[j]);
            pos = j;
        }}
    return [max , pos];}
let b = findJoltageFrom("818181911112111",0,1)
console.log(b[0], b[1]);

console.log(out);

3121910778619
3121190777719