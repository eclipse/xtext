/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Abstraction of a commonly used set of attributes related to the current content assist request.
 * @since 2.9
 */
public class ContentAssistContext {
	
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

		public Builder setRootNode(ICompositeNode rootNode) {
			assertCanModify();
			context.rootNode = rootNode;
			return this;
		}
		
		public Builder setCurrentNode(INode currentNode) {
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
		
		@Override
		public void accept(AbstractElement element) {
			if (element == null)
				throw new NullPointerException("element may not be null");
			assertCanModify();
			context.firstSetGrammarElements = null;
			context.mutableFirstSetGrammarElements.add(element);
		}

		public Builder setLastCompleteNode(INode lastCompleteNode) {
			assertCanModify();
			context.lastCompleteNode = lastCompleteNode;
			return this;
		}
		
		public Builder setReplaceRegion(ITextRegion replaceRegion) {
			assertCanModify();
			context.replaceRegion = replaceRegion;
			context.replaceContextLength = null;
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

		public Builder setSelectedText(String selectedText) {
			assertCanModify();
			context.selectedText = selectedText;
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
			context.replaceRegion = original.replaceRegion;
			context.resource = original.resource;
			context.replaceContextLength = original.replaceContextLength;
			context.mutableFirstSetGrammarElements.addAll(original.mutableFirstSetGrammarElements);	
		}
	}
	
	private String prefix;
	private String selectedText;
	private EObject rootModel;
	private ICompositeNode rootNode;
	private EObject currentModel;
	private EObject previousModel;
	private INode currentNode;
	private INode lastCompleteNode;
	private int offset;
	private ITextRegion replaceRegion;
	private XtextResource resource;
	private Integer replaceContextLength;
	private ImmutableList<AbstractElement> firstSetGrammarElements;
	private List<AbstractElement> mutableFirstSetGrammarElements;
	
	@Inject
	private Provider<Builder> builderProvider;
	
	/**
	 * Protected contructor to allow subclassing.
	 */
	protected ContentAssistContext() {
		super();
		mutableFirstSetGrammarElements = Lists.newArrayList();
	}

	/**
	 * Use this context as prototype for a new mutable builder. The new builder is
	 * pre-populated with the current settings of this context instance.
	 */
	public ContentAssistContext.Builder copy() {
		Builder result = builderProvider.get();
		result.copyFrom(this);
		return result;
	}

	/**
	 * The prefix string that is used to match the validity of proposals. By default, the 
	 * complete prefix will be overridden in the document when a proposal is applied.
	 * The prefix may be empty but is never <code>null</code>.  
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * The root model in the resource. May be <code>null</code>.
	 */
	public EObject getRootModel() {
		return rootModel;
	}

	/**
	 * The root node in the resource. May be <code>null</code>.
	 */
	public ICompositeNode getRootNode() {
		return rootNode;
	}
	
	/**
	 * The current node which is part of the current completion offset. The total offset of the 
	 * current node may be equal to the completion offset.  
	 */
	public INode getCurrentNode() {
		return currentNode;
	}

	/**
	 * The completion offset in the text viewer. If the text viewer has a non-empty text selection, the offset
	 * will be the beginning of the selection.
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * The last non-hidden node before the offset that is considered to be complete.
	 */
	public INode getLastCompleteNode() {
		return lastCompleteNode;
	}

	/**
	 * The model that covers the completion offset and has a grammar element assigned
	 * that has the expected grammar element at the given offset in its call hierarchy.
	 * Thereby it may be a parent of the actual model element at the given offset due to
	 * alternative decisions of the parser or actions.
	 * @see #getPreviousModel()
	 */
	public EObject getCurrentModel() {
		return currentModel;
	}
	
	/**
	 * The model element that is valid for the position left of the completion offset. 
	 * It is likely to be the same as the current model. However, as the call hierarchy of
	 * the grammar elements is ignored (in contrast to {@link #getCurrentModel()}, 
	 * it may provide addition information.
	 * @see #getCurrentModel()
	 */
	public EObject getPreviousModel() {
		return previousModel;
	}
	
	/**
	 * The region in the document that will be replaced by a new completion proposal.
	 */
	public ITextRegion getReplaceRegion() {
		return replaceRegion;
	}

	/**
	 * The currently selected text.
	 */
	public String getSelectedText() {
		return selectedText;
	}

	/**
	 * The grammar elements that may occur at the given offset.
	 */
	public ImmutableList<AbstractElement> getFirstSetGrammarElements() {
		if (firstSetGrammarElements == null) {
			firstSetGrammarElements = ImmutableList.copyOf(mutableFirstSetGrammarElements);
		}
		return firstSetGrammarElements;
	}

	/**
	 * The length of the region left to the completion offset that is part of the 
	 * replace region.
	 */
	public int getReplaceContextLength() {
		if (replaceContextLength == null) {
			int replacementOffset = getReplaceRegion().getOffset();
			ITextRegion currentRegion = getCurrentNode().getTextRegion();
			int replaceContextLength = currentRegion.getLength() - (replacementOffset - currentRegion.getOffset());
			this.replaceContextLength = replaceContextLength;
			return replaceContextLength;
		}
		return replaceContextLength.intValue();
	}

	/**
	 * The resource. Is never <code>null</code>.
	 */
	public XtextResource getResource() {
		return resource;
	}
	
}
