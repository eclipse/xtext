package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  @Inject
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private ITypeProvider _iTypeProvider;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    EList<EObject> _contents = input.getContents();
    for (final EObject obj : _contents) {
      this.internalDoGenerate(obj, fsa);
    }
  }
  
  protected void _internalDoGenerate(final EObject obj, final IFileSystemAccess fsa) {
  }
  
  protected void _internalDoGenerate(final JvmGenericType type, final IFileSystemAccess fsa) {
    String _qualifiedName = type.getQualifiedName();
    String _replace = _qualifiedName.replace(".", "/");
    String _operator_plus = StringExtensions.operator_plus(_replace, ".java");
    CharSequence _generateType = this.generateType(type);
    fsa.generateFile(_operator_plus, _generateType);
  }
  
  public CharSequence generateType(final JvmGenericType type) {
    CharSequence _xblockexpression = null;
    {
      ImportManager _importManager = new ImportManager(true, type);
      final ImportManager importManager = _importManager;
      CharSequence _generateBody = this.generateBody(type, importManager);
      final CharSequence typeBody = _generateBody;
      StringConcatenation _builder = new StringConcatenation();
      {
        String _packageName = type.getPackageName();
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_packageName, null);
        if (_operator_notEquals) {
          _builder.append("package ");
          String _packageName_1 = type.getPackageName();
          _builder.append(_packageName_1, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      {
        List<String> _imports = importManager.getImports();
        boolean hasAnyElements = false;
        for(final String i : _imports) {
          if (!hasAnyElements) {
            hasAnyElements = true;
          }
          _builder.append("import ");
          _builder.append(i, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
        if (hasAnyElements) {
          _builder.append("\n", "");
        }
      }
      _builder.append(typeBody, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateBody(final JvmGenericType it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateJavaDoc = this.generateJavaDoc(it);
    _builder.append(_generateJavaDoc, "");
    _builder.newLineIfNotEmpty();
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    CharSequence _generateAnnotations = this.generateAnnotations(_annotations, importManager);
    _builder.append(_generateAnnotations, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generateModifier = this.generateModifier(it);
    _builder.append(_generateModifier, "");
    {
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        _builder.append("interface");
      } else {
        _builder.append("class");
      }
    }
    _builder.append(" ");
    String _simpleName = it.getSimpleName();
    _builder.append(_simpleName, "");
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    CharSequence _generateTypeParameterDeclaration = this.generateTypeParameterDeclaration(_typeParameters, importManager);
    _builder.append(_generateTypeParameterDeclaration, "");
    _builder.append(" ");
    String _generateExtendsClause = this.generateExtendsClause(it, importManager);
    _builder.append(_generateExtendsClause, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      EList<JvmMember> _members = it.getMembers();
      final Function1<JvmMember,CharSequence> _function = new Function1<JvmMember,CharSequence>() {
          public CharSequence apply(final JvmMember m) {
            CharSequence _generateMember = JvmModelGenerator.this.generateMember(m, importManager);
            return _generateMember;
          }
        };
      List<CharSequence> _map = ListExtensions.<JvmMember, CharSequence>map(_members, _function);
      final Function1<CharSequence,Boolean> _function_1 = new Function1<CharSequence,Boolean>() {
          public Boolean apply(final CharSequence c) {
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(c, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<CharSequence> _filter = IterableExtensions.<CharSequence>filter(_map, _function_1);
      boolean hasAnyElements = false;
      for(final CharSequence memberCode : _filter) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate("\n", "  ");
        }
        _builder.append("  ");
        _builder.append(memberCode, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateModifier(final JvmGenericType it) {
    StringConcatenation _builder = new StringConcatenation();
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    _builder.append(_javaName, "");
    {
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    {
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        _builder.append("final ");
      }
    }
    {
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        _builder.append("static ");
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateModifier(final JvmField it) {
    StringConcatenation _builder = new StringConcatenation();
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    _builder.append(_javaName, "");
    {
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        _builder.append("final ");
      }
    }
    {
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        _builder.append("static ");
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateModifier(final JvmOperation it) {
    StringConcatenation _builder = new StringConcatenation();
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    _builder.append(_javaName, "");
    {
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    {
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        _builder.append("final ");
      }
    }
    {
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        _builder.append("static ");
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateModifier(final JvmConstructor it) {
    StringConcatenation _builder = new StringConcatenation();
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    _builder.append(_javaName, "");
    return _builder;
  }
  
  public String javaName(final JvmVisibility visibility) {
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(visibility, null);
    if (_operator_notEquals) {
      String _switchResult = null;
      final JvmVisibility visibility_1 = visibility;
      boolean matched = false;
      if (!matched) {
        if (ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PRIVATE)) {
          matched=true;
          _switchResult = "private ";
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PUBLIC)) {
          matched=true;
          _switchResult = "public ";
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PROTECTED)) {
          matched=true;
          _switchResult = "protected ";
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(visibility_1,JvmVisibility.DEFAULT)) {
          matched=true;
          _switchResult = "";
        }
      }
      return _switchResult;
    } else {
      return "";
    }
  }
  
  public String generateExtendsClause(final JvmGenericType it, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      boolean _isEmpty = _superTypes.isEmpty();
      if (_isEmpty) {
        return null;
      }
      String _xifexpression = null;
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        EList<JvmTypeReference> _superTypes_1 = it.getSuperTypes();
        final Function1<JvmTypeReference,String> _function = new Function1<JvmTypeReference,String>() {
            public String apply(final JvmTypeReference t) {
              String _serialize = JvmModelGenerator.this.serialize(t, importManager);
              return _serialize;
            }
          };
        List<String> _map = ListExtensions.<JvmTypeReference, String>map(_superTypes_1, _function);
        String _join = IterableExtensions.join(_map, ", ");
        String _operator_plus = StringExtensions.operator_plus("extends ", _join);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " ");
        _xifexpression = _operator_plus_1;
      } else {
        {
          EList<JvmTypeReference> _superTypes_2 = it.getSuperTypes();
          final Function1<JvmTypeReference,Boolean> _function_1 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef) {
                String _identifier = typeRef.getIdentifier();
                boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_identifier, "java.lang.Object");
                return ((Boolean)_operator_notEquals);
              }
            };
          Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(_superTypes_2, _function_1);
          final Iterable<JvmTypeReference> withoutObject = _filter;
          final Function1<JvmTypeReference,Boolean> _function_2 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef) {
                boolean _operator_and = false;
                JvmType _type = typeRef.getType();
                if (!(_type instanceof JvmGenericType)) {
                  _operator_and = false;
                } else {
                  JvmType _type_1 = typeRef.getType();
                  boolean _isInterface_1 = ((JvmGenericType) _type_1).isInterface();
                  boolean _operator_not = BooleanExtensions.operator_not(_isInterface_1);
                  _operator_and = BooleanExtensions.operator_and((_type instanceof JvmGenericType), _operator_not);
                }
                return ((Boolean)_operator_and);
              }
            };
          Iterable<JvmTypeReference> _filter_1 = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_2);
          JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_filter_1);
          final JvmTypeReference superClazz = _head;
          final Function1<JvmTypeReference,Boolean> _function_3 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef) {
                boolean _operator_notEquals = ObjectExtensions.operator_notEquals(typeRef, superClazz);
                return ((Boolean)_operator_notEquals);
              }
            };
          Iterable<JvmTypeReference> _filter_2 = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_3);
          final Iterable<JvmTypeReference> superInterfaces = _filter_2;
          String result = "";
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(superClazz, null);
          if (_operator_notEquals) {
            String _serialize = this.serialize(superClazz, importManager);
            String _operator_plus_2 = StringExtensions.operator_plus("extends ", _serialize);
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, " ");
            result = _operator_plus_3;
          }
          boolean _isEmpty_1 = IterableExtensions.isEmpty(superInterfaces);
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
          if (_operator_not) {
            String _operator_plus_4 = StringExtensions.operator_plus(result, "implements ");
            final Function1<JvmTypeReference,String> _function_4 = new Function1<JvmTypeReference,String>() {
                public String apply(final JvmTypeReference t) {
                  String _serialize_1 = JvmModelGenerator.this.serialize(t, importManager);
                  return _serialize_1;
                }
              };
            Iterable<String> _map_1 = IterableExtensions.<JvmTypeReference, String>map(superInterfaces, _function_4);
            String _join_1 = IterableExtensions.join(_map_1, ", ");
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, _join_1);
            String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, " ");
            result = _operator_plus_6;
          }
          return result;
        }
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _generateMember(final JvmMember it, final ImportManager importManager) {
    String _operator_plus = StringExtensions.operator_plus("generateMember not implemented for elements of type ", it);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_operator_plus);
    throw _unsupportedOperationException;
  }
  
  protected CharSequence _generateMember(final JvmField it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateJavaDoc = this.generateJavaDoc(it);
    _builder.append(_generateJavaDoc, "");
    _builder.newLineIfNotEmpty();
    {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      boolean _isEmpty = _annotations.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
        CharSequence _generateAnnotations = this.generateAnnotations(_annotations_1, importManager);
        _builder.append(_generateAnnotations, "");
      }
    }
    _builder.newLineIfNotEmpty();
    CharSequence _generateModifier = this.generateModifier(it);
    _builder.append(_generateModifier, "");
    JvmTypeReference _type = it.getType();
    String _serialize = this.serialize(_type, importManager);
    _builder.append(_serialize, "");
    _builder.append(" ");
    String _simpleName = it.getSimpleName();
    _builder.append(_simpleName, "");
    CharSequence _generateInitialization = this.generateInitialization(it, importManager);
    _builder.append(_generateInitialization, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _generateMember(final JvmOperation it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateJavaDoc = this.generateJavaDoc(it);
    _builder.append(_generateJavaDoc, "");
    _builder.newLineIfNotEmpty();
    {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      boolean _isEmpty = _annotations.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
        CharSequence _generateAnnotations = this.generateAnnotations(_annotations_1, importManager);
        _builder.append(_generateAnnotations, "");
      }
    }
    _builder.newLineIfNotEmpty();
    CharSequence _generateModifier = this.generateModifier(it);
    _builder.append(_generateModifier, "");
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    CharSequence _generateTypeParameterDeclaration = this.generateTypeParameterDeclaration(_typeParameters, importManager);
    _builder.append(_generateTypeParameterDeclaration, "");
    String _xifexpression = null;
    JvmTypeReference _returnType = it.getReturnType();
    boolean _operator_equals = ObjectExtensions.operator_equals(_returnType, null);
    if (_operator_equals) {
      _xifexpression = "void";
    } else {
      JvmTypeReference _returnType_1 = it.getReturnType();
      String _serialize = this.serialize(_returnType_1, importManager);
      _xifexpression = _serialize;
    }
    _builder.append(_xifexpression, "");
    _builder.append(" ");
    String _simpleName = it.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("(");
    EList<JvmFormalParameter> _parameters = it.getParameters();
    final Function1<JvmFormalParameter,String> _function = new Function1<JvmFormalParameter,String>() {
        public String apply(final JvmFormalParameter p) {
          String _generateParameter = JvmModelGenerator.this.generateParameter(p, importManager);
          return _generateParameter;
        }
      };
    List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function);
    String _join = IterableExtensions.join(_map, ", ");
    _builder.append(_join, "");
    _builder.append(")");
    CharSequence _generateThrowsClause = this.generateThrowsClause(it, importManager);
    _builder.append(_generateThrowsClause, "");
    {
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _builder.append(";");
      } else {
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        CharSequence _generateBody = this.generateBody(it, importManager);
        _builder.append(_generateBody, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateMember(final JvmConstructor it, final ImportManager importManager) {
    CharSequence _xifexpression = null;
    boolean _operator_or = false;
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    if (_operator_not) {
      _operator_or = true;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_associatedExpression, null);
      _operator_or = BooleanExtensions.operator_or(_operator_not, _operator_notEquals);
    }
    if (_operator_or) {
      StringConcatenation _builder = new StringConcatenation();
      StringConcatenation _generateJavaDoc = this.generateJavaDoc(it);
      _builder.append(_generateJavaDoc, "");
      _builder.newLineIfNotEmpty();
      {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        boolean _isEmpty_1 = _annotations.isEmpty();
        boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
        if (_operator_not_1) {
          EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
          CharSequence _generateAnnotations = this.generateAnnotations(_annotations_1, importManager);
          _builder.append(_generateAnnotations, "");
        }
      }
      _builder.newLineIfNotEmpty();
      CharSequence _generateModifier = this.generateModifier(it);
      _builder.append(_generateModifier, "");
      _builder.append(" ");
      String _simpleName = it.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append("(");
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      final Function1<JvmFormalParameter,String> _function = new Function1<JvmFormalParameter,String>() {
          public String apply(final JvmFormalParameter p) {
            String _generateParameter = JvmModelGenerator.this.generateParameter(p, importManager);
            return _generateParameter;
          }
        };
      List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters_1, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "");
      _builder.append(")");
      CharSequence _generateThrowsClause = this.generateThrowsClause(it, importManager);
      _builder.append(_generateThrowsClause, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      CharSequence _generateBody = this.generateBody(it, importManager);
      _builder.append(_generateBody, "  ");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public CharSequence generateInitialization(final JvmField it, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      EList<Adapter> _eAdapters = it.eAdapters();
      Iterable<CompilationStrategyAdapter> _filter = IterableExtensions.<CompilationStrategyAdapter>filter(_eAdapters, org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter.class);
      CompilationStrategyAdapter _head = IterableExtensions.<CompilationStrategyAdapter>head(_filter);
      final CompilationStrategyAdapter adapter = _head;
      String _xifexpression = null;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(adapter, null);
      if (_operator_notEquals) {
        Function1<ImportManager,? extends CharSequence> _compilationStrategy = adapter.getCompilationStrategy();
        CharSequence _apply = _compilationStrategy.apply(importManager);
        String _operator_plus = StringExtensions.operator_plus(" = ", _apply);
        _xifexpression = _operator_plus;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateTypeParameterDeclaration(final List<JvmTypeParameter> typeParameters, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final JvmTypeParameter it : typeParameters) {
        if (!hasAnyElements) {
          hasAnyElements = true;
          _builder.append("<", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        CharSequence _generateTypeParameterDeclaration = this.generateTypeParameterDeclaration(it, importManager);
        _builder.append(_generateTypeParameterDeclaration, "");
      }
      if (hasAnyElements) {
        _builder.append("> ", "");
      }
    }
    return _builder;
  }
  
  public CharSequence generateTypeParameterDeclaration(final JvmTypeParameter it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _serialize = importManager.serialize(it);
    _builder.append(_serialize, "");
    CharSequence _generateTypeParameterConstraints = this.generateTypeParameterConstraints(it, importManager);
    _builder.append(_generateTypeParameterConstraints, "");
    return _builder;
  }
  
  public CharSequence generateTypeParameterConstraints(final JvmTypeParameter it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<JvmTypeConstraint> _constraints = it.getConstraints();
      Iterable<JvmUpperBound> _filter = IterableExtensions.<JvmUpperBound>filter(_constraints, org.eclipse.xtext.common.types.JvmUpperBound.class);
      boolean hasAnyElements = false;
      for(final JvmUpperBound it_1 : _filter) {
        if (!hasAnyElements) {
          hasAnyElements = true;
          _builder.append(" extends ", "");
        } else {
          _builder.appendImmediate(" & ", "");
        }
        JvmTypeReference _typeReference = it_1.getTypeReference();
        String _serialize = this.serialize(_typeReference, importManager);
        _builder.append(_serialize, "");
      }
    }
    return _builder;
  }
  
  public CharSequence generateThrowsClause(final JvmExecutable it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<JvmTypeReference> _exceptions = it.getExceptions();
      boolean hasAnyElements = false;
      for(final JvmTypeReference exc : _exceptions) {
        if (!hasAnyElements) {
          hasAnyElements = true;
          _builder.append(" throws ", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _serialize = this.serialize(exc, importManager);
        _builder.append(_serialize, "");
      }
    }
    return _builder;
  }
  
  public String generateParameter(final JvmFormalParameter it, final ImportManager importManager) {
    JvmTypeReference _parameterType = it.getParameterType();
    String _serialize = this.serialize(_parameterType, importManager);
    String _operator_plus = StringExtensions.operator_plus("final ", _serialize);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " ");
    String _simpleName = it.getSimpleName();
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _simpleName);
    return _operator_plus_2;
  }
  
  public CharSequence generateBody(final JvmExecutable op, final ImportManager importManager) {
      EList<Adapter> _eAdapters = op.eAdapters();
      Iterable<CompilationStrategyAdapter> _filter = IterableExtensions.<CompilationStrategyAdapter>filter(_eAdapters, org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter.class);
      CompilationStrategyAdapter _head = IterableExtensions.<CompilationStrategyAdapter>head(_filter);
      final CompilationStrategyAdapter adapter = _head;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(adapter, null);
      if (_operator_notEquals) {
        Function1<ImportManager,? extends CharSequence> _compilationStrategy = adapter.getCompilationStrategy();
        CharSequence _apply = _compilationStrategy.apply(importManager);
        return _apply;
      } else {
        {
          XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(op);
          final XExpression expression = _associatedExpression;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(expression, null);
          if (_operator_notEquals_1) {
            {
              StringBuilderBasedAppendable _createAppendable = this.createAppendable(op, importManager);
              final StringBuilderBasedAppendable appendable = _createAppendable;
              EList<JvmFormalParameter> _parameters = op.getParameters();
              for (final JvmFormalParameter p : _parameters) {
                String _simpleName = p.getSimpleName();
                appendable.declareVariable(p, _simpleName);
              }
              JvmTypeReference _switchResult = null;
              final JvmExecutable op_1 = op;
              boolean matched = false;
              if (!matched) {
                if (op_1 instanceof JvmOperation) {
                  final JvmOperation op_2 = (JvmOperation) op_1;
                  matched=true;
                  JvmTypeReference _returnType = op_2.getReturnType();
                  _switchResult = _returnType;
                }
              }
              if (!matched) {
                _switchResult = null;
              }
              final JvmTypeReference returnType = _switchResult;
              EList<JvmTypeReference> _exceptions = op.getExceptions();
              Set<JvmTypeReference> _set = IterableExtensions.<JvmTypeReference>toSet(_exceptions);
              this.compiler.compile(expression, appendable, returnType, _set);
              String _string = appendable.toString();
              String _removeSurroundingCurlies = this.removeSurroundingCurlies(_string);
              return _removeSurroundingCurlies;
            }
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("throw new UnsupportedOperationException(\"");
            String _simpleName_1 = op.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(" is not implemented\");");
            return _builder;
          }
        }
      }
  }
  
  public String removeSurroundingCurlies(final String code) {
      String _trim = code.trim();
      final String result = _trim;
      boolean _operator_and = false;
      boolean _startsWith = result.startsWith("{\n");
      if (!_startsWith) {
        _operator_and = false;
      } else {
        boolean _endsWith = result.endsWith("}");
        _operator_and = BooleanExtensions.operator_and(_startsWith, _endsWith);
      }
      if (_operator_and) {
        int _length = result.length();
        int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)1));
        String _substring = result.substring(2, _operator_minus);
        return _substring;
      }
      boolean _operator_and_1 = false;
      boolean _startsWith_1 = result.startsWith("{");
      if (!_startsWith_1) {
        _operator_and_1 = false;
      } else {
        boolean _endsWith_1 = result.endsWith("}");
        _operator_and_1 = BooleanExtensions.operator_and(_startsWith_1, _endsWith_1);
      }
      if (_operator_and_1) {
        int _length_1 = result.length();
        int _operator_minus_1 = IntegerExtensions.operator_minus(((Integer)_length_1), ((Integer)1));
        String _substring_1 = result.substring(1, _operator_minus_1);
        return _substring_1;
      }
      return result;
  }
  
  public StringConcatenation generateJavaDoc(final EObject it) {
    StringConcatenation _xblockexpression = null;
    {
      EList<Adapter> _eAdapters = it.eAdapters();
      Iterable<DocumentationAdapter> _filter = IterableExtensions.<DocumentationAdapter>filter(_eAdapters, org.eclipse.xtext.xbase.compiler.DocumentationAdapter.class);
      DocumentationAdapter _head = IterableExtensions.<DocumentationAdapter>head(_filter);
      final DocumentationAdapter adapter = _head;
      StringConcatenation _xifexpression = null;
      String _documentation = adapter==null?(String)null:adapter.getDocumentation();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_documentation);
      boolean _operator_not = BooleanExtensions.operator_not(_isNullOrEmpty);
      if (_operator_not) {
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("/**");
          final StringConcatenation doc = ((StringConcatenation) _builder);
          doc.newLine();
          doc.append(" * ");
          String _documentation_1 = adapter.getDocumentation();
          doc.append(_documentation_1, " * ");
          doc.newLine();
          doc.append(" */");
          doc.newLine();
          return doc;
        }
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateAnnotations(final List<JvmAnnotationReference> annotations, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      boolean _isEmpty = annotations.isEmpty();
      if (_isEmpty) {
        return null;
      }
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final JvmAnnotationReference a : annotations) {
          _builder.append("@");
          JvmAnnotationType _annotation = a.getAnnotation();
          CharSequence _serialize = importManager.serialize(_annotation);
          _builder.append(_serialize, "");
          {
            EList<JvmAnnotationValue> _values = a.getValues();
            boolean hasAnyElements = false;
            for(final JvmAnnotationValue value : _values) {
              if (!hasAnyElements) {
                hasAnyElements = true;
                _builder.append("(", "");
              } else {
                _builder.appendImmediate(", ", "");
              }
              CharSequence _java = this.toJava(value, importManager);
              _builder.append(_java, "");
            }
            if (hasAnyElements) {
              _builder.append(")", "");
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence toJava(final JvmAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      JvmOperation _operation = it.getOperation();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_operation, null);
      if (_operator_notEquals) {
        JvmOperation _operation_1 = it.getOperation();
        String _simpleName = _operation_1.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" = ");
      }
    }
    CharSequence _javaLiteral = this.toJavaLiteral(it, importManager);
    _builder.append(_javaLiteral, "");
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmAnnotationAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    CharSequence _generateAnnotations = this.generateAnnotations(_annotations, importManager);
    _builder.append(_generateAnnotations, "");
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmShortAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Short> _values = it.getValues();
      int _size = _values.size();
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
      if (_operator_equals) {
        EList<Short> _values_1 = it.getValues();
        Short _head = IterableExtensions.<Short>head(_values_1);
        _builder.append(_head, "");
      } else {
        _builder.append("{");
        EList<Short> _values_2 = it.getValues();
        String _join = IterableExtensions.join(_values_2, ",");
        _builder.append(_join, "");
        _builder.append("}");
      }
    }
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmStringAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<String> _values = it.getValues();
      int _size = _values.size();
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
      if (_operator_equals) {
        _builder.append("\"");
        EList<String> _values_1 = it.getValues();
        String _head = IterableExtensions.<String>head(_values_1);
        _builder.append(_head, "");
        _builder.append("\"");
      } else {
        _builder.append("{");
        EList<String> _values_2 = it.getValues();
        final Function1<String,String> _function = new Function1<String,String>() {
            public String apply(final String s) {
              String _operator_plus = StringExtensions.operator_plus("\"", s);
              String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\"");
              return _operator_plus_1;
            }
          };
        List<String> _map = ListExtensions.<String, String>map(_values_2, _function);
        String _join = IterableExtensions.join(_map, ",");
        _builder.append(_join, "");
        _builder.append("}");
      }
    }
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmTypeAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<JvmTypeReference> _values = it.getValues();
      int _size = _values.size();
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
      if (_operator_equals) {
        EList<JvmTypeReference> _values_1 = it.getValues();
        JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_values_1);
        String _serialize = this.serialize(_head, importManager);
        _builder.append(_serialize, "");
        _builder.append(".class");
      } else {
        _builder.append("{");
        EList<JvmTypeReference> _values_2 = it.getValues();
        final Function1<JvmTypeReference,String> _function = new Function1<JvmTypeReference,String>() {
            public String apply(final JvmTypeReference t) {
              String _serialize_1 = JvmModelGenerator.this.serialize(t, importManager);
              String _operator_plus = StringExtensions.operator_plus(_serialize_1, ".class");
              return _operator_plus;
            }
          };
        List<String> _map = ListExtensions.<JvmTypeReference, String>map(_values_2, _function);
        String _join = IterableExtensions.join(_map, ",");
        _builder.append(_join, "");
        _builder.append("}");
      }
    }
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmBooleanAnnotationValue it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Boolean> _values = it.getValues();
      int _size = _values.size();
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
      if (_operator_equals) {
        EList<Boolean> _values_1 = it.getValues();
        Boolean _head = IterableExtensions.<Boolean>head(_values_1);
        _builder.append(_head, "");
      } else {
        _builder.append("{");
        EList<Boolean> _values_2 = it.getValues();
        String _join = IterableExtensions.join(_values_2, ",");
        _builder.append(_join, "");
        _builder.append("}");
      }
    }
    return _builder;
  }
  
  protected CharSequence _toJavaLiteral(final JvmCustomAnnotationValue it, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(it, importManager);
      final StringBuilderBasedAppendable appendable = _createAppendable;
      EList<Object> _values = it.getValues();
      int _size = _values.size();
      final int __valOfSwitchOver = _size;
      boolean matched = false;
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,0)) {
          matched=true;
          appendable.append("{}");
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,1)) {
          matched=true;
          EList<Object> _values_1 = it.getValues();
          Object _head = IterableExtensions.<Object>head(_values_1);
          this.compiler.toJavaExpression(((XExpression) _head), appendable);
        }
      }
      if (!matched) {
        {
          appendable.append("{");
          EList<Object> _values_2 = it.getValues();
          Object _head_1 = IterableExtensions.<Object>head(_values_2);
          this.compiler.toJavaExpression(((XExpression) _head_1), appendable);
          EList<Object> _values_3 = it.getValues();
          Iterable<Object> _tail = IterableExtensions.<Object>tail(_values_3);
          Iterable<XExpression> _filter = IterableExtensions.<XExpression>filter(_tail, org.eclipse.xtext.xbase.XExpression.class);
          final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
              public void apply(final XExpression it) {
                {
                  appendable.append(",");
                  JvmModelGenerator.this.compiler.toJavaExpression(it, appendable);
                }
              }
            };
          IterableExtensions.<XExpression>forEach(_filter, _function);
          appendable.append("}");
        }
      }
      String _string = appendable.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String serialize(final JvmTypeReference it, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      StringBuilderBasedAppendable _createAppendable = this.createAppendable(it, importManager);
      final StringBuilderBasedAppendable appendable = _createAppendable;
      EObject _eContainer = it.eContainer();
      this.typeRefSerializer.serialize(it, _eContainer, appendable);
      String _string = appendable.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public StringBuilderBasedAppendable createAppendable(final EObject context, final ImportManager importManager) {
    StringBuilderBasedAppendable _xblockexpression = null;
    {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      JvmGenericType _containerType = this.containerType(context);
      final JvmGenericType type = _containerType;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(type, null);
      if (_operator_notEquals) {
        {
          JvmGenericType _containerType_1 = this.containerType(context);
          appendable.declareVariable(_containerType_1, "this");
          JvmGenericType _containerType_2 = this.containerType(context);
          JvmTypeReference _extendedClass = _containerType_2.getExtendedClass();
          final JvmTypeReference superType = _extendedClass;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(superType, null);
          if (_operator_notEquals_1) {
            JvmType _type = superType.getType();
            appendable.declareVariable(_type, "super");
          }
        }
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(context, null);
    if (_operator_equals) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType) context);
      } else {
        EObject _eContainer = context.eContainer();
        JvmGenericType _containerType = this.containerType(_eContainer);
        _xifexpression_1 = _containerType;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) {
    if (type instanceof JvmGenericType) {
      _internalDoGenerate((JvmGenericType)type, fsa);
    } else {
      _internalDoGenerate(type, fsa);
    }
  }
  
  public CharSequence generateModifier(final JvmMember it) {
    if (it instanceof JvmConstructor) {
      return _generateModifier((JvmConstructor)it);
    } else if (it instanceof JvmGenericType) {
      return _generateModifier((JvmGenericType)it);
    } else if (it instanceof JvmOperation) {
      return _generateModifier((JvmOperation)it);
    } else if (it instanceof JvmField) {
      return _generateModifier((JvmField)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence generateMember(final JvmMember it, final ImportManager importManager) {
    if (it instanceof JvmConstructor) {
      return _generateMember((JvmConstructor)it, importManager);
    } else if (it instanceof JvmOperation) {
      return _generateMember((JvmOperation)it, importManager);
    } else if (it instanceof JvmField) {
      return _generateMember((JvmField)it, importManager);
    } else {
      return _generateMember(it, importManager);
    }
  }
  
  public CharSequence toJavaLiteral(final JvmAnnotationValue it, final ImportManager importManager) {
    if (it instanceof JvmAnnotationAnnotationValue) {
      return _toJavaLiteral((JvmAnnotationAnnotationValue)it, importManager);
    } else if (it instanceof JvmBooleanAnnotationValue) {
      return _toJavaLiteral((JvmBooleanAnnotationValue)it, importManager);
    } else if (it instanceof JvmCustomAnnotationValue) {
      return _toJavaLiteral((JvmCustomAnnotationValue)it, importManager);
    } else if (it instanceof JvmShortAnnotationValue) {
      return _toJavaLiteral((JvmShortAnnotationValue)it, importManager);
    } else if (it instanceof JvmStringAnnotationValue) {
      return _toJavaLiteral((JvmStringAnnotationValue)it, importManager);
    } else if (it instanceof JvmTypeAnnotationValue) {
      return _toJavaLiteral((JvmTypeAnnotationValue)it, importManager);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, importManager).toString());
    }
  }
}
