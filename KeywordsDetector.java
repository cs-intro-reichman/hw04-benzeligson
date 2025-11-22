
import com.sun.source.tree.IfTree;

public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String sentenceLowerCased = sentences[i];
            sentenceLowerCased = lowerCase(sentenceLowerCased);
            for (int j = 0; j < keywords.length; j++) {
                String keywordLowerCased = keywords[j];
                keywordLowerCased = lowerCase(keywordLowerCased);
                if (contains(sentenceLowerCased,keywordLowerCased)){
                    System.out.println(sentences[i]);
                    break;
                }
            }
            
        }
    }

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
}
