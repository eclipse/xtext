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
import org.eclipse.xtext.resource.locationprovidertest.Bus;
import org.eclipse.xtext.resource.locationprovidertest.Component;
import org.eclipse.xtext.resource.locationprovidertest.Element;
import org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage;
import org.eclipse.xtext.resource.locationprovidertest.Mode;
import org.eclipse.xtext.resource.locationprovidertest.Model;
import org.eclipse.xtext.resource.locationprovidertest.Processor;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LocationInFileProviderTest extends AbstractXtextTests {

	private List<Element> elements;
	private String modelAsString;
	private Model model;
	private ILocationInFileProvider locationInFileProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LocationProviderTestLanguageStandaloneSetup.class);
		modelAsString = 
				"element x singleref y multiref y element y\n" + // 0
				"processor p1\n" + // 1
				"modes\n" + // 2
				"mode m1; \n" + // 3
				"mode m2; \n" + // 4
				"end;\n" + // 5
				"bus b1\n" + // 6
				"modes\n" + // 7
				"mode mb1;\n" + // 8
				"mode mb2;\n" + // 9
				"end;"; // 10
		model = (Model) getModel(modelAsString);
		elements = model.getElements();
		locationInFileProvider = new DefaultLocationInFileProvider();
	}
	
	@Override
	public void tearDown() throws Exception {
		elements = null;
		modelAsString = null;
		model = null;
		locationInFileProvider = null;
		super.tearDown();
	}

	@Test public void testContainmentRefSignificantLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// multi feature index out of bounds -> return owner's significant region 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 2);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.length(), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(10, location.getEndLineNumber());
	}
	
	@Test public void testCrossRefSignificantLocation() throws Exception {
			assertEquals(2, elements.size());
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 0);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		
		// single feature index out of bounds -> ignore index 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 1);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 0);
		assertEquals(indexOfSecondY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// multi feature index out of bounds -> return owner's significant region 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 1);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}

	@Test public void testEObjectSignificantLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0));
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(1));
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}

	@Test public void testAttributeSignificantLocation() {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(0), LocationprovidertestPackage.Literals.ELEMENT__NAME, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// index out of bounds -> return owner's significant region 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(elements.get(1), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}

	@Test public void testContainmentRefFullLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 0);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 1);
		assertEquals(modelAsString.lastIndexOf("element"), location.getOffset());
		assertEquals("element y".length(), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// multi feature index out of bounds -> return owner's full region 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(model, LocationprovidertestPackage.Literals.MODEL__ELEMENTS, 2);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.length(), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(10, location.getEndLineNumber());
	}
	
	@Test public void testCrossRefFullLocation() throws Exception {
			assertEquals(2, elements.size());
		int indexOfFirstY = modelAsString.indexOf("y");
		int indexOfSecondY = modelAsString.indexOf("y", indexOfFirstY + 1);
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 0);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// single feature index out of bounds -> ignore index 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__SINGLEREF, 1);
		assertEquals(indexOfFirstY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 0);
		assertEquals(indexOfSecondY, location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// multi feature index out of bounds -> return owner's full region 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0),
				LocationprovidertestPackage.Literals.ELEMENT__MULTIREFS, 1);
		assertEquals(0, location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}

	@Test public void testEObjectFullLocation() throws Exception {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0));
		assertEquals(modelAsString.indexOf("element x"), location.getOffset());
		assertEquals(modelAsString.indexOf(" element y"), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(1));
		assertEquals(modelAsString.indexOf("element y"), location.getOffset());
		assertEquals("element y".length(), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}

	@Test public void testAttributeFullLocation() {
		assertEquals(2, elements.size());
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(0), LocationprovidertestPackage.Literals.ELEMENT__NAME, 0);
		assertEquals(modelAsString.indexOf("x"), location.getOffset());
		assertEquals(1, location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
		// single feature index out of bounds -> ignore index 
		location = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(elements.get(1), LocationprovidertestPackage.Literals.ELEMENT__NAME, 1);
		assertEquals(modelAsString.lastIndexOf("y"), location.getOffset());
		assertEquals("y".length(), location.getLength());
		assertEquals(0, location.getLineNumber());
		assertEquals(0, location.getEndLineNumber());
	}
	
	@Test public void testBug353969_Setup() throws Exception {
		EList<Component> components = model.getComponents();
		assertEquals(2, components.size());
		assertTrue(components.get(0) instanceof Processor);
		assertTrue(components.get(1) instanceof Bus);
	}
	
	@Test public void testBug353969_01() throws Exception {
		Processor p = (Processor) model.getComponents().get(0);
		EList<Mode> modes = p.getMode();
		assertEquals(2, modes.size());
		Mode m1 = modes.get(0);
		ITextRegionWithLineInformation m1FullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(m1);
		assertEquals(modelAsString.indexOf("mode m1;"), m1FullRegion.getOffset());
		assertEquals("mode m1;".length(), m1FullRegion.getLength());
		assertEquals(3, m1FullRegion.getLineNumber());
		assertEquals(3, m1FullRegion.getEndLineNumber());
		ITextRegionWithLineInformation m1SignificantRegion = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(m1);
		assertEquals(modelAsString.indexOf("m1;"), m1SignificantRegion.getOffset());
		assertEquals("m1".length(), m1SignificantRegion.getLength());
		assertEquals(3, m1SignificantRegion.getLineNumber());
		assertEquals(3, m1SignificantRegion.getEndLineNumber());
	}
	
	@Test public void testBug353969_02() throws Exception {
		Processor p = (Processor) model.getComponents().get(0);
		EList<Mode> modes = p.getMode();
		assertEquals(2, modes.size());
		Mode m2 = modes.get(1);
		ITextRegionWithLineInformation m2FullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(m2);
		assertEquals(modelAsString.indexOf("mode m2;"), m2FullRegion.getOffset());
		assertEquals("mode m2;".length(), m2FullRegion.getLength());
		assertEquals(4, m2FullRegion.getLineNumber());
		assertEquals(4, m2FullRegion.getEndLineNumber());
		ITextRegionWithLineInformation m2SignificantRegion = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(m2);
		assertEquals(modelAsString.indexOf("m2;"), m2SignificantRegion.getOffset());
		assertEquals("m2".length(), m2SignificantRegion.getLength());
		assertEquals(4, m2SignificantRegion.getLineNumber());
		assertEquals(4, m2SignificantRegion.getEndLineNumber());
	}
	
	@Test public void testBug353969_03() throws Exception {
		Bus b = (Bus) model.getComponents().get(1);
		EList<Mode> modes = b.getMode();
		assertEquals(2, modes.size());
		Mode mb1 = modes.get(0);
		ITextRegionWithLineInformation mb1FullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(mb1);
		assertEquals(modelAsString.indexOf("mode mb1;"), mb1FullRegion.getOffset());
		assertEquals("mode mb1;".length(), mb1FullRegion.getLength());
		assertEquals(8, mb1FullRegion.getLineNumber());
		assertEquals(8, mb1FullRegion.getEndLineNumber());
		ITextRegionWithLineInformation mb1SignificantRegion = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(mb1);
		assertEquals(modelAsString.indexOf("mb1;"), mb1SignificantRegion.getOffset());
		assertEquals("mb1".length(), mb1SignificantRegion.getLength());
		assertEquals(8, mb1SignificantRegion.getLineNumber());
		assertEquals(8, mb1SignificantRegion.getEndLineNumber());
	}
	
	@Test public void testBug353969_04() throws Exception {
		Bus b = (Bus) model.getComponents().get(1);
		EList<Mode> modes = b.getMode();
		assertEquals(2, modes.size());
		Mode mb2 = modes.get(1);
		ITextRegionWithLineInformation mb2FullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(mb2);
		assertEquals(modelAsString.indexOf("mode mb2;"), mb2FullRegion.getOffset());
		assertEquals("mode mb2;".length(), mb2FullRegion.getLength());
		assertEquals(9, mb2FullRegion.getLineNumber());
		assertEquals(9, mb2FullRegion.getEndLineNumber());
		ITextRegionWithLineInformation mb2SignificantRegion = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(mb2);
		assertEquals(modelAsString.indexOf("mb2;"), mb2SignificantRegion.getOffset());
		assertEquals("mb2".length(), mb2SignificantRegion.getLength());
		assertEquals(9, mb2SignificantRegion.getLineNumber());
		assertEquals(9, mb2SignificantRegion.getEndLineNumber());
	}
	
	@Test public void testLineNumbers_01() throws Exception {
		Processor p = (Processor) model.getComponents().get(0);
		ITextRegionWithLineInformation fullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(p);
		int b1Index = modelAsString.indexOf("processor p1");
		assertEquals(b1Index, fullRegion.getOffset());
		assertEquals(modelAsString.indexOf("end;") - b1Index + "end;".length(), fullRegion.getLength());
		assertEquals(1, fullRegion.getLineNumber());
		assertEquals(5, fullRegion.getEndLineNumber());
	}
	
	@Test public void testLineNumbers_02() throws Exception {
		Bus b = (Bus) model.getComponents().get(1);
		ITextRegionWithLineInformation fullRegion = (ITextRegionWithLineInformation) locationInFileProvider.getFullTextRegion(b);
		int b1Index = modelAsString.indexOf("bus b1");
		assertEquals(b1Index, fullRegion.getOffset());
		assertEquals(modelAsString.length() - b1Index, fullRegion.getLength());
		assertEquals(6, fullRegion.getLineNumber());
		assertEquals(10, fullRegion.getEndLineNumber());
	}
}
