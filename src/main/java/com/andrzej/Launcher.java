package com.andrzej;

public class Launcher {
    public static void main (String[] args){
        Hotel hotel = new Hotel();
        UserService service = new UserService(hotel);
        Controller controller = new Controller(service);
        controller.start();
    }
}
