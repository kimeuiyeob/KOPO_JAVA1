package Solution5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoluPractice {

	public String solution(String[] votes, int k) {

		String answer = " ";
		// ��ǥ���ڵ��� ���� �迭 �����Ѵ�.
		String[] getter = new String[votes.length];
		String[] split = new String[2];
		// �ݺ��� ���� split���� ���� ��ǥ�����ڸ� �迭�� ��´�.
		for (int i = 0; i < votes.length; i++) {
			split = votes[i].split(" ");
			getter[i] = split[1];
		}
		System.out.println("��ǥ ������ : " + Arrays.toString(getter));

		// HashMap����ؼ� �̸��� �ߺ��� �����ϰ� ���� Ű�� ���� ���� +1�� �����Ѵ�.
		Map<String, Integer> HM = new HashMap<>();
		for (String string : getter) {
			HM.put(string, HM.getOrDefault(string, 0) + 1);
		}
		System.out.println("�ߺ� ���� ���� ���� : " + HM);

		// Map�� ���������� �����ؼ� ����Ʈ�� �������� �����Ѵ�.
		List<String> moreThan2 = new ArrayList<>();
		// HashMap�� ������� �������� ���ؼ� Map.Entry��ü ����Ѵ�. entrySet()Ű�� ����� �����Ѵ�.
		for (Map.Entry<String, Integer> string : HM.entrySet()) {
			// ������� �ŰԺ��� ������ ���ų� ũ�ٸ� ȸ�弱�� �������־
			// ���ǹ��� �´� ������� ����Ʈ�� ����ش�.
			if (string.getValue() >= k) {
				moreThan2.add(string.getKey());
			}
		}
		System.out.println("�ŰԺ��� �������� ��ǥ ���� ������ : " + moreThan2);

		// HashMap����ؼ� ���� �����ڸ� �ߺ������ϰ� ī��Ʈ�Ѵ�.
		Map<String, Integer> HashM = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			split = votes[i].split(" ");
			for (int j = 0; j < moreThan2.size(); j++) {
				if (split[1].equals(moreThan2.get(j))) {
					HashM.put(split[0], HashM.getOrDefault(split[0], 0) + 1);
				}
			}
		}
		System.out.println("���� ���� �� : " + HashM);

		// �ְ��� ���ϱ� ���� ���� �����Ѵ�.
		int max = Integer.MIN_VALUE;
		// ���� ������ ���� ���� ���� ������ ����ش�.
		for (Map.Entry<String, Integer> string : HashM.entrySet()) {
			if (string.getValue() > max) {
				max = string.getValue();
			}
		}
		System.out.println("���� ���� ���� ���� �� : " + max);

		// ���� ������ ���̹��� ���̶� ������ ������� �������ִ� ������� ����Ʈ�� ��´�.
		List<String> finalPerson = new ArrayList<>();
		for (Map.Entry<String, Integer> string : HashM.entrySet()) {
			if (string.getValue() == max) {
				finalPerson.add(string.getKey());
			}
		}
		// �� ������ ���ĺ������� �����ؾ��ϱ� ������ Collections.sort����Ѵ�.
		Collections.sort(finalPerson);
		// ù��°�� �ִ� ����� �����´�.
		answer = finalPerson.get(0);
		return answer;
	}

	public static void main(String[] args) {
		SoluPractice T = new SoluPractice();
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
				"luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}