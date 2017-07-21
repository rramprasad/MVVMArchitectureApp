package com.rramprasad.testingsample.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lakeba
 */
public class UtilsTest {

    @Before
    public void setup(){
    }

    @Test
    public void check_Password_With_TextOnly() throws Exception {
        boolean validPassword = Utils.isValidPassword("TextOnly");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_NumberOnly() throws Exception {
        boolean validPassword = Utils.isValidPassword("123456789123");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_Text_And_Number() throws Exception {
        boolean validPassword = Utils.isValidPassword("TextOnly123456789123");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_Small_Text_Number_And_SpecialChar() throws Exception {
        boolean validPassword = Utils.isValidPassword("textonly@123456789123");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_Max_Chars() throws Exception {
        boolean validPassword = Utils.isValidPassword("textonly@12345678");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_Min_Chars() throws Exception {
        boolean validPassword = Utils.isValidPassword("T@123");
        assertFalse(validPassword);
    }

    @Test
    public void check_Password_With_All_Valid_Characters() throws Exception {
        boolean validPassword = Utils.isValidPassword("TextOnly@12345");
        assertTrue(validPassword);
    }

    @Test
    public void check_UserName_With_Min_Chars() throws Exception {
        boolean validUserName = Utils.isValidUserName("a@gc");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Without_At_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("abcgmail.com");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Without_Dot_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("abc@gmailcom");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Starts_With_At_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("@gmail.com");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Starts_With_Underscore_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("_abc@gmail.com");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Starts_With_Dot_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName(".abc@gmail.com");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Ends_With_At_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("abc@gmail.com@");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Ends_With_Underscore_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("abc@gmail.com_");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Ends_With_Dot_Symbol() throws Exception {
        boolean validUserName = Utils.isValidUserName("abc@gmail.com.");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_Without_Dot_On_Second_Part() throws Exception {
        boolean validUserName = Utils.isValidUserName("abc.@gmailcom");
        assertFalse(validUserName);
    }

    @Test
    public void check_UserName_With_Special_Chars() throws Exception {
        boolean validUserName = Utils.isValidUserName("ab*c@gmail.com");
        assertFalse(validUserName);
    }
}