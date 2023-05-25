package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "select * from attachments where status_id = :id", nativeQuery = true)
    Iterable<Image> findAllByStatus(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from attachments where status_id = :statusId", nativeQuery = true)
    void deleteAllByStatusId(@Param("statusId") Long statusId);

    @Query(value = "select image.link,image.id,image.status_id, image.type from attachments image join status s on s.id = image.status_id join user_table u on u.id = s.owner_id\n" +
            "where u.id = :idUser and s.status <> 0 order by s.create_at desc", nativeQuery = true)
    Iterable<Image> findAllImageByUserId(@Param("idUser") Long idUser);

    @Query(value = "select image.link,image.id,image.status_id, image.type from attachments image join status s on s.id = image.status_id join user_table u on u.id = s.owner_id\n" +
            "where u.id = :idUser and s.status <> 0 order by s.create_at desc limit 5", nativeQuery = true)
    Iterable<Image> top5ImageByUserId(@Param("idUser") Long idUser);
}
