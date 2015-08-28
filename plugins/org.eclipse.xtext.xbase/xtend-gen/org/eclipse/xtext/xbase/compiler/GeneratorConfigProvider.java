/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Moritz Eysholdt - introduced adapter
 */
@SuppressWarnings("all")
public class GeneratorConfigProvider implements IGeneratorConfigProvider {
  @EmfAdaptable
  public static class GeneratorConfigAdapter {
    public static class GeneratorConfigAdapterAdapter extends AdapterImpl {
      private GeneratorConfigProvider.GeneratorConfigAdapter element;
      
      public GeneratorConfigAdapterAdapter(final GeneratorConfigProvider.GeneratorConfigAdapter element) {
        this.element = element;
      }
      
      public GeneratorConfigProvider.GeneratorConfigAdapter get() {
        return this.element;
      }
      
      @Override
      public boolean isAdapterForType(final Object object) {
        return object == GeneratorConfigProvider.GeneratorConfigAdapter.class;
      }
    }
    
    @Accessors
    private final Map<String, GeneratorConfig> language2GeneratorConfig = CollectionLiterals.<String, GeneratorConfig>newHashMap();
    
    public static GeneratorConfigProvider.GeneratorConfigAdapter findInEmfObject(final Notifier emfObject) {
      for (Adapter adapter : emfObject.eAdapters()) {
      	if (adapter instanceof GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter) {
      		return ((GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public static GeneratorConfigProvider.GeneratorConfigAdapter removeFromEmfObject(final Notifier emfObject) {
      List<Adapter> adapters = emfObject.eAdapters();
      for(int i = 0, max = adapters.size(); i < max; i++) {
      	Adapter adapter = adapters.get(i);
      	if (adapter instanceof GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter) {
      		emfObject.eAdapters().remove(i);
      		return ((GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public void attachToEmfObject(final Notifier emfObject) {
      GeneratorConfigAdapter result = findInEmfObject(emfObject);
      if (result != null)
      	throw new IllegalStateException("The given EMF object already contains an adapter for GeneratorConfigAdapter");
      GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter adapter = new GeneratorConfigProvider.GeneratorConfigAdapter.GeneratorConfigAdapterAdapter(this);
      emfObject.eAdapters().add(adapter);
    }
    
    @Pure
    public Map<String, GeneratorConfig> getLanguage2GeneratorConfig() {
      return this.language2GeneratorConfig;
    }
  }
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  public GeneratorConfig install(final ResourceSet resourceSet, final GeneratorConfig config) {
    GeneratorConfigProvider.GeneratorConfigAdapter _elvis = null;
    GeneratorConfigProvider.GeneratorConfigAdapter _findInEmfObject = GeneratorConfigProvider.GeneratorConfigAdapter.findInEmfObject(resourceSet);
    if (_findInEmfObject != null) {
      _elvis = _findInEmfObject;
    } else {
      GeneratorConfigProvider.GeneratorConfigAdapter _generatorConfigAdapter = new GeneratorConfigProvider.GeneratorConfigAdapter();
      _elvis = _generatorConfigAdapter;
    }
    final Procedure1<GeneratorConfigProvider.GeneratorConfigAdapter> _function = new Procedure1<GeneratorConfigProvider.GeneratorConfigAdapter>() {
      @Override
      public void apply(final GeneratorConfigProvider.GeneratorConfigAdapter it) {
        it.attachToEmfObject(resourceSet);
      }
    };
    final GeneratorConfigProvider.GeneratorConfigAdapter adapter = ObjectExtensions.<GeneratorConfigProvider.GeneratorConfigAdapter>operator_doubleArrow(_elvis, _function);
    return adapter.language2GeneratorConfig.put(this.languageId, config);
  }
  
  @Override
  public GeneratorConfig get(final EObject context) {
    Resource _eResource = null;
    if (context!=null) {
      _eResource=context.eResource();
    }
    ResourceSet _resourceSet = null;
    if (_eResource!=null) {
      _resourceSet=_eResource.getResourceSet();
    }
    final ResourceSet resourceSet = _resourceSet;
    if ((resourceSet != null)) {
      final GeneratorConfigProvider.GeneratorConfigAdapter adapter = GeneratorConfigProvider.GeneratorConfigAdapter.findInEmfObject(resourceSet);
      boolean _and = false;
      if (!(adapter != null)) {
        _and = false;
      } else {
        boolean _containsKey = adapter.language2GeneratorConfig.containsKey(this.languageId);
        _and = _containsKey;
      }
      if (_and) {
        return adapter.language2GeneratorConfig.get(this.languageId);
      }
    }
    return new GeneratorConfig();
  }
}
