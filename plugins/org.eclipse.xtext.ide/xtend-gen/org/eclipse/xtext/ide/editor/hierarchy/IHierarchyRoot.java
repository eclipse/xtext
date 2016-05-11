/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Represents a hierarchy root.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public interface IHierarchyRoot {
  public abstract Collection<IHierarchyNode> getRoots();
  
  public final static IHierarchyRoot EMPTY = new IHierarchyRoot() {
    @Override
    public Collection<IHierarchyNode> getRoots() {
      return CollectionLiterals.<IHierarchyNode>emptyList();
    }
  };
}
