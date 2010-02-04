/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.Wrapper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourceTest extends AbstractGeneratorTest {

	private XtextResource resource;
	private final String simpleModel = "spielplatz 1 { kind ( Bob 0 ) }";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		resource = getResourceFromString("");
	}

	public void testInitialState() throws Exception {
		assertNotNull(resource);
		assertTrue(resource.isLoaded());
		assertFalse("resource.isTrackingModification()", resource.isTrackingModification());
		assertFalse(resource.isModified());
		assertTrue(resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().isEmpty());

		IParseResult parseResult = resource.getParseResult();
		assertNotNull("parseResult", parseResult);
		assertNotNull(parseResult.getRootNode());
		assertEquals(0, parseResult.getParseErrors().size());
		assertEquals(0, parseResult.getRootNode().getTotalLength());
		assertNull(parseResult.getRootASTElement());
	}

	public void testModify_01() throws Exception {
		resource.update(0, 0, simpleModel);
		assertFalse(resource.isModified());
	}

	public void testModify_02() throws Exception {
		resource.reparse(simpleModel);
		assertFalse(resource.isModified());
	}

	public void testModify_03() throws Exception {
		resource.reparse(simpleModel);
		assertFalse(resource.isModified());
		modifySpielplatz();
		assertFalse(resource.isModified());
	}

	public void testModify_04() throws Exception {
		resource.setTrackingModification(true);
		resource.update(0, 0, simpleModel);
		assertTrue(resource.isModified());
	}

	public void testModify_05() throws Exception {
		resource.setTrackingModification(true);
		resource.reparse(simpleModel);
		assertFalse(resource.isModified());
	}

	public void testModify_06() throws Exception {
		resource.setTrackingModification(true);
		resource.reparse(simpleModel);
		assertFalse(resource.isModified());
		modifySpielplatz();
		assertTrue(resource.isModified());
	}

	private void modifySpielplatz() {
		EObject obj = resource.getParseResult().getRootASTElement();
		assertNotNull(obj);
		assertEquals("Spielplatz", obj.eClass().getName());
		EStructuralFeature feature = obj.eClass().getEStructuralFeature("groesse");
		assertNotNull(feature);
		assertEquals(1, obj.eGet(feature));
		obj.eSet(feature, 3);
	}

	public void testUnload() throws Exception {
		resource.reparse(simpleModel);
		IParseResult parseResult = resource.getParseResult();
		resource.unload();
		assertNull(resource.getParseResult());
		assertTrue(parseResult.getRootASTElement().eIsProxy());
	}

	public void testUnloadReferables() throws Exception {
		resource.reparse(simpleModel);
		final Wrapper<Boolean> unloaded = Wrapper.wrap(Boolean.FALSE);
		resource.setUnloader(new IReferableElementsUnloader() {
			public void unloadRoot(EObject root) {
				unloaded.set(Boolean.TRUE);
			}
		});
		resource.reparse(simpleModel);
		assertTrue("unloaded", unloaded.get());
	}
	
	public void testUpdate() throws Exception {
		resource.update(0, 0, simpleModel);

		IParseResult parseResult = resource.getParseResult();
		assertNotNull("parseResult", parseResult);
		assertNotNull(parseResult.getRootNode());
		assertEquals(0, parseResult.getParseErrors().size());
		assertEquals(simpleModel.length(), parseResult.getRootNode().getTotalLength());
		assertNotNull(parseResult.getRootASTElement());
	}

	public void testErrorMarkers() throws Exception {
		String model = "spielplatz 1 {kind(B 1) erwachsener(E 1) familie(F E E B, C)}";
		resource.update(0, 0, model);
		EcoreUtil.resolveAll(resource);
		assertEquals(1, resource.getErrors().size());
		XtextLinkingDiagnostic diag = (XtextLinkingDiagnostic) resource.getErrors().get(0);
		assertEquals(model.indexOf("C)"), diag.getOffset());
		assertEquals(1, diag.getLength());
	}


}
