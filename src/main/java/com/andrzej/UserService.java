package com.andrzej;

import java.util.List;
import java.util.Optional;

public class UserService {
    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> getAllRooms(){
        return hotel.getRooms();
    }

    public List<Room> getAllAvailableRooms(){
        return hotel.getAllAvailableRooms();
    }

    public List<Room> getAllNotAvailableRooms(){
        return hotel.getAllNotAvailableRooms();
    }

    public boolean bookRoom(int number){
        Optional<Room> optionalOfRoom = hotel.findByNumber(number);
        if (!optionalOfRoom.isPresent() || !optionalOfRoom.get().isAvailable())
            return false;

        Room room = optionalOfRoom.get();
        room.setAvailable(false);
        hotel.saveRoom(room);
        return true;
    }

    public boolean releaseRoom(int number){
        Optional<Room> optionalOfRoom = hotel.findByNumber(number);
        if (!optionalOfRoom.isPresent() || optionalOfRoom.get().isAvailable())
            return false;

        Room room = optionalOfRoom.get();
        room.setAvailable(true);
        hotel.saveRoom(room);
        return true;
    }



}
