/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Generate some code to simplify implementation of project templates.
 * 
 * <ol>
 * <li>Automatically extend AbstractProjectTemplate</li>
 * <li>Generate "messages.properties" for i18n</li>
 * <li>Generate "Messages.java" for i18n</li>
 * </ol>
 * 
 * The generated files for i18n contain the "label" and "description" of all the project templates. The files may be
 * extended manually by the user to externalize more strings. The generator then merges its own changes into the
 * existing files.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class ProjectTemplateProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    annotatedClass.setExtendedClass(context.newTypeReference(AbstractProjectTemplate.class));
  }
  
  @Override
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    final String propertyContents = this.generatePropertiesFile(annotatedClass, context);
    this.generateMessagesClass(propertyContents, annotatedClass, context);
  }
  
  private String generatePropertiesFile(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    final AnnotationReference annotation = annotatedClass.findAnnotation(context.findTypeGlobally(ProjectTemplate.class));
    final String label = this.replaceNewlines(annotation.getStringValue("label"));
    final String description = this.replaceNewlines(annotation.getStringValue("description"));
    final Path propertyFile = annotatedClass.getCompilationUnit().getFilePath().getParent().append("messages.properties");
    String propertyContents = "";
    boolean _exists = context.exists(propertyFile);
    if (_exists) {
      propertyContents = context.getContents(propertyFile).toString();
    }
    if (((propertyContents.length() > 0) && (!propertyContents.endsWith(System.lineSeparator())))) {
      String _propertyContents = propertyContents;
      String _lineSeparator = System.lineSeparator();
      propertyContents = (_propertyContents + _lineSeparator);
    }
    String _simpleName = annotatedClass.getSimpleName();
    final String labelLineStart = (_simpleName + "_Label=");
    final String labelLine = (labelLineStart + label);
    boolean _contains = propertyContents.contains(labelLineStart);
    if (_contains) {
      propertyContents = propertyContents.replaceFirst((("^(?m)" + labelLineStart) + ".*$"), labelLine);
    } else {
      String _propertyContents_1 = propertyContents;
      String _lineSeparator_1 = System.lineSeparator();
      String _plus = (labelLine + _lineSeparator_1);
      propertyContents = (_propertyContents_1 + _plus);
    }
    String _simpleName_1 = annotatedClass.getSimpleName();
    final String descriptionLineStart = (_simpleName_1 + "_Description=");
    final String descriptionLine = (descriptionLineStart + description);
    boolean _contains_1 = propertyContents.contains(descriptionLineStart);
    if (_contains_1) {
      propertyContents = propertyContents.replaceFirst((("^(?m)" + descriptionLineStart) + ".*$"), descriptionLine);
    } else {
      String _propertyContents_2 = propertyContents;
      String _lineSeparator_2 = System.lineSeparator();
      String _plus_1 = (descriptionLine + _lineSeparator_2);
      propertyContents = (_propertyContents_2 + _plus_1);
    }
    context.setContents(propertyFile, propertyContents);
    return propertyContents;
  }
  
  private void generateMessagesClass(final String propertyContents, final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    final Path classFile = annotatedClass.getCompilationUnit().getFilePath().getParent().append("Messages.java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = annotatedClass.getCompilationUnit().getPackageName();
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.osgi.util.NLS;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Messages extends NLS {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final String BUNDLE_NAME = \"");
    String _packageName_1 = annotatedClass.getCompilationUnit().getPackageName();
    _builder.append(_packageName_1, "\t");
    _builder.append(".messages\"; //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    String contents = _builder.toString();
    String[] _split = propertyContents.split("(\r?\n)+");
    for (final String line : _split) {
      boolean _contains = line.contains("=");
      if (_contains) {
        final String[] parts = line.split("=");
        String _contents = contents;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\t");
        _builder_1.append("public static String ");
        String _trim = parts[0].trim();
        _builder_1.append(_trim, "\t");
        _builder_1.append(";");
        _builder_1.newLineIfNotEmpty();
        contents = (_contents + _builder_1);
      }
    }
    String _contents_1 = contents;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\t");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("static {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("// initialize resource bundle");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("NLS.initializeMessages(BUNDLE_NAME, Messages.class);");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("private Messages() {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    contents = (_contents_1 + _builder_2);
    context.setContents(classFile, contents);
  }
  
  private String replaceNewlines(final String input) {
    return input.replaceAll("(\r?\n)+", " ");
  }
}
