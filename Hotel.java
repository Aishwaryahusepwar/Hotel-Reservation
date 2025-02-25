import java.util.ArrayList;
import java.util.Scanner;

class Rooms {
    int room_num;
    String category;
    double price;

    public Rooms(int room_num, String category, double price) {
        this.room_num = room_num;
        this.category = category;
        this.price = price;
    }

    public void display() {
        System.out.println(room_num + " " + category + " " + price);
    }
}

class Booking {
    String guest_name;
    int room_num;

    public Booking(int room_num, String guest_name) {
        this.room_num = room_num;
        this.guest_name = guest_name;
    }

    public void display() {
        System.out.println("Room: " + room_num + ", Guest: " + guest_name);
    }
}


public class Hotel {
	ArrayList<Rooms> room = new ArrayList<>();
    ArrayList<Booking> booked = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    double guest_balance = 5000.0;

    public void Details() {
        room.add(new Rooms(100, "normal", 1000.0));
        room.add(new Rooms(101, "standard", 2000.0));
    }

    public void available_rooms() {
        for (Rooms r : room) {
            r.display();
        }
    }

    public void reservation() {
        System.out.println("Enter guest name:");
        String name = sc.next();
        System.out.println("Enter room number:");
        int room_num = sc.nextInt();

        for (Rooms r : room) {
            if (r.room_num == room_num) {
                booked.add(new Booking(room_num, name));
                guest_balance -= r.price;
                System.out.println("Payment successful");
                System.out.println("Reservation completed") ;
                return;
            }
        else{
            System.out.println("Not available ") ;
        }
        }
    }

    public void booking_details() {
        System.out.println("To view details, enter room number:");
        int room_num = sc.nextInt();
        

        for (Booking b : booked) {
            if (b.room_num == room_num) {
                System.out.println("Booking details:");
                b.display();
                
                break;
            }
        }
        
    }

    public void start() {
        System.out.println("_WELCOME_");
        Details();

        while (true) {
            System.out.println("1. Available rooms");
            System.out.println("2. Make reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.println("Choose your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    available_rooms();
                    break;
                case 2:
                    reservation();
                    break;
                case 3:
                    booking_details();
                    break;
                case 4:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
       Hotel m = new Hotel();
        m.start();
    }

}
