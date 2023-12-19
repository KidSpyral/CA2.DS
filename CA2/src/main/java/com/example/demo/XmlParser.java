package com.example.demo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.example.demo.repository.GasEmissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class XmlParser implements CommandLineRunner {

    @Autowired
    private GasEmissionRepository gasEmissionRepository;

    @Override
    public void run(String... args) throws Exception {
        File xmlFile = new File("C:/Users/kidsp/Downloads/GasEmissions.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        NodeList rows = doc.getElementsByTagName("Row");

        for (int i = 0; i < rows.getLength(); i++) {
            Node row = rows.item(i);

            if (row.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) row;
                int year = getIntContent(elem, "Year");
                String scenario = getTextContent(elem, "Scenario");
                String valueStr = getTextContent(elem, "Value");

                if (!valueStr.isEmpty()) {
                    double value = Double.parseDouble(valueStr);
                    String category = getTextContent(elem, "Category__1_3");
                    String gasUnits = getTextContent(elem, "Gas___Units");
                    String nk = getTextContent(elem, "NK");

                    if (value > 0 && scenario.equals("WEM") && year == 2023) {
                        GasEmission gasEmission = new GasEmission(category, year, scenario, gasUnits, nk, value);
                        gasEmissionRepository.save(gasEmission);
                    }
                }
            }
        }
    }

    private static String getTextContent(Element elem, String tagName) {
        Node node = elem.getElementsByTagName(tagName).item(0);
        return (node != null) ? node.getTextContent() : "";
    }

    private static int getIntContent(Element elem, String tagName) {
        String content = getTextContent(elem, tagName);
        return (content.isEmpty()) ? 0 : Integer.parseInt(content);
    }
}
