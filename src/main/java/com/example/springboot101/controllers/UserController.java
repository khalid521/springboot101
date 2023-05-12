package com.example.springboot101.controllers;

import com.example.springboot101.models.User;
import com.example.springboot101.services.UserService;
import com.rometools.rome.feed.WireFeed;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.WireFeedOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.access.prepost.PreAuthorize;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  
   public UserController() {
   }

    // @PreAuthorize("isAdmin()")
    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public ResponseEntity<?> findAll() throws Exception
    {
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public ResponseEntity<?> insertOne1() throws Exception
    {

        User user  = new User();
        user.setName("Khalid");
        user.setId("100");

        return ResponseEntity.ok(userService.insertOne((user)));
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public ResponseEntity<?> insertOne(@RequestBody User user) throws Exception
    {
        return ResponseEntity.ok(userService.insertOne((user)));
    }

    @RequestMapping(value = {"/ping"}, method = RequestMethod.GET)
    public ResponseEntity<?> ping() throws Exception
    {
        return ResponseEntity.ok("Ping!");
    }

    @RequestMapping(value = "/rss", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getEmployeesRssFeed() throws IllegalArgumentException, FeedException, IOException {


        // set up
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle("Employee List");
        feed.setDescription("A list of all employees");
        feed.setLink("https://example.com/employees");
        feed.setLanguage("en-us");
        feed.setPublishedDate(new Date());


        List<User> employees =  userService.findAll();
        String rssFeed ="";


        // Channel channel = new Channel();
        // channel.setTitle("Employee List");
        // channel.setDescription("A list of all employees");
        // channel.setLink("https://example.com/employees");
        // channel.setPubDate(new Date());

        // map to items
        List<SyndEntry> items = new ArrayList<>();
        for (User employee : employees) {
            // Item item = new Item();
            // item.setTitle(employee.getName());
            // // item.setDescription(new Description(employee.getName()));
            // item.setLink("imageUrl");
            // item.setPubDate(new Date());
            // items.add(item);
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle(employee.getName());
            entry.setLink("https://cdn.cnn.com/cnnnext/dam/assets/230403164607-22-trump-indictment-travel-new-york-super-169.jpg");
            entry.setPublishedDate(new Date());
            

            SyndContent description = new SyndContentImpl();
            description.setType("text/plain");
            description.setValue(employee.getName());
            entry.setDescription(description);
            items.add(entry);
        }
        // channel.setItems(items);

        feed.setEntries(items);

        SyndFeedOutput output = new SyndFeedOutput();
        StringWriter writer = new StringWriter();
        output.output(feed, writer);
        rssFeed = writer.toString();



        // String feedTitle = "Employee List";
        // String feedDescription = "A list of all employees";
        // String feedLink = "https://example.com/employees";
        // String feedLanguage = "en-us";
        // Date feedPubDate = new Date();
        // SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        // String feedPubDateString = formatter.format(feedPubDate);
        // //String feedPubDateString = DateTimeFormatter.RFC_1123_DATE_TIME.format(feedPubDate.toInstant());

        // String items = employees.stream()
        //   .map(e -> {
        //     String itemTitle = e.getName();
        //     String itemDescription = e.getName();
        //     String itemLink = "https://example.com/employees/" + e.getId();
        //     // itemPubDate = e.getCreatedDate();
        //    // String itemPubDateString = DateTimeFormatter.RFC_1123_DATE_TIME.format(itemPubDate.toInstant());
        //     return "<item>"
        //       + "<title>" + itemTitle + "</title>"
        //       + "<description>" + itemDescription + "</description>"
        //       + "<link>" + itemLink + "</link>"
        //       //+ "<enclosure url='https://example.com/images/image1.jpg' type='image/jpeg' length='12345' />"
        //     //   +"<media:group>"
        //     //   +"<media:content medium='image' url='https://cdn.cnn.com/cnnnext/dam/assets/230403164607-22-trump-indictment-travel-new-york-super-169.jpg' height='619' width='1100' type='image/jpeg'/>"
        //     //   +"</media:group>"
        //      //+ "<pubDate>" + itemPubDateString + "</pubDate>"
        //       + "</item>";
        //   })
        //   .collect(Collectors.joining());


        return ResponseEntity.ok(rssFeed);
        //return ResponseEntity.ok("Ping1111!");

    }

    // @RequestMapping(value = "/rss", produces = MediaType.APPLICATION_XML_VALUE)
    // public ResponseEntity<?> getEmployeesRssFeed() {


       

    //     List<User> employees =  userService.findAll();

    //     String feedTitle = "Employee List";
    //     String feedDescription = "A list of all employees";
    //     String feedLink = "https://example.com/employees";
    //     String feedLanguage = "en-us";
    //     Date feedPubDate = new Date();
    //     SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
    //     String feedPubDateString = formatter.format(feedPubDate);
    //     //String feedPubDateString = DateTimeFormatter.RFC_1123_DATE_TIME.format(feedPubDate.toInstant());

    //     String items = employees.stream()
    //       .map(e -> {
    //         String itemTitle = e.getName();
    //         String itemDescription = e.getName();
    //         String itemLink = "https://example.com/employees/" + e.getId();
    //         // itemPubDate = e.getCreatedDate();
    //        // String itemPubDateString = DateTimeFormatter.RFC_1123_DATE_TIME.format(itemPubDate.toInstant());
    //         return "<item>"
    //           + "<title>" + itemTitle + "</title>"
    //           + "<description>" + itemDescription + "</description>"
    //           + "<link>" + itemLink + "</link>"
    //           //+ "<enclosure url='https://example.com/images/image1.jpg' type='image/jpeg' length='12345' />"
    //         //   +"<media:group>"
    //         //   +"<media:content medium='image' url='https://cdn.cnn.com/cnnnext/dam/assets/230403164607-22-trump-indictment-travel-new-york-super-169.jpg' height='619' width='1100' type='image/jpeg'/>"
    //         //   +"</media:group>"
    //          //+ "<pubDate>" + itemPubDateString + "</pubDate>"
    //           + "</item>";
    //       })
    //       .collect(Collectors.joining());

    //     String rssFeed = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
    //       + "<rss xmlns:content=\"http://purl.org/rss/1.0/modules/content/\" xmlns:atom=\"http://www.w3.org/2005/Atom\" xmlns:media=\"http://search.yahoo.com/mrss/\" version=\"2.0\">"
    //       + "<channel>"
    //       + "<title>" + feedTitle + "</title>"
    //       + "<description>" + feedDescription + "</description>"
    //       + "<link>" + feedLink + "</link>"
    //       + "<language>" + feedLanguage + "</language>"
    //       + "<pubDate>" + feedPubDateString + "</pubDate>"
    //       + items
    //       + "</channel>"
    //       + "</rss>";

    //     return ResponseEntity.ok(rssFeed);
    //     //return ResponseEntity.ok("Ping1111!");

    // }

    
}