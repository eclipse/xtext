/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ecore.EcoreResourceDescription;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EcoreResourceDescriptionTest extends AbstractXtextTests {

	public void testClasspathURIIsNormalized() {
		XtextResourceSet xtextResourceSet = new XtextResourceSet();
		xtextResourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.ecore");
		Resource resource = xtextResourceSet.getResource(classpathURI, true);
		EcoreResourceDescription ecoreResourceDescription = new EcoreResourceDescription(resource);
		assertNotSame(classpathURI, ecoreResourceDescription.getURI());
		assertEquals(xtextResourceSet.getURIConverter().normalize(classpathURI), ecoreResourceDescription.getURI());
	}
}
