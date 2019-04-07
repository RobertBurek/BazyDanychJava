package jpa.domain;

import javax.persistence.Embeddable;

/**
 * Created by Robert Burek
 */
@Embeddable
public class Address {

    private String street;
    private String apartment;
    private String postalCode;
    private String city;

    public Address(String street, String apartment, String postalCode, String city) {
        this.street = street;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", apartment='" + apartment + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
