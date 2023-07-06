package auto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinkParser4 {

    public static void main(String[] args) {
        String filePath = "path/to/your/file.lnk";
        filePath = "D:\\Eval\\Desktop\\原神.lnk";
        parseLinkInfo(filePath);
    }

    public static void parseLinkInfo(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] linkBytes = Files.readAllBytes(path);
            // Check if it is a valid shortcut file
            if (linkBytes.length >= 76 && linkBytes[0] == 0x4C && linkBytes[1] == 0x00
                    && linkBytes[2] == 0x00 && linkBytes[3] == 0x00) {//0000004C(H)
                // Get the offset of Link Info structure
                int linkInfoOffset = bytesToShort(linkBytes, 0x14);
                // Get the size of Link Info structure
                int linkInfoSize = bytesToInt(linkBytes, 0x10);
                // Calculate the start and end position of Link Info structure
                int linkInfoStart = linkInfoOffset + 0x14;
                int linkInfoEnd = linkInfoStart + linkInfoSize;
                // Parse the Link Info structure
                byte[] linkInfoBytes = new byte[linkInfoSize];
                System.arraycopy(linkBytes, linkInfoStart, linkInfoBytes, 0, linkInfoSize);
                // Extract relevant information from Link Info structure
                String targetPath = parseTargetPath(linkInfoBytes);
                System.out.println("快捷方式的目标路径: " + targetPath);
            } else {
                System.out.println("不是有效的快捷方式文件。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseTargetPath(byte[] linkInfoBytes) {
        // Extract the target path from Link Info structure
        int flags = bytesToInt(linkInfoBytes, 0x14);
        int targetPathOffset = 0x1C;
        if ((flags & 0x01) == 1) {
            targetPathOffset += 0x04;
        }
        int targetPathLength = bytesToInt(linkInfoBytes, targetPathOffset);
        byte[] targetPathBytes = new byte[targetPathLength];
        System.arraycopy(linkInfoBytes, targetPathOffset + 0x04, targetPathBytes, 0, targetPathLength);
        return new String(targetPathBytes);
    }

    private static int bytesToInt(byte[] bytes, int offset) {
        return ((bytes[offset + 3] & 0xFF) << 24) | ((bytes[offset + 2] & 0xFF) << 16)
                | ((bytes[offset + 1] & 0xFF) << 8) | (bytes[offset] & 0xFF);
    }

    private static int bytesToShort(byte[] bytes, int offset) {
        return ((bytes[offset + 1] & 0xFF) << 8) | (bytes[offset] & 0xFF);
    }
}