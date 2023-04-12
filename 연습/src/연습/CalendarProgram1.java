package ����;

import java.util.Scanner;

class CalendarProgram1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int year; // ����� �Է� <== �⵵ �޾ƿ���
		int month; // ����� �Է� <== �� �޾ƿ���

		int dayOfWeek; // ����� ����
		int sum = 0; // ������ ��� �� ��� ����

		int basicYear[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // �޺��� ������ ��¥ ����

		System.out.printf("�⵵ �Է� ���ּ��� : ");
		year = sc.nextInt();
		System.out.printf("�� �Է� ���ּ��� : ");
		month = sc.nextInt();

		// ���� Ȯ��
		// �⵵�� ������ ����1�� ������ ���� -> 2���޿� �Ϸ縦 �����ش�.
		int yoondal = checkYoonDal(year);
		if (yoondal == 1) {
			basicYear[1] += 1;
		}

		// 1900�⵵���� ����
		for (int i = 1900; i < year; i++) {
			int yoon = checkYoonDal(i);
			if (yoon == 1) {
				sum += 366; // �����Ͻ� �Ϸ�� ��
			} else {
				sum += 365;
			}
		}

		// �Է��� �ޱ��� �������� ����� sum�� ����
		for (int i = 0; i < month - 1; i++) {
			sum += basicYear[i];
		}

		// ���� sum�� 1900����� �Է¹޴� �⵵���� ��� ��¥ ���Ѵ�, ���� ����, ���� ���� ��¥����
		sum += 1;

		// ��� ��¥�� ������ 7�� �������� �������� ���� �����̴�.
		dayOfWeek = sum % 7;

		System.out.printf("==================== %d�� %d��====================\n", year, month);
		System.out.printf("��\t��\tȭ\t��\t��\t��\t��\n");

		// ���� ���Ͽ� ���� ����
		for (int j = 0; j < dayOfWeek; j++) {
			System.out.printf("\t");
		}

		// ���� ���� ��¥��ŭ �ݺ�
		for (int i = 1; i <= basicYear[month - 1]; i++) {
			System.out.printf("%d\t", i);

			if (dayOfWeek == 6) {
				dayOfWeek = -1;
				System.out.printf("\n");
			}
			dayOfWeek++;
		}

	}

	// ���� Ȯ�� �Լ�
	static int checkYoonDal(int a) {
		if ((a % 4 == 0) && !(a % 100 == 0) || (a % 400 == 0)) {
			return 1;
		} else {
			return 0;
		}
	}

}