/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiShortNamesCache;
import com.intellij.util.ArrayUtil;
import com.intellij.util.CommonProcessors;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.HashSet;
import java.util.Collection;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmTypesShortNamesCache extends PsiShortNamesCache {
  @Inject
  private JvmPsiClasses jvmPsiClasses;
  
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  private final Project project;
  
  private final IXtextLanguage language;
  
  public JvmTypesShortNamesCache(final IXtextLanguage language, final Project project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  @Override
  public String[] getAllClassNames() {
    return ((String[])Conversions.unwrapArray(this.jvmDeclaredTypeShortNameIndex.getAllKeys(this.project), String.class));
  }
  
  @Override
  public void getAllClassNames(final HashSet<String> dest) {
    CommonProcessors.CollectProcessor<String> _collectProcessor = new CommonProcessors.CollectProcessor<String>(dest);
    this.processAllClassNames(_collectProcessor);
  }
  
  @Override
  public boolean processAllClassNames(final Processor<String> processor) {
    return this.jvmDeclaredTypeShortNameIndex.processAllKeys(this.project, processor);
  }
  
  @Override
  public String[] getAllFieldNames() {
    return ArrayUtil.EMPTY_STRING_ARRAY;
  }
  
  @Override
  public void getAllFieldNames(final HashSet<String> set) {
  }
  
  @Override
  public String[] getAllMethodNames() {
    return ArrayUtil.EMPTY_STRING_ARRAY;
  }
  
  @Override
  public void getAllMethodNames(final HashSet<String> set) {
  }
  
  @Override
  public PsiClass[] getClassesByName(final String name, final GlobalSearchScope scope) {
    Collection<BaseXtextFile> _get = this.jvmDeclaredTypeShortNameIndex.get(name, this.project, scope);
    final Function1<BaseXtextFile, Boolean> _function = new Function1<BaseXtextFile, Boolean>() {
      @Override
      public Boolean apply(final BaseXtextFile xtextFile) {
        Language _language = xtextFile.getLanguage();
        return Boolean.valueOf(Objects.equal(_language, JvmTypesShortNamesCache.this.language));
      }
    };
    Iterable<BaseXtextFile> _filter = IterableExtensions.<BaseXtextFile>filter(_get, _function);
    final Function1<BaseXtextFile, Iterable<PsiClass>> _function_1 = new Function1<BaseXtextFile, Iterable<PsiClass>>() {
      @Override
      public Iterable<PsiClass> apply(final BaseXtextFile xtextFile) {
        return JvmTypesShortNamesCache.this.jvmPsiClasses.getPsiClassesByName(xtextFile, name);
      }
    };
    Iterable<Iterable<PsiClass>> _map = IterableExtensions.<BaseXtextFile, Iterable<PsiClass>>map(_filter, _function_1);
    return ((PsiClass[])Conversions.unwrapArray(Iterables.<PsiClass>concat(_map), PsiClass.class));
  }
  
  @Override
  public PsiField[] getFieldsByName(final String name, final GlobalSearchScope scope) {
    return PsiField.EMPTY_ARRAY;
  }
  
  @Override
  public PsiField[] getFieldsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return PsiField.EMPTY_ARRAY;
  }
  
  @Override
  public PsiMethod[] getMethodsByName(final String name, final GlobalSearchScope scope) {
    return PsiMethod.EMPTY_ARRAY;
  }
  
  @Override
  public PsiMethod[] getMethodsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return PsiMethod.EMPTY_ARRAY;
  }
  
  @Override
  public boolean processMethodsWithName(final String name, final GlobalSearchScope scope, final Processor<PsiMethod> processor) {
    PsiMethod[] _methodsByName = this.getMethodsByName(name, scope);
    return ContainerUtil.<PsiMethod>process(_methodsByName, processor);
  }
}
