/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class IdeaFileSystemSupport extends AbstractFileSystemSupport {
  @Override
  public Iterable<? extends Path> getChildren(final URI uri, final Path path) {
    final IdeaResourceSetProvider.VirtualFileBasedUriHandler handler = IdeaResourceSetProvider.VirtualFileBasedUriHandler.find(this.getContext());
    if ((handler == null)) {
      return CollectionLiterals.<Path>emptyList();
    }
    final Function1<URI, Path> _function = (URI it) -> {
      return this.getPath(it, uri, path);
    };
    return IterableExtensions.<Path>filterNull(IterableExtensions.<URI, Path>map(handler.getChildren(uri), _function));
  }
}
