/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.refactoring;

import junit.framework.Test;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RenameStrategyTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(RenameStrategyTest.class);
	}

	@Inject
	private IRenameStrategy.Provider renameStrategyProvider;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private WorkbenchTestHelper testHelper;

	public void testInferredClassRenamed() throws Exception {
		XtendClass fooClass = testHelper.xtendFile("Foo", "class Foo { }").getXtendClass();
		JvmGenericType inferredType = associations.getInferredType(fooClass);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(fooClass);
		IRenameStrategy renameStrategy = renameStrategyProvider.get(fooClass, null);
		renameStrategy.applyDeclarationChange("Bar", fooClass.eResource().getResourceSet());
		assertEquals("Bar", fooClass.getName());
		assertEquals("Bar", inferredType.getSimpleName());
		assertEquals("Bar", inferredConstructor.getSimpleName());
		renameStrategy.revertDeclarationChange(fooClass.eResource().getResourceSet());
		assertEquals("Foo", fooClass.getName());
		assertEquals("Foo", inferredType.getSimpleName());
		assertEquals("Foo", inferredConstructor.getSimpleName());
	}

	public void testInferredMethodRenamed() throws Exception {
		XtendFunction fooMethod = (XtendFunction) testHelper.xtendFile("Foo", "class Foo { Foo foo() this }")
				.getXtendClass().getMembers().get(0);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(fooMethod);
		IRenameStrategy renameStrategy = renameStrategyProvider.get(fooMethod, null);
		renameStrategy.applyDeclarationChange("bar", fooMethod.eResource().getResourceSet());
		assertEquals("bar", fooMethod.getName());
		assertEquals("bar", inferredOperation.getSimpleName());
		renameStrategy.revertDeclarationChange(fooMethod.eResource().getResourceSet());
		assertEquals("foo", fooMethod.getName());
		assertEquals("foo", inferredOperation.getSimpleName());
	}

}
