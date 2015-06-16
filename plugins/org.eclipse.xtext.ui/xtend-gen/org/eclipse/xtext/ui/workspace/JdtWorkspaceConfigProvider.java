/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.ui.workspace.JdtProjectConfig;

@SuppressWarnings("all")
public class JdtWorkspaceConfigProvider extends EclipseWorkspaceConfigProvider {
  @Override
  public EclipseProjectConfig getProjectConfig(final IProject project) {
    return new JdtProjectConfig(project);
  }
}
