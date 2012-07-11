package org.eclipse.xtend.core.formatting;

import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@SuppressWarnings("all")
public class FormattingDataInit {
  public Object leftAnchor;
  
  public Object rightAnchor;
  
  public String space = null;
  
  public boolean canWrap = true;
  
  public int newLines = 0;
  
  public int indentationChange = 0;
  
  public int newLine() {
    int _newLines = this.newLines = 1;
    return _newLines;
  }
  
  public String noSpace() {
    String _space = this.space = "";
    return _space;
  }
  
  public int increaseIndentation() {
    int _plus = (this.indentationChange + 1);
    int _indentationChange = this.indentationChange = _plus;
    return _indentationChange;
  }
  
  public int decreaseIndentation() {
    int _minus = (this.indentationChange - 1);
    int _indentationChange = this.indentationChange = _minus;
    return _indentationChange;
  }
  
  public String toString() {
    ToStringHelper _toStringHelper = new ToStringHelper();
    String _string = _toStringHelper.toString(this);
    return _string;
  }
}
