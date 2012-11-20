package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.configuration.IConfigurationKey;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@SuppressWarnings("all")
public class FormattingDataInit {
  public String space = null;
  
  public int newLines = 0;
  
  public int indentationChange = 0;
  
  public IConfigurationKey<? extends Object> key = null;
  
  public void cfg(final IConfigurationKey<? extends Object> key) {
    this.key = key;
  }
  
  public void newLine() {
    this.newLines = 1;
  }
  
  public void noSpace() {
    this.space = "";
  }
  
  public void oneSpace() {
    this.space = " ";
  }
  
  public void increaseIndentation() {
    int _plus = (this.indentationChange + 1);
    this.indentationChange = _plus;
  }
  
  public void decreaseIndentation() {
    int _minus = (this.indentationChange - 1);
    this.indentationChange = _minus;
  }
  
  public String toString() {
    ToStringHelper _toStringHelper = new ToStringHelper();
    String _string = _toStringHelper.toString(this);
    return _string;
  }
}
