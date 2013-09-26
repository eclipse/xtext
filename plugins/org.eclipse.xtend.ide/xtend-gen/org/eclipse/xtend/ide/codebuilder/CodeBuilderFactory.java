/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractClassBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractInterfaceBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaClassBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaInterfaceBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendClassBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendInterfaceBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.XtendParameterBuilder;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Creates {@link ICodeBuilder}s to insert Java or Xtend code snippets into an {@link IAppendable}.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class CodeBuilderFactory {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  @Extension
  private IJavaElementFinder _iJavaElementFinder;
  
  @Inject
  private Provider<XtendClassBuilder> xtendClassBuilderProvider;
  
  @Inject
  private Provider<XtendInterfaceBuilder> xtendInterfaceBuilderProvider;
  
  @Inject
  private Provider<XtendAnnotationBuilder> xtendAnnotationBuilderProvider;
  
  @Inject
  private Provider<XtendFieldBuilder> xtendFieldBuilderProvider;
  
  @Inject
  private Provider<XtendConstructorBuilder> xtendConstructorBuilderProvider;
  
  @Inject
  private Provider<XtendMethodBuilder> xtendMethodBuilderProvider;
  
  @Inject
  private Provider<XtendParameterBuilder> xtendParameterBuilderProvider;
  
  @Inject
  private Provider<JavaClassBuilder> javaClassBuilderProvider;
  
  @Inject
  private Provider<JavaInterfaceBuilder> javaInterfaceBuilderProvider;
  
  @Inject
  private Provider<JavaAnnotationBuilder> javaAnnotationBuilderProvider;
  
  @Inject
  private Provider<JavaFieldBuilder> javaFieldBuilderProvider;
  
  @Inject
  private Provider<JavaConstructorBuilder> javaConstructorBuilderProvider;
  
  @Inject
  private Provider<JavaMethodBuilder> javaMethodBuilderProvider;
  
  @Inject
  private Provider<JavaParameterBuilder> javaParameterBuilderProvider;
  
  public AbstractClassBuilder createClassBuilder(final JvmDeclaredType owner) {
    AbstractClassBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractClassBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        XtendClassBuilder _get = this.xtendClassBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaClassBuilder _get_1 = this.javaClassBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractClassBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public AbstractInterfaceBuilder createInterfaceBuilder(final JvmDeclaredType owner) {
    AbstractInterfaceBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractInterfaceBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        XtendInterfaceBuilder _get = this.xtendInterfaceBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaInterfaceBuilder _get_1 = this.javaInterfaceBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractInterfaceBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public AbstractAnnotationBuilder createAnnotationBuilder(final JvmDeclaredType owner) {
    AbstractAnnotationBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractAnnotationBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        XtendAnnotationBuilder _get = this.xtendAnnotationBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaAnnotationBuilder _get_1 = this.javaAnnotationBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractAnnotationBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public AbstractFieldBuilder createFieldBuilder(final JvmDeclaredType owner) {
    AbstractFieldBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractFieldBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
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
      if ((ownerSource instanceof XtendTypeDeclaration)) {
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
      if ((ownerSource instanceof XtendTypeDeclaration)) {
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
  
  public AbstractParameterBuilder createParameterBuilder(final JvmDeclaredType owner) {
    AbstractParameterBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractParameterBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        XtendParameterBuilder _get = this.xtendParameterBuilderProvider.get();
        _xifexpression = _get;
      } else {
        JavaParameterBuilder _get_1 = this.javaParameterBuilderProvider.get();
        _xifexpression = _get_1;
      }
      final AbstractParameterBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public Object getSource(final JvmDeclaredType element) {
    IType _xblockexpression = null;
    {
      final EObject xtendType = this._iXtendJvmAssociations.getPrimarySourceElement(element);
      if ((xtendType instanceof XtendTypeDeclaration)) {
        return xtendType;
      }
      final IJavaElement jvmElement = this._iJavaElementFinder.findExactElementFor(element);
      IType _xifexpression = null;
      if ((jvmElement instanceof IType)) {
        _xifexpression = ((IType)jvmElement);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
