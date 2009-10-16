/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilFactory;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserCrossContainmentSingleTest extends AbstractPartialParserCrossContainmentTest {

	@Override
	protected void setCrossResourceContainer(XtextResource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		Resource containerResource = resourceSet.createResource(URI.createFileURI("sample.xmi"));
		CrossResourceContainerOneChild container = PartialParsingTestUtilFactory.eINSTANCE.createCrossResourceContainerOneChild();
		containerResource.getContents().add(container);
		assertEquals(1, resource.getContents().size());
		container.setChild(resource.getContents().get(0));
	}
	
}
