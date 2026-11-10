/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let seen = new Map();
    let left = 0;
    let maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        let char = s[right];
        
        // If character is seen and is within the current window
        if (seen.has(char) && seen.get(char) >= left) {
            left = seen.get(char) + 1;
        }
        
        seen.set(char, right);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};