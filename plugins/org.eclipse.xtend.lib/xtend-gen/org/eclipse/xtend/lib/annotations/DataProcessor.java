package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.annotations.ToStringConfiguration;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
      Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        @Override
        public Boolean apply(final MutableFieldDeclaration it) {
          return Boolean.valueOf((((!it.isStatic()) && (!it.isTransient())) && Util.this.context.isThePrimaryGeneratedJavaElement(it)));
        }
      };
      return IterableExtensions.filter(_declaredFields, _function);
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
    Iterable<? extends MutableFieldDeclaration> _dataFields = util.getDataFields(it);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      @Override
      public void apply(final MutableFieldDeclaration it) {
        Element _primarySourceElement = context.getPrimarySourceElement(it);
        Set<Modifier> _modifiers = ((FieldDeclaration) _primarySourceElement).getModifiers();
        boolean _contains = _modifiers.contains(Modifier.VAR);
        if (_contains) {
          context.addError(it, "Cannot use the \'var\' keyword on a data field");
        }
        it.setFinal(true);
      }
    };
    IterableExtensions.forEach(_dataFields, _function);
    if ((requiredArgsUtil.needsFinalFieldConstructor(it) || (it.findAnnotation(context.findTypeGlobally(FinalFieldsConstructor.class)) != null))) {
      requiredArgsUtil.addFinalFieldsConstructor(it);
    }
    boolean _hasHashCode = ehUtil.hasHashCode(it);
    boolean _not = (!_hasHashCode);
    if (_not) {
      Iterable<? extends MutableFieldDeclaration> _dataFields_1 = util.getDataFields(it);
      boolean _hasSuperHashCode = ehUtil.hasSuperHashCode(it);
      ehUtil.addHashCode(it, _dataFields_1, _hasSuperHashCode);
    }
    boolean _hasEquals = ehUtil.hasEquals(it);
    boolean _not_1 = (!_hasEquals);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _dataFields_2 = util.getDataFields(it);
      boolean _hasSuperEquals = ehUtil.hasSuperEquals(it);
      ehUtil.addEquals(it, _dataFields_2, _hasSuperEquals);
    }
    boolean _hasToString = toStringUtil.hasToString(it);
    boolean _not_2 = (!_hasToString);
    if (_not_2) {
      ResolvedConstructor _superConstructor = requiredArgsUtil.getSuperConstructor(it);
      boolean _tripleEquals = (_superConstructor == null);
      if (_tripleEquals) {
        Iterable<? extends MutableFieldDeclaration> _dataFields_3 = util.getDataFields(it);
        ToStringConfiguration _elvis = null;
        ToStringConfiguration _toStringConfig = toStringUtil.getToStringConfig(it);
        if (_toStringConfig != null) {
          _elvis = _toStringConfig;
        } else {
          ToStringConfiguration _toStringConfiguration = new ToStringConfiguration();
          _elvis = _toStringConfiguration;
        }
        toStringUtil.addToString(it, _dataFields_3, _elvis);
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
    Iterable<? extends MutableFieldDeclaration> _dataFields_4 = util.getDataFields(it);
    final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
      @Override
      public void apply(final MutableFieldDeclaration it) {
        boolean _shouldAddGetter = getterUtil.shouldAddGetter(it);
        if (_shouldAddGetter) {
          Visibility _elvis = null;
          AccessorType _getterType = getterUtil.getGetterType(it);
          Visibility _visibility = null;
          if (_getterType!=null) {
            _visibility=getterUtil.toVisibility(_getterType);
          }
          if (_visibility != null) {
            _elvis = _visibility;
          } else {
            _elvis = Visibility.PUBLIC;
          }
          getterUtil.addGetter(it, _elvis);
        }
      }
    };
    IterableExtensions.forEach(_dataFields_4, _function_1);
  }
}
