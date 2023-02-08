/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import static com.google.common.collect.Iterables.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Arrays;
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
 * @deprecated Use org.eclipse.xtext.testing.validation.ValidationTestHelper instead
 */
@Deprecated(forRemoval = true)
public class ValidationTestHelper {

	public List<Issue> validate(EObject model) {
		return validate(model.eResource());
	}
	
	public void assertNoIssues(final EObject model) {
		assertNoIssues(model.eResource());
	}
	
	public void assertNoErrors(final EObject model) {
		assertNoErrors(model.eResource());
	}

	public void assertNoError(final EObject model, final String issueCode) {
		assertNoError(model.eResource(), issueCode, null);
	}
	
	/**
	 * @since 2.9
	 */
	public void assertNoError(final EObject model, final String issueCode, final String userData) {
		assertNoError(model.eResource(), issueCode, userData);
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
	public void assertNoIssues(final EObject model, final EClass objectType) {
		assertNoIssues(model.eResource(), objectType);
	}
	
	/**
	 * @since 2.4
	 */
	public void assertNoIssue(final EObject model, final EClass objectType, final String issueCode) {
		assertNoIssue(model.eResource(), objectType, issueCode);
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
	public void assertIssue(EObject model, EClass objectType, String issueCode, int offset, int length,  Severity severity,
			String... messageParts) {
		assertIssue(model.eResource(), objectType, issueCode, offset, length, severity, messageParts);
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
	public void assertNoIssues(EObject model, EClass objectType, String issueCode, int offset, int length,  Severity severity,
			String... messageParts) {
		assertNoIssues(model.eResource(), objectType, issueCode, offset, length, severity, messageParts);
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

	/**
	 * @since 2.8
	 */
	public List<Issue> validate(Resource resource) {
		IResourceValidator validator = ((XtextResource) resource).getResourceServiceProvider()
				.getResourceValidator();
		return validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoIssues(final Resource resource) {
		final List<Issue> validate = validate(resource);
		if (!isEmpty(validate))
			fail("Expected no issues, but got :" + getIssuesAsString(resource, validate, new StringBuilder()));
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoErrors(final Resource resource) {
		final List<Issue> validate = validate(resource);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				return Severity.ERROR == input.getSeverity();
			}
		});
		if (!isEmpty(issues))
			fail("Expected no errors, but got :" + getIssuesAsString(resource, issues, new StringBuilder()));
	}

	/**
	 * @since 2.8
	 */
	public void assertNoError(final Resource resource, final String issuecode) {
		assertNoError(resource, issuecode, null);
	}
	
	/**
	 * @since 2.9
	 */
	public void assertNoError(final Resource resource, final String issuecode, final String userData) {
		final List<Issue> validate = validate(resource);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				if (issuecode.equals(input.getCode())) {
					return userData == null || Arrays.contains(input.getData(), userData);
				}
				return false;
			}
		});
		if (!isEmpty(issues))
			fail("Expected no error '" + issuecode + "' but got " + getIssuesAsString(resource, issues, new StringBuilder()));
	}

