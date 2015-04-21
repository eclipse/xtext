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
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiAnonymousClass;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMirrorElement;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.impl.source.tree.JavaElementType;
import com.intellij.psi.impl.source.tree.RecursiveTreeElementWalkingVisitor;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.idea.extensions.IdeaProjectExtensions;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.idea.jvm.JvmLanguage;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnonymousClass;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;
import org.eclipse.xtext.xbase.idea.jvm.PsiJvmFileImpl;
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
      public void apply(final JvmPsiClass jvmPsiClass) {
        PsiClass _createStub = JvmPsiClassProvider.this.createStub();
        jvmPsiClass.setStub(_createStub);
        jvmPsiClass.setType(JvmPsiClassProvider.this.jvmDeclaredType);
        final Provider<PsiClass> _function = new Provider<PsiClass>() {
          @Override
          public PsiClass get() {
            return JvmPsiClassProvider.this.createPsiClass();
          }
        };
        jvmPsiClass.setPsiClassProvider(_function);
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
      final PsiElement psiElement = this._iPsiModelAssociations.getPsiElement(this.sourceElement);
      Project _project = psiElement.getProject();
      final PsiFileFactory psiFileFactory = IdeaProjectExtensions.getPsiFileFactory(_project);
      PsiFile _containingFile = psiElement.getContainingFile();
      VirtualFile _virtualFile = _containingFile.getVirtualFile();
      final PsiFile psiFile = psiFileFactory.createFileFromText(fileName, 
        JvmLanguage.INSTANCE, contents, 
        false, 
        false, 
        true, _virtualFile);
      PsiClass _xifexpression = null;
      if ((psiFile instanceof PsiJvmFileImpl)) {
        PsiClass _xblockexpression_1 = null;
        {
          PsiClass[] _classes = ((PsiJvmFileImpl)psiFile).getClasses();
          final PsiClass psiClass = IterableExtensions.<PsiClass>head(((Iterable<PsiClass>)Conversions.doWrapArray(_classes)));
          PsiClass _xifexpression_1 = null;
          boolean _notEquals = (!Objects.equal(psiClass, null));
          if (_notEquals) {
            PsiClass _xblockexpression_2 = null;
            {
              final HashMap<EObject, PsiElement> mapping = CollectionLiterals.<EObject, PsiElement>newHashMap();
              this.bindTo(psiClass, this.jvmDeclaredType, mapping);
              ((PsiJvmFileImpl)psiFile).setMapping(mapping);
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
  
  protected void _bindTo(final PsiElement psiElement, final Void void_, final Map<EObject, PsiElement> mapping) {
  }
  
  protected void _bindTo(final PsiElement psiElement, final EObject object, final Map<EObject, PsiElement> mapping) {
    this.doBindTo(psiElement, object, mapping);
  }
  
  protected void _bindTo(final PsiMethod psiMethod, final JvmExecutable jvmExecutable, final Map<EObject, PsiElement> mapping) {
    this._bindTo(psiMethod, ((JvmFeature) jvmExecutable), mapping);
    EList<JvmFormalParameter> _parameters = jvmExecutable.getParameters();
    final Iterator<JvmFormalParameter> i = _parameters.iterator();
    PsiParameterList _parameterList = psiMethod.getParameterList();
    PsiParameter[] _parameters_1 = _parameterList.getParameters();
    for (final PsiParameter parameter : _parameters_1) {
      {
        JvmFormalParameter _nextEObject = this.<JvmFormalParameter>nextEObject(i, JvmFormalParameter.class);
        this.bindTo(parameter, _nextEObject, mapping);
        boolean _hasNext = i.hasNext();
        boolean _not = (!_hasNext);
        if (_not) {
          return;
        }
      }
    }
  }
  
  private final static TokenSet BLOCK_ELEMENTS = TokenSet.create(
    JavaElementType.ANNOTATION, 
    JavaElementType.CLASS, 
    JavaElementType.ANONYMOUS_CLASS);
  
  protected void _bindTo(final PsiElement psiElement, final JvmFeature jvmFeature, final Map<EObject, PsiElement> mapping) {
    this.doBindTo(psiElement, jvmFeature, mapping);
    EList<JvmGenericType> _localClasses = jvmFeature.getLocalClasses();
    final Iterator<JvmGenericType> localClassesIterator = _localClasses.iterator();
    boolean _hasNext = localClassesIterator.hasNext();
    if (_hasNext) {
      ASTNode _node = psiElement.getNode();
      final ASTNode codeBlock = _node.findChildByType(JavaElementType.CODE_BLOCK);
      if ((codeBlock instanceof TreeElement)) {
        ((TreeElement)codeBlock).acceptTree(new RecursiveTreeElementWalkingVisitor() {
          @Override
          protected void visitNode(final TreeElement element) {
            IElementType _elementType = element.getElementType();
            boolean _contains = JvmPsiClassProvider.BLOCK_ELEMENTS.contains(_elementType);
            if (_contains) {
              PsiElement _psi = element.getPsi();
              JvmGenericType _next = localClassesIterator.next();
              JvmPsiClassProvider.this.bindTo(_psi, _next, mapping);
              boolean _hasNext = localClassesIterator.hasNext();
              boolean _not = (!_hasNext);
              if (_not) {
                super.stopWalking();
              }
            } else {
              super.visitNode(element);
            }
          }
        });
      }
    }
  }
  
  protected void _bindTo(final PsiClass psiClass, final JvmDeclaredType jvmDeclaredType, final Map<EObject, PsiElement> mapping) {
    final PsiElement mirror = this.doBindTo(psiClass, jvmDeclaredType, mapping);
    PsiMethod[] _constructors = psiClass.getConstructors();
    boolean _isEmpty = ((List<PsiMethod>)Conversions.doWrapArray(_constructors)).isEmpty();
    if (_isEmpty) {
      Iterable<JvmConstructor> _declaredConstructors = jvmDeclaredType.getDeclaredConstructors();
      for (final JvmConstructor declaredConstructor : _declaredConstructors) {
        mapping.put(declaredConstructor, mirror);
      }
    }
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
            this.bindTo(psiElement, _nextEObject, mapping);
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiMethod) {
            boolean _isConstructor = ((PsiMethod)psiElement).isConstructor();
            if (_isConstructor) {
              _matched=true;
              JvmConstructor _nextEObject = this.<JvmConstructor>nextEObject(i, JvmConstructor.class);
              this.bindTo(psiElement, _nextEObject, mapping);
            }
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiMethod) {
            _matched=true;
            JvmOperation _nextEObject = this.<JvmOperation>nextEObject(i, JvmOperation.class);
            this.bindTo(psiElement, _nextEObject, mapping);
          }
        }
        if (!_matched) {
          if (psiElement instanceof PsiClass) {
            _matched=true;
            JvmDeclaredType _nextEObject = this.<JvmDeclaredType>nextEObject(i, JvmDeclaredType.class);
            this.bindTo(psiElement, _nextEObject, mapping);
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
  
  protected PsiElement doBindTo(final PsiElement element, final EObject object, final Map<EObject, PsiElement> mapping) {
    PsiElement _xblockexpression = null;
    {
      final PsiElement mirror = this.mirror(element);
      mapping.put(object, mirror);
      JvmPsiElementExtensions.setJvmElement(mirror, object);
      final Provider<PsiElement> _function = new Provider<PsiElement>() {
        @Override
        public PsiElement get() {
          return JvmPsiClassProvider.this._iPsiJvmModelAssociations.getPrimarySourceElement(object);
        }
      };
      JvmPsiElementExtensions.setNavigationElementProvider(mirror, _function);
      _xblockexpression = mirror;
    }
    return _xblockexpression;
  }
  
  protected PsiElement mirror(final PsiElement element) {
    PsiElement _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof PsiMirrorElement) {
        _matched=true;
        _switchResult = element;
      }
    }
    if (!_matched) {
      if (element instanceof PsiAnonymousClass) {
        _matched=true;
        _switchResult = new JvmPsiAnonymousClass(((PsiAnonymousClass)element));
      }
    }
    if (!_matched) {
      _switchResult = element;
    }
    return _switchResult;
  }
  
  protected void bindTo(final PsiElement psiMethod, final EObject jvmExecutable, final Map<EObject, PsiElement> mapping) {
    if (psiMethod instanceof PsiMethod
         && jvmExecutable instanceof JvmExecutable) {
      _bindTo((PsiMethod)psiMethod, (JvmExecutable)jvmExecutable, mapping);
      return;
    } else if (psiMethod instanceof PsiClass
         && jvmExecutable instanceof JvmDeclaredType) {
      _bindTo((PsiClass)psiMethod, (JvmDeclaredType)jvmExecutable, mapping);
      return;
    } else if (psiMethod != null
         && jvmExecutable instanceof JvmFeature) {
      _bindTo(psiMethod, (JvmFeature)jvmExecutable, mapping);
      return;
    } else if (psiMethod != null
         && jvmExecutable != null) {
      _bindTo(psiMethod, jvmExecutable, mapping);
      return;
    } else if (psiMethod != null
         && jvmExecutable == null) {
      _bindTo(psiMethod, (Void)null, mapping);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(psiMethod, jvmExecutable, mapping).toString());
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
