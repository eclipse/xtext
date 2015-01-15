/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
  @Accessors
  private String fieldName;
  
  @Accessors
  private LightweightTypeReference fieldType;
  
  @Accessors
  private boolean staticFlag;
  
  @Override
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
  
  @Pure
  public String getFieldName() {
    return this.fieldName;
  }
  
  public void setFieldName(final String fieldName) {
    this.fieldName = fieldName;
  }
  
  @Pure
  public LightweightTypeReference getFieldType() {
    return this.fieldType;
  }
  
  public void setFieldType(final LightweightTypeReference fieldType) {
    this.fieldType = fieldType;
  }
  
  @Pure
  public boolean isStaticFlag() {
    return this.staticFlag;
  }
  
  public void setStaticFlag(final boolean staticFlag) {
    this.staticFlag = staticFlag;
  }
}
