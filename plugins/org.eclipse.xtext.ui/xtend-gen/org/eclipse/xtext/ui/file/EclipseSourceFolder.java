/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.file;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.workspace.ISourceFolder;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class EclipseSourceFolder implements ISourceFolder {
  private final IProject project;
  
  private final String name;
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    String _name = this.project.getName();
    String _plus = ("/" + _name);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + this.name);
    return URI.createPlatformResourceURI(_plus_2, true);
  }
  
  public EclipseSourceFolder(final IProject project, final String name) {
    super();
    this.project = project;
    this.name = name;
  }
}
