package schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AddressesDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("street")
    private String street;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("contactId")
    private int contactId;

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getId(){
        return id;
    }

    public String getCity(){
        return city;
    }

    public String getCountry(){
        return country;
    }

    public String getStreet(){
        return street;
    }
    public String getZip(){
        return zip;
    }
    public int getContactId(){
        return contactId;
    }
}
