package lv.merrill.audion;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class GreetingJpaRepository implements GreetingRepository {

    private EntityManager entityManager;

    public GreetingJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String findGreeting() {
        return entityManager.find(GreetingEntity.class, "hello-world").getText();
    }
}
