/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Abstraction of a commonly used set of attributes related to the current content assist request.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class ContentAssistContext {

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
	
	public static class Builder implements IFollowElementAcceptor {
		
		@Inject
		private ContentAssistContext context;
		
		private boolean contextQueried = false;

		protected void assertCanModify() {
			if (contextQueried)
				throw new IllegalStateException("Cannot modify externally visible context. Use this.toContext().copy() instead.");
		}
		
		protected ContentAssistContext get() {
			return context;
		}
		
		public ContentAssistContext toContext() {
			contextQueried = true;
			return context;
		}
		
		public Builder setPrefix(String prefix) {
			assertCanModify();
			context.prefix = prefix;
			return this;
		}
		
		public Builder setRootModel(EObject rootModel) {
			assertCanModify();
			context.rootModel = rootModel;
			return this;
		}

		public Builder setRootNode(CompositeNode rootNode) {
			assertCanModify();
			context.rootNode = rootNode;
			return this;
		}
		
		public Builder setCurrentNode(AbstractNode currentNode) {
			assertCanModify();
			context.currentNode = currentNode;
			context.replaceContextLength = null;
			return this;
		}

		public Builder setOffset(int offset) {
			assertCanModify();
			context.offset = offset;
			return this;
		}

		public Builder setViewer(ITextViewer viewer) {
			assertCanModify();
			context.viewer = viewer;
			return this;
		}
		
		public void accept(AbstractElement element) {
			if (element == null)
				throw new NullPointerException("element may not be null");
			assertCanModify();
			context.firstSetGrammarElements = null;
			context.mutableFirstSetGrammarElements.add(element);
		}

		public Builder setLastCompleteNode(AbstractNode lastCompleteNode) {
			assertCanModify();
			context.lastCompleteNode = lastCompleteNode;
			return this;
		}

		public Builder setCurrentModel(EObject currentModel) {
			assertCanModify();
			context.currentModel = currentModel;
			return this;
		}
		
		public Builder setPreviousModel(EObject previousModel) {
			assertCanModify();
			context.previousModel = previousModel;
			return this;
		}

		public Builder setReplaceRegion(Region replaceRegion) {
			assertCanModify();
			context.replaceRegion = replaceRegion;
			context.replaceContextLength = null;
			return this;
		}
		
		public Builder setSelectedText(String selectedText) {
			assertCanModify();
			context.selectedText = selectedText;
			return this;
		}
		
		public Builder setMatcher(PrefixMatcher matcher) {
			assertCanModify();
			context.matcher = matcher;
			return this;
		}
		
		public Builder setResource(XtextResource resource) {
			assertCanModify();
			context.resource = resource;
			return this;
		}

		protected void copyFrom(ContentAssistContext original) {
			context.prefix = original.prefix;
			context.selectedText = original.selectedText;
			context.rootModel = original.rootModel;
			context.rootNode = original.rootNode;
			context.currentModel = original.currentModel;
			context.previousModel = original.previousModel;
			context.currentNode = original.currentNode;
			context.lastCompleteNode = original.lastCompleteNode;
			context.offset = original.offset;
			context.resource = original.resource;
			context.viewer = original.viewer;
			context.replaceRegion = original.replaceRegion;
			context.replaceContextLength = original.replaceContextLength;
			context.matcher = original.matcher;
			context.mutableFirstSetGrammarElements.addAll(original.mutableFirstSetGrammarElements);	
		}
	}
	
	private String prefix;
	private String selectedText;
	private EObject rootModel;
	private CompositeNode rootNode;
	private EObject currentModel;
	private EObject previousModel;
	private AbstractNode currentNode;
	private AbstractNode lastCompleteNode;
	private int offset;
	private XtextResource resource;
	private ITextViewer viewer;
	private Region replaceRegion;
	private Integer replaceContextLength;
	private PrefixMatcher matcher;
	private ImmutableList<AbstractElement> firstSetGrammarElements;
	private List<AbstractElement> mutableFirstSetGrammarElements;
	
	@Inject
	private Provider<Builder> builderProvider;
	
	protected ContentAssistContext() {
		super();
		mutableFirstSetGrammarElements = Lists.newArrayList();
	}
	
	public ContentAssistContext.Builder copy() {
		Builder result = builderProvider.get();
		result.copyFrom(this);
		return result;
	}

	public String getPrefix() {
		return prefix;
	}

	public EObject getRootModel() {
		return rootModel;
	}

	public CompositeNode getRootNode() {
		return rootNode;
	}
	
	public AbstractNode getCurrentNode() {
		return currentNode;
	}

	public int getOffset() {
		return offset;
	}
	
	public ITextViewer getViewer() {
		return viewer;
	}
	
	public IXtextDocument getDocument() {
		return (IXtextDocument) viewer.getDocument();
	}
	
	public AbstractNode getLastCompleteNode() {
		return lastCompleteNode;
	}
	
	public EObject getCurrentModel() {
		return currentModel;
	}
	
	public EObject getPreviousModel() {
		return previousModel;
	}

	public Region getReplaceRegion() {
		return replaceRegion;
	}

	public String getSelectedText() {
		return selectedText;
	}

	public ImmutableList<AbstractElement> getFirstSetGrammarElements() {
		if (firstSetGrammarElements == null) {
			firstSetGrammarElements = ImmutableList.copyOf(mutableFirstSetGrammarElements);
		}
		return firstSetGrammarElements;
	}

	public PrefixMatcher getMatcher() {
		return matcher;
	}

	public int getReplaceContextLength() {
		if (replaceContextLength == null) {
			int replacementOffset = getReplaceRegion().getOffset();
			int replaceContextLength = getCurrentNode().getLength() - (replacementOffset - getCurrentNode().getOffset());
			this.replaceContextLength = replaceContextLength;
			return replaceContextLength;
		}
		return replaceContextLength.intValue();
	}

	public XtextResource getResource() {
		return resource;
	}
	
}
