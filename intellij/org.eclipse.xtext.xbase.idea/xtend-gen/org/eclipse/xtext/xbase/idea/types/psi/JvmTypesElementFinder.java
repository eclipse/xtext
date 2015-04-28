/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFinder;
import com.intellij.psi.search.GlobalSearchScope;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmTypesElementFinder extends PsiElementFinder {
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  private final Project project;
  
  private final IXtextLanguage language;
  
  public JvmTypesElementFinder(final IXtextLanguage language, final Project project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  @Override
  public PsiClass findClass(final String qualifiedName, final GlobalSearchScope scope) {
    Iterable<PsiClass> _doFindClasses = this.doFindClasses(qualifiedName, scope);
    return IterableExtensions.<PsiClass>head(_doFindClasses);
  }
  
  @Override
  public PsiClass[] findClasses(final String qualifiedName, final GlobalSearchScope scope) {
    return ((PsiClass[])Conversions.unwrapArray(this.doFindClasses(qualifiedName, scope), PsiClass.class));
  }
  
  protected Iterable<PsiClass> doFindClasses(final String qualifiedName, final GlobalSearchScope scope) {
    Iterable<String> _variants = this.getVariants(qualifiedName);
    final Function1<String, Iterable<PsiClass>> _function = new Function1<String, Iterable<PsiClass>>() {
      @Override
      public Iterable<PsiClass> apply(final String it) {
        return JvmTypesElementFinder.this.doFindClassesByVariant(it, scope);
      }
    };
    Iterable<Iterable<PsiClass>> _map = IterableExtensions.<String, Iterable<PsiClass>>map(_variants, _function);
    return Iterables.<PsiClass>concat(_map);
  }
  
  protected Iterable<PsiClass> doFindClassesByVariant(final String variant, final GlobalSearchScope scope) {
    Iterable<PsiClass> _xblockexpression = null;
    {
      final QualifiedName qualifiedName = this.toQualifiedName(variant);
      Iterable<BaseXtextFile> _findFiles = this.findFiles(variant, scope);
      final Function1<BaseXtextFile, Iterable<PsiClass>> _function = new Function1<BaseXtextFile, Iterable<PsiClass>>() {
        @Override
        public Iterable<PsiClass> apply(final BaseXtextFile it) {
          return JvmTypesElementFinder.this._jvmPsiClasses.getPsiClassesByQualifiedName(it, qualifiedName);
        }
      };
      Iterable<Iterable<PsiClass>> _map = IterableExtensions.<BaseXtextFile, Iterable<PsiClass>>map(_findFiles, _function);
      _xblockexpression = Iterables.<PsiClass>concat(_map);
    }
    return _xblockexpression;
  }
  
  protected Iterable<String> getVariants(final String qualifiedName) {
    final Iterable<String> _function = new Iterable<String>() {
      @Override
      public Iterator<String> iterator() {
        return new AbstractJvmTypeProvider.ClassNameVariants(qualifiedName);
      }
    };
    return Iterables.<String>concat(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(qualifiedName)), _function);
  }
  
  protected QualifiedName toQualifiedName(final String variant) {
    String[] _split = variant.split("\\.");
    return QualifiedName.create(_split);
  }
  
  protected Iterable<BaseXtextFile> findFiles(final String qualifiedName, final GlobalSearchScope scope) {
    Collection<BaseXtextFile> _get = this.exportedObjectQualifiedNameIndex.get(qualifiedName, this.project, scope);
    final Function1<BaseXtextFile, Boolean> _function = new Function1<BaseXtextFile, Boolean>() {
      @Override
      public Boolean apply(final BaseXtextFile xtextFile) {
        Language _language = xtextFile.getLanguage();
        return Boolean.valueOf(Objects.equal(_language, JvmTypesElementFinder.this.language));
      }
    };
    return IterableExtensions.<BaseXtextFile>filter(_get, _function);
  }
  
  @Override
  public Condition<PsiClass> getClassesFilter(final GlobalSearchScope scope) {
    final Condition<PsiClass> _function = new Condition<PsiClass>() {
      @Override
      public boolean value(final PsiClass psiClass) {
        if ((psiClass instanceof JvmPsiClass)) {
          return true;
        }
        String _qualifiedName = psiClass.getQualifiedName();
        PsiClass _findClass = JvmTypesElementFinder.this.findClass(_qualifiedName, scope);
        return Objects.equal(_findClass, null);
      }
    };
    return _function;
  }
}
