import java.util.Random;

public class Generate_Random_Hex_Bytes 
{
    public static void main(String args[])
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        System.out.println("Random Hex Byte: " + Hex);
    }
}
