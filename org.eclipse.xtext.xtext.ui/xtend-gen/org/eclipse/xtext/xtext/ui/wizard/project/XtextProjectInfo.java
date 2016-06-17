/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

/**
 * Simple value object class containing all relevant attributes necessary for the creation of new Xtext projects.
 */
@Accessors
@SuppressWarnings("all")
public class XtextProjectInfo extends WizardConfiguration implements IProjectInfo {
  private Iterable<IWorkingSet> workingSets;
  
  private IWorkbench workbench;
  
  @Override
  public String getProjectName() {
    return this.getBaseName();
  }
  
  @Override
  public void setProjectName(final String projectName) {
    this.setBaseName(projectName);
  }
  
  @Pure
  public Iterable<IWorkingSet> getWorkingSets() {
    return this.workingSets;
  }
  
  public void setWorkingSets(final Iterable<IWorkingSet> workingSets) {
    this.workingSets = workingSets;
  }
  
  @Pure
  public IWorkbench getWorkbench() {
    return this.workbench;
  }
  
  public void setWorkbench(final IWorkbench workbench) {
    this.workbench = workbench;
  }
}
