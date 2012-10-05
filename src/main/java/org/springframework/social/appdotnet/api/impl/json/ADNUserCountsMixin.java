package org.springframework.social.appdotnet.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Map;

/**
 * Mixin class for adding Jackson annotations to {@link org.springframework.social.appdotnet.api.data.user.ADNUserCounts}
 *
 * @author Arik Galansky
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ADNUserCountsMixin {
    @JsonCreator
    ADNUserCountsMixin(
            @JsonProperty("following") int followingCount,
            @JsonProperty("followers") int followerCount,
            @JsonProperty("posts") int postCount,
            @JsonProperty("stars") int starCount
    ) {
    }
}
