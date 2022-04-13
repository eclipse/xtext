/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Creates {@link ICodeBuilder}s to insert Java or Xtend code snippets into an {@link IAppendable}.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API
 */
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
        _xifexpression = this.xtendClassBuilderProvider.get();
      } else {
        _xifexpression = this.javaClassBuilderProvider.get();
      }
      final AbstractClassBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractInterfaceBuilder createInterfaceBuilder(final JvmDeclaredType owner) {
    AbstractInterfaceBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractInterfaceBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendInterfaceBuilderProvider.get();
      } else {
        _xifexpression = this.javaInterfaceBuilderProvider.get();
      }
      final AbstractInterfaceBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractAnnotationBuilder createAnnotationBuilder(final JvmDeclaredType owner) {
    AbstractAnnotationBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractAnnotationBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendAnnotationBuilderProvider.get();
      } else {
        _xifexpression = this.javaAnnotationBuilderProvider.get();
      }
      final AbstractAnnotationBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractFieldBuilder createFieldBuilder(final JvmDeclaredType owner) {
    AbstractFieldBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractFieldBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendFieldBuilderProvider.get();
      } else {
        _xifexpression = this.javaFieldBuilderProvider.get();
      }
      final AbstractFieldBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractConstructorBuilder createConstructorBuilder(final JvmDeclaredType owner) {
    AbstractConstructorBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractConstructorBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendConstructorBuilderProvider.get();
      } else {
        _xifexpression = this.javaConstructorBuilderProvider.get();
      }
      final AbstractConstructorBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractMethodBuilder createMethodBuilder(final JvmDeclaredType owner) {
    AbstractMethodBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractMethodBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendMethodBuilderProvider.get();
      } else {
        _xifexpression = this.javaMethodBuilderProvider.get();
      }
      final AbstractMethodBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }

  public AbstractParameterBuilder createParameterBuilder(final JvmDeclaredType owner) {
    AbstractParameterBuilder _xblockexpression = null;
    {
      final Object ownerSource = this.getSource(owner);
      AbstractParameterBuilder _xifexpression = null;
      if ((ownerSource instanceof XtendTypeDeclaration)) {
        _xifexpression = this.xtendParameterBuilderProvider.get();
      } else {
        _xifexpression = this.javaParameterBuilderProvider.get();
      }
      final AbstractParameterBuilder builder = _xifexpression;
      builder.setOwner(owner);
      builder.setOwnerSource(ownerSource);
      _xblockexpression = builder;
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
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
