package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class UnknownType implements Type {
  private final CompilationUnit _compilationUnit;
  
  public CompilationUnit getCompilationUnit() {
    return this._compilationUnit;
  }
  
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  public UnknownType(final CompilationUnit compilationUnit, final String name) {
    super();
    this._compilationUnit = compilationUnit;
    this._name = name;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_compilationUnit== null) ? 0 : _compilationUnit.hashCode());
    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UnknownType other = (UnknownType) obj;
    if (_compilationUnit == null) {
      if (other._compilationUnit != null)
        return false;
    } else if (!_compilationUnit.equals(other._compilationUnit))
      return false;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
