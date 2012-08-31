/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class DependentElementsCalculatorTest extends AbstractXtendUITestCase {
	
	@Inject 
	private IDependentElementsCalculator dependentElementsCalculator;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject 
	private WorkbenchTestHelper testHelper;
	
	@Test public void testDependentElements() throws Exception {
		XtendFile file = testHelper.xtendFile("Foo", "class Foo { def Foo foo() {new Foo()} }");
		XtendClass fooClass = (XtendClass) file.getXtendTypes().get(0);
		List<URI> dependentElementURIs = newArrayList(dependentElementsCalculator.getDependentElementURIs(fooClass, null));
		assertEquals(3, dependentElementURIs.size());
		XtendFunction fooFunction = (XtendFunction) fooClass.getMembers().get(0);
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(fooFunction)));
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(associations.getInferredType(fooClass))));
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(associations.getInferredConstructor(fooClass))));
	}
	
	// TODO test polymorphic dispatch method refactoring
	
}
