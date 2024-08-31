package Semana3.Builder;

public class Plane {
    private String engineType;
    private Double wingspan;
    private Integer capacity;
    private boolean isComercial;
    private boolean hasAutoPilot;

    private Plane(PlaneBuilder builder){
        this.engineType = builder.engineType;
        this.wingspan = builder.wingspan;
        this.capacity = builder.capacity;
        this.isComercial = builder.isComercial;
        this.hasAutoPilot = builder.hasAutoPilot;
    }

    @Override
    public String toString(){
        return "Plane [engineType=" + engineType + ", wingspan=" + wingspan + ", seatingCapacity=" + capacity +
        ", is a comercial plane=" + isComercial + ", hasAutopilot=" + hasAutoPilot + "]";
    }

    public static class PlaneBuilder{
        private String engineType;
        private Double wingspan;
        private Integer capacity;
        private boolean isComercial;
        private boolean hasAutoPilot;

        public PlaneBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public PlaneBuilder setWingspan(double wingspan) {
            this.wingspan = wingspan;
            return this;
        }

        public PlaneBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public PlaneBuilder setIsComercial(boolean isComercial){
            this.isComercial = isComercial;
            return this;
        }

        public PlaneBuilder setHasAutoPilot(boolean hasAutoPilot){
            this.hasAutoPilot = hasAutoPilot;
            return this;
        }

        public Plane build(){
            return new Plane(this);
        }

    }

}
