package org.eclipse.xtext.idea.types.psi.impl;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.util.Pair;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.HierarchicalMethodSignature;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassInitializer;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifier;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReferenceList;
import com.intellij.psi.PsiSubstitutor;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterList;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.InheritanceImplUtil;
import com.intellij.psi.impl.PsiClassImplUtil;
import com.intellij.psi.impl.PsiImplUtil;
import com.intellij.psi.impl.PsiSuperMethodImplUtil;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.impl.light.LightMethodBuilder;
import com.intellij.psi.impl.light.LightParameter;
import com.intellij.psi.impl.light.LightParameterListBuilder;
import com.intellij.psi.impl.light.LightReferenceListBuilder;
import com.intellij.psi.impl.light.LightTypeParameterListBuilder;
import com.intellij.psi.impl.source.ClassInnerStuffCache;
import com.intellij.psi.impl.source.PsiClassReferenceType;
import com.intellij.psi.impl.source.PsiExtensibleClass;
import com.intellij.psi.impl.source.javadoc.PsiDocCommentImpl;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
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
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.idea.types.psi.impl.AnnotatableModifierList;
import org.eclipse.xtext.idea.types.psi.impl.LightAnnotation;
import org.eclipse.xtext.idea.types.psi.impl.LightFieldBuilder;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
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
  
  private final PsiNamedElement psiElement;
  
  private final ClassInnerStuffCache membersCache;
  
  public JvmPsiClassImpl(final JvmDeclaredType declaredType, final PsiNamedElement psiElement) {
    super(psiElement.getManager(), psiElement.getLanguage());
    this.jvmType = declaredType;
    this.psiElement = psiElement;
    final Language language = this.getLanguage();
    if ((language instanceof IXtextLanguage)) {
      ((IXtextLanguage)language).injectMembers(this);
    }
    ClassInnerStuffCache _classInnerStuffCache = new ClassInnerStuffCache(this);
    this.membersCache = _classInnerStuffCache;
  }
  
  public EClass getType() {
    return this.jvmType.eClass();
  }
  
  public PsiElement copy() {
    return new JvmPsiClassImpl(this.jvmType, this.psiElement);
  }
  
  public String getName() {
    return this.jvmType.getSimpleName();
  }
  
  public String getQualifiedName() {
    return this.jvmType.getQualifiedName();
  }
  
  public PsiElement getNavigationElement() {
    return this.psiElement;
  }
  
  public PsiFile getContainingFile() {
    return this.psiElement.getContainingFile();
  }
  
  public boolean isValid() {
    return this.psiElement.isValid();
  }
  
  public PsiMethod[] getConstructors() {
    return PsiImplUtil.getConstructors(this);
  }
  
  public PsiField[] getFields() {
    return this.membersCache.getFields();
  }
  
  public PsiMethod[] getMethods() {
    return this.membersCache.getMethods();
  }
  
  public PsiClass[] getInnerClasses() {
    return this.membersCache.getInnerClasses();
  }
  
  public List<PsiField> getOwnFields() {
    Iterable<JvmField> _declaredFields = this.jvmType.getDeclaredFields();
    final Function1<JvmField, PsiField> _function = new Function1<JvmField, PsiField>() {
      public PsiField apply(final JvmField f) {
        PsiManager _manager = JvmPsiClassImpl.this.getManager();
        Language _language = JvmPsiClassImpl.this.getLanguage();
        String _simpleName = f.getSimpleName();
        JvmTypeReference _type = f.getType();
        PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_type);
        LightFieldBuilder _lightFieldBuilder = new LightFieldBuilder(_manager, _language, _simpleName, _psiType);
        final Procedure1<LightFieldBuilder> _function = new Procedure1<LightFieldBuilder>() {
          public void apply(final LightFieldBuilder it) {
            it.setContainingClass(JvmPsiClassImpl.this);
            AnnotatableModifierList _psiModifiers = JvmPsiClassImpl.this.getPsiModifiers(f);
            it.setModifierList(_psiModifiers);
            PsiDocCommentImpl _psiDocComment = JvmPsiClassImpl.this.getPsiDocComment(f);
            it.setDocComment(_psiDocComment);
            boolean _isDeprecated = f.isDeprecated();
            it.setDeprecated(_isDeprecated);
            JvmPsiClassImpl.this.associatePrimary(f, it);
          }
        };
        LightFieldBuilder _doubleArrow = ObjectExtensions.<LightFieldBuilder>operator_doubleArrow(_lightFieldBuilder, _function);
        return ((PsiField) _doubleArrow);
      }
    };
    Iterable<PsiField> _map = IterableExtensions.<JvmField, PsiField>map(_declaredFields, _function);
    return IterableExtensions.<PsiField>toList(_map);
  }
  
  public List<PsiMethod> getOwnMethods() {
    EList<JvmMember> _members = this.jvmType.getMembers();
    Iterable<JvmExecutable> _filter = Iterables.<JvmExecutable>filter(_members, JvmExecutable.class);
    final Function1<JvmExecutable, PsiMethod> _function = new Function1<JvmExecutable, PsiMethod>() {
      public PsiMethod apply(final JvmExecutable m) {
        PsiManager _manager = JvmPsiClassImpl.this.getManager();
        Language _language = JvmPsiClassImpl.this.getLanguage();
        String _simpleName = m.getSimpleName();
        LightParameterListBuilder _psiParameters = JvmPsiClassImpl.this.getPsiParameters(m);
        AnnotatableModifierList _psiModifiers = JvmPsiClassImpl.this.getPsiModifiers(m);
        LightReferenceListBuilder _psiThrowsList = JvmPsiClassImpl.this.psiThrowsList(m);
        LightTypeParameterListBuilder _psiTypeParameterList = JvmPsiClassImpl.this.getPsiTypeParameterList(m);
        LightMethodBuilder _lightMethodBuilder = new LightMethodBuilder(_manager, _language, _simpleName, _psiParameters, _psiModifiers, _psiThrowsList, _psiTypeParameterList);
        final Procedure1<LightMethodBuilder> _function = new Procedure1<LightMethodBuilder>() {
          public void apply(final LightMethodBuilder it) {
            it.setContainingClass(JvmPsiClassImpl.this);
            it.setConstructor((m instanceof JvmConstructor));
            if ((m instanceof JvmOperation)) {
              JvmTypeReference _returnType = ((JvmOperation)m).getReturnType();
              PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_returnType);
              it.setMethodReturnType(_psiType);
            }
            JvmPsiClassImpl.this.associatePrimary(m, it);
          }
        };
        LightMethodBuilder _doubleArrow = ObjectExtensions.<LightMethodBuilder>operator_doubleArrow(_lightMethodBuilder, _function);
        return ((PsiMethod) _doubleArrow);
      }
    };
    Iterable<PsiMethod> _map = IterableExtensions.<JvmExecutable, PsiMethod>map(_filter, _function);
    return IterableExtensions.<PsiMethod>toList(_map);
  }
  
  private LightReferenceListBuilder psiThrowsList(final JvmExecutable executable) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightReferenceListBuilder _lightReferenceListBuilder = new LightReferenceListBuilder(_manager, _language, PsiReferenceList.Role.THROWS_LIST);
    final Procedure1<LightReferenceListBuilder> _function = new Procedure1<LightReferenceListBuilder>() {
      public void apply(final LightReferenceListBuilder it) {
        EList<JvmTypeReference> _exceptions = executable.getExceptions();
        final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
          public void apply(final JvmTypeReference e) {
            PsiType _psiType = JvmPsiClassImpl.this.toPsiType(e);
            it.addReference(((PsiClassReferenceType) _psiType));
          }
        };
        IterableExtensions.<JvmTypeReference>forEach(_exceptions, _function);
      }
    };
    return ObjectExtensions.<LightReferenceListBuilder>operator_doubleArrow(_lightReferenceListBuilder, _function);
  }
  
  private LightParameterListBuilder getPsiParameters(final JvmExecutable m) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightParameterListBuilder _lightParameterListBuilder = new LightParameterListBuilder(_manager, _language);
    final Procedure1<LightParameterListBuilder> _function = new Procedure1<LightParameterListBuilder>() {
      public void apply(final LightParameterListBuilder it) {
        EList<JvmFormalParameter> _parameters = m.getParameters();
        final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
          public void apply(final JvmFormalParameter p) {
            String _simpleName = p.getSimpleName();
            JvmTypeReference _parameterType = p.getParameterType();
            PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_parameterType);
            Language _language = it.getLanguage();
            final LightParameter psiParameter = new LightParameter(_simpleName, _psiType, JvmPsiClassImpl.this.psiElement, _language);
            JvmPsiClassImpl.this.associatePrimary(p, psiParameter);
            it.addParameter(psiParameter);
          }
        };
        IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function);
      }
    };
    return ObjectExtensions.<LightParameterListBuilder>operator_doubleArrow(_lightParameterListBuilder, _function);
  }
  
  private boolean associatePrimary(final EObject jvmElement, final LightElement psiElement) {
    boolean _xblockexpression = false;
    {
      final EObject primarySourceElement = this.jvmAssocations.getPrimarySourceElement(jvmElement);
      final PsiElement navigationElement = this.psiAssocations.getPsiElement(primarySourceElement);
      psiElement.setNavigationElement(navigationElement);
      final PsiElementProvider _function = new PsiElementProvider() {
        public PsiElement get() {
          return psiElement;
        }
      };
      _xblockexpression = this.psiAssocations.associatePrimary(primarySourceElement, _function);
    }
    return _xblockexpression;
  }
  
  private AnnotatableModifierList getPsiModifiers(final JvmMember m) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    AnnotatableModifierList _annotatableModifierList = new AnnotatableModifierList(_manager, _language);
    final Procedure1<AnnotatableModifierList> _function = new Procedure1<AnnotatableModifierList>() {
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
        if ((m instanceof JvmAnnotationTarget)) {
          EList<JvmAnnotationReference> _annotations = m.getAnnotations();
          final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
            public void apply(final JvmAnnotationReference anno) {
              JvmAnnotationType _annotation = anno.getAnnotation();
              String _qualifiedName = _annotation.getQualifiedName();
              LightAnnotation _addAnnotation = it.addAnnotation(_qualifiedName);
              final Procedure1<LightAnnotation> _function = new Procedure1<LightAnnotation>() {
                public void apply(final LightAnnotation it) {
                  JvmPsiClassImpl.this.associatePrimary(m, it);
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
    PsiType _xifexpression = null;
    if ((type instanceof XComputedTypeReference)) {
      JvmTypeReference _equivalent = ((XComputedTypeReference)type).getEquivalent();
      _xifexpression = this.toPsiType(_equivalent);
    } else {
      String _qualifiedName = type.getQualifiedName('.');
      PsiFile _containingFile = this.getContainingFile();
      _xifexpression = PsiImplUtil.buildTypeFromTypeString(_qualifiedName, this.psiElement, _containingFile);
    }
    return _xifexpression;
  }
  
  public List<PsiClass> getOwnInnerClasses() {
    Iterable<JvmDeclaredType> _allNestedTypes = this.jvmType.getAllNestedTypes();
    final Function1<JvmDeclaredType, PsiClass> _function = new Function1<JvmDeclaredType, PsiClass>() {
      public PsiClass apply(final JvmDeclaredType inner) {
        PsiClass _xblockexpression = null;
        {
          final EObject sourceElement = JvmPsiClassImpl.this.jvmAssocations.getPrimarySourceElement(inner);
          PsiElement _psiElement = JvmPsiClassImpl.this.psiAssocations.getPsiElement(sourceElement);
          final PsiNamedElement psiElement = ((PsiNamedElement) _psiElement);
          JvmPsiClassImpl _jvmPsiClassImpl = new JvmPsiClassImpl(inner, psiElement);
          final Procedure1<JvmPsiClassImpl> _function = new Procedure1<JvmPsiClassImpl>() {
            public void apply(final JvmPsiClassImpl it) {
              it.associatePrimary(inner, it);
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
  
  public PsiClass getContainingClass() {
    final EObject container = this.jvmType.eContainer();
    if ((container instanceof JvmDeclaredType)) {
      PsiElement _psiElement = this.psiAssocations.getPsiElement(container);
      return ((PsiClass) _psiElement);
    }
    return null;
  }
  
  public PsiReferenceList getExtendsList() {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightReferenceListBuilder _lightReferenceListBuilder = new LightReferenceListBuilder(_manager, _language, PsiReferenceList.Role.EXTENDS_LIST);
    final Procedure1<LightReferenceListBuilder> _function = new Procedure1<LightReferenceListBuilder>() {
      public void apply(final LightReferenceListBuilder it) {
        boolean _isInterface = JvmPsiClassImpl.this.isInterface();
        if (_isInterface) {
          Iterable<JvmTypeReference> _extendedInterfaces = JvmPsiClassImpl.this.jvmType.getExtendedInterfaces();
          final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
            public void apply(final JvmTypeReference type) {
              PsiType _psiType = JvmPsiClassImpl.this.toPsiType(type);
              it.addReference(((PsiClassType) _psiType));
            }
          };
          IterableExtensions.<JvmTypeReference>forEach(_extendedInterfaces, _function);
        } else {
          JvmTypeReference _extendedClass = JvmPsiClassImpl.this.jvmType.getExtendedClass();
          PsiType _psiType = JvmPsiClassImpl.this.toPsiType(_extendedClass);
          it.addReference(((PsiClassType) _psiType));
        }
      }
    };
    return ObjectExtensions.<LightReferenceListBuilder>operator_doubleArrow(_lightReferenceListBuilder, _function);
  }
  
  public PsiReferenceList getImplementsList() {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightReferenceListBuilder _lightReferenceListBuilder = new LightReferenceListBuilder(_manager, _language, PsiReferenceList.Role.IMPLEMENTS_LIST);
    final Procedure1<LightReferenceListBuilder> _function = new Procedure1<LightReferenceListBuilder>() {
      public void apply(final LightReferenceListBuilder it) {
        boolean _isInterface = JvmPsiClassImpl.this.isInterface();
        boolean _not = (!_isInterface);
        if (_not) {
          Iterable<JvmTypeReference> _extendedInterfaces = JvmPsiClassImpl.this.jvmType.getExtendedInterfaces();
          final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
            public void apply(final JvmTypeReference type) {
              PsiType _psiType = JvmPsiClassImpl.this.toPsiType(type);
              it.addReference(((PsiClassType) _psiType));
            }
          };
          IterableExtensions.<JvmTypeReference>forEach(_extendedInterfaces, _function);
        }
      }
    };
    return ObjectExtensions.<LightReferenceListBuilder>operator_doubleArrow(_lightReferenceListBuilder, _function);
  }
  
  public PsiClassInitializer[] getInitializers() {
    return new PsiClassInitializer[] {};
  }
  
  public PsiElement getLBrace() {
    return null;
  }
  
  public PsiElement getRBrace() {
    return null;
  }
  
  public PsiIdentifier getNameIdentifier() {
    return null;
  }
  
  public PsiElement getScope() {
    final EObject container = this.jvmType.eContainer();
    if ((container instanceof JvmDeclaredType)) {
      return this.psiAssocations.getPsiElement(container);
    }
    return this.getContainingFile();
  }
  
  public boolean isAnnotationType() {
    return (this.jvmType instanceof JvmAnnotationType);
  }
  
  public boolean isEnum() {
    return (this.jvmType instanceof JvmEnumerationType);
  }
  
  public boolean isInterface() {
    if ((this.jvmType instanceof JvmGenericType)) {
      return ((JvmGenericType)this.jvmType).isInterface();
    }
    return false;
  }
  
  public PsiElement setName(final String name) throws IncorrectOperationException {
    throw new IncorrectOperationException();
  }
  
  public PsiModifierList getModifierList() {
    return this.getPsiModifiers(this.jvmType);
  }
  
  public boolean hasModifierProperty(final String name) {
    PsiModifierList _modifierList = this.getModifierList();
    return _modifierList.hasModifierProperty(name);
  }
  
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
  
  public boolean isDeprecated() {
    return this.jvmType.isDeprecated();
  }
  
  public PsiTypeParameterList getTypeParameterList() {
    return this.getPsiTypeParameterList(this.jvmType);
  }
  
  private LightTypeParameterListBuilder getPsiTypeParameterList(final EObject declarator) {
    PsiManager _manager = this.getManager();
    Language _language = this.getLanguage();
    LightTypeParameterListBuilder _lightTypeParameterListBuilder = new LightTypeParameterListBuilder(_manager, _language);
    final Procedure1<LightTypeParameterListBuilder> _function = new Procedure1<LightTypeParameterListBuilder>() {
      public void apply(final LightTypeParameterListBuilder it) {
        if ((declarator instanceof JvmTypeParameterDeclarator)) {
        }
      }
    };
    return ObjectExtensions.<LightTypeParameterListBuilder>operator_doubleArrow(_lightTypeParameterListBuilder, _function);
  }
  
  public void accept(final PsiElementVisitor visitor) {
    if ((visitor instanceof JavaElementVisitor)) {
      ((JavaElementVisitor)visitor).visitClass(this);
    } else {
      visitor.visitElement(this);
    }
  }
  
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
    return PsiClassImplUtil.processDeclarationsInClass(this, processor, state, null, lastParent, place, level, false);
  }
  
  public String toString() {
    return this.jvmType.toString();
  }
  
  public boolean isEquivalentTo(final PsiElement another) {
    return PsiClassImplUtil.isClassEquivalentTo(this, another);
  }
  
  public PsiField findFieldByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findFieldByName(this, name, checkBases);
  }
  
  public PsiClass findInnerClassByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findInnerByName(this, name, checkBases);
  }
  
  public PsiMethod findMethodBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return PsiClassImplUtil.findMethodBySignature(this, patternMethod, checkBases);
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> findMethodsAndTheirSubstitutorsByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsAndTheirSubstitutorsByName(this, name, checkBases);
  }
  
  public PsiMethod[] findMethodsByName(final String name, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsByName(this, name, checkBases);
  }
  
  public PsiMethod[] findMethodsBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return PsiClassImplUtil.findMethodsBySignature(this, patternMethod, checkBases);
  }
  
  public Collection<HierarchicalMethodSignature> getVisibleSignatures() {
    return PsiSuperMethodImplUtil.getVisibleSignatures(this);
  }
  
  public PsiField[] getAllFields() {
    return PsiClassImplUtil.getAllFields(this);
  }
  
  public PsiClass[] getAllInnerClasses() {
    return PsiClassImplUtil.getAllInnerClasses(this);
  }
  
  public PsiMethod[] getAllMethods() {
    return PsiClassImplUtil.getAllMethods(this);
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> getAllMethodsAndTheirSubstitutors() {
    return PsiClassImplUtil.<PsiMethod>getAllWithSubstitutorsByMap(this, PsiClassImplUtil.MemberType.METHOD);
  }
  
  public PsiClassType[] getExtendsListTypes() {
    return PsiClassImplUtil.getExtendsListTypes(this);
  }
  
  public PsiClassType[] getImplementsListTypes() {
    return PsiClassImplUtil.getImplementsListTypes(this);
  }
  
  public PsiClass[] getInterfaces() {
    return PsiClassImplUtil.getInterfaces(this);
  }
  
  public PsiClass getSuperClass() {
    return PsiClassImplUtil.getSuperClass(this);
  }
  
  public PsiClassType[] getSuperTypes() {
    return PsiClassImplUtil.getSuperTypes(this);
  }
  
  public PsiClass[] getSupers() {
    return PsiClassImplUtil.getSupers(this);
  }
  
  public boolean isInheritor(final PsiClass baseClass, final boolean checkDeep) {
    return InheritanceImplUtil.isInheritor(this, baseClass, checkDeep);
  }
  
  public boolean isInheritorDeep(final PsiClass baseClass, final PsiClass classToByPass) {
    return InheritanceImplUtil.isInheritorDeep(this, baseClass, classToByPass);
  }
  
  public PsiTypeParameter[] getTypeParameters() {
    return PsiImplUtil.getTypeParameters(this);
  }
  
  public boolean hasTypeParameters() {
    return PsiImplUtil.hasTypeParameters(this);
  }
}
