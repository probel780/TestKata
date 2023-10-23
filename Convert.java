import java.util.TreeMap;

public class Convert {
    TreeMap<Character, Integer> romKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();
    public Convert() {
        romKeyMap.put('I', 1);
        romKeyMap.put('V', 5);
        romKeyMap.put('X', 10);
        romKeyMap.put('L', 50);
        romKeyMap.put('C', 100);
        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");
    }
    public int romToInt(String num) {
        int end = num.length()-1;
        char[] arr = num.toCharArray();
        int arab;
        int result = romKeyMap.get(arr[end]);
        for (int i = end-1; i >= 0; i--) {
            arab = romKeyMap.get(arr[i]);
            if (arab < romKeyMap.get(arr[i+1])) {
                result -= arab;
            } else {
                result += arab;
            }
        }
        return result;
    }
    public String intToRom(int num){
        String rom = "";
        int arabKey;
        do {
            arabKey = arabKeyMap.floorKey(num);
            rom += arabKeyMap.get(arabKey);
            num -= arabKey;
        } while (num != 0);
        return rom;
    }
    public boolean isRoman(String num) {
        return romKeyMap.containsKey(num.charAt(0));
    }
}