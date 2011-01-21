package org.eclipse.xtext.example.validation;

import org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage;
import org.eclipse.xtext.example.fowlerdsl.Statemachine;
import org.eclipse.xtext.validation.Check;
 

public class FowlerDslJavaValidator extends AbstractFowlerDslJavaValidator {

	@Check
	public void checkStatesExist(Statemachine sm) {
		if (sm.getStates().isEmpty()) {
			warning("A Statemachine should have at least one state", FowlerdslPackage.Literals.STATEMACHINE__STATES);
		}
	}

}
