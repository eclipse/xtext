/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;


import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LeafNodeBug_234132_Test extends AbstractGeneratorTest {
	
	private static final Logger logger = Logger.getLogger(LeafNodeBug_234132_Test.class);

    public void testLeafNodeBug() throws Exception {
        with(ReferenceGrammarStandaloneSetup.class);
        String model = readFileIntoString("org/eclipse/xtext/reference/leafNodeBug_234132.tst");
        CompositeNode rootNode = getRootNode(model);
        
        EList<LeafNode> leafNodes = rootNode.getLeafNodes();
        logger.debug("Model length=" + model.length());
        for (LeafNode leafNode : leafNodes) {
            String text = leafNode.getText();
            logger.debug("Leaf node" + leafNode.toString() + " offset=" + leafNode.getOffset() + " length=" + leafNode.getLength() + " text=" + ((text != null)? text : ""));
            assertTrue(leafNode.getLength() + leafNode.getOffset() <= model.length());
            assertEquals(model.substring(leafNode.getOffset(), leafNode.getOffset() + leafNode.getLength()), leafNode.getText());
        }
    }
}
