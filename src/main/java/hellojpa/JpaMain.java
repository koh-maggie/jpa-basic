package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 데이터베이스연결도 된다.
        // WEB Application 로드 시점에 DB 별로 딱 하나만 생성된다.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        // EntityManager 는 자바로 치면 하나의 컬렉션으로 생각하면 된 다.
        // 고객의 요청에 따라 , 생성(CREATE) 되었다가 버려졌다가(CLOSE) 하게 된다.
        EntityManager em = emf.createEntityManager();

        // 데이터의 모든 변경은 트랜잭션 안에서 이루어져야 한다.
        // 추후, Spring 에서는 @Transactoinal 을 지원하니 큰 문제가 되지 않을 것 .
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // 실제 동작하는 코드가 들어간다.
            // 비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloB");

            // 영속 상태
//            System.out.println("------ BEFORE ------");
//            em.persist(member);
//            System.out.println("------ AFTER ------");

//            Member findMember1 = em.find(Member.class , 101L); // select 쿼리 발생
//            Member findMember2 = em.find(Member.class , 101L); // 1차 캐쉬에서 조회
//
//            System.out.println(" result = " + (findMember1 == findMember2));

//            Member findMemeber = em.find(Member.class, 1L);

            // 쿼리에서 from 절의 대상은 DB 테이블의 Member 가 아니라, 객체로 봐야한다.
//            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member findMember : findMembers) {
//                System.out.println(findMember.getName());
//            }

            // 비영속 상태
//            Member member1 = new Member(150L , "A");
//            Member member2 = new Member(160L , "B");

            // 영속 상태 ( 1차 캐쉬, 쓰기 지연 구간 저장 )
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=============================================");

            // JPA 수정 ( 변경 감지 )
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");
//
//            em.clear();
//
//            Member member2 = em.find(Member.class, 150L);
//            System.out.println("member2 = " + member2.getName());
//
//            System.out.println("------------------------------");


            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GEUSET);

            em.persist(member);

            // 데이터베이스에 변경 쿼리 실행
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }

}
