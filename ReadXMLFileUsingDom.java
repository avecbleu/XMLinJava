import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;




public class ReadXMLFileUsingDom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try
    {
		
		File xmlDoc = new File("students.xml");
		DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFact.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlDoc);
		
		// read root element
		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
		
		// read array of students elements, this array is called Nodelist
		NodeList nList = doc.getElementsByTagName("student");
		
		for(int i=0; i<nList.getLength();i++)
		{
			Node nNode = nList.item(i);
			System.out.println("Node name" + " " + nNode.getNodeName() + (i+1));
			if(nNode.getNodeType()==Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				System.out.println("Student ID#: " + eElement.getAttribute("idno"));
				System.out.println("Student First name: " +
				        eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Student Last name: " +
						eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Student Score: " +
						eElement.getElementsByTagName("score").item(0).getTextContent());
				System.out.println("---------------------------------------");
				
				
			}
			
		}
	}

    catch (Exception e){
    	
    }
    }
}
