/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import junit.framework.TestCase;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class TransformationDiagnosticTest extends TestCase {

	public void testEnumCode() throws Exception {
		String expected = "org.eclipse.xtext.xtext.ecoreInference.TransformationErrorCode.AliasForMetamodelAlreadyExists";
		assertEquals(expected, TransformationErrorCode.AliasForMetamodelAlreadyExists.getFullyQualifiedCode());
	}
	
	public void testDiagnostic() throws Exception {
		AbstractNode node = ParsetreeFactory.eINSTANCE.createLeafNode();
		TransformationDiagnostic diagnostic = new TransformationDiagnostic(node, "message", TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists);
		String expected = "org.eclipse.xtext.xtext.ecoreInference.TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists";
		assertEquals(expected, diagnostic.getCode());
	}
}
