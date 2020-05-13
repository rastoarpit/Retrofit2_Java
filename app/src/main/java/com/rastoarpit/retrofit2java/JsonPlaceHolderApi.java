package com.rastoarpit.retrofit2java;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {

    //http://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<Post>> getPosts();

    //http://jsonplaceholder.typicode.com/posts?userId=1
    @GET("posts")
    Call<List<Post>> getPostsWithQuery(@Query("userId") int userId);

    //http://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPostsWithQueryParams(@Query("userId") int userId,
                                             @Query("_sort") String sortBy,
                                             @Query("_order") String order);

    //http://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPostsWithQueryParamsAsMap(@QueryMap Map<String, String> parameters);

    //http://jsonplaceholder.typicode.com/comments
    @GET("comments")
    Call<List<Comment>> getComments();

    //http://jsonplaceholder.typicode.com/posts/1/comments
    @GET("posts/{id}/comments")
    Call<List<Comment>> getCommentsOnPost(@Path("id") int postId);

    //alternatively we can also use @HeaderMap Map<String, String> headers instead of @Header (Dynamic_Header) String headerValue
    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @POST("posts")
    Call<Post> createPost(@Header("Dynamic_Header") String headerValue,
                          @Body Post post);
}
