package com.parsing.demo.repo;

import com.parsing.demo.model.Syn1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SynonymRepo extends JpaRepository<Syn1, Integer> {

    @Query()
    List<Syn1> findByWord(String word);

}
