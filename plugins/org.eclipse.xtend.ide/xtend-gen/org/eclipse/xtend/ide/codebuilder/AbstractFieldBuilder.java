package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtext.common.types.JvmTypeReference;

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
