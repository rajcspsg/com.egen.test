package com.egen.app.dao;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;
import com.egen.dao.UserRepository;
import com.egen.entities.User;


import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTests {
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    User user = new User("Raj", "Gounder", "Kumar", 28, 'M', 2345678910L, 02451);
    
    @Test
    public void testExample() throws Exception {
        this.entityManager.persist(user);
        Optional<User> userOptional = this.repository.findByFirstname("sboot");
        Assert.assertEquals(true, userOptional.isPresent());
    }
}
