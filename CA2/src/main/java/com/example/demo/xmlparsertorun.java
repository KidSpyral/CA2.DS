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

public class xmlparsertorun {

	public static void main(String argv[]) throws IOException, ParserConfigurationException, SAXException {

		File xmlFile = new File("C:/Users/kidsp/Downloads/GasEmissions.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList rows = doc.getElementsByTagName("Row");

		int validEntries = 0;

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
						validEntries++;

						System.out.println("Category: " + category);
						System.out.println("Year: " + year);
						System.out.println("Scenario: " + scenario);
						System.out.println("Gas Units: " + gasUnits);
						System.out.println("NK: " + nk);
						System.out.println("Value: " + value);
						System.out.println("                ");
					}
				}
			}
		}

		System.out.println("\nTotal valid entries: " + validEntries);
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