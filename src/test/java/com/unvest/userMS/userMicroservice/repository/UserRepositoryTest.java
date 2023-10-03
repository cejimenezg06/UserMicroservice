package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.NewWatchlist;
import com.unvest.userMS.userMicroservice.entity.Perfil;
import com.unvest.userMS.userMicroservice.entity.StockWatchlist;
import com.unvest.userMS.userMicroservice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test                   // Saving a User with a profile assigned
    public void saveUserWithPerfil() {

        Perfil perfil =
                Perfil.builder()
                        .namePerfil("JJJJJ")
                        .lastNamePerfil("AJJJJJJH")
                        .emailPerfil("HHHJJ")
                        .phonePerfil("3HHJ")
                        .imagePerfil("img11HJJJJJJJJJ")
                        .build();
        StockWatchlist stockWatchlist1 =
                StockWatchlist.builder()
                        .descriptionStock("StJJJJJJJJJJ")
                        .build();
        StockWatchlist stockWatchlist2 =
                StockWatchlist.builder()
                        .descriptionStock("HJJJJJJJJJJJJJ")
                        .build();
        NewWatchlist newWatchlist1 =
                NewWatchlist.builder()
                        .descriptionNew("JJJJJJJJJ")
                        .build();
        NewWatchlist newWatchlist2 =
                NewWatchlist.builder()
                        .descriptionNew("HJJJJJJJJJ")
                        .build();

        User user =
                User.builder()
                        .nameUser("JJJJ")
                        .passwordUser("JJJJJ")
                        .perfil(perfil)
                        .stockWatchlistList(List.of(stockWatchlist1, stockWatchlist2))
                        .newWatchlistsList(List.of(newWatchlist1, newWatchlist2))
                        .build();

        userRepository.save(user);
    }
    
    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("users = " + users);
    }


}