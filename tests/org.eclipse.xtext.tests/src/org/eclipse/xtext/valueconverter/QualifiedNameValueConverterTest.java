/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.valueconverter.qualifiedName.Element;
import org.eclipse.xtext.valueconverter.qualifiedName.QualifiedNameFactory;

/**
 * @author koehnlein - Initial contribution and API
 */
public class QualifiedNameValueConverterTest extends AbstractXtextTests {

	public static final String KEYWORD = "keyword";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(QualifiedNameTestlanguageStandaloneSetup.class);
	}

	public void testQualifiedNameValueConverter() throws Exception {
		checkBothDirections("keywrd", "keywrd");
		checkBothDirections("nokeyword", "nokeyword");
		checkBothDirections("^keyword.nokeyword", "keyword.nokeyword");
		checkBothDirections("nokeyword.^keyword.nokeyword", "nokeyword.keyword.nokeyword");
		checkBothDirections("nokeyword.^keyword.nokeyword.*", "nokeyword.keyword.nokeyword.*");
		checkToValue("nokeyword. /* comment */ ^keyword. nokeyword.*", "nokeyword.keyword.nokeyword.*");
	}

	private void checkBothDirections(String nameAsString, String nameAsValue) throws Exception {
		checkToValue(nameAsString, nameAsValue);
		checkToString(nameAsString, nameAsValue);
	}

	protected void checkToString(String nameAsString, String nameAsValue) {
		String model = "keyword " + nameAsString;
		Element element = QualifiedNameFactory.eINSTANCE.createElement();		
		element.setQualifiedName(nameAsValue);
		String serializedModel = getSerializer().serialize(element);
		assertEquals(serializedModel, model);
	}

	private void checkToValue(String nameAsString, String nameAsValue) throws Exception {
		String model = "keyword " + nameAsString;
		XtextResource resource = getResource(model, "tempuri");
		Element element = (Element) resource.getContents().get(0);
		assertEquals(nameAsValue, element.getQualifiedName());
	}
	
}
