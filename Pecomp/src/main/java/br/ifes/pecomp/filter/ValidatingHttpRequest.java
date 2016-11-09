package br.ifes.pecomp.filter;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.hibernate.annotations.common.util.impl.LoggerFactory;


public class ValidatingHttpRequest extends HttpServletRequestWrapper {

	/**
	 * @see HttpServletRequestWrapper#ValidatingHttpRequest(HttpServletRequest)
	 */
	public ValidatingHttpRequest(HttpServletRequest request) {
        super(request);
	}


	/**
	 * Gets value of the parameter from the request,
	 * and validate it
	 * @param name name of the parameter
	 * @return valid value of the parameter
	 * @see HttpServletRequestWrapper#getParameter(String)
	 */
	@Override
	public String getParameter(String name) {
		HttpServletRequest request = (HttpServletRequest) super.getRequest();
		return validate(name, request.getParameter(name));
	}
	
	/**
	 * Checks value of the parameter in request.
	 * If it's valid, then returns value as is.
	 * If it is not valid, then returns default value.
	 * Default value is considering to be valid.
	 * @param name name of the parameter
	 * @param value value of the parameter
	 * @return valid value of the parameter
	 */
	private String validate(String name, String value) {

        return "";
	}    
	
}
