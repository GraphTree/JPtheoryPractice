package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");
            em.clear();
            Member member2 = em.find(Member.class, 150L);
            System.out.println("==============");
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloJPA2");
//            //영속
//            System.out.println("---before--");
//            em.persist(member);
//            System.out.println("---after---");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findmember id = " + findMember.getId());
//            System.out.println("findmember name = " + findMember.getName());

//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList(); jpql 을 사용한 객체형 sql 조회
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);  삭제
//            findMember.setName("HelloJpa"); em.persist 하지 않아도 업데이트
//            em.persist(member);

            tx.commit();
        } catch (Exception e ){
            tx.rollback();
        } finally {
            em.clear();

        }
        emf.close();

    }
}
