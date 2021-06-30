package com.edu.flynote.check.impl;

import com.edu.flynote.check.SpamChecker;
import com.edu.flynote.check.SpamForbiddenException;
import com.edu.flynote.service.useragent.UserAgentWhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class UserAgentSpamChecker implements SpamChecker {

    private final UserAgentWhitelistService userAgentWhitelistService;

    @Autowired
    public UserAgentSpamChecker(UserAgentWhitelistService userAgentWhitelistService) {
        this.userAgentWhitelistService = userAgentWhitelistService;
    }

    @Override
    public void execute(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        List<String> list = userAgentWhitelistService.getAllValues();

        boolean check = list.stream()
                            .anyMatch(whitelist -> whitelist.equals(userAgent));
        if (!check)
            throw new SpamForbiddenException("User agent not in whitelist!");
    }
}
