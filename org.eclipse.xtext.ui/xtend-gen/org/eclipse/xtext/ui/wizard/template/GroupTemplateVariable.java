/**
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.ui.wizard.template.ContainerTemplateVariable;
import org.eclipse.xtext.ui.wizard.template.ParameterComposite;

@SuppressWarnings("all")
public class GroupTemplateVariable extends ContainerTemplateVariable {
  private Group group;
  
  public GroupTemplateVariable(final String label, final String description, final ContainerTemplateVariable container) {
    super(label, description, container);
  }
  
  public String[] getPossibleValues() {
    return this.getPossibleValues();
  }
  
  @Override
  public void createWidget(final ParameterComposite parameterComposite, final Composite parent) {
    Group _group = new Group(parent, SWT.READ_ONLY);
    this.group = _group;
    GridLayout _gridLayout = new GridLayout(2, false);
    this.group.setLayout(_gridLayout);
    this.group.setText(this.getLabel());
    this.group.setToolTipText(this.getDescription());
  }
  
  @Override
  public void refresh() {
  }
  
  @Override
  public Composite getWidget() {
    return this.group;
  }
  
  @Override
  public boolean isLabeled() {
    return false;
  }
  
  @Override
  public String toString() {
    return this.getLabel();
  }
}
