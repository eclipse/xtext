/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class CommentOnEofBug_234135_Test extends AbstractXtextTests {

    @Test public void testCommentOnEof() throws Exception {
        with(ReferenceGrammarTestLanguageStandaloneSetup.class);
        String model = "//comment";
        List<ILeafNode> leafNodes = Lists.newArrayList(getRootNode(model).getLeafNodes());
        assertEquals(1, leafNodes.size());
        EObject grammarElement = leafNodes.get(0).getGrammarElement();
        assertNotNull(grammarElement);
        assertTrue(grammarElement instanceof TerminalRule);
    }

}
