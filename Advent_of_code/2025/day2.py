def is_invalid_id(num):
    s = str(num)
    total_len = len(s)
    
    # We try all possible "seed" lengths, from 1 up to half the string
    # Example: For "123123", we check len 1 ("1"), then len 2 ("12"), then len 3 ("123")
    for pattern_len in range(1, (total_len // 2) + 1):
        
        # A pattern can only be valid if it divides the total length evenly
        if total_len % pattern_len == 0:
            pattern = s[:pattern_len]
            multiplier = total_len // pattern_len
            
            # Check if reconstructing the string using this pattern matches the original
            if pattern * multiplier == s:
                return True
                
    return False

def solve_part_two():
    try:
        with open("./day2.txt", "r") as f:
            data = f.read().strip().replace('\n', '')
            ranges = data.split(",")
    except FileNotFoundError:
        print("Error: Input file not found.")
        return

    total_sum = 0

    for r in ranges:
        start_s, end_s = r.split("-")
        start = int(start_s)
        end = int(end_s)
        
        # Since the ranges are usually small gaps, we check every number
        for num in range(start, end + 1):
            if is_invalid_id(num):
                total_sum += num

    return total_sum

result = solve_part_two()
print(f"Part 2 - Total Sum of Invalid IDs: {result}")