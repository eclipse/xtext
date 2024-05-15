/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.fragments;

import com.google.inject.Injector;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractFragmentsPlainParsingTest extends AbstractXtextTests {
	@Override
	protected void setInjector(Injector injector) {
		super.setInjector(injector);
		injectMembers(this);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return true;
	}

	@Test
	public void testSimpleModel() throws Exception {
		getModel("#1 myName");
	}

	@Test
	public void testReference() throws Exception {
		getModel("#2 myName -> myName");
	}

	@Test
	public void testReference_02() throws Exception {
		getModel("#1 myName : myName");
	}

	@Test
	public void testReferenceInFragment() throws Exception {
		getModel("#1 myName - myName");
	}

	@Test
	public void testReferenceBeforeFragment() throws Exception {
		getModel("#3 myName <- myName");
	}

	@Test
	public void testAction() throws Exception {
		getModel("#4 prev current");
	}

	@Test
	public void testActionAndReference() throws Exception {
		getModel("#4 prev current prev current");
	}

	@Test
	@Ignore("Actions are currently not supported in fragments")
	public void testActionInFragment_01() throws Exception {
		getModel("#5 prev current");
	}

	@Test
	@Ignore("Actions are currently not supported in fragments")
	public void testActionInFragment_02() throws Exception {
		getModel("#6 prev current");
	}

	@Test
	@Ignore("Actions are currently not supported in fragments")
	public void testActionInFragmentAndReference_01() throws Exception {
		getModel("#5 prev current current - prev");
	}

	@Test
	@Ignore("Actions are currently not supported in fragments")
	public void testActionInFragmentAndReference_02() throws Exception {
		getModel("#6 prev current current - prev");
	}

	@Test
	@Ignore("Actions are currently not supported in fragments")
	public void testActionInFragmentAndReferenceLoop() throws Exception {
		getModel("#7 root -> a a -> b b -> c c - root");
	}

	@Test
	public void testDatatypeRule_01() throws Exception {
		getModel("#8 a - a");
	}

	@Test
	public void testDatatypeRule_02() throws Exception {
		getModel("#8 a.b.c.d");
	}

	@Test
	public void testDatatypeRule_03() throws Exception {
		getModel("#8 a.b.c.d - a.b.c.d");
	}
}
