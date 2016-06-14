/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class UIStringsTest extends AbstractXtendTestCase {
	
	@Inject
	protected UIStrings uiStrings;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private ValidationTestHelper validationTestHelper;
	
	/** Only the simple name of the type is specified.
	 * The JvmTypeReference is not a proxy.
	 */
	@Test
	public void testReferenceToString_0() throws Exception {
		XtendFile file = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "public interface InterfaceA { }\n"
				+ "public class ClassB implements InterfaceA { }\n"
				+ "public class ClassC extends ClassB {\n"
				+ "}\n"
				+ "class XtendClass1 {\n"
				+ "  def test() {\n"
				+ "    val x = new List<ClassC>\n"
				+ "  }\n"
				+ "}\n");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(3);
		XBlockExpression block = (XBlockExpression) ((XtendFunction) clazz.getMembers().get(0)).getExpression();
		XVariableDeclaration declaration = (XVariableDeclaration) block.getExpressions().get(0);
		XConstructorCall cons = (XConstructorCall) declaration.getRight();
		JvmTypeReference reference = cons.getTypeArguments().get(0);
		assertNotNull(reference);
		assertNotNull(reference.getType());
		assertFalse(reference.getType().eIsProxy());
		assertNotNull(reference.eResource());
		assertEquals("ClassC", this.uiStrings.referenceToString(reference, "the-default-label"));
	}

	/** Only the simple name of the type is specified.
	 * The JvmTypeReference is proxy.
	 */
	@Test
	public void testReferenceToString_1() throws Exception {
		XtendFile file1 = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "public interface InterfaceA { }\n"
				+ "public class ClassB implements InterfaceA { }\n"
				+ "public class ClassC extends ClassB {\n"
				+ "}\n");
		assertNotNull(file1);
		XtendFile file2 = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "class XtendClass1 {\n"
				+ "  def test() {\n"
				+ "    val x = new List<ClassC>\n"
				+ "  }\n"
				+ "}\n");
		XtendClass clazz = (XtendClass) file2.getXtendTypes().get(0);
		XBlockExpression block = (XBlockExpression) ((XtendFunction) clazz.getMembers().get(0)).getExpression();
		XVariableDeclaration declaration = (XVariableDeclaration) block.getExpressions().get(0);
		XConstructorCall cons = (XConstructorCall) declaration.getRight();
		JvmTypeReference reference = cons.getTypeArguments().get(0);
		assertNotNull(reference);
		assertNotNull(reference.getType());
		assertTrue(reference.getType().eIsProxy());
		assertNotNull(reference.eResource());
		assertEquals("ClassC", this.uiStrings.referenceToString(reference, "the-default-label"));
	}

	/** The qualified name of the type is specified.
	 * The JvmTypeReference is not a proxy.
	 */
	@Test
	public void testReferenceToString_2() throws Exception {
		XtendFile file = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "public interface InterfaceA { }\n"
				+ "public class ClassB implements InterfaceA { }\n"
				+ "public class ClassC extends ClassB {\n"
				+ "}\n"
				+ "class XtendClass1 {\n"
				+ "  def test() {\n"
				+ "    val x = new List<org.eclipse.xtend.core.tests.validation.uistrings.ClassC>\n"
				+ "  }\n"
				+ "}\n");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(3);
		XBlockExpression block = (XBlockExpression) ((XtendFunction) clazz.getMembers().get(0)).getExpression();
		XVariableDeclaration declaration = (XVariableDeclaration) block.getExpressions().get(0);
		XConstructorCall cons = (XConstructorCall) declaration.getRight();
		JvmTypeReference reference = cons.getTypeArguments().get(0);
		assertNotNull(reference);
		assertNotNull(reference.getType());
		assertFalse(reference.getType().eIsProxy());
		assertNotNull(reference.eResource());
		assertEquals("ClassC", this.uiStrings.referenceToString(reference, "the-default-label"));
	}

	/** The qualified name of the type is specified.
	 * The JvmTypeReference is proxy.
	 */
	@Test
	public void testReferenceToString_3() throws Exception {
		XtendFile file1 = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "public interface InterfaceA { }\n"
				+ "public class ClassB implements InterfaceA { }\n"
				+ "public class ClassC extends ClassB {\n"
				+ "}\n");
		assertNotNull(file1);
		XtendFile file2 = file(
				  "package org.eclipse.xtend.core.tests.validation.uistrings\n"
				+ "class XtendClass1 {\n"
				+ "  def test() {\n"
				+ "    val x = new List<org.eclipse.xtend.core.tests.validation.uistrings.ClassC>\n"
				+ "  }\n"
				+ "}\n");
		XtendClass clazz = (XtendClass) file2.getXtendTypes().get(0);
		XBlockExpression block = (XBlockExpression) ((XtendFunction) clazz.getMembers().get(0)).getExpression();
		XVariableDeclaration declaration = (XVariableDeclaration) block.getExpressions().get(0);
		XConstructorCall cons = (XConstructorCall) declaration.getRight();
		JvmTypeReference reference = cons.getTypeArguments().get(0);
		assertNotNull(reference);
		assertNotNull(reference.getType());
		assertTrue(reference.getType().eIsProxy());
		assertNotNull(reference.eResource());
		assertEquals("ClassC", this.uiStrings.referenceToString(reference, "the-default-label"));
	}
	
	@Test
	public void testReferenceToString_4() throws Exception {
		XtendFile file = file("class Foo { var test }");
		assertFalse(validationTestHelper.validate(file).isEmpty());
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendField field = (XtendField) clazz.getMembers().get(0);
		JvmField jvmField = associations.getJvmField(field);
		JvmTypeReference reference = jvmField.getType();
		assertNotNull(reference);
		assertNotNull(reference.getType());
		assertFalse(reference.getType().eIsProxy());
		assertNotNull(reference.eResource());
		assertEquals("Object", this.uiStrings.referenceToString(reference, "the-default-label"));
	}

}
