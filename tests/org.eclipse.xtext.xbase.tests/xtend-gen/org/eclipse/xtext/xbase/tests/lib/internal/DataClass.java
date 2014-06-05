package org.eclipse.xtext.xbase.tests.lib.internal;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class DataClass {
  public final Wrapper<DataClass> _other;
  
  public Wrapper<DataClass> getOther() {
    return this._other;
  }
  
  public final String _name;
  
  public String getName() {
    return this._name;
  }
  
  public DataClass(final Wrapper<DataClass> other, final String name) {
    super();
    this._other = other;
    this._name = name;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._other== null) ? 0 : this._other.hashCode());
    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
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
    DataClass other = (DataClass) obj;
    if (this._other == null) {
      if (other._other != null)
        return false;
    } else if (!this._other.equals(other._other))
      return false;
    if (this._name == null) {
      if (other._name != null)
        return false;
    } else if (!this._name.equals(other._name))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
