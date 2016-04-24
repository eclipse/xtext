/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;

/**
 * This class is used to build a hierarchy structure.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public interface IHierarchyBuilder {
  /**
   * @returns root hierarchy nodes for the given URI; empty if the hierarchy cannot be built for the given URI
   */
  public abstract Collection<IHierarchyNode> buildRoots(final URI rootURI, final IProgressMonitor monitor);
  
  /**
   * @returns child nodes for the given parent node; empty if {@link IHierarchyNode#mayHaveChildren} returns <code>false</code> for the parent
   */
  public abstract Collection<IHierarchyNode> buildChildren(final IHierarchyNode parent, final IProgressMonitor monitor);
}
