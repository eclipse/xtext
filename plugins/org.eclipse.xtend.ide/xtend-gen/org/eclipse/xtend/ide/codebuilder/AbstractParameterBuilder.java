package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public abstract class AbstractParameterBuilder extends AbstractCodeBuilder {
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private LightweightTypeReference _type;
  
  public LightweightTypeReference getType() {
    return this._type;
  }
  
  public void setType(final LightweightTypeReference type) {
    this._type = type;
  }
  
  private boolean _varArgsFlag;
  
  public boolean isVarArgsFlag() {
    return this._varArgsFlag;
  }
  
  public void setVarArgsFlag(final boolean varArgsFlag) {
    this._varArgsFlag = varArgsFlag;
  }
  
  private boolean _extensionFlag;
  
  public boolean isExtensionFlag() {
    return this._extensionFlag;
  }
  
  public void setExtensionFlag(final boolean extensionFlag) {
    this._extensionFlag = extensionFlag;
  }
  
  private boolean _finalFlag;
  
  public boolean isFinalFlag() {
    return this._finalFlag;
  }
  
  public void setFinalFlag(final boolean finalFlag) {
    this._finalFlag = finalFlag;
  }
  
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      this.appendModifiers(appendable);
      boolean _isVarArgsFlag = this.isVarArgsFlag();
      if (_isVarArgsFlag) {
        LightweightTypeReference _type = this.getType();
        LightweightTypeReference _componentType = ((ArrayTypeReference) _type).getComponentType();
        ISourceAppender _appendType = this.appendType(appendable, _componentType, "Object");
        _appendType.append("...");
      } else {
        LightweightTypeReference _type_1 = this.getType();
        this.appendType(appendable, _type_1, "Object");
      }
      ISourceAppender _append = appendable.append(" ");
      String _name = this.getName();
      _xblockexpression = (_append.append(_name));
    }
    return _xblockexpression;
  }
  
  protected abstract ISourceAppender appendModifiers(final ISourceAppender appendable);
  
  public boolean isValid() {
    boolean _and = false;
    boolean _and_1 = false;
    LightweightTypeReference _type = this.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _or = false;
      boolean _isVarArgsFlag = this.isVarArgsFlag();
      boolean _not = (!_isVarArgsFlag);
      if (_not) {
        _or = true;
      } else {
        LightweightTypeReference _type_1 = this.getType();
        _or = (_type_1 instanceof ArrayTypeReference);
      }
      _and_1 = _or;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isValid = super.isValid();
      _and = _isValid;
    }
    return _and;
  }
  
  public String getImage() {
    return "parameter.gif";
  }
}
