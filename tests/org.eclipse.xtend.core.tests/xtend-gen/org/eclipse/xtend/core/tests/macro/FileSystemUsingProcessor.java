package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class FileSystemUsingProcessor extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    CompilationUnit _compilationUnit = annotatedClass.getCompilationUnit();
    final Path path = _compilationUnit.getFilePath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Path \"");
    String _string = path.toString();
    _builder.append(_string, "");
    _builder.append("\" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("exists: ");
    boolean _exists = context.exists(path);
    _builder.append(_exists, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("isFolder: ");
    boolean _isFolder = context.isFolder(path);
    _builder.append(_isFolder, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("isFile: ");
    boolean _isFile = context.isFile(path);
    _builder.append(_isFile, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.append("sourceFolder : ");
    Path _sourceFolder = context.getSourceFolder(path);
    _builder.append(_sourceFolder, "");
    _builder.newLineIfNotEmpty();
    _builder.append("targetFolder : ");
    Path _targetFolder = context.getTargetFolder(path);
    _builder.append(_targetFolder, "");
    _builder.newLineIfNotEmpty();
    _builder.append("projectFolder: ");
    Path _projectFolder = context.getProjectFolder(path);
    _builder.append(_projectFolder, "");
    _builder.newLineIfNotEmpty();
    annotatedClass.setDocComment(_builder.toString());
  }
}
