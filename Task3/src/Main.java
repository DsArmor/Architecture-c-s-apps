public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            if (args[0].equals("server")) {
                new Server().start(Integer.parseInt(args[1]));
            } else if (args[0].equals("client")) {
                new Client().startConnection(args[1], Integer.parseInt(args[2]));
            }
        }
    }
}
