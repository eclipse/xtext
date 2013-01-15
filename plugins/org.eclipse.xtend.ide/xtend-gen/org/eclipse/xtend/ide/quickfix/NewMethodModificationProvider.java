/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.quickfix.CreateJavaMethod;
import org.eclipse.xtend.ide.quickfix.CreateXtendMethod;
import org.eclipse.xtend.ide.quickfix.FeatureCallTargetTypeProvider;
import org.eclipse.xtend.ide.quickfix.MethodBuilderProvider;
import org.eclipse.xtend.ide.quickfix.XtendMethodBuilder;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable.Factory;

@SuppressWarnings("all")
public class NewMethodModificationProvider {
  @Inject
  private IURIEditorOpener editorOpener;
  
  @Inject
  private Factory apendableFactory;
  
  @Inject
  private MethodBuilderProvider methodBuilderProvider;
  
  @Inject
  private IJavaElementFinder elementProvider;
  
  @Inject
  private FeatureCallTargetTypeProvider _featureCallTargetTypeProvider;
  
  public IModification createModification(final XMemberFeatureCall call, final String methodName) {
    final JvmType targetType = this._featureCallTargetTypeProvider.targetType(call);
    final XtendClass xtendClass = this.xtendClass(targetType);
    boolean _notEquals = ObjectExtensions.operator_notEquals(xtendClass, null);
    if (_notEquals) {
      final XtendMethodBuilder methodBuilder = this.methodBuilderProvider.newXtendMethodBuilder(methodName, call);
      XtendClass _xtendClass = this.xtendClass(targetType);
      CreateXtendMethod _createXtendMethod = new CreateXtendMethod(methodBuilder, _xtendClass, this.editorOpener, this.apendableFactory);
      return _createXtendMethod;
    } else {
      final XtendMethodBuilder methodBuilder_1 = this.methodBuilderProvider.newJavaMethodBuilder(methodName, call);
      boolean _and = false;
      if (!(targetType instanceof JvmGenericType)) {
        _and = false;
      } else {
        boolean _isInterface = ((JvmGenericType) targetType).isInterface();
        _and = ((targetType instanceof JvmGenericType) && _isInterface);
      }
      methodBuilder_1.setIsInterface(_and);
      final IJavaElement javaElement = this.elementProvider.findElementFor(targetType);
      CreateJavaMethod _createJavaMethod = new CreateJavaMethod(methodBuilder_1, ((IType) javaElement));
      return _createJavaMethod;
    }
  }
  
  protected XtendClass xtendClass(final JvmType type) {
    XtendClass _xblockexpression = null;
    {
      boolean _equals = ObjectExtensions.operator_equals(type, null);
      if (_equals) {
        return null;
      }
      Resource _eResource = type.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<XtendClass> _filter = Iterators.<XtendClass>filter(_allContents, XtendClass.class);
      final Function1<XtendClass,Boolean> _function = new Function1<XtendClass,Boolean>() {
          public Boolean apply(final XtendClass it) {
            String _name = it.getName();
            String _simpleName = type.getSimpleName();
            boolean _equals = ObjectExtensions.operator_equals(_name, _simpleName);
            return Boolean.valueOf(_equals);
          }
        };
      XtendClass _findFirst = IteratorExtensions.<XtendClass>findFirst(_filter, _function);
      _xblockexpression = (_findFirst);
    }
    return _xblockexpression;
  }
}
