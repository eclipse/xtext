/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class PlainTextFile extends TextFile {
  @Accessors
  private final CharSequence content;
  
  @Override
  public String getContent() {
    return this.content.toString();
  }
  
  public PlainTextFile(final Outlet outlet, final String relativePath, final ProjectDescriptor project, final CharSequence content) {
    super(outlet, relativePath, project);
    this.content = content;
  }
}
