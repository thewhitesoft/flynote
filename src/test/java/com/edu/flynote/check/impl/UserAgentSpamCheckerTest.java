package com.edu.flynote.check.impl;

import com.edu.flynote.service.useragent.UserAgentWhitelistService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserAgentSpamCheckerTest {

    private UserAgentWhitelistService userAgentWhitelistService
            = mock(UserAgentWhitelistService.class);

    private UserAgentSpamChecker checker
            = new UserAgentSpamChecker(userAgentWhitelistService);

    @BeforeEach
    void setUp() {
        when(userAgentWhitelistService.getAllValues())
                .thenReturn(Lists.list("Chrome",
                                       "Firefox"));
    }

    @Test
    void execute() {
        // Arrange
        String userAgent = "IE";
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        when(requestMock.getHeader("User-Agent")).thenReturn(userAgent);

        // Act & Assert
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                         () -> checker.execute(requestMock));

        assertThat(runtimeException.getMessage()).isEqualTo("User agent not in whitelist!");
    }

    @Test
    void executeWhenInWhitelist() {
        // Arrange
        String userAgent = "Chrome";
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        when(requestMock.getHeader("User-Agent")).thenReturn(userAgent);

        // Act & Assert
        checker.execute(requestMock);

        // do not expect exception
    }

    @Test
    void executeWhenHeaderNotSet() {
        // Arrange
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        when(requestMock.getHeader("User-Agent")).thenReturn(null);

        // Act & Assert
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                         () -> checker.execute(requestMock));

        assertThat(runtimeException.getMessage()).isEqualTo("User agent not in whitelist!");
    }
}