package org.costa;

public class ProblemThree {
  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    if (A.length == 1) {
      return 1;
    }
    int countPos = isPositive(A[0]) ? 1 : 0;
    int countNeg = isNegative(A[0]) ? 1 : 0;
    boolean nextSignPositive = false;
    boolean nextSignNegative = false;
    int max = 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i] == 0) {
        countPos++;
        countNeg++;
      } else {
        if (isPositive(A[i])) {
          if (nextSignPositive) {
            countPos++;
          } else {
            if (max < countPos) {
              max = countPos;
            }
            countPos = 1;
          }
          if (nextSignNegative) {
            if (max < countNeg) {
              max = countNeg;
            }
            countNeg = 1;
          } else {
            countNeg++;
          }
        } else {
          if (nextSignPositive) {
            if (max < countPos) {
              max = countPos;
            }
            countPos = 1;
          } else {
            countPos++;
          }
          if (nextSignNegative) {
            countNeg++;
          } else {

            if (max < countNeg) {
              max = countNeg;
            }
            countNeg = 1;
          }
        }
      }
      nextSignNegative = !nextSignNegative;
      nextSignPositive = !nextSignPositive;
    }
    if (max < countPos) {
      max = countPos;
    }
    if (max < countNeg) {
      max = countNeg;
    }
    return max;
  }

  private boolean isPositive(int x) {
    return x >= 0;
  }

  private boolean isNegative(int x) {
    return x <= 0;
  }
}
