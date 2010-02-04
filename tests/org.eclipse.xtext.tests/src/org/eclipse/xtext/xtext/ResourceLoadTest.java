/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.io.IOException;

import junit.framework.TestResult;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.GenerateAllTestGrammars;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * Really long running smoke tests for the xtext grammar.
 * Uses all test grammars.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("unused")
public class ResourceLoadTest extends AbstractGeneratorTest {

	private Class<?> clazz;

	private String model;

	@Override
	public int countTestCases() {
		return super.countTestCases() * getTestClasses().length;
	}

	private Class<?>[] getTestClasses() {
		return GenerateAllTestGrammars.getTestGrammarClasses();
	}

	@Override
	public String getName() {
		return super.getName() + (clazz != null ? (" [" + clazz.getSimpleName() + "]") : "");
	}

	@Override
	public void run(TestResult result) {
		for(int i = 0; i < getTestClasses().length; i++) {
//		for(int i = GenerateAllTestGrammars.testclasses.length - 1; i >= 0; i--) {
			this.clazz = getTestClasses()[i];
//			this.clazz = GenerateAllTestGrammars.testclasses[8];
			initModel();
			super.run(result);
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	private void initModel() {
		try {
			model = readFileIntoString(GenerateAllTestGrammars.getGrammarFileName(clazz));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

//	public void testNoExceptionDiagnostics_01() throws Exception{
//		for(int i = 0; i < model.length(); i++) {
//			String model = this.model.substring(0, i);
//			Resource r = getResourceFromString(model);
//			assertNoExceptionDiagnostic(r, model);
//		}
//	}

//	public void testNoExceptionDiagnostics_02() throws Exception{
//		for(int i = 0; i < model.length(); i++) {
//			String model = this.model.substring(i);
//			Resource r = getResourceFromString(model);
//			assertNoExceptionDiagnostic(r, model);
//		}
//	}

//	public void testNoExceptionDiagnostics_03() throws Exception{
//		for(int i = 0; i < model.length() - 1; i++) {
//			String model = this.model.substring(0, i) + this.model.substring(i + 1);
////			System.out.println(model);
//			Resource r = getResourceFromString(model);
//			assertNoExceptionDiagnostic(r, model);
//		}
//	}
//
//	public void testNoExceptionDiagnostics_04() throws Exception {
//		XtextResource r = getResourceFromString(this.model);
//		assertTrue(r.getErrors().isEmpty());
//		CompositeNode node = r.getParseResult().getRootNode();
//		Iterable<Pair<Integer, Integer>> nodeBounds = CollectionUtils.map(node.eAllContents(), new Function<EObject, Pair<Integer, Integer>>() {
//			public Pair<Integer, Integer> exec(EObject param) {
//				AbstractNode node = (AbstractNode) param;
//				return Tuples.create(node.getOffset(), node.getLength());
//			}
//		});
//		for(Pair<Integer, Integer> bound: nodeBounds) {
//			String model = this.model.substring(0, bound.getFirst()) + this.model.substring(bound.getFirst() + bound.getSecond());
//			Resource res = getResourceFromString(model);
//			assertNoExceptionDiagnostic(res, model);
//		}
//	}

	private void assertNoExceptionDiagnostic(Resource r, String model) throws Exception {
		for(Diagnostic d: r.getErrors()) {
			if (d instanceof ExceptionDiagnostic) {
				throw new Exception(model, ((ExceptionDiagnostic)d).getException());
			}
		}
	}

	public void testDummy() {
		assertNotNull(clazz);
	}

}
