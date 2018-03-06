/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.template.ContainerProjectVariable;
import org.eclipse.xtext.ui.wizard.template.IParameterPage;
import org.eclipse.xtext.ui.wizard.template.ProjectVariable;

@SuppressWarnings("all")
public class BooleanProjectVariable extends ProjectVariable {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean value;
  
  private Button checkbox;
  
  public BooleanProjectVariable(final String label, final boolean defaultValue, final String description, final ContainerProjectVariable container) {
    super(label, description, container);
    this.value = defaultValue;
  }
  
  public boolean getValue() {
    return this.value;
  }
  
  @Override
  public void createWidget(final IParameterPage parameterPage, final Composite parent) {
    Button _button = new Button(parent, SWT.CHECK);
    this.checkbox = _button;
    this.checkbox.setText(this.getLabel());
    this.checkbox.setSelection(this.getValue());
    this.checkbox.setToolTipText(this.getDescription());
    this.checkbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        BooleanProjectVariable.this.setValue(BooleanProjectVariable.this.checkbox.getSelection());
        parameterPage.update();
      }
    });
  }
  
  @Override
  public void refresh() {
    boolean _isEnabled = this.checkbox.isEnabled();
    boolean _isEnabled_1 = this.isEnabled();
    boolean _notEquals = (_isEnabled != _isEnabled_1);
    if (_notEquals) {
      this.checkbox.setEnabled(this.isEnabled());
    }
    boolean _selection = this.checkbox.getSelection();
    boolean _value = this.getValue();
    boolean _notEquals_1 = (_selection != _value);
    if (_notEquals_1) {
      this.checkbox.setSelection(this.getValue());
    }
  }
  
  @Override
  public boolean isLabeled() {
    return false;
  }
  
  @Override
  public Control getWidget() {
    return this.checkbox;
  }
  
  @Override
  public String toString() {
    return Boolean.valueOf(this.value).toString();
  }
  
  public void setValue(final boolean value) {
    this.value = value;
  }
}
