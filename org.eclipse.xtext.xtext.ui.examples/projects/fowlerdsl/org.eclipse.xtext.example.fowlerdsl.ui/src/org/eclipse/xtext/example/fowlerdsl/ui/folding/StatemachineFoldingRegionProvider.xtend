/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.folding

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion

/**
 * @author miklossy - Initial contribution and API
 */
class StatemachineFoldingRegionProvider extends DefaultFoldingRegionProvider {

	@Inject extension StatemachineGrammarAccess

	override protected computeObjectFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		if (eObject instanceof Statemachine) {
			val it = eObject.eResource as XtextResource
			computeEventsFolding(foldingRegionAcceptor)
			computeResetEventsFolding(foldingRegionAcceptor)
			computeCommandsFolding(foldingRegionAcceptor)
		} else {
			super.computeObjectFolding(eObject, foldingRegionAcceptor)
		}
	}

	override protected isHandled(EObject eObject) {
		super.isHandled(eObject) || eObject instanceof Statemachine
	}

	private def computeEventsFolding(XtextResource it, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(statemachineAccess.eventsKeyword_1_0, statemachineAccess.endKeyword_1_2, foldingRegionAcceptor)
	}

	private def computeResetEventsFolding(XtextResource it, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(statemachineAccess.resetEventsKeyword_2_0, statemachineAccess.endKeyword_2_2, foldingRegionAcceptor)
	}

	private def computeCommandsFolding(XtextResource it, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		computeFoldingRegionBetweenKeywords(statemachineAccess.commandsKeyword_3_0, statemachineAccess.endKeyword_3_2, foldingRegionAcceptor)
	}

	private def computeFoldingRegionBetweenKeywords(XtextResource it, Keyword startKeyword, Keyword endKeyword, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		val region = textRegionBetween(startKeyword, endKeyword)
		if (region !== null) {
			foldingRegionAcceptor.accept(region.offset, region.length)
		}
	}

	/**
	 * Determine the text region between the start keyword and the end keyword.
	 */
	private def ITextRegion textRegionBetween(XtextResource it, Keyword startKeyword, Keyword endKeyword) {
		var INode startNode
		for (INode node : parseResult.rootNode.asTreeIterable) {
			val grammarElement = node.grammarElement
			if (grammarElement == startKeyword) {
				startNode = node
			}
			if (grammarElement == endKeyword && startNode !==null) {
				return textRegionBetween(startNode, node)
			}
		}
	}

	/**
	 * Determine the text region between the start node and the end node.
	 */
	private def ITextRegion textRegionBetween(XtextResource it, INode startNode, INode endNode) {
		val offset = startNode.offset
		val length = endNode.endOffset - offset
		new TextRegion(offset, length)
	}
}