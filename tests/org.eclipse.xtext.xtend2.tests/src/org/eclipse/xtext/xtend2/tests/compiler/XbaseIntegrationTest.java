/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.IOException;

import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	@Inject
	private CompilerTestHelper testHelper;
	
	@Before
	public void setUp() throws Exception {
		AbstractXtend2TestCase.getInjector().injectMembers(this);
		testHelper.setUp();
	}
	
	@Test public void testClosure_19() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{val ()=>void proc = [| throw new java.io.IOException()] proc.apply return null}");
	}
	
	@Test public void testClosure_20() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{ newArrayList('foo').forEach( s | throw new java.io.IOException() ) return null }");
	}
	
	@Test public void testTryCatch_06() throws Exception {
		assertEvaluatesTo("", 
				"try new String() " +
				"  catch(java.io.IOException e) 'foo'" +
				"  catch(Exception e) 'bar'");
	}

	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		testHelper.assertEvaluatesTo(object, string);
	}
	
	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		testHelper.assertEvaluatesWithException(class1, string);
	}

	@Test public void testIteratorExtensions() throws Exception {
		assertEvaluatesTo("Foo", "newArrayList('Foo').iterator.toIterable.iterator.next");
	}
}
