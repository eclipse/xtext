/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;

import org.eclipse.xtext.parsetree.reconstr.bug302128.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author svenefftinge - Initial contribution and API
 * 
 *         https://bugs.eclipse.org/bugs/show_bug.cgi?id=302128
 */
public class Bug302128Test extends AbstractXtextTests {

	@Test public void testTheBug2() throws Exception {
		with(new Bug302128TestLanguageStandaloneSetup());
		String text = "VARIABLE += value.val value2.val\n" 
				+ "VARIABLE2 += value3.val value4.val\n\n"
				+ "#Comment comment comment\n\n" 
				+ "VARIABLE3 += value5.val value6.val\n"
				+ "VARIABLE4 += value.val value2.val\n" 
				+ "VARIABLE5 += value3.val value4.val\n\n" 
				+ "#Comment comment comment\n\n" +
				  "VARIABLE.varible += value5.val value6.val\n";
		XtextResource resource = getResource(new StringInputStream(text));
		Model model = (Model) resource.getContents().get(0);
		model.getElements().get(2).setValue("+= value5.val value6.val\n");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, null);
		assertEquals(text, new String(outputStream.toByteArray()));
	}

}
