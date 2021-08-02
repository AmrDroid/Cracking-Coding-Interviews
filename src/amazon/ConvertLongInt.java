package amazon;

public class ConvertLongInt {
    public static void main(String[] args)
    {
        // Long object
        Long longnum = 100L;

        // Converting Long object to int primitive type
        int intnum = longnum.intValue();

        // printing the type
        System.out.println("Converted type: "
                + ((Object)intnum).getClass().getName());

        // printing the int value
        System.out.println("Converted int value: "
                + intnum);









        long value1 = 523386L;
        long value2 = -4456368L;

        // change long to int
        int num1 = Math.toIntExact(value1);
        int num2 = Math.toIntExact(value2);

        // print the type
        System.out.println("Converted type: "+ ((Object)num1).getClass().getName());
        System.out.println("Converted type: "+ ((Object)num2).getClass().getName());

        // print the int value
        System.out.println(num1);  // 52336
        System.out.println(num2);  // -445636

}

}
