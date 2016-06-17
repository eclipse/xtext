/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.EmfStructureComparator;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractPartialParserTest extends AbstractXtextTests {

	protected EmfStructureComparator comparator;
	
	private PartialParsingHelper partialParser;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		comparator = new EmfStructureComparator();
	}

	@Override
	public void tearDown() throws Exception {
		comparator = null;
		super.tearDown();
	}
	
	protected String getReparseRegion(PartialParsingPointers parsingPointers) {
		ICompositeNode replaceRootNode = parsingPointers.getDefaultReplaceRootNode();
		return replaceRootNode.getText();
	}
	
	protected IParseResult reparse(IParseResult parseResult, int offset, int length, String text) {
		return getPartialParser().reparse(getParser(), parseResult, new ReplaceRegion(offset, length, text));
	}
	
	protected void assertSameStructure(ICompositeNode first, ICompositeNode second) {
		BidiTreeIterator<INode> firstIter = first.getAsTreeIterable().iterator();
		BidiTreeIterator<INode> secondIter = second.getAsTreeIterable().iterator();
		while(firstIter.hasNext()) {
			assertTrue(secondIter.hasNext());
			INode firstNext = firstIter.next();
			INode secondNext = secondIter.next();
			assertEquals(firstNext.getClass(), secondNext.getClass());
			assertEquals(firstNext.getTotalOffset(), secondNext.getTotalOffset());
			assertEquals(firstNext.getTotalLength(), secondNext.getTotalLength());
			assertEquals(firstNext.getText(), secondNext.getText());
			
		}
		assertEquals(firstIter.hasNext(), secondIter.hasNext());
	}

	protected PartialParsingHelper getPartialParser() {
		if(partialParser == null) 
			partialParser = get(PartialParsingHelper.class);
		return partialParser;
	}
}
