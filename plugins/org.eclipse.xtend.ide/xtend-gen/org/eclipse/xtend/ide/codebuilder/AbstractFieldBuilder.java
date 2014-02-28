/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

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
  
  private LightweightTypeReference _fieldType;
  
  public LightweightTypeReference getFieldType() {
    return this._fieldType;
  }
  
  public void setFieldType(final LightweightTypeReference fieldType) {
    this._fieldType = fieldType;
  }
  
  private boolean _staticFlag;
  
  public boolean isStaticFlag() {
    return this._staticFlag;
  }
  
  public void setStaticFlag(final boolean staticFlag) {
    this._staticFlag = staticFlag;
  }
  
  public String getImage() {
    String _switchResult = null;
    JvmVisibility _visibility = this.getVisibility();
    if (_visibility != null) {
      switch (_visibility) {
        case PRIVATE:
          _switchResult = "field_private_obj.gif";
          break;
        case PROTECTED:
          _switchResult = "field_protected_obj.gif";
          break;
        case PUBLIC:
          _switchResult = "field_public_obj.gif";
          break;
        default:
          _switchResult = "field_default_obj.gif";
          break;
      }
    } else {
      _switchResult = "field_default_obj.gif";
    }
    return _switchResult;
  }
}
