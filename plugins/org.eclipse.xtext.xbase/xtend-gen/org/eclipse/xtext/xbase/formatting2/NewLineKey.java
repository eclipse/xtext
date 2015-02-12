/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class NewLineKey extends BooleanKey implements Procedure1<IHiddenRegionFormatter> {
  public NewLineKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  @Override
  public void apply(final IHiddenRegionFormatter it) {
    FormatterRequest _request = it.getRequest();
    ITypedPreferenceValues _preferences = _request.getPreferences();
    final Boolean newLine = _preferences.<Boolean>getPreference(this);
    if ((newLine).booleanValue()) {
      it.setNewLines(1);
    } else {
      it.oneSpace();
    }
  }
}
