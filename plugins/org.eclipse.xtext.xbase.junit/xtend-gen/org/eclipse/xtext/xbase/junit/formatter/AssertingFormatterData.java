package org.eclipse.xtext.xbase.junit.formatter;

import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues;

@SuppressWarnings("all")
public class AssertingFormatterData {
  private MapBasedConfigurationValues _cfg;
  
  public MapBasedConfigurationValues getCfg() {
    return this._cfg;
  }
  
  public void setCfg(final MapBasedConfigurationValues cfg) {
    this._cfg = cfg;
  }
  
  private CharSequence _expectation;
  
  public CharSequence getExpectation() {
    return this._expectation;
  }
  
  public void setExpectation(final CharSequence expectation) {
    this._expectation = expectation;
  }
  
  private CharSequence _toBeFormatted;
  
  public CharSequence getToBeFormatted() {
    return this._toBeFormatted;
  }
  
  public void setToBeFormatted(final CharSequence toBeFormatted) {
    this._toBeFormatted = toBeFormatted;
  }
  
  private String _prefix;
  
  public String getPrefix() {
    return this._prefix;
  }
  
  public void setPrefix(final String prefix) {
    this._prefix = prefix;
  }
  
  private String _postfix;
  
  public String getPostfix() {
    return this._postfix;
  }
  
  public void setPostfix(final String postfix) {
    this._postfix = postfix;
  }
  
  private boolean _allowErrors;
  
  public boolean isAllowErrors() {
    return this._allowErrors;
  }
  
  public void setAllowErrors(final boolean allowErrors) {
    this._allowErrors = allowErrors;
  }
}
