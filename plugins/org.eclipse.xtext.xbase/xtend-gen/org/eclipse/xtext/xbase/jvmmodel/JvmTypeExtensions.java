package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmTypeExtensions {
  @Inject
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  public Procedure1<? super ITreeAppendable> getCompilationStrategy(final JvmIdentifiableElement it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<CompilationStrategyAdapter> _filter = Iterables.<CompilationStrategyAdapter>filter(_eAdapters, CompilationStrategyAdapter.class);
    final CompilationStrategyAdapter adapter = IterableExtensions.<CompilationStrategyAdapter>head(_filter);
    return adapter==null?(Procedure1<ITreeAppendable>)null:adapter.getCompilationStrategy();
  }
  
  public boolean isSingleSyntheticDefaultConstructor(final JvmConstructor it) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    if (!_isEmpty) {
      _and_2 = false;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _equals = ObjectExtensions.operator_equals(_associatedExpression, null);
      _and_2 = (_isEmpty && _equals);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      Procedure1<? super ITreeAppendable> _compilationStrategy = this.getCompilationStrategy(it);
      boolean _equals_1 = ObjectExtensions.operator_equals(_compilationStrategy, null);
      _and_1 = (_and_2 && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      JvmDeclaredType _declaringType = it.getDeclaringType();
      EList<JvmMember> _members = _declaringType.getMembers();
      Iterable<JvmConstructor> _filter = Iterables.<JvmConstructor>filter(_members, JvmConstructor.class);
      int _size = IterableExtensions.size(_filter);
      boolean _equals_2 = (_size == 1);
      _and = (_and_1 && _equals_2);
    }
    return _and;
  }
  
  public boolean isSynthetic(final JvmIdentifiableElement element) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    boolean _isSynthetic = _metaData.isSynthetic();
    return _isSynthetic;
  }
  
  public void setSynthetic(final JvmIdentifiableElement element, final boolean isSynthetic) {
    JvmIdentifiableMetaData _metaData = this.getMetaData(element);
    _metaData.setSynthetic(isSynthetic);
  }
  
  protected JvmIdentifiableMetaData getMetaData(final JvmIdentifiableElement element) {
    EList<Adapter> _eAdapters = element.eAdapters();
    Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, JvmIdentifiableMetaData.class);
    JvmIdentifiableMetaData metaData = ((JvmIdentifiableMetaData) _adapter);
    boolean _equals = ObjectExtensions.operator_equals(metaData, null);
    if (_equals) {
      JvmIdentifiableMetaData _jvmIdentifiableMetaData = new JvmIdentifiableMetaData();
      metaData = _jvmIdentifiableMetaData;
      EList<Adapter> _eAdapters_1 = element.eAdapters();
      _eAdapters_1.add(metaData);
    }
    return metaData;
  }
}
