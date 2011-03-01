package org.eclipse.xtext.example.domainmodel.compiler;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.compiler.CompilerExtensions;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DomainmodelCompiler {
  private final DomainmodelCompiler _this = this;
  @com.google.inject.Inject private CompilerExtensions compilerExtensions;
  @com.google.inject.Inject private XbaseCompiler xbaseCompiler;
  
  public StringConcatenation compile(final Entity e) {
    StringConcatenation _xblockexpression = null;
    {
      final ImportManager importManager = new ImportManager(true);
      StringConcatenation _body = _this.body(e, importManager);
      final StringConcatenation body = _body;
      StringConcatenation builder = new StringConcatenation();
      builder.append("package ");
      CompilerExtensions _compilerExtensions = compilerExtensions;
      final Entity final_e = (Entity)e;
      String _packageName = _compilerExtensions.packageName(final_e);
      builder.append(_packageName, "");
      builder.append(";");
      builder.newLineIfNotEmpty();
      builder.newLine();
      {
        List<String> _imports = importManager.getImports();
        for(java.lang.String i : _imports) {
          builder.newLineIfNotEmpty();
          builder.append("import ");
          builder.append(i, "");
          builder.append(";");
          builder.newLineIfNotEmpty();
        }
      }
      builder.newLineIfNotEmpty();
      builder.newLine();
      builder.append(body, "");
      builder.newLineIfNotEmpty();
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation body(final Entity e, final ImportManager importManager) {
    StringConcatenation builder = new StringConcatenation();
    builder.append("public class ");
    String _name = e.getName();
    builder.append(_name, "");
    builder.append(" ");
    String _superTypeClause = _this.superTypeClause(e, importManager);
    builder.append(_superTypeClause, "");
    builder.append("{");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    {
      EList<Feature> _features = e.getFeatures();
      for(org.eclipse.xtext.example.domainmodel.domainmodel.Feature f : _features) {
        builder.newLineIfNotEmpty();
        builder.append("\t");
        StringConcatenation _feature = _this.feature(f, importManager);
        builder.append(_feature, "	");
        builder.newLineIfNotEmpty();
        builder.append("\t");
        builder.newLine();
        builder.append("\t");
      }
    }
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    return builder;
  }
  
  public String superTypeClause(final Entity e, final ImportManager importManager) {
    String _xifexpression = null;
    JvmParameterizedTypeReference _superType = e.getSuperType();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superType, null);
    if (((Boolean)_operator_notEquals)) {
      String _xifexpression_1 = null;
      JvmParameterizedTypeReference _superType_1 = e.getSuperType();
      JvmType _type = _superType_1.getType();
      boolean _isInterface = ((org.eclipse.xtext.common.types.JvmGenericType) _type).isInterface();
      if (((Boolean)_isInterface)) {
        _xifexpression_1 = "implements ";
      } else {
        _xifexpression_1 = "extends ";
      }
      CompilerExtensions _compilerExtensions = compilerExtensions;
      JvmParameterizedTypeReference _superType_2 = e.getSuperType();
      String _shortName = _compilerExtensions.shortName(_superType_2, importManager);
      String _operator_plus = StringExtensions.operator_plus(_xifexpression_1, _shortName);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " ");
      _xifexpression = _operator_plus_1;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public StringConcatenation _feature(final Property p, final ImportManager importManager) {
    StringConcatenation builder = new StringConcatenation();
    builder.append("private ");
    CompilerExtensions _compilerExtensions = compilerExtensions;
    final Property final_p = (Property)p;
    JvmParameterizedTypeReference _type = final_p.getType();
    String _shortName = _compilerExtensions.shortName(_type, importManager);
    builder.append(_shortName, "");
    builder.append(" ");
    final Property final_p_1 = (Property)p;
    String _name = final_p_1.getName();
    builder.append(_name, "");
    builder.append(";");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.newLine();
    builder.append("public ");
    CompilerExtensions _compilerExtensions_1 = compilerExtensions;
    final Property final_p_2 = (Property)p;
    JvmParameterizedTypeReference _type_1 = final_p_2.getType();
    String _shortName_1 = _compilerExtensions_1.shortName(_type_1, importManager);
    builder.append(_shortName_1, "");
    builder.append(" get");
    final Property final_p_3 = (Property)p;
    String _name_1 = final_p_3.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    builder.append(_firstUpper, "");
    builder.append("() {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.append("return ");
    final Property final_p_4 = (Property)p;
    String _name_2 = final_p_4.getName();
    builder.append(_name_2, "	");
    builder.append(";");
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    builder.newLine();
    builder.append("public void set");
    final Property final_p_5 = (Property)p;
    String _name_3 = final_p_5.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
    builder.append(_firstUpper_1, "");
    builder.append("(");
    CompilerExtensions _compilerExtensions_2 = compilerExtensions;
    final Property final_p_6 = (Property)p;
    JvmParameterizedTypeReference _type_2 = final_p_6.getType();
    String _shortName_2 = _compilerExtensions_2.shortName(_type_2, importManager);
    builder.append(_shortName_2, "");
    builder.append(" ");
    final Property final_p_7 = (Property)p;
    String _name_4 = final_p_7.getName();
    builder.append(_name_4, "");
    builder.append(") {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.append("this.");
    final Property final_p_8 = (Property)p;
    String _name_5 = final_p_8.getName();
    builder.append(_name_5, "	");
    builder.append(" = ");
    final Property final_p_9 = (Property)p;
    String _name_6 = final_p_9.getName();
    builder.append(_name_6, "	");
    builder.append(";");
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    return builder;
  }
  
  public StringConcatenation _feature(final Operation o, final ImportManager importManager) {
    StringConcatenation builder = new StringConcatenation();
    builder.append("public ");
    CompilerExtensions _compilerExtensions = compilerExtensions;
    final Operation final_o = (Operation)o;
    JvmParameterizedTypeReference _type = final_o.getType();
    String _shortName = _compilerExtensions.shortName(_type, importManager);
    builder.append(_shortName, "");
    builder.append(" ");
    final Operation final_o_1 = (Operation)o;
    String _name = final_o_1.getName();
    builder.append(_name, "");
    builder.append("(");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    {
      EList<JvmFormalParameter> _params = o.getParams();
      for(org.eclipse.xtext.common.types.JvmFormalParameter p : _params) {
        CompilerExtensions _compilerExtensions_1 = compilerExtensions;
        JvmTypeReference _parameterType = p.getParameterType();
        String _shortName_1 = _compilerExtensions_1.shortName(_parameterType, importManager);
        builder.append(_shortName_1, "	");
        builder.append(" ");
        String _name_1 = p.getName();
        builder.append(_name_1, "	");
      }
    }
    builder.append(") {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.append("// now it becomes interesting");
    builder.newLine();
    builder.append("\t");
    String _body = _this.body(o, importManager);
    builder.append(_body, "	");
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    return builder;
  }
  
  public String body(final Operation o, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      final StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
      XbaseCompiler _xbaseCompiler = _this.xbaseCompiler;
      XExpression _body = o.getBody();
      final StringBuilderBasedAppendable final_appendable = (StringBuilderBasedAppendable)appendable;
      final Operation final_o = (Operation)o;
      JvmParameterizedTypeReference _type = final_o.getType();
      _xbaseCompiler.compile(_body, final_appendable, _type);
      String _string = appendable.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation feature(final Feature p, final ImportManager importManager) {
    if ((p instanceof Operation)
         && (importManager instanceof ImportManager)) {
      return _feature((Operation)p, (ImportManager)importManager);
    } else if ((p instanceof Property)
         && (importManager instanceof ImportManager)) {
      return _feature((Property)p, (ImportManager)importManager);
    } else {
      throw new IllegalArgumentException();
    }
  }
}