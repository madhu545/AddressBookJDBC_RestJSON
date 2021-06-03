import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
class CreatingJSONDocument {
    public static void main(String args[]) throws JSONException {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Madhu");
        jsonObject.put("Last_Name", "Sudhan");
        jsonObject.put("Date_Of_Birth", "1997-09-05");
        jsonObject.put("Place_Of_Birth", "Telangana");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter("C:\\Users\\ADMIN\\REST assured\\AddressBook_JDBC\\src\\main\\resources\\Addressbook.json");
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
