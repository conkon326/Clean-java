

public class Osarai_2re {

  public static void main(String[] args) {
    System.out.println(
		// ���̒l����͂��Ă������� >
      "\u5143\u306E\u5024\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044"
    );
    int a = new java.util.Scanner(System.in).nextInt();
    System.out.println(
		// �v�Z�񐔂���͂��Ă������� >
      "\u8A08\u7B97\u56DE\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044"
    );
    int b = new java.util.Scanner(System.in).nextInt();
    System.out.println("++ or --");
    String operator = new java.util.Scanner(System.in).nextLine();
    for (int i = 0; i < b; i++) {
		// ������̒l������������equals���g�p
      if (operator.equals("++")) {
		// "�l��"
        System.out.println("\u5024\u306F" + ++a);
      } else if (operator.equals("--")) {
		System.out.println("\u5024\u306F" + --a);
	} else {
		// ++ �܂��� -- ����͂��Ă��������B
		System.out.println("++ \u307E\u305F\u306F -- \u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044\u3002");
		break;
	}
    }
  }
}
