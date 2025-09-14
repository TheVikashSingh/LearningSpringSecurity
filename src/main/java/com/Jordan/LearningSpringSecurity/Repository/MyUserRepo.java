package com.Jordan.LearningSpringSecurity.Repository;

import com.Jordan.LearningSpringSecurity.Model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyUserRepo extends JpaRepository<Userinfo, Long>{

    Userinfo findByName(String name);

}
