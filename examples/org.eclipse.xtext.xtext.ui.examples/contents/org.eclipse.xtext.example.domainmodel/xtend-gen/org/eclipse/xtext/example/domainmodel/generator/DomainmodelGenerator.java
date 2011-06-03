package org.eclipse.xtext.example.domainmodel.generator;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DomainmodelGenerator implements IGenerator {
  
  @Inject
  private GeneratorExtensions generatorExtensions;
  
  @Inject
  private DomainmodelCompiler domainmodelCompiler;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
    Iterable<Entity> _filter = IterableExtensions.<Entity>filter(_allContentsIterable, org.eclipse.xtext.example.domainmodel.domainmodel.Entity.class);
    for (Entity entity : _filter) {
      String _fileName = this.generatorExtensions.fileName(entity);
      StringConcatenation _compile = this.compile(entity);
      fsa.generateFile(_fileName, _compile);
    }
  }
  
  public StringConcatenation compile(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    ImportManager _importManager = new ImportManager(true);
    final ImportManager importManager = _importManager;
    _builder.newLineIfNotEmpty();
    StringConcatenation _body = this.body(e, importManager);
    final StringConcatenation body = _body;
    _builder.newLineIfNotEmpty();
    {
      String _packageName = this.generatorExtensions.packageName(e);
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_packageName);
      boolean _operator_not = BooleanExtensions.operator_not(_isNullOrEmpty);
      if (_operator_not) {
        _builder.append("package ");
        String _packageName_1 = this.generatorExtensions.packageName(e);
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
    return _builder;
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
      boolean _isInterface = this.generatorExtensions.isInterface(_superType_1);
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
  
  protected StringConcatenation _feature(final Property p, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    JvmParameterizedTypeReference _type = p.getType();
    String _shortName = this.generatorExtensions.shortName(_type, importManager);
    _builder.append(_shortName, "");
    _builder.append(" ");
    String _name = p.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    JvmParameterizedTypeReference _type_1 = p.getType();
    String _shortName_1 = this.generatorExtensions.shortName(_type_1, importManager);
    _builder.append(_shortName_1, "");
    _builder.append(" get");
    String _name_1 = p.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_2 = p.getName();
    _builder.append(_name_2, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void set");
    String _name_3 = p.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_1, "");
    _builder.append("(");
    JvmParameterizedTypeReference _type_2 = p.getType();
    String _shortName_2 = this.generatorExtensions.shortName(_type_2, importManager);
    _builder.append(_shortName_2, "");
    _builder.append(" ");
    String _name_4 = p.getName();
    _builder.append(_name_4, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_5 = p.getName();
    _builder.append(_name_5, "	");
    _builder.append(" = ");
    String _name_6 = p.getName();
    _builder.append(_name_6, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected StringConcatenation _feature(final Operation o, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    JvmParameterizedTypeReference _type = o.getType();
    String _shortName = this.generatorExtensions.shortName(_type, importManager);
    _builder.append(_shortName, "");
    _builder.append(" ");
    String _name = o.getName();
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
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(o, importManager).toString());
    }
  }
}