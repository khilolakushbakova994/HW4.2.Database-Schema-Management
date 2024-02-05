package HW42.Database.Schema.Management.HW42.Database.Schema.Management.repository;



import HW42.Database.Schema.Management.HW42.Database.Schema.Management.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvatarRepository extends JpaRepository<Avatar, Long> {
     Avatar findAvatarById (Long studentId);
}