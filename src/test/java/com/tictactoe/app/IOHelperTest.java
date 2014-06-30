package com.tictactoe.app;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class IOHelperTest {

    private IOHelper helper = new IOHelper();

    @Test
    public void shouldValidateValidInput() {
        assertTrue(helper.isValidInput("1"));
    }

    @Test
    public void shouldNotValidateInvalidInput() {
        assertFalse(helper.isValidInput("a"));
    }

    @Test
    public void shouldNotValidateInvalidModeInput() {
        assertFalse(helper.isValidMode("A"));
    }

    @Test
    public void shouldValidateModeInput() {
        TestCase.assertTrue(helper.isValidMode("C"));
        TestCase.assertTrue(helper.isValidMode("c"));
    }
}
