// Class 1 of the subsystem
class SubsystemClassA {
    public void operationA() {
        System.out.println("SubsystemClassA: operationA");
    }
}

// Class 2 of the subsystem
class SubsystemClassB {
    public void operationB() {
        System.out.println("SubsystemClassB: operationB");
    }
}

// Class 3 of the subsystem
class SubsystemClassC {
    public void operationC() {
        System.out.println("SubsystemClassC: operationC");
    }
}

// Facade class that provides a simpler interface to the subsystem
class Facade {
    private SubsystemClassA classA;
    private SubsystemClassB classB;
    private SubsystemClassC classC;

    // Constructor initializes the subsystem classes
    public Facade() {
        this.classA = new SubsystemClassA();
        this.classB = new SubsystemClassB();
        this.classC = new SubsystemClassC();
    }

    // Simplified method that client code will use
    public void simplifiedOperation() {
        System.out.println("Facade: simplifiedOperation");
        classA.operationA();
        classB.operationB();
        classC.operationC();
    }

    // Additional simplified method
    public void anotherSimplifiedOperation() {
        System.out.println("Facade: anotherSimplifiedOperation");
        classB.operationB();
        classC.operationC();
    }
}

// Client Code
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Client code interacts with the subsystem via the Facade
        Facade facade = new Facade();

        // Simplified operations
        facade.simplifiedOperation();
        facade.anotherSimplifiedOperation();
    }
}

