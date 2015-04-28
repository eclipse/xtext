/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.HierarchicalMethodSignature;
import com.intellij.psi.JVMElementFactories;
import com.intellij.psi.JVMElementFactory;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassInitializer;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifier;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiNameHelper;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReferenceList;
import com.intellij.psi.PsiSubstitutor;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterList;
import com.intellij.psi.PsiTypeParameterListOwner;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.InheritanceImplUtil;
import com.intellij.psi.impl.PsiClassImplUtil;
import com.intellij.psi.impl.PsiImplUtil;
import com.intellij.psi.impl.PsiSuperMethodImplUtil;
import com.intellij.psi.impl.light.LightClassReference;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.impl.light.LightParameter;
import com.intellij.psi.impl.light.LightParameterListBuilder;
import com.intellij.psi.impl.light.LightReferenceListBuilder;
import com.intellij.psi.impl.light.LightTypeParameter;
import com.intellij.psi.impl.light.LightTypeParameterListBuilder;
import com.intellij.psi.impl.source.ClassInnerStuffCache;
import com.intellij.psi.impl.source.PsiClassReferenceType;
import com.intellij.psi.impl.source.PsiExtensibleClass;
import com.intellij.psi.impl.source.javadoc.PsiDocCommentImpl;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.impl.NameConcatHelper;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.impl.AnnotatableModifierList;
import org.eclipse.xtext.xbase.idea.types.psi.impl.LightAnnotation;
import org.eclipse.xtext.xbase.idea.types.psi.impl.LightFieldBuilder;
import org.eclipse.xtext.xbase.idea.types.psi.impl.LightMethodBuilder;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XComputedTypeReference;

@SuppressWarnings("all")
public class JvmPsiClassImpl extends LightElement implements JvmPsiClass, PsiExtensibleClass {
  @Inject
  private PsiModelAssociations psiAssocations;
  
  @Inject
  private IJvmModelAssociations jvmAssocations;
  
  private final JvmDeclaredType jvmType;
  
  private final PsiElement psiElement;
  
  private final ClassInnerStuffCache membersCache;
  
  private PsiTypeParameterList typeParameterList;
  
  public JvmPsiClassImpl(final JvmDeclaredType declaredType, final PsiElement psiElement) {
    super(psiElement.getManager(), psiElement.getLanguage());
    this.jvmType = declaredType;
    this.psiElement = psiElement;
    final Language language = this.getLanguage();
    if ((language instanceof IXtextLanguage)) {
      ((IXtextLanguage)language).injectMembers(this);
    }
    JvmPsiElementExtensions.setJvmElement(this, declaredType);
    ClassInnerStuffCache _classInnerStuffCache = new ClassInnerStuffCache(this);
    this.membersCache = _classInnerStuffCache;
  }
  
  @Override
  public EClass getType() {
    return this.jvmType.eClass();
  }
  
  @Override
  public PsiElement copy() {
    return new JvmPsiClassImpl(this.jvmType, this.psiElement);
  }
  
  @Override
  public String getName() {
    return this.jvmType.getSimpleName();
  }
  
  @Override
  public String getQualifiedName() {
    return this.jvmType.getQualifiedName();
  }
  
  @Override
  public PsiElement getNavigationElement() {
    return this.psiElement;
  }
  
  @Override
  public PsiFile getContainingFile() {
    return this.psiElement.getContainingFile();
  }
  
  @Override
  public boolean isValid() {
    return this.psiElement.isValid();
  }
  
  @Override
  public PsiMethod[] getConstructors() {
    return this.membersCache.getConstructors();
  }
  
  @Override
  public PsiField[] getFields() {
    return this.membersCache.getFields();
  }
  
  @Override
  public PsiMethod[] getMethods() {
    return this.membersCache.getMethods();
  }
  
  @Override
  public PsiClass[] getInnerClasses() {
    return this.membersCache.getInnerClasses();
  }
  
