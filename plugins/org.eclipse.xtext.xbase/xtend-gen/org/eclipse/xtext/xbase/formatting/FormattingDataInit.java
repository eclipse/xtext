package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
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
    this.increaseIndentationChange = (this.increaseIndentationChange + 1);
  }
  
  public void decreaseIndentation() {
    this.decreaseIndentationChange = (this.decreaseIndentationChange - 1);
  }
  
  @Override
  public String toString() {
    ToStringBuilder _toStringBuilder = new ToStringBuilder(this);
    ToStringBuilder _addAllFields = _toStringBuilder.addAllFields();
    return _addAllFields.toString();
  }
}
