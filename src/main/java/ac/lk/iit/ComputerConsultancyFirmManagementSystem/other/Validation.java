package ac.lk.iit.ComputerConsultancyFirmManagementSystem.other;

public class Validation {

    public static boolean isInt(String number) {
        char[] chars = number.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean isAlpha(String text){
        char[] chars = text.toCharArray();
        for (char achar : chars){
            if (!Character.isLetter(achar)){
                return false;
            }
        }
        return true;
    }

    public static boolean isTelephone(String number){
        String val = "^[0-9]{10}";
        if (number.matches(val)){
            return true;
        }
        return false;
    }
}
