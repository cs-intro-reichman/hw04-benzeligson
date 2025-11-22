public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i);
            if (ch >= 65 && ch <= 90){
                ch = (char) ((int) ch + 32);
            }
            res = res + ch;
        }
        return res;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0){
            return true;
        }
        char firstLetter = str2.charAt(0);
        // index that will be checked in larger string
        int fromIndex = 0;
        do { 

            int index = str1.indexOf(firstLetter, fromIndex);
            if (index == -1)
            {
                //if the first letter of the contained string 
                //doesn't appear it will not be in the bigger string
                return false;
            }
            if (index + str2.length() <= str1.length()){
                //checks if the first letter of the contained string is 
                //actually the first letter of it inside the bigger string
                if (str2.equals(str1.substring(index, index + str2.length()))){
                    return true;
                }
            }
            //checks from its next appearance in the bigger string 
            fromIndex++;
        }
        while (fromIndex != 0);
        return false;
    }
}
