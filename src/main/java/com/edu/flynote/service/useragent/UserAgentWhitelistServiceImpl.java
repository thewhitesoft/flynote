package com.edu.flynote.service.useragent;

import com.edu.flynote.entity.UserAgentWhitelist;
import com.edu.flynote.repository.UserAgentWhitelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAgentWhitelistServiceImpl implements UserAgentWhitelistService {

    private final UserAgentWhitelistRepository repository;

    @Autowired
    public UserAgentWhitelistServiceImpl(UserAgentWhitelistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> getAllValues() {
        return repository.findAll()
                         .stream()
                         .map(UserAgentWhitelist::getValue)
                         .collect(Collectors.toList());
    }
}
