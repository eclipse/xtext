/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private LanguageConfig2 langConfig;
  
  @Inject
  private CodeConfig codeConfig;
  
  public TextFileAccess startPluginXml(final TextFileAccess file) {
    file.setPath("plugin.xml");
    List<CharSequence> _codeFragments = file.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    _codeFragments.add(_builder.toString());
    return file;
  }
  
  public TextFileAccess finishPluginXml(final TextFileAccess file) {
    List<CharSequence> _codeFragments = file.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("</plugin>");
    _builder.newLine();
    _codeFragments.add(_builder.toString());
    return file;
  }
  
  public JavaFileAccess getRuntimeSetup() {
    final Grammar grammar = this.langConfig.getGrammar();
    String _runtimeSetup = this._xtextGeneratorNaming.getRuntimeSetup(grammar);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeSetup, this.codeConfig);
    String _runtimeGenSetup = this._xtextGeneratorNaming.getRuntimeGenSetup(grammar);
    final String runtimeSetupImpl = javaFile.imported(_runtimeGenSetup);
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
    String _runtimeSetup_1 = this._xtextGeneratorNaming.getRuntimeSetup(grammar);
    String _simple = this._xtextGeneratorNaming.getSimple(_runtimeSetup_1);
    _builder_1.append(_simple, "");
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
    String _runtimeSetup_2 = this._xtextGeneratorNaming.getRuntimeSetup(grammar);
    String _simple_1 = this._xtextGeneratorNaming.getSimple(_runtimeSetup_2);
    _builder_1.append(_simple_1, "\t\t");
    _builder_1.append("().createInjectorAndDoEMFRegistration();");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments.add(_builder_1.toString());
    return javaFile;
  }
  
  public JavaFileAccess startRuntimeGenSetup() {
    final Grammar grammar = this.langConfig.getGrammar();
    String _runtimeGenSetup = this._xtextGeneratorNaming.getRuntimeGenSetup(grammar);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeGenSetup, this.codeConfig);
    javaFile.imported("org.eclipse.emf.ecore.EPackage");
    javaFile.imported("org.eclipse.emf.ecore.resource.Resource");
    javaFile.imported("org.eclipse.xtext.ISetup");
    javaFile.imported("org.eclipse.xtext.ISetupExtension");
    javaFile.imported("com.google.inject.Guice");
    javaFile.imported("com.google.inject.Injector");
    javaFile.imported("java.util.List");
    javaFile.imported("java.util.Arrays");
    String _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(grammar);
    final String runtimeGuiceModule = javaFile.imported(_runtimeModule);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    final Function1<Grammar, String> _function = new Function1<Grammar, String>() {
      @Override
      public String apply(final Grammar it) {
        String _runtimeSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(it);
        return javaFile.imported(_runtimeSetup);
      }
    };
    final List<String> usedRuntimeSetups = ListExtensions.<Grammar, String>map(_usedGrammars, _function);
    List<CharSequence> _codeFragments = javaFile.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _runtimeGenSetup_1 = this._xtextGeneratorNaming.getRuntimeGenSetup(grammar);
    String _simple = this._xtextGeneratorNaming.getSimple(_runtimeGenSetup_1);
    _builder.append(_simple, "");
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
    _codeFragments.add(_builder.toString());
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public JavaFileAccess finishRuntimeGenSetup(final JavaFileAccess javaFile) {
    List<CharSequence> _codeFragments = javaFile.getCodeFragments();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _codeFragments.add(_builder.toString());
    return javaFile;
  }
  
  private String getBindMethodName(final GuiceModuleAccess.Binding it) {
    String _xifexpression = null;
    boolean _and = false;
    GuiceModuleAccess.BindValue _value = it.getValue();
    boolean _isProvider = _value.isProvider();
    boolean _not = (!_isProvider);
    if (!_not) {
      _and = false;
    } else {
      GuiceModuleAccess.BindValue _value_1 = it.getValue();
      List<CharSequence> _statements = _value_1.getStatements();
      boolean _isEmpty = _statements.isEmpty();
      _and = _isEmpty;
    }
    if (_and) {
      _xifexpression = "bind";
    } else {
      String _xifexpression_1 = null;
      GuiceModuleAccess.BindValue _value_2 = it.getValue();
      List<CharSequence> _statements_1 = _value_2.getStatements();
      boolean _isEmpty_1 = _statements_1.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = "provide";
      } else {
        _xifexpression_1 = "configure";
      }
      _xifexpression = _xifexpression_1;
    }
    GuiceModuleAccess.BindKey _key = it.getKey();
    String _type = _key.getType();
    String _simpleMethodName = this.getSimpleMethodName(_type);
    String _plus = (_xifexpression + _simpleMethodName);
    String _xifexpression_2 = null;
    boolean _and_1 = false;
    GuiceModuleAccess.BindValue _value_3 = it.getValue();
    String _expression = _value_3.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (!_tripleNotEquals) {
      _and_1 = false;
    } else {
      GuiceModuleAccess.BindValue _value_4 = it.getValue();
      boolean _isProvider_1 = _value_4.isProvider();
      boolean _not_1 = (!_isProvider_1);
      _and_1 = _not_1;
    }
    if (_and_1) {
      _xifexpression_2 = "ToInstance";
    } else {
      _xifexpression_2 = "";
    }
    return (_plus + _xifexpression_2);
  }
  
  private String getSimpleMethodName(final String qn) {
    String _replaceAll = qn.replaceAll("<", "\\.");
    String _replaceAll_1 = _replaceAll.replaceAll(">", "\\.");
    String[] _split = _replaceAll_1.split("\\.");
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.matches("[A-Z].*"));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
    return IterableExtensions.join(_filter, "$");
  }
  
  private boolean endsWith(final CharSequence sequence, final char c) {
    boolean _and = false;
    int _length = sequence.length();
    boolean _greaterThan = (_length > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      int _length_1 = sequence.length();
      int _minus = (_length_1 - 1);
      char _charAt = sequence.charAt(_minus);
      boolean _equals = (_charAt == c);
      _and = _equals;
    }
    return _and;
  }
  
  public JavaFileAccess getRuntimeModule() {
    final Grammar grammar = this.langConfig.getGrammar();
    String _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(grammar);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeModule, this.codeConfig);
    String _runtimeGenModule = this._xtextGeneratorNaming.getRuntimeGenModule(grammar);
    final String runtimeGeneratedModule = javaFile.imported(_runtimeGenModule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Use this class to register components to be used at runtime / without the Equinox extension registry.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<CharSequence> _codeFragments = javaFile.getCodeFragments();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class ");
    String _runtimeModule_1 = this._xtextGeneratorNaming.getRuntimeModule(grammar);
    String _simple = this._xtextGeneratorNaming.getSimple(_runtimeModule_1);
    _builder_1.append(_simple, "");
    _builder_1.append(" extends ");
    _builder_1.append(runtimeGeneratedModule, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments.add(_builder_1.toString());
    return javaFile;
  }
  
  public GuiceModuleAccess startRuntimeGenModule() {
    final Grammar grammar = this.langConfig.getGrammar();
    String _runtimeGenModule = this._xtextGeneratorNaming.getRuntimeGenModule(grammar);
    final GuiceModuleAccess module = new GuiceModuleAccess(_runtimeGenModule, this.codeConfig);
    module.imported("java.util.Properties");
    module.imported("org.eclipse.xtext.Constants");
    module.imported("com.google.inject.Binder");
    module.imported("com.google.inject.name.Names");
    String _runtimeDefaultModule = this._xtextGeneratorNaming.getRuntimeDefaultModule(grammar);
    final String runtimeDefaultModule = module.imported(_runtimeDefaultModule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    String _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(grammar);
    String _simple = this._xtextGeneratorNaming.getSimple(_runtimeModule);
    _builder.append(_simple, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    module.setTypeComment(_builder);
    List<CharSequence> _codeFragments = module.getCodeFragments();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public abstract class ");
    String _runtimeGenModule_1 = this._xtextGeneratorNaming.getRuntimeGenModule(grammar);
    String _simple_1 = this._xtextGeneratorNaming.getSimple(_runtimeGenModule_1);
    _builder_1.append(_simple_1, "");
    _builder_1.append(" extends ");
    _builder_1.append(runtimeDefaultModule, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected Properties properties = null;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void configure(Binder binder) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("properties = tryBindProperties(binder, \"");
    String _name = grammar.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    _builder_1.append(_replaceAll, "\t\t");
    _builder_1.append(".properties\");");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("super.configure(binder);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void configureLanguageName(Binder binder) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance(\"");
    String _name_1 = grammar.getName();
    _builder_1.append(_name_1, "\t\t");
    _builder_1.append("\");");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void configureFileExtensions(Binder binder) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance(\"");
    List<String> _fileExtensions = this.langConfig.getFileExtensions();
    String _join = IterableExtensions.join(_fileExtensions, ",");
    _builder_1.append(_join, "\t\t\t");
    _builder_1.append("\");");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments.add(_builder_1.toString());
    module.setMarkedAsGenerated(true);
    return module;
  }
  
  public JavaFileAccess getEclipsePluginModule() {
    final Grammar g = this.langConfig.getGrammar();
    String _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginModule, this.codeConfig);
    String _eclipsePluginGenModule = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    final String eclipsePluginGenGuiceModule = javaFile.imported(_eclipsePluginGenModule);
    javaFile.imported("org.eclipse.ui.plugin.AbstractUIPlugin");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Use this class to register components to be used within the Eclipse IDE.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<CharSequence> _codeFragments = javaFile.getCodeFragments();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class ");
    String _eclipsePluginModule_1 = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    String _simple = this._xtextGeneratorNaming.getSimple(_eclipsePluginModule_1);
    _builder_1.append(_simple, "");
    _builder_1.append(" extends ");
    _builder_1.append(eclipsePluginGenGuiceModule, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("public ");
    String _eclipsePluginModule_2 = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    String _simple_1 = this._xtextGeneratorNaming.getSimple(_eclipsePluginModule_2);
    _builder_1.append(_simple_1, "\t");
    _builder_1.append("(AbstractUIPlugin plugin) {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("super(plugin);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments.add(_builder_1.toString());
    return javaFile;
  }
  
  public GuiceModuleAccess startEclipsePluginGenModule() {
    final Grammar g = this.langConfig.getGrammar();
    String _eclipsePluginGenModule = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    final GuiceModuleAccess module = new GuiceModuleAccess(_eclipsePluginGenModule, this.codeConfig);
    module.imported("org.eclipse.ui.plugin.AbstractUIPlugin");
    String _eclipsePluginDefaultModule = this._xtextGeneratorNaming.getEclipsePluginDefaultModule(g);
    final String eclipsePluginDefaultModule = module.imported(_eclipsePluginDefaultModule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    String _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    String _simple = this._xtextGeneratorNaming.getSimple(_eclipsePluginModule);
    _builder.append(_simple, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    module.setTypeComment(_builder);
    List<CharSequence> _codeFragments = module.getCodeFragments();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public abstract class ");
    String _eclipsePluginGenModule_1 = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    String _simple_1 = this._xtextGeneratorNaming.getSimple(_eclipsePluginGenModule_1);
    _builder_1.append(_simple_1, "");
    _builder_1.append(" extends ");
    _builder_1.append(eclipsePluginDefaultModule, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public ");
    String _eclipsePluginGenModule_2 = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    String _simple_2 = this._xtextGeneratorNaming.getSimple(_eclipsePluginGenModule_2);
    _builder_1.append(_simple_2, "\t");
    _builder_1.append("(AbstractUIPlugin plugin) {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("super(plugin);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments.add(_builder_1.toString());
    module.setMarkedAsGenerated(true);
    return module;
  }
  
  public GuiceModuleAccess finishGenModule(final GuiceModuleAccess module) {
    final String binder = module.imported("com.google.inject.Binder");
    final String provider = module.imported("com.google.inject.Provider");
    final String singletonBinding = module.imported("org.eclipse.xtext.service.SingletonBinding");
    List<GuiceModuleAccess.Binding> _bindings = module.getBindings();
    for (final GuiceModuleAccess.Binding it : _bindings) {
      List<CharSequence> _codeFragments = module.getCodeFragments();
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _and = false;
        GuiceModuleAccess.BindValue _value = it.getValue();
        boolean _isProvider = _value.isProvider();
        boolean _not = (!_isProvider);
        if (!_not) {
          _and = false;
        } else {
          GuiceModuleAccess.BindValue _value_1 = it.getValue();
          List<CharSequence> _statements = _value_1.getStatements();
          boolean _isEmpty = _statements.isEmpty();
          _and = _isEmpty;
        }
        if (_and) {
          _builder.append("// contributed by ");
          String _contributedBy = it.getContributedBy();
          _builder.append(_contributedBy, "");
          _builder.newLineIfNotEmpty();
          {
            GuiceModuleAccess.BindKey _key = it.getKey();
            boolean _isSingleton = _key.isSingleton();
            if (_isSingleton) {
              _builder.append("@");
              _builder.append(singletonBinding, "");
              {
                GuiceModuleAccess.BindKey _key_1 = it.getKey();
                boolean _isEagerSingleton = _key_1.isEagerSingleton();
                if (_isEagerSingleton) {
                  _builder.append("(eager=true)");
                }
              }
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("public ");
          {
            GuiceModuleAccess.BindValue _value_2 = it.getValue();
            String _expression = _value_2.getExpression();
            boolean _tripleEquals = (_expression == null);
            if (_tripleEquals) {
              _builder.append("Class<? extends ");
              GuiceModuleAccess.BindKey _key_2 = it.getKey();
              String _type = _key_2.getType();
              String _imported = module.imported(_type);
              _builder.append(_imported, "");
              _builder.append(">");
            } else {
              GuiceModuleAccess.BindKey _key_3 = it.getKey();
              String _type_1 = _key_3.getType();
              String _imported_1 = module.imported(_type_1);
              _builder.append(_imported_1, "");
            }
          }
          _builder.append(" ");
          String _bindMethodName = this.getBindMethodName(it);
          _builder.append(_bindMethodName, "");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("return ");
          {
            GuiceModuleAccess.BindValue _value_3 = it.getValue();
            String _expression_1 = _value_3.getExpression();
            boolean _tripleNotEquals = (_expression_1 != null);
            if (_tripleNotEquals) {
              GuiceModuleAccess.BindValue _value_4 = it.getValue();
              String _expression_2 = _value_4.getExpression();
              _builder.append(_expression_2, "\t");
            } else {
              GuiceModuleAccess.BindValue _value_5 = it.getValue();
              String _typeName = _value_5.getTypeName();
              _builder.append(_typeName, "\t");
              _builder.append(".class");
            }
          }
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          GuiceModuleAccess.BindValue _value_6 = it.getValue();
          List<CharSequence> _statements_1 = _value_6.getStatements();
          boolean _isEmpty_1 = _statements_1.isEmpty();
          if (_isEmpty_1) {
            _builder.append("// contributed by ");
            String _contributedBy_1 = it.getContributedBy();
            _builder.append(_contributedBy_1, "");
            _builder.newLineIfNotEmpty();
            {
              GuiceModuleAccess.BindKey _key_4 = it.getKey();
              boolean _isSingleton_1 = _key_4.isSingleton();
              if (_isSingleton_1) {
                _builder.append("@");
                _builder.append(singletonBinding, "");
                {
                  GuiceModuleAccess.BindKey _key_5 = it.getKey();
                  boolean _isEagerSingleton_1 = _key_5.isEagerSingleton();
                  if (_isEagerSingleton_1) {
                    _builder.append("(eager=true)");
                  }
                }
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("public ");
            {
              GuiceModuleAccess.BindValue _value_7 = it.getValue();
              String _expression_3 = _value_7.getExpression();
              boolean _equals = Objects.equal(_expression_3, null);
              if (_equals) {
                _builder.append("Class<? extends ");
                _builder.append(provider, "");
                _builder.append("<");
                GuiceModuleAccess.BindKey _key_6 = it.getKey();
                String _type_2 = _key_6.getType();
                _builder.append(_type_2, "");
                _builder.append(">>");
              } else {
                _builder.append(provider, "");
                _builder.append("<");
                GuiceModuleAccess.BindKey _key_7 = it.getKey();
                String _type_3 = _key_7.getType();
                _builder.append(_type_3, "");
                _builder.append(">");
              }
            }
            _builder.append(" ");
            String _bindMethodName_1 = this.getBindMethodName(it);
            _builder.append(_bindMethodName_1, "");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            {
              GuiceModuleAccess.BindValue _value_8 = it.getValue();
              String _expression_4 = _value_8.getExpression();
              boolean _notEquals = (!Objects.equal(_expression_4, null));
              if (_notEquals) {
                GuiceModuleAccess.BindValue _value_9 = it.getValue();
                String _expression_5 = _value_9.getExpression();
                _builder.append(_expression_5, "\t");
              } else {
                GuiceModuleAccess.BindValue _value_10 = it.getValue();
                String _typeName_1 = _value_10.getTypeName();
                _builder.append(_typeName_1, "\t");
                _builder.append(".class");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("// contributed by ");
            String _contributedBy_2 = it.getContributedBy();
            _builder.append(_contributedBy_2, "");
            _builder.newLineIfNotEmpty();
            _builder.append("public void ");
            String _bindMethodName_2 = this.getBindMethodName(it);
            _builder.append(_bindMethodName_2, "");
            _builder.append("(");
            _builder.append(binder, "");
            _builder.append(" binder) {");
            _builder.newLineIfNotEmpty();
            {
              GuiceModuleAccess.BindValue _value_11 = it.getValue();
              List<CharSequence> _statements_2 = _value_11.getStatements();
              for(final CharSequence statement : _statements_2) {
                _builder.append(statement, "");
                {
                  boolean _endsWith = this.endsWith(statement, ';');
                  boolean _not_1 = (!_endsWith);
                  if (_not_1) {
                    _builder.append(";");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
      _codeFragments.add(_builder.toString());
    }
    List<CharSequence> _codeFragments_1 = module.getCodeFragments();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("}");
    _builder_1.newLine();
    _codeFragments_1.add(_builder_1.toString());
    return module;
  }
}
