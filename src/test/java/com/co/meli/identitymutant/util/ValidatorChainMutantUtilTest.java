package com.co.meli.identitymutant.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;

public class ValidatorChainMutantUtilTest {

    @Test
    public void testValidateChainStructure_ValidArray_ReturnsTrue() throws Exception {
        String[] array = {"ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTG"};
        boolean result = ValidatorChainMutantUtil.validateChainStructure(array);
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateChainStructure_InvalidArray_ReturnsFalse() throws Exception {
        String[] array = {"ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTX"}; // Contains invalid character 'X'
        boolean result = ValidatorChainMutantUtil.validateChainStructure(array);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCreateDNATable_ValidRows_ReturnsDNATable() throws Exception {
        String[] rows = {"ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTG"};
        char[][] expectedTable = {
                {'A', 'T', 'G', 'C', 'G', 'A'},
                {'C', 'C', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'G', 'A', 'A', 'G', 'G'},
                {'C', 'T', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };

        char[][] result = ValidatorChainMutantUtil.createDNATable(rows);
        Assertions.assertArrayEquals(expectedTable, result);
    }

    @Test
    public void testHasConsecutiveSequences_NoConsecutiveSequences_ReturnsFalse() {
        char[][] chaindna = {
                {'A', 'T', 'G', 'C', 'G', 'A'},
                {'C', 'C', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'G', 'A', 'A', 'G', 'G'},
                {'C', 'T', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };
        boolean result = ValidatorChainMutantUtil.hasConsecutiveSequences(chaindna);
        Assertions.assertFalse(result);
    }

    @Test
    public void testHasConsecutiveSequences_ConsecutiveSequences_ReturnsTrue() {
        char[][] chaindna = {
                {'A', 'T', 'G', 'C', 'G', 'A'},
                {'C', 'C', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'A', 'A', 'A', 'G', 'G'}, // Consecutive sequence of 'A'
                {'C', 'T', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };
        boolean result = ValidatorChainMutantUtil.hasConsecutiveSequences(chaindna);
        Assertions.assertTrue(result);
    }

    @Test
    public void testHasConsecutiveSequences_ExceptionThrown_ReturnsFalse() {
        char[][] chaindna = {
                {'A', 'T', 'G', 'C', 'G', 'A'},
                {'C', 'C', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'G', 'A'}, // Invalid row length, will throw IllegalArgumentException
                {'C', 'T', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };

        // Mock the logger to avoid logging error messages during the test
        Logger loggerMock = Mockito.mock(Logger.class);
       // ValidatorChainMutantUtil.setLogger(loggerMock);

        boolean result = ValidatorChainMutantUtil.hasConsecutiveSequences(chaindna);
        Assertions.assertFalse(result);

        // Verify that the logger error message was not called
        verify(loggerMock, never()).error(anyString());
    }
}
