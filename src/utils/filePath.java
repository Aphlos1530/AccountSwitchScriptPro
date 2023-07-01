package utils;

import java.io.File;

public class filePath {

    public static String getTruePath(String filePath) {

        // Inner
        if (fileExist("../../../../revolve")) return "../../../../" + filePath;
        if (fileExist("../../../revolve")) return "../../../" + filePath;
        if (fileExist("../../revolve")) return "../../" + filePath;
        if (fileExist("../revolve")) return "../" + filePath;
        if (fileExist("revolve")) return filePath;

        // Outer
        if (fileExist("ASS/revolve")) return "ASS/" + filePath;
        if (fileExist("AccountSwitchScriptPro/revolve")) return "AccountSwitchScriptPro/" + filePath;

        return filePath;

    }

    private static Boolean fileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

}
