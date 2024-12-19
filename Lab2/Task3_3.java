import java.util.StringTokenizer;

class Task3_3 {
    public static void splitIPAddress(String IP)
    {
       StringTokenizer tokenizer = new StringTokenizer(IP, ".");

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
    public static void main(String[] args) {
        String IP = "192.168.1.1";
        splitIPAddress(IP);
 

    }
}
