package springboot.studyjava.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springboot.studyjava.entity.Todo;
import springboot.studyjava.entity.UserName;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
public class HelloWorldController {
RestTemplate restTemplate = new RestTemplate();
//nghint Api RestTemplate
    //Get Data Localserver
    @GetMapping("/todos/get")
    public  String getData(){
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
            return  result;
        }

        //post
     @PostMapping("/todos/post")
    public  String postTodo(){
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

         Todo newTodo = new Todo();
         newTodo.setId((long) 100);
         newTodo.setTitle("joe");
         newTodo.setUserId((long)9);
         newTodo.setCompleted(false);

         HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo,headers);

         return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST,entity,String.class).getBody();

     }
     //delete
    @GetMapping("/todos/delete")
    public  String deleteTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long)1);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);
        return  restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + newTodo.getId(), HttpMethod.DELETE,entity, String.class).getBody();
    }

    //update
    @GetMapping("/todos/put/{id}")
    public String updateTodo(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo updateTodo = new Todo();
        updateTodo.setTitle("JOHN WICK");
        updateTodo.setCompleted(true);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(updateTodo, headers);

        return  restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/"+ id,HttpMethod.PUT,entity,String.class).getBody();
    }


//    @GetMapping("/hello")
//    public  String HelloWorld(){
//        return  "Hello Engkos";
//    }
//    @GetMapping("/helloworld/{name}")
//        public String HelloWorldName(@PathVariable(value = "name") String name){
//        return  "hello" +  name ;
//        }
//    @PostMapping("/helloworld")
//    public  String HelloWorldPostController (@RequestParam(name = "userName") String username){
//        return "hello" + username;
//    }
//
//    @PostMapping("/hellopost")
//    public UserName helloPostController (@Validated @RequestBody UserName userName){
//        System.out.println("datatatat");
//        return  userName;
//    }
}
