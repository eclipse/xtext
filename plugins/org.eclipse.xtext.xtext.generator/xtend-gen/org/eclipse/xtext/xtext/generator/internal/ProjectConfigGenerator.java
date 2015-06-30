/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.internal;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ProjectConfigGenerator {
  private final static String INTERFACE_NAME = "org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig";
  
  private final static String IMPL_NAME = "org.eclipse.xtext.xtext.generator.model.XtextProjectConfig";
  
  private final static List<String> PROJECTS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("runtime", "runtimeTest", "genericIde", "genericIdeTest", "eclipsePlugin", "eclipsePluginTest", "ideaPlugin", "ideaPluginTest", "web", "webTest"));
  
  public static void main(final String[] args) {
    final ArrayList<Closeable> closeables = new ArrayList<Closeable>();
    try {
      String _replace = ProjectConfigGenerator.INTERFACE_NAME.replace(".", File.separator);
      String _plus = (("src" + File.separator) + _replace);
      String _plus_1 = (_plus + ".java");
      final FileWriter interfaceWriter = new FileWriter(_plus_1);
      closeables.add(interfaceWriter);
      String _replace_1 = ProjectConfigGenerator.IMPL_NAME.replace(".", File.separator);
      String _plus_2 = (("src" + File.separator) + _replace_1);
      String _plus_3 = (_plus_2 + ".java");
      final FileWriter implWriter = new FileWriter(_plus_3);
      closeables.add(implWriter);
      final ProjectConfigGenerator generator = new ProjectConfigGenerator();
      CharSequence _generateInterface = generator.generateInterface();
      String _string = _generateInterface.toString();
      interfaceWriter.write(_string);
      CharSequence _generateImpl = generator.generateImpl();
      String _string_1 = _generateImpl.toString();
      implWriter.write(_string_1);
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      final Procedure1<Closeable> _function = new Procedure1<Closeable>() {
        @Override
        public void apply(final Closeable it) {
          try {
            it.close();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<Closeable>forEach(closeables, _function);
    }
  }
  
  public CharSequence generateInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*******************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* All rights reserved. This program and the accompanying materials");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* which accompanies this distribution, and is available at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************************/");
    _builder.newLine();
    _builder.append("package ");
    int _lastIndexOf = ProjectConfigGenerator.INTERFACE_NAME.lastIndexOf(".");
    String _substring = ProjectConfigGenerator.INTERFACE_NAME.substring(0, _lastIndexOf);
    _builder.append(_substring, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess2;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ManifestAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ModuleAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface ");
    int _lastIndexOf_1 = ProjectConfigGenerator.INTERFACE_NAME.lastIndexOf(".");
    int _plus = (_lastIndexOf_1 + 1);
    String _substring_1 = ProjectConfigGenerator.INTERFACE_NAME.substring(_plus);
    _builder.append(_substring_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String p : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("IFileSystemAccess2 get");
        String _firstUpper = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper, "\t");
        _builder.append("Src();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("IFileSystemAccess2 get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("SrcGen();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("ManifestAccess get");
        String _firstUpper_2 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("Manifest();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("PluginXmlAccess get");
        String _firstUpper_3 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_3, "\t");
        _builder.append("PluginXml();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("ModuleAccess get");
        String _firstUpper_4 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_4, "\t");
        _builder.append("Module();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("IFileSystemAccess2 getOrionJsGen();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IFileSystemAccess2 getAceJsGen();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateImpl() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*******************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* All rights reserved. This program and the accompanying materials");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* which accompanies this distribution, and is available at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************************/");
    _builder.newLine();
    _builder.append("package ");
    int _lastIndexOf = ProjectConfigGenerator.IMPL_NAME.lastIndexOf(".");
    String _substring = ProjectConfigGenerator.IMPL_NAME.substring(0, _lastIndexOf);
    _builder.append(_substring, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess2;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.IEncodingProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ManifestAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ModuleAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    int _lastIndexOf_1 = ProjectConfigGenerator.IMPL_NAME.lastIndexOf(".");
    int _plus = (_lastIndexOf_1 + 1);
    String _substring_1 = ProjectConfigGenerator.IMPL_NAME.substring(_plus);
    _builder.append(_substring_1, "");
    _builder.append(" implements ");
    int _lastIndexOf_2 = ProjectConfigGenerator.INTERFACE_NAME.lastIndexOf(".");
    int _plus_1 = (_lastIndexOf_2 + 1);
    String _substring_2 = ProjectConfigGenerator.INTERFACE_NAME.substring(_plus_1);
    _builder.append(_substring_2, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject private IEncodingProvider encodingProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String p : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("private FileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("SrcAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private FileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("SrcGenAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ManifestAccess ");
        _builder.append(p, "\t");
        _builder.append("ManifestAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private PluginXmlAccess ");
        _builder.append(p, "\t");
        _builder.append("PluginXmlAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ModuleAccess ");
        _builder.append(p, "\t");
        _builder.append("ModuleAccess;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("private FileSystemAccess orionJsGenAccess;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private FileSystemAccess aceJsGenAccess;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String p_1 : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IFileSystemAccess2 get");
        String _firstUpper = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper, "\t");
        _builder.append("Src() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_1, "\t\t");
        _builder.append("SrcAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("Src(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(p_1, "\t\t");
        _builder.append("SrcAccess = new FileSystemAccess(path, encodingProvider);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IFileSystemAccess2 get");
        String _firstUpper_2 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("SrcGen() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_1, "\t\t");
        _builder.append("SrcGenAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_3 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_3, "\t");
        _builder.append("SrcGen(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(p_1, "\t\t");
        _builder.append("SrcGenAccess = new FileSystemAccess(path, encodingProvider);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(p_1, "\t\t");
        _builder.append("ModuleAccess = new ModuleAccess(");
        _builder.append(p_1, "\t\t");
        _builder.append("SrcGenAccess);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ManifestAccess get");
        String _firstUpper_4 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_4, "\t");
        _builder.append("Manifest() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_1, "\t\t");
        _builder.append("ManifestAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_5 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_5, "\t");
        _builder.append("Manifest(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(p_1, "\t\t");
        _builder.append("ManifestAccess = new ManifestAccess(path);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public PluginXmlAccess get");
        String _firstUpper_6 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_6, "\t");
        _builder.append("PluginXml() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_1, "\t\t");
        _builder.append("PluginXmlAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_7 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_7, "\t");
        _builder.append("PluginXml(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(p_1, "\t\t");
        _builder.append("PluginXmlAccess = new PluginXmlAccess(path);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ModuleAccess get");
        String _firstUpper_8 = StringExtensions.toFirstUpper(p_1);
        _builder.append(_firstUpper_8, "\t");
        _builder.append("Module() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_1, "\t\t");
        _builder.append("ModuleAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IFileSystemAccess2 getOrionJsGen() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return orionJsGenAccess;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setOrionJsGen(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("orionJsGenAccess = new FileSystemAccess(path, encodingProvider);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IFileSystemAccess2 getAceJsGen() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return aceJsGenAccess;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setAceJsGen(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aceJsGenAccess = new FileSystemAccess(path, encodingProvider);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
