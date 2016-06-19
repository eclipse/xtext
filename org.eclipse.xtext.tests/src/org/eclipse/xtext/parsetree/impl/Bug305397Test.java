/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.impl.bug305397.Element;
import org.eclipse.xtext.parsetree.impl.bug305397.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Effting - Initial contribution and API
 */
public class Bug305397Test extends AbstractXtextTests {
	
	@Test public void testBug() throws Exception {
		with(new Bug305397StandaloneSetup());
		Model model = (Model) getModel("   a element \n   element X end\n element Y end \nend");
		Element outer = model.getElements().get(0);
		Element firstInner = outer.getElements().get(0);
		
		ICompositeNode outerNode = NodeModelUtils.getNode(outer);
		assertEquals(3,outerNode.getOffset());
		ICompositeNode firstInnerNode = NodeModelUtils.getNode(firstInner);
		assertEquals(17,firstInnerNode.getOffset());
	}

}
