/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class Bug378261Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	private GrammarAccessFragment fragment = new GrammarAccessFragment(); 
	
	@Test public void testReplaceResourceURIs() {
		XtextResourceSet xtextResourceSet = get(XtextResourceSet.class);
		xtextResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		xtextResourceSet.setClasspathURIContext(this);
		Resource grammarResource = xtextResourceSet.getResource(URI.createURI("classpath:/org/eclipse/xtext/generator/grammarAccess/GrammarAccessTestLanguage.xtext"), true);
		EcoreUtil.resolveAll(grammarResource);
		Grammar grammar = (Grammar) grammarResource.getContents().get(0);
		EPackage ePackage = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertFalse(ePackage.eResource().getURI().equals(URI.createURI(ePackage.getNsURI())));
		fragment.replaceResourceURIsWithNsURIs(grammar, xtextResourceSet);
		assertEquals(ePackage.eResource().getURI(), URI.createURI(ePackage.getNsURI()));
	}
}
