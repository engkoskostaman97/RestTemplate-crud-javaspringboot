package springboot.studyjava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springboot.studyjava.entity.Todo;
import springboot.studyjava.entity.UserName;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class HelloWorldController {
RestTemplate restTemplate = new RestTemplate();
//nghint Api RestTemplate
    //Get Data Localserver
//    @GetMapping("/todos/get")
//    public  String getData(){
//        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
//            return  result;
//        }
//
//        //post
//     @PostMapping("/todos/post")
//    public  String postTodo(){
//         HttpHeaders headers = new HttpHeaders();
//         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//         Todo newTodo = new Todo();
//         newTodo.setId((long) 100);
//         newTodo.setTitle("joe");
//         newTodo.setUserId((long)9);
//         newTodo.setCompleted(false);
//
//         HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo,headers);
//
//         return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST,entity,String.class).getBody();
//
//     }
//     //delete
//    @GetMapping("/todos/delete")
//    public  String deleteTodo(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        Todo newTodo = new Todo();
//        newTodo.setId((long)1);
//
//        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);
//        return  restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + newTodo.getId(), HttpMethod.DELETE,entity, String.class).getBody();
//    }
//
//    //update
//    @GetMapping("/todos/put/{id}")
//    public String updateTodo(@PathVariable("id") String id){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        Todo updateTodo = new Todo();
//        updateTodo.setTitle("JOHN WICK");
//        updateTodo.setCompleted(true);
//
//        HttpEntity<Todo> entity = new HttpEntity<Todo>(updateTodo, headers);
//
//        return  restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/"+ id,HttpMethod.PUT,entity,String.class).getBody();
//    }

//
    @GetMapping("/hello")
    public  String HelloWorld(){
        return  "Hello Engkos";
    }
    @GetMapping("/helloworld/{name}")
        public String HelloWorldName(@PathVariable(value = "name") String name){
        return  "hello" +  name ;
        }
    @PostMapping("/helloworld")
    public  String HelloWorldPostController (@RequestParam(name = "userName") String username){
        return "hello" + username;

    }
    @PostMapping("/hellopost")
    public UserName HelloWorldUserController(@Valid @RequestBody UserName userName){
        return  userName;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex)
    throws JsonProcessingException
    {
        List<String> errors = new ArrayList<>();
        Map<Integer, String> errorsMap = new HashMap<Integer, String>();
        int counter = 0;

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        for (String err : errors){
            counter++;
            errorsMap.put(counter,  err);
        }
        return ResponseEntity.ok().body(errorsMap);
    }


    @GetMapping("/home")
    public ResponseEntity<String> home(){
        throw new RuntimeException("ada error");
//        return new ResponseEntity<>("HALLLO" ,HttpStatus.OK);
    }
}
