package com.example.support.controllers;

import com.example.support.models.User;
import com.example.support.services.UserService;
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




        return ResponseEntity.ok(rssFeed);
    }

    
           
}