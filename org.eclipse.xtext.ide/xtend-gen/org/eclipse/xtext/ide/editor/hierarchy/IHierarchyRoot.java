/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
  Collection<IHierarchyNode> getRoots();
  
  static final IHierarchyRoot EMPTY = new IHierarchyRoot() {
    @Override
    public Collection<IHierarchyNode> getRoots() {
      return CollectionLiterals.<IHierarchyNode>emptyList();
    }
  };
}
