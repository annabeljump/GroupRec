/**
 * File to configure LensKit recommender library
 * to build the recommender for the Group Recommendation extension
 * @author Lenskit - testing "getting started" configuration
 */

LenskitConfiguration config = new LenskitConfiguration();

//config.bind(ItemScorer.class).to(ItemItemScorer.class);

// personalized mean rating used as the baseline/fallback predictor.
// 2-step process:
// First, use the user mean rating as the baseline scorer
//config.bind(BaselineScorer.class, ItemScorer.class)
  //      .to(UserMeanItemScorer.class);
// Second, use the item mean rating as the base for user means
//config.bind(UserMeanBaseline.class, ItemScorer.class)
  //      .to(ItemMeanRatingItemScorer.class);
// and normalize ratings by baseline prior to computing similarities
//config.bind(UserVectorNormalizer.class)
//        .to(BaselineSubtractingUserVectorNormalizer.class);

//I actually want user-user CF:

config.bind(ItemScorer.class).to(UserUserItemScorer).class;
// use item-user mean when user-user fails
config.bind(BaselineScorer.class, ItemScorer.class).to(UserMeanItemScorer.class);
config.bind(UserMeanBaseline.class, ItemScorer.class).to(ItemMeanRatingItemScorer.class);
// normalize by subtracting the user's mean rating
within (UserVectorNormalizer) {
    // for normalization, just center on user means
    config.bind(VectorNormalizer.class).to(MeanCenteringVectorNormalizer.class);
}
config.set(NeighborhoodSize.class).to(30);



//bind the data source
//config.bind(EventDAO.class).to(new SimpleFileRatingDAO(new File(""), ","));
config.bind(EventDAO.class).to(new SimpleFileRatingDAO(new csvFile("~/IdeaProject/u.data"), "/t"));