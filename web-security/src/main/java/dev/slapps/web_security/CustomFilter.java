// Copyright 2025 Qvalent Pty. Ltd.
package dev.slapps.web_security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class CustomFilter implements Filter {

  @Override
  public void doFilter(
      final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {

    System.out.println("CustomFilter.doFilter()");
    chain.doFilter(request, response);

  }
}
