package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class NewLineKey extends BooleanKey implements Procedure1<IHiddenRegionFormatter> {
  public NewLineKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IHiddenRegionFormatter it) {
    IFormatterRequest _request = it.getRequest();
    ITypedPreferenceValues _preferences = _request.getPreferences();
    final Boolean newLine = _preferences.<Boolean>getPreference(this);
    if ((newLine).booleanValue()) {
      it.setNewLines(1);
    } else {
      it.oneSpace();
    }
  }
}
