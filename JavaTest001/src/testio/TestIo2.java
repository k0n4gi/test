package testio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestIo2 {

	public static void main(String[] args) throws IOException 
	{
		// 파일로드
		File file = new File("C:\\Users\\user\\Desktop\\학생공유\\test_io_file.txt");
		// 파일의 열을 읽음
		List<String> lines = Files.readAllLines(file.toPath());
		
		List<int[]> arrayForEachLine = new ArrayList<int[]>(lines.size());
		for (String line : lines) 
		{
			//생성한 배열을 출력
			int[] array = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
			
			arrayForEachLine.add(array);
		}
		//출력
		arrayForEachLine.stream().map(array -> Arrays.toString(array)).forEach(System.out::println);
	}

}
