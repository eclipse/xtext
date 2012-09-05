package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;

@SuppressWarnings("all")
public class DisableCodeGenerationAdapter extends AdapterImpl {
  public boolean isAdapterForType(final Object type) {
    Class<? extends Object> _class = this.getClass();
    boolean _equals = Objects.equal(_class, type);
    return _equals;
  }
  
  public static boolean isDisabled(final JvmDeclaredType type) {
    Adapter _adapter = DisableCodeGenerationAdapter.getAdapter(type);
    boolean _notEquals = (!Objects.equal(_adapter, null));
    return _notEquals;
  }
  
  public static void disableCodeGeneration(final JvmDeclaredType declaredType) {
    Adapter _adapter = DisableCodeGenerationAdapter.getAdapter(declaredType);
    boolean _equals = Objects.equal(_adapter, null);
    if (_equals) {
      EList<Adapter> _eAdapters = declaredType.eAdapters();
      DisableCodeGenerationAdapter _disableCodeGenerationAdapter = new DisableCodeGenerationAdapter();
      _eAdapters.add(_disableCodeGenerationAdapter);
    }
  }
  
  public static void enableCodeGeneration(final JvmDeclaredType declaredType) {
    final Adapter adapter = DisableCodeGenerationAdapter.getAdapter(declaredType);
    boolean _notEquals = (!Objects.equal(adapter, null));
    if (_notEquals) {
      EList<Adapter> _eAdapters = declaredType.eAdapters();
      _eAdapters.remove(adapter);
    }
  }
  
  private static Adapter getAdapter(final JvmDeclaredType declaredType) {
    EList<Adapter> _eAdapters = declaredType.eAdapters();
    return EcoreUtil.getAdapter(_eAdapters, DisableCodeGenerationAdapter.class);
  }
}
