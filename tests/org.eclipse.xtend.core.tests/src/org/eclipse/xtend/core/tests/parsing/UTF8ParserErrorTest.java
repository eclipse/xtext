/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.parsing;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UTF8ParserErrorTest extends AbstractXtendTestCase {
	
	@Override
	protected XtendFile file(String string, boolean validate) throws Exception {
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string, "UTF-8"), Collections.singletonMap(XtextResource.OPTION_ENCODING, "UTF-8"));
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
	@Test public void testInvalidIdentifier_01() throws Exception {
		XtendFunction func = function("def \\u0020invalidStart() {}");
		assertEquals("invalidStart", func.getName());
	}
	
	@Test public void testIdentifiers_02() throws Exception {
		XtendFunction func = function("def invalid\\u0020Part() {}");
		assertEquals("invalidPart", func.getName());
	}

	@Test public void testInvalidReference_01() throws Exception {
		XtendFunction func = function("def m() { \\u0020invalidStart }");
		XBlockExpression block = (XBlockExpression) func.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		String featureName = featureCall.getConcreteSyntaxFeatureName();
		assertEquals("\\u0020invalidStart", featureName);
		assertTrue(featureCall.getFeature().eIsProxy());
		List<Diagnostic> errorList = func.eResource().getErrors();
		assertEquals(2, errorList.size());
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errorList.get(1);
		assertTrue(diagnostic.getMessage().contains("invalidStart"));
	}
	
	@Test public void testInvalidReference_02() throws Exception {
		XtendFunction func = function("def m() { invalid\\u0020Part }");
		XBlockExpression block = (XBlockExpression) func.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		String featureName = featureCall.getConcreteSyntaxFeatureName();
		assertEquals("invalid\\u0020Part", featureName);
		assertTrue(featureCall.getFeature().eIsProxy());
		List<Diagnostic> errorList = func.eResource().getErrors();
		assertEquals(2, errorList.size());
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errorList.get(1);
		assertTrue(diagnostic.getMessage().contains("invalidPart"));
	}
	
}
