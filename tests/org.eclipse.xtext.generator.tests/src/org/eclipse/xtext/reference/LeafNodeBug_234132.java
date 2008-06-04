/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;


import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LeafNodeBug_234132 extends AbstractGeneratorTest {

    public void testLeafNodeBug() throws Exception {
        with(ReferenceGrammarStandaloneSetup.class);
        String model = readFileIntoString("org/eclipse/xtext/reference/leafNodeBug_234132.tst");
        CompositeNode rootNode = getRootNode(model,new IParseErrorHandler() {
            public void handleParserError(IParseError error) {
                int foo =42;
                // ignore
            }
        });
        
        EList<LeafNode> leafNodes = rootNode.getLeafNodes();
        System.out.println("Model length=" + model.length());
        for (LeafNode leafNode : leafNodes) {
            String text = leafNode.getText();
            System.out.println("Leaf node" + leafNode.toString() + " offset=" + leafNode.offset() + " length=" + leafNode.length() + " text=" + ((text != null)? text : ""));
            assertTrue(leafNode.length() + leafNode.offset() <= model.length());
            assertEquals(model.substring(leafNode.offset(), leafNode.offset() + leafNode.length()), leafNode.getText());
        }
    }
}
