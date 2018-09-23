/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.hover;

import com.google.inject.ImplementedBy;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkedString;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.hover.HoverService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(HoverService.class)
@SuppressWarnings("all")
public interface IHoverService {
  public static final Hover EMPTY_HOVER = new Hover(CollectionLiterals.<Either<String, MarkedString>>emptyList(), null);
  
  /**
   * callback for 'textDocument/hover' requests.
   */
  public abstract Hover hover(final Document document, final XtextResource resource, final TextDocumentPositionParams params, final CancelIndicator cancelIndicator);
}
