package za.ac.cput.Repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import za.ac.cput.Domain.Admin;

public interface IAdminRepository extends JpaRepository<Admin, String> {
}
