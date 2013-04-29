/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.builder.builderState.impl.BuilderStateFactoryImpl;
import org.eclipse.xtext.naming.QualifiedName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderStateFactoryTest extends Assert {

	private BuilderStateFactory factory;
	private EDataType dataType;

	@Before
	public void setUp() throws Exception {
		factory = BuilderStateFactory.eINSTANCE;
		dataType = BuilderStatePackage.Literals.QUALIFIED_NAME;
	}
	
	@Test public void testEmptyQualifiedName() {
		QualifiedName empty = QualifiedName.EMPTY;
		String converted = factory.convertToString(dataType, empty);
		assertNotNull(converted);
	}
	
	@Test public void testEmptyStringToQualifiedName() {
		QualifiedName qn = (QualifiedName) factory.createFromString(dataType, "");
		assertEquals(QualifiedName.EMPTY, qn);
	}
	
	@Test public void testNullToQualifiedName() {
		QualifiedName qn = (QualifiedName) factory.createFromString(dataType, null);
		assertEquals(QualifiedName.EMPTY, qn);
	}
	
	@Test public void testValueConversionURI() {
		BuilderStateFactoryImpl implementation = (BuilderStateFactoryImpl) factory;
		assertNotNull(implementation.create(BuilderStatePackage.Literals.EURI));
	}
	@Test public void testValueConversionQualifiedName() {
		BuilderStateFactoryImpl implementation = (BuilderStateFactoryImpl) factory;
		assertNotNull(implementation.create(BuilderStatePackage.Literals.QUALIFIED_NAME));
	}
	
}
