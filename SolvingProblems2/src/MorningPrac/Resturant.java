package MorningPrac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resturant {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> menuList = new ArrayList<>();
		List<Integer> menuPrice = new ArrayList<>();

		double revenue = 0.66;
		double partTime = 12000 / 60.0; // �д� 200��
		int cookingTime = 20;

		System.out.println("�޴��� ����ּ���~~");

		while (true) {
			System.out.println("1. �������� : 9000��");
			System.out.println("2. ��¡��� : 12000��");
			System.out.println("3. ��ġ� : 8000��");
			System.out.println("4. ����� : 8000��");
			System.out.println("5. ���̴� : 2000��");
			System.out.println("6. �׸� ������");

			int chooseMenu = sc.nextInt();

			if (chooseMenu == 1) {
				System.out.println("���� �޴��� ���������Դϴ�.");
				System.out.println("�� ���ðڽ��ϱ�?");
				menuPrice.add(9000);
			} else if (chooseMenu == 2) {
				System.out.println("���� �޴��� ��¡����Դϴ�.");
				System.out.println("�� ���ðڽ��ϱ�?");
				menuPrice.add(12000);
			} else if (chooseMenu == 3) {
				System.out.println("���� �޴��� ��ġ��Դϴ�.");
				System.out.println("�� ���ðڽ��ϱ�?");
				menuPrice.add(8000);
			} else if (chooseMenu == 4) {
				System.out.println("���� �޴��� ������Դϴ�.");
				System.out.println("�� ���ðڽ��ϱ�?");
				menuPrice.add(8000);
			} else if (chooseMenu == 5) {
				System.out.println("���� �޴��� ���̴��Դϴ�.");
				System.out.println("�� ���ðڽ��ϱ�?");
				menuPrice.add(2000);
			} else if (chooseMenu == 6) {
				System.out.println("�����մϴ�~");
				break;
			} else {
				System.out.println("1~6���� ����ּ���~");
			}
			menuList.add(chooseMenu);
		}
		int totalIncomeMoney = 0;
		for (int i = 0; i < menuPrice.size(); i++) {
			totalIncomeMoney += menuPrice.get(i);
		}
		System.out.println("�� �ݾ��� : " + totalIncomeMoney + " ���Դϴ�.");

		double revenueTotal = 0;
		int totalCookingTime = 0;

		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i) > 0 && menuList.get(i) < 5) {
				totalCookingTime += cookingTime;
			}
		}
		int giveMoneyManagerMoney = (int) totalCookingTime * (int) partTime;

		revenueTotal = totalIncomeMoney * revenue - giveMoneyManagerMoney;
		System.out.println("������� �� ���� : " + (int) revenueTotal + "�� �Դϴ�.");

	}

}
