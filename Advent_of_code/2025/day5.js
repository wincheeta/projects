import fs from 'fs';

const lines = fs.readFileSync('./day5.txt', 'utf-8').split('\n').filter(line => line.trim()).map(line => line.split("-").map(Number)).sort(function(a, b) {return a[0] - b[0];});

// console.log(lines);
console.log(lines)
let ranges = []
let temp = lines[0];
for (let i = 1; i < lines.length ; i++) {
    if (temp[1] >= lines[i][0]-1) {
        temp[1] = Math.max(temp[1], lines[i][1]);
    } else {
        ranges.push(temp);
        temp = lines[i];
    }

}
ranges.push(temp);

const values = fs.readFileSync('./day5.2.txt', 'utf-8').split('\n').filter(line => line.trim()).map(Number)
let out = 0
for (let i = 0; i < values.length; i++) {
    let val = values[i];
    let found = false;
    for (let j = 0; j < lines.length; j++) {
        if (val >= lines[j][0] && val <= lines[j][1]) {
            found = true;
            break;
        }}
    if (found) {
        out++;
    }
}
console.log(out);


out = 0
for (let i = 0; i < ranges.length; i++) {
    out += (ranges[i][1] - ranges[i][0] + 1);
}
console.log(ranges);
console.log(out);