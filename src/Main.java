public class Main {

    public static int numberofletter(char x, char[] a){
        int y = -1;
        for  (int i = 0; i< a.length; i++) {
            if (x == a[i])
            {y=i;}
        }
        return y;
    }

    public static char letterfornumber(int x, char[] a)
    {
        return a[x];
    }

    public static char encrypt_symbol(char x, char[] a, int o)
    {   boolean c = false;
        char y = x;
        if (Character.isUpperCase(x))
        {c = true;
            x = Character.toLowerCase(x); }
        int z = numberofletter(x,a);
        if (z>=0)
        {
            y = letterfornumber(((z + o) % a.length), a);
            if (c) {
                y = Character.toUpperCase(y);
            }
        }
        return y ;
    }

    public static char decrypt_symbol(char x, char[] a, int o)
    {   boolean c = false;
        char yy = x;
        if (Character.isUpperCase(x))
        {c = true;
            x = Character.toLowerCase(x); }
        int z = numberofletter(x,a);
        if (z>=0)
        {
            int y = z - o;
            if (y < 0) {
                y = a.length + y;
            }
            yy = letterfornumber((y % a.length), a);
            if (c) {
                yy = Character.toUpperCase(yy);
            }
        }
        return yy;
    }

    public static String encrypt_string(String x, int o, char[] a)
    {   String output = "";
        char [] arrayChars = x.toCharArray();
        for (int i = 0; i< arrayChars.length; i++)
        {
            output+=encrypt_symbol(arrayChars[i],a,o);
        }
        return output;
    }

    public static String decrypt_string(String x, int o, char[] a)
    {   String output = "";
        char [] arrayChars = x.toCharArray();
        for (int i = 0; i< arrayChars.length; i++)
        {
            output+=decrypt_symbol(arrayChars[i],a,o);
        }
        return output;
    }

    public static void show_error()
    {
        System.out.println("Change your input to following view:");
        System.out.println("> java Main -flag YourString -o Int");
        System.out.println("Where -flag can take values -e for encryption or -d for decoding");
        System.out.println("YourString this is the English text you want to encrypt or decode");
        System.out.println("Int this is the value of offset for Caesar cipher");
    }

    public static void main(String[] args) {
        if (args.length != 4)
        {   show_error();}
        else if ( !args[0].equals("-e") & !args[0].equals("-d") | !args[2].equals("-o")) {
            show_error();
        } else {
            if (Integer.parseInt(args[3])< 0  | Integer.parseInt(args[3]) > 26 )
            {
                System.out.println("Offset must be more than 0 and less than 26 for English alphabet");
            }
            else {
                char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                int o = Integer.parseInt(args[3]);
                String input = args[1];
                if (args[0].equals("-e")) {
                    String ret = encrypt_string(input, o, alphabet);
                    System.out.println(ret);
                    if (ret.equals(input) & (o!=0 & o!=26))
                    {System.out.println("Remember that input string should be in English");}
                }
                if (args[0].equals("-d")) {
                    String ret = decrypt_string(input, o, alphabet);
                    System.out.println(ret);
                    if (ret.equals(input) & (o!=0 & o!=26))
                    {System.out.println("Remember that input string should be in English");}
                }
            }
        }
    }
}

