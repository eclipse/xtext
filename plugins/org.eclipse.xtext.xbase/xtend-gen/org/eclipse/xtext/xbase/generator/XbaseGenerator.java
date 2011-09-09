package org.eclipse.xtext.xbase.generator;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.jvmmodel.IExpressionContextProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XbaseGenerator implements IGenerator {
  
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
            String _operator_plus = StringExtensions.operator_plus("import ", i);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ";");
            return _operator_plus_1;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_imports, _function);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(typeBody, "");
      _builder.newLineIfNotEmpty();
      fsa.generateFile(_replace, _builder);
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
        String _operator_plus = StringExtensions.operator_plus(" extends ", _join);
        _xifexpression = _operator_plus;
      } else {
        String _xblockexpression_1 = null;
        {
          EList<JvmTypeReference> _superTypes_2 = it.getSuperTypes();
          final Function1<JvmTypeReference,Boolean> _function_1 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef) {
                boolean _operator_and = false;
                JvmType _type = typeRef.getType();
                if (!(_type instanceof org.eclipse.xtext.common.types.JvmGenericType)) {
                  _operator_and = false;
                } else {
                  JvmType _type_1 = typeRef.getType();
                  boolean _isInterface_1 = ((JvmGenericType) _type_1).isInterface();
                  _operator_and = BooleanExtensions.operator_and((_type instanceof org.eclipse.xtext.common.types.JvmGenericType), _isInterface_1);
                }
                return ((Boolean)_operator_and);
              }
            };
          Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(_superTypes_2, _function_1);
          JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_filter);
          final JvmTypeReference superClazz = _head;
          EList<JvmTypeReference> _superTypes_3 = it.getSuperTypes();
          final Function1<JvmTypeReference,Boolean> _function_2 = new Function1<JvmTypeReference,Boolean>() {
              public Boolean apply(final JvmTypeReference typeRef_1) {
                boolean _operator_notEquals = ObjectExtensions.operator_notEquals(typeRef_1, superClazz);
                return ((Boolean)_operator_notEquals);
              }
            };
          Iterable<JvmTypeReference> _filter_1 = IterableExtensions.<JvmTypeReference>filter(_superTypes_3, _function_2);
          final Iterable<JvmTypeReference> superInterfaces = _filter_1;
          String _xifexpression_1 = null;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(superClazz, null);
          if (_operator_notEquals_1) {
            CharSequence _serialize_1 = importManager.serialize(superClazz);
            String _operator_plus_1 = StringExtensions.operator_plus(" extends ", _serialize_1);
            String _xifexpression_2 = null;
            boolean _isEmpty_1 = IterableExtensions.isEmpty(superInterfaces);
            boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
            if (_operator_not) {
              final Function1<JvmTypeReference,CharSequence> _function_3 = new Function1<JvmTypeReference,CharSequence>() {
                  public CharSequence apply(final JvmTypeReference t_1) {
                    CharSequence _serialize_2 = importManager.serialize(t_1);
                    return _serialize_2;
                  }
                };
              Iterable<CharSequence> _map_1 = IterableExtensions.<JvmTypeReference, CharSequence>map(superInterfaces, _function_3);
              String _join_1 = IterableExtensions.join(_map_1, ", ");
              String _operator_plus_2 = StringExtensions.operator_plus(" implements ", _join_1);
              _xifexpression_2 = _operator_plus_2;
            }
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_1, _xifexpression_2);
            _xifexpression_1 = _operator_plus_3;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
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
          String _generateParameter = XbaseGenerator.this.generateParameter(p, importManager);
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
      XExpression _associatedExpression = this._iExpressionContextProvider0.getAssociatedExpression(op);
      final XExpression expression = _associatedExpression;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(expression, null);
      if (_operator_notEquals) {
        {
          StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
          final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
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