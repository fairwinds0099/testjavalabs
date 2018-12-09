package tests.FantasyAliTests;

public class Restaurant {
    private String name;
    Owner owner;
    RestaurantStaff staff;
    RestaurantStaff staff1;

    public Restaurant(String str, Owner owner, RestaurantStaff staff, RestaurantStaff staff1) {
        this.name = str;
        this.owner = owner;
        this.staff = staff;
        this.staff1 = staff1;
    }

    //public class RestaurantOwner {
     //   Owner owner;
      //  Owner.OwnerAddress ownerAddress;
   // }
    public static class RestaurantStaff {
        String name;
        int age;
        double salary;

        public RestaurantStaff(String str, int i, double v) {
            this.name = str;
            this.age = i;
            this.salary = v;
        }

    }
}
