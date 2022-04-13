/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib;

import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Deprecated
@SuppressWarnings("all")
public class DataProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
   * @noextend
   * @noreference
   */
  @Deprecated
  public static class Util {
    @Extension
    private TransformationContext context;

    public Util(final TransformationContext context) {
      this.context = context;
    }

    public Iterable<? extends FieldDeclaration> getDataFields(final ClassDeclaration it) {
      final Function1<FieldDeclaration, Boolean> _function = (FieldDeclaration it_1) -> {
        return Boolean.valueOf(((!it_1.isStatic()) && this.context.isThePrimaryGeneratedJavaElement(it_1)));
      };
      return IterableExtensions.filter(it.getDeclaredFields(), _function);
    }

    public Iterable<? extends MutableFieldDeclaration> getDataFields(final MutableClassDeclaration it) {
      final Function1<MutableFieldDeclaration, Boolean> _function = (MutableFieldDeclaration it_1) -> {
        return Boolean.valueOf(((!it_1.isStatic()) && this.context.isThePrimaryGeneratedJavaElement(it_1)));
      };
      return IterableExtensions.filter(it.getDeclaredFields(), _function);
    }

    public void addDataToString(final MutableClassDeclaration cls) {
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        this.context.setPrimarySourceElement(it, this.context.getPrimarySourceElement(cls));
        it.setReturnType(this.context.getString());
        it.addAnnotation(this.context.newAnnotationReference(Override.class));
        it.addAnnotation(this.context.newAnnotationReference(Pure.class));
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("String result = new ");
            _builder.append(ToStringHelper.class);
            _builder.append("().toString(this);");
            _builder.newLineIfNotEmpty();
            _builder.append("return result;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      cls.addMethod("toString", _function);
    }
  }

  @Override
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final DataProcessor.Util util = new DataProcessor.Util(context);
    @Extension
    final AccessorsProcessor.Util getterUtil = new AccessorsProcessor.Util(context);
    @Extension
    final EqualsHashCodeProcessor.Util ehUtil = new EqualsHashCodeProcessor.Util(context);
    @Extension
    final ToStringProcessor.Util toStringUtil = new ToStringProcessor.Util(context);
    @Extension
    final FinalFieldsConstructorProcessor.Util requiredArgsUtil = new FinalFieldsConstructorProcessor.Util(context);
    final Consumer<MutableFieldDeclaration> _function = (MutableFieldDeclaration it_1) -> {
      it_1.setFinal(true);
    };
    util.getDataFields(it).forEach(_function);
    boolean _needsFinalFieldConstructor = requiredArgsUtil.needsFinalFieldConstructor(it);
    if (_needsFinalFieldConstructor) {
      requiredArgsUtil.addFinalFieldsConstructor(it);
    }
    boolean _hasHashCode = ehUtil.hasHashCode(it);
    boolean _not = (!_hasHashCode);
    if (_not) {
      ehUtil.addHashCode(it, util.getDataFields(it), ehUtil.hasSuperHashCode(it));
    }
    boolean _hasEquals = ehUtil.hasEquals(it);
    boolean _not_1 = (!_hasEquals);
    if (_not_1) {
      ehUtil.addEquals(it, util.getDataFields(it), ehUtil.hasSuperEquals(it));
    }
    boolean _hasToString = toStringUtil.hasToString(it);
    boolean _not_2 = (!_hasToString);
    if (_not_2) {
      util.addDataToString(it);
    }
    final Consumer<MutableFieldDeclaration> _function_1 = (MutableFieldDeclaration it_1) -> {
      boolean _shouldAddGetter = getterUtil.shouldAddGetter(it_1);
      if (_shouldAddGetter) {
        getterUtil.addGetter(it_1, Visibility.PUBLIC);
      }
      String _firstLower = StringExtensions.toFirstLower(it_1.getSimpleName());
      String _plus = ("_" + _firstLower);
      it_1.setSimpleName(_plus);
    };
    util.getDataFields(it).forEach(_function_1);
  }
}
