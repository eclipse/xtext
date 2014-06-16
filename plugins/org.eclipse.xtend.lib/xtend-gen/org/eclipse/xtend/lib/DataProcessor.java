package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.lib.CommonQueries;
import org.eclipse.xtend.lib.CommonTransformations;
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
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final CommonTransformations transformations = new CommonTransformations(context);
    boolean _hasDataConstructor = this.hasDataConstructor(it);
    boolean _not = (!_hasDataConstructor);
    if (_not) {
      this.addDataConstructor(it, context);
    }
    boolean _hasHashCode = CommonQueries.hasHashCode(it);
    boolean _not_1 = (!_hasHashCode);
    if (_not_1) {
      Iterable<? extends MutableFieldDeclaration> _instanceFields = CommonQueries.getInstanceFields(it);
      ConstructorDeclaration _superConstructor = this.getSuperConstructor(it);
      boolean _tripleNotEquals = (_superConstructor != null);
      transformations.addHashCode(it, _instanceFields, _tripleNotEquals);
    }
    boolean _hasEquals = CommonQueries.hasEquals(it);
    boolean _not_2 = (!_hasEquals);
    if (_not_2) {
      Iterable<? extends MutableFieldDeclaration> _instanceFields_1 = CommonQueries.getInstanceFields(it);
      ConstructorDeclaration _superConstructor_1 = this.getSuperConstructor(it);
      boolean _tripleNotEquals_1 = (_superConstructor_1 != null);
      transformations.addEquals(it, _instanceFields_1, _tripleNotEquals_1);
    }
    boolean _hasToString = CommonQueries.hasToString(it);
    boolean _not_3 = (!_hasToString);
    if (_not_3) {
      transformations.addReflectiveToString(it);
    }
    Iterable<? extends MutableFieldDeclaration> _instanceFields_2 = CommonQueries.getInstanceFields(it);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _hasGetter = CommonQueries.hasGetter(it);
        boolean _not = (!_hasGetter);
        if (_not) {
          transformations.addGetter(it);
        }
        it.setFinal(true);
        String _simpleName = it.getSimpleName();
        String _firstLower = StringExtensions.toFirstLower(_simpleName);
        String _plus = ("_" + _firstLower);
        it.setSimpleName(_plus);
      }
    };
    IterableExtensions.forEach(_instanceFields_2, _function);
  }
  
  protected boolean hasDataConstructor(final ClassDeclaration cls) {
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
    final Function1<ConstructorDeclaration, Boolean> _function = new Function1<ConstructorDeclaration, Boolean>() {
      public Boolean apply(final ConstructorDeclaration it) {
        boolean _xblockexpression = false;
        {
          final ArrayList<TypeReference> expectedTypes = CollectionLiterals.<TypeReference>newArrayList();
          ConstructorDeclaration _superConstructor = DataProcessor.this.getSuperConstructor(cls);
          boolean _tripleNotEquals = (_superConstructor != null);
          if (_tripleNotEquals) {
            ConstructorDeclaration _superConstructor_1 = DataProcessor.this.getSuperConstructor(cls);
            Iterable<? extends ParameterDeclaration> _parameters = _superConstructor_1.getParameters();
            final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
              public TypeReference apply(final ParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
            Iterables.<TypeReference>addAll(expectedTypes, _map);
          }
          Iterable<? extends FieldDeclaration> _instanceFields = CommonQueries.getInstanceFields(cls);
          final Function1<FieldDeclaration, TypeReference> _function_1 = new Function1<FieldDeclaration, TypeReference>() {
            public TypeReference apply(final FieldDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map_1 = IterableExtensions.map(_instanceFields, _function_1);
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
  
  protected MutableConstructorDeclaration addDataConstructor(final MutableClassDeclaration cls, final TransformationContext ctx) {
    final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
      public void apply(final MutableConstructorDeclaration constructor) {
        final HashMap<Declaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<Declaration, MutableParameterDeclaration>newHashMap();
        Iterable<? extends ParameterDeclaration> _elvis = null;
        ConstructorDeclaration _superConstructor = DataProcessor.this.getSuperConstructor(cls);
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
        Iterable<? extends MutableFieldDeclaration> _constructedFields = DataProcessor.this.constructedFields(cls);
        final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration it) {
            String _simpleName = it.getSimpleName();
            TypeReference _type = it.getType();
            final MutableParameterDeclaration param = constructor.addParameter(_simpleName, _type);
            it.markAsInitialized();
            fieldToParameter.put(it, param);
          }
        };
        IterableExtensions.forEach(_constructedFields, _function_1);
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
              Iterable<? extends MutableFieldDeclaration> _constructedFields = DataProcessor.this.constructedFields(cls);
              for(final MutableFieldDeclaration field : _constructedFields) {
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
  
  protected Iterable<? extends MutableFieldDeclaration> constructedFields(final MutableClassDeclaration it) {
    Iterable<? extends MutableFieldDeclaration> _instanceFields = CommonQueries.getInstanceFields(it);
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        Expression _initializer = it.getInitializer();
        return Boolean.valueOf(Objects.equal(_initializer, null));
      }
    };
    return IterableExtensions.filter(_instanceFields, _function);
  }
  
  protected ConstructorDeclaration getSuperConstructor(final ClassDeclaration it) {
    boolean _or = false;
    TypeReference _extendedClass = it.getExtendedClass();
    boolean _equals = Objects.equal(_extendedClass, null);
    if (_equals) {
      _or = true;
    } else {
      TypeReference _extendedClass_1 = it.getExtendedClass();
      String _name = _extendedClass_1.getName();
      String _name_1 = Object.class.getName();
      boolean _equals_1 = Objects.equal(_name, _name_1);
      _or = _equals_1;
    }
    if (_or) {
      return null;
    }
    TypeReference _extendedClass_2 = it.getExtendedClass();
    Type _type = _extendedClass_2.getType();
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = ((ClassDeclaration) _type).getDeclaredConstructors();
    return IterableExtensions.head(_declaredConstructors);
  }
}
