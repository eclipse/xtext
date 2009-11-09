/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class GrammarUtilTest extends AbstractGeneratorTest {

	public void testAllMetamodelDeclarations_01() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = "grammar foo with org.eclipse.xtext.common.Terminals " +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				"generate g 'http://3' as ecore " +
				"startrule returns ecore::startrule: name=ID;";
		Resource r = getResourceFromString(model);
		assertTrue(r.getErrors().isEmpty());
		Grammar g = (Grammar) r.getContents().get(0);
		List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
		// ecore as ecore
		// g as ecore
		// inherited ecore as ecore == ecore as bar
		assertEquals(2, decls.size());
		AbstractMetamodelDeclaration decl = decls.get(0);
		assertTrue(decl instanceof ReferencedMetamodel);
		assertNotNull(decl.getEPackage());
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		assertEquals("ecore", decl.getAlias());
		decl = decls.get(1);
		assertEquals("ecore", decl.getAlias());
		assertNotNull(decl.getEPackage());
		assertEquals("http://3", decl.getEPackage().getNsURI());
	}

	public void testAllMetamodelDeclarations_02() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = "grammar foo with org.eclipse.xtext.common.Terminals " +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as bar " +
				"generate g 'http://3' as bar " +
				"startrule returns bar::startrule: name=ID;";
		Resource r = getResourceFromString(model);
		assertTrue(r.getErrors().isEmpty());
		Grammar g = (Grammar) r.getContents().get(0);
		List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
		// ecore as bar
		// g as bar
		// inherited ecore as ecore != ecore as bar
		assertEquals(3, decls.size());
		AbstractMetamodelDeclaration decl = decls.get(0);
		assertTrue(decl instanceof ReferencedMetamodel);
		assertNotNull(decl.getEPackage());
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		assertEquals("bar", decl.getAlias());
		decl = decls.get(1);
		assertEquals("bar", decl.getAlias());
		assertNotNull(decl.getEPackage());
		assertEquals("http://3", decl.getEPackage().getNsURI());
		decl = decls.get(2);
		assertTrue(decl instanceof ReferencedMetamodel);
		assertNotNull(decl.getEPackage());
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		assertEquals("ecore", decl.getAlias());
	}

	public void testGetReference() throws Exception {
		with(LangATestLanguageStandaloneSetup.class);
		XtextResource resource = getResourceFromStringAndExpect("type A extends B", 1);

		Assignment asExtends = get(LangATestLanguageGrammarAccess.class).getTypeAccess().getExtendsAssignment_2_1();
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		EObject model = getModel(resource);
		EObject typeA = (EObject) invokeWithXtend("types.first()", model);
		EReference ref = GrammarUtil.getReference(xref, typeA.eClass());
		assertNotNull(ref);
		assertEquals("extends", ref.getName());
		assertFalse(ref.isMany());
		assertEquals(typeA.eClass(), ref.getEReferenceType());
	}

}
