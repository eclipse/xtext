/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.tests.ClasspathBasedModule;
import org.junit.Test;

import com.google.inject.Module;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ClasspathConformanceComputerTest extends AbstractTypeConformanceComputerTest {

	@Override
	protected Module getModule() {
		return new ClasspathBasedModule();
	}
	
	@Test
	public void testRedundantInheritance() throws Exception {
		assertCommonSuperType(
				String.format("%s & %s & %s", Root.class.getName(), InterfaceB.class.getName(), InterfaceA.class.getName()),
				ref(ChildA.class),
				ref(ChildB.class));
	}

	static class Root implements InterfaceC {}
	static class ParentA extends Root implements InterfaceA {}
	static class ParentB extends Root implements InterfaceA {}
	@SuppressWarnings("unused")
	static class ChildA extends ParentA implements InterfaceB, InterfaceC {}
	@SuppressWarnings("unused")
	static class ChildB extends ParentB implements InterfaceB, InterfaceC {}
	
	static interface InterfaceA {}
	static interface InterfaceB {}
	static interface InterfaceC {}
	
}
