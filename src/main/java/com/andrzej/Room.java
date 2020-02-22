package com.andrzej;

public class Room {
    private int number;
    private int size;
    private boolean restRoom;
    private boolean available;

    public Room(int number, int size, boolean restRoom, boolean available) {
        this.number = number;
        this.size = size;
        this.restRoom = restRoom;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getNumber() {
        return number;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static Room buildCopy(Room room){
        return new Room(room.number, room.size, room.restRoom, room.available);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", size=" + size +
                ", restRoom=" + restRoom +
                ", available=" + available +
                '}';
    }
}
