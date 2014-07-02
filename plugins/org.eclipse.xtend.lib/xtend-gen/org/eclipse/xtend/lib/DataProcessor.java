package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.annotations.GetterProcessor;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Declaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
    
    public boolean hasDataConstructor(final ClassDeclaration cls) {
      Iterable<? extends ConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
      final Function1<ConstructorDeclaration, Boolean> _function = new Function1<ConstructorDeclaration, Boolean>() {
        public Boolean apply(final ConstructorDeclaration it) {
          boolean _xblockexpression = false;
          {
            final ArrayList<TypeReference> expectedTypes = CollectionLiterals.<TypeReference>newArrayList();
            ConstructorDeclaration _superConstructor = Util.this.getSuperConstructor(cls);
            boolean _tripleNotEquals = (_superConstructor != null);
            if (_tripleNotEquals) {
              ConstructorDeclaration _superConstructor_1 = Util.this.getSuperConstructor(cls);
              Iterable<? extends ParameterDeclaration> _parameters = _superConstructor_1.getParameters();
              final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
                public TypeReference apply(final ParameterDeclaration it) {
                  return it.getType();
                }
              };
              Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
              Iterables.<TypeReference>addAll(expectedTypes, _map);
            }
            Iterable<? extends FieldDeclaration> _dataFields = Util.this.getDataFields(cls);
            final Function1<FieldDeclaration, TypeReference> _function_1 = new Function1<FieldDeclaration, TypeReference>() {
              public TypeReference apply(final FieldDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map_1 = IterableExtensions.map(_dataFields, _function_1);
            Iterables.<TypeReference>addAll(expectedTypes, _map_1);
            Iterable<? extends ParameterDeclaration> _parameters_1 = it.getParameters();
            final Function1<ParameterDeclaration, TypeReference> _function_2 = new Function1<ParameterDeclaration, TypeReference>() {
              public TypeReference apply(final ParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map_2 = IterableExtensions.map(_parameters_1, _function_2);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map_2);
            _xblockexpression = Objects.equal(_list, expectedTypes);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      return IterableExtensions.exists(_declaredConstructors, _function);
    }
    
    public MutableConstructorDeclaration addDataConstructor(final MutableClassDeclaration cls) {
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        public void apply(final MutableConstructorDeclaration constructor) {
          final HashMap<Declaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<Declaration, MutableParameterDeclaration>newHashMap();
          Iterable<? extends ParameterDeclaration> _elvis = null;
          ConstructorDeclaration _superConstructor = Util.this.getSuperConstructor(cls);
          Iterable<? extends ParameterDeclaration> _parameters = null;
          if (_superConstructor!=null) {
            _parameters=_superConstructor.getParameters();
          }
          if (_parameters != null) {
            _elvis = _parameters;
          } else {
            _elvis = Collections.<ParameterDeclaration>unmodifiableList(Lists.<ParameterDeclaration>newArrayList());
          }
          final Iterable<? extends ParameterDeclaration> superParameters = _elvis;
          final Procedure1<ParameterDeclaration> _function = new Procedure1<ParameterDeclaration>() {
            public void apply(final ParameterDeclaration it) {
              String _simpleName = it.getSimpleName();
              TypeReference _type = it.getType();
              final MutableParameterDeclaration param = constructor.addParameter(_simpleName, _type);
              fieldToParameter.put(it, param);
            }
          };
          IterableExtensions.forEach(superParameters, _function);
          Iterable<? extends MutableFieldDeclaration> _dataConstructorFields = Util.this.getDataConstructorFields(cls);
          final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
            public void apply(final MutableFieldDeclaration it) {
              String _simpleName = it.getSimpleName();
              TypeReference _type = it.getType();
              final MutableParameterDeclaration param = constructor.addParameter(_simpleName, _type);
              it.markAsInitializedBy(constructor);
              fieldToParameter.put(it, param);
            }
          };
          IterableExtensions.forEach(_dataConstructorFields, _function_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("super(");
              final Function1<ParameterDeclaration, String> _function = new Function1<ParameterDeclaration, String>() {
                public String apply(final ParameterDeclaration it) {
                  return it.getSimpleName();
                }
              };
              String _join = IterableExtensions.join(superParameters, ", ", _function);
              _builder.append(_join, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                Iterable<? extends MutableFieldDeclaration> _dataConstructorFields = Util.this.getDataConstructorFields(cls);
                for(final MutableFieldDeclaration field : _dataConstructorFields) {
                  _builder.append("this.");
                  String _simpleName = field.getSimpleName();
                  _builder.append(_simpleName, "");
                  _builder.append(" = ");
                  MutableParameterDeclaration _get = fieldToParameter.get(field);
                  String _simpleName_1 = _get.getSimpleName();
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
    
    public Iterable<? extends MutableFieldDeclaration> getDataConstructorFields(final MutableClassDeclaration it) {
      Iterable<? extends MutableFieldDeclaration> _dataFields = this.getDataFields(it);
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        public Boolean apply(final MutableFieldDeclaration it) {
          Expression _initializer = it.getInitializer();
          return Boolean.valueOf(Objects.equal(_initializer, null));
        }
      };
      return IterableExtensions.filter(_dataFields, _function);
    }
    
    public ConstructorDeclaration getSuperConstructor(final ClassDeclaration it) {
      TypeReference _extendedClass = it.getExtendedClass();
      TypeReference _object = this.context.getObject();
      boolean _equals = Objects.equal(_extendedClass, _object);
      if (_equals) {
        return null;
      }
      TypeReference _extendedClass_1 = it.getExtendedClass();
      Type _type = _extendedClass_1.getType();
      Iterable<? extends ConstructorDeclaration> _declaredConstructors = ((ClassDeclaration) _type).getDeclaredConstructors();
      return IterableExtensions.head(_declaredConstructors);
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
  }
  
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final DataProcessor.Util util = new DataProcessor.Util(context);
    @Extension
    final GetterProcessor.Util getterUtil = new GetterProcessor.Util(context);
    @Extension
    final EqualsHashCodeProcessor.Util ehUtil = new EqualsHashCodeProcessor.Util(context);
    @Extension
    final ToStringProcessor.Util toStringUtil = new ToStringProcessor.Util(context);
    boolean _hasDataConstructor = util.hasDataConstructor(it);
    boolean _not = (!_hasDataConstructor);
    if (_not) {
      util.addDataConstructor(it);
    }
    boolean _hasHashCode = ehUtil.hasHashCode(it);
    boolean _not_1 = (!_hasHashCode);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _dataFields = util.getDataFields(it);
      ConstructorDeclaration _superConstructor = util.getSuperConstructor(it);
      boolean _tripleNotEquals = (_superConstructor != null);
      ehUtil.addHashCode(it, _dataFields, _tripleNotEquals);
    }
    boolean _hasEquals = ehUtil.hasEquals(it);
    boolean _not_2 = (!_hasEquals);
    if (_not_2) {
      Iterable<? extends MutableFieldDeclaration> _dataFields_1 = util.getDataFields(it);
      ConstructorDeclaration _superConstructor_1 = util.getSuperConstructor(it);
      boolean _tripleNotEquals_1 = (_superConstructor_1 != null);
      ehUtil.addEquals(it, _dataFields_1, _tripleNotEquals_1);
    }
    boolean _hasToString = toStringUtil.hasToString(it);
    boolean _not_3 = (!_hasToString);
    if (_not_3) {
      toStringUtil.addReflectiveToString(it);
    }
    Iterable<? extends MutableFieldDeclaration> _dataFields_2 = util.getDataFields(it);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _hasGetter = getterUtil.hasGetter(it);
        boolean _not = (!_hasGetter);
        if (_not) {
          getterUtil.addGetter(it);
        }
        it.setFinal(true);
        String _simpleName = it.getSimpleName();
        String _firstLower = StringExtensions.toFirstLower(_simpleName);
        String _plus = ("_" + _firstLower);
        it.setSimpleName(_plus);
      }
    };
    IterableExtensions.forEach(_dataFields_2, _function);
  }
}
