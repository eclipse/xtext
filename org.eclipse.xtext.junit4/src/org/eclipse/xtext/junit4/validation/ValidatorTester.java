/*******************************************************************************
 * Copyright (c) 2009, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.State;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class ValidatorTester<T extends AbstractDeclarativeValidator> extends AbstractValidatorTester {

	protected T validator;

	protected boolean validatorCalled;

	public ValidatorTester(T validator, Injector injector) {
		this(validator,
			injector.getInstance(EValidatorRegistrar.class),
			injector.getInstance(Key.get(String.class, Names.named(Constants.LANGUAGE_NAME))));
	}
	
	@Inject
	public ValidatorTester(T validator, EValidatorRegistrar registrar, @Named(Constants.LANGUAGE_NAME) final String languageName) {
		this.validator = validator;
		EValidator.Registry originalRegistry = registrar.getRegistry();
		EValidatorRegistryImpl newRegistry = new EValidatorRegistryImpl();
		registrar.setRegistry(newRegistry);
		this.validator.register(registrar);
		diagnostician = new Diagnostician(newRegistry) {
			@Override
			public java.util.Map<Object,Object> createDefaultContext() {
				java.util.Map<Object,Object> map = super.createDefaultContext();
				map.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME, languageName);
				return map;
			}
		};
		registrar.setRegistry(originalRegistry);
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
