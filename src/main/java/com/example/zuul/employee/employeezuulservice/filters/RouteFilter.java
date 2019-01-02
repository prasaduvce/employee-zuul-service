package com.example.zuul.employee.employeezuulservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;

public class RouteFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "Route";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("Using route filter");
		HttpServletRequest request = ctx.getRequest();
		System.out.println("Request Method : "+request.getMethod()+" Request URL : "+request.getRequestURL().toString());
		request.setAttribute("user", "Ram");
		return null;
	}
}
