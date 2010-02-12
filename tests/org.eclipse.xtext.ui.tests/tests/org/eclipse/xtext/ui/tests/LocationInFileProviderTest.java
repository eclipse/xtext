/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests;

import java.util.List;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.DefaultLocationInFileProvider;
import org.eclipse.xtext.ui.ILocationInFileProvider;
import org.eclipse.xtext.ui.tests.locationprovidertest.Element;
import org.eclipse.xtext.ui.tests.locationprovidertest.LocationprovidertestPackage;
import org.eclipse.xtext.ui.tests.locationprovidertest.Model;

/**
 * @author koehnlein - Initial contribution and API
 */
public class LocationInFileProviderTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LocationProviderTestLanguageStandaloneSetup.class);
	}

	public void testCrossRefLocation() throws Exception {
		String modelAsString = "element x singleref y multiref y element y";
		Model model = (Model) getModel(modelAsString);
		List<Element> elements = model.getElements();
		assertEquals(2, elements.size());
		ILocationInFileProvider locationInFileProvider = new DefaultLocationInFileProvider();
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		Region location = locationInFileProvider.getLocation(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 0);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 1);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 0);
		assertEquals(indexOfSecondY, location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 1);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
	}

	public void testEObjectCLocation() throws Exception {
		String modelAsString = "element x singleref y multiref y element y";
		Model model = (Model) getModel(modelAsString);
		List<Element> elements = model.getElements();
		assertEquals(2, elements.size());
		ILocationInFileProvider locationInFileProvider = new DefaultLocationInFileProvider();
		Region location = locationInFileProvider.getLocation(elements.get(0));
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(1));
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
	}

}
