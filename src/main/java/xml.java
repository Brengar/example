import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class xml {

    public static boolean check(List<String> arg) {
        boolean isFinded=false;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("otherxml.xml");

            Node root = document.getDocumentElement();

            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    if (book.getNodeType() != Node.TEXT_NODE) {
                        NodeList bookProps = book.getChildNodes();
                        if(arg.get(1).equals(bookProps.item(1).getTextContent())){
                            isFinded=true;
                            for(int j = 0; j < bookProps.getLength(); j++) {
                                Node bookProp = bookProps.item(j);
                                if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                    if (!arg.get(j).equals(bookProp.getChildNodes().item(0).getTextContent())) return false;
                                }
                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return isFinded;
    }

    public static void write(List<String> arg) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("xml.xml");

            addNewBook(document,arg);

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void addNewBook(Document document,List<String> arg) throws TransformerFactoryConfigurationError, DOMException {
        Node root = document.getDocumentElement();

        Element book = document.createElement("Book");
        Element title = document.createElement("Title");
        title.setTextContent(arg.get(0));
        Element author = document.createElement("Author");
        author.setTextContent(arg.get(1));
        Element date = document.createElement("Date");
        date.setTextContent(arg.get(2));
        Element isbn = document.createElement("ISBN");
        isbn.setTextContent(arg.get(3));
        Element publisher = document.createElement("Publisher");
        publisher.setTextContent(arg.get(4));
        Element cost = document.createElement("Cost");
        cost.setTextContent(arg.get(5));
        cost.setAttribute("currency", arg.get(6));

        book.appendChild(title);
        book.appendChild(author);
        book.appendChild(date);
        book.appendChild(isbn);
        book.appendChild(publisher);
        book.appendChild(cost);

        root.appendChild(book);

        writeDocument(document);
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("otherxml.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

}