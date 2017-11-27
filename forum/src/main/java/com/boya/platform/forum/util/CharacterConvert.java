package com.boya.platform.forum.util;

/**
 * 汉字简繁转换
 * Created by jingzl on 2017/1/29.
 */
public final class CharacterConvert {

    /**
     * 将简体字符串转换为繁体字符串
     * @param words 简体字符串
     * @return 繁体字符串
     */
    public static String toTraditional(String words) {

        StringBuilder convert_words = new StringBuilder();

        for (int i = 0; i < words.length(); i++) {
            // 取字符
            char tempChar = words.charAt(i);
            // 从Map中获取对应的繁体
            Character character = Characters.getInstance().getCharSimplifiedMap().get(tempChar);
            // 转换字符
            char cnChar;
            if (character == null) {
                cnChar = tempChar;
            } else {
                cnChar = character;
            }
            // 组新字符串
            convert_words.append(cnChar);
        }

        return convert_words.toString();
    }

    /**
     * 将繁体字符串转换为简体字符串
     * @param words 繁体字符串
     * @return 简体字符串
     */
    public static String toSimplified(String words) {
        StringBuilder convert_words = new StringBuilder();

        for (int i = 0; i < words.length(); i++) {
            // 取字符
            char tempChar = words.charAt(i);
            // 从Map中获取对应的简体
            Character character = Characters.getInstance().getCharTraditionalMap().get(tempChar);
            // 转换字符
            char cnChar;
            if (character == null) {
                cnChar = tempChar;
            } else {
                cnChar = character;
            }
            // 组新字符串
            convert_words.append(cnChar);
        }

        return convert_words.toString();
    }


}
