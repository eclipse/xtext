/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.impl.bug305397.Element;
import org.eclipse.xtext.parsetree.impl.bug305397.Model;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class Bug305397Test extends AbstractXtextTests {
	
	public void testBug() throws Exception {
		with(new Bug305397StandaloneSetup());
		Model model = (Model) getModel("   a element \n   element X end\n element Y end \nend");
		Element outer = model.getElements().get(0);
		Element firstInner = outer.getElements().get(0);
		
		CompositeNode outerNode = NodeUtil.getNodeAdapter(outer).getParserNode();
		assertEquals(3,outerNode.getOffset());
		CompositeNode firstInnerNode = NodeUtil.getNodeAdapter(firstInner).getParserNode();
		assertEquals(17,firstInnerNode.getOffset());
	}

}
