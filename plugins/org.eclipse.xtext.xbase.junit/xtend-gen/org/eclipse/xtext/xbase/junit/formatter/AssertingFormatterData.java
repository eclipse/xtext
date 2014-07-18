package org.eclipse.xtext.xbase.junit.formatter;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class AssertingFormatterData {
  private MapBasedPreferenceValues config;
  
  public FormattingPreferenceValues getCfg() {
    return new FormattingPreferenceValues(this.config);
  }
  
  private CharSequence expectation;
  
  private CharSequence toBeFormatted;
  
  private String prefix;
  
  private String postfix;
  
  private boolean allowErrors;
  
  @Pure
  public MapBasedPreferenceValues getConfig() {
    return this.config;
  }
  
  public void setConfig(final MapBasedPreferenceValues config) {
    this.config = config;
  }
  
  @Pure
  public CharSequence getExpectation() {
    return this.expectation;
  }
  
  public void setExpectation(final CharSequence expectation) {
    this.expectation = expectation;
  }
  
  @Pure
  public CharSequence getToBeFormatted() {
    return this.toBeFormatted;
  }
  
  public void setToBeFormatted(final CharSequence toBeFormatted) {
    this.toBeFormatted = toBeFormatted;
  }
  
  @Pure
  public String getPrefix() {
    return this.prefix;
  }
  
  public void setPrefix(final String prefix) {
    this.prefix = prefix;
  }
  
  @Pure
  public String getPostfix() {
    return this.postfix;
  }
  
  public void setPostfix(final String postfix) {
    this.postfix = postfix;
  }
  
  @Pure
  public boolean isAllowErrors() {
    return this.allowErrors;
  }
  
  public void setAllowErrors(final boolean allowErrors) {
    this.allowErrors = allowErrors;
  }
}
