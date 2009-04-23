/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.IFollowElementCalculator;
import org.eclipse.xtext.ui.core.editor.contentassist.PrefixMatcher;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultContentAssistContextFactory implements ContentAssistContext.Factory {

	@Inject
	private IFollowElementCalculator followElementCalculator;
	
	@Inject
	private Provider<ContentAssistContext> contentAssistContextProvider;
	
	@Inject
	private PrefixMatcher matcher;
	
	public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
		List<ContentAssistContext> result = new ArrayList<ContentAssistContext>(2);
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			throw new NullPointerException("parseResult is null");
		
		// adjust offset to beginning of normalized selection
		ITextSelection selection= (ITextSelection) viewer.getSelectionProvider().getSelection();
		int fixedOffset = offset;
		if (selection.getOffset() + selection.getLength() == offset)
			fixedOffset= selection.getOffset();
		
		CompositeNode rootNode = parseResult.getRootNode();
		AbstractNode lastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, fixedOffset);
		EObject currentModel = NodeUtil.getNearestSemanticObject(lastCompleteNode);
		AbstractNode currentNode = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, fixedOffset);
		
		if (lastCompleteNode.getOffset()+lastCompleteNode.getLength() == fixedOffset) {
			AbstractNode precedingLastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, Math.max(0, lastCompleteNode.getOffset()));
			String prefix = getPrefix(lastCompleteNode, fixedOffset);
			result.add(createContext(viewer, fixedOffset, parseResult, rootNode, precedingLastCompleteNode, currentModel, lastCompleteNode, prefix));
			
			if (lastCompleteNode.getGrammarElement() instanceof Keyword ||
					lastCompleteNode.getGrammarElement() instanceof CrossReference ||
				(lastCompleteNode.getGrammarElement() instanceof RuleCall &&
				((RuleCall)lastCompleteNode.getGrammarElement()).getRule() instanceof TerminalRule)) {
				result.add(createContext(viewer, fixedOffset, parseResult, rootNode, lastCompleteNode, currentModel, currentNode, ""));
			}
		} else if (lastCompleteNode == currentNode) {
			AbstractNode precedingLastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, Math.max(0, lastCompleteNode.getOffset()));
			String prefix = getPrefix(currentNode, fixedOffset);
			result.add(createContext(viewer, fixedOffset, parseResult, rootNode, precedingLastCompleteNode, currentModel, currentNode, prefix));
		} else {
			String prefix = getPrefix(currentNode, fixedOffset);
			result.add(createContext(viewer, fixedOffset, parseResult, rootNode, lastCompleteNode, currentModel, currentNode, prefix));
		}
		
		return result.toArray(new ContentAssistContext[result.size()]);
	}

	public ContentAssistContext createContext(ITextViewer viewer, int offset, IParseResult parseResult, CompositeNode rootNode,
			AbstractNode lastCompleteNode, EObject currentModel, AbstractNode currentNode, String prefix) {
		ITextSelection selection= (ITextSelection) viewer.getSelectionProvider().getSelection();
		ContentAssistContext context = contentAssistContextProvider.get();
		
		context.setRootNode(rootNode);
		context.setLastCompleteNode(lastCompleteNode);
		context.setCurrentNode(currentNode);
		
		context.setRootModel(parseResult.getRootASTElement());
		context.setCurrentModel(currentModel);
		context.setOffset(offset);
		context.setViewer(viewer);
		context.setPrefix(prefix);
		int regionLength = prefix.length();
		if (selection.getLength() > 0)
			regionLength = regionLength + selection.getLength();
		Region region= new Region(offset - prefix.length(), regionLength);
		context.setReplaceRegion(region);
		context.setSelectedText(selection.getText());
		followElementCalculator.calculateValidElements(rootNode, lastCompleteNode, offset, context);
		context.setMatcher(matcher);
		return context;
	}
	
	public String getPrefix(AbstractNode currentNode, int offset) {
		if (currentNode instanceof LeafNode) {
			if (((LeafNode) currentNode).isHidden())
				return "";
			return getNodeText(currentNode, offset);
		}
		StringBuilder result = new StringBuilder(currentNode.getTotalLength());
		doComputePrefix((CompositeNode) currentNode, result, offset);
		return result.toString();
	}

	public String getNodeText(AbstractNode currentNode, int offset) {
		int startOffset = currentNode.getOffset();
		String text = ((LeafNode) currentNode).getText();
		String result = text.substring(0, offset - startOffset);
		return result;
	}
	
	public boolean doComputePrefix(CompositeNode node, StringBuilder result, int offset) {
		List<LeafNode> hiddens = new ArrayList<LeafNode>(2);
		for (AbstractNode child: node.getChildren()) {
			if (child instanceof CompositeNode) {
				if (!doComputePrefix((CompositeNode) child, result, offset))
					return false;
			} else {
				LeafNode leaf = (LeafNode) child;
				if (leaf.getOffset() > offset)
					return false;
				if (leaf.isHidden()) {
					if (result.length() != 0)
						hiddens.add((LeafNode)child);
				} else {
					Iterator<LeafNode> iter = hiddens.iterator();
					while(iter.hasNext()) {
						result.append(iter.next().getText());
					}
					hiddens.clear();
					result.append(getNodeText(leaf, offset));
					if (leaf.getOffset() + leaf.getLength() > offset)
						return false;
				}
			}
		}
		return true;
	}

}
