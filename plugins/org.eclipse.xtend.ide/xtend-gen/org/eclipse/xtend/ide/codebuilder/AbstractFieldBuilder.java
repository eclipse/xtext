/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
  private String _fieldName;
  
  public String getFieldName() {
    return this._fieldName;
  }
  
  public void setFieldName(final String fieldName) {
    this._fieldName = fieldName;
  }
  
  private JvmTypeReference _fieldType;
  
  public JvmTypeReference getFieldType() {
    return this._fieldType;
  }
  
  public void setFieldType(final JvmTypeReference fieldType) {
    this._fieldType = fieldType;
  }
}
