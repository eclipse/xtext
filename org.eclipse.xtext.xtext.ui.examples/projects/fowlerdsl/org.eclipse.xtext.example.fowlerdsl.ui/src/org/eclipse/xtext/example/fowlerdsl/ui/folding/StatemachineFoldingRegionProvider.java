/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.fowlerdsl.ui.folding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
public class StatemachineFoldingRegionProvider extends DefaultFoldingRegionProvider {
	@Inject
	private StatemachineGrammarAccess statemachineGrammarAccess;

	@Override
	protected void computeObjectFolding(EObject o, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		if (o instanceof Statemachine) {
			XtextResource res = (XtextResource) o.eResource();
			computeEventsFolding(res, foldingRegionAcceptor);
			computeResetEventsFolding(res, foldingRegionAcceptor);
			computeCommandsFolding(res, foldingRegionAcceptor);
		} else {
			super.computeObjectFolding(o, foldingRegionAcceptor);
		}
	}

	@Override
	protected boolean isHandled(EObject o) {
		return super.isHandled(o) || o instanceof Statemachine;
	}

	private void computeEventsFolding(XtextResource res, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(res,
				statemachineGrammarAccess.getStatemachineAccess().getEventsKeyword_1_0(),
				statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_1_2(), foldingRegionAcceptor);
	}

	private void computeResetEventsFolding(XtextResource res,
			IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(res,
				statemachineGrammarAccess.getStatemachineAccess().getResetEventsKeyword_2_0(),
				statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_2_2(), foldingRegionAcceptor);
	}

	private void computeCommandsFolding(XtextResource res,
			IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(res,
				statemachineGrammarAccess.getStatemachineAccess().getCommandsKeyword_3_0(),
				statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_3_2(), foldingRegionAcceptor);
	}

	private void computeFoldingRegionBetweenKeywords(XtextResource it, Keyword startKeyword, Keyword endKeyword,
			IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		ITextRegion region = textRegionBetween(it, startKeyword, endKeyword);
		if (region != null) {
			foldingRegionAcceptor.accept(region.getOffset(), region.getLength());
		}
	}

	/**
	 * Determine the text region between the start keyword and the end keyword.
	 */
	private ITextRegion textRegionBetween(XtextResource res, Keyword startKeyword, Keyword endKeyword) {
		INode startNode = null;
		for (INode node : res.getParseResult().getRootNode().getAsTreeIterable()) {
			EObject grammarElement = node.getGrammarElement();
			if (grammarElement == startKeyword) {
				startNode = node;
			}
			if (grammarElement == endKeyword && startNode != null) {
				return textRegionBetween(res, startNode, node);
			}
		}
		return null;
	}

	/**
	 * Determine the text region between the start node and the end node.
	 */
	private ITextRegion textRegionBetween(XtextResource res, INode startNode, INode endNode) {
		int offset = startNode.getOffset();
		int endOffset = endNode.getEndOffset();
		int length = endOffset - offset;
		return new TextRegion(offset, length);
	}
}
