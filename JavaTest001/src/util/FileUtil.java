package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/**
	 * file path의 내용을 라인별로 ArraList<String> 형으로 반환한다.
	 * @param path 읽을 파일의 path
	 * @return
	 * @throws Exception
	 */
	
	public static ArrayList<String> getArrayStringByFilePath(String path) throws Exception{
		// 1. 파일 객체 생성
		File file = new File(path);
		// 입력 스트림 생성
		FileReader file_reader = new FileReader(file);
		// 스트림으로 입력 버퍼를 생성
		BufferedReader buffer_reader = new BufferedReader(file_reader);

		ArrayList<String> lines = new ArrayList<String>();
		String line = "";
		// 2. 텍스트 내용을 한 줄씩 읽어와 lines에 담고 추가함
		while ((line = buffer_reader.readLine()) != null) {
			//String re = line.replaceAll("[HLX]", "");
			lines.add(line);
		}
		
		buffer_reader.close();
		return lines;
	}
}
