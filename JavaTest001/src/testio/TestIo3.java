package testio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestIo3 {
	public void test() {

		try {

			// file을 가져와 file 객체 생성 ( '\'가 아닌 '/'임을 명심 )
			File aText = new File("C:\\Users\\user\\Desktop\\학생공유\\test_io_file.txt");

			// file 입력 스트림을 생성
			FileReader aReader = new FileReader(aText);

			// 스트림으로 입력 버퍼를 생성
			BufferedReader aBufReader = new BufferedReader(aReader);

			List<String> aLines = new ArrayList<String>();

			String aLine = "";

			// 텍스트 내용을 한 줄씩 읽어와 aLine에 담고, 이를 aLines에 add 함.
			while ((aLine = aBufReader.readLine()) != null) {
				aLines.add(aLine);
			}

			// 버퍼를 닫아줌 ( 파일을 닫아줌 )
			aBufReader.close();

			for (int i = 0; i < aLines.size(); i++) {
				System.out.println(i + " 번 행 데이터 : " + aLines.get(i));
			}

		} catch (Exception e) {
			// TODO
		}
	}
}