/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class EValidatorRegistrar {

	@Inject
	private EValidator.Registry registry;

	@Inject
	private Provider<CompositeEValidator> compositeProvider;
	
	public void register(EPackage ePackage, EValidator registerMe) {
		EValidator validator = getRegistry().getEValidator(ePackage);
		if (validator == null) {
			validator = compositeProvider.get();
		}
		else if (!(validator instanceof CompositeEValidator)) {
			CompositeEValidator newValidator = compositeProvider.get();
			newValidator.addValidator(validator);
			validator = newValidator;
		}
		((CompositeEValidator) validator).addValidator(registerMe);
		getRegistry().put(ePackage, validator);
	}

	public void setRegistry(EValidator.Registry registry) {
		this.registry = registry;
	}

	public EValidator.Registry getRegistry() {
		return registry;
	}

	public void setCompositeProvider(Provider<CompositeEValidator> compositeProvider) {
		this.compositeProvider = compositeProvider;
	}

	public Provider<CompositeEValidator> getCompositeProvider() {
		return compositeProvider;
	}
	
}
