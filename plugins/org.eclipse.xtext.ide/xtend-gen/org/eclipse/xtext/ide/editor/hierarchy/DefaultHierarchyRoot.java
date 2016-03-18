/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyRoot;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors
@SuppressWarnings("all")
public class DefaultHierarchyRoot implements HierarchyRoot {
  private final ArrayList<HierarchyNode> roots = CollectionLiterals.<HierarchyNode>newArrayList();
  
  @Pure
  public Collection<HierarchyNode> getRoots() {
    return this.roots;
  }
}
