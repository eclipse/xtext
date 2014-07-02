package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.GetterProcessor;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class ValueObjectProcessor extends AbstractClassProcessor {
  /**
   * @since 2.7
   */
  @Beta
  @GwtCompatible
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
    }
    
    public boolean hasVoConstructor(final MutableClassDeclaration cls) {
      Iterable<? extends MutableConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
      final Function1<MutableConstructorDeclaration, Boolean> _function = new Function1<MutableConstructorDeclaration, Boolean>() {
        public Boolean apply(final MutableConstructorDeclaration it) {
          Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
          final Function1<MutableParameterDeclaration, TypeReference> _function = new Function1<MutableParameterDeclaration, TypeReference>() {
            public TypeReference apply(final MutableParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
          List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
          Iterable<? extends MutableFieldDeclaration> _valueObjectFields = Util.this.getValueObjectFields(cls);
          final Function1<MutableFieldDeclaration, TypeReference> _function_1 = new Function1<MutableFieldDeclaration, TypeReference>() {
            public TypeReference apply(final MutableFieldDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map_1 = IterableExtensions.map(_valueObjectFields, _function_1);
          List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(_map_1);
          return Boolean.valueOf(Objects.equal(_list, _list_1));
        }
      };
      return IterableExtensions.exists(_declaredConstructors, _function);
    }
    
    public MutableConstructorDeclaration addVoConstructor(final MutableClassDeclaration cls) {
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        public void apply(final MutableConstructorDeclaration constructor) {
          Iterable<? extends MutableFieldDeclaration> _valueObjectConstructorFields = Util.this.getValueObjectConstructorFields(cls);
          final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
            public void apply(final MutableFieldDeclaration it) {
              String _simpleName = it.getSimpleName();
              TypeReference _type = it.getType();
              constructor.addParameter(_simpleName, _type);
              it.markAsInitializedBy(constructor);
            }
          };
          IterableExtensions.forEach(_valueObjectConstructorFields, _function);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              {
                Iterable<? extends MutableFieldDeclaration> _valueObjectConstructorFields = Util.this.getValueObjectConstructorFields(cls);
                for(final MutableFieldDeclaration field : _valueObjectConstructorFields) {
                  _builder.append("this.");
                  String _simpleName = field.getSimpleName();
                  _builder.append(_simpleName, "");
                  _builder.append(" = ");
                  String _simpleName_1 = field.getSimpleName();
                  _builder.append(_simpleName_1, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          };
          constructor.setBody(_client);
        }
      };
      return cls.addConstructor(_function);
    }
    
    public Iterable<? extends MutableFieldDeclaration> getValueObjectConstructorFields(final MutableTypeDeclaration it) {
      Iterable<? extends MutableFieldDeclaration> _valueObjectFields = this.getValueObjectFields(it);
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        public Boolean apply(final MutableFieldDeclaration it) {
          Expression _initializer = it.getInitializer();
          return Boolean.valueOf((_initializer == null));
        }
      };
      return IterableExtensions.filter(_valueObjectFields, _function);
    }
    
    public Iterable<? extends MutableFieldDeclaration> getValueObjectFields(final MutableTypeDeclaration it) {
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
  
  public void doTransform(final MutableClassDeclaration cls, @Extension final TransformationContext context) {
    @Extension
    final ValueObjectProcessor.Util util = new ValueObjectProcessor.Util(context);
    @Extension
    final GetterProcessor.Util getterUtil = new GetterProcessor.Util(context);
    @Extension
    final EqualsHashCodeProcessor.Util ehUtil = new EqualsHashCodeProcessor.Util(context);
    @Extension
    final ToStringProcessor.Util toStringUtil = new ToStringProcessor.Util(context);
    cls.setFinal(true);
    TypeReference _extendedClass = cls.getExtendedClass();
    TypeReference _object = context.getObject();
    boolean _notEquals = (!Objects.equal(_extendedClass, _object));
    if (_notEquals) {
      context.addError(cls, "Inheritance is forbidden for value objects");
    }
    boolean _hasVoConstructor = util.hasVoConstructor(cls);
    boolean _not = (!_hasVoConstructor);
    if (_not) {
      util.addVoConstructor(cls);
    }
    boolean _hasToString = toStringUtil.hasToString(cls);
    boolean _not_1 = (!_hasToString);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _valueObjectFields = util.getValueObjectFields(cls);
      toStringUtil.addToString(cls, _valueObjectFields);
    }
    boolean _hasEquals = ehUtil.hasEquals(cls);
    boolean _not_2 = (!_hasEquals);
    if (_not_2) {
      Iterable<? extends MutableFieldDeclaration> _valueObjectFields_1 = util.getValueObjectFields(cls);
      ehUtil.addEquals(cls, _valueObjectFields_1, false);
    }
    boolean _hasHashCode = ehUtil.hasHashCode(cls);
    boolean _not_3 = (!_hasHashCode);
    if (_not_3) {
      Iterable<? extends MutableFieldDeclaration> _valueObjectFields_2 = util.getValueObjectFields(cls);
      ehUtil.addHashCode(cls, _valueObjectFields_2, false);
    }
    Iterable<? extends MutableFieldDeclaration> _valueObjectFields_3 = util.getValueObjectFields(cls);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _hasGetter = getterUtil.hasGetter(it);
        boolean _not = (!_hasGetter);
        if (_not) {
          getterUtil.addGetter(it);
        }
        it.setFinal(true);
      }
    };
    IterableExtensions.forEach(_valueObjectFields_3, _function);
  }
}
