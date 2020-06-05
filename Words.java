import java.util.ArrayList;
import java.util.List;

public class Words {
    static int amountOfVowelLetters;
    static int maxAmountOfVowelLetters = 1;
    static int amountOfUniqueSymbols;
    static int maxAmountOfUniqueSymbols = 1;
    static int minLengthOfWord = 20;
    static String wordWithMinLength = "";
    static String wordWithMaxAmountOfVowelLetters = "";
    static String wordWithMaxAmountOfUniqueSymbols = "";
    static List<String> list = new ArrayList<>();

    static void findWords(String str) {

        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            char[] wordsFromAlice = strings[i].toLowerCase().toCharArray();

            amountOfVowelLetters = 0;
            for (int j = 0; j < wordsFromAlice.length; j++) {
                switch (wordsFromAlice[j]) {
                    case 'а':
                    case 'е':
                    case 'ё':
                    case 'и':
                    case 'о':
                    case 'у':
                    case 'ы':
                    case 'э':
                    case 'ю':
                    case 'я':
                        amountOfVowelLetters++;
                        break;
                }
            }

            if (amountOfVowelLetters > maxAmountOfVowelLetters) {
                maxAmountOfVowelLetters = amountOfVowelLetters;
                wordWithMaxAmountOfVowelLetters = String.valueOf(wordsFromAlice);
            }

            amountOfUniqueSymbols = wordsFromAlice.length;
            for (int j = 0; j < wordsFromAlice.length; j++) {
                for (int k = j + 1; k < wordsFromAlice.length - 1; k++) {
                    if (wordsFromAlice[j] == wordsFromAlice[k]) {
                        amountOfUniqueSymbols--;
                    }
                }
            }

            if (amountOfUniqueSymbols > maxAmountOfUniqueSymbols) {
                maxAmountOfUniqueSymbols = amountOfUniqueSymbols;
                wordWithMaxAmountOfUniqueSymbols = String.valueOf(wordsFromAlice);
            }

            if (wordsFromAlice.length < minLengthOfWord) {
                minLengthOfWord = wordsFromAlice.length;
                wordWithMinLength = String.valueOf(wordsFromAlice);
            }
        }

        list.add(wordWithMaxAmountOfVowelLetters);
        list.add(wordWithMaxAmountOfUniqueSymbols);
        list.add(wordWithMinLength);
        System.out.println(list);
    }
}
