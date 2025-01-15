public class Conversor {
    public String convertir(int opcion, double monto) {
        String monedaOrigen = "";
        String monedaDestino = "";

        switch (opcion) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "ARS";
                break;
            case 2:
                monedaOrigen = "ARS";
                monedaDestino = "USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                break;
            case 4:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "COP";
                break;
            case 6:
                monedaOrigen = "COP";
                monedaDestino = "USD";
                break;
            default:
                return "Opción no válida, inténtelo de nuevo.";
        }

        // Realizar conversión usando la API
        try {
            double tasaConversion = Api.obtenerTasaConversion(monedaOrigen, monedaDestino);
            double resultado = monto * tasaConversion;
            return String.format("El valor %.2f [%s] corresponde a %.2f [%s]",
                    monto, monedaOrigen, resultado, monedaDestino);
        } catch (Exception e) {
            return "Error al obtener la tasa de conversión: " + e.getMessage();
        }
    }
}
