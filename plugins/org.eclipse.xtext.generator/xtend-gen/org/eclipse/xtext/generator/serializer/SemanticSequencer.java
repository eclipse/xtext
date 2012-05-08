package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames.GenFileName;

@SuppressWarnings("all")
public class SemanticSequencer extends GeneratedFile {
  @Inject
  private SerializerGenFileNames names;
  
  public CharSequence getFileContents(final GenFileName filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = filename.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = filename.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    GenFileName _abstractSemanticSequencer = this.names.getAbstractSemanticSequencer();
    String _simpleName_1 = _abstractSemanticSequencer.getSimpleName();
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
