package org.kawakicchi.dev.tools.util;

public class DevToolsUtil {

	/**
	 * 文字列をキャメル文字へ変換する。
	 * 
	 * @param string 文字列
	 * @return キャメル文字へ変換した文字列
	 */
	private static String toCamelCase(final String string) {
		String result = null;
		if (isNotNull(string)) {
			boolean flg = false;
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if ('_' == c) {
					flg = true;
				} else {
					if (flg) {
						flg = false;
						s.append(String.valueOf(c).toUpperCase());
					} else {
						s.append(c);
					}
				}
			}
			result = s.toString();
		}
		return result;
	}

	public static String toUpperCamelCase(final String string) {
		return toUpperCasePrefix(toCamelCase(string));
	}

	public static String toLowerCamelCase(final String string) {
		return toLowerCasePrefix(toCamelCase(string));
	}

	/**
	 * 先頭文字を大文字に変換する。
	 * 
	 * @param string 文字列
	 * @return 先頭文字を大文字にした文字列
	 */
	public static String toUpperCasePrefix(String string) {
		String result = null;
		if (isNotNull(string)) {
			if (0 < string.length()) {
				result = string.substring(0, 1).toUpperCase() + string.substring(1);
			} else {
				result = string;
			}
		}
		return result;
	}

	/**
	 * 先頭文字を小文字に変換する。
	 * 
	 * @param string 文字列
	 * @return 先頭文字を小文字にした文字列
	 */
	public static String toLowerCasePrefix(String string) {
		String result = null;
		if (isNotNull(string)) {
			if (0 < string.length()) {
				result = string.substring(0, 1).toLowerCase() + string.substring(1);
			} else {
				result = string;
			}
		}
		return result;
	}

	public static boolean isNull(final Object object) {
		return (null == object);
	}

	public static boolean isNotNull(final Object object) {
		return (!isNull(object));
	}

	public static boolean isAnyEquals(final String string, final String... strings) {
		for (String s : strings) {
			if (string.equals(s)) {
				return true;
			}
		}
		return false;
	}

	public static String padding(final int size) {
		return padding(size, ' ');
	}

	public static String padding(final int size, final char c) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append(c);
		}
		return s.toString();
	}
}
