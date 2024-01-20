package com.vti.testing.specification;

import com.vti.testing.entity.CustomerReceiveAlertPrice;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CustomerReceiveAlertPriceSpecification {
    public static Specification<CustomerReceiveAlertPrice> buildSpec(CustomerReceiveAlertPriceFilterForm form) {
        return (root, query, builder) -> {
            if (form == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                Path<String> fullName = root.get("fullName");
                Predicate hasFullNameLike = builder.like(fullName, pattern);
                Path<String> phoneNumber = root.get("phoneNumber");
                Predicate hasPhoneNumberLike = builder.like(phoneNumber, pattern);
                predicates.add(builder.or(hasFullNameLike, hasPhoneNumberLike));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
