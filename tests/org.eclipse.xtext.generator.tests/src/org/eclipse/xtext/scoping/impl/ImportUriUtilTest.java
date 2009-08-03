/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ImportUriUtilTest extends AbstractXtextTests {
	
	public void testSimple() throws Exception {
		
		ResourceSet rs = new ResourceSetImpl();
		Resource foo = rs.createResource(URI.createURI("foo.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		foo.getContents().add(ePackage);
		Resource bar = rs.createResource(URI.createURI("bar.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		bar.getContents().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertEquals(bar, ImportUriUtil.getResource(foo, "bar.xmi"));
		assertEquals(true, ImportUriUtil.isValid(ePackage, "bar.xmi"));
	}
}
