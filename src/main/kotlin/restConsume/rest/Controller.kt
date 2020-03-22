package restConsume.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/api")

class Controller() {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Value(var id: Long = 0, var quote: String = "")

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Quote(var type : String = "", var value : Value? = null)

    @GetMapping("/posts")
    fun getPosts() {
        val URL: String = "https://jsonplaceholder.typicode.com/posts"
        val posts = RestTemplate().getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)
        println(posts)
    }
}