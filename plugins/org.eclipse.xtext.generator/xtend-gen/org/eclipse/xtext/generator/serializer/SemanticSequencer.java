package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import org.eclipse.xtext.generator.serializer.AbstractSemanticSequencer;
import org.eclipse.xtext.generator.serializer.GeneratedJavaClass;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class SemanticSequencer extends GeneratedJavaClass {
  @Inject private AbstractSemanticSequencer abstractSemanticSequencer;
  
  public String getQualifiedName() {
    String _name = this.getName("", "SemanticSequencer");
    return _name;
  }
  
  public String getFileContents() {
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
    String _simpleName_1 = this.abstractSemanticSequencer.getSimpleName();
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
}