package roman;
/* $Id: Roman.java,v 1.2 2006/08/10 01:38:41 aholkner Exp $ 
 *
 * Software Testing, 
 *
 *        Written by Alex Holkner
 */

public class Roman {
	// U+2181 ad U+2182 are Unicode code points for Roman numerals
	// 5000 and 10,000.
	private static final char[] powers = { 'I', 'V', 'X', 'L', 'C', 'D', 'M', '\u2181', '\u2182' };
	private static final int[][] positions = {

			{ 0, -1, -1, -1 }, // 1 I
			{ 0, 0, -1, -1 }, // 2 II
			{ 0, 0, 0, -1 }, // 3 III
			{ 0, 1, -1, -1 }, // 4 IV
			{ 1, -1, -1, -1 }, // 5 V
			{ 1, 0, -1, -1 }, // 6 VI
			{ 1, 0, 0, -1 }, // 7 VII
			{ 1, 0, 0, 0 }, // 8 VIII
			{ 0, 2, -1, -1 }, // 9 IX
	};

	public static final int ROMAN_MIN = 1;
	public static final int ROMAN_MAX = 38999;

	public static String toRoman(int number) throws RomanException {
		if (number < ROMAN_MIN || number > ROMAN_MAX)
			throw new RomanException(String.format("Cannot convert %d to Roman numerals", number));

		String result = "";
		int power = 0;
		while (number > 0) {
			String part = "";
			if (number % 10 > 0) {
				int[] partIndices = positions[number % 10 - 1];
				for (int i = 0; i < partIndices.length && partIndices[i] != -1; i++)
					part += powers[power + partIndices[i]];
				result = part + result;
			}
			number /= 10;
			power += 2;
		}

		return result;
	}

	public static int fromRoman(String roman) throws RomanException {
		if (roman.length() == 0)
			throw new RomanException("Cannot convert empty string");

		char[] rc = roman.toCharArray();
		int result = 0;
		int lastPower = powers.length;

		for (int i = 0; i < rc.length;) {
			int power = 0;
			for (; power < powers.length && powers[power] != rc[i]; power++)
				;

			if (power == powers.length)
				throw new RomanException(String.format("\"%c\" is an invalid character", rc[i]));

			power &= ~0x1;

			if (power >= lastPower)
				throw new RomanException(String.format("Parse error in \"%s\" at %d", roman, i));

			int bestVal = 0;
			int maxPartLength = 0;
			for (int j = 0; j < positions.length; j++) {
				int[] partIndices = positions[j];
				int k = 0;
				for (; k < partIndices.length && partIndices[k] != -1 && partIndices[k] + power < powers.length
						&& k + i < rc.length; k++) {
					if (powers[partIndices[k] + power] != rc[i + k])
						break;
				}

				if (k > maxPartLength && (k == partIndices.length || partIndices[k] == -1)) {
					maxPartLength = k;
					bestVal = j + 1;
				}
			}

			assert bestVal != 0;

			lastPower = power;
			for (; power > 0; power -= 2)
				bestVal *= 10;
			result += bestVal;

			i += maxPartLength;
		}

		return result;
	}
}
