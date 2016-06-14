/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * Represents a hierarchy node.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public interface IHierarchyNode extends INavigatable {
  /**
   * @returns an associated element that is used to build child nodes
   */
  public abstract IEObjectDescription getElement();
  
  /**
   * @returns a parent; <code>null</code> if the node is a root
   */
  public abstract IHierarchyNode getParent();
  
  /**
   * @returns references used to reach the node from a parent; empty if the node is a root
   */
  public abstract Collection<IHierarchyNodeReference> getReferences();
  
  /**
   * @returns whether there is a parent (can be transitive) containing the same element as the node
   */
  public abstract boolean isRecursive();
  
  /**
   * @returns whether the node may have children; e.g. a recursive node cannot have children
   */
  public abstract boolean mayHaveChildren();
}
