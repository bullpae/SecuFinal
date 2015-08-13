package com.k2k.secu;

import java.util.List;

public class SecuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String a = "0100010111";
		// String b = "0000101101";
		int a = 0;
		a = SetBit(a, 8);
		a = SetBit(a, 4);
		a = SetBit(a, 3);
		a = SetBit(a, 2);
		a = SetBit(a, 0);

		DisplayBit(a);
		
		int b = 0;
		b = SetBit(b, 5);
		b = SetBit(b, 3);
		b = SetBit(b, 2);
		b = SetBit(b, 0);

		DisplayBit(b);

		System.out.println("PLOY_MUL=====");
		
		PolyMul(a, b);
		
		System.out.println("PLOY_DIY_Q=====");
		PolyDivQ(a, b);
	}
	
	public static int SetBit(int val, int pos) {
		 return val + (int) Math.pow(2, pos);
	}

	public static void DisplayBit(int val) {
		String s = "";

		for (int i = 0; i < Integer.numberOfLeadingZeros(val); i++) {
			s += "0"; // 0을 빈자리 개수만큼 만들어 전진 배치
		}
		s += Integer.toBinaryString(val); // 10진수를 2진수화하여 합치기

		// for (int i = 0; i < 32; i += 8)
		// s2 += s.substring(i, i + 8) + " "; // 2진수를 8개씩 공백으로 나누어 묶기

		System.out.println(s);
		// System.out.println(s2);
	}

	public static int PolyMul(int a, int b) {
		//String aBin = Integer.toBinaryString(a);
		String bBin = Integer.toBinaryString(b);
		
		int ret = 0;
		int tmp = 0;
		int idx = 0;
		for (int i = bBin.length() - 1; i > 0; i--, idx++) {
			if (bBin.getBytes()[i] == '1') {
				tmp = a << idx;
				//DisplayBit(tmp);
				ret ^= tmp;
				//DisplayBit(ret);
			}
		}
		
		DisplayBit(ret);

		return ret;
	}
	
	public static int PolyDivQ(int a, int b) {
		String aBin = Integer.toBinaryString(a);
		String bBin = Integer.toBinaryString(b);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		int ret = a;
		int tmp = 0;
		int quot = 0;
		int aRealLen = aBin.length() - 1;
		for (int i = bBin.length() - 1; i > 0; i--) {
			String divA = Integer.toBinaryString(ret);
			
			//int maxIdx = divA.length() - 1;
			for (int maxIdx = divA.length() - 1; maxIdx >= 0; maxIdx--) {
				if (divA.getBytes()[maxIdx] == '1') {
					quot += SetBit(quot, maxIdx - (bBin.length()));
					tmp = b << i - (bBin.length());
					DisplayBit(tmp);
					ret ^= tmp;
					DisplayBit(ret);
				}
			}
		}
		
//		for (int i = aRealLen; i > (bBin.length() - 1); i--) {
//			String divA = Integer.toBinaryString(ret);
//			int maxIdx = divA.length() - 1;
//			if (divA.getBytes()[maxIdx] == '1') {
//				quot += SetBit(quot, maxIdx - (bBin.length()));
//				tmp = b << i - (bBin.length());
//				DisplayBit(tmp);
//				ret ^= tmp;
//				DisplayBit(ret);
//			}
//		}
		
		DisplayBit(ret);
		
		DisplayBit(quot);

		return ret;
	}

}
