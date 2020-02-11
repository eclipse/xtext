/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @since 2.8
 */
@Singleton
public class DelegatingContentAssistContextFactory extends AbstractContentAssistContextFactory {
	
	@Inject
	private Provider<StatefulFactory> statefulFactoryProvider;

	private ExecutorService pool;
	
	public DelegatingContentAssistContextFactory() {
		pool = Executors.newFixedThreadPool(3);
	}
	
	public Provider<? extends StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}
	
	protected ExecutorService getPool() {
		return pool;
	}
	
	@Override
	public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
		StatefulFactory factory = getStatefulFactoryProvider().get();
		factory.setPool(pool);
		return factory.create(viewer, offset, resource);
	}
	
	public static class StatefulFactory {
		
		@Inject
		protected Provider<ContentAssistContext.Builder> contentAssistContextProvider;
		
		@Inject
		private ContentAssistContextFactory delegate;
		
		@Inject
		protected PrefixMatcher matcher;
		
		protected ITextViewer viewer;

		protected ITextSelection selection;

		protected XtextResource resource;

		public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
			this.viewer = viewer;
			this.resource = resource;
			return doCreateContexts(offset);
		}
		
		public void setPool(ExecutorService pool) {
			getDelegate().setPool(pool);
		}
		
		public ContentAssistContextFactory getDelegate() {
			return delegate;
		}
		
		protected ContentAssistContext[] doCreateContexts(int offset) {
			ITextSelection selection = (ITextSelection) viewer.getSelectionProvider().getSelection();
			ITextRegion region = new SelectionBasedRegion(selection);
			org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext[] delegateContexts = getDelegate().create(viewer.getDocument().get(), region, offset, resource);
			ContentAssistContext[] contexts = new ContentAssistContext[delegateContexts.length];
			for (int i = 0; i < delegateContexts.length; i++) {
				contexts[i] = convert(delegateContexts[i]).toContext();
			}
			return contexts;
		}
		
		protected static class SelectionBasedRegion implements ITextRegion {
			
			private ITextSelection selection;

			public SelectionBasedRegion(ITextSelection selection) {
				this.selection = selection;
			}

			@Override
			public int getOffset() {
				return selection.getOffset();
			}

			@Override
			public int getLength() {
				return selection.getLength();
			}

			@Override
			public ITextRegion merge(ITextRegion region) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean contains(ITextRegion other) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean contains(int offset) {
				throw new UnsupportedOperationException();
			}
		}

		protected ContentAssistContext.Builder convert(org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext delegateContext) {
			ContentAssistContext.Builder context = contentAssistContextProvider.get();

			context.setRootNode(delegateContext.getRootNode());
			context.setLastCompleteNode(delegateContext.getLastCompleteNode());
			context.setCurrentNode(delegateContext.getCurrentNode());

			context.setRootModel(delegateContext.getRootModel());
			context.setCurrentModel(delegateContext.getCurrentModel());
			context.setPreviousModel(delegateContext.getPreviousModel());
			context.setOffset(delegateContext.getOffset());
			context.setViewer(viewer);
			context.setPrefix(delegateContext.getPrefix());
			Region region = new Region(delegateContext.getReplaceRegion().getOffset(), delegateContext.getReplaceRegion().getLength());
			context.setReplaceRegion(region);
			context.setSelectedText(delegateContext.getSelectedText());
			context.setMatcher(matcher);
			context.setResource(resource);
			for (AbstractElement grammarElement : delegateContext.getFirstSetGrammarElements()) {
				context.accept(grammarElement);
			}
			return context;
		}
	}
}
