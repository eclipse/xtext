package org.eclipse.xtext.purexbase.generator;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PureXbaseGenerator implements IGenerator {
  @Inject private XbaseCompiler compiler;
  @Inject private TypeReferences typeReferences;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    String _name = this.name(resource);
    String _operator_plus = StringExtensions.operator_plus(_name, ".java");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    StringConcatenation _generateMain = this.generateMain(((Model) _head));
    fsa.generateFile(_operator_plus, _generateMain);
  }
  
  public String name(final Resource res) {
    {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      final String s = _lastSegment;
      int _length = s.length();
      int _length_1 = ".xbase".length();
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Number)_length_1));
      String _substring = s.substring(0, _operator_minus);
      return _substring;
    }
  }
  
  public StringConcatenation generateMain(final Model m) {
    StringConcatenation _xblockexpression = null;
    {
      ImportManager _importManager = new ImportManager(true);
      final ImportManager impMnr = _importManager;
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(impMnr);
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      XBlockExpression _block = m.getBlock();
      final StringBuilderBasedAppendable typeConverted_appendable = (StringBuilderBasedAppendable)appendable;
      final Model typeConverted_m = (Model)m;
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName("void", typeConverted_m);
      this.compiler.compile(_block, typeConverted_appendable, _typeForName);
      StringConcatenation _builder = new StringConcatenation();
      List<String> _imports = impMnr.getImports();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(String e) {
            final String typeConverted_e = (String)e;
            String _operator_plus = StringExtensions.operator_plus("import ", typeConverted_e);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ";\n");
            return _operator_plus_1;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_imports, _function);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("public class ");
      final Model typeConverted_m_1 = (Model)m;
      Resource _eResource = typeConverted_m_1.eResource();
      String _name = this.name(_eResource);
      _builder.append(_name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("public static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(appendable, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}