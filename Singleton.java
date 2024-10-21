public class Singleton {

    //Create a private static variable to hold the single instance of the class
    private static Singleton singleInstance;

    //Make the constructor private to prevent instantiation from other classes
    private Singleton() {
        // Initialization code here
    }

    //Provide a public static method to get the single instance of the class
    public static Singleton getInstance() {
        if (singleInstance == null) {
            // Create the instance if it doesn't exist
            singleInstance = new Singleton();
        }
        // Return the single instance
        return singleInstance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }

    public static void main(String[] args) {
        // Get the only instance of the Singleton class
        Singleton singleton = Singleton.getInstance();

        // Call a method on the instance
        singleton.showMessage();

}
}