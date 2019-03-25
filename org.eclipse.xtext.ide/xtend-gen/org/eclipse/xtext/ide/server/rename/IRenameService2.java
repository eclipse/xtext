/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.rename;

import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * Service called for rename refactoring.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@SuppressWarnings("all")
public interface IRenameService2 {
  public abstract WorkspaceEdit rename(final ILanguageServerAccess access, final RenameParams renameParams, final CancelIndicator cancelIndicator);
}
