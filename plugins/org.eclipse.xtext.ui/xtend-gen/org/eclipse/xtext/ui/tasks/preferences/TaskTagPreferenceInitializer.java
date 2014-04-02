/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tasks.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TaskTagPreferenceInitializer implements IPreferenceStoreInitializer {
  public void initialize(final IPreferenceStoreAccess access) {
    final IPreferenceStore store = access.getWritablePreferenceStore();
    final Procedure1<PreferenceKey> _function = new Procedure1<PreferenceKey>() {
      public void apply(final PreferenceKey it) {
        String _id = it.getId();
        String _defaultValue = it.getDefaultValue();
        store.setDefault(_id, _defaultValue);
      }
    };
    IterableExtensions.<PreferenceKey>forEach(PreferenceTaskTagProvider.KEYS, _function);
  }
}
