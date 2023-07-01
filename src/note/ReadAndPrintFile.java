package note;

import java.io.*;

public class ReadAndPrintFile {

    public static void main(String[] args) {
        try {
            String fileName = "文本映射关系.txt"; // 相对于当前类的路径
            InputStream inputStream = ReadAndPrintFile.class.getResourceAsStream(fileName);
            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String line = bufferedReader.readLine();
                while (line!= null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            } else {
                System.out.println("找不到文件：" + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}