function combSort(arr: number[]): number[] {
    const shrinkFactor = 1.4;
    let gap = arr.length;
    let swapped = true;

    while (gap > 1 || swapped) {
        // Update the gap value
        gap = Math.floor(gap / shrinkFactor);
        if (gap < 1) {
            gap = 1;
        }

        swapped = false;

        // Compare and swap elements
        for (let i = 0; i + gap < arr.length; i++) {
            if (arr[i] > arr[i + gap]) {
                // Swap elements
                [arr[i], arr[i + gap]] = [arr[i + gap], arr[i]];
                swapped = true;
            }
        }
    }

    return arr;
}

// Example usage:
const arr = [5, 2, 9, 1, 5, 6, 8];
console.log(combSort(arr)); // Output: [1, 2, 5, 5, 6, 8, 9]
