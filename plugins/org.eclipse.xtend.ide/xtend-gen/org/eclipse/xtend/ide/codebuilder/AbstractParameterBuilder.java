package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public abstract class AbstractParameterBuilder extends AbstractCodeBuilder {
  @Accessors
  private String name;
  
  @Accessors
  private LightweightTypeReference type;
  
  @Accessors
  private boolean varArgsFlag;
  
  @Accessors
  private boolean extensionFlag;
  
  @Accessors
  private boolean finalFlag;
  
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      this.appendModifiers(appendable);
      if (this.varArgsFlag) {
        LightweightTypeReference _componentType = ((ArrayTypeReference) this.type).getComponentType();
        ISourceAppender _appendType = this.appendType(appendable, _componentType, "Object");
        _appendType.append("...");
      } else {
        this.appendType(appendable, this.type, "Object");
      }
      ISourceAppender _append = appendable.append(" ");
      _xblockexpression = _append.append(this.name);
    }
    return _xblockexpression;
  }
  
  protected abstract ISourceAppender appendModifiers(final ISourceAppender appendable);
  
  public boolean isValid() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(this.type, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      _and_1 = ((!this.varArgsFlag) || (this.type instanceof ArrayTypeReference));
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
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public LightweightTypeReference getType() {
    return this.type;
  }
  
  public void setType(final LightweightTypeReference type) {
    this.type = type;
  }
  
  @Pure
  public boolean isVarArgsFlag() {
    return this.varArgsFlag;
  }
  
  public void setVarArgsFlag(final boolean varArgsFlag) {
    this.varArgsFlag = varArgsFlag;
  }
  
  @Pure
  public boolean isExtensionFlag() {
    return this.extensionFlag;
  }
  
  public void setExtensionFlag(final boolean extensionFlag) {
    this.extensionFlag = extensionFlag;
  }
  
  @Pure
  public boolean isFinalFlag() {
    return this.finalFlag;
  }
  
  public void setFinalFlag(final boolean finalFlag) {
    this.finalFlag = finalFlag;
  }
}
