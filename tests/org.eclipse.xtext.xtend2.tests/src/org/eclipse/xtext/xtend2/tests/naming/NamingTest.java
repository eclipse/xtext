/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.naming;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NamingTest extends AbstractXtend2TestCase {

	@Inject
	protected IQualifiedNameProvider nameProvider;

	@Inject
	protected IXtend2JvmAssociations associations;

	public void testQualifiedNameProvider_0() throws Exception {
		XtendFile file = file("package foo class Bar {}");
		assertEquals(QualifiedName.create("foo", "Bar"), nameProvider.getFullyQualifiedName(file.getXtendClass()));
		assertEquals(QualifiedName.create("foo", "Bar"),
				nameProvider.getFullyQualifiedName(associations.getInferredType(file.getXtendClass())));
		assertEquals(QualifiedName.create("foo", "Bar"),
				nameProvider.getFullyQualifiedName(associations.getInferredConstructor(file.getXtendClass())));
	}

	public void testQualifiedNameProvider_1() throws Exception {
		XtendFile file = file("package foo class Bar { def baz() {this} }");
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		assertEquals(QualifiedName.create("foo", "Bar", "baz"), nameProvider.getFullyQualifiedName(function));
		assertEquals(QualifiedName.create("foo", "Bar", "baz"),
				nameProvider.getFullyQualifiedName(associations.getDirectlyInferredOperation(function)));
	}

	public void testQualifiedNames_0() throws Exception {
		XtendFile file = file("package foo class Bar {}");
		assertEquals("foo.Bar", file.getXtendClass().getQualifiedName());
		assertEquals("foo.Bar", associations.getInferredType(file.getXtendClass()).getQualifiedName());
		assertEquals("foo.Bar", associations.getInferredConstructor(file.getXtendClass()).getQualifiedName());
	}

	public void testQualifiedNames_1() throws Exception {
		XtendFile file = file("package foo class Bar { def baz() {this} }");
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		assertEquals("foo.Bar.baz", function.getQualifiedName());
		assertEquals("foo.Bar.baz", associations.getDirectlyInferredOperation(function).getQualifiedName());
	}

	public void testIdentifier_0() throws Exception {
		XtendFile file = file("package foo class Bar {}");
		assertEquals("foo.Bar", file.getXtendClass().getIdentifier());
		assertEquals("foo.Bar", associations.getInferredType(file.getXtendClass()).getIdentifier());
		assertEquals("foo.Bar.Bar()", associations.getInferredConstructor(file.getXtendClass()).getIdentifier());
	}

	public void testIdentifier_1() throws Exception {
		XtendFile file = file("package foo class Bar { def baz() {this} def baz(Bar f) {f}}");
		XtendFunction baz0 = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XtendFunction baz1 = (XtendFunction) file.getXtendClass().getMembers().get(1);
		assertEquals("foo.Bar.baz()", baz0.getIdentifier());
		assertEquals("foo.Bar.baz(foo.Bar)", baz1.getIdentifier());
		assertEquals("foo.Bar.baz()", associations.getDirectlyInferredOperation(baz0).getIdentifier());
		assertEquals("foo.Bar.baz(foo.Bar)", associations.getDirectlyInferredOperation(baz1).getIdentifier());
	}

}
