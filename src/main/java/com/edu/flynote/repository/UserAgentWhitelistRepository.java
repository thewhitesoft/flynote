package com.edu.flynote.repository;

import com.edu.flynote.entity.UserAgentWhitelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentWhitelistRepository extends JpaRepository<UserAgentWhitelist, Long> {
}
