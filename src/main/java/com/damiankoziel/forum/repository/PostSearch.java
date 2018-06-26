package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.model.Post;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostSearch {

    @PersistenceContext
    private EntityManager entityManager;

    public List search(final String text) {


        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.
                        getFullTextEntityManager(entityManager);


        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Post.class).get();


        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .onFields("title")
                        .matching(text.concat("*"))
                        .createQuery();


        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Post.class);

        @SuppressWarnings("unchecked")
        List results = jpaQuery.getResultList();
        return results;
    }

}
