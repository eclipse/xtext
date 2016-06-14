/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors
@SuppressWarnings("all")
public class DefaultHierarchyRoot implements IHierarchyRoot {
  private final List<IHierarchyNode> roots = CollectionLiterals.<IHierarchyNode>newArrayList();
  
  @Pure
  public List<IHierarchyNode> getRoots() {
    return this.roots;
  }
}
