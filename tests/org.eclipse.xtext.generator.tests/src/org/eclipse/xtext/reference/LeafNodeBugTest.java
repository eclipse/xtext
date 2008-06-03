/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;

import java.io.InputStream;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LeafNodeBugTest extends AbstractGeneratorTest {

    public void testLeafNodeBug() throws Exception {
        with(ReferenceGrammarStandaloneSetup.class);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("org/eclipse/xtext/reference/leafNodeBug.tst");
        CompositeNode rootNode = getRootNode(resourceAsStream);
        LeafNode leafNode = rootNode.getLeafNodes().get(0);
        assertEquals(0, leafNode.offset());
    }
}
