/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Bug283278Test extends AbstractXtextTests {
	
	public void testCheckGeneratedEcoreModel() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		URL url = getClass().getResource("SubTestLanguage.ecore");
		URI uri = URI.createURI(url.toString());
		Resource resource = rs.getResource(uri, true);
		EcoreUtil.resolveAll(resource);
		assertEquals(2,rs.getResources().size());
	}
}
