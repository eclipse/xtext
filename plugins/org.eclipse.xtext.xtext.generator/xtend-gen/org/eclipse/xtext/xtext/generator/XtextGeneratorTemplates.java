/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ISetupExtension;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  public TextFileAccess createPluginXml(final PluginXmlAccess pluginXml) {
    final TextFileAccess file = new TextFileAccess();
    file.setEncodingProvider(this.encodingProvider);
    String _path = pluginXml.getPath();
    file.setPath(_path);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    {
      List<CharSequence> _entries = pluginXml.getEntries();
      for(final CharSequence entry : _entries) {
        _builder.append("\t");
        _builder.append(entry, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</plugin>");
    _builder.newLine();
    file.setContent(_builder);
    return file;
  }
  
  public JavaFileAccess createRuntimeSetup(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeSetup = this._xtextGeneratorNaming.getRuntimeSetup(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeSetup, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
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
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(g);
        String _simpleName = _runtimeSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenSetup(g);
        _builder.append(_runtimeGenSetup, "");
        _builder.append("{");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void doSetup() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("new ");
        TypeReference _runtimeSetup_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(g);
        String _simpleName_1 = _runtimeSetup_1.getSimpleName();
        _builder.append(_simpleName_1, "\t\t");
        _builder.append("().createInjectorAndDoEMFRegistration();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createRuntimeGenSetup(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeGenSetup = this._xtextGeneratorNaming.getRuntimeGenSetup(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeGenSetup, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenSetup(g);
        String _simpleName = _runtimeGenSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        _builder.append(ISetup.class, "");
        _builder.append(", ");
        _builder.append(ISetupExtension.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append("java.util.List", "\t");
        _builder.append("<String> getFileExtensions() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append("java.util.Arrays", "\t\t");
        _builder.append(".asList(");
        {
          List<String> _fileExtensions = langConfig.getFileExtensions();
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
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjectorAndDoEMFRegistration() {");
        _builder.newLineIfNotEmpty();
        {
          EList<Grammar> _usedGrammars = g.getUsedGrammars();
          for(final Grammar usedGrammar : _usedGrammars) {
            _builder.append("\t\t");
            TypeReference _runtimeSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(usedGrammar);
            _builder.append(_runtimeSetup, "\t\t");
            _builder.append(".doSetup();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Grammar> _usedGrammars_1 = g.getUsedGrammars();
          boolean _isEmpty = _usedGrammars_1.isEmpty();
          if (_isEmpty) {
            _builder.append("\t\t");
            _builder.append("// register default ePackages");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (!");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"ecore\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\"ecore\", new ");
            _builder.append("org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl", "\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (!");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xmi\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\"xmi\", new ");
            _builder.append("org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl", "\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (!");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xtextbin\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("org.eclipse.emf.ecore.resource.Resource", "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\"xtextbin\", new ");
            _builder.append(BinaryGrammarResourceFactoryImpl.class, "\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (!");
            _builder.append("org.eclipse.emf.ecore.EPackage", "\t\t");
            _builder.append(".Registry.INSTANCE.containsKey(");
            _builder.append(XtextPackage.class, "\t\t");
            _builder.append(".eNS_URI))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("org.eclipse.emf.ecore.EPackage", "\t\t\t");
            _builder.append(".Registry.INSTANCE.put(");
            _builder.append(XtextPackage.class, "\t\t\t");
            _builder.append(".eNS_URI, ");
            _builder.append(XtextPackage.class, "\t\t\t");
            _builder.append(".eINSTANCE);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(Injector.class, "\t\t");
        _builder.append(" injector = createInjector();");
        _builder.newLineIfNotEmpty();
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
        _builder.append("public ");
        _builder.append(Injector.class, "\t\t");
        _builder.append(" createInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t");
        _builder.append(".createInjector(new ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeModule(g);
        _builder.append(_runtimeModule, "\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void register(");
        _builder.append(Injector.class, "\t");
        _builder.append(" injector) {");
        _builder.newLineIfNotEmpty();
        {
          StandaloneSetupAccess _runtimeGenSetup_1 = langConfig.getRuntimeGenSetup();
          List<CharSequence> _registrations = _runtimeGenSetup_1.getRegistrations();
          for(final CharSequence reg : _registrations) {
            _builder.append("\t\t");
            _builder.append(reg, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
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
  
  private CharSequence createBindingMethod(final GuiceModuleAccess.Binding it) {
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
            _builder.append(SingletonBinding.class, "");
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
            _builder.append(_type, "");
            _builder.append(">");
          } else {
            GuiceModuleAccess.BindKey _key_3 = it.getKey();
            String _type_1 = _key_3.getType();
            _builder.append(_type_1, "");
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
              _builder.append(SingletonBinding.class, "");
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
              _builder.append(Provider.class, "");
              _builder.append("<");
              GuiceModuleAccess.BindKey _key_6 = it.getKey();
              String _type_2 = _key_6.getType();
              _builder.append(_type_2, "");
              _builder.append(">>");
            } else {
              _builder.append(Provider.class, "");
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
          _builder.append(Binder.class, "");
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
    return _builder;
  }
  
  public JavaFileAccess createRuntimeModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
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
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeModule(g);
        String _simpleName = _runtimeModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenModule(g);
        _builder.append(_runtimeGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createRuntimeGenModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeGenModule = this._xtextGeneratorNaming.getRuntimeGenModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeGenModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(g);
    String _simpleName = _runtimeModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenModule(g);
        String _simpleName = _runtimeGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeDefaultModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeDefaultModule(g);
        _builder.append(_runtimeDefaultModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append("java.util.Properties", "\t");
        _builder.append(" properties = null;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configure(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("properties = tryBindProperties(binder, \"");
        String _name = g.getName();
        String _replaceAll = _name.replaceAll("\\.", "/");
        _builder.append(_replaceAll, "\t\t");
        _builder.append(".properties\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super.configure(binder);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureLanguageName(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(");
        _builder.append(Names.class, "\t\t");
        _builder.append(".named(");
        _builder.append(Constants.class, "\t\t");
        _builder.append(".LANGUAGE_NAME)).toInstance(\"");
        String _name_1 = g.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureFileExtensions(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(");
        _builder.append(Names.class, "\t\t\t");
        _builder.append(".named(");
        _builder.append(Constants.class, "\t\t\t");
        _builder.append(".FILE_EXTENSIONS)).toInstance(\"");
        List<String> _fileExtensions = langConfig.getFileExtensions();
        String _join = IterableExtensions.join(_fileExtensions, ",");
        _builder.append(_join, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _runtimeGenModule_1 = langConfig.getRuntimeGenModule();
          List<GuiceModuleAccess.Binding> _bindings = _runtimeGenModule_1.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            CharSequence _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
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
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginModule(g);
        String _simpleName = _eclipsePluginModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        _builder.append(_eclipsePluginGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginModule_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginModule(g);
        String _simpleName_1 = _eclipsePluginModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        _builder.append("org.eclipse.ui.plugin.AbstractUIPlugin", "\t");
        _builder.append(" plugin) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(plugin);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginGenModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _eclipsePluginGenModule = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginGenModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    String _simpleName = _eclipsePluginModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        String _simpleName = _eclipsePluginGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _eclipsePluginDefaultModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginDefaultModule(g);
        _builder.append(_eclipsePluginDefaultModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginGenModule_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        String _simpleName_1 = _eclipsePluginGenModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        _builder.append("org.eclipse.ui.plugin.AbstractUIPlugin", "\t");
        _builder.append(" plugin) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(plugin);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _eclipsePluginGenModule_2 = langConfig.getEclipsePluginGenModule();
          List<GuiceModuleAccess.Binding> _bindings = _eclipsePluginGenModule_2.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            CharSequence _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginExecutableExtensionFactory(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginExecutableExtensionFactory, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class was generated. Customizations should only happen in a newly");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* introduced subclass. ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _eclipsePluginExecutableExtensionFactory = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(g);
        String _simpleName = _eclipsePluginExecutableExtensionFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append("org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory", "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append("org.osgi.framework.Bundle", "\t");
        _builder.append(" getBundle() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _eclipsePluginActivator = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator, "\t\t");
        _builder.append(".getInstance().getBundle();");
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
        _builder.append("protected ");
        _builder.append(Injector.class, "\t");
        _builder.append(" getInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _eclipsePluginActivator_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator_1, "\t\t");
        _builder.append(".getInstance().getInjector(");
        TypeReference _eclipsePluginActivator_2 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator_2, "\t\t");
        _builder.append(".");
        String _name = g.getName();
        String _upperCase = _name.toUpperCase();
        String _replaceAll = _upperCase.replaceAll("\\.", "_");
        _builder.append(_replaceAll, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
}
