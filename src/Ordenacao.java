public class Ordenacao {
    public static void ordenarPorModelo(String[] modelos, String[] placa, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (modelos[j].compareToIgnoreCase(modelos[j + 1]) > 0) {
                    trocarElementos(modelos, j, j + 1);
                    trocarElementos(placa, j, j + 1);
                }
            }
        }
    }

    public static void ordenarPorPlaca(String[] placas, String[] modelos, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (placas[j].compareToIgnoreCase(placas[j + 1]) > 0) {
                    trocarElementos(placas, j, j + 1);
                    trocarElementos(modelos, j, j + 1);
                }
            }
        }
    }

    private static void trocarElementos(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