  @Override
  public List<PsiField> getOwnFields() {
    Iterable<JvmField> _declaredFields = this.jvmType.getDeclaredFields();
    final Function1<JvmField, PsiField> _function = new Function1<JvmField, PsiField>() {
      @Override
      public PsiField apply(final JvmField f) {
        PsiManager _manager = JvmPsiClassImpl.this.getManager();
        Language _language = JvmPsiClassImpl.this.getLanguage();
        String _simpleName = f.getSimpleName();
        JvmTypeReference _type = f.getType();
        PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_type);
        LightFieldBuilder _lightFieldBuilder = new LightFieldBuilder(_manager, _language, _simpleName, _psiType);
        final Procedure1<LightFieldBuilder> _function = new Procedure1<LightFieldBuilder>() {
          @Override
          public void apply(final LightFieldBuilder it) {
            it.setParent(JvmPsiClassImpl.this);
            it.setContainingClass(JvmPsiClassImpl.this);
            AnnotatableModifierList _psiModifiers = JvmPsiClassImpl.this.getPsiModifiers(f);
            it.setModifierList(_psiModifiers);
            PsiDocCommentImpl _psiDocComment = JvmPsiClassImpl.this.getPsiDocComment(f);
            it.setDocComment(_psiDocComment);
            boolean _isDeprecated = f.isDeprecated();
            it.setDeprecated(_isDeprecated);
            PsiElement _navigationElement = JvmPsiClassImpl.this.getNavigationElement(f);
            JvmPsiClassImpl.this.setNullableNavigationElement(it, _navigationElement);
            JvmPsiElementExtensions.setJvmElement(it, f);
          }
        };
        LightFieldBuilder _doubleArrow = ObjectExtensions.<LightFieldBuilder>operator_doubleArrow(_lightFieldBuilder, _function);
        return ((PsiField) _doubleArrow);
      }
    };
    Iterable<PsiField> _map = IterableExtensions.<JvmField, PsiField>map(_declaredFields, _function);
    return IterableExtensions.<PsiField>toList(_map);
  }
  
  @Override
  public List<PsiMethod> getOwnMethods() {
    EList<JvmMember> _members = this.jvmType.getMembers();
    Iterable<JvmExecutable> _filter = Iterables.<JvmExecutable>filter(_members, JvmExecutable.class);
    final Function1<JvmExecutable, PsiMethod> _function = new Function1<JvmExecutable, PsiMethod>() {
      @Override
      public PsiMethod apply(final JvmExecutable m) {
        PsiManager _manager = JvmPsiClassImpl.this.getManager();
        Language _language = JvmPsiClassImpl.this.getLanguage();
        String _simpleName = m.getSimpleName();
        LightParameterListBuilder _psiParameters = JvmPsiClassImpl.this.getPsiParameters(m);
        AnnotatableModifierList _psiModifiers = JvmPsiClassImpl.this.getPsiModifiers(m);
        LightReferenceListBuilder _throwsList = JvmPsiClassImpl.this.getThrowsList(m);
        LightTypeParameterListBuilder _psiTypeParameterList = JvmPsiClassImpl.this.getPsiTypeParameterList(m);
        LightMethodBuilder _lightMethodBuilder = new LightMethodBuilder(_manager, _language, _simpleName, _psiParameters, _psiModifiers, _throwsList, _psiTypeParameterList);
        final Procedure1<LightMethodBuilder> _function = new Procedure1<LightMethodBuilder>() {
          @Override
          public void apply(final LightMethodBuilder it) {
            it.setParent(JvmPsiClassImpl.this);
            it.setContainingClass(JvmPsiClassImpl.this);
            it.setConstructor((m instanceof JvmConstructor));
            if ((m instanceof JvmOperation)) {
              JvmTypeReference _returnType = ((JvmOperation)m).getReturnType();
              PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_returnType);
              it.setMethodReturnType(_psiType);
            }
            PsiElement _navigationElement = JvmPsiClassImpl.this.getNavigationElement(m);
            JvmPsiClassImpl.this.setNullableNavigationElement(it, _navigationElement);
            JvmPsiElementExtensions.setJvmElement(it, m);
          }
        };
        LightMethodBuilder _doubleArrow = ObjectExtensions.<LightMethodBuilder>operator_doubleArrow(_lightMethodBuilder, _function);
        return ((PsiMethod) _doubleArrow);
      }
    };
    Iterable<PsiMethod> _map = IterableExtensions.<JvmExecutable, PsiMethod>map(_filter, _function);
    return IterableExtensions.<PsiMethod>toList(_map);
  }
  
  protected LightReferenceListBuilder getThrowsList(final JvmExecutable executable) {
    EList<JvmTypeReference> _exceptions = executable.getExceptions();
    return this.toReferenceList(_exceptions, PsiReferenceList.Role.THROWS_LIST);
  }
  
  private LightParameterListBuilder getPsiParameters(final JvmExecutable m) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightParameterListBuilder _lightParameterListBuilder = new LightParameterListBuilder(_manager, _language);
    final Procedure1<LightParameterListBuilder> _function = new Procedure1<LightParameterListBuilder>() {
      @Override
      public void apply(final LightParameterListBuilder it) {
        EList<JvmFormalParameter> _parameters = m.getParameters();
        final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
          @Override
          public void apply(final JvmFormalParameter p) {
            final String parameterName = p.getSimpleName();
            JvmTypeReference _parameterType = p.getParameterType();
            PsiType _psiType = null;
            if (_parameterType!=null) {
              _psiType=JvmPsiClassImpl.this.toPsiType(_parameterType);
            }
            final PsiType parameterType = _psiType;
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(parameterName, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _notEquals_1 = (!Objects.equal(parameterType, null));
              _and = _notEquals_1;
            }
            if (_and) {
              Language _language = it.getLanguage();
              LightParameter _lightParameter = new LightParameter(parameterName, parameterType, JvmPsiClassImpl.this.psiElement, _language);
              final Procedure1<LightParameter> _function = new Procedure1<LightParameter>() {
                @Override
                public void apply(final LightParameter it) {
                  PsiElement _navigationElement = JvmPsiClassImpl.this.getNavigationElement(p);
                  JvmPsiClassImpl.this.setNullableNavigationElement(it, _navigationElement);
                  JvmPsiElementExtensions.setJvmElement(it, p);
                }
              };
              LightParameter _doubleArrow = ObjectExtensions.<LightParameter>operator_doubleArrow(_lightParameter, _function);
              it.addParameter(_doubleArrow);
            }
          }
        };
        IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function);
      }
    };
    return ObjectExtensions.<LightParameterListBuilder>operator_doubleArrow(_lightParameterListBuilder, _function);
  }
  
  private PsiElement getNavigationElement(final EObject jvmElement) {
    PsiElement _xblockexpression = null;
    {
      final EObject primarySourceElement = this.jvmAssocations.getPrimarySourceElement(jvmElement);
      _xblockexpression = this.psiAssocations.getPsiElement(primarySourceElement);
    }
    return _xblockexpression;
  }
  
  private void setNullableNavigationElement(final LightElement element, final PsiElement navigationElement) {
    boolean _notEquals = (!Objects.equal(navigationElement, null));
    if (_notEquals) {
      element.setNavigationElement(navigationElement);
    }
  }
  
  private AnnotatableModifierList getPsiModifiers(final JvmMember m) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    AnnotatableModifierList _annotatableModifierList = new AnnotatableModifierList(_manager, _language);
    final Procedure1<AnnotatableModifierList> _function = new Procedure1<AnnotatableModifierList>() {
      @Override
      public void apply(final AnnotatableModifierList it) {
        JvmVisibility _visibility = m.getVisibility();
        if (_visibility != null) {
          switch (_visibility) {
            case DEFAULT:
              it.addModifier(PsiModifier.PACKAGE_LOCAL);
              break;
            case PRIVATE:
              it.addModifier(PsiModifier.PRIVATE);
              break;
            case PROTECTED:
              it.addModifier(PsiModifier.PROTECTED);
              break;
            case PUBLIC:
              it.addModifier(PsiModifier.PUBLIC);
              break;
            default:
              break;
          }
        }
        if ((m instanceof JvmDeclaredType)) {
          boolean _isAbstract = ((JvmDeclaredType)m).isAbstract();
          if (_isAbstract) {
            it.addModifier(PsiModifier.ABSTRACT);
          }
          boolean _isFinal = ((JvmDeclaredType)m).isFinal();
          if (_isFinal) {
            it.addModifier(PsiModifier.FINAL);
          }
          boolean _isStatic = ((JvmDeclaredType)m).isStatic();
          if (_isStatic) {
            it.addModifier(PsiModifier.STATIC);
          }
        }
        if ((m instanceof JvmFeature)) {
          boolean _isStatic_1 = ((JvmFeature)m).isStatic();
          if (_isStatic_1) {
            it.addModifier(PsiModifier.STATIC);
          }
        }
        if ((m instanceof JvmField)) {
          boolean _isFinal_1 = ((JvmField)m).isFinal();
          if (_isFinal_1) {
            it.addModifier(PsiModifier.FINAL);
          }
          boolean _isTransient = ((JvmField)m).isTransient();
          if (_isTransient) {
            it.addModifier(PsiModifier.TRANSIENT);
          }
          boolean _isVolatile = ((JvmField)m).isVolatile();
          if (_isVolatile) {
            it.addModifier(PsiModifier.VOLATILE);
          }
        }
        if ((m instanceof JvmOperation)) {
          boolean _isAbstract_1 = ((JvmOperation)m).isAbstract();
          if (_isAbstract_1) {
            it.addModifier(PsiModifier.ABSTRACT);
          }
          boolean _isDefault = ((JvmOperation)m).isDefault();
          if (_isDefault) {
            it.addModifier(PsiModifier.DEFAULT);
          }
          boolean _isFinal_2 = ((JvmOperation)m).isFinal();
          if (_isFinal_2) {
            it.addModifier(PsiModifier.FINAL);
          }
          boolean _isNative = ((JvmOperation)m).isNative();
          if (_isNative) {
            it.addModifier(PsiModifier.NATIVE);
          }
          boolean _isStrictFloatingPoint = ((JvmOperation)m).isStrictFloatingPoint();
          if (_isStrictFloatingPoint) {
            it.addModifier(PsiModifier.STRICTFP);
          }
          boolean _isSynchronized = ((JvmOperation)m).isSynchronized();
          if (_isSynchronized) {
            it.addModifier(PsiModifier.SYNCHRONIZED);
          }
        }
        if ((m != null)) {
          EList<JvmAnnotationReference> _annotations = m.getAnnotations();
          final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
            @Override
            public void apply(final JvmAnnotationReference anno) {
              JvmAnnotationType _annotation = anno.getAnnotation();
              String _qualifiedName = _annotation.getQualifiedName();
              LightAnnotation _addAnnotation = it.addAnnotation(_qualifiedName);
              final Procedure1<LightAnnotation> _function = new Procedure1<LightAnnotation>() {
                @Override
                public void apply(final LightAnnotation it) {
                }
              };
              ObjectExtensions.<LightAnnotation>operator_doubleArrow(_addAnnotation, _function);
            }
          };
          IterableExtensions.<JvmAnnotationReference>forEach(_annotations, _function);
        }
      }
    };
    return ObjectExtensions.<AnnotatableModifierList>operator_doubleArrow(_annotatableModifierList, _function);
  }
  
  private PsiType toPsiType(final JvmTypeReference type) {
    try {
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      if ((type instanceof XComputedTypeReference)) {
        JvmTypeReference _equivalent = ((XComputedTypeReference)type).getEquivalent();
        return this.toPsiType(_equivalent);
      }
      String _qualifiedName = type.getQualifiedName('.');
      PsiFile _containingFile = this.getContainingFile();
      return this.buildTypeFromTypeString(_qualifiedName, this.psiElement, _containingFile);
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledError) {
        final OperationCanceledError e = (OperationCanceledError)_t;
        throw e.getWrapped();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Copied from PsiClassImplUtil for Android Studio compatibility
   */
  private PsiType buildTypeFromTypeString(final String typeName, final PsiElement context, final PsiFile psiFile) {
    final PsiManager psiManager = psiFile.getManager();
    boolean _or = false;
    boolean _or_1 = false;
    int _indexOf = typeName.indexOf("<");
    boolean _notEquals = (_indexOf != (-1));
    if (_notEquals) {
      _or_1 = true;
    } else {
      int _indexOf_1 = typeName.indexOf("[");
      boolean _notEquals_1 = (_indexOf_1 != (-1));
      _or_1 = _notEquals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      int _indexOf_2 = typeName.indexOf(".");
      boolean _equals = (_indexOf_2 == (-1));
      _or = _equals;
    }
    if (_or) {
      try {
        Project _project = psiManager.getProject();
        JavaPsiFacade _instance = JavaPsiFacade.getInstance(_project);
        PsiElementFactory _elementFactory = _instance.getElementFactory();
        return _elementFactory.createTypeFromText(typeName, context);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    Project _project_1 = psiManager.getProject();
    JavaPsiFacade _instance_1 = JavaPsiFacade.getInstance(_project_1);
    GlobalSearchScope _resolveScope = context.getResolveScope();
    final PsiClass aClass = _instance_1.findClass(typeName, _resolveScope);
    boolean _equals_1 = Objects.equal(aClass, null);
    if (_equals_1) {
      String _shortClassName = PsiNameHelper.getShortClassName(typeName);
      final LightClassReference ref = new LightClassReference(psiManager, _shortClassName, typeName, 
        PsiSubstitutor.EMPTY, psiFile);
      return new PsiClassReferenceType(ref, null);
    } else {
      Project _project_2 = psiManager.getProject();
      JavaPsiFacade _instance_2 = JavaPsiFacade.getInstance(_project_2);
      final PsiElementFactory factory = _instance_2.getElementFactory();
      final PsiSubstitutor substitutor = factory.createRawSubstitutor(aClass);
      return factory.createType(aClass, substitutor);
    }
  }
  
  @Override
  public List<PsiClass> getOwnInnerClasses() {
    Iterable<JvmDeclaredType> _allNestedTypes = this.jvmType.getAllNestedTypes();
    final Function1<JvmDeclaredType, PsiClass> _function = new Function1<JvmDeclaredType, PsiClass>() {
      @Override
      public PsiClass apply(final JvmDeclaredType inner) {
        PsiClass _xblockexpression = null;
        {
          final EObject sourceElement = JvmPsiClassImpl.this.jvmAssocations.getPrimarySourceElement(inner);
          PsiElement _psiElement = JvmPsiClassImpl.this.psiAssocations.getPsiElement(sourceElement);
          final PsiNamedElement psiElement = ((PsiNamedElement) _psiElement);
          JvmPsiClassImpl _jvmPsiClassImpl = new JvmPsiClassImpl(inner, psiElement);
          final Procedure1<JvmPsiClassImpl> _function = new Procedure1<JvmPsiClassImpl>() {
            @Override
            public void apply(final JvmPsiClassImpl it) {
              PsiElement _navigationElement = JvmPsiClassImpl.this.getNavigationElement(inner);
              JvmPsiClassImpl.this.setNullableNavigationElement(it, _navigationElement);
              JvmPsiElementExtensions.setJvmElement(it, inner);
            }
          };
          JvmPsiClassImpl _doubleArrow = ObjectExtensions.<JvmPsiClassImpl>operator_doubleArrow(_jvmPsiClassImpl, _function);
          _xblockexpression = ((PsiClass) _doubleArrow);
        }
        return _xblockexpression;
      }
    };
    Iterable<PsiClass> _map = IterableExtensions.<JvmDeclaredType, PsiClass>map(_allNestedTypes, _function);
    return IterableExtensions.<PsiClass>toList(_map);
  }
  
  @Override
  public PsiClass getContainingClass() {
    final EObject container = this.jvmType.eContainer();
    if ((container instanceof JvmDeclaredType)) {
      PsiElement _psiElement = this.psiAssocations.getPsiElement(container);
      return ((PsiClass) _psiElement);
    }
    return null;
  }
  
  @Override
  public PsiReferenceList getExtendsList() {
    LightReferenceListBuilder _xblockexpression = null;
    {
      Iterable<JvmTypeReference> _xifexpression = null;
      boolean _isInterface = this.isInterface();
      if (_isInterface) {
        _xifexpression = this.jvmType.getExtendedInterfaces();
      } else {
        JvmTypeReference _extendedClass = this.jvmType.getExtendedClass();
        _xifexpression = Collections.<JvmTypeReference>unmodifiableList(CollectionLiterals.<JvmTypeReference>newArrayList(_extendedClass));
      }
      final Iterable<JvmTypeReference> references = _xifexpression;
      _xblockexpression = this.toReferenceList(references, PsiReferenceList.Role.EXTENDS_LIST);
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiReferenceList getImplementsList() {
    LightReferenceListBuilder _xblockexpression = null;
    {
      Iterable<JvmTypeReference> _xifexpression = null;
      boolean _isInterface = this.isInterface();
      if (_isInterface) {
        _xifexpression = CollectionLiterals.<JvmTypeReference>emptyList();
      } else {
        _xifexpression = this.jvmType.getExtendedInterfaces();
      }
      final Iterable<JvmTypeReference> references = _xifexpression;
      _xblockexpression = this.toReferenceList(references, PsiReferenceList.Role.IMPLEMENTS_LIST);
    }
    return _xblockexpression;
  }
  
  protected LightReferenceListBuilder toReferenceList(final Iterable<JvmTypeReference> references, final PsiReferenceList.Role role) {
    LightReferenceListBuilder _xblockexpression = null;
    {
      PsiManager _manager = this.getManager();
      Language _language = this.getLanguage();
      @Extension
      final LightReferenceListBuilder referenceList = new LightReferenceListBuilder(_manager, _language, role);
      final Function1<JvmTypeReference, PsiType> _function = new Function1<JvmTypeReference, PsiType>() {
        @Override
        public PsiType apply(final JvmTypeReference it) {
          return JvmPsiClassImpl.this.toPsiType(it);
        }
      };
      Iterable<PsiType> _map = IterableExtensions.<JvmTypeReference, PsiType>map(references, _function);
      Iterable<PsiClassType> _filter = Iterables.<PsiClassType>filter(_map, PsiClassType.class);
      final Procedure1<PsiClassType> _function_1 = new Procedure1<PsiClassType>() {
        @Override
        public void apply(final PsiClassType it) {
          referenceList.addReference(it);
        }
      };
      IterableExtensions.<PsiClassType>forEach(_filter, _function_1);
      _xblockexpression = referenceList;
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiClassInitializer[] getInitializers() {
    return new PsiClassInitializer[] {};
  }
  
  @Override
  public PsiElement getLBrace() {
    return null;
  }
  
  @Override
  public PsiElement getRBrace() {
    return null;
  }
  
  @Override
  public PsiIdentifier getNameIdentifier() {
    return null;
  }
  
  @Override
  public PsiElement getScope() {
    final EObject container = this.jvmType.eContainer();
    if ((container instanceof JvmDeclaredType)) {
      return this.psiAssocations.getPsiElement(container);
    }
    return this.getContainingFile();
  }
  
  @Override
  public boolean isAnnotationType() {
    return (this.jvmType instanceof JvmAnnotationType);
  }
  
  @Override
  public boolean isEnum() {
    return (this.jvmType instanceof JvmEnumerationType);
  }
  
  @Override
  public boolean isInterface() {
    if ((this.jvmType instanceof JvmGenericType)) {
      return ((JvmGenericType)this.jvmType).isInterface();
    }
    return false;
  }
  
  @Override
  public PsiElement setName(final String name) throws IncorrectOperationException {
    throw new IncorrectOperationException();
  }
  
  @Override
  public PsiModifierList getModifierList() {
    return this.getPsiModifiers(this.jvmType);
  }
  
  @Override
  public boolean hasModifierProperty(final String name) {
    PsiModifierList _modifierList = this.getModifierList();
    return _modifierList.hasModifierProperty(name);
  }
  
  @Override
  public PsiDocComment getDocComment() {
    return this.getPsiDocComment(this.jvmType);
  }
  
  private PsiDocCommentImpl getPsiDocComment(final EObject jvmObject) {
    PsiDocCommentImpl _xblockexpression = null;
    {
      EList<Adapter> _eAdapters = jvmObject.eAdapters();
      Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, DocumentationAdapter.class);
      final DocumentationAdapter adapter = ((DocumentationAdapter) _adapter);
      String _elvis = null;
      String _documentation = null;
      if (adapter!=null) {
        _documentation=adapter.getDocumentation();
      }
      if (_documentation != null) {
        _elvis = _documentation;
      } else {
        _elvis = "";
      }
      _xblockexpression = new PsiDocCommentImpl(_elvis);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isDeprecated() {
    return this.jvmType.isDeprecated();
  }
  
  @Override
  public PsiTypeParameterList getTypeParameterList() {
    if ((this.typeParameterList == null)) {
      LightTypeParameterListBuilder _psiTypeParameterList = this.getPsiTypeParameterList(this.jvmType);
      return this.typeParameterList = _psiTypeParameterList;
    }
    return this.typeParameterList;
  }
  
  private LightTypeParameterListBuilder getPsiTypeParameterList(final EObject declarator) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightTypeParameterListBuilder _lightTypeParameterListBuilder = new LightTypeParameterListBuilder(_manager, _language);
    final Procedure1<LightTypeParameterListBuilder> _function = new Procedure1<LightTypeParameterListBuilder>() {
      @Override
      public void apply(final LightTypeParameterListBuilder builder) {
        if ((declarator instanceof JvmTypeParameterDeclarator)) {
          EList<JvmTypeParameter> _typeParameters = ((JvmTypeParameterDeclarator)declarator).getTypeParameters();
          final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
            @Override
            public void apply(final JvmTypeParameter it) {
              LightTypeParameter _psiTypeParameter = JvmPsiClassImpl.this.toPsiTypeParameter(it);
              builder.addParameter(_psiTypeParameter);
            }
          };
          IterableExtensions.<JvmTypeParameter>forEach(_typeParameters, _function);
        }
      }
    };
    return ObjectExtensions.<LightTypeParameterListBuilder>operator_doubleArrow(_lightTypeParameterListBuilder, _function);
  }
  
  public LightTypeParameter toPsiTypeParameter(final JvmTypeParameter typeParam) {
    Project _project = this.getProject();
    final JVMElementFactory psiFactory = JVMElementFactories.requireFactory(JavaLanguage.INSTANCE, _project);
    final StringBuilder sb = new StringBuilder();
    StringBuilder _append = sb.append("public <");
    String _simpleName = typeParam.getSimpleName();
    StringBuilder _append_1 = _append.append(_simpleName);
    _append_1.append(" ");
    EList<JvmTypeConstraint> _constraints = typeParam.getConstraints();
    NameConcatHelper.appendConstraintsName(sb, _constraints, '.', NameConcatHelper.NameType.QUALIFIED);
    sb.append("> void m(){}");
    PsiTypeParameter _xtrycatchfinallyexpression = null;
    try {
      String _string = sb.toString();
      PsiMethod _createMethodFromText = psiFactory.createMethodFromText(_string, null);
      PsiTypeParameter[] _typeParameters = _createMethodFromText.getTypeParameters();
      _xtrycatchfinallyexpression = _typeParameters[0];
    } catch (final Throwable _t) {
      if (_t instanceof IncorrectOperationException) {
        final IncorrectOperationException e = (IncorrectOperationException)_t;
        String _simpleName_1 = typeParam.getSimpleName();
        _xtrycatchfinallyexpression = psiFactory.createTypeParameter(_simpleName_1, PsiClassType.EMPTY_ARRAY);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final PsiTypeParameter psiTypeParam = _xtrycatchfinallyexpression;
    return new LightTypeParameter(psiTypeParam) {
      @Override
      public PsiTypeParameterListOwner getOwner() {
        return JvmPsiClassImpl.this;
      }
    };
  }
  
  @Override
  public void accept(final PsiElementVisitor visitor) {
    if ((visitor instanceof JavaElementVisitor)) {
      ((JavaElementVisitor)visitor).visitClass(this);
    } else {
      visitor.visitElement(this);
    }
  }
  
  @Override
  public boolean processDeclarations(final PsiScopeProcessor processor, final ResolveState state, final PsiElement lastParent, final PsiElement place) {
    boolean _isEnum = this.isEnum();
    if (_isEnum) {
      boolean _processDeclarationsInEnum = PsiClassImplUtil.processDeclarationsInEnum(processor, state, this.membersCache);
      boolean _not = (!_processDeclarationsInEnum);
      if (_not) {
        return false;
      }
    }
    final LanguageLevel level = PsiUtil.getLanguageLevel(place);
    return PsiClassImplUtil.processDeclarationsInClass(this, processor, state, null, lastParent, place, level, 
      false);
  }
  
  @Override
  public String toString() {
    return this.jvmType.toString();
  }
  
  @Override
  protected Icon getElementIcon(final int flags) {
    return PsiClassImplUtil.getClassIcon(flags, this);
  }
  
  @Override
  public boolean isEquivalentTo(final PsiElement another) {
    return PsiClassImplUtil.isClassEquivalentTo(this, another);
  }
  
  @Override
  public PsiField findFieldByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findFieldByName(this, name, checkBases);
  }
  
  @Override
  public PsiClass findInnerClassByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findInnerByName(this, name, checkBases);
  }
  
  @Override
  public PsiMethod findMethodBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return PsiClassImplUtil.findMethodBySignature(this, patternMethod, checkBases);
  }
  
  @Override
  public List<Pair<PsiMethod, PsiSubstitutor>> findMethodsAndTheirSubstitutorsByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsAndTheirSubstitutorsByName(this, name, checkBases);
  }
  
  @Override
  public PsiMethod[] findMethodsByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsByName(this, name, checkBases);
  }
  
  @Override
  public PsiMethod[] findMethodsBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsBySignature(this, patternMethod, checkBases);
  }
  
  @Override
  public Collection<HierarchicalMethodSignature> getVisibleSignatures() {
    return PsiSuperMethodImplUtil.getVisibleSignatures(this);
  }
  
  @Override
  public PsiField[] getAllFields() {
    return PsiClassImplUtil.getAllFields(this);
  }
  
  @Override
  public PsiClass[] getAllInnerClasses() {
    return PsiClassImplUtil.getAllInnerClasses(this);
  }
  
  @Override
  public PsiMethod[] getAllMethods() {
    return PsiClassImplUtil.getAllMethods(this);
  }
  
  @Override
  public List<Pair<PsiMethod, PsiSubstitutor>> getAllMethodsAndTheirSubstitutors() {
    return PsiClassImplUtil.<PsiMethod>getAllWithSubstitutorsByMap(this, PsiClassImplUtil.MemberType.METHOD);
  }
  
  @Override
  public PsiClassType[] getExtendsListTypes() {
    return PsiClassImplUtil.getExtendsListTypes(this);
  }
  
  @Override
  public PsiClassType[] getImplementsListTypes() {
    return PsiClassImplUtil.getImplementsListTypes(this);
  }
  
  @Override
  public PsiClass[] getInterfaces() {
    return PsiClassImplUtil.getInterfaces(this);
  }
  
  @Override
  public PsiClass getSuperClass() {
    return PsiClassImplUtil.getSuperClass(this);
  }
  
  @Override
  public PsiClassType[] getSuperTypes() {
    return PsiClassImplUtil.getSuperTypes(this);
  }
  
  @Override
  public PsiClass[] getSupers() {
    return PsiClassImplUtil.getSupers(this);
  }
  
  @Override
  public boolean isInheritor(final PsiClass baseClass, final boolean checkDeep) {
    return InheritanceImplUtil.isInheritor(this, baseClass, checkDeep);
  }
  
  @Override
  public boolean isInheritorDeep(final PsiClass baseClass, final PsiClass classToByPass) {
    return InheritanceImplUtil.isInheritorDeep(this, baseClass, classToByPass);
  }
  
  @Override
  public PsiTypeParameter[] getTypeParameters() {
    return PsiImplUtil.getTypeParameters(this);
  }
  
  @Override
  public boolean hasTypeParameters() {
    if ((this.jvmType instanceof JvmTypeParameterDeclarator)) {
      EList<JvmTypeParameter> _typeParameters = ((JvmTypeParameterDeclarator)this.jvmType).getTypeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      return (!_isEmpty);
    }
    return false;
  }
}
