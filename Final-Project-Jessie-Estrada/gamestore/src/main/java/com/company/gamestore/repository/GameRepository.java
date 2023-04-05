package com.company.gamestore.repository;


import com.company.gamestore.model.Game;
import com.company.gamestore.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    List<Game> findAllByStudio(String studio);
    List<Game> findAllByEsrbRating(String esrb_rating);

    List<Game> findAllByTitle(String  title);


}
