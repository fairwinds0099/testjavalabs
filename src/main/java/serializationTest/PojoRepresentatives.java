package serializationTest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoRepresentatives {
        private String district;
        private String name;
        private String party;



        public String getDistrict() {

                return district;
        }

        public void setDistrict(String district) {

                this.district = district;
        }

        public String getName() {

                return name;
        }

        public void setName(String name) {

                this.name = name;
        }

        public String getParty() {

                return party;
        }

        public void setParty(String party) {

                this.party = party;
        }

}
