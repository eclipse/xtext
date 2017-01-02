/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.execution;

import org.eclipse.xtend.idea.XtendIdeaTestCase;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedConfigurationProducerTest extends XtendIdeaTestCase {
  @Override
  protected boolean isTestSource(final /* VirtualFile */Object srcFolder) {
    return true;
  }
  
  public void testApplicationConfiguration_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nBaseXtextFile cannot be resolved to a type."
      + "\nRunConfigurationProducer cannot be resolved to a type."
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method assertTrue(boolean) is undefined"
      + "\nThe method or field XtendApplicationConfigurationProducer is undefined"
      + "\nThe method assertEquals(Set<Object>, Object) is undefined"
      + "\nThe method or field module is undefined"
      + "\nThe method or field ContainerUtilRt is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method or field PsiMethodUtil is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method or field XtendApplicationConfigurationProducer is undefined"
      + "\nThe method or field RunConfigurationProducer is undefined"
      + "\nThe method or field XtendApplicationConfigurationProducer is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nApplicationConfiguration cannot be resolved to a type."
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method createContext(PsiElement) from the type TraceBasedConfigurationProducerTest refers to the missing type ConfigurationContext"
      + "\nfindFile cannot be resolved"
      + "\nviewProvider cannot be resolved"
      + "\nfindElementAt cannot be resolved"
      + "\nnewHashSet cannot be resolved"
      + "\ngetModules cannot be resolved"
      + "\nhasMainMethod cannot be resolved"
      + "\nmainClass cannot be resolved"
      + "\nmainClass cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\ngetName cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\nisConfigurationFromContext cannot be resolved");
  }
  
  public void testApplicationConfiguration_2() {
    throw new Error("Unresolved compilation problems:"
      + "\nBaseXtextFile cannot be resolved to a type."
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method assertTrue(boolean) is undefined"
      + "\nThe method or field RunConfigurationProducer is undefined"
      + "\nThe method or field XtendApplicationConfigurationProducer is undefined"
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method createContext(PsiElement) from the type TraceBasedConfigurationProducerTest refers to the missing type ConfigurationContext"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nfindFile cannot be resolved"
      + "\nviewProvider cannot be resolved"
      + "\nfindElementAt cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ncreateConfigurationFromContext cannot be resolved"
      + "\nconfiguration cannot be resolved");
  }
  
  public void testApplicationConfigurationNoSelection() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method or field XtendApplicationConfigurationProducer is undefined"
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nfindFile cannot be resolved");
  }
  
  public void testJunitConfigurationNoSelection() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field module is undefined"
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method or field XtendJunitClassConfigurationProducer is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method addJunit4Lib(Module) from the type TraceBasedConfigurationProducerTest refers to the missing type Object"
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nfindFile cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nMAIN_CLASS_NAME cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nTEST_OBJECT cannot be resolved");
  }
  
  public void testJunitConfigurationMethod_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nBaseXtextFile cannot be resolved to a type."
      + "\nThe method or field module is undefined"
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method assertTrue(boolean) is undefined"
      + "\nThe method or field XtendJunitMethodConfigurationProducer is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method addJunit4Lib(Module) from the type TraceBasedConfigurationProducerTest refers to the missing type Object"
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nfindFile cannot be resolved"
      + "\nviewProvider cannot be resolved"
      + "\nfindElementAt cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nMAIN_CLASS_NAME cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nTEST_OBJECT cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nMETHOD_NAME cannot be resolved");
  }
  
  public void testJunitConfigurationMethod_2() {
    throw new Error("Unresolved compilation problems:"
      + "\nBaseXtextFile cannot be resolved to a type."
      + "\nThe method or field module is undefined"
      + "\nThe method addFile(Object) is undefined"
      + "\n-> cannot be resolved."
      + "\nThe method or field psiManager is undefined"
      + "\nThe method assertTrue(boolean) is undefined"
      + "\nThe method or field XtendJunitMethodConfigurationProducer is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method addJunit4Lib(Module) from the type TraceBasedConfigurationProducerTest refers to the missing type Object"
      + "\nThe method createConfiguration(PsiElement, Class<? extends RunConfigurationProducer>) from the type TraceBasedConfigurationProducerTest refers to the missing type RunConfiguration"
      + "\nThe method checkCanRun(RunConfiguration) from the type TraceBasedConfigurationProducerTest refers to the missing type JavaParameters"
      + "\nfindFile cannot be resolved"
      + "\nviewProvider cannot be resolved"
      + "\nfindElementAt cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nMAIN_CLASS_NAME cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nTEST_OBJECT cannot be resolved"
      + "\ngetPersistentData cannot be resolved"
      + "\nMETHOD_NAME cannot be resolved");
  }
  
  protected Object addJunit4Lib(final /* Module */Object module) {
    throw new Error("Unresolved compilation problems:"
      + "\nJavaTestFramework cannot be resolved to a type."
      + "\nThe method or field Extensions is undefined"
      + "\nThe method or field TestFramework is undefined"
      + "\n== cannot be resolved."
      + "\nThe method or field name is undefined"
      + "\ngetExtensions cannot be resolved"
      + "\nEXTENSION_NAME cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\nisLibraryAttached cannot be resolved"
      + "\n! cannot be resolved"
      + "\nsetupLibrary cannot be resolved");
  }
  
  protected <T/*  extends RunConfiguration */> T createConfiguration(final /* PsiElement */Object psiElement, final /* Class<? extends RunConfigurationProducer<T>> */Object clazz) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field RunConfigurationProducer is undefined"
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method createContext(PsiElement) from the type TraceBasedConfigurationProducerTest refers to the missing type ConfigurationContext"
      + "\ngetInstance cannot be resolved"
      + "\ncreateConfigurationFromContext cannot be resolved"
      + "\ngetConfiguration cannot be resolved");
  }
  
  private /* ConfigurationContext */Object createContext(/* @NotNull  */final /* PsiElement */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nMapDataContext cannot be resolved."
      + "\nThe method createContext(PsiElement, MapDataContext) from the type TraceBasedConfigurationProducerTest refers to the missing type ConfigurationContext");
  }
  
  private /* ConfigurationContext */Object createContext(/* @NotNull  */final /* PsiElement */Object psiClass, /* @NotNull  */final /* MapDataContext */Object dataContext) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CommonDataKeys is undefined"
      + "\nThe method or field myProject is undefined"
      + "\nThe method or field LangDataKeys is undefined"
      + "\nThe method or field LangDataKeys is undefined"
      + "\nThe method or field ModuleUtilCore is undefined"
      + "\nThe method or field Location is undefined"
      + "\nThe method or field PsiLocation is undefined"
      + "\nThe method or field ConfigurationContext is undefined"
      + "\nput cannot be resolved"
      + "\nPROJECT cannot be resolved"
      + "\nMODULE cannot be resolved"
      + "\ngetData cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nput cannot be resolved"
      + "\nMODULE cannot be resolved"
      + "\nfindModuleForPsiElement cannot be resolved"
      + "\nput cannot be resolved"
      + "\nDATA_KEY cannot be resolved"
      + "\nfromPsiElement cannot be resolved"
      + "\ngetFromContext cannot be resolved");
  }
  
  public static /* JavaParameters */Object checkCanRun(final /* RunConfiguration */Object configuration)/*  throws ExecutionException */ {
    throw new Error("Unresolved compilation problems:"
      + "\nRunProfileState cannot be resolved to a type."
      + "\nJavaCommandLine cannot be resolved to a type."
      + "\nRuntimeConfigurationError cannot be resolved to a type."
      + "\nRuntimeConfigurationException cannot be resolved to a type."
      + "\nJavaCommandLine cannot be resolved to a type."
      + "\nThe method or field ExecutionEnvironmentBuilder is undefined"
      + "\nThe method or field DefaultRunExecutor is undefined"
      + "\nThe method assertNotNull(RunProfileState) is undefined"
      + "\nThe method assertTrue(boolean) is undefined"
      + "\nThe method fail(Object) is undefined"
      + "\n+ cannot be resolved."
      + "\nThe method fail(Object) is undefined"
      + "\n+ cannot be resolved."
      + "\nUnreachable code: The catch block can never match. It is already handled by a previous condition."
      + "\ncreate cannot be resolved"
      + "\ngetRunExecutorInstance cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ngetState cannot be resolved"
      + "\ncheckConfiguration cannot be resolved"
      + "\ngetMessage cannot be resolved"
      + "\ngetMessage cannot be resolved"
      + "\ngetJavaParameters cannot be resolved");
  }
}
