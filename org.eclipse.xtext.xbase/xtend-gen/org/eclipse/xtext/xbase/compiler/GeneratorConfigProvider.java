/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
      final Procedure1<GeneratorConfigProvider.GeneratorConfigAdapter> _function = (GeneratorConfigProvider.GeneratorConfigAdapter it) -> {
        it.attachToEmfObject(resourceSet);
      };
      GeneratorConfigProvider.GeneratorConfigAdapter _doubleArrow = ObjectExtensions.<GeneratorConfigProvider.GeneratorConfigAdapter>operator_doubleArrow(_generatorConfigAdapter, _function);
      _elvis = _doubleArrow;
    }
    final GeneratorConfigProvider.GeneratorConfigAdapter adapter = _elvis;
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
      if (((adapter != null) && adapter.language2GeneratorConfig.containsKey(this.languageId))) {
        return adapter.language2GeneratorConfig.get(this.languageId);
      }
    }
    return new GeneratorConfig();
  }
}
