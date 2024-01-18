package com.vti.testing.specification;

import com.vti.testing.entity.Account;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {

    public static Specification<Account> usernameEquals(String username) {
        return (root, query, builder) -> builder.equal(root.get("username"), username);
    }
}