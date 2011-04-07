/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.refactoring;

import static com.google.common.collect.Lists.*;

import java.util.List;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DependentElementsCalculatorTest extends AbstractXtend2UITestCase {
	
	public static Test suite() {
		return WorkbenchTestHelper.suite(DependentElementsCalculatorTest.class);
	}
	
	@Inject 
	private IDependentElementsCalculator dependentElementsCalculator;
	
	@Inject
	private IXtend2JvmAssociations associations;
	
	@Inject 
	private WorkbenchTestHelper testHelper;
	
	public void testDependentElements() throws Exception {
		XtendFile file = testHelper.xtendFile("Foo", "class Foo { Foo foo() {new Foo()} }");
		XtendClass fooClass = file.getXtendClass();
		List<URI> dependentElementURIs = newArrayList(dependentElementsCalculator.getDependentElementURIs(fooClass, null));
		assertEquals(3, dependentElementURIs.size());
		XtendFunction fooFunction = (XtendFunction) fooClass.getMembers().get(0);
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(fooFunction)));
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(associations.getInferredType(fooClass))));
		assertTrue(dependentElementURIs.contains(EcoreUtil.getURI(associations.getInferredConstructor(fooClass))));
	}
	
	// TODO test polymorphic dispatch method refactoring
	
}
