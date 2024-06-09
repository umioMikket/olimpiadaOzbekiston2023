package com.umiomikket.testscomplete;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        canBuildDominoBuild(20); // false
        canBuildDominoBuild(28); // true

        rowEquation("cat", "rat");
        rowEquation("abracadabra", "abacadabada");

        introvertKomildshon("#...#");
        introvertKomildshon("##....#....");
        
        kthSubArraySum(2, new int[][] {{1}, {2}, {3}, {1, 2}, {2, 3}, {1, 2, 3}});
        kthSubArraySum(3, new int[][] {{1}, {2}, {3}, {1, 2}, {2, 3}, {1, 2, 3}});
        kthSubArraySum(4, new int[][] {{1}, {2}, {3}, {1, 2}, {2, 3}, {1, 2, 3}});
    }

    // test 1
    public static void canBuildDominoBuild(int count) {
        System.out.println(count >= 28? "Enough" : 28 - count);
    }

    // Test 2
    public static void rowEquation(String a, String b) {
        List<Character> consonants = "qwrtpsdfghjklzxcvbnm".chars().mapToObj(c -> (char) c).toList();
        List<Character> vowels = "aeiouy".chars().mapToObj(c -> (char) c).toList();

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int howMany = 0;

        for (int c = 0; c < a.toCharArray().length; c++) {
            if (aChars[c] == bChars[c]) continue;
            if (consonants.contains(aChars[c]) && consonants.contains(bChars[c])) continue;
            if (vowels.contains(aChars[c]) && vowels.contains(bChars[c])) continue;

            howMany++;
        }

        System.out.println(howMany);
    }
    
    // Test 3
    public static void introvertKomildshon(String computers) {
        char[] chars = computers.toCharArray();

        int charIndex = 0, charSize = 0,
            currentCharIndex = 0, currentCharSize = 0;

        for (int c = 0; c < chars.length; c++) {
            if (chars[c] == '#') {
                if (currentCharSize > charSize) {
                    charSize = currentCharSize;
                    charIndex = currentCharIndex;
                }

                continue;
            }

            currentCharSize++;
            currentCharIndex = c;
        }

        System.out.println(charIndex - (charSize / 2) + 1);
    }

    // Test 4 (idk)

    // Test 5
    public static void kthSubArraySum(int index, int[][] numbers) {
        int summa = 0;
        for (int n: numbers[index - 1]) summa += n;
        System.out.println(summa);
    }
}
