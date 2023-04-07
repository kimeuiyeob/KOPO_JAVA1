package Solution1;

import java.util.Arrays;

public class Solution1 {

	public int[] solution(int c, int r, int k) {

		// ���� �������� anwer�迭
		int[] answer = new int[2];
		// 2���� �迭�� ���������� �ѹ� �����°� ����Ʈ�̴�.
		int[][] intArr = new int[c][r];
		// ������ ����� �迭 ����
		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		int x = 0, y = 0, d = 1;
		int count = 1;
		// k�� �ش� ��ġ�� ���� ã�°Ŷ� while���� k������ �ݺ��� ������.
		while (count < k) {
			// ���� ����
			int dx = x + directionX[d];
			int dy = y + directionY[d];
			// ������ �迭 0���� �۰ų� ���̰� �� ��ų� �ƴϸ� �迭 ���� 0���� ũ�� ���ǹ��� Ÿ�Եȴ�.
			if (dx < 0 || dy < 0 || dx >= c || dy >= r || intArr[dx][dy] > 0) {
				// ������ ���������� ��ĭ ������.
				d = (d + 1) % 4;
				// �̶��� ������ȯ�̶� continue�� �Ʒ� �� �ȵ��� �����ش�.
				continue;
			}
			// ���� if���� Ÿ�� �ʾҴٸ� ��ĭ ���������״� �̶� count�� ���������ش�.
			count++;
			// ���� ���ǹ��� intArr[dx][dy] > 0 �̰� ����⶧���� ��ĭ �����ϸ� ���� ä���ش�. �ٽ� ������ ���ϰ�
			// ���� �̰� �����ְ� �Ǹ� �����ڸ��� ���ۻ��� �����̴�.
			intArr[x][y] = 1;
			// ��ĭ �����ߴٸ� �ش� x y ���� ����ش�.
			x = dx;
			y = dy;
		}

		// while���� ������ ��û ���ڸ�ŭ ���Ұ� ������ x y���� ����ش�. ���������� 1,1�� �����ϴµ�
		// �迭�� 0,0���� �����ϱ� ������ +1 �� ���ذŴ�.
		answer[0] = x + 1;
		answer[1] = y + 1;

		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}