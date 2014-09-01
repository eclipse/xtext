/*******************************************************************************
 * Copyright (c) 2006, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   David Saff (saff@mit.edu) - initial API and implementation
 *             (bug 102632: [JUnit] Support for JUnit 4.)
 *******************************************************************************/
package org.eclipse.jdt.junit4.runtime.patch;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jdt.internal.junit.runner.FailedComparison;
import org.eclipse.jdt.internal.junit.runner.IListensToTestExecutions;
import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.MessageIds;
import org.eclipse.jdt.internal.junit.runner.TestReferenceFailure;
import org.eclipse.jdt.internal.junit4.runner.JUnit4Identifier;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

@SuppressWarnings("restriction")
public class JUnit4TestListener extends RunListener {

	private static class IgnoredTestIdentifier extends JUnit4Identifier {
		public IgnoredTestIdentifier(Description description) {
			super(description);
		}

		@Override
		public String getName() {
			String name = super.getName();
			if (name != null)
				return MessageIds.IGNORED_TEST_PREFIX + name;
			return null;
		}
	}

	private static class AssumptionFailedTestIdentifier extends JUnit4Identifier {
		public static final String ASSUMPTION_FAILED_TEST_PREFIX = "@AssumptionFailure: "; //$NON-NLS-1$

		public AssumptionFailedTestIdentifier(Description description) {
			super(description);
		}

		@Override
		public String getName() {
			String name = super.getName();
			if (name != null)
				return ASSUMPTION_FAILED_TEST_PREFIX + name;
			return null;
		}
	}

	private final IListensToTestExecutions fNotified;

	public JUnit4TestListener(IListensToTestExecutions notified) {
		fNotified = notified;
	}

	@Override
	public void testStarted(Description plan) throws Exception {
		fNotified.notifyTestStarted(getIdentifier(plan, false, false));
	}

	@Override
	public void testFailure(Failure failure) throws Exception {
		testFailure(failure, false);
	}

	@Override
	public void testAssumptionFailure(Failure failure) {
		testFailure(failure, true);
	}

	private void testFailure(Failure failure, boolean assumptionFailed) {
		ITestIdentifier identifier = getIdentifier(failure.getDescription(), false, assumptionFailed);
		TestReferenceFailure testReferenceFailure;
		try {
			Throwable exception = failure.getException();
			String status = (assumptionFailed || exception instanceof AssertionError) ? MessageIds.TEST_FAILED : MessageIds.TEST_ERROR;
			FailedComparison comparison = null;
			if (exception instanceof junit.framework.ComparisonFailure) {
				junit.framework.ComparisonFailure comparisonFailure = (junit.framework.ComparisonFailure) exception;
				comparison = new FailedComparison(comparisonFailure.getExpected(), comparisonFailure.getActual());
			} else if (exception instanceof org.junit.ComparisonFailure) {
				org.junit.ComparisonFailure comparisonFailure = (org.junit.ComparisonFailure) exception;
				comparison = new FailedComparison(comparisonFailure.getExpected(), comparisonFailure.getActual());
			}
			testReferenceFailure = new TestReferenceFailure(identifier, status, failure.getTrace(), comparison);
		} catch (RuntimeException e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			testReferenceFailure = new TestReferenceFailure(identifier, MessageIds.TEST_FAILED, stringWriter.getBuffer().toString(), null);
		}
		fNotified.notifyTestFailed(testReferenceFailure);
	}

	@Override
	public void testIgnored(Description plan) throws Exception {
		// Send message to listeners which would be stale otherwise
		ITestIdentifier identifier = getIdentifier(plan, true, false);
		fNotified.notifyTestStarted(identifier);
		fNotified.notifyTestEnded(identifier);
	}

	@Override
	public void testFinished(Description plan) throws Exception {
		fNotified.notifyTestEnded(getIdentifier(plan, false, false));
	}

	private ITestIdentifier getIdentifier(Description plan, boolean ignored, boolean assumptionFailed) {
		if (ignored)
			return new IgnoredTestIdentifier(plan);
		if (assumptionFailed)
			return new AssumptionFailedTestIdentifier(plan);
		return new JUnit4Identifier(plan);
	}
}
