package lt.viko.eif.kostenko.hostelapp.util;

import lt.viko.eif.kostenko.hostelapp.menu.Menu;
import lt.viko.eif.kostenko.hostelapp.model.Hostel;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Utility class for JAXB (Java Architecture for XML Binding) operations.
 * This class provides methods for converting objects to XML, XML to POJO,
 * and generating XSD (XML Schema Definition).
 */
public class JaxbUtilGeneric {

    /**
     * Private constructor to prevent instantiation
     */
    private  JaxbUtilGeneric(){
    }

    /**
     * Converts the specified object to XML ( Extensible Markup Language) format.
     * @param object The object to be converted to XML.
     * @param <T>    The type of the object.
     */
    public static <T> void convertToXML(T object){
        try{
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
            OutputStream os = new FileOutputStream("generated.xml");
            marshaller.marshal(object, System.out);
            marshaller.marshal(object, os);

        }catch (FileNotFoundException | JAXBException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Converts XML file to POJO (Plain Old Java Object).
     * @param xmlFilePath The path of the XML file to be converted.
     * @param type        The class type of the resulting POJO.
     * @param <T>         The type of the resulting POJO.
     * @return The POJO converted from the XML file.
     */
    public static <T> T convertToPOJO(String xmlFilePath, Class<T> type) {
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File(xmlFilePath);
            return type.cast(unmarshaller.unmarshal(xmlFile));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Generates an XSD (XML Schema Definition) for the specified class.
     * @param clazz The class for which XSD is to be generated.
     * @param <T>   The type of the class.
     */
    public static <T> void generateXSD(Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            jaxbContext.generateSchema(new SchemaOutputResolver() {

                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    File file = new File("generated.xsd");
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.toURI().toURL().toString());
                    return result;
                }
            });
            BufferedReader reader = new BufferedReader(new FileReader("generated.xsd"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
