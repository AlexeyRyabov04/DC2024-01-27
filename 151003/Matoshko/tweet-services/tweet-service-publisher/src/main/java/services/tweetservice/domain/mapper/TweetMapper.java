package services.tweetservice.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import services.tweetservice.domain.entity.Tweet;
import services.tweetservice.domain.request.TweetRequestTo;
import services.tweetservice.domain.response.TweetResponseTo;

@Mapper(componentModel = "spring", uses = {StickerListMapper.class, CreatorMapper.class})
public interface TweetMapper {
    @Mapping(source = "creatorId", target = "creator.id")
    Tweet toTweet(TweetRequestTo tweetRequestTo);
    @Mapping(source = "creator.id", target = "creatorId")
    TweetResponseTo toTweetResponseTo(Tweet tweet);
}
