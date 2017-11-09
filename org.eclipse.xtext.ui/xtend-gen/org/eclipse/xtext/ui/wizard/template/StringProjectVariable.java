/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.template.IParameterPage;
import org.eclipse.xtext.ui.wizard.template.ProjectVariable;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StringProjectVariable extends ProjectVariable {
  @Accessors
  private String value;
  
  private Text text;
  
  public StringProjectVariable(final String label, final String defaultValue, final String description) {
    super(label, description);
    this.value = defaultValue;
  }
  
  @Override
  public void createWidget(final IParameterPage parameterPage) {
    Composite _control = parameterPage.getControl();
    Text _text = new Text(_control, (SWT.SINGLE | SWT.BORDER));
    this.text = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    this.text.setLayoutData(_gridData);
    this.text.setText(this.getValue());
    this.text.setToolTipText(this.getDescription());
    final ModifyListener _function = (ModifyEvent it) -> {
      this.setValue(this.text.getText());
      parameterPage.update();
    };
    this.text.addModifyListener(_function);
  }
  
  @Override
  public void refresh() {
    boolean _isEnabled = this.text.isEnabled();
    boolean _isEnabled_1 = this.isEnabled();
    boolean _notEquals = (_isEnabled != _isEnabled_1);
    if (_notEquals) {
      this.text.setEnabled(this.isEnabled());
    }
    boolean _equals = this.text.getText().equals(this.getValue());
    boolean _not = (!_equals);
    if (_not) {
      this.text.setText(this.getValue());
    }
  }
  
  @Override
  public String toString() {
    return this.value;
  }
  
  @Pure
  public String getValue() {
    return this.value;
  }
  
  public void setValue(final String value) {
    this.value = value;
  }
}
