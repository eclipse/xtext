package org.eclipse.xtend.core.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FormatterCfg {
  private final String _lineSeparator;
  
  public String getLineSeparator() {
    return this._lineSeparator;
  }
  
  private final String _indentation;
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return FormatterCfg.this._indentation;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return FormatterCfg.this._lineSeparator;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public FormatterCfg(final String lineSeparator, final String indentation) {
    super();
    this._lineSeparator = lineSeparator;
    this._indentation = indentation;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_lineSeparator== null) ? 0 : _lineSeparator.hashCode());
    result = prime * result + ((_indentation== null) ? 0 : _indentation.hashCode());
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
    FormatterCfg other = (FormatterCfg) obj;
    if (_lineSeparator == null) {
      if (other._lineSeparator != null)
        return false;
    } else if (!_lineSeparator.equals(other._lineSeparator))
      return false;
    if (_indentation == null) {
      if (other._indentation != null)
        return false;
    } else if (!_indentation.equals(other._indentation))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
