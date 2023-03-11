/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.ui.hover.JvmAnnotationReferencePrinter
import org.junit.Assert
import org.junit.Test

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
