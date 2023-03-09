/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class ValidatorTest extends AbstractReaderTest {

	@Override
	protected SlotEntry createSlotEntry() {
		return new SlotEntry();
	}
	
	
	@Override
	protected Reader getReader() {
		Reader reader = new Reader();
		Validator validator = new Validator();
		validator.setStopOnError(false);
		reader.setValidate(validator);
		return reader;
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=322645
	 */
	@Test public void testBugFix322645() throws Exception {
		Issues issues = issues();
		Issue a = new Issue.IssueImpl();
		Issue b = new Issue.IssueImpl();
		issues.addError("foo", a);
		issues.addWarning(null, a);
		issues.addError(null, b);
		MWEDiagnostic[] errors = issues.getErrors();
		assertEquals(2, errors.length);
		final Validator validator = new Validator();
		final String string = validator.toString(issues);
		assert(string.contains("foo"));
	}

}
