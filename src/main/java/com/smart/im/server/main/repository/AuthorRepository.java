//package com.smart.im.server.main.repository;
//
//
//import com.smart.im.server.main.entity.User;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//public interface AuthorRepository extends JpaRepository<User,Integer> {
//
//    @Transactional(readOnly = true)
//    @Query("select u from Author u where (u.author_id = :author_id) and (u.name like :author_name)")
//    Optional<Author> getAuthorByIdAndName(@Param("author_id") int author_id, @Param("author_name") String author_name);
//
//}
