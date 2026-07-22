package com.csc340tp.localguide.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
  @GetMapping
  public ResponseEntity<String> homePage() {
    String html = "<html> <body><h1>Local Guide API page as a just in case</h1>" +
        "<p>Tourist API endpoints:</p>" +
        "<ul><li><a href=\"/tourists\">/tourists</a></li>"+
        "<li><a href=\"/tourists/1\">/tourists/{id} (you can replace 1 with any tourist ID)</a></li>"+
        "<li><a href=\"/tourists/login\">/tourists/login (login as a tourist)</a></li>"+
        "</ul>"+
        "<p>Tour Guide API endpoints:</p>" +
        "<ul><li><a href=\"/api/guides\">/guides</a></li>"+
        "<li><a href=\"/api/guides/1\">/guides/{id} (you can replace 1 with any guide ID)</a></li>"+
        "<li><a href=\"/api/guides/search?query=Jackson\">/guides/search?query=Jackson (search guides by name)</a></li>"+
        "<li><a href=\"/api/guides/keyword-search?keyword=example\">/guides/keyword-search?keyword=example (search guides by keyword)</a></li>"+
        "</ul>"+
        "<p> Tour API endpoints:</p>" +
        "<ul><li><a href=\"/tours/1\">/tours/{id} (you can replace 1 with any tour ID)</a></li>"+
        "<li><a href=\"/tours/tourist/1\">/tours/tourist/{touristId} (you can replace 1 with any tourist ID)</a></li>"+
        "</ul>"+
        "<p> Tour listing API endpoints:</p>" +
        "<ul><li><a href=\"/api/tour-listings\">/tour-listings</a></li>"+
        "<li><a href=\"/api/tour-listings/1\">/tour-listings/{id} (you can replace 1 with any listing ID)</a></li>"+
        "</ul>"+
        "<p> Review API endpoints:</p>" +
        "<ul><li><a href=\"/reviews/1\">/reviews/{id} (you can replace 1 with any review ID)</a></li>"+
        "<li><a href=\"/reviews/tourist/1\">/reviews/tourist/{touristId} (reviews by tourist ID, you can replace 1 with any tourist ID)</a></li>"+
        "<li><a href=\"/reviews/guide/1\">/reviews/guide/{guideId} (reviews by guide ID, you can replace 1 with any guide ID)</a></li>"+
        "</ul>"+
        "<p> Please read the README.md on the backend-api folder for information on how to use the endpoints.</p>" +
        " </body></html>";

    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.TEXT_HTML)
        .body(html);

    }
}
