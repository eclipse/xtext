/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class XbaseInterpreterTestWithNewTypeSystem extends XbaseInterpreterTest {
	
	@Override
	@Test
	@Ignore
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_06_1() throws Exception {
		super.testClosure_06_1();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_10() throws Exception {
		super.testClosure_10();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_10_2() throws Exception {
		super.testClosure_10_2();
	}
	
	@Override
	@Test
	@Ignore
	public void testStaticMethod_02() throws Exception {
		super.testStaticMethod_02();
	}
}
