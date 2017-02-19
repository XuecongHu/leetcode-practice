package twoPointers;

/**
 * Created by 胡学聪 on 2017/2/19.
 */
public class _345ReverseVowelsOfAString {

    private final char[] vowels = {'a', 'A', 'e', 'E', 'o', 'O', 'u', 'U', 'i', 'I'};

    private boolean isVowel(char c) {
        for(int i=0; i<vowels.length; i++){
            if(c == vowels[i])
                return true;
        }
        return false;
    }

    /**
     * 题意：反转字符串中的元音字符顺序
     * 思路：字符串维护头首两个指针分别指着元音字符，交换后选择下一个元音，直到两个指针汇合
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if(s == null || s.isEmpty())
            return s;

        StringBuffer sb = new StringBuffer(s);
        int headVowelIndex = 0, tailVowelIndex = s.length() - 1;

        while(headVowelIndex < tailVowelIndex){
            while(headVowelIndex < tailVowelIndex && !isVowel(sb.charAt(headVowelIndex)))
                headVowelIndex++;

            while(headVowelIndex < tailVowelIndex && !isVowel(sb.charAt(tailVowelIndex)))
                tailVowelIndex--;

            if(headVowelIndex != tailVowelIndex){
                char tmpChar = sb.charAt(headVowelIndex);
                sb.setCharAt(headVowelIndex, sb.charAt(tailVowelIndex));
                sb.setCharAt(tailVowelIndex, tmpChar);

                headVowelIndex++;
                tailVowelIndex--;
            }
        }

        return sb.toString();
    }
}
