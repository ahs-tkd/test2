import java.util.Scanner;

class Main {
    static int k, money, rnum, opnum, ans = 0;
    static String[] ramen, option;
    static int[] r_price, op_price;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
			money = sc.nextInt();
			rnum  = sc.nextInt();
			ramen = new String[rnum];
			r_price = new int[rnum];
			for (int j = 0; j < rnum; j++) {
				ramen[j] = sc.next();
				r_price[j] = sc.nextInt();
        	}
        	opnum  = sc.nextInt();
			option = new String[opnum];
			op_price = new int[opnum];
			for (int j = 0; j < opnum; j++) {
				option[j] = sc.next();
				op_price[j] = sc.nextInt();
        	}
        	ans = func();
        	System.out.printf("Case #%d: %d\n",i , ans);	
        }
    }
}