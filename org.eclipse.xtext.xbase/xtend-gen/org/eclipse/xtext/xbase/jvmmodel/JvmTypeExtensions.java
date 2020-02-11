/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.jvmmodel;

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
    final CompilationStrategyAdapter adapter = IterableExtensions.<CompilationStrategyAdapter>head(Iterables.<CompilationStrategyAdapter>filter(it.eAdapters(), CompilationStrategyAdapter.class));
    Procedure1<ITreeAppendable> _compilationStrategy = null;
    if (adapter!=null) {
      _compilationStrategy=adapter.getCompilationStrategy();
    }
    return _compilationStrategy;
  }
  
  public StringConcatenationClient getCompilationTemplate(final JvmIdentifiableElement it) {
    final CompilationTemplateAdapter adapter = IterableExtensions.<CompilationTemplateAdapter>head(Iterables.<CompilationTemplateAdapter>filter(it.eAdapters(), CompilationTemplateAdapter.class));
    StringConcatenationClient _compilationTemplate = null;
    if (adapter!=null) {
      _compilationTemplate=adapter.getCompilationTemplate();
    }
    return _compilationTemplate;
  }
  
  public boolean isSingleSyntheticDefaultConstructor(final JvmConstructor it) {
    return ((((it.getParameters().isEmpty() && 
      (this._iLogicalContainerProvider.getAssociatedExpression(it) == null)) && 
      (this.getCompilationStrategy(it) == null)) && 
      (this.getCompilationTemplate(it) == null)) && 
      (IterableExtensions.size(Iterables.<JvmConstructor>filter(it.getDeclaringType().getMembers(), JvmConstructor.class)) == 1));
  }
  
  public boolean isSynthetic(final JvmIdentifiableElement element) {
    return this.getMetaData(element).isSynthetic();
  }
  
  /**
   * @since 2.8
   */
  public boolean isSynthetic(final JvmAnnotationReference element) {
    return this.getMetaData(element).isSynthetic();
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
    Adapter _adapter = EcoreUtil.getAdapter(element.eAdapters(), JvmIdentifiableMetaData.class);
    JvmIdentifiableMetaData metaData = ((JvmIdentifiableMetaData) _adapter);
    if ((metaData == null)) {
      JvmIdentifiableMetaData _jvmIdentifiableMetaData = new JvmIdentifiableMetaData();
      metaData = _jvmIdentifiableMetaData;
      EList<Adapter> _eAdapters = element.eAdapters();
      _eAdapters.add(metaData);
    }
    return metaData;
  }
}
