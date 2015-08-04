/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  public TextFileAccess createPluginXml(final PluginXmlAccess pluginXml) {
    final TextFileAccess file = this.fileAccessFactory.createTextFile();
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
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _runtimeSetup = it.getRuntimeSetup();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_runtimeSetup);
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
        TypeReference _runtimeSetup = it.getRuntimeSetup();
        String _simpleName = _runtimeSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenSetup = it.getRuntimeGenSetup();
        _builder.append(_runtimeGenSetup, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void doSetup() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("new ");
        TypeReference _runtimeSetup_1 = it.getRuntimeSetup();
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
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _runtimeGenSetup = it.getRuntimeGenSetup();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_runtimeGenSetup);
    StandaloneSetupAccess _runtimeGenSetup_1 = langConfig.getRuntimeGenSetup();
    Set<TypeReference> _imports = _runtimeGenSetup_1.getImports();
    for (final TypeReference type : _imports) {
      javaFile.importType(type);
    }
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeGenSetup = it.getRuntimeGenSetup();
        String _simpleName = _runtimeGenSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        _builder.append(ISetup.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
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
          Grammar _grammar = langConfig.getGrammar();
          EList<Grammar> _usedGrammars = _grammar.getUsedGrammars();
          for(final Grammar usedGrammar : _usedGrammars) {
            _builder.append("\t\t");
            XtextGeneratorNaming _naming = XtextGeneratorNaming.naming(usedGrammar);
            TypeReference _runtimeSetup = _naming.getRuntimeSetup();
            _builder.append(_runtimeSetup, "\t\t");
            _builder.append(".doSetup();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Grammar _grammar_1 = langConfig.getGrammar();
          EList<Grammar> _usedGrammars_1 = _grammar_1.getUsedGrammars();
          boolean _isEmpty = _usedGrammars_1.isEmpty();
          if (_isEmpty) {
            _builder.append("\t\t");
            _builder.append("// register default ePackages");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (!");
            TypeReference _typeRef = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef, "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"ecore\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_1, "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\"ecore\", new ");
            TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl");
            _builder.append(_typeRef_2, "\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (!");
            TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_3, "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xmi\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_4, "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\"xmi\", new ");
            TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl");
            _builder.append(_typeRef_5, "\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (!");
            TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_6, "\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xtextbin\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_7, "\t\t\t");
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
            TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.emf.ecore.EPackage");
            _builder.append(_typeRef_8, "\t\t");
            _builder.append(".Registry.INSTANCE.containsKey(");
            _builder.append(XtextPackage.class, "\t\t");
            _builder.append(".eNS_URI))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            TypeReference _typeRef_9 = TypeReference.typeRef("org.eclipse.emf.ecore.EPackage");
            _builder.append(_typeRef_9, "\t\t\t");
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
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t");
        _builder.append(".createInjector(new ");
        TypeReference _runtimeModule = it.getRuntimeModule();
        _builder.append(_runtimeModule, "\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
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
  
  private CharSequence getBindMethodName(final GuiceModuleAccess.Binding it) {
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
        List<Object> _statements = _value_1.getStatements();
        boolean _isEmpty = _statements.isEmpty();
        _and = _isEmpty;
      }
      if (_and) {
        _builder.append("bind");
      } else {
        GuiceModuleAccess.BindValue _value_2 = it.getValue();
        List<Object> _statements_1 = _value_2.getStatements();
        boolean _isEmpty_1 = _statements_1.isEmpty();
        if (_isEmpty_1) {
          _builder.append("provide");
        } else {
          _builder.append("configure");
        }
      }
    }
    String _elvis = null;
    GuiceModuleAccess.BindKey _key = it.getKey();
    String _name = _key.getName();
    String _replace = null;
    if (_name!=null) {
      _replace=_name.replace(".", "$");
    }
    if (_replace != null) {
      _elvis = _replace;
    } else {
      GuiceModuleAccess.BindKey _key_1 = it.getKey();
      TypeReference _type = _key_1.getType();
      String _simpleMethodName = this.getSimpleMethodName(_type);
      _elvis = _simpleMethodName;
    }
    _builder.append(_elvis, "");
    {
      boolean _and_1 = false;
      GuiceModuleAccess.BindValue _value_3 = it.getValue();
      Object _expression = _value_3.getExpression();
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
        _builder.append("ToInstance");
      }
    }
    return _builder;
  }
  
  private String getSimpleMethodName(final TypeReference type) {
    List<String> _simpleNames = type.getSimpleNames();
    String _join = IterableExtensions.join(_simpleNames, "$");
    List<TypeReference> _typeArguments = type.getTypeArguments();
    final Function1<TypeReference, CharSequence> _function = new Function1<TypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final TypeReference it) {
        return XtextGeneratorTemplates.this.getSimpleMethodName(it);
      }
    };
    String _join_1 = IterableExtensions.<TypeReference>join(_typeArguments, "$", "$", "", _function);
    return (_join + _join_1);
  }
  
  private StringConcatenationClient createBindingMethod(final GuiceModuleAccess.Binding it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _and = false;
          GuiceModuleAccess.BindValue _value = it.getValue();
          boolean _isProvider = _value.isProvider();
          boolean _not = (!_isProvider);
          if (!_not) {
            _and = false;
          } else {
            GuiceModuleAccess.BindValue _value_1 = it.getValue();
            List<Object> _statements = _value_1.getStatements();
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
              Object _expression = _value_2.getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("Class<? extends ");
                GuiceModuleAccess.BindKey _key_2 = it.getKey();
                TypeReference _type = _key_2.getType();
                _builder.append(_type, "");
                _builder.append(">");
              } else {
                GuiceModuleAccess.BindKey _key_3 = it.getKey();
                TypeReference _type_1 = _key_3.getType();
                _builder.append(_type_1, "");
              }
            }
            _builder.append(" ");
            CharSequence _bindMethodName = XtextGeneratorTemplates.this.getBindMethodName(it);
            _builder.append(_bindMethodName, "");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            {
              GuiceModuleAccess.BindValue _value_3 = it.getValue();
              Object _expression_1 = _value_3.getExpression();
              boolean _tripleNotEquals = (_expression_1 != null);
              if (_tripleNotEquals) {
                GuiceModuleAccess.BindValue _value_4 = it.getValue();
                Object _expression_2 = _value_4.getExpression();
                _builder.append(_expression_2, "\t");
              } else {
                GuiceModuleAccess.BindValue _value_5 = it.getValue();
                TypeReference _type_2 = _value_5.getType();
                _builder.append(_type_2, "\t");
                _builder.append(".class");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            GuiceModuleAccess.BindValue _value_6 = it.getValue();
            List<Object> _statements_1 = _value_6.getStatements();
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
                Object _expression_3 = _value_7.getExpression();
                boolean _equals = Objects.equal(_expression_3, null);
                if (_equals) {
                  _builder.append("Class<? extends ");
                  _builder.append(Provider.class, "");
                  _builder.append("<");
                  GuiceModuleAccess.BindKey _key_6 = it.getKey();
                  TypeReference _type_3 = _key_6.getType();
                  _builder.append(_type_3, "");
                  _builder.append(">>");
                } else {
                  _builder.append(Provider.class, "");
                  _builder.append("<");
                  GuiceModuleAccess.BindKey _key_7 = it.getKey();
                  TypeReference _type_4 = _key_7.getType();
                  _builder.append(_type_4, "");
                  _builder.append(">");
                }
              }
              _builder.append(" ");
              CharSequence _bindMethodName_1 = XtextGeneratorTemplates.this.getBindMethodName(it);
              _builder.append(_bindMethodName_1, "");
              _builder.append("() {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("return ");
              {
                GuiceModuleAccess.BindValue _value_8 = it.getValue();
                Object _expression_4 = _value_8.getExpression();
                boolean _notEquals = (!Objects.equal(_expression_4, null));
                if (_notEquals) {
                  GuiceModuleAccess.BindValue _value_9 = it.getValue();
                  Object _expression_5 = _value_9.getExpression();
                  _builder.append(_expression_5, "\t");
                } else {
                  GuiceModuleAccess.BindValue _value_10 = it.getValue();
                  TypeReference _type_5 = _value_10.getType();
                  _builder.append(_type_5, "\t");
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
              CharSequence _bindMethodName_2 = XtextGeneratorTemplates.this.getBindMethodName(it);
              _builder.append(_bindMethodName_2, "");
              _builder.append("(");
              _builder.append(Binder.class, "");
              _builder.append(" binder) {");
              _builder.newLineIfNotEmpty();
              {
                GuiceModuleAccess.BindValue _value_11 = it.getValue();
                List<Object> _statements_2 = _value_11.getStatements();
                for(final Object statement : _statements_2) {
                  _builder.append("\t");
                  _builder.append(statement, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
    };
    return _client;
  }
  
  public JavaFileAccess createRuntimeModule(final LanguageConfig2 langConfig) {
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _runtimeModule = it.getRuntimeModule();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_runtimeModule);
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
        TypeReference _runtimeModule = it.getRuntimeModule();
        String _simpleName = _runtimeModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenModule = it.getRuntimeGenModule();
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
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _elvis = null;
    GuiceModuleAccess _runtimeGenModule = langConfig.getRuntimeGenModule();
    TypeReference _superClass = _runtimeGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _runtimeDefaultModule = it.getRuntimeDefaultModule();
      _elvis = _runtimeDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _runtimeGenModule_1 = it.getRuntimeGenModule();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_runtimeGenModule_1);
    javaFile.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _runtimeModule = it.getRuntimeModule();
    String _simpleName = _runtimeModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _runtimeGenModule = it.getRuntimeGenModule();
        String _simpleName = _runtimeGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Properties.class, "\t");
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
        Grammar _grammar = langConfig.getGrammar();
        String _name = _grammar.getName();
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
        Grammar _grammar_1 = langConfig.getGrammar();
        String _name_1 = _grammar_1.getName();
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
          Set<GuiceModuleAccess.Binding> _bindings = _runtimeGenModule_1.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            StringConcatenationClient _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
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
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _eclipsePluginModule = it.getEclipsePluginModule();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_eclipsePluginModule);
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
        TypeReference _eclipsePluginModule = it.getEclipsePluginModule();
        String _simpleName = _eclipsePluginModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _eclipsePluginGenModule = it.getEclipsePluginGenModule();
        _builder.append(_eclipsePluginGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginModule_1 = it.getEclipsePluginModule();
        String _simpleName_1 = _eclipsePluginModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.ui.plugin.AbstractUIPlugin");
        _builder.append(_typeRef, "\t");
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
    final XtextGeneratorNaming it = langConfig.getNaming();
    TypeReference _elvis = null;
    GuiceModuleAccess _eclipsePluginGenModule = langConfig.getEclipsePluginGenModule();
    TypeReference _superClass = _eclipsePluginGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _eclipsePluginDefaultModule = it.getEclipsePluginDefaultModule();
      _elvis = _eclipsePluginDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _eclipsePluginGenModule_1 = it.getEclipsePluginGenModule();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_eclipsePluginGenModule_1);
    javaFile.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _eclipsePluginModule = it.getEclipsePluginModule();
    String _simpleName = _eclipsePluginModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _eclipsePluginGenModule = it.getEclipsePluginGenModule();
        String _simpleName = _eclipsePluginGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginGenModule_1 = it.getEclipsePluginGenModule();
        String _simpleName_1 = _eclipsePluginGenModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.ui.plugin.AbstractUIPlugin");
        _builder.append(_typeRef, "\t");
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
          Set<GuiceModuleAccess.Binding> _bindings = _eclipsePluginGenModule_2.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            StringConcatenationClient _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
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
  
  public TextFileAccess createManifest(final ManifestAccess manifest, final TypeReference activator) {
    final TextFileAccess file = this.fileAccessFactory.createTextFile();
    String _path = manifest.getPath();
    file.setPath(_path);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    String _bundleName = manifest.getBundleName();
    _builder.append(_bundleName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    String _elvis = null;
    String _symbolicName = manifest.getSymbolicName();
    if (_symbolicName != null) {
      _elvis = _symbolicName;
    } else {
      String _bundleName_1 = manifest.getBundleName();
      _elvis = _bundleName_1;
    }
    _builder.append(_elvis, "");
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    {
      String _version = manifest.getVersion();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_version);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("Bundle-Version: ");
        String _version_1 = manifest.getVersion();
        _builder.append(_version_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
    _builder.newLine();
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    {
      Set<String> _exportedPackages = manifest.getExportedPackages();
      boolean _isEmpty = _exportedPackages.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        _builder.append("Export-Package: ");
        {
          Set<String> _exportedPackages_1 = manifest.getExportedPackages();
          List<String> _sort = IterableExtensions.<String>sort(_exportedPackages_1);
          boolean _hasElements = false;
          for(final String pack : _sort) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<String> _requiredBundles = manifest.getRequiredBundles();
      boolean _isEmpty_1 = _requiredBundles.isEmpty();
      boolean _not_2 = (!_isEmpty_1);
      if (_not_2) {
        _builder.append("Require-Bundle: ");
        {
          Set<String> _requiredBundles_1 = manifest.getRequiredBundles();
          List<String> _sort_1 = IterableExtensions.<String>sort(_requiredBundles_1);
          boolean _hasElements_1 = false;
          for(final String bundle : _sort_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(bundle, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<String> _importedPackages = manifest.getImportedPackages();
      boolean _isEmpty_2 = _importedPackages.isEmpty();
      boolean _not_3 = (!_isEmpty_2);
      if (_not_3) {
        _builder.append("Import-Package: ");
        {
          Set<String> _importedPackages_1 = manifest.getImportedPackages();
          List<String> _sort_2 = IterableExtensions.<String>sort(_importedPackages_1);
          boolean _hasElements_2 = false;
          for(final String pack_1 : _sort_2) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((activator != null)) {
        _builder.append("Bundle-Activator: ");
        _builder.append(activator, "");
        _builder.newLineIfNotEmpty();
      }
    }
    file.setContent(_builder);
    return file;
  }
  
  public JavaFileAccess createEclipsePluginExecutableExtensionFactory(final LanguageConfig2 langConfig, final LanguageConfig2 activatorLanguage) {
    XtextGeneratorNaming _naming = langConfig.getNaming();
    TypeReference _eclipsePluginExecutableExtensionFactory = _naming.getEclipsePluginExecutableExtensionFactory();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(_eclipsePluginExecutableExtensionFactory);
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
        XtextGeneratorNaming _naming = langConfig.getNaming();
        TypeReference _eclipsePluginExecutableExtensionFactory = _naming.getEclipsePluginExecutableExtensionFactory();
        String _simpleName = _eclipsePluginExecutableExtensionFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.osgi.framework.Bundle");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" getBundle() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        XtextGeneratorNaming _naming_1 = activatorLanguage.getNaming();
        TypeReference _eclipsePluginActivator = _naming_1.getEclipsePluginActivator();
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
        XtextGeneratorNaming _naming_2 = activatorLanguage.getNaming();
        TypeReference _eclipsePluginActivator_1 = _naming_2.getEclipsePluginActivator();
        _builder.append(_eclipsePluginActivator_1, "\t\t");
        _builder.append(".getInstance().getInjector(");
        XtextGeneratorNaming _naming_3 = activatorLanguage.getNaming();
        TypeReference _eclipsePluginActivator_2 = _naming_3.getEclipsePluginActivator();
        _builder.append(_eclipsePluginActivator_2, "\t\t");
        _builder.append(".");
        Grammar _grammar = langConfig.getGrammar();
        String _name = _grammar.getName();
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
  
  public JavaFileAccess createEclipsePluginActivator(final List<LanguageConfig2> langConfigs) {
    LanguageConfig2 _head = IterableExtensions.<LanguageConfig2>head(langConfigs);
    XtextGeneratorNaming _naming = _head.getNaming();
    final TypeReference activator = _naming.getEclipsePluginActivator();
    final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(activator);
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
        String _simpleName = activator.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append("org.eclipse.ui.plugin.AbstractUIPlugin", "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          for(final LanguageConfig2 lang : langConfigs) {
            _builder.append("\t");
            _builder.append("public static final String ");
            Grammar _grammar = lang.getGrammar();
            String _name = _grammar.getName();
            String _upperCase = _name.toUpperCase();
            String _replaceAll = _upperCase.replaceAll("\\.", "_");
            _builder.append(_replaceAll, "\t");
            _builder.append(" = \"");
            Grammar _grammar_1 = lang.getGrammar();
            String _name_1 = _grammar_1.getName();
            _builder.append(_name_1, "\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final ");
        _builder.append(Logger.class, "\t");
        _builder.append(" logger = ");
        _builder.append(Logger.class, "\t");
        _builder.append(".getLogger(");
        String _simpleName_1 = activator.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static ");
        String _simpleName_2 = activator.getSimpleName();
        _builder.append(_simpleName_2, "\t");
        _builder.append(" INSTANCE;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(Map.class, "\t");
        _builder.append("<String, ");
        _builder.append(Injector.class, "\t");
        _builder.append("> injectors = ");
        _builder.append(Collections.class, "\t");
        _builder.append(".synchronizedMap(");
        _builder.append(Maps.class, "\t");
        _builder.append(".<String, ");
        _builder.append(Injector.class, "\t");
        _builder.append("> newHashMapWithExpectedSize(1));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void start(");
        TypeReference _typeRef = TypeReference.typeRef("org.osgi.framework.BundleContext");
        _builder.append(_typeRef, "\t");
        _builder.append(" context) throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super.start(context);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = this;");
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
        _builder.append("public void stop(");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.osgi.framework.BundleContext");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" context) throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("injectors.clear();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.stop(context);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static ");
        String _simpleName_3 = activator.getSimpleName();
        _builder.append(_simpleName_3, "\t");
        _builder.append(" getInstance() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" getInjector(String language) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("synchronized (injectors) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(Injector.class, "\t\t\t");
        _builder.append(" injector = injectors.get(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("if (injector == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("injectors.put(language, injector = createInjector(language));");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return injector;");
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
        _builder.append("protected ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjector(String language) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" runtimeModule = getRuntimeModule(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" sharedStateModule = getSharedStateModule();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" uiModule = getUiModule(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" mergedModule = ");
        _builder.append(Modules2.class, "\t\t\t");
        _builder.append(".mixin(runtimeModule, sharedStateModule, uiModule);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t\t");
        _builder.append(".createInjector(mergedModule);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("} catch (Exception e) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(\"Failed to create injector for \" + language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(e.getMessage(), e);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("throw new RuntimeException(\"Failed to create injector for \" + language, e);");
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
        _builder.append("protected Module getRuntimeModule(String grammar) {");
        _builder.newLine();
        {
          for(final LanguageConfig2 lang_1 : langConfigs) {
            _builder.append("\t\t");
            _builder.append("if (");
            Grammar _grammar_2 = lang_1.getGrammar();
            String _name_2 = _grammar_2.getName();
            String _upperCase_1 = _name_2.toUpperCase();
            String _replaceAll_1 = _upperCase_1.replaceAll("\\.", "_");
            _builder.append(_replaceAll_1, "\t\t");
            _builder.append(".equals(grammar)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new ");
            XtextGeneratorNaming _naming = lang_1.getNaming();
            TypeReference _runtimeModule = _naming.getRuntimeModule();
            _builder.append(_runtimeModule, "\t\t\t");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Module.class, "\t");
        _builder.append(" getUiModule(String grammar) {");
        _builder.newLineIfNotEmpty();
        {
          for(final LanguageConfig2 lang_2 : langConfigs) {
            _builder.append("\t\t");
            _builder.append("if (");
            Grammar _grammar_3 = lang_2.getGrammar();
            String _name_3 = _grammar_3.getName();
            String _upperCase_2 = _name_3.toUpperCase();
            String _replaceAll_2 = _upperCase_2.replaceAll("\\.", "_");
            _builder.append(_replaceAll_2, "\t\t");
            _builder.append(".equals(grammar)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new ");
            XtextGeneratorNaming _naming_1 = lang_2.getNaming();
            TypeReference _eclipsePluginModule = _naming_1.getEclipsePluginModule();
            _builder.append(_eclipsePluginModule, "\t\t\t");
            _builder.append("(this);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Module.class, "\t");
        _builder.append(" getSharedStateModule() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return new ");
        TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.shared.SharedStateModule");
        _builder.append(_typeRef_2, "\t\t");
        _builder.append("();");
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
