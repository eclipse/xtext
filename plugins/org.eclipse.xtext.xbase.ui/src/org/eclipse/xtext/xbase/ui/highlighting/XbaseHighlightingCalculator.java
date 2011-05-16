/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.highlighting;

import java.util.BitSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * <p>A base implementation of the semantic highlighting calculation.</p>
 * 
 * <p>Highlights references to {@link Primitives}, e.g. <code>void, int, boolean</code>
 * and the identifier <code>this</code>.</p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	private Map<String, String> highlightedIdentifiers;
	private BitSet idLengthsToHighlight;
	
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null
				|| resource.getParseResult().getRootASTElement() == null)
			return;
		if (highlightedIdentifiers == null) {
			highlightedIdentifiers = initializeHighlightedIdentifiers();
			idLengthsToHighlight = new BitSet();
			for(String s: highlightedIdentifiers.keySet()) {
				idLengthsToHighlight.set(s.length());
			}
		}
		doProvideHighlightingFor(resource, acceptor);
	}

	/**
	 * <p>Actual implementation of the semantic highlighting calculation. It is ensured, that the given
	 * resource is not <code>null</code> and refers to an initialized parse result.</p>
	 * <p>Clients should override this method in order to perform custom highlighting.</p>
	 * 
	 * @param resource a valid to-be-processed resource. Is never <code>null</code>.
	 * @param acceptor the acceptor. Is never <code>null</code>.
	 */
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = resource.getParseResult().getRootNode();
		highlightSpecialIdentifiers(acceptor, node);
	}

	protected void highlightSpecialIdentifiers(IHighlightedPositionAcceptor acceptor, ICompositeNode root) {
		TerminalRule idRule = grammarAccess.getIDRule();
		for(ILeafNode leaf: root.getLeafNodes()) {
			if (!leaf.isHidden()) {
				highlightSpecialIdentifiers(leaf, acceptor, idRule);
			}
		}
	}

	protected void highlightSpecialIdentifiers(ILeafNode leafNode, IHighlightedPositionAcceptor acceptor,
			TerminalRule idRule) {
		if (idLengthsToHighlight.get(leafNode.getLength())) {
			EObject element = leafNode.getGrammarElement();
			if (element == idRule || (element instanceof RuleCall && ((RuleCall) element).getRule() == idRule)) {
				String text = leafNode.getText();
				String highlightingID = highlightedIdentifiers.get(text);
				if (highlightingID != null) {
					acceptor.addPosition(leafNode.getOffset(), leafNode.getLength(), highlightingID);
				}
			}	
		}
	}

	/**
	 * Returns a mapping from identifier (e.g. 'void', 'int', 'this') to highlighting ID.
	 * May not return <code>null</code>.
	 * @return a mapping from identifier (e.g. 'void', 'int', 'this') to highlighting ID.
	 */
	protected Map<String, String> initializeHighlightedIdentifiers() {
		Map<String, String> result = Maps.newHashMap();
		for(Primitive p: Primitives.Primitive.values()) {
			result.put(p.name().toLowerCase(), DefaultHighlightingConfiguration.KEYWORD_ID);
		}
		result.put("this", DefaultHighlightingConfiguration.KEYWORD_ID);
		return result;
	}
	
	/**
	 * Highlights the non-hidden parts of {@code node} with the style that is associated
	 * with {@code id}.
	 */
	protected void highlightNode(INode node, String id, IHighlightedPositionAcceptor acceptor) {
		if (node == null)
			return;
		if (node instanceof ILeafNode) {
			acceptor.addPosition(node.getOffset(), node.getLength(), id);
		} else {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
				}
			}
		}
	}
}
