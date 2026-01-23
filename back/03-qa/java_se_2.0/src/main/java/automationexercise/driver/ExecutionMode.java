package automationexercise.driver;

/**
 * Enum para modos de execução
 */
public enum ExecutionMode {
    LOCAL,
    GRID,
    DOCKER;

    public static ExecutionMode fromString(String mode) {
        try {
            return valueOf(mode.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Modo de execução inválido: " + mode + ". Usando LOCAL.");
            return LOCAL;
        }
    }
}
