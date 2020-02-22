package com.andrzej;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Scanner reader;
    private UserService userService;
    private boolean running;

    public Controller(UserService userService) {
        reader = new Scanner(System.in);
        this.userService = userService;
        running = true;
    }

    public void start(){
        while (running){
            chooseAndExecuteExceptionHandling();
        }
    }

    private void chooseAndExecuteExceptionHandling(){
        try {
            chooseAndExecute();
        }
        catch (InputMismatchException e){
            System.out.println("Należy wprowadzic liczbe");
            reader = new Scanner(System.in);
        }
    }

    private void chooseAndExecute() {
        printOptions();
        int option = reader.nextInt();
        choose(option);
    }

    private void choose(int option){
        switch (option){
            case 1:
                printRooms(userService.getAllRooms());
                break;
            case 2:
                printRooms(userService.getAllAvailableRooms());
                break;
            case 3:
                bookRoom();
                break;
            case 4:
                releaseRoom();
                break;
            case 5:
                end();
                break;
            default:
                System.out.println("Nieprawidlowy wybor opcji");
                break;
        }
    }

    private void printRooms(List<Room> rooms){
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void end(){
        System.out.println("Konczymy dzialanie progamu");
        running = false;
    }

    private void releaseRoom(){
        List<Room> availableRooms = userService.getAllNotAvailableRooms();
        if (availableRooms.isEmpty()){
            System.out.println("Wszystkie pokoje sa wolne");
            return;
        }
        printRooms(availableRooms);

        int wantedNumber = reader.nextInt();
        boolean isReleased = userService.releaseRoom(wantedNumber);

        if(isReleased){
            System.out.println("Zwolniono pokój");
        }
        else {
            System.out.println("Nie udalo sie zwolnic pokoju");
        }
    }

    private void bookRoom(){
        List<Room> availableRooms = userService.getAllAvailableRooms();
        if (availableRooms.isEmpty()){
            System.out.println("Brak dostepnych pokoi");
            return;
        }
        printRooms(availableRooms);

        int wantedNumber = reader.nextInt();
        boolean isBooked = userService.bookRoom(wantedNumber);

        if(isBooked){
            System.out.println("Zarezerwowano pokój");
        }
        else {
            System.out.println("Nie udalo sie zarezerwowac pokoju");
        }
    }


    private void printOptions(){
        System.out.println("1. Wyswietl liste pokoi wraz z ich statusem(wolny- zajęty)");
        System.out.println("2. Wyświetl listę dostępnych pokoi");
        System.out.println("3. Zarezerwuj pokój");
        System.out.println("4. Zwolnij pokój");
        System.out.println("5. Zakończ program");
    }
}
