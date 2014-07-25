package org.eclipse.xtext.xbase.formatter;

import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class WhitespaceKey extends BooleanKey implements Procedure1<IGapFormatting> {
  public WhitespaceKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IGapFormatting it) {
    IFormatter.Request _request = it.getRequest();
    ITypedPreferenceValues _preferences = _request.getPreferences();
    final Boolean space = _preferences.<Boolean>getPreference(this);
    String _xifexpression = null;
    if ((space).booleanValue()) {
      _xifexpression = " ";
    } else {
      _xifexpression = "";
    }
    it.setSpace(_xifexpression);
  }
}
