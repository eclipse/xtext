package org.eclipse.xtext.purexbase.generator;

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
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PureXbaseGenerator implements IGenerator {
  private final PureXbaseGenerator _this = this;
  @com.google.inject.Inject private XbaseCompiler compiler;
  @com.google.inject.Inject private TypeReferences typeReferences;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    String _name = _this.name(resource);
    String _operator_plus = StringExtensions.operator_plus(_name, ".java");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.head(_contents);
    StringConcatenation _generateMain = _this.generateMain(((org.eclipse.xtext.purexbase.pureXbase.Model) _head));
    fsa.generateFile(_operator_plus, _generateMain);
  }
  
  public String name(final Resource res) {
    {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      final String s = _lastSegment;
      int _length = s.length();
      int _length_1 = ".xbase".length();
      int _operator_minus = IntegerExtensions.operator_minus(_length, ((Number)_length_1));
      String _substring = s.substring(0, _operator_minus);
      return _substring;
    }
  }
  
  public StringConcatenation generateMain(final Model m) {
    StringConcatenation _xblockexpression = null;
    {
      final ImportManager impMnr = new ImportManager(true);
      final StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(impMnr);
      XbaseCompiler _compiler = _this.compiler;
      XBlockExpression _block = m.getBlock();
      final StringBuilderBasedAppendable typeConverted_appendable = (StringBuilderBasedAppendable)appendable;
      TypeReferences _typeReferences = _this.typeReferences;
      final Model typeConverted_m = (Model)m;
      JvmTypeReference _typeForName = _typeReferences.getTypeForName("void", typeConverted_m);
      _compiler.compile(_block, typeConverted_appendable, _typeForName);
      StringConcatenation builder = new StringConcatenation();
      builder.append("\uFFFDimpMnr.imports.map(e|\'import \'+e+\';\\n\').elementsToString(\"\")\uFFFD");
      builder.newLine();
      builder.newLine();
      builder.append("@SuppressWarnings(\"all\")");
      builder.newLine();
      builder.append("public class \uFFFDm.eResource.name\uFFFD {");
      builder.newLine();
      builder.append("\t");
      builder.append("public static void main(String[] args) {");
      builder.newLine();
      builder.append("\t\t");
      builder.append("\uFFFDappendable\uFFFD");
      builder.newLine();
      builder.append("\t");
      builder.append("}");
      builder.newLine();
      builder.append("}");
      builder.newLine();
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
}