package Solution1;

import java.util.Stack;

public class Solution1 {

	public String solution(String s) {
		// ���� ����� ��������
		String answer = "";
		// �������� ���� ������ Stack LIFO ��� ���
		Stack<String> st = new Stack<>();
		// ���ڿ��� ������ ���ڷ� ���� �ݺ�������
		for (Character x : s.toCharArray()) {
			// �Ѿ�� ���ڰ� )�϶�
			if (x == ')') {
				// ���� ����� ���� ����
				String temp = "";
				// Stack�� ���� ������������� �ݺ�����.
				while (!st.empty()) {
					// ���� ���� c������ ����ش�.
					// �� if���� x == ) �϶� ���°Ŵϱ�
					String c = st.pop();
					System.out.println("stack�� ��� ������ �� : " + c);
					// ���� ���� ���� ( ��
					if (c.equals("(")) {
						// ���� ����� ���� ����
						String num = "";
						// Character.isDigit() �������� �Ǵ��ϴ� Character���� �Լ�
						System.out.println("�� Ȯ�� : " + st.peek());
						// ���� st�ȿ� ���� �ְ� �������� ��� ���� ���ڶ�� �� ���ڸ� ���� num�� ����ش�.
						while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
							num = st.pop() + num;
						}
						String res = "";
						int cnt = 0;
						// ���� num�� ����ִٸ� 1��
						if (num.equals("")) {
							cnt = 1;
						} else {
							// �ƴϸ� ����ȯ �ؼ� �� ���ڸ� ����ش�.
							// ������� string���ڿ��� 2�� ���Դٸ� ���� 2�� �ٱ cnt�� ����ִ°Ŵ�.
							// �̼��ڸ�ŭ �׹��ڿ��� �ݺ������� �������ϱ� �����̴�.
							cnt = Integer.parseInt(num);
						}
						// ���⼭ �ش� ���ڸ�ŭ �ݺ����� res�� ����ְ� res�� �ٽ� st�� ����ش�.
						for (int i = 0; i < cnt; i++) {
							res += temp;
						}
						st.push(res);
						break;
					}
					// ������ ���� ���� ( �ƴ϶�� temp�� ���� �߰��Ѵ�.
					// �̶� c�� ��ġ�� �߿��ϴ�.
					temp = c + temp;
				}
			} else {
				// )�� ������ ���� ���ڵ��� st stack�� ����ش�.
				st.push(String.valueOf(x));
			}
		}
		for (String x : st) {
			answer += x;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
//		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
//		System.out.println(T.solution("2(ab3((cd)))"));
//		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
//		System.out.println(T.solution("3(ab2(sg))"));
	}
}