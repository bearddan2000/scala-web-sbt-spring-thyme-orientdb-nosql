package example.repository;

import org.springframework.stereotype.Repository;

import example.model.Dog;

@Repository("dogRepository")
trait DogRepository {
  def save(dog: Dog): Unit
  def findAll(): List[Dog]
}
