/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.locationprovidertest.Element;
import org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage;
import org.eclipse.xtext.resource.locationprovidertest.Model;
import org.eclipse.xtext.util.TextLocation;

/**
 * @author koehnlein - Initial contribution and API
 */
public class LocationInFileProviderTest extends AbstractXtextTests {

	private List<Element> elements;
	private String modelAsString;
	private Model model;
	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LocationProviderTestLanguageStandaloneSetup.class);
		modelAsString = "element x singleref y multiref y element y";
		model = (Model) getModel(modelAsString);
		elements = model.getElements();
		locationInFileProvider = new DefaultLocationInFileProvider();
	}

	public void testContainmentRefLocation() throws Exception {
		assertEquals(2, elements.size());
		TextLocation location = locationInFileProvider.getLocation(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());		
	}
	
	public void testCrossRefLocation() throws Exception {
			assertEquals(2, elements.size());
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		TextLocation location = locationInFileProvider.getLocation(elements.get(0),
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

	public void testEObjectLocation() throws Exception {
		assertEquals(2, elements.size());
		TextLocation location = locationInFileProvider.getLocation(elements.get(0));
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(1));
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
	}

	public void testAttributeLocation() {
		assertEquals(2, elements.size());
		TextLocation location = locationInFileProvider.getLocation(elements.get(0), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getLocation(elements.get(1), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());		
	}
}
