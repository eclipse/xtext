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

/**
 * A utility class for generating XtextProjectConfig. Not intended to be used outside of this project.
 */
@SuppressWarnings("all")
public class ProjectConfigGenerator {
  private final static String INTERFACE_NAME = "org.eclipse.xtext.xtext.generator.IXtextProjectConfig";
  
  private final static String IMPL_NAME = "org.eclipse.xtext.xtext.generator.XtextProjectConfig";
  
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
  
  private boolean hasPluginXml(final String project) {
    boolean _and = false;
    boolean _startsWith = project.startsWith("ideaPlugin");
    boolean _not = (!_startsWith);
    if (!_not) {
      _and = false;
    } else {
      boolean _startsWith_1 = project.startsWith("web");
      boolean _not_1 = (!_startsWith_1);
      _and = _not_1;
    }
    return _and;
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
    _builder.append("import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ManifestAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Inject an instance of this interface in order to generate code in a generator fragment.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* <p>This file has been generated with {@link ");
    String _name = ProjectConfigGenerator.class.getName();
    _builder.append(_name, " ");
    _builder.append("}.</p>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public interface ");
    int _lastIndexOf_1 = ProjectConfigGenerator.INTERFACE_NAME.lastIndexOf(".");
    int _plus = (_lastIndexOf_1 + 1);
    String _substring_1 = ProjectConfigGenerator.INTERFACE_NAME.substring(_plus);
    _builder.append(_substring_1, "");
    _builder.append(" extends IGuiceAwareGeneratorComponent {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IXtextGeneratorFileSystemAccess getRuntimeModelGen();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String p : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("IXtextGeneratorFileSystemAccess get");
        String _firstUpper = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper, "\t");
        _builder.append("Root();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("IXtextGeneratorFileSystemAccess get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("MetaInf();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("IXtextGeneratorFileSystemAccess get");
        String _firstUpper_2 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("Src();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("IXtextGeneratorFileSystemAccess get");
        String _firstUpper_3 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_3, "\t");
        _builder.append("SrcGen();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("ManifestAccess get");
        String _firstUpper_4 = StringExtensions.toFirstUpper(p);
        _builder.append(_firstUpper_4, "\t");
        _builder.append("Manifest();");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasPluginXml = this.hasPluginXml(p);
          if (_hasPluginXml) {
            _builder.append("\t");
            _builder.append("PluginXmlAccess get");
            String _firstUpper_5 = StringExtensions.toFirstUpper(p);
            _builder.append(_firstUpper_5, "\t");
            _builder.append("PluginXml();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("IXtextGeneratorFileSystemAccess getWebApp();");
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
    _builder.append("import com.google.inject.Injector;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.ManifestAccess;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Use this class to configure output paths in the XtextGenerator.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* <p>This file has been generated with {@link ");
    String _name = ProjectConfigGenerator.class.getName();
    _builder.append(_name, " ");
    _builder.append("}.</p>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
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
    _builder.append("private IXtextGeneratorFileSystemAccess runtimeModelGen;");
    _builder.newLine();
    {
      for(final String p : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("private IXtextGeneratorFileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("Root;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private IXtextGeneratorFileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("MetaInf;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private IXtextGeneratorFileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("Src;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private IXtextGeneratorFileSystemAccess ");
        _builder.append(p, "\t");
        _builder.append("SrcGen;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ManifestAccess ");
        _builder.append(p, "\t");
        _builder.append("Manifest;");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasPluginXml = this.hasPluginXml(p);
          if (_hasPluginXml) {
            _builder.append("\t");
            _builder.append("private PluginXmlAccess ");
            _builder.append(p, "\t");
            _builder.append("PluginXml;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("private IXtextGeneratorFileSystemAccess webApp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void checkConfiguration(Issues issues) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (");
    String _head = IterableExtensions.<String>head(ProjectConfigGenerator.PROJECTS);
    _builder.append(_head, "\t\t");
    _builder.append("Src == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("issues.addError(\"The property \'");
    String _head_1 = IterableExtensions.<String>head(ProjectConfigGenerator.PROJECTS);
    _builder.append(_head_1, "\t\t\t");
    _builder.append("Src\' must be set.\", this);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (");
    String _head_2 = IterableExtensions.<String>head(ProjectConfigGenerator.PROJECTS);
    _builder.append(_head_2, "\t\t");
    _builder.append("SrcGen == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("issues.addError(\"The property \'");
    String _head_3 = IterableExtensions.<String>head(ProjectConfigGenerator.PROJECTS);
    _builder.append(_head_3, "\t\t\t");
    _builder.append("SrcGen\' must be set.\", this);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      for(final String p_1 : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t\t");
        _builder.append("if (");
        _builder.append(p_1, "\t\t");
        _builder.append("Manifest != null && ");
        _builder.append(p_1, "\t\t");
        _builder.append("MetaInf == null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("issues.addError(\"The property \'");
        _builder.append(p_1, "\t\t\t");
        _builder.append("MetaInf\' must be set when \'");
        _builder.append(p_1, "\t\t\t");
        _builder.append("Manifest\' is set.\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        {
          boolean _hasPluginXml_1 = this.hasPluginXml(p_1);
          if (_hasPluginXml_1) {
            _builder.append("\t\t");
            _builder.append("if (");
            _builder.append(p_1, "\t\t");
            _builder.append("PluginXml != null && ");
            _builder.append(p_1, "\t\t");
            _builder.append("Root == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("issues.addError(\"The property \'");
            _builder.append(p_1, "\t\t\t");
            _builder.append("Root\' must be set when \'");
            _builder.append(p_1, "\t\t\t");
            _builder.append("PluginXml\' is set.\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void initialize(Injector injector) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("injector.injectMembers(this);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (runtimeModelGen != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("runtimeModelGen.initialize(injector);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      for(final String p_2 : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Initialize ");
        _builder.append(p_2, "\t\t");
        _builder.append(" configuration");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (");
        _builder.append(p_2, "\t\t");
        _builder.append("Root != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(p_2, "\t\t\t");
        _builder.append("Root.initialize(injector);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (");
        _builder.append(p_2, "\t\t");
        _builder.append("MetaInf != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(p_2, "\t\t\t");
        _builder.append("MetaInf.initialize(injector);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (");
        _builder.append(p_2, "\t\t");
        _builder.append("Src != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(p_2, "\t\t\t");
        _builder.append("Src.initialize(injector);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (");
        _builder.append(p_2, "\t\t");
        _builder.append("SrcGen != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(p_2, "\t\t\t");
        _builder.append("SrcGen.initialize(injector);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (webApp != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("webApp.initialize(injector);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
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
    _builder.append("public IXtextGeneratorFileSystemAccess getRuntimeModelGen() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return runtimeModelGen;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setRuntimeModelGen(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.runtimeModelGen = new XtextGeneratorFileSystemAccess(path, true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String p_3 : ProjectConfigGenerator.PROJECTS) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IXtextGeneratorFileSystemAccess get");
        String _firstUpper = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper, "\t");
        _builder.append("Root() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_3, "\t\t");
        _builder.append("Root;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("Root(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(p_3, "\t\t");
        _builder.append("Root = new XtextGeneratorFileSystemAccess(path, true);");
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
        _builder.append("public IXtextGeneratorFileSystemAccess get");
        String _firstUpper_2 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("MetaInf() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_3, "\t\t");
        _builder.append("MetaInf;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_3 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_3, "\t");
        _builder.append("MetaInf(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(p_3, "\t\t");
        _builder.append("MetaInf = new XtextGeneratorFileSystemAccess(path, true);");
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
        _builder.append("public IXtextGeneratorFileSystemAccess get");
        String _firstUpper_4 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_4, "\t");
        _builder.append("Src() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_3, "\t\t");
        _builder.append("Src;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_5 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_5, "\t");
        _builder.append("Src(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(p_3, "\t\t");
        _builder.append("Src = new XtextGeneratorFileSystemAccess(path, false);");
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
        _builder.append("public IXtextGeneratorFileSystemAccess get");
        String _firstUpper_6 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_6, "\t");
        _builder.append("SrcGen() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_3, "\t\t");
        _builder.append("SrcGen;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_7 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_7, "\t");
        _builder.append("SrcGen(String path) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(p_3, "\t\t");
        _builder.append("SrcGen = new XtextGeneratorFileSystemAccess(path, true);");
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
        String _firstUpper_8 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_8, "\t");
        _builder.append("Manifest() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(p_3, "\t\t");
        _builder.append("Manifest;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_9 = StringExtensions.toFirstUpper(p_3);
        _builder.append(_firstUpper_9, "\t");
        _builder.append("Manifest(ManifestAccess manifest) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(p_3, "\t\t");
        _builder.append("Manifest = manifest;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _hasPluginXml_2 = this.hasPluginXml(p_3);
          if (_hasPluginXml_2) {
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public PluginXmlAccess get");
            String _firstUpper_10 = StringExtensions.toFirstUpper(p_3);
            _builder.append(_firstUpper_10, "\t");
            _builder.append("PluginXml() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            _builder.append(p_3, "\t\t");
            _builder.append("PluginXml;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_11 = StringExtensions.toFirstUpper(p_3);
            _builder.append(_firstUpper_11, "\t");
            _builder.append("PluginXml(PluginXmlAccess pluginXml) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            _builder.append(p_3, "\t\t");
            _builder.append("PluginXml = pluginXml;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IXtextGeneratorFileSystemAccess getWebApp() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return webApp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setWebApp(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.webApp = new XtextGeneratorFileSystemAccess(path, true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
