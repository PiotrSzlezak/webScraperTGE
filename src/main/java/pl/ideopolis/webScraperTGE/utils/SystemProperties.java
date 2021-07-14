package pl.ideopolis.webScraperTGE.utils;

public class SystemProperties {

    private static String resourcePath;
    private static final String osName = System.getProperty("os.name");

    public static String getPath() {
        System.out.println("os name = "+osName);
        switch(osName){
            case "Linux": resourcePath = "/media/piotr/Data/Dane synoptyczne/";
            break;
            case "Windows 10": resourcePath = "D:/Dane synoptyczne/";
            break;
        }
        return resourcePath;
    }
}
