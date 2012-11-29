/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import java.io.IOException;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	@Inject
	private CompilerTestHelper testHelper;
	
	@Before
	public void setUp() throws Exception {
		testHelper.setUp();
	}
	
	@Test public void testExceptionInClosure_01() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{val ()=>void proc = [| throw new java.io.IOException()] proc.apply return null}");
	}
	
	@Test public void testExceptionInClosure_02() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{ newArrayList('foo').forEach( s | throw new java.io.IOException() ) return null }");
	}
	
	@Test public void testExceptionInClosure_03() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{val ()=>void proc = [| throw new java.io.IOException] proc.apply return null}");
	}
	
	@Test public void testExceptionInClosure_04() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{ newArrayList('foo').forEach( s | throw new java.io.IOException ) return null }");
	}
	
	@Test public void testTryCatch_07() throws Exception {
		assertEvaluatesTo("", 
				"try new String() " +
				"  catch(java.io.IOException e) 'foo'" +
				"  catch(Exception e) 'bar'");
	}
	
	@Test public void testTryCatch_08() throws Exception {
		assertEvaluatesTo("", 
				"try new String " +
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
