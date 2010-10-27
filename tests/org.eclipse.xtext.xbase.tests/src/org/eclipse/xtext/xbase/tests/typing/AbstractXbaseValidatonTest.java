/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.internal.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractXbaseValidatonTest extends AbstractXbaseTestCase implements ValidationMessageAcceptor {

	protected List<Triple<String, EObject, String>> errors;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resetErrors();
	}

	protected void resetErrors() {
		errors = Lists.newArrayList();
	}

	public void acceptError(String message, EObject object, Integer feature, String code, String... issueData) {
		errors.add(Tuples.create(message, object, code));
	}

	public void acceptWarning(String message, EObject object, Integer feature, String code, String... issueData) {
	}

	public void assertNoError(final String code) {
		Iterable<Triple<String, EObject, String>> matchingErrors = Iterables.filter(errors, new Predicate<Triple<String, EObject, String>>() {
			public boolean apply(Triple<String, EObject, String> input) {
				return  Strings.equal(input.getThird(), code);
			}
		});
		if (!Iterables.isEmpty(matchingErrors))
			fail("Expected no error '" + code + "' but got " + errors.toString());
	}

	public void assertError(final EClass objectType, final String code, final String... messageParts) {
		Iterable<Triple<String, EObject, String>> matchingErrors = Iterables.filter(errors, new Predicate<Triple<String, EObject, String>>() {
			public boolean apply(Triple<String, EObject, String> input) {
				if (objectType.isInstance(input.getSecond()) && Strings.equal(input.getThird(), code)) {
					for (String messagePart : messageParts) {
						if (!input.getFirst().contains(messagePart)) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
		});
		if (Iterables.isEmpty(matchingErrors))
			fail("Expected error '" + code + "' but got " + errors.toString());
	}
}
