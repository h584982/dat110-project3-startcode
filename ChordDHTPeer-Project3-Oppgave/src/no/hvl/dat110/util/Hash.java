package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		// convert the hash into hex format

		// convert the hex into BigInteger

		// return the BigInteger

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		
			byte[] entityBytes = entity.getBytes();
			md.update(entityBytes);
			byte[] digest = md.digest();
			
			String value = toHex(digest);
			
			hashint = new BigInteger(value, 16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5
		
		// get the digest length
		// compute the number of bits = digest length * 8
		// compute the address size = 2 ^ number of bits
		// return the address size
		
			int length = bitSize();
			BigInteger size = new BigInteger("2").pow(length);
			
			return size;
		
	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
