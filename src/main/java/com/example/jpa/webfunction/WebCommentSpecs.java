package com.example.jpa.webfunction;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class WebCommentSpecs {

    public static Specification<WebComment> isbBest() {
        return (Specification<WebComment>) (root, query, builder) -> builder.isTrue(root.get(WebComment_.best));
    }

    public static Specification<WebComment> isGood() {
        return (Specification<WebComment>) (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(WebComment_.up),10);
    }
}
