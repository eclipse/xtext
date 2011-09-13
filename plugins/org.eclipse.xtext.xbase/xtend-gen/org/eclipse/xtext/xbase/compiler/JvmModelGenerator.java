package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.jvmmodel.IExpressionContextProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  
  @Inject
  private IExpressionContextProvider _iExpressionContextProvider0;
  
  @Inject
  private XbaseCompiler compiler;
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) throws UnsupportedOperationException {
    EList<EObject> _contents = input.getContents();
    for (final EObject obj : _contents) {
      this.internalDoGenerate(obj, fsa);
    }
  }
  
  protected void _internalDoGenerate(final EObject obj, final IFileSystemAccess fsa) {
  }
  
  protected void _internalDoGenerate(final JvmGenericType type, final IFileSystemAccess fsa) throws UnsupportedOperationException {
    {
      String _qualifiedName = type.getQualifiedName();
      ImportManager _importManager = new ImportManager(true, _qualifiedName);
      final ImportManager importManager = _importManager;
      StringConcatenation _generateBody = this.generateBody(type, importManager);
      final StringConcatenation typeBody = _generateBody;
      String _qualifiedName_1 = type.getQualifiedName();
      String _replace = _qualifiedName_1.replace(".", "/");
      String _operator_plus = StringExtensions.operator_plus(_replace, ".java");
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
      List<String> _imports = importManager.getImports();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String i) {
            String _operator_plus_1 = StringExtensions.operator_plus("import ", i);
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ";");
            return _operator_plus_2;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_imports, _function);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(typeBody, "");
      _builder.newLineIfNotEmpty();
      fsa.generateFile(_operator_plus, _builder);
    }
  }
  
  public StringConcatenation generateBody(final JvmGenericType type, final ImportManager importManager) throws UnsupportedOperationException {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateModifier = this.generateModifier(type);
    _builder.append(_generateModifier, "");
    {
      boolean _isInterface = type.isInterface();
      if (_isInterface) {
        _builder.append("interface");} else {
        _builder.append("class");
      }
    }
    _builder.append(" ");
    String _simpleName = type.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(" ");
    String _generateExtendsClause = this.generateExtendsClause(type, importManager);
    _builder.append(_generateExtendsClause, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<JvmMember> _members = type.getMembers();
      for(final JvmMember m : _members) {
        _builder.append("\t");
        CharSequence _generateMember = this.generateMember(m, importManager);
        _builder.append(_generateMember, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected StringConcatenation _generateModifier(final JvmGenericType it) {
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
  
  protected StringConcatenation _generateModifier(final JvmField it) {
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
  
  protected StringConcatenation _generateModifier(final JvmOperation it) {
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
  
  public String javaName(final JvmVisibility visibility) {
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(visibility, null);
    if (_operator_notEquals) {
      String _switchResult = null;
      final JvmVisibility visibility_1 = visibility;
      boolean matched = false;
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PRIVATE)) {
          matched=true;
          _switchResult = "private ";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PUBLIC)) {
          matched=true;
          _switchResult = "public ";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(visibility_1,JvmVisibility.PROTECTED)) {
          matched=true;
          _switchResult = "protected ";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(visibility_1,JvmVisibility.DEFAULT)) {
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
        final Function1<JvmTypeReference,CharSequence> _function = new Function1<JvmTypeReference,CharSequence>() {
            public CharSequence apply(final JvmTypeReference t) {
              CharSequence _serialize = importManager.serialize(t);
              return _serialize;
            }
          };
        List<CharSequence> _map = ListExtensions.<JvmTypeReference, CharSequence>map(_superTypes_1, _function);
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
              public Boolean apply(final JvmTypeReference typeRef_1) {
                boolean _operator_and = false;
                JvmType _type = typeRef_1.getType();
                if (!(_type instanceof org.eclipse.xtext.common.types.JvmGenericType)) {
                  _operator_and = false;
                } else {
                  JvmType _type_1 = typeRef_1.getType();
                  boolean _isInterface_1 = ((JvmGenericType) _type_1).isInterface();
                  boolean _operator_not = BooleanExtensions.operator_not(_isInterface_1);
                  _operator_and = BooleanExtensions.operator_and((_type instanceof org.eclipse.xtext.common.types.JvmGenericType), _operator_not);
                }
                return ((Boolean)_operator_and);
              }
            };
          Iterable<JvmTypeReference> _filter_1 = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_2);
          JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_filter_1);
          final JvmTypeReference superClazz = _head;
          final Function1<JvmTypeReference,Boolean> _function_3 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef_2) {
                boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(typeRef_2, superClazz);
                return ((Boolean)_operator_notEquals_1);
              }
            };
          Iterable<JvmTypeReference> _filter_2 = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_3);
          final Iterable<JvmTypeReference> superInterfaces = _filter_2;
          String result = "";
          EList<JvmTypeReference> _superTypes_3 = it.getSuperTypes();
          String _string = _superTypes_3.toString();
          String _operator_plus_2 = StringExtensions.operator_plus(_string, " / ");
          String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, superClazz);
          InputOutput.<String>println(_operator_plus_3);
          boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(superClazz, null);
          if (_operator_notEquals_2) {
            CharSequence _serialize_1 = importManager.serialize(superClazz);
            String _operator_plus_4 = StringExtensions.operator_plus("extends ", _serialize_1);
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, " ");
            result = _operator_plus_5;
          }
          boolean _isEmpty_1 = IterableExtensions.isEmpty(superInterfaces);
          boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
          if (_operator_not_1) {
            String _operator_plus_6 = StringExtensions.operator_plus(result, "implements ");
            final Function1<JvmTypeReference,CharSequence> _function_4 = new Function1<JvmTypeReference,CharSequence>() {
                public CharSequence apply(final JvmTypeReference t_1) {
                  CharSequence _serialize_2 = importManager.serialize(t_1);
                  return _serialize_2;
                }
              };
            Iterable<CharSequence> _map_1 = IterableExtensions.<JvmTypeReference, CharSequence>map(superInterfaces, _function_4);
            String _join_1 = IterableExtensions.join(_map_1, ", ");
            String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, _join_1);
            String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, " ");
            result = _operator_plus_8;
          }
          return result;
        }
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _generateMember(final JvmMember it, final ImportManager importManager) throws UnsupportedOperationException {
    String _operator_plus = StringExtensions.operator_plus("generateMember not implemented for elements of type ", it);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_operator_plus);
    throw _unsupportedOperationException;
  }
  
  protected CharSequence _generateMember(final JvmField it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateModifier = this.generateModifier(it);
    _builder.append(_generateModifier, "");
    JvmTypeReference _type = it.getType();
    CharSequence _serialize = importManager.serialize(_type);
    _builder.append(_serialize, "");
    _builder.append(" ");
    String _simpleName = it.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _generateMember(final JvmOperation it, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _generateModifier = this.generateModifier(it);
    _builder.append(_generateModifier, "");
    CharSequence _xifexpression = null;
    JvmTypeReference _returnType = it.getReturnType();
    boolean _operator_equals = ObjectExtensions.operator_equals(_returnType, null);
    if (_operator_equals) {
      _xifexpression = "void";
    } else {
      JvmTypeReference _returnType_1 = it.getReturnType();
      CharSequence _serialize = importManager.serialize(_returnType_1);
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
    {
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _builder.append(";");} else {
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generateBody = this.generateBody(it, importManager);
        String _string = _generateBody.toString();
        String _trim = _string.trim();
        _builder.append(_trim, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String generateParameter(final JvmFormalParameter it, final ImportManager importManager) {
    JvmTypeReference _parameterType = it.getParameterType();
    CharSequence _serialize = importManager.serialize(_parameterType);
    String _string = _serialize.toString();
    String _operator_plus = StringExtensions.operator_plus(_string, " ");
    String _simpleName = it.getSimpleName();
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _simpleName);
    return _operator_plus_1;
  }
  
  public CharSequence generateBody(final JvmOperation op, final ImportManager importManager) {
    {
      EList<Adapter> _eAdapters = op.eAdapters();
      Iterable<CompilationStrategyAdapter> _filter = IterableExtensions.<CompilationStrategyAdapter>filter(_eAdapters, org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter.class);
      CompilationStrategyAdapter _head = IterableExtensions.<CompilationStrategyAdapter>head(_filter);
      final CompilationStrategyAdapter adapter = _head;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(adapter, null);
      if (_operator_notEquals) {
        Function1<ImportManager,CharSequence> _compilationStrategy = adapter.getCompilationStrategy();
        CharSequence _apply = _compilationStrategy.apply(importManager);
        return _apply;
      } else {
        {
          XExpression _associatedExpression = this._iExpressionContextProvider0.getAssociatedExpression(op);
          final XExpression expression = _associatedExpression;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(expression, null);
          if (_operator_notEquals_1) {
            {
              StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
              final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
              JvmDeclaredType _declaringType = op.getDeclaringType();
              appendable.declareVariable(_declaringType, "this");
              JvmTypeReference _returnType = op.getReturnType();
              this.compiler.compile(expression, appendable, _returnType);
              String _string = appendable.toString();
              return _string;
            }
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("throw new UnsupportedOperationException(\"");
            String _simpleName = op.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" is not implemented\");");
            return _builder;
          }
        }
      }
    }
  }
  
  public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) throws UnsupportedOperationException {
    if ((type instanceof JvmGenericType)
         && (fsa instanceof IFileSystemAccess)) {
      _internalDoGenerate((JvmGenericType)type, (IFileSystemAccess)fsa);
    } else if ((type instanceof EObject)
         && (fsa instanceof IFileSystemAccess)) {
      _internalDoGenerate((EObject)type, (IFileSystemAccess)fsa);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(type, fsa).toString());
    }
  }
  
  public StringConcatenation generateModifier(final JvmMember it) {
    if ((it instanceof JvmGenericType)) {
      return _generateModifier((JvmGenericType)it);
    } else if ((it instanceof JvmOperation)) {
      return _generateModifier((JvmOperation)it);
    } else if ((it instanceof JvmField)) {
      return _generateModifier((JvmField)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence generateMember(final JvmMember it, final ImportManager importManager) throws UnsupportedOperationException {
    if ((it instanceof JvmOperation)
         && (importManager instanceof ImportManager)) {
      return _generateMember((JvmOperation)it, (ImportManager)importManager);
    } else if ((it instanceof JvmField)
         && (importManager instanceof ImportManager)) {
      return _generateMember((JvmField)it, (ImportManager)importManager);
    } else if ((it instanceof JvmMember)
         && (importManager instanceof ImportManager)) {
      return _generateMember((JvmMember)it, (ImportManager)importManager);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(it, importManager).toString());
    }
  }
}