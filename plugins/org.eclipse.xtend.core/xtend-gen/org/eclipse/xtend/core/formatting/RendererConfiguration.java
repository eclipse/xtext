package org.eclipse.xtend.core.formatting;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RendererConfiguration {
  private String _lineSeparator;
  
  public String getLineSeparator() {
    return this._lineSeparator;
  }
  
  public void setLineSeparator(final String lineSeparator) {
    this._lineSeparator = lineSeparator;
  }
  
  private String _indentation;
  
  public void setIndentation(final String indentation) {
    this._indentation = indentation;
  }
  
  private int _indentationLength = 4;
  
  public int getIndentationLength() {
    return this._indentationLength;
  }
  
  public void setIndentationLength(final int indentationLength) {
    this._indentationLength = indentationLength;
  }
  
  private int _maxLineWidth = 80;
  
  public int getMaxLineWidth() {
    return this._maxLineWidth;
  }
  
  public void setMaxLineWidth(final int maxLineWidth) {
    this._maxLineWidth = maxLineWidth;
  }
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return RendererConfiguration.this._indentation;
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
  
  public int getIndentationLenght(final int levels) {
    int _indentationLength = this.getIndentationLength();
    int _multiply = (levels * _indentationLength);
    return _multiply;
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return RendererConfiguration.this._lineSeparator;
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
}
