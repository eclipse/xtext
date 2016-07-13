/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DefaultProjectDescriptionFactory implements IProjectDescriptionFactory {
  @Override
  public ProjectDescription getProjectDescription(final IProjectConfig config) {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      String _name = config.getName();
      it.setName(_name);
    };
    return ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
  }
}
