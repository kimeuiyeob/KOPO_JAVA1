package Solution5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution5 {

	public String solution(String[] votes, int k) {

		String answer = " ";
		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();
		HashMap<String, Integer> present = new HashMap<>();

		// �迭�� �޾ƿ� x�� ��� �ݺ�������.
		for (String x : votes) {
			// a = ��ǥ���� b = ��ǥ������
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			// putIfAbsent() Key ���� �����ϴ� ��� Map�� Value�� ���� ��ȯ�ϰ�,
			// Key���� �������� �ʴ� ��� Key�� Value�� Map�� �����ϰ� Null�� ��ȯ�Ѵ�.
			voteHash.putIfAbsent(a, new HashSet<String>());
			// �ش� ��ǥ�ڸ� Ű�� ������ ������� ��ǥ���ڸ� add����ش�.
			voteHash.get(a).add(b);
			// ��ǥ������ �̸� �ߺ����ŵ� �����Ѵ�.
			candidate.put(b, candidate.getOrDefault(b, 0) + 1);
		}

		System.out.println("voteHash : " + voteHash);
		System.out.println("candidate : " + candidate);

		int max = Integer.MIN_VALUE;
		// voteHash�� �ִ� Ű���� ������ �ݺ�����.
		for (String a : voteHash.keySet()) {
			int cnt = 0;

			for (String b : voteHash.get(a)) {
				if (candidate.get(b) >= k)
					cnt++;
			}
			present.put(a, cnt);
			max = Math.max(max, cnt);
		}

		ArrayList<String> tmp = new ArrayList<>();

		for (String name : present.keySet()) {
			if (present.get(name) == max)
				tmp.add(name);
		}

		tmp.sort((a, b) -> a.compareTo(b));
		answer = tmp.get(0);
		return answer;

	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
//		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
//				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
//		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
//				"luis tom", "daniel tom", "luis john" }, 2));
//		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
//				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}