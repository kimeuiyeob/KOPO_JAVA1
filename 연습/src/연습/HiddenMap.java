package ����;

import java.util.Arrays;

public class HiddenMap {

	public String[] solution(int number, int[] array1, int[] array2) {

//		======================================================
		// ù��° array1 �� ���������� �ٲ��� �� ���
		String[][] twoArrString1 = new String[number][number];
		String[] toString1 = new String[number];
		// �ι�° array2 �� ���������� �ٲ��� �� ���
		String[][] twoArrString2 = new String[number][number];
		String[] toString2 = new String[number];

		String Zero = "0";
		String One = "1";

//		======================================================
		// �޾ƿ� ���ڸ� ���������� ��ȯ , ������ �տ� 0�� ������ ������� ������ ���ǹ�
		// ���� ���ڰ� �����ϸ� �����Ѹ�ŭ �տ� 0�� ����
		for (int i = 0; i < number; i++) {
			String toBinary1 = Integer.toBinaryString(array1[i]);
			String toBinary2 = Integer.toBinaryString(array2[i]);
			int addZero1 = number - toBinary1.length();
			int addZero2 = number - toBinary2.length();
			if (toBinary1.length() < number) {
				for (int j = 0; j < addZero1; j++) {
					toBinary1 = Zero.concat(toBinary1);
				}
			}
			if (toBinary2.length() < number) {
				for (int j = 0; j < addZero2; j++) {
					toBinary2 = Zero.concat(toBinary2);
				}
			}
			toString1[i] = toBinary1;
			toString2[i] = toBinary2;
		}
//		======================================================
		// 1���� �迭�� �ִ� ������ ���ڸ� ���� 2���� �迭�� �����.
		for (int i = 0; i < toString1.length; i++) {
			String tmp1 = toString1[i];
			String tmp2 = toString2[i];
			for (int j = 0; j < tmp1.length(); j++) {
				twoArrString1[i][j] = String.valueOf(tmp1.charAt(j));
				twoArrString2[i][j] = String.valueOf(tmp2.charAt(j));
			}
		}

//		======================================================
		// �ΰ��� 2���� �迭 ��ġ�� -> 1�϶��� �Ѿ�� 0�϶��� �ι��� �迭�� 1���ִ��� Ȯ����
		// 1�� ������ 1��� ������ �״�� 0���� �����ش�.
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (twoArrString1[i][j].equals(Zero)) {
					if (twoArrString2[i][j].equals(Zero)) {
						continue;
					} else if (twoArrString2[i][j].equals(One)) {
						twoArrString1[i][j] = One;
					}
				}
			}
		}

//		======================================================
		// 1�� 0���� ������ 2�����迭�� 1�϶��� #�ٲٰ� 0�϶��� " "�ٲٱ�
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (twoArrString1[i][j].equals(One)) {
					twoArrString1[i][j] = "#";
				} else if (twoArrString1[i][j].equals(Zero)) {
					twoArrString1[i][j] = " ";
				}
			}
		}

//		======================================================
		// ������ ���
		String[] answer = new String[number];
		for (int i = 0; i < number; i++) {
			String add = "";
			for (int j = 0; j < number; j++) {
				add += twoArrString1[i][j];
			}
			answer[i] = add;
		}
		return answer;
	}

//	======================================================
	public static void main(String[] args) {

		HiddenMap HM = new HiddenMap();

		String[] answer1 = HM.solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
		System.out.println(Arrays.toString(answer1));

		String[] answer2 = HM.solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });
		System.out.println(Arrays.toString(answer2));

	}

}
