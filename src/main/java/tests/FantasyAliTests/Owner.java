package tests.FantasyAliTests;

public class Owner {
    String name;
    int age;
    String nation;
    OwnerAddress address;

    public Owner(String str, int i, String str1, OwnerAddress address) {
        this.name = str;
        this.age = i;
        this.nation = str1;
        this.address = address;
    }

    public static class OwnerAddress{
        String street;
        int number;
        String state;
        int zipcode;

        public OwnerAddress(String str, int i, String str1, int i1) {
            this.street = str;
            this.number = i;
            this.state = str1;
            this.zipcode = i1;
        }
    }

}
