package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  private Naming naming;
  
  public String getName(final Grammar grammar, final String prefix, final String component) {
    String _basePackageRuntime = this.naming.basePackageRuntime(grammar);
    String _operator_plus = StringExtensions.operator_plus(_basePackageRuntime, ".serializer.");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, prefix);
    String _name = grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _simpleName);
    String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, component);
    return _operator_plus_3;
  }
  
  public String getQualifiedName() {
    String _qualifiedName = this.getQualifiedName(this.grammar);
    return _qualifiedName;
  }
  
  public String getQualifiedName(final Grammar grammar) {
    return null;
  }
  
  public String getPackageName() {
    String _qualifiedName = this.getQualifiedName();
    String _packageName = this.naming.toPackageName(_qualifiedName);
    return _packageName;
  }
  
  public String getSimpleName() {
    String _qualifiedName = this.getQualifiedName();
    String _simpleName = this.naming.toSimpleName(_qualifiedName);
    return _simpleName;
  }
  
  public String getSimpleName(final Grammar grammar) {
    String _qualifiedName = this.getQualifiedName(grammar);
    String _simpleName = this.naming.toSimpleName(_qualifiedName);
    return _simpleName;
  }
  
  public String getFileName() {
    String _qualifiedName = this.getQualifiedName();
    String _asPath = this.naming.asPath(_qualifiedName);
    String _operator_plus = StringExtensions.operator_plus(_asPath, ".");
    String _fileExtension = this.getFileExtension();
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _fileExtension);
    return _operator_plus_1;
  }
  
  public String getFileExtension() {
    return "java";
  }
  
  public CharSequence getFileContents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<not implemented>");
    _builder.newLine();
    return _builder;
  }
}
