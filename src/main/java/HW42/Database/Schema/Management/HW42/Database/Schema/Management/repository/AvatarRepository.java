package HW42.Database.Schema.Management.HW42.Database.Schema.Management.repository;


import hogwarts.HW41.SQL.and.Paging.Hogwarts.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvatarRepository extends JpaRepository<Avatar, Long> {
     Avatar findAvatarById (Long studentId);
}