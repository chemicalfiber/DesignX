package com.gdkm.util;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlUtil {	
	/** HTML代码的Escape处理方法 */
	public static String escape(String src) {
		return StringEscapeUtils.escapeXml(src);
	}

	/** HTML代码的UnEscape处理方法 */
	public static String unescape(String src) {
		return StringEscapeUtils.unescapeHtml4(StringEscapeUtils
				.unescapeXml(src));
	}
	/** HTML代码的UnEscape处理方法，去除html标签 */
	public static String unescapetext(String src) {
		String merDesc=StringEscapeUtils.unescapeHtml4(StringEscapeUtils.unescapeXml(src));
		merDesc = merDesc.replaceAll("</?[^>]+>", "");
		merDesc = merDesc.replaceAll("&nbsp;", "").replaceAll("\n", "").replaceAll("\r", "").trim();
		return merDesc;
	}
	
	/** 截取指定字节数的字符串,且确保汉字不被拆分 */
	public static String cutString(String text, int textMaxChar) {
		int size, index;
		String result = null;
		if (textMaxChar <= 0) {
			result = text;
		} else {
			for (size = 0, index = 0; index < text.length()
					&& size < textMaxChar; index++) {
				size += text.substring(index, index + 1).getBytes().length;
			}
			result = text.substring(0, index);
		}
		return result;
	}

}
