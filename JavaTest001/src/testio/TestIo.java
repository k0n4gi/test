package testio;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

import java.util.regex.*;

import util.FileUtil;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class TestIo {

	private final static String PATH = "C:\\\\Users\\\\user\\\\Desktop\\\\학생공유\\\\test_io_file.txt";

	public static void main(String[] args) {
		try {

			// 1. 로그파일 호출
			List<String> lines = FileUtil.getArrayStringByFilePath(PATH);

			// 2. 문자 치환
			for (int i = 0; i < lines.size(); i++) {
				lines.set(i, lines.get(i).replaceAll("[HLX]", ""));
			}

			// 3. 중복 제거
			LinkedHashSet<String> hashSet = new LinkedHashSet<>();
			for (String overlap : lines) {
				hashSet.add(overlap);

			}
			// a,b 분류
			for (int i = 0; i < hashSet.size(); i++) {
				int count = countChar(hashSet.contains('1'));
				if(count % 2 == 1)
				{
					System.out.println('a');
				}
				else if(count % 2 == 0)
				{
					System.out.println('b');
				}
			}
			System.out.println(hashSet);

		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static int countChar(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

}
