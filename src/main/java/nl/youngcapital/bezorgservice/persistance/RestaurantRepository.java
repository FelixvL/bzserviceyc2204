package nl.youngcapital.bezorgservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.youngcapital.bezorgservice.domein.Restaurant;


@Component
//public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
	public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
