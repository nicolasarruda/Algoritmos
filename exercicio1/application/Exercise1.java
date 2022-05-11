package exercicio1.application;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import exercicio1.documents.DocumentInput;
import exercicio1.formats.ExerciseFormat;
import exercicio1.validations.Validation;

public class Exercise1 {

	private static final String PATH = "C:\\Users\\Nícolas\\Desktop\\";
	private static final String XML = "siteMarks.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, TransformerException, SAXException, IOException {
		Scanner sc = new Scanner(System.in);
		char operator = 0;
		String path = PATH;
		String archiveXML = XML;
		File file = new File(path + archiveXML);
		ExerciseFormat format = new ExerciseFormat();
		Validation validation = new Validation();
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.newDocument();
		DocumentInput docInput = new DocumentInput();

		do {

			System.out.println("\nSiteMarks - (" + path + archiveXML + ")");

			if (file.exists()) {
				doc = builder.parse(file);
				doc.getDocumentElement().normalize();
				NodeList nodes = doc.getElementsByTagName("Site");

				for (int i = 0; i < nodes.getLength(); i++) {
					Node node = nodes.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element textTag = (Element) node;
						System.out.println(textTag.getElementsByTagName("Text").item(0).getTextContent());
					}
				}
			}
			System.out.println("\n(A)dd    (E)dit    (R)emove    (Q)uit");

			System.out.print("\nSelect an operation > ");
			operator = sc.next().charAt(0);
			format.skipLine(sc);
			validation.invalidOperationMessage(operator);

			// Add
			if (operator == 'A') {

				// int sequenceNumber = 1;
				String description = null;
				Element root = null;

				if (file.exists()) {
					doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
					root = doc.getDocumentElement();
					NodeList nodes = doc.getElementsByTagName("Site");
					Node node = nodes.item(nodes.getLength() - 1);
					String sequenceNumber = null;
					if (nodes.getLength() != 0) {
						sequenceNumber = docInput.getSequenceNumberInput(node, sequenceNumber);
					}

					System.out.print("\nURL > ");
					String url = sc.nextLine();
					url = format.formatURL(url);

					System.out.print("\nDescription > ");

					description = null;
					description = docInput.descriptionInput(description, sc, validation);
					description = format.formatDescription(sequenceNumber, description);
					String line = description.concat(url);

					// XML
					docInput.constructTags(doc, line, root);
					docInput.createXML(file, doc);

				} else {
					doc = builder.newDocument();
					root = doc.createElement("Sites");
					doc.appendChild(root);

					System.out.print("\nURL > ");
					String url = sc.nextLine();
					url = format.formatURL(url);

					System.out.print("\nDescription > ");

					description = null;
					description = docInput.descriptionInput(description, sc, validation);
					description = format.formatDescription("1", description);
					String line = description.concat(url);

					// XML
					docInput.constructTags(doc, line, root);
					docInput.createXML(file, doc);
				}
			}

			// Edit
			if (operator == 'E') {

				if (file.exists()) {

					doc = builder.parse(file);
					doc.getDocumentElement().normalize();
					NodeList nodes = doc.getElementsByTagName("Sites");
					Node node = nodes.item(0);
					NodeList nodesChild = node.getChildNodes();

					if (nodes.item(0) != null) {
						
						String firstChildNumber = node.getFirstChild().getTextContent();
						String lastChildNumber = node.getLastChild().getTextContent();

						firstChildNumber = docInput.getChildString(firstChildNumber);
						lastChildNumber = docInput.getChildString(lastChildNumber);
						int firstChildNumberInt = Integer.parseInt(firstChildNumber);
						int lastChildNumberInt = Integer.parseInt(lastChildNumber);
						
						int editNumber = 0;
						
						do {
							System.out.print("\nNumber of SiteMark to edit > ");
							try {
								editNumber = sc.nextInt();
							} catch (InputMismatchException e) {
								System.out.println("Invalid number. Please enter a number");
								return;
							}
							validation.invalidNumberMessage(editNumber, firstChildNumberInt, lastChildNumberInt);
						} while (editNumber < firstChildNumberInt || editNumber > lastChildNumberInt);

						format.skipLine(sc);

						System.out.print("\nURL > ");
						String url = sc.nextLine();
						url = format.formatURL(url);

						System.out.print("\nDescription > ");
						String description = null;
						description = docInput.descriptionInput(description, sc, validation);
						description = format.formatDescription(editNumber, description);
						String line = description.concat(url);

						// XML
						
						docInput.editContent(nodesChild, editNumber, doc, line);
						docInput.createXML(file, doc);
						
					} else {
						System.out.println("\nNothing to edit");
					}
				} else {
					System.out.println("This file " + path + archiveXML + " doesn't exist");
				}
			}

			// Remove
			if (operator == 'R') {

				if (file.exists()) {

					doc = builder.parse(file);
					doc.getDocumentElement().normalize();
					NodeList nodes = doc.getElementsByTagName("Sites");
					Node node = nodes.item(0);
					NodeList nodesChild = node.getChildNodes();

					if (nodes.item(0) != null) {

						// Remove;
						docInput.removeItems(nodesChild);

					} else {
						System.out.println("\nNothing to remove");
					}

					// XML
					docInput.createXML(file, doc);

				} else {
					System.out.println("This file " + path + archiveXML + " doesn't exist\n");
				}
			}

		} while (operator != 'Q');

		System.out.println("\nGoodbye!");
	}
}
