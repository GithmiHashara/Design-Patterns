import java.util.ArrayList;
import java.util.List;

// 1: Define the Mediator Interface
// The ChatMediator interface declares methods for sending messages and adding users.
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// 2: Implement the Concrete Mediator
// The ChatMediatorImpl class implements the ChatMediator interface and manages communication between users.
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        // Relay message to all users except the sender
        for (User u : this.users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
}

// 3: Create the User Class
// The abstract User class holds a reference to the mediator and declares methods for sending and receiving messages.
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// 4: Implement Concrete User Classes
// The UserImpl class extends User and provides concrete implementations for the send and receive methods.
class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + ": Sending Message = " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + ": Received Message = " + message);
    }
}

// 5: Client Code to Demonstrate the Pattern
// The MediatorPatternDemo class demonstrates how to use the Mediator pattern.
public class MediatorPatternDemo {
    public static void main(String[] args) {
        // Create the mediator
        ChatMediator mediator = new ChatMediatorImpl();

        // Create users and register them with the mediator
        User user1 = new UserImpl(mediator, "Alice");
        User user2 = new UserImpl(mediator, "Bob");
        User user3 = new UserImpl(mediator, "Charlie");
        User user4 = new UserImpl(mediator, "David");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        // Send a message from one user
        user1.send("Hi Everyone!");
        user2.send("Hello, I'm Bob");
    }
}

