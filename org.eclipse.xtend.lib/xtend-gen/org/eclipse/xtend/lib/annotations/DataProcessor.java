/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Modifier;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
@SuppressWarnings("all")
public class DataProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
   * @noextend
   * @noreference
   */
  @Beta
  public static class Util {
    @Extension
    private TransformationContext context;

    public Util(final TransformationContext context) {
      this.context = context;
    }

    public Iterable<? extends MutableFieldDeclaration> getDataFields(final MutableClassDeclaration it) {
      final Function1<MutableFieldDeclaration, Boolean> _function = (MutableFieldDeclaration it_1) -> {
        return Boolean.valueOf((((!it_1.isStatic()) && (!it_1.isTransient())) && this.context.isThePrimaryGeneratedJavaElement(it_1)));
      };
      return IterableExtensions.filter(it.getDeclaredFields(), _function);
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
      Element _primarySourceElement = context.getPrimarySourceElement(it_1);
      boolean _contains = ((FieldDeclaration) _primarySourceElement).getModifiers().contains(Modifier.VAR);
      if (_contains) {
        context.addError(it_1, "Cannot use the \'var\' keyword on a data field");
      }
      it_1.setFinal(true);
    };
    util.getDataFields(it).forEach(_function);
    if ((requiredArgsUtil.needsFinalFieldConstructor(it) || (it.findAnnotation(context.findTypeGlobally(FinalFieldsConstructor.class)) != null))) {
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
      ResolvedConstructor _superConstructor = requiredArgsUtil.getSuperConstructor(it);
      boolean _tripleEquals = (_superConstructor == null);
      if (_tripleEquals) {
        Iterable<? extends MutableFieldDeclaration> _dataFields = util.getDataFields(it);
        ToStringConfiguration _elvis = null;
        ToStringConfiguration _toStringConfig = toStringUtil.getToStringConfig(it);
        if (_toStringConfig != null) {
          _elvis = _toStringConfig;
        } else {
          ToStringConfiguration _toStringConfiguration = new ToStringConfiguration();
          _elvis = _toStringConfiguration;
        }
        toStringUtil.addToString(it, _dataFields, _elvis);
      } else {
        ToStringConfiguration _elvis_1 = null;
        ToStringConfiguration _toStringConfig_1 = toStringUtil.getToStringConfig(it);
        if (_toStringConfig_1 != null) {
          _elvis_1 = _toStringConfig_1;
        } else {
          ToStringConfiguration _toStringConfiguration_1 = new ToStringConfiguration();
          _elvis_1 = _toStringConfiguration_1;
        }
        toStringUtil.addReflectiveToString(it, _elvis_1);
      }
    }
    final Consumer<MutableFieldDeclaration> _function_1 = (MutableFieldDeclaration it_1) -> {
      boolean _shouldAddGetter = getterUtil.shouldAddGetter(it_1);
      if (_shouldAddGetter) {
        Visibility _elvis_2 = null;
        AccessorType _getterType = getterUtil.getGetterType(it_1);
        Visibility _visibility = null;
        if (_getterType!=null) {
          _visibility=getterUtil.toVisibility(_getterType);
        }
        if (_visibility != null) {
          _elvis_2 = _visibility;
        } else {
          _elvis_2 = Visibility.PUBLIC;
        }
        getterUtil.addGetter(it_1, _elvis_2);
      }
    };
    util.getDataFields(it).forEach(_function_1);
  }
}
