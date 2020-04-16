package com.example.jpa.webfunction;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware<WebAccount> {
    @Override
    public Optional<WebAccount> getCurrentAuditor() {
        System.out.println("looking for currunt user");
        return Optional.empty();
    }
}
