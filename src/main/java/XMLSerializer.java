import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLSerializer {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("xmlUser");
        user.setPassWord("xmlPass");
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String xmlString = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(new File("User.xml"),user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            User userFromXML = mapper.readValue(new File("User.xml"), User.class);
            System.out.println("Read from XML: ");
            System.out.println(userFromXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
