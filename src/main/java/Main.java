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

    public static void show_args_error()
    {
        System.out.println("There are must be 4 arguments");}

    public static void show_error()
    {
        System.out.println("Change your input to following view: > java Main -flag YourString -o Int");
        /*System.out.println("> java Main -flag YourString -o Int");
        System.out.println("Where -flag can take values -e for encryption or -d for decoding");
        System.out.println("YourString this is the English text you want to encrypt or decode");
        System.out.println("Int this is the value of offset for Caesar cipher");*/
    }

    public static String[] normalize_args (String[] a) {
        String args[] = new String[4];
        for (int i = 0; i < args.length; i++) {
            args[i] = "null";
        }
        String e = "", d = "",  o = "", offset = "";
        int e_n = -1, d_n = -1, o_n = -1, offset_n = -1;
        int e_count = 0, d_count = 0, m_count = 0, o_count = 0, offset_count = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i].length()!=0) {
            if (a[i].equals("-e")) {
                e = a[i];
                e_n = i;
                e_count += 1;
            }
            if (a[i].equals("-d")) {
                d = a[i];
                d_n = i;
                d_count += 1;
            }
            if (a[i].equals("-o")) {
                o = a[i];
                o_n = i;
                o_count += 1;
            }
            if (Character.isDigit(a[i].charAt(0))) {
                    offset = a[i];
                    offset_n = i;
                    offset_count += 1;
                }
            if (a[i].charAt(0)=='-') {
                m_count+=1;
            }
        }}
        if (m_count==3) { args[0] = "minus";}
        if ((e_count + d_count) == 1 & o_count == 1 & offset_count == 1) {
            if (e_count == 1) {
                args[0] = e;
            } else {
                args[0] = d;
            }

            for (int i = 0; i < a.length; i++) {
                if (i != e_n & i != d_n & i != o_n & i != offset_n) {
                    args[1] = a[i];
                }
            }

            args[2] = o;
            args[3] = offset;

        }

        return args;
    }
    public static void main(String[] args) {
        if (args.length != 4)
        {   show_args_error();}
        else {
            String ar[] = normalize_args(args);
            if (ar[0].equals("null")) {show_error();}
            else if (ar[0].equals("minus")) {System.out.print("Offset must be positive number");}
            else {
                if (!Character.isDigit(ar[3].charAt(0)))
                {
                    System.out.print("Offset must be positive number");
                }
                else if (Integer.parseInt(ar[3]) > 26 )
                {
                    System.out.print("Offset must be less than 26 for English alphabet");
                }
                else {
                    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                    int o = Integer.parseInt(ar[3]);
                    String input = ar[1];
                    if (ar[0].equals("-e")) {
                        String ret = encrypt_string(input, o, alphabet);
                        System.out.println(ret);
                        if (ret.equals(input) & (o!=0 & o!=26))
                        {System.out.print("Please note that the program encodes/decodes only characters that are letters of the English language");}
                    }
                    if (ar[0].equals("-d")) {
                        String ret = decrypt_string(input, o, alphabet);
                        System.out.println(ret);
                        int ll = 0;
                        if (ret.equals(input) & (o!=0 & o!=26))
                        {System.out.print("Please note that the program encodes/decodes only characters that are letters of the English language");}
                    }
                }
            }

        }

    }
}