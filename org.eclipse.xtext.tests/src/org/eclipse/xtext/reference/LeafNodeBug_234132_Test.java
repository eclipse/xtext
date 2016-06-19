/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class LeafNodeBug_234132_Test extends AbstractXtextTests {
	
    @Test public void testLeafNodeBug() throws Exception {
        with(ReferenceGrammarTestLanguageStandaloneSetup.class);
        String model = readFileIntoString("org/eclipse/xtext/reference/leafNodeBug_234132.tst");
        ICompositeNode rootNode = getRootNodeAndExpect(model, 1);
        for(ILeafNode leafNode: rootNode.getLeafNodes()) {
            assertTrue(leafNode.getTotalLength() + leafNode.getTotalOffset() <= model.length());
            assertEquals(model.substring(leafNode.getTotalOffset(), leafNode.getTotalOffset() + leafNode.getTotalLength()), leafNode.getText());
        }
    }
}
