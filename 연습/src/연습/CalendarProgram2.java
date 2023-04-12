package ����;

import java.util.Scanner;

public class CalendarProgram2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] basicMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int sum = 0;
		int dayWeek = 0;

		System.out.println("�⵵�� �Է����ּ���.");
		int nowYear = sc.nextInt();
		System.out.println("�� �Է����ּ���.");
		int nowMonth = sc.nextInt();

		int year = checkYoonDal(nowYear);
		if (year == 1) {
			basicMonth[1] += 1;
		}

		for (int i = 2000; i < nowYear; i++) {
			int checking = checkYoonDal(i);
			if (checking == 1) {
				sum += 366;
			} else {
				sum += 365;
			}
		}
		sum += 6;

		for (int i = 0; i < nowMonth - 1; i++) {
			sum += basicMonth[i];
		}
		System.out.println("**************************************************");
		System.out.println("                  " + nowYear + "�� " + nowMonth + "���� �޷�");
		System.out.println("**************************************************");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		dayWeek = sum % 7;

		for (int i = 0; i < dayWeek; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= basicMonth[nowMonth - 1]; i++) {
			System.out.print(i + "\t");

			if (dayWeek == 6) {
				dayWeek = -1;
				System.out.println();
			}
			dayWeek++;
		}
	}

	static public int checkYoonDal(int year) {
		if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
			return 1;
		} else {
			return 0;
		}

	}
}
