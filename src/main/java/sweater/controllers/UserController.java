package sweater.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sweater.objmodels.User;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private List<User> usersListStorage = new ArrayList<>();

    @GetMapping("/newuser")
    public String user(Map<String, Object> model){
        model.put("users", usersListStorage);
        return "newuser";
    }

    @PostMapping
    public String newUser(@RequestParam String firstName, @RequestParam String lastName, Map<String, Object> model){
        User user = new User(firstName, lastName);
        usersListStorage.add(user);
        model.put("users", usersListStorage);
        return "newuser";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        if(filter != null && !filter.isEmpty()) {
            model.put("users", findUser(usersListStorage, filter));
        }else {
            model.put("users", usersListStorage);
        }
        return "newuser";
    }

    private List<User> findUser(List<User> usersListStorage, String text){
       return usersListStorage.stream().filter(e -> e.getFirstName().contains(text) || e.getLastName().contains(text))
                .collect(Collectors.toList());
    }
}
