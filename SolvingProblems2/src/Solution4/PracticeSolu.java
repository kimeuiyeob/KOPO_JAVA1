package Solution4;

import java.util.HashMap;
import java.util.Map;

public class PracticeSolu {
	public int solution(int[] nums, int m) {

		int answer = 0;
		int sum = 0;
		Map<Integer, Integer> HM = new HashMap<>();
		// �켱 HM�� 0,1�� ����ش�.
		HM.put(0, 1);
		// �̰��� ������ ������ ���� ���� Ȯ���ϴ� ����� ����.
		for (int i : nums) {
			// sum���ٰ� ������ ��Ų��
			sum += i;
			// �켱������ containsKey()��°� �Ҹ����·� HM�� Ű���� �ִٸ� true�ƴϸ� false�̴�.
			// ó���� 2�� ���� ���� ���� ���¿� HM�� Ű��0�� ���ۿ� ���⶧���� ���ǹ��� Ÿ�� �ʰ� �ٷ� HM�� Ű�� 2�� ��Եȴ�.
			// HM.getOrDefault()�� ����Ͽ� Ű��2�� �� ���ý� ������ �����ش�.
			// �״��� 3��° �ݺ����� ���� �� ��� �������� 7�̵ȴ�.
			// 7�̵Ǵ°�� sum = 7 / m = 5�̹Ƿ� 7-5�ϸ� 2�� �ȴ�. HM�� Ű���� 2�ΰ� �ִ�?
			// ������ ������ 2�� ���� ������ Ʈ�簡 �ȴ�.
			// �׶� Ű�� �߷����� 1�̱⶧���� answer�� 1�� �߰����ȴ�. �̷��� �ݺ��ϸ� ���� ���Ҽ��ִ�.
			if (HM.containsKey(sum - m)) {
				answer += HM.get(sum - m);
			}
			HM.put(sum, HM.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		PracticeSolu T = new PracticeSolu();
		System.out.println(T.solution(new int[] { 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2 }, 3));
//		System.out.println(T.solution(new int[] { -1, 0, 1 }, 0));
//		System.out.println(T.solution(new int[] { -1, -1, -1, 1 }, 0));
	}
}