	/**
	 * @since 2.8
	 */
	public void assertNoErrors(final Resource resource, final EClass objectType, final String code,
			final String... messageParts) {
		assertNoIssues(resource, objectType, code, Severity.ERROR, messageParts);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoErrors(final Resource resource, final String code) {
		assertNoIssues(resource, EcorePackage.Literals.EOBJECT, code, Severity.ERROR);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoIssues(final Resource resource, final EClass objectType) {
		final List<Issue> validate = validate(resource);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				EObject object = resource.getEObject(input.getUriToProblem().fragment());
				if (objectType.isInstance(object)) {
					return true;
				}
				return false;
			}
		});
		if (!isEmpty(issues))
			fail("Expected no error on instances of  '" + objectType.getName() + "' but got " + getIssuesAsString(resource, issues, new StringBuilder()));
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoIssue(final Resource resource, final EClass objectType, final String issuecode) {
		final List<Issue> validate = validate(resource);
		Iterable<Issue> issues = filter(validate, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				if (issuecode.equals(input.getCode())) {
					EObject object = resource.getEObject(input.getUriToProblem().fragment());
					if (objectType.isInstance(object)) {
						return true;
					}
				}
				return false;
			}
		});
		if (!isEmpty(issues)) {
			fail("Expected no error '" + issuecode + "' but got " + getIssuesAsString(resource, issues, new StringBuilder()));
		}
	}

	/**
	 * @since 2.8
	 */
	public void assertError(final Resource resource, final EClass objectType, final String code, int offset, int length, 
			final String... messageParts) {
		assertIssue(resource, objectType, code, offset, length, Severity.ERROR, messageParts);
	}

	/**
	 * @since 2.8
	 */
	public void assertError(final Resource resource, final EClass objectType, final String code,
			final String... messageParts) {
		assertIssue(resource, objectType, code, Severity.ERROR, messageParts);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertIssue(final Resource resource, final EClass objectType, final String code, final Severity severity,
			final String... messageParts) {
		assertIssue(resource, objectType, code, -1, -1, severity, messageParts);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertIssue(final Resource resource, final EClass objectType, final String code, final int offset, final int length,  final Severity severity,
			final String... messageParts) {
		final List<Issue> allIssues = validate(resource);
		final Iterable<Issue> validate = matchIssues(resource, objectType, code, offset, length, severity, allIssues, messageParts);
		if (Iterables.isEmpty(validate)) {
			StringBuilder message = new StringBuilder("Expected ")
				.append(severity)
				.append(" '")
				.append(code)
				.append("' on ")
				.append(objectType.getName())
				.append(" at [")
				.append(offset)
				.append(":")
				.append(length)
				.append("] but got\n");
			getIssuesAsString(resource, allIssues, message);
			assertEquals(Joiner.on('\n').join(messageParts), message.toString());
			fail(message.toString());
		}
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoIssues(final Resource resource, final EClass objectType, final String code, final Severity severity,
			final String... messageParts) {
		assertNoIssues(resource, objectType, code, -1, -1, severity, messageParts);
	}
	
	/**
	 * @since 2.8
	 */
	public void assertNoIssues(final Resource resource, final EClass objectType, final String code, final int offset, final int length,  final Severity severity,
			final String... messageParts) {
		final List<Issue> allIssues = validate(resource);
		final Iterable<Issue> validate = matchIssues(resource, objectType, code, offset, length, severity, allIssues, messageParts);
		if (!Iterables.isEmpty(validate)) {
			StringBuilder message = new StringBuilder("Expected no ")
				.append(severity)
				.append(" '")
				.append(code)
				.append("' on ")
				.append(objectType.getName())
				.append(" but got\n");
			getIssuesAsString(resource, allIssues, message);
			assertEquals(Joiner.on('\n').join(messageParts), message.toString());
			fail(message.toString());
		}
	}

	/**
	 * @since 2.8
	 */
	public void assertWarning(final Resource resource, final EClass objectType, final String code,
			final String... messageParts) {
		assertIssue(resource, objectType, code, Severity.WARNING, messageParts);
	}

	/**
	 * @since 2.8
	 */
	public void assertNoWarnings(final Resource resource, final EClass objectType, final String code,
			final String... messageParts) {
		assertNoIssues(resource, objectType, code, Severity.WARNING, messageParts);
	}

	/**
	 * @since 2.8
	 */
	public void assertWarning(final Resource resource, final EClass objectType, final String code, int offset, int length, 
			final String... messageParts) {
		assertIssue(resource, objectType, code, offset, length, Severity.WARNING, messageParts);
	}

	/**
	 * @since 2.4
	 */
	protected Iterable<Issue> matchIssues(final EObject model, final EClass objectType, final String code,
			final int offset, final int length, final Severity severity, final List<Issue> validate,
			final String... messageParts) {
		return doMatchIssues(model.eResource(), objectType, code, offset, length, severity, validate, messageParts);
	}
	
	/**
	 * @since 2.8
	 */
	protected Iterable<Issue> matchIssues(final Resource resource, final EClass objectType, final String code,
			final int offset, final int length, final Severity severity, final List<Issue> validate,
			final String... messageParts) {
		// keep the original impl of #matchIssues(EObject, ..) in the call graph  
		List<EObject> contents = resource.getContents();
		if (contents.size() > 1) {
			return matchIssues(contents.get(0), objectType, code, offset, length, severity, validate, messageParts);
		}
		return doMatchIssues(resource, objectType, code, offset, length, severity, validate, messageParts);
	}

	/**
	 * @since 2.8
	 */
	protected Iterable<Issue> doMatchIssues(final Resource resource, final EClass objectType, final String code,
			final int offset, final int length, final Severity severity, final List<Issue> validate,
			final String... messageParts) {
		return Iterables.filter(validate, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				if (Strings.equal(input.getCode(), code) && input.getSeverity()==severity) {
					if ((offset < 0 || offset == input.getOffset()) && (length < 0 || length == input.getLength())) {
						EObject object = resource.getResourceSet().getEObject(input.getUriToProblem(), true);
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
		return doGetIssuesAsString(model.eResource(), issues, result);
	}
	
	/**
	 * @since 2.8
	 */
	protected StringBuilder getIssuesAsString(final Resource resource, final Iterable<Issue> issues, StringBuilder result) {
		// keep the original impl of #getIssuesAsString(EObject, ..) in the call graph  
		List<EObject> contents = resource.getContents();
		if (contents.size() > 1) {
			return getIssuesAsString(contents.get(0), issues, result);
		}
		return doGetIssuesAsString(resource, issues, result);
	}

	/**
	 * @since 2.8
	 */
	protected StringBuilder doGetIssuesAsString(Resource resource, final Iterable<Issue> issues, StringBuilder result) {
		for (Issue issue : issues) {
			URI uri = issue.getUriToProblem();
			result.append(issue.getSeverity());
			result.append(" (");
			result.append(issue.getCode());
			result.append(") '");
			result.append(issue.getMessage());
			result.append("'");
			if (uri != null) {
				EObject eObject = resource.getResourceSet().getEObject(uri, true);
				result.append(" on ");
				result.append(eObject.eClass().getName());
			}
			result.append(", offset " + issue.getOffset() + ", length " + issue.getLength());
			result.append("\n");
		}
		return result;
	}

}
