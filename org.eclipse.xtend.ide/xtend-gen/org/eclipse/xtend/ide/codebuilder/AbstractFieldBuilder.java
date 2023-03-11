/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
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

  @Accessors
  private boolean finalFlag;

  @Inject
  private Primitives primitives;

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

  protected ISourceAppender appendDefaultValueLiteral(final ISourceAppender appendable, final LightweightTypeReference typeRef, final String surrogate) {
    ISourceAppender _xblockexpression = null;
    {
      if (((typeRef != null) && typeRef.isPrimitive())) {
        JvmType _type = typeRef.getType();
        appendable.append(
          this.getPrimitiveKindRepresentation(this.primitives.primitiveKind(((JvmPrimitiveType) _type))));
      } else {
        appendable.append(surrogate);
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }

  public abstract String getPrimitiveKindRepresentation(final Primitives.Primitive primitiveKind);

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

  @Pure
  public boolean isFinalFlag() {
    return this.finalFlag;
  }

  public void setFinalFlag(final boolean finalFlag) {
    this.finalFlag = finalFlag;
  }
}
