package org.costa;

public class ProblemTwo {
  private static final String INSERT = "INSERT %s";
  private static final String DELETE = "DELETE %s";
  private static final String SWAP = "SWAP %s %s";
  private static final String NOTHING = "NOTHING";
  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  public String solution(String S, String T) {
    if (S == null || T == null) {
      throw new IllegalArgumentException("S and T must not be null");
    }

    if (S.equals(T)) {
      return NOTHING;
    }

    if (Math.abs(S.length() - T.length()) > 1) {
      return IMPOSSIBLE;
    }

    if (S.isEmpty() && T.length() == 1) {
      return String.format(INSERT, T);
    } else if (T.isEmpty() && S.length() == 1) {
      return String.format(DELETE, S);
    }

    if (S.length() == T.length()) {
      return checkForSwap(S, T);
    }

    return S.length() < T.length() ? checkForInsert(S, T) : checkForDelete(S, T);
  }

  private String checkForInsert(String S, String T) {
    char insertChar = getDifferenceChar(S, T);
    return insertChar == '0' ? IMPOSSIBLE : String.format(INSERT, insertChar);
  }

  private String checkForDelete(String S, String T) {
    char insertChar = getDifferenceChar(T, S);
    return insertChar == '0' ? IMPOSSIBLE : String.format(DELETE, insertChar);
  }

  private char getDifferenceChar(String S, String T) {
    char insertChar = ' ';
    char[] shorterChars = S.toCharArray();
    char[] longerChars = T.toCharArray();
    int diffCount = 0;
    int indexShorter = 0;
    for (int i = 0; i < longerChars.length; i++) {
      if (diffCount == 0 && i == longerChars.length - 1) {
        return longerChars[i];
      }
      if (shorterChars[indexShorter] != longerChars[i]) {
        if (diffCount > 0) {
          return '0';
        }
        insertChar = longerChars[i];
        diffCount++;
      } else {
        indexShorter++;
      }
    }
    return insertChar;
  }

  private String checkForSwap(String S, String T) {
    char[] diffChars = new char[4];
    char[] s = S.toCharArray();
    char[] t = T.toCharArray();
    int diffCount = 0;
    int index = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] != t[i]) {
        if (diffCount > 1) {
          return IMPOSSIBLE;
        }
        diffChars[index++] = s[i];
        diffChars[index++] = t[i];
        diffCount++;
      }
    }
    if (diffChars[0] == diffChars[3] && diffChars[1] == diffChars[2]) {
      return String.format(SWAP, diffChars[0], diffChars[1]);
    }
    return IMPOSSIBLE;
  }
}
