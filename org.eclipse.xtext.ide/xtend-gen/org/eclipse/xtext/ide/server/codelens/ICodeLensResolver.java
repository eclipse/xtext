/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.codelens;

import org.eclipse.lsp4j.CodeLens;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public interface ICodeLensResolver {
  /**
   * Resolve the given code lens.
   */
  public abstract CodeLens resolveCodeLens(final Document document, final XtextResource resource, final CodeLens codeLens, final CancelIndicator indicator);
}
