package org.eclipse.xtext.purexbase.generator;

import com.google.inject.Inject;
import java.util.Collection;
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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer.ExitPoint;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PureXbaseGenerator implements IGenerator {
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private TypeReferences typeReferences;
  
  @Inject
  private IEarlyExitComputer computer;
  
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
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)_length_1));
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
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName("void", m);
      this.compiler.compile(_block, appendable, _typeForName);
      StringConcatenation _xifexpression = null;
      XBlockExpression _block_1 = m.getBlock();
      boolean _containsReturn = this.containsReturn(_block_1);
      if (_containsReturn) {
        StringConcatenation _builder = new StringConcatenation();
        List<String> _imports = impMnr.getImports();
        final Function1<String,String> _function = new Function1<String,String>() {
            public String apply(final String e) {
              String _operator_plus = StringExtensions.operator_plus("import ", e);
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
        Resource _eResource = m.eResource();
        String _name = this.name(_eResource);
        _builder.append(_name, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public static void main(String[] args) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("xbaseExpression();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} catch (Throwable t) {}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static Object xbaseExpression() throws Throwable {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (Boolean.TRUE) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(appendable, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        List<String> _imports_1 = impMnr.getImports();
        final Function1<String,String> _function_1 = new Function1<String,String>() {
            public String apply(final String e_1) {
              String _operator_plus_2 = StringExtensions.operator_plus("import ", e_1);
              String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ";\n");
              return _operator_plus_3;
            }
          };
        List<String> _map_1 = ListExtensions.<String, String>map(_imports_1, _function_1);
        String _join_1 = IterableExtensions.join(_map_1);
        _builder_1.append(_join_1, "");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class ");
        Resource _eResource_1 = m.eResource();
        String _name_1 = this.name(_eResource_1);
        _builder_1.append(_name_1, "");
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("public static void main(String[] args) {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("try {");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append(appendable, "			");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t");
        _builder_1.append("} catch (Throwable t) {}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _xifexpression = _builder_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public boolean containsReturn(final XExpression expr) {
    {
      Collection<ExitPoint> _exitPoints = this.computer.getExitPoints(expr);
      final Collection<ExitPoint> exitPoints = _exitPoints;
      for (final ExitPoint point : exitPoints) {
        XExpression _expression = point.getExpression();
        if ((_expression instanceof org.eclipse.xtext.xbase.XReturnExpression)) {
          return true;
        }
      }
      return false;
    }
  }
}