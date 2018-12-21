package org.com.exam.module1;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int sumA = 0;
		int sumB = 0;

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)) {
				sumA++;
			} else if (a.get(i) < b.get(i)) {
				sumB++;
			}
		}
		res.add(sumA);
		res.add(sumB);

		return res;

	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(6);
		a.add(7);
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(6);
		b.add(10);
		System.out.println(compareTriplets(a, b));

	}

}
