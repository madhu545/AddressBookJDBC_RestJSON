import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddressBookDBTest {

    @Test
    void giveDataFromADatabase_WhenRetrieved_ShouldMatchTheCount() throws CustomException {
        List<Data> contactDetails;
        AddressBookDB addressBookDB = new AddressBookDB();
        contactDetails = addressBookDB.getAllDetailsFromTable();
        System.out.println(contactDetails.size());
        Assertions.assertEquals(7, contactDetails.size());
    }

    @Test
    void givenNewSalary_WhenUpdated_ShouldPassTestAndBeInSync() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        int result = addressBookDB.updateContactDetailsInDB("Madhu", "8247473242");
        Assertions.assertEquals(1, result);
    }

    @Test
    void givenCityNaME_WhenFound_ShouldReturnNoOfContactsFromGivenCity() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        contactDetails = addressBookDB.getContactDetailsAccordingToCity("Kondapur");
        Assertions.assertEquals(2, contactDetails.size());
    }

    @Test
    void givenCityNaME_WhenFound_ShouldReturnNoOfContactsFromGivenState() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        contactDetails = addressBookDB.getContactDetailsAccordingToState("Telangana");
        Assertions.assertEquals(4, contactDetails.size());
    }

    @Test
    void givenANewEntry_WhenQueryExecuted_ShouldAddNewContactInDB() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        addressBookDB.addNewContactToDB("madhu", "Sudhan", "Kondapur", "Hyderabad",  "Telangana", 500032, 8247473242, "madhu@gmail.com","friend",  10,"contact 11");
        contactDetails = addressBookDB.getAllDetailsFromTable();
        Assertions.assertEquals(7, contactDetails.size());
    }

    @Test
    void givenMultipleEmployees_WhenAddedToDB_ShouldMatchCount() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDataList;
        Data[]  contactArray = {
                new Data("Madhu", "Sudhan", "Kondapur", "Hyderabad", "Telangana",  500032, 824747, "maddy@gmail.com",8,"family","contact5"),
                new Data("Madhu", "Sudhan", "Kondapur", "Hyderabad", "Telangana",  500032, 824747, "maddy@gmail.com",11,"family","contact5"),
                new Data("Madhu", "Sudhan", "Kondapur", "Hyderabad", "Telangana",  500032, 824747, "maddy@gmail.com",12,"family","contact5"),
                new Data("Madhu", "Sudhan", "Kondapur", "Hyderabad", "Telangana",  500032, 824747, "maddy@gmail.com",13,"family","contact5"),
                new Data("Madhu", "Sudhan", "Kondapur", "Hyderabad", "Telangana",  500032, 824747, "maddy@gmail.com",14,"family","contact5"),
        };
        Instant startThread = Instant.now();
        addressBookDB.addMultipleContacts(Arrays.asList(contactArray));
        Instant endThread = Instant.now();
        System.out.println("Time Taken to Execute : " + Duration.between(startThread, endThread));
        contactDataList = addressBookDB.getAllDetailsFromTable();
        Assertions.assertEquals(7, contactDataList.size());
    }
}
