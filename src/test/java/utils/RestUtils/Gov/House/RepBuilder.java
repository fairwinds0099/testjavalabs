package utils.RestUtils.Gov.House;

public class RepBuilder {
    private String district;
    private String name;
    private String party;
    private String officeRoom;
    private String phone;
    private String committee;

        public static class Builder {
            private String district;
            private String name;
            private String party;
            private String officeRoom;
            private String phone;
            private String committee;

            public Builder(String district, String name, String party) {
                this.district = district;
                this.name = name;
                this.party = party;
            }

            public Builder setOfficeRoom(String office) {
                this.officeRoom = office;
                return this;
            }

            public Builder setPhone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder setCommitte(String committee) {
                this.committee = committee;
                return this;
            }

            public RepBuilder build(){
                return new RepBuilder(this);
            }
        }

            public RepBuilder(Builder builder){
            district = builder.district;
            name = builder.name;
            party = builder.party;
            officeRoom = builder.officeRoom;
            phone = builder.phone;
            committee = builder.committee;
        }
}
