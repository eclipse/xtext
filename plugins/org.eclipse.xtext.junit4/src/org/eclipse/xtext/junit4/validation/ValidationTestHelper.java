/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import static com.google.common.collect.Iterables.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class ValidationTestHelper {

	public List<Issue> validate(EObject model) {
		IResourceValidator validator = ((XtextResource) model.eResource()).getResourceServiceProvider()
				.getResourceValidator();
		return validator.validate(model.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	public void assertNoIssues(final EObject model) {
		final List<Issue> validate = validate(model);
		if (!isEmpty(validate))
			fail("Expected no issues, but got :" + getIssuesAsString(model, validate, new StringBuilder()));
	}
	
	public void assertNoErrors(final EObject model) {
		final List<Issue> validate = validate(model);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				return Severity.ERROR == input.getSeverity();
			}
		});
		if (!isEmpty(issues))
			fail("Expected no errors, but got :" + getIssuesAsString(model, issues, new StringBuilder()));
	}

	public void assertNoError(final EObject model, final String issuecode) {
		final List<Issue> validate = validate(model);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				return issuecode.equals(input.getCode());
			}
		});
		if (!isEmpty(issues))
			fail("Expected no error '" + issuecode + "' but got " + getIssuesAsString(model, issues, new StringBuilder()));
	}

	/**
	 * @since 2.4
	 */
	public void assertNoErrors(final EObject model, final EClass objectType, final String code,
			final String... messageParts) {
		assertNoIssues(model, objectType, code, Severity.ERROR, messageParts);
	}
	
	/**
	 * @since 2.6
	 */
	public void assertNoErrors(final EObject model, final String code) {
		assertNoIssues(model, EcorePackage.Literals.EOBJECT, code, Severity.ERROR);
	}
	
	/**
	 * @since 2.4
	 */
	public void assertNoIssues(final EObject root, final EClass objectType) {
		final List<Issue> validate = validate(root);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				EObject object = root.eResource().getEObject(input.getUriToProblem().fragment());
				if (objectType.isInstance(object)) {
					return true;
				}
				return false;
			}
		});
		if (!isEmpty(issues))
			fail("Expected no error on instances of  '" + objectType.getName() + "' but got " + getIssuesAsString(root, issues, new StringBuilder()));
	}
	
	/**
	 * @since 2.4
	 */
	public void assertNoIssue(final EObject root, final EClass objectType, final String issuecode) {
		final List<Issue> validate = validate(root);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				if (issuecode.equals(input.getCode())) {
					EObject object = root.eResource().getEObject(input.getUriToProblem().fragment());
					if (objectType.isInstance(object)) {
						return true;
					}
				}
				return false;
			}
		});
		if (!isEmpty(issues)) {
			fail("Expected no error '" + issuecode + "' but got " + getIssuesAsString(root, issues, new StringBuilder()));
		}
	}

	/**
	 * @since 2.4
	 */
	public void assertError(final EObject model, final EClass objectType, final String code, int offset, int length, 
			final String... messageParts) {
		assertIssue(model, objectType, code, offset, length, Severity.ERROR, messageParts);
	}

	public void assertError(final EObject model, final EClass objectType, final String code,
			final String... messageParts) {
		assertIssue(model, objectType, code, Severity.ERROR, messageParts);
	}
	
	/**
	 * @since 2.4
	 */
	public void assertIssue(final EObject model, final EClass objectType, final String code, final Severity severity,
			final String... messageParts) {
		assertIssue(model, objectType, code, -1, -1, severity, messageParts);
	}
	
	/**
	 * @since 2.4
	 */
	public void assertIssue(final EObject model, final EClass objectType, final String code, final int offset, final int length,  final Severity severity,
			final String... messageParts) {
		final List<Issue> allIssues = validate(model);
		final Iterable<Issue> validate = matchIssues(model, objectType, code, offset, length, severity, allIssues, messageParts);
		if (Iterables.isEmpty(validate)) {
			StringBuilder message = new StringBuilder("Expected ")
				.append(severity)
				.append(" '")
				.append(code)
				.append("' on ")
				.append(objectType.getName())
				.append(" but got\n");
			getIssuesAsString(model, allIssues, message);
			assertEquals(Joiner.on('\n').join(messageParts), message.toString());
			fail(message.toString());
		}
	}
	
	/**
	 * @since 2.4
	 */
	public void assertNoIssues(final EObject model, final EClass objectType, final String code, final Severity severity,
			final String... messageParts) {
		assertNoIssues(model, objectType, code, -1, -1, severity, messageParts);
	}
	
	/**
	 * @since 2.4
	 */
	public void assertNoIssues(final EObject model, final EClass objectType, final String code, final int offset, final int length,  final Severity severity,
			final String... messageParts) {
		final List<Issue> allIssues = validate(model);
		final Iterable<Issue> validate = matchIssues(model, objectType, code, offset, length, severity, allIssues, messageParts);
		if (!Iterables.isEmpty(validate)) {
			StringBuilder message = new StringBuilder("Expected no ")
				.append(severity)
				.append(" '")
				.append(code)
				.append("' on ")
				.append(objectType.getName())
				.append(" but got\n");
			getIssuesAsString(model, allIssues, message);
			assertEquals(Joiner.on('\n').join(messageParts), message.toString());
			fail(message.toString());
		}
	}

	/**
	 * @since 2.4
	 */
	protected Iterable<Issue> matchIssues(final EObject model, final EClass objectType, final String code,
			final int offset, final int length, final Severity severity, final List<Issue> validate,
			final String... messageParts) {
		return Iterables.filter(validate, new Predicate<Issue>() {
			public boolean apply(Issue input) {
				if (Strings.equal(input.getCode(), code) && input.getSeverity()==severity) {
					if ((offset < 0 || offset == input.getOffset()) && (length < 0 || length == input.getLength())) {
						EObject object = model.eResource().getResourceSet().getEObject(input.getUriToProblem(), true);
						if (objectType.isInstance(object)) {
							for (String messagePart : messageParts) {
								if (!input.getMessage().toLowerCase().contains(messagePart.toLowerCase())) {
									return false;
								}
							}
							return true;
						}
					}
				}
				return false;
			}
		});
	}

	/**
	 * @since 2.4
	 */
	protected StringBuilder getIssuesAsString(final EObject model, final Iterable<Issue> issues, StringBuilder result) {
		for (Issue issue : issues) {
			URI uri = issue.getUriToProblem();
			result.append(issue.getSeverity());
			result.append(" (");
			result.append(issue.getCode());
			result.append(") '");
			result.append(issue.getMessage());
			result.append("'");
			if (uri != null) {
				EObject eObject = model.eResource().getResourceSet().getEObject(uri, true);
				result.append(" on ");
				result.append(eObject.eClass().getName());
			}
			result.append("\n");
		}
		return result;
	}

	public void assertWarning(final EObject model, final EClass objectType, final String code,
			final String... messageParts) {
		assertIssue(model, objectType, code, Severity.WARNING, messageParts);
	}

	/**
	 * @since 2.4
	 */
	public void assertNoWarnings(final EObject model, final EClass objectType, final String code,
			final String... messageParts) {
		assertNoIssues(model, objectType, code, Severity.WARNING, messageParts);
	}

	/**
	 * @since 2.4
	 */
	public void assertWarning(final EObject model, final EClass objectType, final String code, int offset, int length, 
			final String... messageParts) {
		assertIssue(model, objectType, code, offset, length, Severity.WARNING, messageParts);
	}

}
