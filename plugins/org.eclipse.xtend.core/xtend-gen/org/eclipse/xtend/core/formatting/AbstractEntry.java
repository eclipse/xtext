package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@SuppressWarnings("all")
public abstract class AbstractEntry {
  private final String _key;
  
  public String getKey() {
    return this._key;
  }
  
  public AbstractEntry(final String key) {
    this._key = key;
  }
  
  protected String fullPrefix(final String prefix) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(prefix, null);
    if (_equals) {
      String _key = this.getKey();
      _xifexpression = _key;
    } else {
      String _plus = (prefix + ".");
      String _key_1 = this.getKey();
      String _plus_1 = (_plus + _key_1);
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
  
  public abstract void load(final String prefix, final Map<String,String> values);
  
  public abstract void store(final String prefix, final Map<String,String> values);
  
  public String toString() {
    ToStringHelper _toStringHelper = new ToStringHelper();
    String _string = _toStringHelper.toString(this);
    return _string;
  }
}
