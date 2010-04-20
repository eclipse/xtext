/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Iterator;

import junit.framework.TestResult;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Really long running smoke tests for the xtext grammar. Uses all test grammars.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ResourceLoadTest extends AbstractXtextTests {

	private String grammarPath;
	private String model;
	
	private static boolean FIRST_ONLY = true; 

	@Override
	public int countTestCases() {
		return super.countTestCases() * getAllTestGrammarPaths(FIRST_ONLY).size();
	}

	@Override
	public String getName() {
		return super.getName() + (grammarPath != null ? (" [" + grammarPath + "]") : "");
	}

	@Override
	public void run(TestResult result) {
		for (String testGrammarPath : getAllTestGrammarPaths(FIRST_ONLY)) {
			try {
				model = null;
				grammarPath = testGrammarPath;
				model = readFileIntoString(testGrammarPath);
				super.run(result);
			} catch (Exception exc) {
				result.addError(this, exc);
			}
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testNoExceptionDiagnostics_01() throws Exception {
		for (int i = 0; i < model.length(); i++) {
			String model = this.model.substring(0, i);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	public void testNoExceptionDiagnostics_02() throws Exception {
		for (int i = 0; i < model.length(); i++) {
			String model = this.model.substring(i);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	public void testNoExceptionDiagnostics_03() throws Exception {
		for (int i = 0; i < model.length() - 1; i++) {
			String model = this.model.substring(0, i) + this.model.substring(i + 1);
			//			System.out.println(model);
			Resource r = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(r, model);
		}
	}

	public void testNoExceptionDiagnostics_04() throws Exception {
		XtextResource r = getResourceFromString(this.model);
		assertTrue(r.getErrors().isEmpty());
		CompositeNode node = r.getParseResult().getRootNode();
		for (Iterator<EObject> i = node.eAllContents(); i.hasNext();) {
			AbstractNode childNode = (AbstractNode) i.next();
			String subModel = model.substring(0, childNode.getOffset())
					+ model.substring(childNode.getOffset() + childNode.getLength());
			Resource res = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
			assertNoExceptionDiagnostic(res, subModel);
		}
	}

	private void assertNoExceptionDiagnostic(Resource r, String model) throws Exception {
		for (Diagnostic d : r.getErrors()) {
			if (d instanceof ExceptionDiagnostic) {
				throw new Exception(model, ((ExceptionDiagnostic) d).getException());
			}
		}
	}

	public void testDummy() {
		assertNotNull(model);
	}

}
