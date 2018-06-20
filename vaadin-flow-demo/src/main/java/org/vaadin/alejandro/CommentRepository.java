package org.vaadin.alejandro;

import java.util.List;

/**
 * @author Alejandro Duarte
 */
public class CommentRepository {

    public static List<Comment> findAll() {
        return JPAService.runInTransaction(em ->
                em.createQuery("select c from Comment c").getResultList()
        );
    }

    public static void save(Comment comment) {
        JPAService.runInTransaction(em -> {
            em.persist(comment);
            return null;
        });
    }

}
