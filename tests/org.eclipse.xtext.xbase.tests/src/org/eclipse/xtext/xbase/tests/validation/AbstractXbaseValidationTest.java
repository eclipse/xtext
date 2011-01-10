/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractXbaseValidationTest extends AbstractXbaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected List<Issue> validate(EObject model) throws Exception {
		IResourceValidator validator = ((XtextResource)model.eResource()).getResourceServiceProvider().getResourceValidator();
		return validator.validate(model.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	public void assertNoError(final EObject model, final String issuecode) throws Exception {
		final List<Issue> validate = validate(model);
		if (!validate.isEmpty())
			System.err.println(validate.toString());
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				return issuecode.equals(input.getCode());
			}
		});
		if (!isEmpty(issues))
			fail("Expected no error '" + issuecode + "' but got " + issues);
	}

	public void assertError(final EObject model, final EClass objectType, final String code, final String... messageParts) throws Exception {
		final List<Issue> validate = validate(model);
		Iterable<Issue> matchingErrors = Iterables.filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				if (Strings.equal(input.getCode(), code)) {
					EObject object = model.eResource().getResourceSet().getEObject(input.getUriToProblem(), true);
					if (objectType.isInstance(object)) {
						for (String messagePart : messageParts) {
							if (!input.getMessage().contains(messagePart)) {
								return false;
							}
						}
						return true;
					}
				}
				return false;
			}
		});
		if (Iterables.isEmpty(matchingErrors))
			fail("Expected error '" + code + "' but got " + matchingErrors);
	}
}
