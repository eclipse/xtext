package org.eclipse.xtext.xbase.formatter;

import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class NewLineKey extends BooleanKey implements Procedure1<IGapFormatting> {
  public NewLineKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IGapFormatting it) {
    IFormatter.Request _request = it.getRequest();
    ITypedPreferenceValues _preferences = _request.getPreferences();
    final Boolean newLine = _preferences.<Boolean>getPreference(this);
    if ((newLine).booleanValue()) {
      it.setNewLines(1);
    } else {
      it.oneSpace();
    }
  }
}
