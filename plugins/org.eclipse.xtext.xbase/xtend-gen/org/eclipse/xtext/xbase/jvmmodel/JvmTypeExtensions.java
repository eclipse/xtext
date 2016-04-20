/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.CompilationTemplateAdapter;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @since 2.7
 */
@SuppressWarnings("all")
public class JvmTypeExtensions {
  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  public Procedure1<? super ITreeAppendable> getCompilationStrategy(final JvmIdentifiableElement it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<CompilationStrategyAdapter> _filter = Iterables.<CompilationStrategyAdapter>filter(_eAdapters, CompilationStrategyAdapter.class);
    final CompilationStrategyAdapter adapter = IterableExtensions.<CompilationStrategyAdapter>head(_filter);
    Procedure1<ITreeAppendable> _compilationStrategy = null;
    if (adapter!=null) {
      _compilationStrategy=adapter.getCompilationStrategy();
    }
    return _compilationStrategy;
  }
  
  public StringConcatenationClient getCompilationTemplate(final JvmIdentifiableElement it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<CompilationTemplateAdapter> _filter = Iterables.<CompilationTemplateAdapter>filter(_eAdapters, CompilationTemplateAdapter.class);
    final CompilationTemplateAdapter adapter = IterableExtensions.<CompilationTemplateAdapter>head(_filter);
    StringConcatenationClient _compilationTemplate = null;
    if (adapter!=null) {
      _compilationTemplate=adapter.getCompilationTemplate();
    }
    return _compilationTemplate;
  }
  
  public boolean isSingleSyntheticDefaultConstructor(final JvmConstructor it) {
    return ((((it.getParameters().isEmpty() && 
      Objects.equal(this._iLogicalContainerProvider.getAssociatedExpression(it), null)) && 
      Objects.equal(this.getCompilationStrategy(it), null)) && 
      Objects.equal(this.getCompilationTemplate(it), null)) && 
      (IterableExtensions.size(Iterables.<JvmConstructor>filter(it.getDeclaringType().getMembers(), JvmConstructor.class)) == 1));
  }
  
  public boolean isSynthetic(final JvmIdentifiableElement element) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    return _metaData.isSynthetic();
  }
  
  /**
   * @since 2.8
   */
  public boolean isSynthetic(final JvmAnnotationReference element) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    return _metaData.isSynthetic();
  }
  
  public void setSynthetic(final JvmIdentifiableElement element, final boolean isSynthetic) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    _metaData.setSynthetic(isSynthetic);
  }
  
  /**
   * @since 2.8
   */
  public void setSynthetic(final JvmAnnotationReference element, final boolean isSynthetic) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    _metaData.setSynthetic(isSynthetic);
  }
  
  /**
   * @since 2.8
   */
  protected JvmIdentifiableMetaData getMetaData(final EObject element) {
    EList<Adapter> _eAdapters = element.eAdapters();
    Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, JvmIdentifiableMetaData.class);
    JvmIdentifiableMetaData metaData = ((JvmIdentifiableMetaData) _adapter);
    boolean _equals = Objects.equal(metaData, null);
    if (_equals) {
      JvmIdentifiableMetaData _jvmIdentifiableMetaData = new JvmIdentifiableMetaData();
      metaData = _jvmIdentifiableMetaData;
      EList<Adapter> _eAdapters_1 = element.eAdapters();
      _eAdapters_1.add(metaData);
    }
    return metaData;
  }
}
