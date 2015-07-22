package com.fsnip.platform.global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

	public static String removeHtmlTag(String htmlStr) {
		if(htmlStr == null){
			return "";
		}
		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}

	/**
	 * 单引号转义，'转换为\'
	 * @param str
	 * @return
	 */
	public static String addSlashes(String str){
		if(str == null){
			return null;
		}
		return str.replace("'", "\'").replace("\"", "\\\"").replace("\\", "\\\\");
	}
	
	/**
	 * 去掉转义后的\'为'
	 * @param str
	 * @return
	 */
	public static String stripSlashes(String str){
		if(str == null){
			return null;
		}
		return str;
	}
	
	/**
	 * 将危险的脚本符号转义
	 * @param str
	 * @return
	 */
	public static String replaceHtmlScript(String str){
		if(str == null){
			return null;
		}
		return str.replace("<", "&lt;").replace(">", "&gt; ");
	}
	
	/**
	 * 过滤不安全的字符信息
	 * @param str
	 * @return
	 */
	public static String securityFilter(String str){
		if(str == null){
			return null;
		}
		return addSlashes(replaceHtmlScript(str));
	}
	
	/**
	 * 将字符串进行截取
	 * @param str
	 * @param start
	 * @param length
	 * @param isSuffix
	 * @return
	 */
	public static String subStr(String str, int start, int length, boolean isSuffix){
		if(str == null){
			return "";
		}
		
		String s = "";
		if(str.length() > length){
			s = str.substring(start, length);
			if(isSuffix){
				s += "...";
			}
			return s;
		}
		
		return str;
	}
	
	
	
	public static void main(String[] args) {
		String s = "<p><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 14px; line-height: 21px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 18px;\">婴儿水疗</span></span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; line-height: 26px; font-size: 18px; background-color: rgb(255, 255, 255);\"><span style=\"line-height: 27px;\">法，就是运用水的温度及物理特性，来达到预防和治疗疾病为目的的一种保健手段。</span></span><br/></p><p><span style=\"color: rgb(51, 51, 51); font-family: 宋体; line-height: 26px; font-size: 18px; background-color: rgb(255, 255, 255);\"><span style=\"line-height: 27px;\">&nbsp; &nbsp; 婴儿水疗</span></span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; line-height: 26px; font-size: 18px; background-color: rgb(255, 255, 255);\"><span style=\"line-height: 27px;\">法适合于健康婴幼儿的保健，脑潜能开发和对肢体运动功能障碍，关节挛缩和肌张力增高等病症治疗，通过水疗</span></span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; line-height: 26px; font-size: 18px; background-color: rgb(255, 255, 255);\"><span style=\"line-height: 27px;\">对中枢神经协调障碍，注意力不集中，脑瘫，语言发育迟缓，维生素D缺乏性佝偻病，营养不良，肥胖等多种疾病的患儿和早产儿，高危儿，低出生体重儿等各类生长发育偏离的小儿在常规处理的同时，进行疗程化的水疗。增强免疫能力，提高婴儿睡眠质量，尤其对促进骨骼肌生长发育，呼吸循环，消化吸收有显著效果。</span></span></p><p>&nbsp;</p>";
		System.out.println(HtmlUtil.removeHtmlTag(s));
	}
}
