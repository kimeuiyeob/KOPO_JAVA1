package Solution2;

import java.util.ArrayList;

public class Solution2 {

	public int solution(int[] nums) {
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();

		// ������� ���������� �켱 ����� ������ ã���ִ°� �����̴�.
		// ����� �����̶�°� �ᱹ�� �����̶� �����ʺ��� ����� ���ڰ� ũ��ȴ�.
		// �׷��� �ݺ����� ���ؼ� ã���ش�.
		for (int i = 1; i < n - 1; i++) {
			// �ε����� 0���� ���ؾߵǴϱ� i�� 1���ְ� �ε��� ���̷� ����ϴϱ� n-1�� ���ش�.
			// ���� �ε��� ���ʺ��� ����� �� ũ�� ����� �����ʺ��� ũ�ٸ�
			// �� �ش簪�� peaks ����Ʈ���� ����ش�. => �̷��� �Ǹ� ����� ������ �� ã�����ִ�.
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}
		// ����� ���� ������ ������ �ݺ�������/
		// ���⼭ ����Ʈ�� �����̶� ������ ������ ī�������ִ°Ŵ�.
		for (int x : peaks) {
			// �켱 �ش� ���� ���� ������ ������ ����ְ�
			int left = x;
			int right = x;
			int cnt = 1;
			// ������ ī�����ϴ� �ݺ���
			// ���� ���� �ٻ��� 0���� �۾����� �ȵǰ�
			// ���� ������ ������ ���� �� ũ�ٸ� ī������ �����ϰ� �ε����� 1�� ���ش�.
			// �̷��� ���ѷ������� left�� 0�̵ɶ������� ���� �ε��� ���� ������ �ε��� ������ ũ�ԵǸ� ��������.
			while (left - 1 > 0 && nums[left - 1] < nums[left]) {
				left--;
				cnt++;
			}
			// ���� ������ ���������� ����� ������ �ε������� ���� �ε��� ���̶� ���ؼ� ī�����ϴ°Ŵ�.
			while (right + 1 < n && nums[right] > nums[right + 1]) {
				right++;
				cnt++;
			}
			// �̶� Math.max�Լ��� ����Ͽ� cnt�� ���� ������ answer�� ��Ƽ� �����Ѵ�.
			System.out.println("���� �� : " + cnt);
			answer = Math.max(answer, cnt);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
//		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}