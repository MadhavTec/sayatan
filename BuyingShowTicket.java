package com.puzzle;

import java.util.Arrays;

public class BuyingShowTicket {

	static long waitingTime(int[] tickets, int p) {

		long times = 0;
		int[] temp = Arrays.copyOf(tickets, tickets.length);
		for (int i = 0; i < tickets.length; i++) {
			temp[i] = tickets[i] - tickets[p];
		}
		for (int i = 0; i < tickets.length; i++) {
			if (temp[i] < 0)
				times += tickets[i];
			else {
				if (i <= p)
					times += tickets[p];
				else
					times += tickets[p] - 1;
			}
		}
		return times;
	}
	
	public static void main(String[] args) {
		
		int[] tickets = {2,6,3,4,5};
		System.out.println(BuyingShowTicket.waitingTime(tickets, 2));
	}
}
