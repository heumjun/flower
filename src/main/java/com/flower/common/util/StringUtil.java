package com.flower.common.util;

import java.util.Map;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

/**
 * 
 * @파일명 : StringUtil.java
 * @프로젝트 : ITMS
 * @날짜 : 2018. 3. 21.
 * @작성자 : Cho HeumJun
 * @설명
 * 
 *     <pre>
 * 	String Util을 구현
 *     </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class StringUtil
{
	/**
	 * 
	 * @메소드명 : nullString
	 * @날짜 : 2018. 3. 21.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *	null 데이타는 "" 로 치환
	 *     </pre>
	 * 
	 * @param obj
	 * @return
	 */
	public static String nullString(Object obj)
	{
		String ret = "";

		ret = obj == null ? "" : obj.toString();

		return ret;
	}

	public static String setEmptyExt(String arg)
	{
		if (isNullString(arg))
			return "";
		else
			return arg;
	}

	public static boolean isNullString(String arg)
	{
		if (arg == null || arg.equals("") || arg.equalsIgnoreCase("null"))
			return true;
		else
			return false;
	}

	public static String setEmpty(String str)
	{
		String ret = "";
		if (str != null)
		{
			ret = str.trim();
		}
		return ret;
	}

	/**
	 * 
	 * @메소드명 : objectValueMapChangeString
	 * @날짜 : 2018. 3. 21.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *	Object value 형태의 map을 string value형태의 map으로 변경하여 리턴 
	 *  CaseInsensitiveMap를 사용하여 대소문자 구분 필요 없는 상태로 리턴 및 앞뒤 문자 trim처리
	 *     </pre>
	 * 
	 * @param param
	 * @return
	 */
	public static Map<String, String> objectValueMapChangeString(Map<String, Object> param)
	{
		Map<String, String> returnValue = new CaseInsensitiveMap();
		for (String key : param.keySet())
		{
			returnValue.put(key, nullString(param.get(key)).trim());
		}
		return returnValue;
	}

	public static Map<String, Object> stringValueMapChangeObject(Map<String, String> param)
	{
		Map<String, Object> returnValue = new CaseInsensitiveMap();
		for (String key : param.keySet())
		{
			returnValue.put(key, param.get(key));
		}
		return returnValue;
	}

	// isNumeric
	public static boolean isNumeric(String text)
	{
		if (text == null || text.trim().length() == 0)
			return false;

		for (int i = 0; i < text.length(); i++)
		{
			if (!Character.isDigit(text.charAt(i)))
				return false;
		}
		return true;
	}

	// isAlphabet
	public static boolean isAlphabet(String text)
	{
		if (text == null || text.trim().length() == 0)
			return false;

		for (int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
			{
				;
				/* skip */ }
			else
			{
				return false;
			}
		}
		return true;
	}

	// utility function : replaceAmpAll
	public static synchronized String replaceAmpAll(String str, String oldstr, String newstr)
	{
		StringBuffer buf = new StringBuffer();
		int savedpos = 0;

		while (true)
		{
			int pos = str.indexOf(oldstr, savedpos);
			if (pos != -1)
			{
				buf.append(str.substring(savedpos, pos));
				buf.append(newstr);
				savedpos = pos + oldstr.length();
				if (savedpos >= str.length())
					break;
			}
			else
				break;
		}

		buf.append(str.substring(savedpos, str.length()));
		return buf.toString();
	}
	
	public static String ScriptReplace(String str) { 
        String result = "";
        if ( str != null ){        	 
            str = replace(str, "&", "&amp;");    
            str = replace(str, "<", "&lt;");
            str = replace(str, ">", "&gt;");
            str = replace(str, "\"", "&quot;");
            result = nullString(str);
        }
        return result;
    } 
	
	public static String BackScriptReplace(String str) { 
        String result = "";
        if ( str != null ){        	 
            str = replace(str, "&amp;", "&");    
            str = replace(str, "&lt;", "<");
            str = replace(str, "&gt;", ">");
            str = replace(str, "&quot;", "\"");
            result = nullString(str);
        }
        return result;
    } 
	
	/**
    * 해당 문자열에서 older String 을 newer String 으로 교체한다.
    @param original 전체 String
    @param older 전체 String 중 교체 전 문자 String
    @param newer 전체 String 중 교체 후 문자 String
    @return result 교체된 문자열을 반환함
    */
    public static String replace(String original, String older, String newer) { 
        String result = original;
        
        if ( original != null ) { 
            int idx = result.indexOf(older);
            int newLength = newer.length();

            while ( idx >= 0 ) { 
                if ( idx == 0 ) { 
                    result = newer + result.substring(older.length() );
                }else { 
                    result = result.substring(0, idx) + newer + result.substring(idx + older.length() );
                }
                idx = result.indexOf(older, idx + newLength);
            }
        }

        return result;
    }
}
