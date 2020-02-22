package com.andrzej;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = generateRooms();
    }

    public List<Room> getRooms(){
        //symuluje obiekty z bazy danych
        List<Room> copy = new ArrayList<>();
        for (Room room : rooms) {
            copy.add(Room.buildCopy(room));
        }
        return copy;
    }

    public List<Room> getAllAvailableRooms(){
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : getRooms()) {
            if (room.isAvailable()){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Room> getAllNotAvailableRooms(){
        List<Room> notAvailableRooms = new ArrayList<>();
        for (Room room : getRooms()) {
            if (!room.isAvailable()){
                notAvailableRooms.add(room);
            }
        }
        return notAvailableRooms;
    }


    public Optional<Room> findByNumber(int number){
        for (Room room : getRooms()) {
            if (room.getNumber() == number){
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }

    public void saveRoom (Room room){
        Room original = null;
        for (Room room1 : rooms) {
            if (room1.getNumber() == room.getNumber()){
                original = room1;
                break;
            }
        }
        if (original != null){
            rooms.remove(original);
        }
        rooms.add(Room.buildCopy(room));
    }

    private List<Room> generateRooms(){
        Room room1 = new Room(1, 2,true,true);
        Room room2 = new Room(2, 1,true,false);
        Room room3 = new Room(3, 6,true,true);
        Room room4 = new Room(4, 1,false,false);
        Room room5 = new Room(5, 1,false,true);
        Room room6 = new Room(6, 1,true,false);

        List<Room> randomRooms = new ArrayList<>();
        randomRooms.add(room1);
        randomRooms.add(room2);
        randomRooms.add(room3);
        randomRooms.add(room4);
        randomRooms.add(room5);
        randomRooms.add(room6);
        return randomRooms;
    }
}
