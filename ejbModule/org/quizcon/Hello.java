package org.quizcon;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Hello
 */
@Stateless
public class Hello implements HelloRemote {

    /**
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
