class Solution {
    public String reversePrefix(String word, char ch) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        
        int index2 = index;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i <= index/2; i++) {
            char temp = wordArray[i];
            wordArray[i] = wordArray[index2];
            wordArray[index2--] = temp;
        }

        return new String(wordArray);
    }
}
