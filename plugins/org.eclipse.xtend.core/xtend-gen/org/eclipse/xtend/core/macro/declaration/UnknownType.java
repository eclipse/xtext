package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class UnknownType implements Type {
  private final CompilationUnit _compilationUnit;
  
  private final String _qualifiedName;
  
  public boolean isAssignableFrom(final Type otherType) {
    return false;
  }
  
  public String getSimpleName() {
    String _xblockexpression = null;
    {
      String _qualifiedName = this.getQualifiedName();
      final int idx = _qualifiedName.lastIndexOf(".");
      String _xifexpression = null;
      if ((idx > 0)) {
        String _qualifiedName_1 = this.getQualifiedName();
        _xifexpression = _qualifiedName_1.substring(idx);
      } else {
        _xifexpression = this.getQualifiedName();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public UnknownType(final CompilationUnit compilationUnit, final String qualifiedName) {
    super();
    this._compilationUnit = compilationUnit;
    this._qualifiedName = qualifiedName;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._compilationUnit== null) ? 0 : this._compilationUnit.hashCode());
    result = prime * result + ((this._qualifiedName== null) ? 0 : this._qualifiedName.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UnknownType other = (UnknownType) obj;
    if (this._compilationUnit == null) {
      if (other._compilationUnit != null)
        return false;
    } else if (!this._compilationUnit.equals(other._compilationUnit))
      return false;
    if (this._qualifiedName == null) {
      if (other._qualifiedName != null)
        return false;
    } else if (!this._qualifiedName.equals(other._qualifiedName))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public CompilationUnit getCompilationUnit() {
    return this._compilationUnit;
  }
  
  @Pure
  public String getQualifiedName() {
    return this._qualifiedName;
  }
}
