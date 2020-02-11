/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.hover;

import com.google.inject.ImplementedBy;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.hover.HoverService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(HoverService.class)
@SuppressWarnings("all")
public interface IHoverService {
  static final Hover EMPTY_HOVER = new Hover(new MarkupContent("markdown", ""), null);
  
  /**
   * callback for 'textDocument/hover' requests.
   */
  Hover hover(final Document document, final XtextResource resource, final TextDocumentPositionParams params, final CancelIndicator cancelIndicator);
}
