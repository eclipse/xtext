/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class NullWorkspaceConfig implements IWorkspaceConfig {
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    return CollectionLiterals.<IProjectConfig>emptySet();
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    return null;
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    return null;
  }
}
