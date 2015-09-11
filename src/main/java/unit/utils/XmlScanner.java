package unit.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class XmlScanner {

    private static URL url;
    public static String xml = null;

    public static String parsePathXml() {
        try {
            url = new URL("http://resources.finance.ua/ru/public/currency-cash.xml");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            String redirect = connection.getHeaderField("Location");
            if (redirect != null) {
                connection = (HttpURLConnection) new URL(redirect).openConnection();
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            if ((xml = bufferedReader.readLine()) != null) {
                xml = xml.concat(bufferedReader.readLine());
            }
            bufferedReader.close();
            return xml;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.XML_ERROR;
    }
}
