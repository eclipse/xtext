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
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
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

	public void testContainmentRefSignificantLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getSignificantTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());		
		// multi feature index out of bounds -> return owner's significant region 
		location = locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 2);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.length(), location.getLength());		
	}
	
	public void testCrossRefSignificantLocation() throws Exception {
			assertEquals(2, elements.size());
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 0);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		// single feature index out of bounds -> ignore index 
		location = locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 1);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 0);
		assertEquals(indexOfSecondY, location.getOffset());
		assertEquals(1, location.getLength());
		// multi feature index out of bounds -> return owner's significant region 
		location = locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 1);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
	}

	public void testEObjectSignificantLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(elements.get(0));
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getSignificantTextRegion(elements.get(1));
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
	}

	public void testAttributeSignificantLocation() {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(elements.get(0), LocationprovidertestPackage.Literals.ELEMENT__NAME, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		// index out of bounds -> return owner's significant region 
		location = locationInFileProvider.getSignificantTextRegion(elements.get(1), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());		
	}

	public void testContainmentRefFullLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 0);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
		location = locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 1);
		assertEquals(modelAsString.lastIndexOf("element"), location.getOffset());
		assertEquals(modelAsString.length() - modelAsString.lastIndexOf("element"), location.getLength());		
		// multi feature index out of bounds -> return owner's full region 
		location = locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 2);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.length(), location.getLength());		
	}
	
	public void testCrossRefFullLocation() throws Exception {
			assertEquals(2, elements.size());
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		ITextRegion location = locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 0);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		// single feature index out of bounds -> ignore index 
		location = locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 1);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		location = locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 0);
		assertEquals(indexOfSecondY, location.getOffset());
		assertEquals(1, location.getLength());
		// multi feature index out of bounds -> return owner's full region 
		location = locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 1);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
	}

	public void testEObjectFullLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getFullTextRegion(elements.get(0));
		assertEquals(modelAsString.indexOf("element x"), location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
		location = locationInFileProvider.getFullTextRegion(elements.get(1));
		assertEquals(modelAsString.indexOf("element y"), location.getOffset());
		assertEquals("element y".length(), location.getLength());
	}

	public void testAttributeFullLocation() {
		assertEquals(2, elements.size());
		ITextRegion location = locationInFileProvider.getFullTextRegion(elements.get(0), LocationprovidertestPackage.Literals.ELEMENT__NAME, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		// single feature index out of bounds -> ignore index 
		location = locationInFileProvider.getFullTextRegion(elements.get(1), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals("y".length(), location.getLength());		
	}
}
