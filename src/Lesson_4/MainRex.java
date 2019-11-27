package Lesson_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRex {
    public static void main(String[] args) {
        System.out.println("mQPM0W                 " + " = " + find("mQPM0W")); //6 символов (символов меньше чем надо)
        System.out.println("}p%Uy~                 " + " = " + find("}p%Uy~")); //6 символов (символов меньше чем надо)
        System.out.println("$XGs5~hv               " + " = " + find("$XGs5~hv")); //8 символов
        System.out.println("#l#0beVg               " + " = " + find("#l#0beVg")); //8 символов
        System.out.println("ghgEzhq%M6xqf          " + " = " + find("ghgEzhq%M6xqf")); //13 символов
        System.out.println("wzbT@YlBq|IhC          " + " = " + find("wzbT@YlBq|IhC")); //13 символов (нет цифр)
        System.out.println("mlg%jl@wJElmrm4A3kTQ   " + " = " + find("mlg%jl@wJElmrm4A3kTQ")); //20 символов
        System.out.println("O~5o19D~6p{Av}TnC%3S   " + " = " + find("O~5o19D~6p{Av}TnC%3S")); //20 символов
        System.out.println("t}pK3cz1cT15jxMnmc~13aC" + " = " + find("t}pK3cz1cT15jxMnmc~13aC")); //23 символов (символов больше чем надо)
        System.out.println("C7w}J}OCJJ$8iwQLP}5k9*d" + " = " + find("C7w}J}OCJJ$8iwQLP}5k9*d")); //23 символов (символов больше чем надо)

    }

    /**
     * ^                 # start-of-string
     * (?=.*[0-9])       # a digit must occur at least once
     * (?=.*[a-z])       # a lower case letter must occur at least once
     * (?=.*[A-Z])       # an upper case letter must occur at least once
     * (?=.*[@#$%^&+=])  # a special character must occur at least once
     * (?=\S+$)          # no whitespace allowed in the entire string
     * .{8,}             # anything, at least eight places though
     * $                 # end-of-string
     * @param str
     * @return bool
     */
    public static boolean find(String str) {
//        Pattern p = Pattern.compile("^[.*]{8,20}$");
//        Pattern p = Pattern.compile("^.*\\d$");
//        Pattern p = Pattern.compile("^[a-zA-Z0-9-!$%^&*()#_+|~=`{}\\[\\]:\";'<>?,.@\\/]{8,20}$");
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
