/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.idea.extensions.IdeaProjectExtensions;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.idea.jvm.JvmFileType;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.JvmPsiClassStubGenerator;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiClassProvider implements PsiElementProvider {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  @Inject
  private JvmModelGenerator jvmModelGenerator;
  
  @Inject
  @Extension
  private JvmPsiClassStubGenerator _jvmPsiClassStubGenerator;
  
  @Accessors
  private EObject sourceElement;
  
  @Accessors
  private JvmDeclaredType jvmDeclaredType;
  
  @Inject
  private Provider<JvmPsiClass> jvmPsiClassProvider;
  
  @Inject
  private ElementIssueProvider.Factory elementIssueProviderFactory;
  
  @Override
  public PsiElement get() {
    JvmPsiClass _get = this.jvmPsiClassProvider.get();
    final Procedure1<JvmPsiClass> _function = new Procedure1<JvmPsiClass>() {
      @Override
      public void apply(final JvmPsiClass it) {
        PsiClass _createStub = JvmPsiClassProvider.this.createStub();
        it.setStub(_createStub);
        final Provider<PsiClass> _function = new Provider<PsiClass>() {
          @Override
          public PsiClass get() {
            return JvmPsiClassProvider.this.createPsiClass();
          }
        };
        it.setPsiClassProvider(_function);
      }
    };
    return ObjectExtensions.<JvmPsiClass>operator_doubleArrow(_get, _function);
  }
  
  protected PsiClass createPsiClass() {
    final Procedure1<IFileSystemAccess> _function = new Procedure1<IFileSystemAccess>() {
      @Override
      public void apply(final IFileSystemAccess fileSystemAccess) {
        JvmPsiClassProvider.this.generatePsiClass(fileSystemAccess);
      }
    };
    return this.createPsiClass(_function);
  }
  
  protected void generatePsiClass(final IFileSystemAccess fileSystemAccess) {
    try {
      Resource _eResource = this.jvmDeclaredType.eResource();
      final Resource synchronizable = _eResource;
      boolean _matched = false;
      if (!_matched) {
        if (synchronizable instanceof ISynchronizable) {
          _matched=true;
          final IUnitOfWork<Object, Resource> _function = new IUnitOfWork<Object, Resource>() {
            @Override
            public Object exec(final Resource it) throws Exception {
              Object _xblockexpression = null;
              {
                JvmPsiClassProvider.this.doGeneratePsiClass(fileSystemAccess);
                _xblockexpression = null;
              }
              return _xblockexpression;
            }
          };
          ((ISynchronizable<Resource>)synchronizable).<Object>execute(_function);
        }
      }
      if (!_matched) {
        this.doGeneratePsiClass(fileSystemAccess);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doGeneratePsiClass(final IFileSystemAccess fileSystemAccess) {
    Resource _eResource = this.jvmDeclaredType.eResource();
    this.elementIssueProviderFactory.attachData(_eResource);
    try {
      this.jvmModelGenerator.internalDoGenerate(this.jvmDeclaredType, fileSystemAccess);
    } finally {
      Resource _eResource_1 = this.jvmDeclaredType.eResource();
      this.elementIssueProviderFactory.detachData(_eResource_1);
    }
  }
  
  protected PsiClass createStub() {
    final Procedure1<IFileSystemAccess> _function = new Procedure1<IFileSystemAccess>() {
      @Override
      public void apply(final IFileSystemAccess fileSystemAccess) {
        JvmPsiClassProvider.this._jvmPsiClassStubGenerator.generateStub(JvmPsiClassProvider.this.jvmDeclaredType, fileSystemAccess);
      }
    };
    return this.createPsiClass(_function);
  }
  
  protected PsiClass createPsiClass(final Procedure1<? super IFileSystemAccess> generator) {
    PsiClass _xblockexpression = null;
    {
      final ArrayList<Pair<String, CharSequence>> result = CollectionLiterals.<Pair<String, CharSequence>>newArrayList();
      IFileSystemAccess _fileSystemAccess = this.getFileSystemAccess(result);
      generator.apply(_fileSystemAccess);
      Pair<String, CharSequence> _head = IterableExtensions.<Pair<String, CharSequence>>head(result);
      final String fileName = _head.getKey();
      Pair<String, CharSequence> _head_1 = IterableExtensions.<Pair<String, CharSequence>>head(result);
      final CharSequence contents = _head_1.getValue();
      _xblockexpression = this.createPsiClass(fileName, contents);
    }
    return _xblockexpression;
  }
  
  protected IFileSystemAccess getFileSystemAccess(final List<Pair<String, CharSequence>> result) {
    return new IFileSystemAccess() {
      @Override
      public void deleteFile(final String fileName) {
      }
      
      @Override
      public void generateFile(final String fileName, final CharSequence contents) {
        Pair<String, CharSequence> _mappedTo = Pair.<String, CharSequence>of(fileName, contents);
        result.add(_mappedTo);
      }
      
      @Override
      public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
      }
    };
  }
  
  protected PsiClass createPsiClass(final String fileName, final CharSequence contents) {
    PsiClass _xblockexpression = null;
    {
      PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(this.sourceElement);
      Project _project = _psiElement.getProject();
      final PsiFileFactory psiFileFactory = IdeaProjectExtensions.getPsiFileFactory(_project);
      final PsiFile psiFile = psiFileFactory.createFileFromText(fileName, 
        JvmFileType.INSTANCE, contents);
      PsiClass _xifexpression = null;
      if ((psiFile instanceof PsiJavaFile)) {
        PsiClass _xblockexpression_1 = null;
        {
          PsiClass[] _classes = ((PsiJavaFile)psiFile).getClasses();
          final PsiClass psiClass = IterableExtensions.<PsiClass>head(((Iterable<PsiClass>)Conversions.doWrapArray(_classes)));
          PsiClass _xifexpression_1 = null;
          boolean _notEquals = (!Objects.equal(psiClass, null));
          if (_notEquals) {
            PsiClass _xblockexpression_2 = null;
            {
              this.bindTo(psiClass, this.jvmDeclaredType);
              _xblockexpression_2 = psiClass;
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void _bindTo(final PsiElement psiElement, final Void void_) {
  }
  
  protected void _bindTo(final PsiElement psiElement, final EObject object) {
    this.doBindTo(psiElement, object);
  }
  
  protected void _bindTo(final PsiMethod psiMethod, final JvmExecutable jvmExecutable) {
    this.doBindTo(psiMethod, jvmExecutable);
    EList<JvmFormalParameter> _parameters = jvmExecutable.getParameters();
    final Iterator<JvmFormalParameter> i = _parameters.iterator();
    PsiParameterList _parameterList = psiMethod.getParameterList();
    PsiParameter[] _parameters_1 = _parameterList.getParameters();
    for (final PsiParameter parameter : _parameters_1) {
      {
        JvmFormalParameter _nextEObject = this.<JvmFormalParameter>nextEObject(i, JvmFormalParameter.class);
        this.bindTo(parameter, _nextEObject);
        boolean _hasNext = i.hasNext();
        boolean _not = (!_hasNext);
        if (_not) {
          return;
        }
      }
    }
  }
  
  protected void _bindTo(final PsiClass psiClass, final JvmDeclaredType jvmDeclaredType) {
    this.doBindTo(psiClass, jvmDeclaredType);
    EList<EObject> _eContents = jvmDeclaredType.eContents();
    final Iterator<EObject> i = _eContents.iterator();
    PsiElement[] _children = psiClass.getChildren();
    for (final PsiElement psiElement : _children) {
      {
        boolean _matched = false;
        if (!_matched) {
          if (psiElement instanceof PsiField) {
            _matched=true;
            JvmField _nextEObject = this.<JvmField>nextEObject(i, JvmField.class);
            this.bindTo(psiElement, _nextEObject);
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiMethod) {
            boolean _isConstructor = ((PsiMethod)psiElement).isConstructor();
            if (_isConstructor) {
              _matched=true;
              JvmConstructor _nextEObject = this.<JvmConstructor>nextEObject(i, JvmConstructor.class);
              this.bindTo(psiElement, _nextEObject);
            }
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiMethod) {
            _matched=true;
            JvmOperation _nextEObject = this.<JvmOperation>nextEObject(i, JvmOperation.class);
            this.bindTo(psiElement, _nextEObject);
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiClass) {
            _matched=true;
            JvmDeclaredType _nextEObject = this.<JvmDeclaredType>nextEObject(i, JvmDeclaredType.class);
            this.bindTo(psiElement, _nextEObject);
          }
        }
        boolean _hasNext = i.hasNext();
        boolean _not = (!_hasNext);
        if (_not) {
          return;
        }
      }
    }
  }
  
  protected <T extends EObject> T nextEObject(final Iterator<? extends EObject> i, final Class<T> clazz) {
    while (i.hasNext()) {
      {
        final EObject object = i.next();
        boolean _isInstance = clazz.isInstance(object);
        if (_isInstance) {
          return ((T) object);
        }
      }
    }
    return null;
  }
  
  protected void doBindTo(final PsiElement element, final EObject object) {
    JvmPsiElementExtensions.setJvmElement(element, object);
    final Provider<PsiElement> _function = new Provider<PsiElement>() {
      @Override
      public PsiElement get() {
        return JvmPsiClassProvider.this._iPsiJvmModelAssociations.getPrimarySourceElement(object);
      }
    };
    JvmPsiElementExtensions.setNavigationElementProvider(element, _function);
  }
  
  protected void bindTo(final PsiElement psiMethod, final EObject jvmExecutable) {
    if (psiMethod instanceof PsiMethod
         && jvmExecutable instanceof JvmExecutable) {
      _bindTo((PsiMethod)psiMethod, (JvmExecutable)jvmExecutable);
      return;
    } else if (psiMethod instanceof PsiClass
         && jvmExecutable instanceof JvmDeclaredType) {
      _bindTo((PsiClass)psiMethod, (JvmDeclaredType)jvmExecutable);
      return;
    } else if (psiMethod != null
         && jvmExecutable != null) {
      _bindTo(psiMethod, jvmExecutable);
      return;
    } else if (psiMethod != null
         && jvmExecutable == null) {
      _bindTo(psiMethod, (Void)null);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(psiMethod, jvmExecutable).toString());
    }
  }
  
  @Pure
  public EObject getSourceElement() {
    return this.sourceElement;
  }
  
  public void setSourceElement(final EObject sourceElement) {
    this.sourceElement = sourceElement;
  }
  
  @Pure
  public JvmDeclaredType getJvmDeclaredType() {
    return this.jvmDeclaredType;
  }
  
  public void setJvmDeclaredType(final JvmDeclaredType jvmDeclaredType) {
    this.jvmDeclaredType = jvmDeclaredType;
  }
}
