package restConsume.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Post(val userId: Int, val id: Int, val title: String, val body: String) {
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Posts(vararg post: Post)
