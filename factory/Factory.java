package factory;

// Generic interface for a factory
public interface Factory<T> {
    // Method to create an object of type T with dynamic arguments
    T create(String description, double amount, String category);

    // Method to generate an ID
    String generateId();
}
