package org.eclipse.xtext.example.domainmodel.generator;

import com.google.inject.Inject;
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
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DomainmodelGenerator implements IGenerator {
  @Inject private GeneratorExtensions generatorExtensions;
  @Inject private DomainmodelCompiler domainmodelCompiler;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
    for (EObject element : _allContentsIterable) {
      if ((element instanceof org.eclipse.xtext.example.domainmodel.domainmodel.Entity)) {
        {
          final Entity entity = ((org.eclipse.xtext.example.domainmodel.domainmodel.Entity) element);
          String _fileName = this.generatorExtensions.fileName(entity);
          StringConcatenation _compile = this.compile(entity);
          fsa.generateFile(_fileName, _compile);
        }
      }
    }
  }
  
  public StringConcatenation compile(final Entity e) {
    StringConcatenation _xblockexpression = null;
    {
      ImportManager _importManager = new ImportManager(true);
      final ImportManager importManager = _importManager;
      StringConcatenation _body = this.body(e, importManager);
      final StringConcatenation body = _body;
      StringConcatenation _builder = new StringConcatenation();
      {
        final Entity typeConverted_e = (Entity)e;
        String _packageName = this.generatorExtensions.packageName(typeConverted_e);
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_packageName);
        boolean _operator_not = BooleanExtensions.operator_not(_isNullOrEmpty);
        if (_operator_not) {
          _builder.append("package ");
          final Entity typeConverted_e_1 = (Entity)e;
          String _packageName_1 = this.generatorExtensions.packageName(typeConverted_e_1);
          _builder.append(_packageName_1, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      {
        List<String> _imports = importManager.getImports();
        for(String i : _imports) {
          _builder.append("import ");
          _builder.append(i, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append(body, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation body(final Entity e, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _superTypeClause = this.superTypeClause(e, importManager);
    _builder.append(_superTypeClause, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      EList<Feature> _features = e.getFeatures();
      for(Feature f : _features) {
        _builder.append("\t");
        StringConcatenation _feature = this.feature(f, importManager);
        _builder.append(_feature, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String superTypeClause(final Entity e, final ImportManager importManager) {
    String _xifexpression = null;
    JvmParameterizedTypeReference _superType = e.getSuperType();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superType, null);
    if (_operator_notEquals) {
      String _xifexpression_1 = null;
      JvmParameterizedTypeReference _superType_1 = e.getSuperType();
      JvmType _type = _superType_1.getType();
      boolean _isInterface = ((org.eclipse.xtext.common.types.JvmGenericType) _type).isInterface();
      if (_isInterface) {
        _xifexpression_1 = "implements ";
      } else {
        _xifexpression_1 = "extends ";
      }
      JvmParameterizedTypeReference _superType_2 = e.getSuperType();
      String _shortName = this.generatorExtensions.shortName(_superType_2, importManager);
      String _operator_plus = StringExtensions.operator_plus(_xifexpression_1, _shortName);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " ");
      _xifexpression = _operator_plus_1;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public StringConcatenation _feature(final Property p, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    final Property typeConverted_p = (Property)p;
    JvmParameterizedTypeReference _type = typeConverted_p.getType();
    String _shortName = this.generatorExtensions.shortName(_type, importManager);
    _builder.append(_shortName, "");
    _builder.append(" ");
    final Property typeConverted_p_1 = (Property)p;
    String _name = typeConverted_p_1.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    final Property typeConverted_p_2 = (Property)p;
    JvmParameterizedTypeReference _type_1 = typeConverted_p_2.getType();
    String _shortName_1 = this.generatorExtensions.shortName(_type_1, importManager);
    _builder.append(_shortName_1, "");
    _builder.append(" get");
    final Property typeConverted_p_3 = (Property)p;
    String _name_1 = typeConverted_p_3.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    final Property typeConverted_p_4 = (Property)p;
    String _name_2 = typeConverted_p_4.getName();
    _builder.append(_name_2, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void set");
    final Property typeConverted_p_5 = (Property)p;
    String _name_3 = typeConverted_p_5.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_1, "");
    _builder.append("(");
    final Property typeConverted_p_6 = (Property)p;
    JvmParameterizedTypeReference _type_2 = typeConverted_p_6.getType();
    String _shortName_2 = this.generatorExtensions.shortName(_type_2, importManager);
    _builder.append(_shortName_2, "");
    _builder.append(" ");
    final Property typeConverted_p_7 = (Property)p;
    String _name_4 = typeConverted_p_7.getName();
    _builder.append(_name_4, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    final Property typeConverted_p_8 = (Property)p;
    String _name_5 = typeConverted_p_8.getName();
    _builder.append(_name_5, "	");
    _builder.append(" = ");
    final Property typeConverted_p_9 = (Property)p;
    String _name_6 = typeConverted_p_9.getName();
    _builder.append(_name_6, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation _feature(final Operation o, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    final Operation typeConverted_o = (Operation)o;
    JvmParameterizedTypeReference _type = typeConverted_o.getType();
    String _shortName = this.generatorExtensions.shortName(_type, importManager);
    _builder.append(_shortName, "");
    _builder.append(" ");
    final Operation typeConverted_o_1 = (Operation)o;
    String _name = typeConverted_o_1.getName();
    _builder.append(_name, "");
    _builder.append("(");
    String _parameterList = this.generatorExtensions.parameterList(o, importManager);
    _builder.append(_parameterList, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _compile = this.domainmodelCompiler.compile(o, importManager);
    _builder.append(_compile, "	");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation feature(final Feature o, final ImportManager importManager) {
    if ((o instanceof Operation)
         && (importManager instanceof ImportManager)) {
      return _feature((Operation)o, (ImportManager)importManager);
    } else if ((o instanceof Property)
         && (importManager instanceof ImportManager)) {
      return _feature((Property)o, (ImportManager)importManager);
    } else {
      throw new IllegalArgumentException();
    }
  }
}