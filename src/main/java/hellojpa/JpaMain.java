package hellojpa;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("test");
            member.setAddress(new Address("a","b","c"));
            member.getFavoriteFooods().add("chick");
            member.getFavoriteFooods().add("hamburger");


            member.getAddressHistory().add(new Address("d", "d", "d"));
            member.getAddressHistory().add(new Address("d", "d", "d"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================= starter =================");
            Member findMember = em.find(Member.class, member.getId());

            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address =" + address.getStreet());

            }


            tx.commit();
        } catch (Exception e ){
            tx.rollback();
        } finally {
            em.clear();

        }
        emf.close();

    }
}
