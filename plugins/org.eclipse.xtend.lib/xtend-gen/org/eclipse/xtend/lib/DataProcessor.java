package org.eclipse.xtend.lib;

import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
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
 */
@Deprecated
@SuppressWarnings("all")
public class DataProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
   */
  @Deprecated
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
    }
    
    public Iterable<? extends FieldDeclaration> getDataFields(final ClassDeclaration it) {
      Iterable<? extends FieldDeclaration> _declaredFields = it.getDeclaredFields();
      final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
        public Boolean apply(final FieldDeclaration it) {
          boolean _and = false;
          boolean _isStatic = it.isStatic();
          boolean _not = (!_isStatic);
          if (!_not) {
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
    
    public Iterable<? extends MutableFieldDeclaration> getDataFields(final MutableClassDeclaration it) {
      Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        public Boolean apply(final MutableFieldDeclaration it) {
          boolean _and = false;
          boolean _isStatic = it.isStatic();
          boolean _not = (!_isStatic);
          if (!_not) {
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
    
    public void addDataToString(final MutableClassDeclaration cls) {
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          TypeReference _string = Util.this.context.getString();
          it.setReturnType(_string);
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Override.class);
          it.addAnnotation(_newAnnotationReference);
          AnnotationReference _newAnnotationReference_1 = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("String result = new ");
              _builder.append(ToStringHelper.class, "");
              _builder.append("().toString(this);");
              _builder.newLineIfNotEmpty();
              _builder.append("return result;");
              _builder.newLine();
            }
          };
          it.setBody(_client);
        }
      };
      cls.addMethod("toString", _function);
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
      util.addDataToString(it);
    }
    Iterable<? extends MutableFieldDeclaration> _dataFields_3 = util.getDataFields(it);
    final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _shouldAddGetter = getterUtil.shouldAddGetter(it);
        if (_shouldAddGetter) {
          getterUtil.addGetter(it, Visibility.PUBLIC);
        }
        String _simpleName = it.getSimpleName();
        String _firstLower = StringExtensions.toFirstLower(_simpleName);
        String _plus = ("_" + _firstLower);
        it.setSimpleName(_plus);
      }
    };
    IterableExtensions.forEach(_dataFields_3, _function_1);
  }
}
