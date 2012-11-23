/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class DisableCodeGenerationAdapter extends AdapterImpl {
  public boolean isAdapterForType(final Object type) {
    Class<? extends Object> _class = this.getClass();
    boolean _equals = ObjectExtensions.operator_equals(_class, type);
    return _equals;
  }
  
  public static boolean isDisabled(final JvmDeclaredType type) {
    Adapter _adapter = DisableCodeGenerationAdapter.getAdapter(type);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_adapter, null);
    return _notEquals;
  }
  
  public static void disableCodeGeneration(final JvmDeclaredType declaredType) {
    Adapter _adapter = DisableCodeGenerationAdapter.getAdapter(declaredType);
    boolean _equals = ObjectExtensions.operator_equals(_adapter, null);
    if (_equals) {
      EList<Adapter> _eAdapters = declaredType.eAdapters();
      DisableCodeGenerationAdapter _disableCodeGenerationAdapter = new DisableCodeGenerationAdapter();
      _eAdapters.add(_disableCodeGenerationAdapter);
    }
  }
  
  public static void enableCodeGeneration(final JvmDeclaredType declaredType) {
    final Adapter adapter = DisableCodeGenerationAdapter.getAdapter(declaredType);
    boolean _notEquals = ObjectExtensions.operator_notEquals(adapter, null);
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
