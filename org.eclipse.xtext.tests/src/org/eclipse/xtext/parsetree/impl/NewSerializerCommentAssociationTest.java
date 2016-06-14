/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.xtext.parsetree.impl.commentAssociation.Element;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.util.ReplaceRegion;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NewSerializerCommentAssociationTest extends CommentAssociationTest {

	@Override
	protected void checkReplaceRegion(Element element, String expectedText, String completeModel) {
		Serializer serializer = get(Serializer.class);
		ReplaceRegion replacement = serializer.serializeReplacement(element, SaveOptions.defaultOptions());
		assertEquals(expectedText, replacement.getText());
		assertEquals(completeModel.indexOf(expectedText), replacement.getOffset());
		assertEquals(expectedText.length(), replacement.getLength());
	}
	
	@Override
	@Test
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=475457")
	public void testSerializeReplacement() throws Exception {
		super.testSerializeReplacement();
	}
	
	@Override
	protected ISerializer getSerializer() {
		return get(Serializer.class);
	}

	@Override
	protected String commentsAtEndOfFileExpectation() {
		// no unnecessary space
		return "element x // comment post x\nparent y element z";
	}
}

