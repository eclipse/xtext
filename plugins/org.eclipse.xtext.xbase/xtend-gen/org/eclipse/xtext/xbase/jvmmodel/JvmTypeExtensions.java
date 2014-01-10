package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.CompilationTemplateAdapter;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _and_3 = false;
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    if (!_isEmpty) {
      _and_3 = false;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _equals = Objects.equal(_associatedExpression, null);
      _and_3 = _equals;
    }
    if (!_and_3) {
      _and_2 = false;
    } else {
      Procedure1<? super ITreeAppendable> _compilationStrategy = this.getCompilationStrategy(it);
      boolean _equals_1 = Objects.equal(_compilationStrategy, null);
      _and_2 = _equals_1;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      StringConcatenationClient _compilationTemplate = this.getCompilationTemplate(it);
      boolean _equals_2 = Objects.equal(_compilationTemplate, null);
      _and_1 = _equals_2;
    }
    if (!_and_1) {
      _and = false;
    } else {
      JvmDeclaredType _declaringType = it.getDeclaringType();
      EList<JvmMember> _members = _declaringType.getMembers();
      Iterable<JvmConstructor> _filter = Iterables.<JvmConstructor>filter(_members, JvmConstructor.class);
      int _size = IterableExtensions.size(_filter);
      boolean _equals_3 = (_size == 1);
      _and = _equals_3;
    }
    return _and;
  }
  
  public boolean isSynthetic(final JvmIdentifiableElement element) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    return _metaData.isSynthetic();
  }
  
  public void setSynthetic(final JvmIdentifiableElement element, final boolean isSynthetic) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    _metaData.setSynthetic(isSynthetic);
  }
  
  protected JvmIdentifiableMetaData getMetaData(final JvmIdentifiableElement element) {
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
