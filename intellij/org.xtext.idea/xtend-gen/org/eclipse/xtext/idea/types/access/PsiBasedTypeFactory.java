package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiAnnotationMemberValue;
import com.intellij.psi.PsiAnnotationMethod;
import com.intellij.psi.PsiAnnotationParameterList;
import com.intellij.psi.PsiAnonymousClass;
import com.intellij.psi.PsiArrayInitializerMemberValue;
import com.intellij.psi.PsiArrayType;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassObjectAccessExpression;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiConstantEvaluationHelper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiEnumConstant;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifier;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiModifierListOwner;
import com.intellij.psi.PsiNameValuePair;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.PsiPrimitiveType;
import com.intellij.psi.PsiReferenceExpression;
import com.intellij.psi.PsiSubstitutor;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeElement;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterListOwner;
import com.intellij.psi.PsiWildcardType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;
import org.eclipse.xtext.idea.types.access.StubURIHelper;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PsiBasedTypeFactory implements ITypeFactory<PsiClass, JvmDeclaredType> {
  private final Stopwatches.StoppedTask createTypeTask = Stopwatches.forTask("PsiClassFactory.createType");
  
  private final Map<PsiType, JvmType> typeProxies;
  
  private final Map<PsiMethod, JvmOperation> operationProxies;
  
  private final Map<PsiType, JvmAnnotationType> annotationProxies;
  
  private final Map<PsiEnumConstant, JvmEnumerationLiteral> enumerationLiteralProxies;
  
  @Extension
  private final TypesFactory _typesFactory = TypesFactory.eINSTANCE;
  
  @Extension
  private final StubURIHelper uriHelper;
  
  @Extension
  private final IPsiModelAssociator psiModelAssociator;
  
  @Inject
  public PsiBasedTypeFactory(final StubURIHelper uriHelper, final IPsiModelAssociator psiModelAssociator) {
    this.uriHelper = uriHelper;
    HashMap<PsiType, JvmType> _newHashMap = CollectionLiterals.<PsiType, JvmType>newHashMap();
    this.typeProxies = _newHashMap;
    HashMap<PsiMethod, JvmOperation> _newHashMap_1 = CollectionLiterals.<PsiMethod, JvmOperation>newHashMap();
    this.operationProxies = _newHashMap_1;
    HashMap<PsiType, JvmAnnotationType> _newHashMap_2 = CollectionLiterals.<PsiType, JvmAnnotationType>newHashMap();
    this.annotationProxies = _newHashMap_2;
    HashMap<PsiEnumConstant, JvmEnumerationLiteral> _newHashMap_3 = CollectionLiterals.<PsiEnumConstant, JvmEnumerationLiteral>newHashMap();
    this.enumerationLiteralProxies = _newHashMap_3;
    this.psiModelAssociator = psiModelAssociator;
  }
  
  public JvmDeclaredType createType(final PsiClass psiClass) {
    JvmDeclaredType _xtrycatchfinallyexpression = null;
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        this.createTypeTask.start();
        final StringBuilder fqn = new StringBuilder(100);
        final String packageName = this.getPackageName(psiClass);
        boolean _notEquals = (!Objects.equal(packageName, null));
        if (_notEquals) {
          StringBuilder _append = fqn.append(packageName);
          _append.append(".");
        }
        final JvmDeclaredType type = this.createType(psiClass, fqn);
        type.setPackageName(packageName);
        _xblockexpression = type;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } finally {
      this.createTypeTask.stop();
    }
    return _xtrycatchfinallyexpression;
  }
  
  protected JvmDeclaredType createType(final PsiClass psiClass, final StringBuilder fqn) {
    JvmDeclaredType _xblockexpression = null;
    {
      ProgressIndicatorProvider.checkCanceled();
      boolean _or = false;
      boolean _isAnonymous = this.isAnonymous(psiClass);
      if (_isAnonymous) {
        _or = true;
      } else {
        boolean _isSynthetic = this.isSynthetic(psiClass);
        _or = _isSynthetic;
      }
      if (_or) {
        throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
      }
      JvmDeclaredType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        boolean _isAnnotationType = psiClass.isAnnotationType();
        if (_isAnnotationType) {
          _matched=true;
          _switchResult = this._typesFactory.createJvmAnnotationType();
        }
      }
      if (!_matched) {
        boolean _isEnum = psiClass.isEnum();
        if (_isEnum) {
          _matched=true;
          _switchResult = this._typesFactory.createJvmEnumerationType();
        }
      }
      if (!_matched) {
        JvmGenericType _createJvmGenericType = this._typesFactory.createJvmGenericType();
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            boolean _isInterface = psiClass.isInterface();
            it.setInterface(_isInterface);
            PsiModifierList _modifierList = psiClass.getModifierList();
            boolean _hasModifierProperty = _modifierList.hasModifierProperty(PsiModifier.STRICTFP);
            it.setStrictFloatingPoint(_hasModifierProperty);
            PsiBasedTypeFactory.this.createTypeParameters(it, psiClass);
          }
        };
        _switchResult = ObjectExtensions.<JvmGenericType>operator_doubleArrow(_createJvmGenericType, _function);
      }
      final Procedure1<JvmDeclaredType> _function_1 = new Procedure1<JvmDeclaredType>() {
        public void apply(final JvmDeclaredType it) {
          ProgressIndicatorProvider.checkCanceled();
          PsiBasedTypeFactory.this.setTypeModifiers(it, psiClass);
          PsiBasedTypeFactory.this.setVisibility(it, psiClass);
          boolean _isDeprecated = psiClass.isDeprecated();
          it.setDeprecated(_isDeprecated);
          String _name = psiClass.getName();
          it.setSimpleName(_name);
          String _name_1 = psiClass.getName();
          fqn.append(_name_1);
          String _string = fqn.toString();
          it.internalSetIdentifier(_string);
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              PsiBasedTypeFactory.this.createNestedTypes(it, psiClass, fqn);
            }
          };
          PsiBasedTypeFactory.this.append(fqn, "$", _function);
          fqn.append(".");
          PsiBasedTypeFactory.this.createMethods(it, psiClass, fqn);
          boolean _isAnnotationType = psiClass.isAnnotationType();
          boolean _not = (!_isAnnotationType);
          if (_not) {
            PsiBasedTypeFactory.this.createFields(it, psiClass, fqn);
          }
          PsiBasedTypeFactory.this.createSuperTypes(it, psiClass);
          PsiBasedTypeFactory.this.createAnnotationValues(it, psiClass);
          final PsiElementProvider _function_1 = new PsiElementProvider() {
            public PsiElement get() {
              return psiClass;
            }
          };
          PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function_1);
        }
      };
      _xblockexpression = ObjectExtensions.<JvmDeclaredType>operator_doubleArrow(_switchResult, _function_1);
    }
    return _xblockexpression;
  }
  
  protected void createAnnotationValues(final JvmAnnotationTarget it, final PsiModifierListOwner psiModifierListOwner) {
    final PsiModifierList modifierList = psiModifierListOwner.getModifierList();
    PsiAnnotation[] _annotations = modifierList.getAnnotations();
    for (final PsiAnnotation annotation : _annotations) {
      {
        final JvmAnnotationReference annotationReference = this.createAnnotationReference(annotation);
        boolean _notEquals = (!Objects.equal(annotationReference, null));
        if (_notEquals) {
          EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
          this.addUnique(_annotations_1, annotationReference);
        }
      }
    }
  }
  
  protected JvmAnnotationReference createAnnotationReference(final PsiAnnotation annotation) {
    JvmAnnotationReference _xblockexpression = null;
    {
      final Project project = annotation.getProject();
      PsiElementFactory _psiElementFactory = this.uriHelper.getPsiElementFactory(project);
      String _qualifiedName = annotation.getQualifiedName();
      final PsiClassType type = _psiElementFactory.createTypeByFQClassName(_qualifiedName);
      final PsiClass psiClass = type.resolve();
      boolean _equals = Objects.equal(psiClass, null);
      if (_equals) {
        return null;
      }
      JvmAnnotationReference _createJvmAnnotationReference = this._typesFactory.createJvmAnnotationReference();
      final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
        public void apply(final JvmAnnotationReference it) {
          JvmAnnotationType _craeteAnnotationProxy = PsiBasedTypeFactory.this.craeteAnnotationProxy(type);
          it.setAnnotation(_craeteAnnotationProxy);
          PsiAnnotationParameterList _parameterList = annotation.getParameterList();
          PsiNameValuePair[] _attributes = _parameterList.getAttributes();
          for (final PsiNameValuePair attribute : _attributes) {
            {
              String _elvis = null;
              String _name = attribute.getName();
              if (_name != null) {
                _elvis = _name;
              } else {
                _elvis = "value";
              }
              final String attributeName = _elvis;
              PsiAnnotationMemberValue _value = attribute.getValue();
              final Object value = PsiBasedTypeFactory.this.computeAnnotationValue(_value, project);
              PsiMethod[] _methods = psiClass.getMethods();
              final Function1<PsiMethod, Boolean> _function = new Function1<PsiMethod, Boolean>() {
                public Boolean apply(final PsiMethod it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, attributeName));
                }
              };
              final PsiMethod method = IterableExtensions.<PsiMethod>findFirst(((Iterable<PsiMethod>)Conversions.doWrapArray(_methods)), _function);
              final JvmAnnotationValue annotationValue = PsiBasedTypeFactory.this.createAnnotationValue(value, method);
              JvmOperation _createMethodProxy = PsiBasedTypeFactory.this.createMethodProxy(method);
              annotationValue.setOperation(_createMethodProxy);
              EList<JvmAnnotationValue> _explicitValues = it.getExplicitValues();
              PsiBasedTypeFactory.this.addUnique(_explicitValues, annotationValue);
            }
          }
        }
      };
      _xblockexpression = ObjectExtensions.<JvmAnnotationReference>operator_doubleArrow(_createJvmAnnotationReference, _function);
    }
    return _xblockexpression;
  }
  
  protected JvmOperation createMethodProxy(final PsiMethod method) {
    JvmOperation _elvis = null;
    JvmOperation _get = this.operationProxies.get(method);
    if (_get != null) {
      _elvis = _get;
    } else {
      JvmOperation _createJvmOperation = this._typesFactory.createJvmOperation();
      _elvis = _createJvmOperation;
    }
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        final URI uri = PsiBasedTypeFactory.this.uriHelper.getFullURI(method);
        if ((it instanceof InternalEObject)) {
          ((InternalEObject)it).eSetProxyURI(uri);
        }
        PsiBasedTypeFactory.this.operationProxies.put(method, it);
      }
    };
    return ObjectExtensions.<JvmOperation>operator_doubleArrow(_elvis, _function);
  }
  
  protected JvmEnumerationLiteral createEnumLiteralProxy(final PsiEnumConstant constant) {
    JvmEnumerationLiteral _elvis = null;
    JvmEnumerationLiteral _get = this.enumerationLiteralProxies.get(constant);
    if (_get != null) {
      _elvis = _get;
    } else {
      JvmEnumerationLiteral _createJvmEnumerationLiteral = this._typesFactory.createJvmEnumerationLiteral();
      _elvis = _createJvmEnumerationLiteral;
    }
    final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
      public void apply(final JvmEnumerationLiteral it) {
        final URI uri = PsiBasedTypeFactory.this.uriHelper.getFullURI(constant);
        if ((it instanceof InternalEObject)) {
          ((InternalEObject)it).eSetProxyURI(uri);
        }
        PsiBasedTypeFactory.this.enumerationLiteralProxies.put(constant, it);
      }
    };
    return ObjectExtensions.<JvmEnumerationLiteral>operator_doubleArrow(_elvis, _function);
  }
  
  protected JvmAnnotationType craeteAnnotationProxy(final PsiType annotationType) {
    JvmAnnotationType _elvis = null;
    JvmAnnotationType _get = this.annotationProxies.get(annotationType);
    if (_get != null) {
      _elvis = _get;
    } else {
      JvmAnnotationType _createJvmAnnotationType = this._typesFactory.createJvmAnnotationType();
      _elvis = _createJvmAnnotationType;
    }
    final Procedure1<JvmAnnotationType> _function = new Procedure1<JvmAnnotationType>() {
      public void apply(final JvmAnnotationType it) {
        final URI uri = PsiBasedTypeFactory.this.uriHelper.getFullURI(annotationType);
        if ((it instanceof InternalEObject)) {
          ((InternalEObject)it).eSetProxyURI(uri);
        }
        PsiBasedTypeFactory.this.annotationProxies.put(annotationType, it);
      }
    };
    return ObjectExtensions.<JvmAnnotationType>operator_doubleArrow(_elvis, _function);
  }
  
  protected void createFields(final JvmDeclaredType it, final PsiClass psiClass, final StringBuilder fqn) {
    PsiField[] _fields = psiClass.getFields();
    for (final PsiField field : _fields) {
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          EList<JvmMember> _members = it.getMembers();
          Object _createField = PsiBasedTypeFactory.this.createField(field, fqn);
          PsiBasedTypeFactory.this.addUnique(_members, _createField);
        }
      };
      this.preserve(fqn, _function);
    }
  }
  
  protected Object createField(final PsiField field, final StringBuilder fqn) {
    JvmField _xblockexpression = null;
    {
      ProgressIndicatorProvider.checkCanceled();
      JvmField _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (field instanceof PsiEnumConstant) {
          _matched=true;
          _switchResult = this._typesFactory.createJvmEnumerationLiteral();
        }
      }
      if (!_matched) {
        JvmField _createJvmField = this._typesFactory.createJvmField();
        final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
          public void apply(final JvmField it) {
            final Object value = field.computeConstantValue();
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              it.setConstant(true);
              it.setConstantValue(value);
            } else {
              it.setConstant(false);
            }
          }
        };
        _switchResult = ObjectExtensions.<JvmField>operator_doubleArrow(_createJvmField, _function);
      }
      final Procedure1<JvmField> _function_1 = new Procedure1<JvmField>() {
        public void apply(final JvmField it) {
          String _name = field.getName();
          StringBuilder _append = fqn.append(_name);
          String _string = _append.toString();
          it.internalSetIdentifier(_string);
          String _name_1 = field.getName();
          it.setSimpleName(_name_1);
          boolean _hasModifierProperty = field.hasModifierProperty(PsiModifier.FINAL);
          it.setFinal(_hasModifierProperty);
          boolean _hasModifierProperty_1 = field.hasModifierProperty(PsiModifier.STATIC);
          it.setStatic(_hasModifierProperty_1);
          boolean _hasModifierProperty_2 = field.hasModifierProperty(PsiModifier.TRANSIENT);
          it.setTransient(_hasModifierProperty_2);
          boolean _hasModifierProperty_3 = field.hasModifierProperty(PsiModifier.VOLATILE);
          it.setVolatile(_hasModifierProperty_3);
          boolean _isDeprecated = field.isDeprecated();
          it.setDeprecated(_isDeprecated);
          PsiBasedTypeFactory.this.setVisibility(it, field);
          PsiType _type = field.getType();
          JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_type);
          it.setType(_createTypeReference);
          PsiBasedTypeFactory.this.createAnnotationValues(it, field);
          final PsiElementProvider _function = new PsiElementProvider() {
            public PsiElement get() {
              return field;
            }
          };
          PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function);
        }
      };
      _xblockexpression = ObjectExtensions.<JvmField>operator_doubleArrow(_switchResult, _function_1);
    }
    return _xblockexpression;
  }
  
  protected void createSuperTypes(final JvmDeclaredType it, final PsiClass psiClass) {
    PsiClassType[] _superTypes = psiClass.getSuperTypes();
    for (final PsiClassType superType : _superTypes) {
      EList<JvmTypeReference> _superTypes_1 = it.getSuperTypes();
      JvmTypeReference _createTypeReference = this.createTypeReference(superType);
      this.addUnique(_superTypes_1, _createTypeReference);
    }
  }
  
  protected StringBuilder createMethods(final JvmDeclaredType it, final PsiClass psiClass, final StringBuilder fqn) {
    StringBuilder _xblockexpression = null;
    {
      PsiMethod[] _methods = psiClass.getMethods();
      for (final PsiMethod method : _methods) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            JvmExecutable _xifexpression = null;
            boolean _isConstructor = method.isConstructor();
            if (_isConstructor) {
              _xifexpression = PsiBasedTypeFactory.this.createConstructor(method, fqn);
            } else {
              JvmOperation _createOperation = PsiBasedTypeFactory.this.createOperation(method, fqn);
              final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  PsiBasedTypeFactory.this.setDefaultValue(it, method);
                }
              };
              _xifexpression = ObjectExtensions.<JvmOperation>operator_doubleArrow(_createOperation, _function);
            }
            final JvmExecutable operation = _xifexpression;
            EList<JvmMember> _members = it.getMembers();
            PsiBasedTypeFactory.this.addUnique(_members, operation);
          }
        };
        this.preserve(fqn, _function);
      }
      boolean _hasDefaultConstructor = this.hasDefaultConstructor(psiClass);
      if (_hasDefaultConstructor) {
        final Procedure0 _function_1 = new Procedure0() {
          public void apply() {
            EList<JvmMember> _members = it.getMembers();
            JvmConstructor _createDefaultConstructor = PsiBasedTypeFactory.this.createDefaultConstructor(psiClass, fqn);
            PsiBasedTypeFactory.this.addUnique(_members, _createDefaultConstructor);
          }
        };
        this.preserve(fqn, _function_1);
      }
      StringBuilder _xifexpression = null;
      boolean _isEnum = psiClass.isEnum();
      if (_isEnum) {
        StringBuilder _xblockexpression_1 = null;
        {
          final Procedure0 _function_2 = new Procedure0() {
            public void apply() {
              EList<JvmMember> _members = it.getMembers();
              JvmOperation _createValuesOperation = PsiBasedTypeFactory.this.createValuesOperation(psiClass, fqn);
              PsiBasedTypeFactory.this.addUnique(_members, _createValuesOperation);
            }
          };
          this.preserve(fqn, _function_2);
          final Procedure0 _function_3 = new Procedure0() {
            public void apply() {
              EList<JvmMember> _members = it.getMembers();
              JvmOperation _createValueOfOperation = PsiBasedTypeFactory.this.createValueOfOperation(psiClass, fqn);
              PsiBasedTypeFactory.this.addUnique(_members, _createValueOfOperation);
            }
          };
          _xblockexpression_1 = this.preserve(fqn, _function_3);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean hasDefaultConstructor(final PsiClass psiClass) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isInterface = psiClass.isInterface();
    boolean _not = (!_isInterface);
    if (!_not) {
      _and_1 = false;
    } else {
      boolean _isAnnotationType = psiClass.isAnnotationType();
      boolean _not_1 = (!_isAnnotationType);
      _and_1 = _not_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      PsiMethod[] _methods = psiClass.getMethods();
      final Function1<PsiMethod, Boolean> _function = new Function1<PsiMethod, Boolean>() {
        public Boolean apply(final PsiMethod it) {
          return Boolean.valueOf(it.isConstructor());
        }
      };
      boolean _exists = IterableExtensions.<PsiMethod>exists(((Iterable<PsiMethod>)Conversions.doWrapArray(_methods)), _function);
      boolean _not_2 = (!_exists);
      _and = _not_2;
    }
    return _and;
  }
  
  protected void setDefaultValue(final JvmOperation operation, final PsiMethod method) {
    if ((method instanceof PsiAnnotationMethod)) {
      PsiAnnotationMemberValue _defaultValue = ((PsiAnnotationMethod)method).getDefaultValue();
      Project _project = ((PsiAnnotationMethod)method).getProject();
      final Object defaultValue = this.computeAnnotationValue(_defaultValue, _project);
      boolean _notEquals = (!Objects.equal(defaultValue, null));
      if (_notEquals) {
        final JvmAnnotationValue annotationValue = this.createAnnotationValue(defaultValue, method);
        operation.setDefaultValue(annotationValue);
        annotationValue.setOperation(operation);
      }
    }
  }
  
  protected JvmAnnotationValue createAnnotationValue(final Object value, final PsiMethod method) {
    JvmAnnotationValue _xblockexpression = null;
    {
      final PsiType returnType = method.getReturnType();
      JvmAnnotationValue _xifexpression = null;
      boolean _isArray = this.isArray(returnType);
      if (_isArray) {
        _xifexpression = this.createArrayAnnotationValue(value, returnType);
      } else {
        _xifexpression = this.createAnnotationValue(value, returnType);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected JvmAnnotationValue createAnnotationValue(final Object value, final PsiType type) {
    JvmAnnotationValue _createAnnotationValue = this.createAnnotationValue(type);
    final Procedure1<JvmAnnotationValue> _function = new Procedure1<JvmAnnotationValue>() {
      public void apply(final JvmAnnotationValue it) {
        PsiBasedTypeFactory.this.addValue(it, value);
      }
    };
    return ObjectExtensions.<JvmAnnotationValue>operator_doubleArrow(_createAnnotationValue, _function);
  }
  
  protected JvmAnnotationValue createArrayAnnotationValue(final Object value, final PsiType type) {
    if ((type instanceof PsiArrayType)) {
      final PsiType componentType = ((PsiArrayType)type).getComponentType();
      JvmAnnotationValue _createAnnotationValue = this.createAnnotationValue(componentType);
      final Procedure1<JvmAnnotationValue> _function = new Procedure1<JvmAnnotationValue>() {
        public void apply(final JvmAnnotationValue it) {
          if ((value instanceof Object[])) {
            for (final Object element : ((Object[]) value)) {
              PsiBasedTypeFactory.this.addValue(it, element);
            }
          } else {
            PsiBasedTypeFactory.this.addValue(it, value);
          }
        }
      };
      return ObjectExtensions.<JvmAnnotationValue>operator_doubleArrow(_createAnnotationValue, _function);
    }
    String _canonicalText = type.getCanonicalText();
    String _plus = ("type is not an array type: " + _canonicalText);
    throw new IllegalArgumentException(_plus);
  }
  
  protected void addValue(final JvmAnnotationValue it, final Object value) {
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof JvmBooleanAnnotationValue) {
        _matched=true;
        EList<Boolean> _values = ((JvmBooleanAnnotationValue)it).getValues();
        this.addUnique(_values, ((Boolean) value));
      }
    }
    if (!_matched) {
      if (it instanceof JvmIntAnnotationValue) {
        _matched=true;
        EList<Integer> _values = ((JvmIntAnnotationValue)it).getValues();
        Integer _asInteger = this.asInteger(value);
        this.addUnique(_values, _asInteger);
      }
    }
    if (!_matched) {
      if (it instanceof JvmLongAnnotationValue) {
        _matched=true;
        EList<Long> _values = ((JvmLongAnnotationValue)it).getValues();
        Long _asLong = this.asLong(value);
        this.addUnique(_values, _asLong);
      }
    }
    if (!_matched) {
      if (it instanceof JvmShortAnnotationValue) {
        _matched=true;
        EList<Short> _values = ((JvmShortAnnotationValue)it).getValues();
        Short _asShort = this.asShort(value);
        this.addUnique(_values, _asShort);
      }
    }
    if (!_matched) {
      if (it instanceof JvmFloatAnnotationValue) {
        _matched=true;
        EList<Float> _values = ((JvmFloatAnnotationValue)it).getValues();
        Float _asFloat = this.asFloat(value);
        this.addUnique(_values, _asFloat);
      }
    }
    if (!_matched) {
      if (it instanceof JvmDoubleAnnotationValue) {
        _matched=true;
        EList<Double> _values = ((JvmDoubleAnnotationValue)it).getValues();
        Double _asDouble = this.asDouble(value);
        this.addUnique(_values, _asDouble);
      }
    }
    if (!_matched) {
      if (it instanceof JvmCharAnnotationValue) {
        _matched=true;
        EList<Character> _values = ((JvmCharAnnotationValue)it).getValues();
        Character _asCharacter = this.asCharacter(value);
        this.addUnique(_values, _asCharacter);
      }
    }
    if (!_matched) {
      if (it instanceof JvmByteAnnotationValue) {
        _matched=true;
        EList<Byte> _values = ((JvmByteAnnotationValue)it).getValues();
        Byte _asByte = this.asByte(value);
        this.addUnique(_values, _asByte);
      }
    }
    if (!_matched) {
      if (it instanceof JvmStringAnnotationValue) {
        _matched=true;
        EList<String> _values = ((JvmStringAnnotationValue)it).getValues();
        this.addUnique(_values, ((String) value));
      }
    }
    if (!_matched) {
      if (it instanceof JvmTypeAnnotationValue) {
        _matched=true;
        EList<JvmTypeReference> _values = ((JvmTypeAnnotationValue)it).getValues();
        JvmTypeReference _createTypeReference = this.createTypeReference(((PsiType) value));
        this.addUnique(_values, _createTypeReference);
      }
    }
    if (!_matched) {
      if (it instanceof JvmAnnotationAnnotationValue) {
        _matched=true;
        EList<JvmAnnotationReference> _values = ((JvmAnnotationAnnotationValue)it).getValues();
        JvmAnnotationReference _createAnnotationReference = this.createAnnotationReference(((PsiAnnotation) value));
        this.addUnique(_values, _createAnnotationReference);
      }
    }
    if (!_matched) {
      if (it instanceof JvmEnumAnnotationValue) {
        _matched=true;
        EList<JvmEnumerationLiteral> _values = ((JvmEnumAnnotationValue)it).getValues();
        JvmEnumerationLiteral _createEnumLiteralProxy = this.createEnumLiteralProxy(((PsiEnumConstant) value));
        this.addUnique(_values, _createEnumLiteralProxy);
      }
    }
  }
  
  protected Integer asInteger(final Object value) {
    Integer _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Integer) {
        _matched=true;
        _switchResult = ((Integer)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Integer.valueOf(((Number)value).intValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Integer) value);
    }
    return _switchResult;
  }
  
  protected Long asLong(final Object value) {
    Long _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Long) {
        _matched=true;
        _switchResult = ((Long)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Long.valueOf(((Number)value).longValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Long) value);
    }
    return _switchResult;
  }
  
  protected Short asShort(final Object value) {
    Short _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Short) {
        _matched=true;
        _switchResult = ((Short)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Short.valueOf(((Number)value).shortValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Short) value);
    }
    return _switchResult;
  }
  
  protected Float asFloat(final Object value) {
    Float _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Float) {
        _matched=true;
        _switchResult = ((Float)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Float.valueOf(((Number)value).floatValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Float) value);
    }
    return _switchResult;
  }
  
  protected Double asDouble(final Object value) {
    Double _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Double) {
        _matched=true;
        _switchResult = ((Double)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Double.valueOf(((Number)value).doubleValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Double) value);
    }
    return _switchResult;
  }
  
  protected Character asCharacter(final Object value) {
    Character _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Character) {
        _matched=true;
        _switchResult = ((Character)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        byte _byteValue = ((Number)value).byteValue();
        _switchResult = Character.valueOf(((char) _byteValue));
      }
    }
    if (!_matched) {
      _switchResult = ((Character) value);
    }
    return _switchResult;
  }
  
  protected Byte asByte(final Object value) {
    Byte _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof Byte) {
        _matched=true;
        _switchResult = ((Byte)value);
      }
    }
    if (!_matched) {
      if (value instanceof Number) {
        _matched=true;
        _switchResult = Byte.valueOf(((Number)value).byteValue());
      }
    }
    if (!_matched) {
      _switchResult = ((Byte) value);
    }
    return _switchResult;
  }
  
  protected JvmAnnotationValue createAnnotationValue(final PsiType type) {
    JvmAnnotationValue _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type, PsiType.BOOLEAN)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmBooleanAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.INT)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmIntAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.LONG)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmLongAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.SHORT)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmShortAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.FLOAT)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmFloatAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.DOUBLE)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmDoubleAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.CHAR)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmCharAnnotationValue();
      }
    }
    if (!_matched) {
      if (Objects.equal(type, PsiType.BYTE)) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmByteAnnotationValue();
      }
    }
    if (!_matched) {
      boolean _isClassType = this.isClassType(type, String.class);
      if (_isClassType) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmStringAnnotationValue();
      }
    }
    if (!_matched) {
      boolean _isClassType_1 = this.isClassType(type, Class.class);
      if (_isClassType_1) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmTypeAnnotationValue();
      }
    }
    if (!_matched) {
      boolean _isAnnotation = this.isAnnotation(type);
      if (_isAnnotation) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmAnnotationAnnotationValue();
      }
    }
    if (!_matched) {
      boolean _isEnum = this.isEnum(type);
      if (_isEnum) {
        _matched=true;
        _switchResult = this._typesFactory.createJvmEnumAnnotationValue();
      }
    }
    if (!_matched) {
      String _canonicalText = type.getCanonicalText();
      String _plus = ("Unexpected type: " + _canonicalText);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }
  
  protected Object computeAnnotationValue(final PsiAnnotationMemberValue value, final Project project) {
    Object _xblockexpression = null;
    {
      JavaPsiFacade _instance = JavaPsiFacade.getInstance(project);
      @Extension
      final PsiConstantEvaluationHelper constantEvaluationHelper = _instance.getConstantEvaluationHelper();
      Object _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (value instanceof PsiAnnotation) {
          _matched=true;
          _switchResult = value;
        }
      }
      if (!_matched) {
        if (value instanceof PsiReferenceExpression) {
          _matched=true;
          _switchResult = ((PsiReferenceExpression)value).resolve();
        }
      }
      if (!_matched) {
        if (value instanceof PsiClassObjectAccessExpression) {
          _matched=true;
          PsiTypeElement _operand = ((PsiClassObjectAccessExpression)value).getOperand();
          _switchResult = _operand.getType();
        }
      }
      if (!_matched) {
        if (value instanceof PsiArrayInitializerMemberValue) {
          _matched=true;
          PsiAnnotationMemberValue[] _initializers = ((PsiArrayInitializerMemberValue)value).getInitializers();
          final Function1<PsiAnnotationMemberValue, Object> _function = new Function1<PsiAnnotationMemberValue, Object>() {
            public Object apply(final PsiAnnotationMemberValue it) {
              return PsiBasedTypeFactory.this.computeAnnotationValue(it, project);
            }
          };
          List<Object> _map = ListExtensions.<PsiAnnotationMemberValue, Object>map(((List<PsiAnnotationMemberValue>)Conversions.doWrapArray(_initializers)), _function);
          _switchResult = _map.toArray();
        }
      }
      if (!_matched) {
        _switchResult = constantEvaluationHelper.computeConstantExpression(value);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected String getPackageName(final PsiClass psiClass) {
    PsiFile _containingFile = psiClass.getContainingFile();
    final PsiJavaFile javaFile = ((PsiJavaFile) _containingFile);
    final String psiPackageName = javaFile.getPackageName();
    boolean _isEmpty = psiPackageName.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return psiPackageName;
    }
    return null;
  }
  
  protected JvmOperation createValuesOperation(final PsiClass psiClass, final StringBuilder fqn) {
    JvmOperation _createJvmOperation = this._typesFactory.createJvmOperation();
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        StringBuilder _append = fqn.append("values()");
        String _string = _append.toString();
        it.internalSetIdentifier(_string);
        it.setSimpleName("values");
        it.setVisibility(JvmVisibility.PUBLIC);
        it.setStatic(true);
        Project _project = psiClass.getProject();
        PsiElementFactory _psiElementFactory = PsiBasedTypeFactory.this.uriHelper.getPsiElementFactory(_project);
        PsiClassType _createType = _psiElementFactory.createType(psiClass);
        JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_createType);
        it.setReturnType(_createTypeReference);
        it.setDeprecated(false);
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            return psiClass;
          }
        };
        PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function);
      }
    };
    return ObjectExtensions.<JvmOperation>operator_doubleArrow(_createJvmOperation, _function);
  }
  
  protected JvmOperation createValueOfOperation(final PsiClass psiClass, final StringBuilder fqn) {
    JvmOperation _xblockexpression = null;
    {
      Project _project = psiClass.getProject();
      final PsiElementFactory psiElementFactory = this.uriHelper.getPsiElementFactory(_project);
      JvmOperation _createJvmOperation = this._typesFactory.createJvmOperation();
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          StringBuilder _append = fqn.append("valueOf(java.lang.String)");
          String _string = _append.toString();
          it.internalSetIdentifier(_string);
          it.setSimpleName("valueOf");
          it.setVisibility(JvmVisibility.PUBLIC);
          it.setStatic(true);
          PsiClassType _createType = psiElementFactory.createType(psiClass);
          JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_createType);
          it.setReturnType(_createTypeReference);
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _createJvmFormalParameter = PsiBasedTypeFactory.this._typesFactory.createJvmFormalParameter();
          final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
            public void apply(final JvmFormalParameter it) {
              it.setName("name");
              String _name = String.class.getName();
              PsiClassType _createTypeByFQClassName = psiElementFactory.createTypeByFQClassName(_name);
              JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_createTypeByFQClassName);
              it.setParameterType(_createTypeReference);
            }
          };
          JvmFormalParameter _doubleArrow = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_createJvmFormalParameter, _function);
          PsiBasedTypeFactory.this.addUnique(_parameters, _doubleArrow);
          it.setDeprecated(false);
          final PsiElementProvider _function_1 = new PsiElementProvider() {
            public PsiElement get() {
              return psiClass;
            }
          };
          PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function_1);
        }
      };
      _xblockexpression = ObjectExtensions.<JvmOperation>operator_doubleArrow(_createJvmOperation, _function);
    }
    return _xblockexpression;
  }
  
  protected JvmConstructor createDefaultConstructor(final PsiClass psiClass, final StringBuilder fqn) {
    JvmConstructor _createJvmConstructor = this._typesFactory.createJvmConstructor();
    final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
      public void apply(final JvmConstructor it) {
        String _name = psiClass.getName();
        StringBuilder _append = fqn.append(_name);
        StringBuilder _append_1 = _append.append("()");
        String _string = _append_1.toString();
        it.internalSetIdentifier(_string);
        String _name_1 = psiClass.getName();
        it.setSimpleName(_name_1);
        it.setVisibility(JvmVisibility.PUBLIC);
        it.setDeprecated(false);
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            return psiClass;
          }
        };
        PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function);
      }
    };
    return ObjectExtensions.<JvmConstructor>operator_doubleArrow(_createJvmConstructor, _function);
  }
  
  protected JvmConstructor createConstructor(final PsiMethod psiMethod, final StringBuilder fqn) {
    JvmConstructor _createJvmConstructor = this._typesFactory.createJvmConstructor();
    final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
      public void apply(final JvmConstructor it) {
        PsiBasedTypeFactory.this.enhanceExecutable(it, psiMethod, fqn);
        PsiBasedTypeFactory.this.createAnnotationValues(it, psiMethod);
      }
    };
    return ObjectExtensions.<JvmConstructor>operator_doubleArrow(_createJvmConstructor, _function);
  }
  
  protected JvmOperation createOperation(final PsiMethod method, final StringBuilder fqn) {
    JvmOperation _xblockexpression = null;
    {
      ProgressIndicatorProvider.checkCanceled();
      JvmOperation _createJvmOperation = this._typesFactory.createJvmOperation();
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          PsiBasedTypeFactory.this.enhanceExecutable(it, method, fqn);
          boolean _hasModifierProperty = method.hasModifierProperty(PsiModifier.ABSTRACT);
          it.setAbstract(_hasModifierProperty);
          boolean _hasModifierProperty_1 = method.hasModifierProperty(PsiModifier.FINAL);
          it.setFinal(_hasModifierProperty_1);
          boolean _hasModifierProperty_2 = method.hasModifierProperty(PsiModifier.STATIC);
          it.setStatic(_hasModifierProperty_2);
          boolean _hasModifierProperty_3 = method.hasModifierProperty(PsiModifier.STRICTFP);
          it.setStrictFloatingPoint(_hasModifierProperty_3);
          boolean _hasModifierProperty_4 = method.hasModifierProperty(PsiModifier.SYNCHRONIZED);
          it.setSynchronized(_hasModifierProperty_4);
          boolean _hasModifierProperty_5 = method.hasModifierProperty(PsiModifier.NATIVE);
          it.setNative(_hasModifierProperty_5);
          PsiType _returnType = method.getReturnType();
          JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_returnType);
          it.setReturnType(_createTypeReference);
          PsiBasedTypeFactory.this.createAnnotationValues(it, method);
          final PsiElementProvider _function = new PsiElementProvider() {
            public PsiElement get() {
              return method;
            }
          };
          PsiBasedTypeFactory.this.psiModelAssociator.associate(it, _function);
        }
      };
      _xblockexpression = ObjectExtensions.<JvmOperation>operator_doubleArrow(_createJvmOperation, _function);
    }
    return _xblockexpression;
  }
  
  protected void enhanceExecutable(final JvmExecutable it, final PsiMethod psiMethod, final StringBuilder fqn) {
    this.createTypeParameters(it, psiMethod);
    String _name = psiMethod.getName();
    StringBuilder _append = fqn.append(_name);
    _append.append("(");
    this.createFormalParameters(it, psiMethod, fqn);
    StringBuilder _append_1 = fqn.append(")");
    final String identifier = _append_1.toString();
    it.internalSetIdentifier(identifier);
    String _name_1 = psiMethod.getName();
    it.setSimpleName(_name_1);
    this.setVisibility(it, psiMethod);
    boolean _isDeprecated = psiMethod.isDeprecated();
    it.setDeprecated(_isDeprecated);
    boolean _isVarArgs = psiMethod.isVarArgs();
    it.setVarArgs(_isVarArgs);
  }
  
  protected void createFormalParameters(final JvmExecutable it, final PsiMethod psiMethod, final StringBuilder fqn) {
    final PsiParameterList parameterList = psiMethod.getParameterList();
    for (int i = 0; (i < parameterList.getParametersCount()); i++) {
      {
        PsiParameter[] _parameters = parameterList.getParameters();
        final PsiParameter parameter = _parameters[i];
        if ((i != 0)) {
          fqn.append(",");
        }
        PsiType _type = parameter.getType();
        this.uriHelper.appendTypeName(fqn, _type);
        EList<JvmFormalParameter> _parameters_1 = it.getParameters();
        JvmFormalParameter _createFormalParameter = this.createFormalParameter(parameter);
        this.addUnique(_parameters_1, _createFormalParameter);
      }
    }
  }
  
  protected void createTypeParameters(final JvmTypeParameterDeclarator it, final PsiTypeParameterListOwner psiTypeParameterListOwner) {
    PsiTypeParameter[] _typeParameters = psiTypeParameterListOwner.getTypeParameters();
    for (final PsiTypeParameter typeParameter : _typeParameters) {
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      JvmTypeParameter _createTypeParameter = this.createTypeParameter(typeParameter);
      this.addUnique(_typeParameters_1, _createTypeParameter);
    }
  }
  
  protected JvmFormalParameter createFormalParameter(final PsiParameter parameter) {
    JvmFormalParameter _createJvmFormalParameter = this._typesFactory.createJvmFormalParameter();
    final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
      public void apply(final JvmFormalParameter it) {
        String _name = parameter.getName();
        it.setName(_name);
        PsiType _type = parameter.getType();
        JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(_type);
        it.setParameterType(_createTypeReference);
        PsiBasedTypeFactory.this.createAnnotationValues(it, parameter);
      }
    };
    return ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_createJvmFormalParameter, _function);
  }
  
  protected JvmTypeParameter createTypeParameter(final PsiTypeParameter parameter) {
    JvmTypeParameter _createJvmTypeParameter = this._typesFactory.createJvmTypeParameter();
    final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
      public void apply(final JvmTypeParameter it) {
        String _name = parameter.getName();
        it.setName(_name);
        final PsiClassType[] extendsListTypes = parameter.getExtendsListTypes();
        boolean _isEmpty = ((List<PsiClassType>)Conversions.doWrapArray(extendsListTypes)).isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          for (final PsiClassType upperBound : extendsListTypes) {
            {
              JvmUpperBound _createJvmUpperBound = PsiBasedTypeFactory.this._typesFactory.createJvmUpperBound();
              final JvmTypeConstraintImplCustom jvmUpperBound = ((JvmTypeConstraintImplCustom) _createJvmUpperBound);
              JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(upperBound);
              jvmUpperBound.internalSetTypeReference(_createTypeReference);
              EList<JvmTypeConstraint> _constraints = it.getConstraints();
              PsiBasedTypeFactory.this.addUnique(_constraints, jvmUpperBound);
            }
          }
        } else {
          JvmUpperBound _createJvmUpperBound = PsiBasedTypeFactory.this._typesFactory.createJvmUpperBound();
          final JvmTypeConstraintImplCustom jvmUpperBound = ((JvmTypeConstraintImplCustom) _createJvmUpperBound);
          Project _project = parameter.getProject();
          JvmTypeReference _createObjectClassReference = PsiBasedTypeFactory.this.createObjectClassReference(_project);
          jvmUpperBound.internalSetTypeReference(_createObjectClassReference);
          EList<JvmTypeConstraint> _constraints = it.getConstraints();
          PsiBasedTypeFactory.this.addUnique(_constraints, jvmUpperBound);
        }
      }
    };
    return ObjectExtensions.<JvmTypeParameter>operator_doubleArrow(_createJvmTypeParameter, _function);
  }
  
  protected JvmTypeReference createObjectClassReference(final Project it) {
    PsiElementFactory _psiElementFactory = this.uriHelper.getPsiElementFactory(it);
    String _name = Object.class.getName();
    PsiClassType _createTypeByFQClassName = _psiElementFactory.createTypeByFQClassName(_name);
    return this.createTypeReference(_createTypeByFQClassName);
  }
  
  protected JvmTypeReference createTypeReference(final PsiType psiType) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (psiType instanceof PsiArrayType) {
        _matched=true;
        PsiType _componentType = ((PsiArrayType)psiType).getComponentType();
        _switchResult = this.createArrayTypeReference(_componentType);
      }
    }
    if (!_matched) {
      if (psiType instanceof PsiClassType) {
        _matched=true;
        JvmTypeReference _xblockexpression = null;
        {
          final PsiClassType.ClassResolveResult resolveResult = ((PsiClassType)psiType).resolveGenerics();
          final PsiClass psiClass = resolveResult.getElement();
          JvmTypeReference _xifexpression = null;
          boolean _equals = Objects.equal(psiClass, null);
          if (_equals) {
            _xifexpression = this._typesFactory.createJvmUnknownTypeReference();
          } else {
            JvmParameterizedTypeReference _xifexpression_1 = null;
            int _parameterCount = ((PsiClassType)psiType).getParameterCount();
            boolean _equals_1 = (_parameterCount == 0);
            if (_equals_1) {
              JvmParameterizedTypeReference _createClassTypeReference = this.createClassTypeReference(resolveResult);
              final Procedure1<JvmParameterizedTypeReference> _function = new Procedure1<JvmParameterizedTypeReference>() {
                public void apply(final JvmParameterizedTypeReference it) {
                  JvmType _createProxy = PsiBasedTypeFactory.this.createProxy(psiType);
                  it.setType(_createProxy);
                }
              };
              _xifexpression_1 = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createClassTypeReference, _function);
            } else {
              JvmParameterizedTypeReference _createClassTypeReference_1 = this.createClassTypeReference(resolveResult);
              final Procedure1<JvmParameterizedTypeReference> _function_1 = new Procedure1<JvmParameterizedTypeReference>() {
                public void apply(final JvmParameterizedTypeReference it) {
                  PsiClassType _rawType = ((PsiClassType)psiType).rawType();
                  JvmType _createProxy = PsiBasedTypeFactory.this.createProxy(_rawType);
                  it.setType(_createProxy);
                  PsiType[] _parameters = ((PsiClassType)psiType).getParameters();
                  for (final PsiType parameter : _parameters) {
                    EList<JvmTypeReference> _arguments = it.getArguments();
                    JvmTypeReference _createTypeArgument = PsiBasedTypeFactory.this.createTypeArgument(parameter);
                    PsiBasedTypeFactory.this.addUnique(_arguments, _createTypeArgument);
                  }
                }
              };
              _xifexpression_1 = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createClassTypeReference_1, _function_1);
            }
            _xifexpression = _xifexpression_1;
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      JvmParameterizedTypeReference _createJvmParameterizedTypeReference = this._typesFactory.createJvmParameterizedTypeReference();
      final Procedure1<JvmParameterizedTypeReference> _function = new Procedure1<JvmParameterizedTypeReference>() {
        public void apply(final JvmParameterizedTypeReference it) {
          JvmType _createProxy = PsiBasedTypeFactory.this.createProxy(psiType);
          it.setType(_createProxy);
        }
      };
      _switchResult = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createJvmParameterizedTypeReference, _function);
    }
    return _switchResult;
  }
  
  protected JvmParameterizedTypeReference createClassTypeReference(final PsiClassType.ClassResolveResult resolveResult) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      final PsiClass psiClass = resolveResult.getElement();
      JvmParameterizedTypeReference _xifexpression = null;
      boolean _isInnerTypeReference = this.isInnerTypeReference(psiClass);
      if (_isInnerTypeReference) {
        JvmInnerTypeReference _createJvmInnerTypeReference = this._typesFactory.createJvmInnerTypeReference();
        final Procedure1<JvmInnerTypeReference> _function = new Procedure1<JvmInnerTypeReference>() {
          public void apply(final JvmInnerTypeReference it) {
            final PsiClass containingClass = psiClass.getContainingClass();
            Project _project = psiClass.getProject();
            final PsiElementFactory psiElementFactory = PsiBasedTypeFactory.this.uriHelper.getPsiElementFactory(_project);
            PsiSubstitutor _substitutor = resolveResult.getSubstitutor();
            final PsiClassType outerType = psiElementFactory.createType(containingClass, _substitutor);
            JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(outerType);
            it.setOuter(((JvmParameterizedTypeReference) _createTypeReference));
          }
        };
        _xifexpression = ObjectExtensions.<JvmInnerTypeReference>operator_doubleArrow(_createJvmInnerTypeReference, _function);
      } else {
        _xifexpression = this._typesFactory.createJvmParameterizedTypeReference();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean isInnerTypeReference(final PsiClass psiClass) {
    boolean _and = false;
    PsiClass _containingClass = psiClass.getContainingClass();
    boolean _notEquals = (!Objects.equal(_containingClass, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _hasModifierProperty = psiClass.hasModifierProperty(PsiModifier.STATIC);
      boolean _not = (!_hasModifierProperty);
      _and = _not;
    }
    return _and;
  }
  
  protected JvmTypeReference createTypeArgument(final PsiType type) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof PsiWildcardType) {
        _matched=true;
        JvmWildcardTypeReference _createJvmWildcardTypeReference = this._typesFactory.createJvmWildcardTypeReference();
        final Procedure1<JvmWildcardTypeReference> _function = new Procedure1<JvmWildcardTypeReference>() {
          public void apply(final JvmWildcardTypeReference it) {
            JvmUpperBound _createJvmUpperBound = PsiBasedTypeFactory.this._typesFactory.createJvmUpperBound();
            final JvmTypeConstraintImplCustom upperBound = ((JvmTypeConstraintImplCustom) _createJvmUpperBound);
            JvmTypeReference _createUpperBoundReference = PsiBasedTypeFactory.this.createUpperBoundReference(((PsiWildcardType)type));
            upperBound.internalSetTypeReference(_createUpperBoundReference);
            EList<JvmTypeConstraint> _constraints = it.getConstraints();
            PsiBasedTypeFactory.this.addUnique(_constraints, upperBound);
            final PsiType superBound = ((PsiWildcardType)type).getSuperBound();
            boolean _notEquals = (!Objects.equal(superBound, PsiType.NULL));
            if (_notEquals) {
              JvmLowerBound _createJvmLowerBound = PsiBasedTypeFactory.this._typesFactory.createJvmLowerBound();
              final JvmTypeConstraintImplCustom lowerBound = ((JvmTypeConstraintImplCustom) _createJvmLowerBound);
              JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(superBound);
              lowerBound.internalSetTypeReference(_createTypeReference);
              EList<JvmTypeConstraint> _constraints_1 = it.getConstraints();
              PsiBasedTypeFactory.this.addUnique(_constraints_1, lowerBound);
            }
          }
        };
        _switchResult = ObjectExtensions.<JvmWildcardTypeReference>operator_doubleArrow(_createJvmWildcardTypeReference, _function);
      }
    }
    if (!_matched) {
      _switchResult = this.createTypeReference(type);
    }
    return _switchResult;
  }
  
  protected JvmTypeReference createUpperBoundReference(final PsiWildcardType type) {
    JvmTypeReference _xblockexpression = null;
    {
      final PsiType extendsBound = type.getExtendsBound();
      JvmTypeReference _xifexpression = null;
      boolean _notEquals = (!Objects.equal(extendsBound, PsiType.NULL));
      if (_notEquals) {
        _xifexpression = this.createTypeReference(extendsBound);
      } else {
        PsiManager _manager = type.getManager();
        Project _project = _manager.getProject();
        _xifexpression = this.createObjectClassReference(_project);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected JvmGenericArrayTypeReference createArrayTypeReference(final PsiType psiComponentType) {
    JvmGenericArrayTypeReference _createJvmGenericArrayTypeReference = this._typesFactory.createJvmGenericArrayTypeReference();
    final Procedure1<JvmGenericArrayTypeReference> _function = new Procedure1<JvmGenericArrayTypeReference>() {
      public void apply(final JvmGenericArrayTypeReference it) {
        JvmTypeReference _createTypeReference = PsiBasedTypeFactory.this.createTypeReference(psiComponentType);
        it.setComponentType(_createTypeReference);
      }
    };
    return ObjectExtensions.<JvmGenericArrayTypeReference>operator_doubleArrow(_createJvmGenericArrayTypeReference, _function);
  }
  
  protected JvmType createProxy(final PsiType psiType) {
    JvmType _elvis = null;
    JvmType _get = this.typeProxies.get(psiType);
    if (_get != null) {
      _elvis = _get;
    } else {
      JvmVoid _createJvmVoid = this._typesFactory.createJvmVoid();
      _elvis = _createJvmVoid;
    }
    final Procedure1<JvmType> _function = new Procedure1<JvmType>() {
      public void apply(final JvmType it) {
        final URI uri = PsiBasedTypeFactory.this.uriHelper.getFullURI(psiType);
        if ((it instanceof InternalEObject)) {
          ((InternalEObject)it).eSetProxyURI(uri);
        }
        PsiBasedTypeFactory.this.typeProxies.put(psiType, it);
      }
    };
    return ObjectExtensions.<JvmType>operator_doubleArrow(_elvis, _function);
  }
  
  protected void createNestedTypes(final JvmDeclaredType it, final PsiClass psiClass, final StringBuilder fqn) {
    PsiClass[] _innerClasses = psiClass.getInnerClasses();
    final Function1<PsiClass, Boolean> _function = new Function1<PsiClass, Boolean>() {
      public Boolean apply(final PsiClass it) {
        boolean _and = false;
        boolean _isAnonymous = PsiBasedTypeFactory.this.isAnonymous(it);
        boolean _not = (!_isAnonymous);
        if (!_not) {
          _and = false;
        } else {
          boolean _isSynthetic = PsiBasedTypeFactory.this.isSynthetic(it);
          boolean _not_1 = (!_isSynthetic);
          _and = _not_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<PsiClass> _filter = IterableExtensions.<PsiClass>filter(((Iterable<PsiClass>)Conversions.doWrapArray(_innerClasses)), _function);
    for (final PsiClass innerClass : _filter) {
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          EList<JvmMember> _members = it.getMembers();
          JvmDeclaredType _createType = PsiBasedTypeFactory.this.createType(innerClass, fqn);
          PsiBasedTypeFactory.this.addUnique(_members, _createType);
        }
      };
      this.preserve(fqn, _function_1);
    }
  }
  
  protected boolean isAnonymous(final PsiClass psiClass) {
    return (psiClass instanceof PsiAnonymousClass);
  }
  
  protected boolean isSynthetic(final PsiClass psiClass) {
    return false;
  }
  
  protected void setVisibility(final JvmMember it, final PsiModifierListOwner modifierListOwner) {
    JvmVisibility _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      boolean _hasModifierProperty = modifierListOwner.hasModifierProperty(PsiModifier.PRIVATE);
      if (_hasModifierProperty) {
        _matched=true;
        _switchResult = JvmVisibility.PRIVATE;
      }
    }
    if (!_matched) {
      boolean _hasModifierProperty_1 = modifierListOwner.hasModifierProperty(PsiModifier.PROTECTED);
      if (_hasModifierProperty_1) {
        _matched=true;
        _switchResult = JvmVisibility.PROTECTED;
      }
    }
    if (!_matched) {
      boolean _hasModifierProperty_2 = modifierListOwner.hasModifierProperty(PsiModifier.PUBLIC);
      if (_hasModifierProperty_2) {
        _matched=true;
        _switchResult = JvmVisibility.PUBLIC;
      }
    }
    it.setVisibility(_switchResult);
  }
  
  protected void setTypeModifiers(final JvmDeclaredType it, final PsiClass psiClass) {
    boolean _hasModifierProperty = psiClass.hasModifierProperty(PsiModifier.ABSTRACT);
    it.setAbstract(_hasModifierProperty);
    boolean _hasModifierProperty_1 = psiClass.hasModifierProperty(PsiModifier.STATIC);
    it.setStatic(_hasModifierProperty_1);
    boolean _isEnum = psiClass.isEnum();
    boolean _not = (!_isEnum);
    if (_not) {
      boolean _hasModifierProperty_2 = psiClass.hasModifierProperty(PsiModifier.FINAL);
      it.setFinal(_hasModifierProperty_2);
    }
  }
  
  protected void addUnique(final EList<?> list, final Object object) {
    ((InternalEList<Object>) list).addUnique(object);
  }
  
  protected StringBuilder append(final StringBuilder builder, final String value, final Procedure0 procedure) {
    StringBuilder _xblockexpression = null;
    {
      final int length = builder.length();
      builder.append(value);
      procedure.apply();
      builder.setLength(length);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder preserve(final StringBuilder builder, final Procedure0 procedure) {
    StringBuilder _xblockexpression = null;
    {
      final int length = builder.length();
      procedure.apply();
      builder.setLength(length);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }
  
  protected boolean isPrimitive(final PsiType type) {
    return (type instanceof PsiPrimitiveType);
  }
  
  protected boolean isClassType(final PsiType type, final Class<?> clazz) {
    boolean _xifexpression = false;
    if ((type instanceof PsiClassType)) {
      PsiClass _resolve = ((PsiClassType)type).resolve();
      String _qualifiedName = _resolve.getQualifiedName();
      String _name = clazz.getName();
      _xifexpression = Objects.equal(_qualifiedName, _name);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  protected boolean isAnnotation(final PsiType type) {
    boolean _xifexpression = false;
    if ((type instanceof PsiClassType)) {
      PsiClass _resolve = ((PsiClassType)type).resolve();
      _xifexpression = _resolve.isAnnotationType();
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  protected boolean isEnum(final PsiType type) {
    boolean _xifexpression = false;
    if ((type instanceof PsiClassType)) {
      PsiClass _resolve = ((PsiClassType)type).resolve();
      _xifexpression = _resolve.isEnum();
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  protected boolean isArray(final PsiType type) {
    return (type instanceof PsiArrayType);
  }
}
