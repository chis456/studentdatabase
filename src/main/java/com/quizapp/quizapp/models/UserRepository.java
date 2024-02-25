package com.quizapp.quizapp.models;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
    List<User> findByName(String name);
    List<User> findByHeight(double height);
    List<User> findByWeight(double weight);
    List<User> findByHairColour(String hairColour);
    List<User> findByGpa(double gpa);
    List<User> findByUid(int uid);
    List<User> findByInternational(String international);
    //List<Student> findBy
}