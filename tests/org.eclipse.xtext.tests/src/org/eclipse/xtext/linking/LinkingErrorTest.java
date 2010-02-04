/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class LinkingErrorTest extends AbstractGeneratorTest {

	private static final Logger logger = Logger.getLogger(CrossRefTest.class);

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
	}

	public void testNoErrors() throws Exception {
		XtextResource resource = getResourceFromString(" type A extends B \n type B extends A");
		EObject model = getModel(resource);
		logger.debug(invokeWithXtend("types.collect(e|e.name+'->'+e.extends.name).toString(',')", model));
		assertWithXtend("2", "types.size", model);
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	public void testLinkError() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(" type A extends B \n type B extends C", 1);
		EObject model = getModel(resource);
		logger.debug(invokeWithXtend("types.collect(e|e.name+'->'+e.extends.name).toString(',')", model));
		assertWithXtend("2", "types.size", model);
		assertEquals(1, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());

		Diagnostic error = (Diagnostic) resource.getErrors().get(0);
		assertEquals(2, error.getLine());
		Diagnostic verboseError = error;
		assertEquals(35, verboseError.getOffset());
		assertEquals(1, verboseError.getLength());
	}

	private int getTreeIteratorContentSize(TreeIterator<Object> iterator) {
		int result = 0;
		while(iterator.hasNext()) {
			result ++;
			Object item = iterator.next();
			logger.debug(item);
		}
		return result;
	}

	private int getContentSize(EObject model) {
		Resource resource = model.eResource();
		assertNotNull(resource);
		ResourceSet resourceSet = resource.getResourceSet();
		assertNotNull(resourceSet);
		TreeIterator<Object> iterator = EcoreUtil.getAllProperContents(resourceSet, true);
		return getTreeIteratorContentSize(iterator);
	}

	public void testReparse() throws Exception {
		String modelText = " type A extends B \n type B extends C";
		XtextResource resource = getResourceFromStringAndExpect(modelText, 1);
		EObject model = getModel(resource);
		logger.debug(invokeWithXtend("types.collect(e|e.name+'->'+e.extends.name).toString(',')", model));

		assertWithXtend("2", "types.size", model);
		assertEquals(4, getContentSize(model));

		resource.reparse(modelText);
		model = getModel(resource);
		assertWithXtend("2", "types.size", model);
		assertEquals(4, getContentSize(model));
	}


}
