package restConsume.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@RestController
@RequestMapping("/api")

class Controller() {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Value(var id: Long = 0, var quote: String = "")

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Quote(var type : String = "", var value : Value? = null)

    @GetMapping("/quotes")
    fun getQuotes() {
        val url: String = "http://gturnquist-quoters.cfapps.io/api/random"
        val quotes = RestTemplate().getForObject(url, Quote::class.java)
        println(quotes)
    }

    @GetMapping("/post")
    fun getPost() {
        val url: String = "https://jsonplaceholder.typicode.com/posts/1"
        val post = RestTemplate().getForObject(url, Post::class.java)
        println(post)
    }

    @GetMapping("/posts")
    fun getPosts() {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())
    }
}