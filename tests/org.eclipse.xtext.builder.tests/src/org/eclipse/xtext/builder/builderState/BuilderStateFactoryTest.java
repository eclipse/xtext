/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.naming.QualifiedName;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderStateFactoryTest extends TestCase {

	private BuilderStateFactory factory;
	private EDataType dataType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = BuilderStateFactory.eINSTANCE;
		dataType = BuilderStatePackage.Literals.QUALIFIED_NAME;
	}
	
	public void testEmptyQualifiedName() {
		QualifiedName empty = QualifiedName.EMPTY;
		String converted = factory.convertToString(dataType, empty);
		assertNotNull(converted);
	}
	
	public void testEmptyStringToQualifiedName() {
		QualifiedName qn = (QualifiedName) factory.createFromString(dataType, "");
		assertEquals(QualifiedName.EMPTY, qn);
	}
	
	public void testNullToQualifiedName() {
		QualifiedName qn = (QualifiedName) factory.createFromString(dataType, null);
		assertEquals(QualifiedName.EMPTY, qn);
	}
	
}
