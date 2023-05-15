package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02FileTest {
	public static void main(String[] args) {
		
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");

		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		} else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");

			try {
				if (f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "파일을 새로 만들었습니다.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if (f2.exists()) {
				System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
			} else {
				System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
			}
			System.out.println("---------------------------");
		
		File f3 = new File("d:/D_Other");
		File[] file = f3.listFiles();
		for (File f : file) {
			System.out.print(f.getName() + " => ");
			if (f.isFile()) {
				System.out.println("파일");
			} else if (f.isDirectory()) {
				System.out.println("디렉토리 (폴더)");
			}

		}
		System.out.println("==============================");
		String[] strFiles = f3.list();
		for (String str : strFiles) {
			System.out.println(str);

		}
		System.out.println("--------------------------------");
		System.out.println();
		
		displayFileList(new File("d:/D_Other"));
	}

	/**
	 * 지정된 디렉토리 (폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	 */
	public static void displayFileList(File dir){
		System.out.println("[" + dir.getAbsolutePath() + "]디렉토리의 내용");

		// 디렉토리 안의 모든 파일 정보를 가져온다.
		File[] files = dir.listFiles();

		// 하위의 디렉토리 정보를 저장할 List 객체 생성 (File 배열의 인덱스값 저장)
		List<Integer> subDirList = new ArrayList<Integer>();

		// 날짜를 출력하기 위한 문자 포맷 설정하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		for (int i = 0; i < files.length; i++) {
			String attr = "";// 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = "";// 파일크기

			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirList.add(i);
			} else {
				size = files[i].length() + "";// +""를 해줌으로써 String화 한다.
				attr = files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";
			}

			System.out.printf("%s %5s %12s %s\n", 
					sdf.format(new Date(files[i].lastModified())),
					attr, size,files[i].getName());
		}

		int dirCount = subDirList.size();
		int fileCount = files.length - dirCount;

		System.out.println(fileCount + "개의 파일," 
						+ dirCount + "개의 디렉토리(폴더)");
		System.out.println();

		
	}
}
