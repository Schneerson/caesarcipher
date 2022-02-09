import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    void valid_params_for_encode()
    {
        Main m = new Main();
        String ar[] = new String[] {"-e","text","-o","2"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void valid_params_for_decode()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","text","-o","2"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode1()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-e","text","-o"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode2()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-o","-e","text"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode3()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","2","-e","text"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode4()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","2","text","-e"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode5()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","-e","2","text"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode6()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","2","-e","-o"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode7()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","-e","2","-o"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode8()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","-o","2","-e"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_encode9()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-o","text","-e"};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode1()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-d","text","-o"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode2()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-o","-d","text"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode3()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","2","-d","text"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode4()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","2","text","-d"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode5()
    {
        Main m = new Main();
        String ar[] = new String[] {"-o","-d","2","text"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode6()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","2","-d","-o"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode7()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","-d","2","-o"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode8()
    {
        Main m = new Main();
        String ar[] = new String[] {"text","-o","2","-d"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void random_valid_params_for_decode9()
    {
        Main m = new Main();
        String ar[] = new String[] {"2","-o","text","-d"};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void less_than_4_arguments()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","text","-o"};
        m.main(ar);
        assertEquals("There are must be 4 arguments", outContent.toString().trim());
    }

    @Test
    void more_than_4_arguments()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","text","-o","2","random"};
        m.main(ar);
        assertEquals("There are must be 4 arguments", outContent.toString().trim());
    }

    @Test
    void arguments_e_or_d_are_missing()
    {
        Main m = new Main();
        String ar[] = new String[] {"-a","text","-o","text"};
        m.main(ar);
        assertEquals("Change your input to following view: > java Main -flag YourString -o Int", outContent.toString().trim());
    }

    @Test
    void argument_o_is_missing()
    {
        Main m = new Main();
        String ar[] = new String[] {"-a","text","-oo","text"};
        m.main(ar);
        assertEquals("Change your input to following view: > java Main -flag YourString -o Int", outContent.toString().trim());
    }

    @Test
    void argument_text_is_empty()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","","-o","2"};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }

    @Test
    void argument_text_is_in_russian()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","Привет","-o","2"};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }

    @Test
    void argument_text_is_in_chinese()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","嘿","-o","2"};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }

    @Test
    void argument_text_is_with_symbols()
    {
        Main m = new Main();
        String ar[] = new String[] {"-d","+-=>< ","-o","2"};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }

    @Test
    void argument_int_is_missing()
    {
        Main m = new Main();
        String ar[] = new String[] {"-a","text","-o","Int"};
        m.main(ar);
        assertEquals("Change your input to following view: > java Main -flag YourString -o Int", outContent.toString().trim());
    }

    @Test
    void argument_int_is_less_than_0()
    {
        Main m = new Main();
        String ar[] = new String[] {"-e","text","-o","-2"};
        m.main(ar);
        assertEquals("Offset must be positive number", outContent.toString().trim());
    }

    @Test
    void argument_int_is_more_than_26()
    {
        Main m = new Main();
        String ar[] = new String[] {"-e","text","-o","30"};
        m.main(ar);
        assertEquals("Offset must be less than 26 for English alphabet", outContent.toString().trim());
    }

    @Test
    void valid_arguments_for_encode_in_1251() throws UnsupportedEncodingException {
        Main m = new Main();
        String ar1 = "-e", ar2 = "text", ar3 = "-o", ar4 = "2";
        String ar11 = new String(ar1.getBytes("Windows-1251"),"Windows-1251");
        String ar21 = new String(ar2.getBytes("Windows-1251"),"Windows-1251");
        String ar31 = new String(ar3.getBytes("Windows-1251"),"Windows-1251");
        String ar41 = new String(ar4.getBytes("Windows-1251"),"Windows-1251");

        String ar[] = new String[] {ar11,ar21,ar31,ar41};
        m.main(ar);
        assertEquals("vgzv", outContent.toString().trim());
    }

    @Test
    void valid_arguments_for_decode_in_1251() throws UnsupportedEncodingException {
        Main m = new Main();
        String ar1 = "-d", ar2 = "text", ar3 = "-o", ar4 = "2";
        String ar11 = new String(ar1.getBytes("Windows-1251"),"Windows-1251");
        String ar21 = new String(ar2.getBytes("Windows-1251"),"Windows-1251");
        String ar31 = new String(ar3.getBytes("Windows-1251"),"Windows-1251");
        String ar41 = new String(ar4.getBytes("Windows-1251"),"Windows-1251");

        String ar[] = new String[] {ar11,ar21,ar31,ar41};
        m.main(ar);
        assertEquals("rcvr", outContent.toString().trim());
    }

    @Test
    void russian_text_for_encode_in_1251() throws UnsupportedEncodingException {
        Main m = new Main();
        String ar1 = "-e", ar2 = "текст", ar3 = "-o", ar4 = "2";
        String ar11 = new String(ar1.getBytes("Windows-1251"),"Windows-1251");
        String ar21 = new String(ar2.getBytes("Windows-1251"),"Windows-1251");
        String ar31 = new String(ar3.getBytes("Windows-1251"),"Windows-1251");
        String ar41 = new String(ar4.getBytes("Windows-1251"),"Windows-1251");

        String ar[] = new String[] {ar11,ar21,ar31,ar41};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }

    @Test
    void russian_text_for_decode_in_1251() throws UnsupportedEncodingException {
        Main m = new Main();
        String ar1 = "-d", ar2 = "текст", ar3 = "-o", ar4 = "2";
        String ar11 = new String(ar1.getBytes("Windows-1251"),"Windows-1251");
        String ar21 = new String(ar2.getBytes("Windows-1251"),"Windows-1251");
        String ar31 = new String(ar3.getBytes("Windows-1251"),"Windows-1251");
        String ar41 = new String(ar4.getBytes("Windows-1251"),"Windows-1251");

        String ar[] = new String[] {ar11,ar21,ar31,ar41};
        m.main(ar);
        String op = outContent.toString().trim();
        assertTrue(op.contains("Please note that the program encodes/decodes only characters that are letters of the English language"));
    }


    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
