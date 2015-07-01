/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;

@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private LanguageConfig2 langConfig;
  
  @Inject
  private CodeConfig codeConfig;
  
  public boolean startPluginXml(final TextFileAccess file) {
    List<CharSequence> _codeFragments = file.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    return _codeFragments.add(_builder.toString());
  }
  
  public void finishPluginXml(final TextFileAccess file) {
    List<CharSequence> _codeFragments = file.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("</plugin>");
    _builder.newLine();
    _codeFragments.add(_builder.toString());
  }
  
  public boolean getRuntimeSetup() {
    boolean _xblockexpression = false;
    {
      final Grammar grammar = this.langConfig.getGrammar();
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
      final JavaFileAccess javaFile = new JavaFileAccess(_runtimeBasePackage, this.codeConfig);
      String _runtimeSetupImplFull = this._xtextGeneratorNaming.getRuntimeSetupImplFull(grammar);
      final String runtimeSetupImpl = javaFile.imported(_runtimeSetupImplFull);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Initialization support for running Xtext languages without Equinox extension registry.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      javaFile.setTypeComment(_builder);
      List<CharSequence> _codeFragments = javaFile.getCodeFragments();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class ");
      String _runtimeSetupSimple = this._xtextGeneratorNaming.getRuntimeSetupSimple(grammar);
      _builder_1.append(_runtimeSetupSimple, "");
      _builder_1.append(" extends ");
      _builder_1.append(runtimeSetupImpl, "");
      _builder_1.append("{");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static void doSetup() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("new ");
      String _runtimeSetupSimple_1 = this._xtextGeneratorNaming.getRuntimeSetupSimple(grammar);
      _builder_1.append(_runtimeSetupSimple_1, "\t\t");
      _builder_1.append("().createInjectorAndDoEMFRegistration();");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _xblockexpression = _codeFragments.add(_builder_1.toString());
    }
    return _xblockexpression;
  }
  
  public boolean startRuntimeSetupImpl() {
    boolean _xblockexpression = false;
    {
      final Grammar grammar = this.langConfig.getGrammar();
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
      final JavaFileAccess javaFile = new JavaFileAccess(_runtimeBasePackage, this.codeConfig);
      javaFile.imported("org.eclipse.emf.ecore.EPackage");
      javaFile.imported("org.eclipse.emf.ecore.resource.Resource");
      javaFile.imported("org.eclipse.xtext.ISetup");
      javaFile.imported("org.eclipse.xtext.ISetupExtension");
      javaFile.imported("com.google.inject.Guice");
      javaFile.imported("com.google.inject.Injector");
      javaFile.imported("java.util.List");
      javaFile.imported("java.util.Arrays");
      String _runtimeGuiceModuleFull = this._xtextGeneratorNaming.getRuntimeGuiceModuleFull(grammar);
      final String runtimeGuiceModule = javaFile.imported(_runtimeGuiceModuleFull);
      EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
      final Function1<Grammar, String> _function = new Function1<Grammar, String>() {
        @Override
        public String apply(final Grammar it) {
          String _runtimeSetupFull = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetupFull(it);
          return javaFile.imported(_runtimeSetupFull);
        }
      };
      final List<String> usedRuntimeSetups = ListExtensions.<Grammar, String>map(_usedGrammars, _function);
      List<CharSequence> _codeFragments = javaFile.getCodeFragments();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class ");
      String _runtimeSetupImplFull = this._xtextGeneratorNaming.getRuntimeSetupImplFull(grammar);
      _builder.append(_runtimeSetupImplFull, "");
      _builder.append(" implements ISetup, ISetupExtension {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<String> getFileExtensions() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return Arrays.asList(");
      {
        List<String> _fileExtensions = this.langConfig.getFileExtensions();
        boolean _hasElements = false;
        for(final String fileExtension : _fileExtensions) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t\t");
          }
          _builder.append("\"");
          _builder.append(fileExtension, "\t\t");
          _builder.append("\"");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Injector createInjectorAndDoEMFRegistration() {");
      _builder.newLine();
      {
        for(final String usedSetup : usedRuntimeSetups) {
          _builder.append("\t\t");
          _builder.append(usedSetup, "\t\t");
          _builder.append(".doSetup();");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<Grammar> _usedGrammars_1 = grammar.getUsedGrammars();
        boolean _isEmpty = _usedGrammars_1.isEmpty();
        if (_isEmpty) {
          _builder.append("\t\t");
          _builder.append("// register default ePackages");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"ecore\"))");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("\"ecore\", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xmi\"))");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("\"xmi\", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xtextbin\"))");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("\"xtextbin\", new org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl());");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Injector injector = createInjector();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("register(injector);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return injector;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public Injector createInjector() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return Guice.createInjector(new ");
      _builder.append(runtimeGuiceModule, "\t\t");
      _builder.append("());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void register(Injector injector) {");
      _builder.newLine();
      _xblockexpression = _codeFragments.add(_builder.toString());
    }
    return _xblockexpression;
  }
  
  public void finishRuntimeSetupImpl(final JavaFileAccess javaFile) {
    List<CharSequence> _codeFragments = javaFile.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _codeFragments.add(_builder.toString());
  }
}
