package com.edu.flynote.check;

import javax.servlet.http.HttpServletRequest;

public interface SpamChecker {

    void execute(HttpServletRequest request);
}
