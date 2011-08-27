/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.locationprovidertest.Bus;
import org.eclipse.xtext.resource.locationprovidertest.Component;
import org.eclipse.xtext.resource.locationprovidertest.Element;
import org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage;
import org.eclipse.xtext.resource.locationprovidertest.Mode;
import org.eclipse.xtext.resource.locationprovidertest.Model;
import org.eclipse.xtext.resource.locationprovidertest.Processor;
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
		modelAsString = 
				"element x singleref y multiref y element y\n" +
				"processor p1\n" + 
				"modes\n" + 
				"mode m1; \n" + 
				"mode m2; \n" + 
				"end;\n" +
				"bus b1\n" +
				"modes\n" +
				"mode mb1;\n" +
				"mode mb2;\n" +
				"end;";
		model = (Model) getModel(modelAsString);
		elements = model.getElements();
		locationInFileProvider = new DefaultLocationInFileProvider();
	}
	
	@Override
	protected void tearDown() throws Exception {
		elements = null;
		modelAsString = null;
		model = null;
		locationInFileProvider = null;
		super.tearDown();
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
		assertEquals("element y".length(), location.getLength());		
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
	
	public void testBug353969_Setup() throws Exception {
		EList<Component> components = model.getComponents();
		assertEquals(2, components.size());
		assertTrue(components.get(0) instanceof Processor);
		assertTrue(components.get(1) instanceof Bus);
	}
	
	public void testBug353969_01() throws Exception {
		Processor p = (Processor) model.getComponents().get(0);
		EList<Mode> modes = p.getMode();
		assertEquals(2, modes.size());
		Mode m1 = modes.get(0);
		ITextRegion m1FullRegion = locationInFileProvider.getFullTextRegion(m1);
		assertEquals(modelAsString.indexOf("mode m1;"), m1FullRegion.getOffset());
		assertEquals("mode m1;".length(), m1FullRegion.getLength());
		ITextRegion m1SignificantRegion = locationInFileProvider.getSignificantTextRegion(m1);
		assertEquals(modelAsString.indexOf("m1;"), m1SignificantRegion.getOffset());
		assertEquals("m1".length(), m1SignificantRegion.getLength());
	}
	
	public void testBug353969_02() throws Exception {
		Processor p = (Processor) model.getComponents().get(0);
		EList<Mode> modes = p.getMode();
		assertEquals(2, modes.size());
		Mode m2 = modes.get(1);
		ITextRegion m2FullRegion = locationInFileProvider.getFullTextRegion(m2);
		assertEquals(modelAsString.indexOf("mode m2;"), m2FullRegion.getOffset());
		assertEquals("mode m2;".length(), m2FullRegion.getLength());
		ITextRegion m2SignificantRegion = locationInFileProvider.getSignificantTextRegion(m2);
		assertEquals(modelAsString.indexOf("m2;"), m2SignificantRegion.getOffset());
		assertEquals("m2".length(), m2SignificantRegion.getLength());
	}
	
	public void testBug353969_03() throws Exception {
		Bus b = (Bus) model.getComponents().get(1);
		EList<Mode> modes = b.getMode();
		assertEquals(2, modes.size());
		Mode mb1 = modes.get(0);
		ITextRegion mb1FullRegion = locationInFileProvider.getFullTextRegion(mb1);
		assertEquals(modelAsString.indexOf("mode mb1;"), mb1FullRegion.getOffset());
		assertEquals("mode mb1;".length(), mb1FullRegion.getLength());
		ITextRegion mb1SignificantRegion = locationInFileProvider.getSignificantTextRegion(mb1);
		assertEquals(modelAsString.indexOf("mb1;"), mb1SignificantRegion.getOffset());
		assertEquals("mb1".length(), mb1SignificantRegion.getLength());
	}
	
	public void testBug353969_04() throws Exception {
		Bus b = (Bus) model.getComponents().get(1);
		EList<Mode> modes = b.getMode();
		assertEquals(2, modes.size());
		Mode mb2 = modes.get(1);
		ITextRegion mb2FullRegion = locationInFileProvider.getFullTextRegion(mb2);
		assertEquals(modelAsString.indexOf("mode mb2;"), mb2FullRegion.getOffset());
		assertEquals("mode mb2;".length(), mb2FullRegion.getLength());
		ITextRegion mb2SignificantRegion = locationInFileProvider.getSignificantTextRegion(mb2);
		assertEquals(modelAsString.indexOf("mb2;"), mb2SignificantRegion.getOffset());
		assertEquals("mb2".length(), mb2SignificantRegion.getLength());
	}
}
