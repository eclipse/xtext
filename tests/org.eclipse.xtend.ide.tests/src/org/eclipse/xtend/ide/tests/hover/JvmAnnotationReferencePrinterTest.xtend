/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.xbase.ui.hover.JvmAnnotationReferencePrinter

/**
 * @author Sven Efftinge - Initial contribution and API
 */
 
class JvmAnnotationReferencePrinterTest extends AbstractXtendUITestCase {
	
	
	@Inject TestingJvmAnnotationValuePrinter printer
	
	static class TestingJvmAnnotationValuePrinter extends JvmAnnotationReferencePrinter {
		
		override protected createLinkWithLabel(String scheme, URI uri, String label) {
			"!"+label+"!"
		}
		
	}
	
	@Test def void testPrintedAnnotationValue() {
		assertPrinted('@!SuppressWarnings!("all")', '@SuppressWarnings("all")')
	}
	@Test def void testPrintedAnnotationValue_01() {
		assertPrinted('@!SuppressWarnings!("all")', "@SuppressWarnings('all')")
	}
	@Test def void testPrintedAnnotationValue_02() {
		assertPrinted('@!SuppressWarnings!(42)', '@SuppressWarnings(42)')
	}
	@Test def void testPrintedAnnotationValue_03() {
		assertPrinted('@!SuppressWarnings!(true)', '@SuppressWarnings(true)')
	}
	@Test def void testPrintedAnnotationValue_04() {
		assertPrinted('@!SuppressWarnings!(false)', '@SuppressWarnings(false)')
	}
	@Test def void testPrintedAnnotationValue_05() {
		assertPrinted('@!SuppressWarnings!(#[true, false])', '@SuppressWarnings(#[true,false])')
	}
	@Test def void testPrintedAnnotationValue_06() {
		assertPrinted('@!SuppressWarnings!(#[!String!, !Integer!])', '@SuppressWarnings(#[String,Integer])')
	}
	@Test def void testPrintedAnnotationValue_07() {
		assertPrinted('@!Retention!(!RetentionPolicy!.!SOURCE!)', '@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)')
	}
	@Test def void testPrintedAnnotationValue_08() {
		assertPrinted('@!Generated!(!value!="foo", !date!="bar", !comments!="baz")', '@javax.annotation.Generated(value="foo", date="bar", comments="baz")')
	}
	@Test def void testPrintedAnnotationValue_09() {
		assertPrinted('@!XmlElements!(#[@!XmlElement!])', '@javax.xml.bind.annotation.XmlElements(#[@javax.xml.bind.annotation.XmlElement()])')
	}
	@Test def void testPrintedAnnotationValue_10() {
		assertPrinted('@!XmlElements!(@!XmlElement!)', '@javax.xml.bind.annotation.XmlElements(@javax.xml.bind.annotation.XmlElement())')
	}
	@Test def void testPrintedAnnotationValue_11() {
		assertPrinted('@!XmlElements!(#[@!XmlElement!(!nillable!=true), @!XmlElement!(!type!=!String![][])])', '@javax.xml.bind.annotation.XmlElements(@javax.xml.bind.annotation.XmlElement(nillable=true), @javax.xml.bind.annotation.XmlElement(type=typeof(String[][])))')
	}
	
	@Inject WorkbenchTestHelper testHelper
	@Inject IResourceSetProvider resourceSetProvider
	@Inject ParseHelper<XtendFile> parseHelper
	private def void assertPrinted(String expected, String xtendCode) {
		val file = parseHelper.parse('''
			«xtendCode» class Foo {}
		''', resourceSetProvider.get(testHelper.project))
		val annoVal = file.eResource.contents.filter(JvmGenericType).head.annotations.head
		Assert.assertEquals(expected, printer.toHtmlString(annoVal))
	}
	
}
