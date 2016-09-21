/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.contentassist;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  public final static int DEFAULT_PROPOSALS_LIMIT = 1000;
  
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  private IdeContentProposalProvider proposalProvider;
  
  public void createProposals(final String document, final int caretOffset, final XtextResource resource, final IIdeContentProposalAcceptor acceptor, final CancelIndicator cancelIndicator) {
    final TextRegion selection = new TextRegion(caretOffset, 0);
    this.createProposals(document, selection, caretOffset, resource, acceptor, cancelIndicator);
  }
  
  public void createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final IIdeContentProposalAcceptor acceptor, final CancelIndicator cancelIndicator) {
    this.createProposals(document, selection, caretOffset, resource, acceptor);
  }
  
  public void createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final IIdeContentProposalAcceptor acceptor) {
    int _length = document.length();
    boolean _greaterThan = (caretOffset > _length);
    if (_greaterThan) {
      return;
    }
    final ContentAssistContextFactory contextFactory = this.contextFactoryProvider.get();
    contextFactory.setPool(this.executorService);
    final ContentAssistContext[] contexts = contextFactory.create(document, selection, caretOffset, resource);
    this.proposalProvider.createProposals(((Collection<ContentAssistContext>)Conversions.doWrapArray(contexts)), acceptor);
  }
}
