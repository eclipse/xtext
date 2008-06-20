/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import static org.eclipse.xtext.parsetree.NodeUtil.dumpCompositeNodes;
import static org.eclipse.xtext.parsetree.NodeUtil.getCompositeChildren;

import java.util.List;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.LookaheadLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LookaheadTest extends AbstractGeneratorTest {

    /* (non-Javadoc)
     * @see org.eclipse.xtext.tests.AbstractGeneratorTest#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        with(LookaheadLanguageStandaloneSetup.class);
    }
    
    public void testLookahead() throws Exception {
        CompositeNode rootNode = getRootNode("bar a foo bar c b d foo bar b c");
        dumpCompositeNodes("", rootNode);
        assertEquals(0, rootNode.getLookahead());
        List<CompositeNode> alts = getCompositeChildren(rootNode);
        assertEquals(1, alts.get(0).getLookahead());
        assertEquals(1, alts.get(1).getLookahead());
        assertEquals(1, alts.get(2).getLookahead());
        assertEquals(1, getCompositeChildren(alts.get(0)).get(0).getLookahead());
        CompositeNode lookahead0 = getCompositeChildren(alts.get(1)).get(0);
        assertEquals(3, lookahead0.getLookahead());
        assertEquals(0, getCompositeChildren(lookahead0).get(0).getLookahead());
        CompositeNode lookahead3 = getCompositeChildren(alts.get(2)).get(0);
        assertEquals(3, lookahead3.getLookahead());
        assertEquals(0, getCompositeChildren(lookahead3).get(0).getLookahead());
    }    
    
}
