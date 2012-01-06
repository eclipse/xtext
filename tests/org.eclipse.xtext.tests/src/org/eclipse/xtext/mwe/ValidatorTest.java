/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
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
		Reader reader = getReader();
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = createSlotEntry();
		entry.setName("foo:bar:Person");
		entry.setFirstOnly(true);
		entry.setNamespaceDelimiter(":");

		reader.addLoad(entry);
		WorkflowContext ctx = ctx();
		Issues issues = issues();
		reader.invoke(ctx, monitor(), issues);
		MWEDiagnostic[] errors = issues.getErrors();
		assertEquals(2, errors.length);
	}

}
