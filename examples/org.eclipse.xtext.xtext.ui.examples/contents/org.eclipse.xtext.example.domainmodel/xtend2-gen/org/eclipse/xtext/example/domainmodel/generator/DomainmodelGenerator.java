package org.eclipse.xtext.example.domainmodel.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.generator.DomainmodelCompiler;
import org.eclipse.xtext.example.domainmodel.generator.GeneratorExtensions;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DomainmodelGenerator implements IGenerator {
  private final DomainmodelGenerator _this = this;
  @com.google.inject.Inject private GeneratorExtensions generatorExtensions;
  @com.google.inject.Inject private DomainmodelCompiler domainmodelCompiler;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
    for (EObject element : _allContentsIterable) {
      if ((element instanceof org.eclipse.xtext.example.domainmodel.domainmodel.Entity)) {
        {
          final Entity entity = ((org.eclipse.xtext.example.domainmodel.domainmodel.Entity) element);
          GeneratorExtensions _generatorExtensions = generatorExtensions;
          String _fileName = _generatorExtensions.fileName(entity);
          StringConcatenation _compile = _this.compile(entity);
          fsa.generateFile(_fileName, _compile);
        }
      }
    }
  }
  
  public StringConcatenation compile(final Entity e) {
    StringConcatenation _xblockexpression = null;
    {
      final ImportManager importManager = new ImportManager(true);
      StringConcatenation _body = _this.body(e, importManager);
      final StringConcatenation body = _body;
      StringConcatenation builder = new StringConcatenation();
      builder.append("package ");
      GeneratorExtensions _generatorExtensions = generatorExtensions;
      final Entity typeConverted_e = (Entity)e;
      String _packageName = _generatorExtensions.packageName(typeConverted_e);
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
      GeneratorExtensions _generatorExtensions = generatorExtensions;
      JvmParameterizedTypeReference _superType_2 = e.getSuperType();
      String _shortName = _generatorExtensions.shortName(_superType_2, importManager);
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
    GeneratorExtensions _generatorExtensions = generatorExtensions;
    final Property typeConverted_p = (Property)p;
    JvmParameterizedTypeReference _type = typeConverted_p.getType();
    String _shortName = _generatorExtensions.shortName(_type, importManager);
    builder.append(_shortName, "");
    builder.append(" ");
    final Property typeConverted_p_1 = (Property)p;
    String _name = typeConverted_p_1.getName();
    builder.append(_name, "");
    builder.append(";");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.newLine();
    builder.append("public ");
    GeneratorExtensions _generatorExtensions_1 = generatorExtensions;
    final Property typeConverted_p_2 = (Property)p;
    JvmParameterizedTypeReference _type_1 = typeConverted_p_2.getType();
    String _shortName_1 = _generatorExtensions_1.shortName(_type_1, importManager);
    builder.append(_shortName_1, "");
    builder.append(" get");
    final Property typeConverted_p_3 = (Property)p;
    String _name_1 = typeConverted_p_3.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    builder.append(_firstUpper, "");
    builder.append("() {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.append("return ");
    final Property typeConverted_p_4 = (Property)p;
    String _name_2 = typeConverted_p_4.getName();
    builder.append(_name_2, "	");
    builder.append(";");
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    builder.newLine();
    builder.append("public void set");
    final Property typeConverted_p_5 = (Property)p;
    String _name_3 = typeConverted_p_5.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
    builder.append(_firstUpper_1, "");
    builder.append("(");
    GeneratorExtensions _generatorExtensions_2 = generatorExtensions;
    final Property typeConverted_p_6 = (Property)p;
    JvmParameterizedTypeReference _type_2 = typeConverted_p_6.getType();
    String _shortName_2 = _generatorExtensions_2.shortName(_type_2, importManager);
    builder.append(_shortName_2, "");
    builder.append(" ");
    final Property typeConverted_p_7 = (Property)p;
    String _name_4 = typeConverted_p_7.getName();
    builder.append(_name_4, "");
    builder.append(") {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    builder.append("this.");
    final Property typeConverted_p_8 = (Property)p;
    String _name_5 = typeConverted_p_8.getName();
    builder.append(_name_5, "	");
    builder.append(" = ");
    final Property typeConverted_p_9 = (Property)p;
    String _name_6 = typeConverted_p_9.getName();
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
    GeneratorExtensions _generatorExtensions = generatorExtensions;
    final Operation typeConverted_o = (Operation)o;
    JvmParameterizedTypeReference _type = typeConverted_o.getType();
    String _shortName = _generatorExtensions.shortName(_type, importManager);
    builder.append(_shortName, "");
    builder.append(" ");
    final Operation typeConverted_o_1 = (Operation)o;
    String _name = typeConverted_o_1.getName();
    builder.append(_name, "");
    builder.append("(");
    GeneratorExtensions _generatorExtensions_1 = generatorExtensions;
    String _parameterList = _generatorExtensions_1.parameterList(o, importManager);
    builder.append(_parameterList, "");
    builder.append(") {");
    builder.newLineIfNotEmpty();
    builder.append("\t");
    DomainmodelCompiler _domainmodelCompiler = _this.domainmodelCompiler;
    String _compile = _domainmodelCompiler.compile(o, importManager);
    builder.append(_compile, "	");
    builder.newLineIfNotEmpty();
    builder.append("}");
    builder.newLine();
    return builder;
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