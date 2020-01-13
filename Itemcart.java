package shopping;

import java.util.HashMap;
import java.util.Scanner;

public class Itemcart {
	String itemname[] = { "Apple", "cookie", "Cake" };
	int itemprice[] = { 10, 20, 30 };
	HashMap<String, Integer> map = new HashMap<>();
// To show the menu available
	public void menu() {
		int i;
		for (i = 0; i <= 2; i++)
			System.out.println((i + 1) + "   " + itemname[i] + "      "
					+ itemprice[i]);
	}
// To update item
	public void updateitem(int item_no, int quantity) {
		map.put(itemname[item_no - 1], quantity);
	}
// To remove complete item from the cart
	public void removeitem(int item_no) {
		map.remove(itemname[item_no - 1]);
	}
// To show the items in cart chosen by user
	public void displayitem() {
		System.out.println(map);
	}
// To show the final billing price
	public void bill() {
		int j, a, total = 0;
		for (j = 0; j < 3; j++) {
			if (map.containsKey(itemname[j])) {
				a = map.get(itemname[j]);
				total = total + itemprice[j] * a;
			}
		}
		System.out.println("total=" + total);
	}

	public static void main(String[] args) {
		System.out.println("###### welcome to shopping ######");
		Itemcart m = new Itemcart();
		int ch;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out
					.println(" 1.To show the menu\n 2.To update items in cart\n 3.To remove items from the cart\n 4.To display items\n 5.To generate bill\n");
			try {

				ch = sc.nextInt();
				switch (ch) {
				case 1:
					m.menu();
					break;
				case 2:
					System.out.println("enter the item s.no");
					int item_number = sc.nextInt();
					System.out.println("enter item quantity");
					int Quantity = sc.nextInt();
					m.updateitem(item_number, Quantity);
					break;
				case 3:
					System.out.println("enter item no you want to delete");
					int item_numbr = sc.nextInt();
					m.removeitem(item_numbr);
					break;
				case 4:
					m.displayitem();
					break;
				case 5:
					m.bill();
					break;
				default:
					System.out.println("please enter valid choice");
					sc.close();
					break;
				}
			} catch (Exception ex) {
				sc.nextLine();
				System.out.println("Press valid key");
			}/*try catch is used to remove error when we press alphabet in switch case instead of number*/

		}

	}

}
