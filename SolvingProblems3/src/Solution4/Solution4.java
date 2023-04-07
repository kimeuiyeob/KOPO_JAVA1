package Solution4;

import java.util.Arrays;
import java.util.HashMap;

public class Solution4 {

	public int[] solution(int[] nums) {

		// �Ѿ�� �迭�� ������ ����, ������ �л��̹Ƿ� �����丸 �������� /2�� �Ѵ�.
		int[] answer = new int[nums.length / 2];
		HashMap<Integer, Integer> nH = new HashMap<>();
		// �ߺ� ���� �� ���� ���� ����� ����
		for (int x : nums)
			nH.put(x, nH.getOrDefault(x, 0) + 1);
		// �迭 ������������ ���� => ���� ���ڴ� �ּҰ��̴�.
		Arrays.sort(nums);
		// ++������ ���� ����
		int indexUp = 0;
		
		System.out.println("�Ѿ�� �迭 : " + Arrays.toString(nums));
		System.out.println("MAP : " + nH);
		
		for (int x : nums) {
			
			if (nH.get(x) == 0) {
				continue;
			}

			// �迭�� ���� ����ش�.
			answer[indexUp] = x;
			indexUp++;

			// ������ nH�� ������ ���ڵ��� ���⼭ ���ش�.
			// �̷��� �Ǹ� �ΰ��� �����Եȴ�.
			nH.put(x, nH.get(x) - 1);
			nH.put(x * 2, nH.get(x * 2) - 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
//		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[] { 1, 1, 6, 2, 2, 7, 3, 14 })));
//		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}