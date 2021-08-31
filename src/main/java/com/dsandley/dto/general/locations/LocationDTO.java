package com.dsandley.dto.general.locations;

public class LocationDTO {
      private String name;
      private String country;
      private String state;
      private String city ;
      private String zipcode;

      public LocationDTO (String name, String country, String state, String city, String zipcode){
          this.name = name;
          this.country = country;
          this.state = state;
          this.city = city;
          this.zipcode = zipcode;
      }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
