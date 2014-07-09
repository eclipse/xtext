package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.annotations.ToStringConfiguration;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
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
 */
@Beta
@SuppressWarnings("all")
public class DataProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
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
        public Boolean apply(final MutableFieldDeclaration it) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _isStatic = it.isStatic();
          boolean _not = (!_isStatic);
          if (!_not) {
            _and_1 = false;
          } else {
            boolean _isTransient = it.isTransient();
            boolean _not_1 = (!_isTransient);
            _and_1 = _not_1;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _isThePrimaryGeneratedJavaElement = Util.this.context.isThePrimaryGeneratedJavaElement(it);
            _and = _isThePrimaryGeneratedJavaElement;
          }
          return Boolean.valueOf(_and);
        }
      };
      return IterableExtensions.filter(_declaredFields, _function);
    }
  }
  
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
      public void apply(final MutableFieldDeclaration it) {
        it.setFinal(true);
      }
    };
    IterableExtensions.forEach(_dataFields, _function);
    boolean _needsFinalFieldConstructor = requiredArgsUtil.needsFinalFieldConstructor(it);
    if (_needsFinalFieldConstructor) {
      requiredArgsUtil.addFinalFieldsConstructor(it);
    }
    boolean _hasHashCode = ehUtil.hasHashCode(it);
    boolean _not = (!_hasHashCode);
    if (_not) {
      Iterable<? extends MutableFieldDeclaration> _dataFields_1 = util.getDataFields(it);
      ResolvedConstructor _superConstructor = requiredArgsUtil.getSuperConstructor(it);
      boolean _tripleNotEquals = (_superConstructor != null);
      ehUtil.addHashCode(it, _dataFields_1, _tripleNotEquals);
    }
    boolean _hasEquals = ehUtil.hasEquals(it);
    boolean _not_1 = (!_hasEquals);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _dataFields_2 = util.getDataFields(it);
      ResolvedConstructor _superConstructor_1 = requiredArgsUtil.getSuperConstructor(it);
      boolean _tripleNotEquals_1 = (_superConstructor_1 != null);
      ehUtil.addEquals(it, _dataFields_2, _tripleNotEquals_1);
    }
    boolean _hasToString = toStringUtil.hasToString(it);
    boolean _not_2 = (!_hasToString);
    if (_not_2) {
      ResolvedConstructor _superConstructor_2 = requiredArgsUtil.getSuperConstructor(it);
      boolean _tripleEquals = (_superConstructor_2 == null);
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
