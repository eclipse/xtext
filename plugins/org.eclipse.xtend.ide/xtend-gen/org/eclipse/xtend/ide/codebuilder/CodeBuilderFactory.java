package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendMethodBuilder;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class CodeBuilderFactory {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private IJavaElementFinder _iJavaElementFinder;
  
  @Inject
  private Provider<XtendFieldBuilder> xtendFieldBuilderProvider;
  
  @Inject
  private Provider<XtendMethodBuilder> xtendMethodBuilderProvider;
  
  @Inject
  private Provider<XtendConstructorBuilder> xtendConstructorBuilderProvider;
  
  @Inject
  private Provider<JavaFieldBuilder> javaFieldBuilderProvider;
  
  @Inject
  private Provider<JavaMethodBuilder> javaMethodBuilderProvider;
  
  @Inject
  private Provider<JavaConstructorBuilder> javaConstructorBuilderProvider;
  
  public AbstractFieldBuilder createFieldBuilder(final JvmDeclaredType owner) {
    AbstractFieldBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractFieldBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendClass)) {
        XtendFieldBuilder _get = this.xtendFieldBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaFieldBuilder _get_1 = this.javaFieldBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractFieldBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public AbstractConstructorBuilder createConstructorBuilder(final JvmDeclaredType owner) {
    AbstractConstructorBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractConstructorBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendClass)) {
        XtendConstructorBuilder _get = this.xtendConstructorBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaConstructorBuilder _get_1 = this.javaConstructorBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractConstructorBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public AbstractMethodBuilder createMethodBuilder(final JvmDeclaredType owner) {
    AbstractMethodBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractMethodBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendClass)) {
        XtendMethodBuilder _get = this.xtendMethodBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaMethodBuilder _get_1 = this.javaMethodBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractMethodBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public Object getSource(final JvmDeclaredType element) {
    IJavaElement _xblockexpression = null;
    {
      if ((element instanceof JvmGenericType)) {
        final XtendClass xtendClass = this._iXtendJvmAssociations.getXtendClass(((JvmGenericType) element));
        boolean _notEquals = ObjectExtensions.operator_notEquals(xtendClass, null);
        if (_notEquals) {
          return xtendClass;
        }
      }
      final IJavaElement jvmElement = this._iJavaElementFinder.findExactElementFor(element);
      IJavaElement _xifexpression = null;
      if ((jvmElement instanceof IType)) {
        _xifexpression = jvmElement;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
