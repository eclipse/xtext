/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractConcreteSyntaxValidator implements IConcreteSyntaxValidator {

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String language;

	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		return true;
	}

	public boolean validateRecursive(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractConcreteSyntaxValidator)
			return language.equals(((AbstractConcreteSyntaxValidator) obj).language);
		return false;
	}

	@Override
	public int hashCode() {
		return language.hashCode();
	}

}
