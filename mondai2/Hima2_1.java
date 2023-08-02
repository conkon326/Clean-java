public class Hima2_1 {

  public static void main(String[] args) {
    int data[][] = {
      { 1, 2, 3, 2, 1 },
      { 0, 4, 1, 4 },
      { 0, 9 },
      { 0, 9 },
      { 0, 9 },
      { 1, 7, 1 },
      { 2, 5, 2 },
      { 3, 3, 3 },
      { 4, 1, 4 },
    };

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if ((j + 1) % 2 == 0) {
          for (int k = 0; k < data[i][j]; k++) {
            System.out.print("\u25A0");
          }
        } else {
          for (int k = 0; k < data[i][j]; k++) {
            System.out.print("\u25A1");
          }
        }
      }
      System.out.println();
    }
  }
}
