package Semana3.Builder;

public class Main {

    public static void main(String[] args) {

        Plane Boeing777 = new Plane.PlaneBuilder()
            .setEngineType("GE90")
            .setWingspan(64.8)
            .setCapacity(301)
            .setIsComercial(true)
            .setHasAutoPilot(true)
            .build();

        System.out.println(Boeing777);


        Plane privateJet = new Plane.PlaneBuilder()
        .setEngineType("PW800")
        .setWingspan(10)
        .setCapacity(20)
        .setHasAutoPilot(true)
        .build();

        System.out.println(privateJet);

    }
}
