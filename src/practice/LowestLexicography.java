package practice;

import java.util.Arrays;
import java.util.Comparator;
/**多个字符串拼接，求出最小字典序字符串
 * */
public class LowestLexicography {

	public static class MyComparator implements Comparator<String> {
		@Override
		//比较策略需要有传递性  a.b<=b.a  b.c<=c.b ====>a.c<=c.a
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));

	}

}
