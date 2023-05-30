import java.util.ArrayList;
import java.util.Scanner;

public class CellphoneMain {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args){
        Cellphone cp = new Cellphone("Nokia", "3310");

        menu();
    }

    static void addContact() {
        while(true) {
            System.out.print("Name  : ");
            String name = input.next();
            System.out.print("Nomor : ");
            String nomor = input.next();
            Contact contact = new Contact(name, nomor);

            contacts.add(contact);

            System.out.print("\nInput Contact Again? (y/t) : ");
            String choice = input.next();

            if(choice.equals("y")){
                continue;
            } else if(choice.equals("t")){
                break;
            }
        }
        menu();
    }

    static void listContact() {
        for(int i=0; i<contacts.size(); i++){
            System.out.println(contacts.get(i).getNama());
            System.out.println(contacts.get(i).getNomor());
            System.out.println("===");
        }
        menu();
    }

    static void menu(){
        System.out.println("1. Top Up Pulsa");
        System.out.println("2. Cek Pulsa");
        System.out.println("3. Tambah Kontak");
        System.out.println("4. List Kontak");
        System.out.println("5. Cari Kontak");

        System.out.println("Pilihan Anda: ");
        int choose = input.nextInt();
        switch(choose){
            case 1:
                break;
            case 2:
                break;
            case 3:
                addContact();
                break;
            case 4:
                listContact();
                break;
            case 5
                break;
            default:
                break;
        }
    }

}
