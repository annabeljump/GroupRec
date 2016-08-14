/**
 * Main Method to run the recommenders
 * testing Lenskit basic implementation
 * Using HelloLenskit basic code - in comment at bottom
 * @author Lenksit
 */

public class Recommender implements Runnable {

    //Initialise a Logger to log progress/errors
    private static final Logger logger = LoggerFactory.getLogger(Recommender.class);


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

//public class HelloLenskit implements Runnable {

  //  private static final Logger logger = LoggerFactory.getLogger(Recommender.class);


  //  public static void main(String[] args) {
  //      HelloLenskit hello = new HelloLenskit(args);
  //      try {
  //          hello.run();
  //      } catch (RuntimeException e) {
  //          System.err.println(e.toString());
  //          e.printStackTrace(System.err);
  //          System.exit(1);
  //      }
  //  }

  //  private Path dataFile = Paths.get("data/movielens.yml");
  //  private List<Long> users;

  //  public HelloLenskit(String[] args) {
  //      users = new ArrayList<>(args.length);
  //      for (String arg: args) {
  //          users.add(Long.parseLong(arg));
  //      }
  //  }

  //  public void run() {
        // We first need to configure the data access.
        // We will load data from a static data source; you could implement your own DAO
        // on top of a database of some kind
  //      DataAccessObject dao;
  //      try {
  //          StaticDataSource data = StaticDataSource.load(dataFile);
            // get the data from the DAO
  //          dao = data.get();
  //      } catch (IOException e) {
  //          logger.error("cannot load data", e);
  //          throw Throwables.propagate(e);
  //      }

        // Next: load the LensKit algorithm configuration
  //      LenskitConfiguration config = null;
  //      try {
  //          config = ConfigHelpers.load(new File("etc/item-item.groovy"));
  //      } catch (IOException e) {
  //          throw new RuntimeException("could not load configuration", e);
  //      }


        // There are more parameters, roles, and components that can be set. See the
        // JavaDoc for each recommender algorithm for more information.

        // Now that we have a configuration, build a recommender engine from the configuration
        // and data source. This will compute the similarity matrix and return a recommender
        // engine that uses it.
  //      LenskitRecommenderEngine engine = LenskitRecommenderEngine.build(config, dao);
  //      logger.info("built recommender engine");

        // Finally, get the recommender and use it.
  //      try (LenskitRecommender rec = engine.createRecommender(dao)) {
  //          logger.info("obtained recommender from engine");
            // we want to recommend items
  //          ItemRecommender irec = rec.getItemRecommender();
  //          assert irec != null; // not null because we configured one
            // for users
  //          for (long user : users) {
                // get 10 recommendation for the user
  //              ResultList recs = irec.recommendWithDetails(user, 10, null, null);
  //              System.out.format("Recommendations for user %d:\n", user);
  //              for (Result item : recs) {
  //                  Entity itemData = dao.lookupEntity(CommonTypes.ITEM, item.getId());
  //                  String name = null;
  //                  if (itemData != null) {
  //                      name = itemData.maybeGet(CommonAttributes.NAME);
  //                  }
  //                  System.out.format("\t%d (%s): %.2f\n", item.getId(), name, item.getScore());
  //              }
  //          }
  //      }
  //  }
//}