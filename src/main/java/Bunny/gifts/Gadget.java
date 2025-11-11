package Bunny.gifts;


    public class Gadget implements Gift {
        private String name;
        private String type;
        private String model;
        private int batteryLifeHours;
        private String operatingSystem;

        public Gadget(String name, String type, String model) {
            this.name = name;
            this.type = type;
            this.model = model;
            this.batteryLifeHours = (type.contains("smartwatch") ? 72 : 8);
            this.operatingSystem = (type.contains("console") ? "CustomOS" : "Android");
        }

        @Override
        public String describe() {
            return this.type + " (" + this.name + ", Model: " + this.model + ")";
        }
    }
