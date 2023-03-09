/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.processors;

import java.io.StringReader;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testing.smoketest.DeltaScenarioProcessor;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.ReplaceRegion;
import org.junit.Assert;
import org.junit.ComparisonFailure;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParsingProcessor extends DeltaScenarioProcessor {

	private static final String DELIM = "\n----------------------\n";
	
	@Inject private IParser parser;
	
	@Override
	public String processFile(String completeData, String data, int offset, int len, String change) throws Exception {
		IParseResult initialParseResult = parser.parse(new StringReader(data));
		String newData = applyDelta(data, offset, len, change);
		ReplaceRegion replaceRegion = new ReplaceRegion(offset, len, change);
		try {
			IParseResult reparsed = parser.reparse(initialParseResult, replaceRegion);
		
			IParseResult parsedFromScratch = parser.parse(new StringReader(newData));
			assertEqual(data, newData, parsedFromScratch, reparsed);
			return newData;
		} catch(Throwable e) {
			ComparisonFailure throwMe = new ComparisonFailure(e.getMessage(), newData, replaceRegion + DELIM + data);
			throwMe.initCause(e);
			throw throwMe;
		}
	}

	private void assertEqual(String data, String newData, IParseResult parsedFromScratch, IParseResult reparsed) {
		EObject rootFromScratch = parsedFromScratch.getRootASTElement();
		EObject rootReparsed = reparsed.getRootASTElement();
		assertEqual(data, newData, EmfFormatter.objToStr(rootFromScratch), EmfFormatter.objToStr(rootReparsed));
		assertEqual(data, newData, parsedFromScratch.getRootNode(), reparsed.getRootNode());
	}
	
	private void assertEqual(String data, String newData, ICompositeNode fromScratch, ICompositeNode reparsed) {
		InvariantChecker checker = new InvariantChecker();
		checker.checkInvariant(reparsed);
		Iterator<INode> scratchIterator = fromScratch.getAsTreeIterable().iterator();
		Iterator<INode> reparsedIterator = reparsed.getAsTreeIterable().iterator();
		while(scratchIterator.hasNext()) {
			Assert.assertTrue(reparsedIterator.hasNext());
			assertEqualNodes(data, newData, scratchIterator.next(), reparsedIterator.next());
		}
		Assert.assertFalse(scratchIterator.hasNext());
		Assert.assertFalse(reparsedIterator.hasNext());
	}
	
	private void assertEqualNodes(String data, String newData, INode node, INode other) {
		Assert.assertEquals(node.getClass(), other.getClass());
		if (node instanceof ILeafNode) {
			Assert.assertEquals(node.getTotalOffset(), other.getTotalOffset());
			Assert.assertEquals(node.getTotalLength(), other.getTotalLength());
		}
		Assert.assertEquals(node.getGrammarElement(), other.getGrammarElement());
		Assert.assertEquals(node.hasDirectSemanticElement(), other.hasDirectSemanticElement());
		Assert.assertEquals(node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage());
		if (node instanceof ICompositeNode) {
			Assert.assertEquals(((ICompositeNode)node).getLookAhead(), ((ICompositeNode) other).getLookAhead());
		}
	}

	private void assertEqual(String data, String newData, String parsedFromScratch, String reparsed) {
		if (!parsedFromScratch.equals(reparsed)) {
			throw new ComparisonFailure("Parsed EObjects are not equal", newData + DELIM + parsedFromScratch, data + DELIM + reparsed);
		}
	}

}
