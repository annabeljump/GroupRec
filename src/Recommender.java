/**
 * Main Method to run the recommenders
 * testing Lenskit basic implementation
 * @author Lenksit
 */

public class Recommender implements Runnable {

    public static void main(String[] args) {
        Recommender hello = new Recommender(args);
        try {
            hello.run();
        } catch (RuntimeException e) {
            System.err.println(e.toString());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private Path dataFile = Paths.get("~/IdeaProjects/");
    private List<Long> users;

    public Recommender(String[] args) {
        users = new ArrayList<>(args.length);
        for (String arg: args) {
            users.add(Long.parseLong(arg));
        }
    }
}