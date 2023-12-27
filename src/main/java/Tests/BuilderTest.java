package Tests;

import Client_Package.Client;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class BuilderTest {
    @Test
    public void testClientBuilder() throws Exception {
        String name = "John Doe";
        String address = "123 Main St";
        int age = 35;
        double phoneNumber = 1234567890;
        Date dateOfBirth = new Date();
        String placeOfBirth = "City";
        Client.ClientBuilder clientBuilder = new Client.ClientBuilder(name);
        clientBuilder.address(address);
        clientBuilder.age(age);
        clientBuilder.phoneNumber(phoneNumber);
        clientBuilder.dateOfBirth(dateOfBirth);
        clientBuilder.placeOfBirth(placeOfBirth);

        Client client = clientBuilder.build();

        assertEquals(name, client.getName());
        assertEquals(address, client.getAddress());
        assertEquals(age, client.getAge());
        assertEquals(phoneNumber, client.getPhoneNumber());
        assertEquals(dateOfBirth, client.getDateOfBirth());
        assertEquals(placeOfBirth, client.getPlaceOfBirth());
    }
}
