/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.containers;

import com.google.common.base.Objects;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ResolveScopeBasedContainer extends AbstractScopeBasedSelectable implements IContainer {
  @Override
  public int getResourceDescriptionCount() {
    Iterable<VirtualFile> _allXtextVirtualFiles = this.getAllXtextVirtualFiles();
    return IterableExtensions.size(_allXtextVirtualFiles);
  }
  
  @Override
  public boolean hasResourceDescription(final URI uri) {
    BaseXtextFile _findFile = this.findFile(uri);
    return (!Objects.equal(_findFile, null));
  }
  
  @Override
  public void setScope(final GlobalSearchScope resolveScope) {
    super.setScope(resolveScope);
  }
}
