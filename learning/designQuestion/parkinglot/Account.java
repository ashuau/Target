package learning.designQuestion.parkinglot;

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

public abstract class Account {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private String password;
    private AccountStatus status;
    private Person person;

 //   public boolean resetPassword();
}

/*public class Admin extends Account {
    public boolean addParkingFloor(ParkingFloor floor);
    public boolean addParkingSpot(String floorName, ParkingSpot spot);
    public bool addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
    public bool addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);

    public bool addEntrancePanel(EntrancePanel entrancePanel);
    public bool addExitPanel(ExitPanel exitPanel);
}

public class ParkingAttendant extends Account {
    public bool processTicket(string TicketNumber);
}*/
