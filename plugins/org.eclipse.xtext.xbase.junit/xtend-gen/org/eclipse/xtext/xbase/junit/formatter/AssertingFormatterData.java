package org.eclipse.xtext.xbase.junit.formatter;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AssertingFormatterData {
  @Property
  private MapBasedPreferenceValues _config;
  
  public FormattingPreferenceValues getCfg() {
    MapBasedPreferenceValues _config = this.getConfig();
    return new FormattingPreferenceValues(_config);
  }
  
  @Property
  private CharSequence _expectation;
  
  @Property
  private CharSequence _toBeFormatted;
  
  @Property
  private String _prefix;
  
  @Property
  private String _postfix;
  
  @Property
  private boolean _allowErrors;
  
  @Pure
  public MapBasedPreferenceValues getConfig() {
    return this._config;
  }
  
  public void setConfig(final MapBasedPreferenceValues config) {
    this._config = config;
  }
  
  @Pure
  public CharSequence getExpectation() {
    return this._expectation;
  }
  
  public void setExpectation(final CharSequence expectation) {
    this._expectation = expectation;
  }
  
  @Pure
  public CharSequence getToBeFormatted() {
    return this._toBeFormatted;
  }
  
  public void setToBeFormatted(final CharSequence toBeFormatted) {
    this._toBeFormatted = toBeFormatted;
  }
  
  @Pure
  public String getPrefix() {
    return this._prefix;
  }
  
  public void setPrefix(final String prefix) {
    this._prefix = prefix;
  }
  
  @Pure
  public String getPostfix() {
    return this._postfix;
  }
  
  public void setPostfix(final String postfix) {
    this._postfix = postfix;
  }
  
  @Pure
  public boolean isAllowErrors() {
    return this._allowErrors;
  }
  
  public void setAllowErrors(final boolean allowErrors) {
    this._allowErrors = allowErrors;
  }
}
