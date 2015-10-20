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
import com.google.inject.util.Modules;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private XtextGeneratorNaming naming;
  
  public JavaFileAccess createRuntimeSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _runtimeSetup = this.naming.getRuntimeSetup(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Initialization support for running Xtext languages without Equinox extension registry.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        TypeReference _runtimeSetup = XtextGeneratorTemplates.this.naming.getRuntimeSetup(it);
        String _simpleName = _runtimeSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this.naming.getRuntimeGenSetup(it);
        _builder.append(_runtimeGenSetup, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def static void doSetup() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("new ");
        TypeReference _runtimeSetup_1 = XtextGeneratorTemplates.this.naming.getRuntimeSetup(it);
        String _simpleName_1 = _runtimeSetup_1.getSimpleName();
        _builder.append(_simpleName_1, "\t\t");
        _builder.append("().createInjectorAndDoEMFRegistration()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_runtimeSetup, _client);
  }
  
  public JavaFileAccess createRuntimeGenSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _runtimeGenSetup = this.naming.getRuntimeGenSetup(it);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_runtimeGenSetup);
    StandaloneSetupAccess _runtimeGenSetup_1 = langConfig.getRuntimeGenSetup();
    Set<TypeReference> _imports = _runtimeGenSetup_1.getImports();
    for (final TypeReference type : _imports) {
      file.importType(type);
    }
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this.naming.getRuntimeGenSetup(it);
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
            TypeReference _runtimeSetup = XtextGeneratorTemplates.this.naming.getRuntimeSetup(usedGrammar);
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
        TypeReference _runtimeModule = XtextGeneratorTemplates.this.naming.getRuntimeModule(it);
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
          List<StringConcatenationClient> _registrations = _runtimeGenSetup_1.getRegistrations();
          for(final StringConcatenationClient reg : _registrations) {
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
    file.setContent(_client);
    return file;
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
  
  public JavaFileAccess createRuntimeModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _runtimeModule = this.naming.getRuntimeModule(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Use this class to register components to be used at runtime / without the Equinox extension registry.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this.naming.getRuntimeModule(it);
        String _simpleName = _runtimeModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this.naming.getRuntimeGenModule(it);
        _builder.append(_runtimeGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_runtimeModule, _client);
  }
  
  public JavaFileAccess createRuntimeGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    GuiceModuleAccess _runtimeGenModule = langConfig.getRuntimeGenModule();
    TypeReference _superClass = _runtimeGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _runtimeDefaultModule = this.naming.getRuntimeDefaultModule(it);
      _elvis = _runtimeDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _runtimeGenModule_1 = this.naming.getRuntimeGenModule(it);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_runtimeGenModule_1);
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this.naming.getRuntimeModule(it);
        String _simpleName = _runtimeModule.getSimpleName();
        _builder.append(_simpleName, " ");
        _builder.append("}.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this.naming.getRuntimeGenModule(it);
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
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }
  
  public JavaFileAccess createEclipsePluginModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _eclipsePluginModule = this.naming.getEclipsePluginModule(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Use this class to register components to be used within the Eclipse IDE.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("@");
        _builder.append(FinalFieldsConstructor.class, "");
        _builder.append(" class ");
        TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this.naming.getEclipsePluginModule(it);
        String _simpleName = _eclipsePluginModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this.naming.getEclipsePluginGenModule(it);
        _builder.append(_eclipsePluginGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_eclipsePluginModule, _client);
  }
  
  public JavaFileAccess createEclipsePluginGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    GuiceModuleAccess _eclipsePluginGenModule = langConfig.getEclipsePluginGenModule();
    TypeReference _superClass = _eclipsePluginGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _eclipsePluginDefaultModule = this.naming.getEclipsePluginDefaultModule(it);
      _elvis = _eclipsePluginDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _eclipsePluginGenModule_1 = this.naming.getEclipsePluginGenModule(it);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_eclipsePluginGenModule_1);
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link ");
        TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this.naming.getEclipsePluginModule(it);
        String _simpleName = _eclipsePluginModule.getSimpleName();
        _builder.append(_simpleName, " ");
        _builder.append("}.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this.naming.getEclipsePluginGenModule(it);
        String _simpleName = _eclipsePluginGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginGenModule_1 = XtextGeneratorTemplates.this.naming.getEclipsePluginGenModule(it);
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
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }
  
  public JavaFileAccess createIdeaModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _ideaModule = this.naming.getIdeaModule(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Use this class to register components to be used within IntelliJ IDEA.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        TypeReference _ideaModule = XtextGeneratorTemplates.this.naming.getIdeaModule(it);
        String _simpleName = _ideaModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _ideaGenModule = XtextGeneratorTemplates.this.naming.getIdeaGenModule(it);
        _builder.append(_ideaGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_ideaModule, _client);
  }
  
  public JavaFileAccess createIdeaGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    GuiceModuleAccess _ideaGenModule = langConfig.getIdeaGenModule();
    TypeReference _superClass = _ideaGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _ideaDefaultModule = this.naming.getIdeaDefaultModule(it);
      _elvis = _ideaDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _ideaGenModule_1 = this.naming.getIdeaGenModule(it);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_ideaGenModule_1);
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link ");
        TypeReference _ideaModule = XtextGeneratorTemplates.this.naming.getIdeaModule(it);
        String _simpleName = _ideaModule.getSimpleName();
        _builder.append(_simpleName, " ");
        _builder.append("}.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _ideaGenModule = XtextGeneratorTemplates.this.naming.getIdeaGenModule(it);
        String _simpleName = _ideaGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _ideaGenModule_1 = langConfig.getIdeaGenModule();
          Set<GuiceModuleAccess.Binding> _bindings = _ideaGenModule_1.getBindings();
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
    file.setContent(_client_1);
    return file;
  }
  
  public JavaFileAccess createWebModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _webModule = this.naming.getWebModule(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Use this class to register additional components to be used within the web application.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("@");
        _builder.append(FinalFieldsConstructor.class, "");
        _builder.append(" class ");
        TypeReference _webModule = XtextGeneratorTemplates.this.naming.getWebModule(it);
        String _simpleName = _webModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _webGenModule = XtextGeneratorTemplates.this.naming.getWebGenModule(it);
        _builder.append(_webGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_webModule, _client);
  }
  
  public JavaFileAccess createWebGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    GuiceModuleAccess _webGenModule = langConfig.getWebGenModule();
    TypeReference _superClass = _webGenModule.getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _webDefaultModule = this.naming.getWebDefaultModule(it);
      _elvis = _webDefaultModule;
    }
    final TypeReference superClass = _elvis;
    TypeReference _webGenModule_1 = this.naming.getWebGenModule(it);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_webGenModule_1);
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link ");
        TypeReference _webModule = XtextGeneratorTemplates.this.naming.getWebModule(it);
        String _simpleName = _webModule.getSimpleName();
        _builder.append(_simpleName, " ");
        _builder.append("}.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _webGenModule = XtextGeneratorTemplates.this.naming.getWebGenModule(it);
        String _simpleName = _webGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _webGenModule_1 = XtextGeneratorTemplates.this.naming.getWebGenModule(it);
        String _simpleName_1 = _webGenModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        _builder.append(Provider.class, "\t");
        _builder.append("<");
        _builder.append(ExecutorService.class, "\t");
        _builder.append("> executorServiceProvider) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(executorServiceProvider);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _webGenModule_2 = langConfig.getWebGenModule();
          Set<GuiceModuleAccess.Binding> _bindings = _webGenModule_2.getBindings();
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
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }
  
  public JavaFileAccess createWebSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _webSetup = this.naming.getWebSetup(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Initialization support for running Xtext languages in web applications.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("@");
        _builder.append(FinalFieldsConstructor.class, "");
        _builder.append(" class ");
        TypeReference _webSetup = XtextGeneratorTemplates.this.naming.getWebSetup(it);
        String _simpleName = _webSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeSetup = XtextGeneratorTemplates.this.naming.getRuntimeSetup(it);
        _builder.append(_runtimeSetup, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("val ");
        _builder.append(Provider.class, "\t");
        _builder.append("<");
        _builder.append(ExecutorService.class, "\t");
        _builder.append("> executorServiceProvider;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("override ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("val runtimeModule = new ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this.naming.getRuntimeModule(it);
        _builder.append(_runtimeModule, "\t\t");
        _builder.append("()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("val webModule = new ");
        TypeReference _webModule = XtextGeneratorTemplates.this.naming.getWebModule(it);
        _builder.append(_webModule, "\t\t");
        _builder.append("(executorServiceProvider)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t");
        _builder.append(".createInjector(");
        _builder.append(Modules.class, "\t\t");
        _builder.append(".override(runtimeModule).with(webModule))");
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
    return this.fileAccessFactory.createXtendFile(_webSetup, _client);
  }
  
  public JavaFileAccess createEclipsePluginExecutableExtensionFactory(final IXtextGeneratorLanguage langConfig, final IXtextGeneratorLanguage activatorLanguage) {
    final Grammar grammar = langConfig.getGrammar();
    final Grammar activatorGrammar = activatorLanguage.getGrammar();
    TypeReference _eclipsePluginExecutableExtensionFactory = this.naming.getEclipsePluginExecutableExtensionFactory(grammar);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_eclipsePluginExecutableExtensionFactory);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
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
      }
    };
    file.setTypeComment(_client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _eclipsePluginExecutableExtensionFactory = XtextGeneratorTemplates.this.naming.getEclipsePluginExecutableExtensionFactory(grammar);
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
        TypeReference _eclipsePluginActivator = XtextGeneratorTemplates.this.naming.getEclipsePluginActivator(activatorGrammar);
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
        TypeReference _eclipsePluginActivator_1 = XtextGeneratorTemplates.this.naming.getEclipsePluginActivator(activatorGrammar);
        _builder.append(_eclipsePluginActivator_1, "\t\t");
        _builder.append(".getInstance().getInjector(");
        TypeReference _eclipsePluginActivator_2 = XtextGeneratorTemplates.this.naming.getEclipsePluginActivator(activatorGrammar);
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
    file.setContent(_client_1);
    return file;
  }
  
  public JavaFileAccess createEclipsePluginActivator(final List<? extends IXtextGeneratorLanguage> langConfigs) {
    IXtextGeneratorLanguage _head = IterableExtensions.head(langConfigs);
    Grammar _grammar = _head.getGrammar();
    final TypeReference activator = this.naming.getEclipsePluginActivator(_grammar);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(activator);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
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
      }
    };
    file.setTypeComment(_client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
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
          for(final IXtextGeneratorLanguage lang : langConfigs) {
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
          for(final IXtextGeneratorLanguage lang_1 : langConfigs) {
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
            Grammar _grammar_3 = lang_1.getGrammar();
            TypeReference _runtimeModule = XtextGeneratorTemplates.this.naming.getRuntimeModule(_grammar_3);
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
          for(final IXtextGeneratorLanguage lang_2 : langConfigs) {
            _builder.append("\t\t");
            _builder.append("if (");
            Grammar _grammar_4 = lang_2.getGrammar();
            String _name_3 = _grammar_4.getName();
            String _upperCase_2 = _name_3.toUpperCase();
            String _replaceAll_2 = _upperCase_2.replaceAll("\\.", "_");
            _builder.append(_replaceAll_2, "\t\t");
            _builder.append(".equals(grammar)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new ");
            Grammar _grammar_5 = lang_2.getGrammar();
            TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this.naming.getEclipsePluginModule(_grammar_5);
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
    file.setContent(_client_1);
    return file;
  }
}
