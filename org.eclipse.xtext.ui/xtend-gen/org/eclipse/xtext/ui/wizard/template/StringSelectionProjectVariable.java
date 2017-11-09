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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.template.IParameterPage;
import org.eclipse.xtext.ui.wizard.template.ProjectVariable;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StringSelectionProjectVariable extends ProjectVariable {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String[] possibleValues;
  
  @Accessors
  private String value;
  
  private Combo combo;
  
  public StringSelectionProjectVariable(final String label, final String[] possibleValues, final String description) {
    super(label, description);
    this.possibleValues = possibleValues;
    this.value = possibleValues[0];
  }
  
  public String[] getPossibleValues() {
    return this.possibleValues;
  }
  
  @Override
  public void createWidget(final IParameterPage parameterPage) {
    Composite _control = parameterPage.getControl();
    Combo _combo = new Combo(_control, SWT.READ_ONLY);
    this.combo = _combo;
    GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    this.combo.setLayoutData(_gridData);
    this.combo.setItems(this.getPossibleValues());
    this.combo.setText(this.getValue());
    this.combo.setToolTipText(this.getDescription());
    this.combo.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        StringSelectionProjectVariable.this.setValue(StringSelectionProjectVariable.this.combo.getText());
        parameterPage.update();
      }
    });
  }
  
  @Override
  public void refresh() {
    boolean _isEnabled = this.combo.isEnabled();
    boolean _isEnabled_1 = this.isEnabled();
    boolean _notEquals = (_isEnabled != _isEnabled_1);
    if (_notEquals) {
      this.combo.setEnabled(this.isEnabled());
    }
    boolean _equals = this.combo.getText().equals(this.getValue());
    boolean _not = (!_equals);
    if (_not) {
      this.combo.setText(this.getValue());
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
