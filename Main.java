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

    static int func() {
        int price = r_price[0];
        int sum;
        int bit;
        int inc;//option num : max=2
        String bin;

        for (int i = 0; i < rnum; i++) {     	
        	sum = r_price[i];
        	if (sum == money)
        		return sum;
        	bit = (int)Math.pow(2, opnum) - 1;
   	        while (bit >= 0) {
    	    	bin = Integer.toBinaryString(bit);
    	    	inc = 0;
        		for (int j = 0; j < bin.length(); j++) {
        			if (bin.charAt(bin.length() - j - 1) == '1' && inc < 2) {
        				try {
        					sum += op_price[bin.length() - j - 1];
        					inc++;
        				} catch (ArrayIndexOutOfBoundsException e) {
        					break;
        				}
        			}
        		}
        		if (Math.abs(money - sum) < Math.abs(money - price) || (Math.abs(money - sum) == Math.abs(money - price) && sum < price)) {
        			price = sum;
        		}
        		if (price == money)
        			 return price;
        		bit--;
        		sum = r_price[i];
        	} 	
        }
        return price;
    }
}