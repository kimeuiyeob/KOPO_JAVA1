package ����;

import java.util.Scanner;

public class ThreeSixNineGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���.");
		int howManyTimes = sc.nextInt();

		for (int i = 1; i <= howManyTimes; i++) {

			int count = 0;
			String number = Integer.toString(i);

			for (int j = 0; j < number.length(); j++) {

				char toChar = number.charAt(j);

				if (toChar == '3' || toChar == '6' || toChar == '9') {
					count++;
				}
			}

			if (count == 1) {
				System.out.print("¦! ");
			} else if (count == 2) {
				System.out.print("¦¦! ");
			} else if (count == 3) {
				System.out.print("¦¦¦! ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
}