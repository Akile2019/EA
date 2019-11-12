package minipro2.order.repositories;

import minipro2.order.model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order1, Integer> {

}
