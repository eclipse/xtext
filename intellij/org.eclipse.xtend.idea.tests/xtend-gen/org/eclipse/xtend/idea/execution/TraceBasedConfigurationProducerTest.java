/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.execution;

import com.google.common.base.Objects;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.Location;
import com.intellij.execution.PsiLocation;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.ConfigurationFromContext;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.configurations.JavaCommandLine;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationError;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ExecutionEnvironmentBuilder;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiMethodUtil;
import com.intellij.testFramework.MapDataContext;
import com.intellij.testIntegration.JavaTestFramework;
import com.intellij.testIntegration.TestFramework;
import com.intellij.util.containers.ContainerUtilRt;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.execution.XtendApplicationConfigurationProducer;
import org.eclipse.xtend.core.idea.execution.XtendJunitClassConfigurationProducer;
import org.eclipse.xtend.core.idea.execution.XtendJunitMethodConfigurationProducer;
import org.eclipse.xtend.idea.XtendIdeaTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jetbrains.annotations.NotNull;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedConfigurationProducerTest extends XtendIdeaTestCase {
  public void testApplicationConfiguration_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* Test");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class XtendMainClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/** test method */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void m|ain(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Hello\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"World\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String code = _builder.toString();
      final int cursorIdx = code.indexOf("|");
      String _replace = code.replace("|", "");
      code = _replace;
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendMainClass.xtend", code);
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      TestCase.assertTrue((xtendFile instanceof BaseXtextFile));
      FileViewProvider _viewProvider = xtendFile.getViewProvider();
      final PsiElement sourceElement = _viewProvider.findElementAt(cursorIdx);
      final ApplicationConfiguration configuration = this.<ApplicationConfiguration>createConfiguration(sourceElement, XtendApplicationConfigurationProducer.class);
      Module _module = this.getModule();
      Set<Module> _singleton = Collections.<Module>singleton(_module);
      Module[] _modules = configuration.getModules();
      HashSet<Module> _newHashSet = ContainerUtilRt.<Module>newHashSet(_modules);
      TestCase.assertEquals(_singleton, _newHashSet);
      PsiClass _mainClass = configuration.getMainClass();
      boolean _hasMainMethod = PsiMethodUtil.hasMainMethod(_mainClass);
      TestCase.assertTrue(_hasMainMethod);
      PsiClass _mainClass_1 = configuration.getMainClass();
      String _qualifiedName = _mainClass_1.getQualifiedName();
      TestCase.assertEquals("XtendMainClass", _qualifiedName);
      String _name = configuration.getName();
      TestCase.assertEquals("XtendMainClass", _name);
      TraceBasedConfigurationProducerTest.checkCanRun(configuration);
      final ApplicationConfiguration sameConfiguration = this.<ApplicationConfiguration>createConfiguration(sourceElement, XtendApplicationConfigurationProducer.class);
      final RunConfigurationProducer<ApplicationConfiguration> producer = RunConfigurationProducer.<XtendApplicationConfigurationProducer>getInstance(XtendApplicationConfigurationProducer.class);
      ConfigurationContext _createContext = this.createContext(sourceElement);
      boolean _isConfigurationFromContext = producer.isConfigurationFromContext(sameConfiguration, _createContext);
      TestCase.assertTrue(_isConfigurationFromContext);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testApplicationConfiguration_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("|");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* Test");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class XtendMainClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/** test method */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Hello\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"World\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String code = _builder.toString();
      final int cursorIdx = code.indexOf("|");
      String _replace = code.replace("|", "");
      code = _replace;
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendMainClass.xtend", code);
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      TestCase.assertTrue((xtendFile instanceof BaseXtextFile));
      FileViewProvider _viewProvider = xtendFile.getViewProvider();
      final PsiElement sourceElement = _viewProvider.findElementAt(cursorIdx);
      final ConfigurationContext context = this.createContext(sourceElement);
      final XtendApplicationConfigurationProducer producer = RunConfigurationProducer.<XtendApplicationConfigurationProducer>getInstance(XtendApplicationConfigurationProducer.class);
      final ConfigurationFromContext confFromContext = producer.createConfigurationFromContext(context);
      TestCase.assertNotNull(confFromContext);
      RunConfiguration _configuration = confFromContext.getConfiguration();
      TraceBasedConfigurationProducerTest.checkCanRun(_configuration);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testApplicationConfigurationNoSelection() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class XtendMainClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendMainClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      final ApplicationConfiguration conf = this.<ApplicationConfiguration>createConfiguration(xtendFile, XtendApplicationConfigurationProducer.class);
      TraceBasedConfigurationProducerTest.checkCanRun(conf);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testJunitConfigurationNoSelection() {
    try {
      Module _module = this.getModule();
      this.addJunit4Lib(_module);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.junit.Assert");
      _builder.newLine();
      _builder.append("import org.junit.Test");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class XtendJunitClass extends Assert{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void testMethod() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void testMethod2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendJunitClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      final JUnitConfiguration conf = this.<JUnitConfiguration>createConfiguration(xtendFile, XtendJunitClassConfigurationProducer.class);
      JUnitConfiguration.Data _persistentData = conf.getPersistentData();
      TestCase.assertEquals("XtendJunitClass", _persistentData.MAIN_CLASS_NAME);
      JUnitConfiguration.Data _persistentData_1 = conf.getPersistentData();
      TestCase.assertEquals("class", _persistentData_1.TEST_OBJECT);
      TraceBasedConfigurationProducerTest.checkCanRun(conf);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testJunitConfigurationMethod_1() {
    try {
      Module _module = this.getModule();
      this.addJunit4Lib(_module);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.junit.Assert");
      _builder.newLine();
      _builder.append("import org.junit.Test");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class XtendJunitClass extends Assert{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void test|Method() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void testMethod2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String code = _builder.toString();
      final int cursorIdx = code.indexOf("|");
      String _replace = code.replace("|", "");
      code = _replace;
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendJunitClass.xtend", code);
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      TestCase.assertTrue((xtendFile instanceof BaseXtextFile));
      FileViewProvider _viewProvider = xtendFile.getViewProvider();
      final PsiElement sourceElement = _viewProvider.findElementAt(cursorIdx);
      final JUnitConfiguration configuration = this.<JUnitConfiguration>createConfiguration(sourceElement, XtendJunitMethodConfigurationProducer.class);
      JUnitConfiguration.Data _persistentData = configuration.getPersistentData();
      TestCase.assertEquals("XtendJunitClass", _persistentData.MAIN_CLASS_NAME);
      JUnitConfiguration.Data _persistentData_1 = configuration.getPersistentData();
      TestCase.assertEquals("method", _persistentData_1.TEST_OBJECT);
      JUnitConfiguration.Data _persistentData_2 = configuration.getPersistentData();
      TestCase.assertEquals("testMethod", _persistentData_2.METHOD_NAME);
      TraceBasedConfigurationProducerTest.checkCanRun(configuration);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testJunitConfigurationMethod_2() {
    try {
      Module _module = this.getModule();
      this.addJunit4Lib(_module);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.junit.Assert");
      _builder.newLine();
      _builder.append("import org.junit.Test");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class XtendJunitClass extends Assert{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void testMethod() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void testM|ethod2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("assertTrue(true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String code = _builder.toString();
      final int cursorIdx = code.indexOf("|");
      String _replace = code.replace("|", "");
      code = _replace;
      Pair<String, String> _mappedTo = Pair.<String, String>of("XtendMainClass.xtend", code);
      final VirtualFile file = this.addFile(_mappedTo);
      PsiManager _psiManager = this.getPsiManager();
      final PsiFile xtendFile = _psiManager.findFile(file);
      TestCase.assertTrue((xtendFile instanceof BaseXtextFile));
      FileViewProvider _viewProvider = xtendFile.getViewProvider();
      final PsiElement sourceElement = _viewProvider.findElementAt(cursorIdx);
      final JUnitConfiguration configuration = this.<JUnitConfiguration>createConfiguration(sourceElement, XtendJunitMethodConfigurationProducer.class);
      JUnitConfiguration.Data _persistentData = configuration.getPersistentData();
      TestCase.assertEquals("XtendJunitClass", _persistentData.MAIN_CLASS_NAME);
      JUnitConfiguration.Data _persistentData_1 = configuration.getPersistentData();
      TestCase.assertEquals("method", _persistentData_1.TEST_OBJECT);
      JUnitConfiguration.Data _persistentData_2 = configuration.getPersistentData();
      TestCase.assertEquals("testMethod2", _persistentData_2.METHOD_NAME);
      TraceBasedConfigurationProducerTest.checkCanRun(configuration);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void addJunit4Lib(final Module module) {
    final TestFramework[] frameworks = Extensions.<TestFramework>getExtensions(TestFramework.EXTENSION_NAME);
    final Function1<TestFramework, Boolean> _function = new Function1<TestFramework, Boolean>() {
      @Override
      public Boolean apply(final TestFramework it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal("JUnit4", _name));
      }
    };
    final TestFramework junit4 = IterableExtensions.<TestFramework>findFirst(((Iterable<TestFramework>)Conversions.doWrapArray(frameworks)), _function);
    boolean _isLibraryAttached = junit4.isLibraryAttached(module);
    boolean _not = (!_isLibraryAttached);
    if (_not) {
      if ((junit4 instanceof JavaTestFramework)) {
        ((JavaTestFramework)junit4).setupLibrary(module);
      }
    }
  }
  
  protected <T extends RunConfiguration> T createConfiguration(final PsiElement psiElement, final Class<? extends RunConfigurationProducer<T>> clazz) {
    final ConfigurationContext context = this.createContext(psiElement);
    final RunConfigurationProducer<T> producer = RunConfigurationProducer.<RunConfigurationProducer<T>>getInstance(clazz);
    TestCase.assertNotNull(producer);
    final ConfigurationFromContext fromContext = producer.createConfigurationFromContext(context);
    TestCase.assertNotNull(fromContext);
    RunConfiguration _configuration = fromContext.getConfiguration();
    return ((T) _configuration);
  }
  
  private ConfigurationContext createContext(@NotNull final PsiElement psiClass) {
    final MapDataContext dataContext = new MapDataContext();
    return this.createContext(psiClass, dataContext);
  }
  
  private ConfigurationContext createContext(@NotNull final PsiElement psiClass, @NotNull final MapDataContext dataContext) {
    dataContext.<Project>put(CommonDataKeys.PROJECT, this.myProject);
    Module _data = LangDataKeys.MODULE.getData(dataContext);
    boolean _equals = Objects.equal(_data, null);
    if (_equals) {
      Module _findModuleForPsiElement = ModuleUtilCore.findModuleForPsiElement(psiClass);
      dataContext.<Module>put(LangDataKeys.MODULE, _findModuleForPsiElement);
    }
    Location<PsiElement> _fromPsiElement = PsiLocation.<PsiElement>fromPsiElement(psiClass);
    dataContext.<Location<?>>put(Location.DATA_KEY, _fromPsiElement);
    return ConfigurationContext.getFromContext(dataContext);
  }
  
  public static JavaParameters checkCanRun(final RunConfiguration configuration) throws ExecutionException {
    Executor _runExecutorInstance = DefaultRunExecutor.getRunExecutorInstance();
    ExecutionEnvironmentBuilder _create = ExecutionEnvironmentBuilder.create(_runExecutorInstance, configuration);
    ExecutionEnvironment _build = _create.build();
    final RunProfileState state = _build.getState();
    TestCase.assertNotNull(state);
    TestCase.assertTrue((state instanceof JavaCommandLine));
    try {
      configuration.checkConfiguration();
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeConfigurationError) {
        final RuntimeConfigurationError e = (RuntimeConfigurationError)_t;
        String _message = e.getMessage();
        String _plus = ("cannot run: " + _message);
        TestCase.fail(_plus);
      } else if (_t instanceof RuntimeConfigurationException) {
        final RuntimeConfigurationException e_1 = (RuntimeConfigurationException)_t;
        String _message_1 = e_1.getMessage();
        String _plus_1 = ("cannot run: " + _message_1);
        TestCase.fail(_plus_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return ((JavaCommandLine) state).getJavaParameters();
  }
}
