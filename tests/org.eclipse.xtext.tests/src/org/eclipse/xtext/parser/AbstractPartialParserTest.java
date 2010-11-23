/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.util.EmfStructureComparator;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractPartialParserTest extends AbstractXtextTests {

	protected EmfStructureComparator comparator;
	protected PartialParsingHelper partialParser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		partialParser = new PartialParsingHelper();
		comparator = new EmfStructureComparator() {
			@Override
			protected boolean isRelevantChild(EObject container, EObject child) {
				return !(child instanceof LeafNode) || !((LeafNode)child).isHidden();
			}
		};
	}

	@Override
	protected void tearDown() throws Exception {
		comparator = null;
		partialParser = null;
		super.tearDown();
	}
	
	protected String getReparseRegion(PartialParsingPointers parsingPointers) {
		ICompositeNode replaceRootNode = parsingPointers.getDefaultReplaceRootNode();
		return replaceRootNode.getText();
	}
	
	protected IParseResult reparse(IParseResult parseResult, int offset, int length, String text) {
		return partialParser.reparse(getParser(), parseResult, new ReplaceRegion(offset, length, text));
	}
}
