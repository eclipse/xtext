/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.validation;

import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;
import junit.framework.Test;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class CrossFileValidationTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(CrossFileValidationTest.class);
	}

	@Override
	protected void tearDown() throws Exception {
		workbenchHelper.tearDown();
		super.tearDown();
	}

	@Inject
	private WorkbenchTestHelper workbenchHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	public void testInheritanceCycle() throws Exception {
		XtendClass foo = workbenchHelper.xtendFile("test/Foo.xtend", "package test class Foo extends Bar {}").getXtendClass();
		XtendClass bar = workbenchHelper.xtendFile("test/Bar.xtend", "package test class Bar extends Foo {}").getXtendClass();
		waitForAutoBuild();
		validationHelper.assertError(foo, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		validationHelper.assertError(bar, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	public void testInheritanceCycle_1() throws Exception {
		XtendClass foo = workbenchHelper.xtendFile("test/Foo.xtend", "package test class Foo extends Bar {}").getXtendClass();
		XtendClass bar = workbenchHelper.xtendFile("test/Bar.xtend", "package test class Bar extends Baz {}").getXtendClass();
		XtendClass baz = workbenchHelper.xtendFile("test/Baz.xtend", "package test class Baz extends Foo {}").getXtendClass();
		waitForAutoBuild();
		validationHelper.assertError(foo, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		validationHelper.assertError(bar, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		validationHelper.assertError(baz, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	public void testIgnoreInterfacesInCycleDetection() throws Exception {
		XtendClass foo = workbenchHelper.xtendFile("test/Foo.xtend", "package test class Foo extends Bar {}").getXtendClass();
		XtendClass bar = workbenchHelper.xtendFile("test/Bar.xtend", "package test class Bar extends Baz implements java.util.Serializable {}").getXtendClass();
		XtendClass baz = workbenchHelper.xtendFile("test/Baz.xtend", "package test class Baz implements java.util.Serializable {}").getXtendClass();
		waitForAutoBuild();
		validationHelper.assertNoError(foo, CYCLIC_INHERITANCE);
		validationHelper.assertNoError(bar, CYCLIC_INHERITANCE);
		validationHelper.assertNoError(baz, CYCLIC_INHERITANCE);
	}
}
