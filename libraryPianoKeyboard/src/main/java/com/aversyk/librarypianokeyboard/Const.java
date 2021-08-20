package com.aversyk.librarypianokeyboard;

/**
 * Created by Averysk
 */
public class Const {
    // 白键上字体的样式1: 排放
    public static final String[] RANGE = {"A0", "B0",
            "C1", "D1", "E1", "F1", "G1", "A1", "B1",
            "C2", "D2", "E2", "F2", "G2", "A2", "B2",
            "C3", "D3", "E3", "F3", "G3", "A3", "B3",
            "C4", "D4", "E4", "F4", "G4", "A4", "B4",
            "C5", "D5", "E5", "F5", "G5", "A5", "B5",
            "C6", "D6", "E6", "F6", "G6", "A6", "B6",
            "C7", "D7", "E7", "F7", "G7", "A7", "B7",
            "C8"};
    // 白键上字体的样式2: 发音
    public static final String[] PRONUNCIATION = {"la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do", "re", "mi", "fa", "sol", "la", "si",
            "do"};
    // 白键上字体的样式3: 发音(首字母大写)
    public static final String[] PRONUNCIATION_INIT_CAP = {"La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do", "Re", "Mi", "Fa", "Sol", "La", "Si",
            "Do"};
    // 黑键位置
    public static final int[] GAPS = {0,
            2, 3, 5, 6, 7,
            9, 10, 12, 13, 14,
            16, 17, 19, 20, 21,
            23, 24, 26, 27, 28,
            30, 31, 33, 34, 35,
            37, 38, 40, 41, 42,
            44, 45, 47, 48, 49};
    // 白键Code
    public static final int[] WHITEKEY_CODE = {1, 3,
            4, 6, 8, 9, 11, 13, 15,
            16, 18, 20, 21, 23, 25, 27,
            28, 30, 32, 33, 35, 37, 39,
            40, 42, 44, 45, 47, 49, 51,
            52, 54, 56, 57, 59, 61, 63,
            64, 66, 68, 69, 71, 73, 75,
            76, 78, 80, 81, 83, 85, 87,
            88};
    // 黑键Code
    public static final int[] BLACKKEY_CODE = {2,
            5, 7, 10, 12, 14,
            17, 19, 22, 24, 26,
            29, 31, 34, 36, 38,
            41, 43 ,46 ,48 ,50,
            53 ,55 ,58 ,60 ,62,
            65 ,67 ,70 ,72 ,74,
            77 ,79 ,82 ,84 ,86};
}
