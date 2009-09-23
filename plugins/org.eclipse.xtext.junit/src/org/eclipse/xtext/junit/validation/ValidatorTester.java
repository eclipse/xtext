/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.State;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 */
public class ValidatorTester<T extends AbstractDeclarativeValidator> extends AbstractValidatorTester {

	protected T validator;

	protected boolean validatorCalled;

	public ValidatorTester(T validator) {
		this.validator = validator;
		EValidatorRegistrar regis = this.validator.getInjector().getInstance(EValidatorRegistrar.class);
		EValidator.Registry reg = regis.getRegistry();
		regis.setRegistry(new EValidatorRegistryImpl());
		this.validator.register(regis);
		diagnostician = new Diagnostician(regis.getRegistry());
		regis.setRegistry(reg);
		validatorCalled = false;
	}

	public AssertableDiagnostics diagnose() {
		if (!validatorCalled)
			throw new IllegalStateException("You have to call validator() before you call diagnose()");
		validatorCalled = false;
		AssertableDiagnostics ad = new AssertableDiagnostics((Diagnostic) validator.setMessageAcceptor(validator)
				.getState().chain);
		validator.setMessageAcceptor(validator).getState().chain = new BasicDiagnostic();
		return ad;
	}

	public T validator() {
		State s = validator.setMessageAcceptor(validator).getState();
		if (s.chain == null)
			s.chain = new BasicDiagnostic();
		validatorCalled = true;
		return validator;
	}

}
