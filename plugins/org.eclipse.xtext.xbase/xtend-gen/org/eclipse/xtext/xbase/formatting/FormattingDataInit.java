package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@SuppressWarnings("all")
public class FormattingDataInit {
  public String space = null;
  
  public Integer newLines = null;
  
  public int increaseIndentationChange = 0;
  
  public int decreaseIndentationChange = 0;
  
  public PreferenceKey key = null;
  
  public void cfg(final PreferenceKey key) {
    this.key = key;
  }
  
  public void newLine() {
    this.newLines = Integer.valueOf(1);
  }
  
  public void noSpace() {
    this.space = "";
  }
  
  public void oneSpace() {
    this.space = " ";
  }
  
  public void increaseIndentation() {
    int _plus = (this.increaseIndentationChange + 1);
    this.increaseIndentationChange = _plus;
  }
  
  public void decreaseIndentation() {
    int _minus = (this.decreaseIndentationChange - 1);
    this.decreaseIndentationChange = _minus;
  }
  
  public String toString() {
    ToStringHelper _toStringHelper = new ToStringHelper();
    String _string = _toStringHelper.toString(this);
    return _string;
  }
}
