package Solution2;

import java.util.Arrays;

class Solution2 {
	public int[] solution(int[][] board, int k) {
		// �������� �迭 ��
		int[] answer = new int[2];
		// �� ���̸� �˱� ���� ����
		int finishLine = board.length;

		// ���⼳���� ���� �迭
		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		// ���� �κ� ��ġ ����
		int x = 0;
		int y = 0;

		// ���⼳��
		int direction = 1;
		int count = 0;

		while (count < k) {
			count++;

			// ������ġ + �������� ���� ���� ����ش�.
			int nx = x + directionX[direction];
			int ny = y + directionY[direction];

			// ���� : �κ��� �ѱ��̶� 0�� �Ѿ�� ����, 1�� ������ �ȵȴ�.
			if (nx < 0 || nx >= finishLine || ny < 0 || ny >= finishLine || board[nx][ny] == 1) {
				// ���� ���ǹ��� �����ϸ� ������ȯ�� continue
				direction = (direction + 1) % 4;
				continue;
			}

			// ���ǹ��� �������� ������ �߰����ִٴ� ��
			// ���� ����ش�.
			x = nx;
			y = ny;
		}

		// ������ �� ����
		answer[0] = x;
		answer[1] = y;
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		int[][] arr1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = { { 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}