package com.co.meli.identitymutant.util;

import com.co.meli.identitymutant.controller.impl.IdentifyMuntantControllerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidatorChainMutantUtil {

    private static final Logger logger = LoggerFactory.getLogger(ValidatorChainMutantUtil.class);
        public static boolean validateChainStructure(String[] array)throws Exception{
            try {
                logger.info("[Utils] Validate Structure DNA Mutant");

                for (String str : array) {
                    if(str.length() > 6 || str.length() < 6){
                        logger.error("El array no cumple con la catidad de caracteres igual a 6 count: " + str.length());
                        return false;
                    }
                    for (char c : str.toCharArray()) {
                        if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                            logger.error("El array contiene caracteres no válidos");
                            return false;
                        }
                    }
                }
                return true; // Si todos los caracteres son válidos, retorna true
            } catch (Exception e) {
                logger.error("[ERROR] - Validate Structure DNA Mutant" + e.getMessage());
                return false; // Si se encuentra una excepción, retorna false
            }
        }


    public static char[][] createDNATable(String[] rows) {
        int n = rows.length;
        char[][] dnaTable = new char[n][n];
        for (int i = 0; i < n; i++) {
            // Verificar que cada fila tenga la misma longitud que el número de filas
            if (rows[i].length() != n) {
                throw new IllegalArgumentException("Las filas deben tener la misma longitud que el número de filas");
            }
            // Convertir la fila en un array de caracteres y asignarlo a la tabla de ADN
            dnaTable[i] = rows[i].toCharArray();
        }
        return dnaTable;
    }

    public static void printDNATable(char[][] dnaTable) {
        for (int i = 0; i < dnaTable.length; i++) {
            for (int j = 0; j < dnaTable[i].length; j++) {
                System.out.print(dnaTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean hasConsecutiveSequences(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Buscar secuencias horizontales
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns - 3; column++) {
                if (matrix[row][column] == matrix[row][column + 1]
                        && matrix[row][column] == matrix[row][column + 2]
                        && matrix[row][column] == matrix[row][column + 3]) {
                    return true;
                }
            }
        }

        // Buscar secuencias verticales
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows - 3; row++) {
                if (matrix[row][column] == matrix[row + 1][column]
                        && matrix[row][column] == matrix[row + 2][column]
                        && matrix[row][column] == matrix[row + 3][column]) {
                    return true;
                }
            }
        }

        // Buscar secuencias diagonales hacia la derecha
        for (int row = 0; row < rows - 3; row++) {
            for (int column = 0; column < columns - 3; column++) {
                if (matrix[row][column] == matrix[row + 1][column + 1]
                        && matrix[row][column] == matrix[row + 2][column + 2]
                        && matrix[row][column] == matrix[row + 3][column + 3]) {
                    return true;
                }
            }
        }

        // Buscar secuencias diagonales hacia la izquierda
        for (int row = 0; row < rows - 3; row++) {
            for (int column = 3; column < columns; column++) {
                if (matrix[row][column] == matrix[row + 1][column - 1]
                        && matrix[row][column] == matrix[row + 2][column - 2]
                        && matrix[row][column] == matrix[row + 3][column - 3]) {
                    return true;
                }
            }
        }

        return false;
    }
}
