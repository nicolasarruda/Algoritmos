package exercicio1.documents;

import java.io.File;
import java.util.Scanner;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import exercicio1.validations.Validation;

public class DocumentInput {

	public DocumentInput() {
	}
	
	public String descriptionInput(String description, Scanner sc, Validation validation) {
		while (description == null || description.length() > 40 || description.length() < 0 || description.isBlank()) {
			description = sc.nextLine(); 
			validation.invalidFormatDescriptionMessage(description);
		}
		return description;
	}

	public void createXML(File file, Document doc) throws TransformerException {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(file));
	}

	public void constructTags(Document doc, String line, Element root) {
		Element siteTag = doc.createElement("Site");
		Element text = doc.createElement("Text");
		Text textSite = doc.createTextNode(line);
		text.appendChild(textSite);
		siteTag.appendChild(text);
		root.appendChild(siteTag);
	}

	public void removeItems(NodeList nodes) throws TransformerException {
			Node removeNode = nodes.item(0);
			removeNode.getParentNode().removeChild(removeNode);
	}

	public String getSequenceNumberInput(Node node, String sequenceNumber) {
		
		if(node.getTextContent().substring(2, 3).compareTo(")") == 0) {
			 int parseNumber = Integer.parseInt(node.getTextContent().substring(1, 2)) + 1;
			 sequenceNumber =  String.valueOf(parseNumber);
		 } 
		 
		 if (node.getTextContent().substring(3, 4).compareTo(")") == 0) {
			 int parseNumber = Integer.parseInt(node.getTextContent().substring(1, 3)) + 1;
			 sequenceNumber =  String.valueOf(parseNumber);
		 }
		 
		 if (node.getTextContent().substring(4, 5).compareTo(")") == 0) {
			 int parseNumber = Integer.parseInt(node.getTextContent().substring(1, 4)) + 1;
			 sequenceNumber =  String.valueOf(parseNumber);
		 }
		 
		 return sequenceNumber;
	}

	public String getChildString(String child) {
		final String childValue = child;
		
		if(childValue.substring(2, 3).compareTo(")") == 0) {
			 child = childValue.substring(1, 2);
		 } 
		 
		 if (childValue.substring(3, 4).compareTo(")") == 0) {
			 child = childValue.substring(1, 3);
		 }
		 
		 if (childValue.substring(4, 5).compareTo(")") == 0) {
			 child = childValue.substring(1, 4);
		 }
		 return child;	
	}

	public void editContent(NodeList nodes, int editNumber, Document doc, String line) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node editNode = nodes.item(i);
			if (nodes.item(i) == nodes.item(editNumber)) {
				Element tag = (Element) editNode;
				NodeList nodeText = tag.getElementsByTagName("Text");
				nodeText.item(0).setTextContent(line);
			}
		}
	}
}
