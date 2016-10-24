package design.pattern.singleton;

enum SingletonEnum {
    Instance;

    public static String getEnumName() {
        return "Enum name";
    }

    /**
     * Can have any number of methods for the enum singleton. Enums are thread
     * safe.
     */
}