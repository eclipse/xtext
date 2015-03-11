/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Moritz Eysholdt - introduced adapter
 */
@SuppressWarnings("all")
public class GeneratorConfigProvider implements IGeneratorConfigProvider {
  @FinalFieldsConstructor
  @Accessors
  protected static class ConfigAdapter extends AdapterImpl {
    private final GeneratorConfig config;
    
    @Override
    public boolean isAdapterForType(final Object type) {
      return (type == GeneratorConfigProvider.ConfigAdapter.class);
    }
    
    public ConfigAdapter(final GeneratorConfig config) {
      super();
      this.config = config;
    }
    
    @Pure
    public GeneratorConfig getConfig() {
      return this.config;
    }
  }
  
  public static void install(final ResourceSet resourceSet, final GeneratorConfig config) {
    EList<Adapter> adapters = resourceSet.eAdapters();
    Iterator<Adapter> iterator = adapters.iterator();
    while (iterator.hasNext()) {
      Adapter _next = iterator.next();
      if ((_next instanceof GeneratorConfigProvider.ConfigAdapter)) {
        iterator.remove();
      }
    }
    GeneratorConfigProvider.ConfigAdapter _configAdapter = new GeneratorConfigProvider.ConfigAdapter(config);
    adapters.add(_configAdapter);
  }
  
  @Override
  public GeneratorConfig get(final EObject context) {
    GeneratorConfig _xblockexpression = null;
    {
      List<Adapter> _elvis = null;
      Resource _eResource = null;
      if (context!=null) {
        _eResource=context.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      EList<Adapter> _eAdapters = null;
      if (_resourceSet!=null) {
        _eAdapters=_resourceSet.eAdapters();
      }
      if (_eAdapters != null) {
        _elvis = _eAdapters;
      } else {
        List<Adapter> _emptyList = CollectionLiterals.<Adapter>emptyList();
        _elvis = _emptyList;
      }
      final List<Adapter> adapters = _elvis;
      GeneratorConfig _elvis_1 = null;
      Iterable<GeneratorConfigProvider.ConfigAdapter> _filter = Iterables.<GeneratorConfigProvider.ConfigAdapter>filter(adapters, GeneratorConfigProvider.ConfigAdapter.class);
      GeneratorConfigProvider.ConfigAdapter _head = IterableExtensions.<GeneratorConfigProvider.ConfigAdapter>head(_filter);
      GeneratorConfig _config = null;
      if (_head!=null) {
        _config=_head.config;
      }
      if (_config != null) {
        _elvis_1 = _config;
      } else {
        GeneratorConfig _generatorConfig = new GeneratorConfig();
        _elvis_1 = _generatorConfig;
      }
      _xblockexpression = _elvis_1;
    }
    return _xblockexpression;
  }
}
