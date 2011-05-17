package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.serializer.AbstractSyntacticSequencer;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class SyntacticSequencer extends GeneratedFile {
  
  @Inject
  private AbstractSyntacticSequencer sequencer;
  
  public String getQualifiedName(final Grammar grammar) {
    String _name = this.getName(grammar, "", "SyntacticSequencer");
    return _name;
  }
  
  public CharSequence getFileContents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _simpleName_1 = this.sequencer.getSimpleName();
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}