package webservices;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbProperty;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class StreamApiSample {
     /*
    One method will accept author name,
    make a GET request to this endpoint: https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c0feb0bc81c74e9284814912f6ccaa4a
    endpoint, and return title(s) belong to that author.
    One method return all articles if  source[‘id’] is not null.
    This app should have exception handling.
    Write unit tests for method in #1 and #2
     */

    private final String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c0feb0bc81c74e9284814912f6ccaa4a";


    private <R> Predicate<R> not(Predicate<R> predicate) {
        return predicate.negate();
    }

    private <R> R getResponseBody(R r) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
        Jsonb jsonb = JsonbBuilder.create();
        return (R) jsonb.fromJson(response, r.getClass());
    }

    private List<String> getTitlesByAuthor(String author) throws IOException {
        List<Article> articlesList = getResponseBody(new Response()).getArticles();
        return articlesList.stream()
                .filter(e -> author.equals(e.getAuthor()))
                .map(Article::getTitle)
                .collect(toList());
    }

    private List<Article> getArticlesWithID() throws IOException {
        List<Article> articlesList = getResponseBody(new Response()).getArticles();
        return articlesList.stream()
                .filter(not(e -> e.getSource().getId() == null))
                .collect(toList());
    }

    class Article {

        @JsonbProperty(value = "author")
        private String author;

        @JsonbProperty(value = "source")
        private Source source;

        @JsonbProperty(value = "title")
        private String title;

        public Article() {
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "author='" + author + '\'' +
                    ", source=" + source +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    class Source {

        @JsonbProperty(value = "id")
        private String id;

        @JsonbProperty(value = "name")
        private String name;

        public Source() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    class Response {

        @JsonbProperty(value = "status")
        private String status;

        @JsonbProperty(value = "articles")
        private List<Article> articles;


        public Response() {
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "status='" + status + '\'' +
                    ", articles=" + articles +
                    '}';
        }
    }
}

