class Main {
    public static String calc(String input) throws Exception {
        int a, b, result;
        String act;

        //удаляем из строки пробелы и делаем буквы римских чисел большими
        input = input.replaceAll(" ", "");
        input = input.toUpperCase();

        //делим строку на операнды и одновременно проверям наличие допустимого знака операции
        String[] nums = input.split("[+\\-*/]");
        if (nums.length != 2) throw new Exception("Введите выражение вида a+b, a-b, a*b или a/b");

        //проверяем в одной ли системе введены операнды
        Convert convert = new Convert();
        if (convert.isRoman(nums[0]) == convert.isRoman(nums[1])) {
            if (convert.isRoman(nums[0])) {

                //если операнды - римские цисла
                a = convert.romToInt(nums[0]);
                b = convert.romToInt(nums[1]);
            } else {

                //если операнды - арабские числа
                a = Integer.parseInt(nums[0]);
                b = Integer.parseInt(nums[1]);
            }

            //Проверяем что вводимые числа в пределах от 1 до 10
            if (a>0 == a<11 == b>0 == b<11) {

                //Делаем вычисление в зависимости от знака операции
                if (input.contains("+")) {
                    result = a+b;
                    act = "+";
                } else if (input.contains("*")) {
                    result = a*b;
                    act = "*";
                } else if (input.contains("/")) {
                    result = a/b;
                    act = "/";
                } else {
                    result = a-b;
                    act = "-";
                }
            } else throw new Exception("Калькулятор принимает числа только от 1(I) до 10(X)");

            //Проверка отрицательного результата для римских чисел
            if (convert.isRoman(nums[0]) && result<1) throw new Exception("При расчете римских чисел результат не может меньше I");

            //Вывод результата
            if (convert.isRoman(nums[0])) {
                return ("Output: "+nums[0]+act+nums[1]+"="+convert.intToRom(result));
            } else {
                return ("Output: "+a+act+b+"="+result);
            }
        } else throw new Exception("Вводите числа одной системы");
    }
}
