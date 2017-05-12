package com.parasoft.parabank.web.controller;

import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.mock.web.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import com.parasoft.parabank.util.*;
import com.parasoft.parabank.web.*;

public class LogoutControllerTest extends AbstractControllerTest<LogoutController> {
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        setPath("/logout.htm");
        setFormName("none");
        registerSession(request);
        //        final MockHttpSession session = new MockHttpSession();
        //        final Customer customer = new Customer();
        //        customer.setId(1);
        //        session.setAttribute(Constants.USERSESSION, new UserSession(customer));
        //        request.setSession(session);
    }

    @Test
    public void testHandleRequest() throws Exception {
        UserSession session = (UserSession) request.getSession().getAttribute(Constants.USERSESSION);
        assertNotNull(session);
        //RequestContextListener
        final ModelAndView mav = processGetRequest(request, new MockHttpServletResponse());

        //final ModelAndView mav = controller.handleRequest(request, response);
        assertNotNull(mav);
        // assertEquals("/index.htm", ((RedirectView) mav.getView()).getUrl());
        assertEquals("/index.htm", ((RedirectView) mav.getView()).getUrl());
        //        assertNull(mav);
        //        assertEquals("index.htm", response.getRedirectedUrl());
        session = (UserSession) request.getSession().getAttribute(Constants.USERSESSION);
        assertNull(session);
    }
}
