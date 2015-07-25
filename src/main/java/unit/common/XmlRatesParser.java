package unit.common;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

public class XmlRatesParser {

    private static URL url;
    private static ArrayList<String> ratesList;

    public static ArrayList parseXml(String xmlToParse, String bankId){

        ratesList = new ArrayList<String>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputSource is = new InputSource(new StringReader(xmlToParse));

            Document doc = builder.parse(is);

            Element rootel = doc.getDocumentElement();

            NodeList organization = rootel.getElementsByTagName("organization");

            for (int i = 0; i < organization.getLength(); i++) {

                Element labTest = (Element) organization.item(i);
                String organizationId = organization.item(i).getAttributes().getNamedItem("id").getNodeValue();
                NodeList coursesTotal = labTest.getElementsByTagName("currencies");

                if (StringUtils.equals(organizationId, bankId)) {
                    for (int j = 0; j < coursesTotal.getLength(); j++) {
                        Element test = (Element) coursesTotal.item(j);
                        NodeList coursesDetail = test.getElementsByTagName("c");

                        for (int k = 0; k < coursesDetail.getLength(); ++k) {

                            Element condition = (Element) coursesDetail.item(k);

                            String value = condition.getAttributes().getNamedItem("id").getNodeValue();
                            String valueCourse1 = condition.getAttributes().getNamedItem("br").getNodeValue();
                            String valueCourse2 = condition.getAttributes().getNamedItem("ar").getNodeValue();

                            ratesList.add(value);
                            ratesList.add(valueCourse1);
                            ratesList.add(valueCourse2);
                        }
                    }
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ratesList;
    }
}
