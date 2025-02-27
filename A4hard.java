/* Hard Level: Ticket Booking System with Multithreading Problem Statement 📝 Develop a ticket booking system with synchronized threads to ensure no double booking of seats. Use thread priorities to simulate VIP bookings being processed first.
Key Concepts Used 🛠️ Multithreading: To handle multiple booking requests simultaneously.
Synchronization: To prevent double booking of seats.
Thread Priorities: To prioritize VIP bookings over regular bookings.
How to Run 🏃‍♀️ Navigate to the Hard/ folder.
Compile and run the TicketBookingSystem.java file.
Observe how VIP bookings are prioritized and how synchronization prevents double booking. */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Seat {
    private boolean isBooked;
    private String bookingType;

    public Seat() {
        this.isBooked = false;
        this.bookingType = "";
    }

    public synchronized boolean bookSeat(String bookingType) {
        if (!isBooked) {
            isBooked = true;
            this.bookingType = bookingType;
            return true;
        }
        return false;
    }

    public synchronized boolean cancelBooking() {
        if (isBooked) {
            isBooked = false;
            bookingType = "";
            return true;
        }
        return false;
    }

    public String getBookingType() {
        return bookingType;
    }
}

class BookingThread extends Thread {
    private Seat seat;
    private String bookingType;

    public BookingThread(Seat seat, String bookingType) {
        this.seat = seat;
        this.bookingType = bookingType;
        if (bookingType.equals("VIP")) {
            this.setPriority(Thread.MAX_PRIORITY);
        } else {
            this.setPriority(Thread.NORM_PRIORITY);
        }
    }

    @Override
    public void run() {
        if (seat.bookSeat(bookingType)) {
            System.out.println("Seat booked successfully by " + bookingType);
        } else {
            System.out.println("Seat already booked by " + seat.getBookingType());
        }
    }
}

public class A4hard {
    public static void main(String[] args) {
        Seat seat = new Seat();

        BookingThread vipBooking = new BookingThread(seat, "VIP");
        BookingThread regularBooking = new BookingThread(seat, "Regular");

        vipBooking.start();
        regularBooking.start();

        try {
            vipBooking.join();
            regularBooking.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}