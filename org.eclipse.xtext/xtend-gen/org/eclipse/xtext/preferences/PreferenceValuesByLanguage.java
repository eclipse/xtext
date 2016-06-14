/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.preferences;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@EmfAdaptable
@SuppressWarnings("all")
public class PreferenceValuesByLanguage {
  public static class PreferenceValuesByLanguageAdapter extends AdapterImpl {
    private PreferenceValuesByLanguage element;
    
    public PreferenceValuesByLanguageAdapter(final PreferenceValuesByLanguage element) {
      this.element = element;
    }
    
    public PreferenceValuesByLanguage get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == PreferenceValuesByLanguage.class;
    }
  }
  
  private final Map<String, IPreferenceValues> preferencesByLanguage = CollectionLiterals.<String, IPreferenceValues>newHashMap();
  
  public IPreferenceValues get(final String languageId) {
    return this.preferencesByLanguage.get(languageId);
  }
  
  public IPreferenceValues put(final String languageId, final IPreferenceValues values) {
    return this.preferencesByLanguage.put(languageId, values);
  }
  
  public static PreferenceValuesByLanguage findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter) {
    		return ((PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static PreferenceValuesByLanguage removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    PreferenceValuesByLanguage result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for PreferenceValuesByLanguage");
    PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter adapter = new PreferenceValuesByLanguage.PreferenceValuesByLanguageAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
}
