package org.eclipse.xtext.xbase.formatter;

import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.formatter.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class NewLineOrPreserveKey extends BooleanKey implements Procedure1<IGapFormatting> {
  public NewLineOrPreserveKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IGapFormatting it) {
    IFormatter.Request _request = it.getRequest();
    final ITypedPreferenceValues preferences = _request.getPreferences();
    final Boolean newLine = preferences.<Boolean>getPreference(this);
    final Boolean preserve = preferences.<Boolean>getPreference(XbaseFormatterPreferenceKeys.preserveNewLines);
    int _xifexpression = (int) 0;
    if ((newLine).booleanValue()) {
      _xifexpression = 1;
    } else {
      _xifexpression = 0;
    }
    final int min = _xifexpression;
    int _xifexpression_1 = (int) 0;
    boolean _or = false;
    if ((preserve).booleanValue()) {
      _or = true;
    } else {
      _or = (newLine).booleanValue();
    }
    if (_or) {
      _xifexpression_1 = 1;
    } else {
      _xifexpression_1 = 0;
    }
    final int max = _xifexpression_1;
    it.setNewLines(min, min, max);
  }
}
