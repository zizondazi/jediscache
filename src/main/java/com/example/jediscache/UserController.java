package com.example.jediscache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    private final JedisPool jedisPool;

    @GetMapping("{id}/email")
    public String getUserEmail(@PathVariable Long id) {
        try(Jedis jedis = jedisPool.getResource()) {
            String userKey = "users:%d:email".formatted(id);
            // request cache
            String userEmail = jedis.get(userKey);
            if(userEmail != null) {
                return  userEmail;
            }
            // DB query
            userEmail = userRepository.findById(id).orElse(User.builder().build()).getEamil();

            // cache save
            jedis.set(userKey, userEmail);

            return userEmail;
        }
    }
}
