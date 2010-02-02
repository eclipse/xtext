/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementCalculator.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * Abstraction of a commonly used set of attributes related to the current content assist request.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class ContentAssistContext implements IFollowElementAcceptor {

	private static final ContentAssistContext[] EMPTY_ARRAY = new ContentAssistContext[0];
	
	@ImplementedBy(ContentAssistContext.Factory.Null.class)
	public interface Factory {
		ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource);
		
		public static class Null implements Factory {

			public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
				return EMPTY_ARRAY;
			}
			
		}
	}
	
	private String prefix;
	private String selectedText;
	private EObject rootModel;
	private CompositeNode rootNode;
	private EObject currentModel;
	private AbstractNode currentNode;
	private AbstractNode lastCompleteNode;
	private int offset;
	private ITextViewer viewer;
	private Region replaceRegion;
	private PrefixMatcher matcher;
	private final List<AbstractElement> firstSetGrammarElements;
	
	@Inject
	public ContentAssistContext() {
		super();
		firstSetGrammarElements = new ArrayList<AbstractElement>();
	}
	
	public ContentAssistContext copy() {
		ContentAssistContext result = new ContentAssistContext();
		result.prefix = prefix;
		result.selectedText = selectedText;
		result.rootModel = rootModel;
		result.rootNode = rootNode;
		result.currentModel = currentModel;
		result.currentNode = currentNode;
		result.lastCompleteNode = lastCompleteNode;
		result.offset = offset;
		result.viewer = viewer;
		result.replaceRegion = replaceRegion;
		result.matcher = matcher;
		result.firstSetGrammarElements.addAll(firstSetGrammarElements);
		return result;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public EObject getRootModel() {
		return rootModel;
	}

	public void setRootModel(EObject rootModel) {
		this.rootModel = rootModel;
	}

	public CompositeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(CompositeNode rootNode) {
		this.rootNode = rootNode;
	}

	public AbstractNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(AbstractNode currentNode) {
		this.currentNode = currentNode;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setViewer(ITextViewer viewer) {
		this.viewer = viewer;
	}

	public ITextViewer getViewer() {
		return viewer;
	}
	
	public IXtextDocument getDocument() {
		return (IXtextDocument) viewer.getDocument();
	}
	
	public void accept(AbstractElement element) {
		if (element == null)
			throw new NullPointerException("element may not be null");
		getFirstSetGrammarElements().add(element);
	}

	public void setLastCompleteNode(AbstractNode lastCompleteNode) {
		this.lastCompleteNode = lastCompleteNode;
	}

	public AbstractNode getLastCompleteNode() {
		return lastCompleteNode;
	}

	public void setCurrentModel(EObject currentModel) {
		this.currentModel = currentModel;
	}

	public EObject getCurrentModel() {
		return currentModel;
	}

	public void setReplaceRegion(Region replaceRegion) {
		this.replaceRegion = replaceRegion;
	}

	public Region getReplaceRegion() {
		return replaceRegion;
	}

	public void setSelectedText(String selectedText) {
		this.selectedText = selectedText;
	}

	public String getSelectedText() {
		return selectedText;
	}

	public List<AbstractElement> getFirstSetGrammarElements() {
		return firstSetGrammarElements;
	}

	public void setMatcher(PrefixMatcher matcher) {
		this.matcher = matcher;
	}

	public PrefixMatcher getMatcher() {
		return matcher;
	}
	
}
