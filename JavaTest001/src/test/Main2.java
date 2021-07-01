package test;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

import java.util.regex.*;

import sun.jvm.hotspot.debugger.posix.elf.ELFException;
import util.FileUtil;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main2 {

	private final static String PATH = "C:\\\\Users\\\\user\\\\Desktop\\\\학생공유\\\\test_io_file.txt";

	public static void main(String[] args) {
		try {

			// 1. 로그파일 호출
			List<String> lines = FileUtil.getArrayStringByFilePath(PATH);

			List<HashMap> hmList = new ArrayList<>();
			
			// 1-1 중복 개수 추출
			for(String line : lines) {
				boolean contain = false;
				for(HashMap hm : hmList) {
					if(hm.get("line").toString().equals(line)) {
						int count = Integer.valueOf(hm.get("count").toString());
						hm.put("count", ++count);
						contain = true;
						break;
					}
				}
				if(!contain) {
					HashMap hm = new HashMap<>();
					hm.put("count", 0);
					hm.put("line", line);
					hmList.add(hm);
				}
			}
			/*
			for(HashMap hm : hmList) {
				System.out.println("count : " + hm.get("count").toString() + "  line : " + hm.get("line").toString());
			}

			System.exit(0);
			*/
			// 3. 중복 제거
			LinkedHashSet<String> hashSet = new LinkedHashSet<>();
			for (String overlap : lines) {
				hashSet.add(overlap);
			}
			
			Iterator it = hashSet.iterator();
			List<String> lineList = new ArrayList<String>();
			while(it.hasNext()) {
				lineList.add(it.next().toString());
			}
			//System.out.println(lineList.toString());
			
			// 2. 문자 치환
			for (int i = 0; i < lines.size(); i++) {
				lines.set(i, lines.get(i).replaceAll("[HLX]", ""));
			}
			// a,b 분류
			
			for (int i = 0; i < lineList.size(); i++) {
				String txt = lineList.get(i);
				int count = countChar(txt, '1');
				String head = "";
				if(count % 2 == 1)
				{
					head = "a";
					//System.out.println('a');
				}
				else if(count % 2 == 0)
				{
					//System.out.println('b');
					head = "b";
				}
				String countStr = "";
				for(HashMap hm : hmList) {
					if(hm.get("line").toString().equals(txt)) {
						countStr = hm.get("count").toString().replace("0", "");
						break;
					}
				}
				System.out.println(head + countStr + " " + txt);
			}
			
			//System.out.println(hashSet);

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
