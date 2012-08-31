/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class RenameStrategyTest extends AbstractXtendUITestCase {

	@Inject
	private IRenameStrategy.Provider renameStrategyProvider;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Test public void testInferredClassRenamed() throws Exception {
		XtendClass fooClass = (XtendClass) testHelper.xtendFile("Foo", "class Foo { }").getXtendTypes().get(0);
		IRenameStrategy renameStrategy = renameStrategyProvider.get(fooClass, null);
		renameStrategy.applyDeclarationChange("Bar", fooClass.eResource().getResourceSet());
		JvmGenericType inferredType = associations.getInferredType(fooClass);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(fooClass);
		assertEquals("Bar", fooClass.getName());
		assertEquals("Bar", inferredType.getSimpleName());
		assertEquals("Bar", inferredConstructor.getSimpleName());
		renameStrategy.revertDeclarationChange(fooClass.eResource().getResourceSet());
		inferredType = associations.getInferredType(fooClass);
		inferredConstructor = associations.getInferredConstructor(fooClass);
		assertEquals("Foo", fooClass.getName());
		assertEquals("Foo", inferredType.getSimpleName());
		assertEquals("Foo", inferredConstructor.getSimpleName());
	}

	@Test public void testInferredMethodRenamed() throws Exception {
		XtendFunction fooMethod = (XtendFunction) ((XtendClass)testHelper.xtendFile("Foo", "class Foo { def Foo foo() {this} }")
				.getXtendTypes().get(0)).getMembers().get(0);
		IRenameStrategy renameStrategy = renameStrategyProvider.get(fooMethod, null);
		renameStrategy.applyDeclarationChange("bar", fooMethod.eResource().getResourceSet());
		assertEquals("bar", fooMethod.getName());
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(fooMethod);
		assertEquals("bar", inferredOperation.getSimpleName());
		renameStrategy.revertDeclarationChange(fooMethod.eResource().getResourceSet());
		inferredOperation = associations.getDirectlyInferredOperation(fooMethod);
		assertEquals("foo", fooMethod.getName());
		assertEquals("foo", inferredOperation.getSimpleName());
	}

	@Test public void testXtendConstructorIgnored() throws Exception {
		XtendConstructor constructor = (XtendConstructor) ((XtendClass)testHelper.xtendFile("Foo", "class Foo { new() {} }")
				.getXtendTypes().get(0)).getMembers().get(0);
		IRenameStrategy renameStrategy = renameStrategyProvider.get(constructor, null);
		assertNull(renameStrategy);
	}

}
