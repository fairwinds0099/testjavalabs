package domain;

/*public enum States {
    Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky,
    Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, Nevada, NewHampshire, NewJersey, NewMexico, NewYork,
    NorthCarolina, NorthDakota, Ohio, Oklahoma, Oregon, Pennsylvania, RhodeIsland, SouthCarolina, SouthDakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington,
    WestVirginia, Wisconsin, Wyoming;
}*/

    enum StatesShort {
        AL("Alabama"), AK("Alaska"), AZ("Arizona"), AR("Arkansas"), CA("California"), CO("Colorado"), CT("Connecticut"), DE("Delaware"), FL("Florida"), GA("Georgia"),
        HI("Hawaii"), ID("Idaho"), IL("Illinois"), IN("Indiana");

        private final String state;

        StatesShort(String st) {
            this.state = st;
        }

        public String getState() {
        return this.state;
        }
    }
//TODO bunu yap boyle
//TODO enum StateCode olsun, sadece kisaltmalari yaz. StateCode.AL yazacaksin teste ama senin kodun Alabama kelimesini cekecek. Kendime prblem alani ariyordum birtane, he tamam.
