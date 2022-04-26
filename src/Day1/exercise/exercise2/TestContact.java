package Day1.exercise.exercise2;

/*
    @author: Dinh Quang Anh
    Date   : 4/25/2022
    Project: Java2
*/
public class TestContact {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact("Dinh Quang Anh","0395100761");
        Contact contact2 = new Contact("Dinh Em Quang","0123456789");
        Contact contact3 = new Contact("Dinh Chi Quang","9876543210");

        contactList.addContact(contact1);
        contactList.addContact(contact2);

//        contactList.getListContact();
//        contactList.searchContact("Em");
//        contactList.removeContact(contact1);
//        contactList.getListContact();
        contactList.updateContact(contact2, contact3);
        contactList.getListContact();
    }
}
