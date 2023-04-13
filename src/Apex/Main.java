package Apex;

import java.util.*; 
import java.io.*;

public class Main {

  public static void main (String[] args) {  
    Scanner s = new Scanner(System.in);

    String input = s.nextLine();
    int arr[] = new int[input.length()];
    for(int i=0 ; i < input.length(); i++)
    {
      arr[i] = Character.getNumericValue(input.charAt(i));
    }
    System.out.print(ArrayChallenge(arr)); 
  }

  public static int ArrayChallenge(int[] arr) {
    int size = arr.length;
    int numSandwiches = arr[0];
    int difference = 0;
    boolean give = false;

    List<Integer> newList = new ArrayList();
    
    for(int i=1 ; i < size-1 ; i++)
    {
      int temp = Math.abs(arr[i] - arr[i+1]);
      difference += temp;

      newList.add(arr[i]);

      if (difference == 0) {
        return 0;
      }

      newList.add(size-1);

      Collections.sort(newList, Collections.reverseOrder());

      do {
        give = false;

        for (int j = 0; j < newList.size()-1; j++) {
          int temp2 = Math.abs(newList.get(j) - newList.get(j+1));
          if (temp2 != 0 && numSandwiches > 0) {
            if (temp2 < 0) {
              newList.set(j, newList.get(j)-numSandwiches);
              give = true;
            } else {
              newList.set(j, newList.get(j)-temp2);
              numSandwiches -= temp2;
              give = true;
            }
            break;
          }
        }
      } while (give);

      difference = 0;

      for (int j = 0; j < newList.size()-1; j++) {
        int temp3 = Math.abs(newList.get(j) - newList.get(j+1));
        difference += temp3;
      }
    }

    return difference;
  }
}
