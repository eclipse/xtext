package org.eclipse.xtext.idea.types.access;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.idea.types.access.StubURIHelper;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PsiBasedTypeFactory /* implements ITypeFactory<PsiClass, JvmDeclaredType>  */{
  private final Stopwatches.StoppedTask createTypeTask = Stopwatches.forTask("PsiClassFactory.createType");
  
  private final /* Map<PsiType, JvmType> */Object typeProxies;
  
  private final /* Map<PsiMethod, JvmOperation> */Object operationProxies;
  
  private final /* Map<PsiType, JvmAnnotationType> */Object annotationProxies;
  
  private final /* Map<PsiEnumConstant, JvmEnumerationLiteral> */Object enumerationLiteralProxies;
  
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
  
  public JvmDeclaredType createType(final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\npackageName cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\npackageName cannot be resolved");
  }
  
  protected JvmDeclaredType createType(final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type PsiBasedTypeFactory"
      + "\ncheckCanceled cannot be resolved"
      + "\nanonymous cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nsynthetic cannot be resolved"
      + "\nannotationType cannot be resolved"
      + "\nenum cannot be resolved"
      + "\ninterface cannot be resolved"
      + "\nmodifierList cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTRICTFP cannot be resolved"
      + "\ncheckCanceled cannot be resolved"
      + "\ndeprecated cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nannotationType cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  protected void createAnnotationValues(final JvmAnnotationTarget it, final /* PsiModifierListOwner */Object psiModifierListOwner) {
    throw new Error("Unresolved compilation problems:"
      + "\nmodifierList cannot be resolved"
      + "\nannotations cannot be resolved"
      + "\ncreateAnnotationReference cannot be resolved"
      + "\n!= cannot be resolved");
  }
  
  protected JvmAnnotationReference createAnnotationReference(final /* PsiAnnotation */Object annotation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined for the type PsiBasedTypeFactory"
      + "\nproject cannot be resolved"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateTypeByFQClassName cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\nresolve cannot be resolved"
      + "\n== cannot be resolved"
      + "\ncraeteAnnotationProxy cannot be resolved"
      + "\nparameterList cannot be resolved"
      + "\nattributes cannot be resolved"
      + "\nname cannot be resolved"
      + "\n?: cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\ncomputeAnnotationValue cannot be resolved"
      + "\nmethods cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved"
      + "\ncreateAnnotationValue cannot be resolved"
      + "\noperation cannot be resolved"
      + "\ncreateMethodProxy cannot be resolved");
  }
  
  protected JvmOperation createMethodProxy(final /* PsiMethod */Object method) {
    throw new Error("Unresolved compilation problems:"
      + "\nfullURI cannot be resolved");
  }
  
  protected JvmEnumerationLiteral createEnumLiteralProxy(final /* PsiEnumConstant */Object constant) {
    throw new Error("Unresolved compilation problems:"
      + "\nfullURI cannot be resolved");
  }
  
  protected JvmAnnotationType craeteAnnotationProxy(final /* PsiType */Object annotationType) {
    throw new Error("Unresolved compilation problems:"
      + "\nfullURI cannot be resolved");
  }
  
  protected void createFields(final JvmDeclaredType it, final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nfields cannot be resolved"
      + "\ncreateField cannot be resolved");
  }
  
  protected Object createField(final /* PsiField */Object field, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiEnumConstant cannot be resolved to a type."
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\ncheckCanceled cannot be resolved"
      + "\ncomputeConstantValue cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nFINAL cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nTRANSIENT cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nVOLATILE cannot be resolved"
      + "\ndeprecated cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected void createSuperTypes(final JvmDeclaredType it, final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nsuperTypes cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected StringBuilder createMethods(final JvmDeclaredType it, final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nmethods cannot be resolved"
      + "\nconstructor cannot be resolved"
      + "\ncreateConstructor cannot be resolved"
      + "\ncreateOperation cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nhasDefaultConstructor cannot be resolved"
      + "\ncreateDefaultConstructor cannot be resolved"
      + "\nenum cannot be resolved"
      + "\ncreateValuesOperation cannot be resolved"
      + "\ncreateValueOfOperation cannot be resolved");
  }
  
  protected Object hasDefaultConstructor(final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field constructor is undefined for the type PsiBasedTypeFactory"
      + "\ninterface cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nannotationType cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nmethods cannot be resolved"
      + "\nexists cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  protected Object setDefaultValue(final JvmOperation operation, final /* PsiMethod */Object method) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiAnnotationMethod cannot be resolved to a type."
      + "\ndefaultValue cannot be resolved"
      + "\ncomputeAnnotationValue cannot be resolved"
      + "\nproject cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ncreateAnnotationValue cannot be resolved"
      + "\noperation cannot be resolved");
  }
  
  protected Object createAnnotationValue(final Object value, final /* PsiMethod */Object method) {
    throw new Error("Unresolved compilation problems:"
      + "\nreturnType cannot be resolved"
      + "\narray cannot be resolved");
  }
  
  protected Object createAnnotationValue(final Object value, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\ncreateAnnotationValue cannot be resolved"
      + "\n=> cannot be resolved");
  }
  
  protected Object createArrayAnnotationValue(final Object value, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiArrayType cannot be resolved to a type."
      + "\ncomponentType cannot be resolved"
      + "\ncreateAnnotationValue cannot be resolved"
      + "\n=> cannot be resolved"
      + "\ncanonicalText cannot be resolved");
  }
  
  protected void addValue(final JvmAnnotationValue it, final Object value) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiType cannot be resolved to a type."
      + "\nPsiAnnotation cannot be resolved to a type."
      + "\nPsiEnumConstant cannot be resolved to a type."
      + "\ncreateTypeReference cannot be resolved"
      + "\ncreateAnnotationReference cannot be resolved"
      + "\ncreateEnumLiteralProxy cannot be resolved");
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
  
  protected JvmAnnotationValue createAnnotationValue(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nBOOLEAN cannot be resolved"
      + "\nINT cannot be resolved"
      + "\nLONG cannot be resolved"
      + "\nSHORT cannot be resolved"
      + "\nFLOAT cannot be resolved"
      + "\nDOUBLE cannot be resolved"
      + "\nCHAR cannot be resolved"
      + "\nBYTE cannot be resolved"
      + "\nisClassType cannot be resolved"
      + "\nisClassType cannot be resolved"
      + "\nannotation cannot be resolved"
      + "\nenum cannot be resolved"
      + "\ncanonicalText cannot be resolved");
  }
  
  protected Object computeAnnotationValue(final /* PsiAnnotationMemberValue */Object value, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiAnnotation cannot be resolved to a type."
      + "\nPsiReferenceExpression cannot be resolved to a type."
      + "\nPsiClassObjectAccessExpression cannot be resolved to a type."
      + "\nPsiArrayInitializerMemberValue cannot be resolved to a type."
      + "\nThe method or field JavaPsiFacade is undefined for the type PsiBasedTypeFactory"
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\ngetInstance cannot be resolved"
      + "\nconstantEvaluationHelper cannot be resolved"
      + "\nresolve cannot be resolved"
      + "\noperand cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ninitializers cannot be resolved"
      + "\nmap cannot be resolved"
      + "\ntoArray cannot be resolved"
      + "\ncomputeConstantExpression cannot be resolved");
  }
  
  protected Object getPackageName(final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiJavaFile cannot be resolved to a type."
      + "\ncontainingFile cannot be resolved"
      + "\ngetPackageName cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  protected JvmOperation createValuesOperation(final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nproject cannot be resolved"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected JvmOperation createValueOfOperation(final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nproject cannot be resolved"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\ncreateTypeReference cannot be resolved"
      + "\ncreateTypeByFQClassName cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected JvmConstructor createDefaultConstructor(final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  protected JvmConstructor createConstructor(final /* PsiMethod */Object psiMethod, final StringBuilder fqn) {
    JvmConstructor _createJvmConstructor = this._typesFactory.createJvmConstructor();
    final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
      public void apply(final JvmConstructor it) {
        PsiBasedTypeFactory.this.enhanceExecutable(it, psiMethod, fqn);
        PsiBasedTypeFactory.this.createAnnotationValues(it, psiMethod);
      }
    };
    return ObjectExtensions.<JvmConstructor>operator_doubleArrow(_createJvmConstructor, _function);
  }
  
  protected JvmOperation createOperation(final /* PsiMethod */Object method, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\ncheckCanceled cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nABSTRACT cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nFINAL cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTRICTFP cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSYNCHRONIZED cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nNATIVE cannot be resolved"
      + "\nreturnType cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected void enhanceExecutable(final JvmExecutable it, final /* PsiMethod */Object psiMethod, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ndeprecated cannot be resolved"
      + "\nvarArgs cannot be resolved");
  }
  
  protected void createFormalParameters(final JvmExecutable it, final /* PsiMethod */Object psiMethod, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\nparameterList cannot be resolved"
      + "\nparametersCount cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ncreateFormalParameter cannot be resolved");
  }
  
  protected void createTypeParameters(final JvmTypeParameterDeclarator it, final /* PsiTypeParameterListOwner */Object psiTypeParameterListOwner) {
    throw new Error("Unresolved compilation problems:"
      + "\ntypeParameters cannot be resolved"
      + "\ncreateTypeParameter cannot be resolved");
  }
  
  protected JvmFormalParameter createFormalParameter(final /* PsiParameter */Object parameter) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected JvmTypeParameter createTypeParameter(final /* PsiTypeParameter */Object parameter) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved"
      + "\nextendsListTypes cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved"
      + "\ncreateTypeReference cannot be resolved"
      + "\nproject cannot be resolved"
      + "\ncreateObjectClassReference cannot be resolved");
  }
  
  protected Object createObjectClassReference(final /* Project */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\ncreateTypeByFQClassName cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected JvmTypeReference createTypeReference(final /* PsiType */Object psiType) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiArrayType cannot be resolved to a type."
      + "\nPsiClassType cannot be resolved to a type."
      + "\nThe method or field type is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field type is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field arguments is undefined for the type PsiBasedTypeFactory"
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\ncomponentType cannot be resolved"
      + "\ncreateArrayTypeReference cannot be resolved"
      + "\nresolveGenerics cannot be resolved"
      + "\nelement cannot be resolved"
      + "\n== cannot be resolved"
      + "\nparameterCount cannot be resolved"
      + "\n== cannot be resolved"
      + "\ncreateClassTypeReference cannot be resolved"
      + "\n=> cannot be resolved"
      + "\ncreateProxy cannot be resolved"
      + "\ncreateClassTypeReference cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nrawType cannot be resolved"
      + "\ncreateProxy cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\naddUnique cannot be resolved"
      + "\ncreateTypeArgument cannot be resolved"
      + "\ncreateProxy cannot be resolved");
  }
  
  protected JvmParameterizedTypeReference createClassTypeReference(final /* ClassResolveResult */Object resolveResult) {
    throw new Error("Unresolved compilation problems:"
      + "\nelement cannot be resolved"
      + "\ninnerTypeReference cannot be resolved"
      + "\ncontainingClass cannot be resolved"
      + "\nproject cannot be resolved"
      + "\npsiElementFactory cannot be resolved"
      + "\ncreateType cannot be resolved"
      + "\nsubstitutor cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected Object isInnerTypeReference(final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\ncontainingClass cannot be resolved"
      + "\n!= cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  protected JvmWildcardTypeReference createTypeArgument(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiWildcardType cannot be resolved to a type."
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\ncreateUpperBoundReference cannot be resolved"
      + "\nsuperBound cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nNULL cannot be resolved"
      + "\ncreateTypeReference cannot be resolved"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected Object createUpperBoundReference(final /* PsiWildcardType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiType is undefined for the type PsiBasedTypeFactory"
      + "\nextendsBound cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nNULL cannot be resolved"
      + "\ncreateTypeReference cannot be resolved"
      + "\nmanager cannot be resolved"
      + "\nproject cannot be resolved");
  }
  
  protected JvmGenericArrayTypeReference createArrayTypeReference(final /* PsiType */Object psiComponentType) {
    throw new Error("Unresolved compilation problems:"
      + "\ncreateTypeReference cannot be resolved");
  }
  
  protected JvmType createProxy(final /* PsiType */Object psiType) {
    throw new Error("Unresolved compilation problems:"
      + "\nfullURI cannot be resolved");
  }
  
  protected void createNestedTypes(final JvmDeclaredType it, final /* PsiClass */Object psiClass, final StringBuilder fqn) {
    throw new Error("Unresolved compilation problems:"
      + "\ninnerClasses cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\ncreateType cannot be resolved");
  }
  
  protected boolean isAnonymous(final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiAnonymousClass cannot be resolved to a type.");
  }
  
  protected boolean isSynthetic(final /* PsiClass */Object psiClass) {
    return false;
  }
  
  protected void setVisibility(final JvmMember it, final /* PsiModifierListOwner */Object modifierListOwner) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nhasModifierProperty cannot be resolved"
      + "\nPRIVATE cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nPROTECTED cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nPUBLIC cannot be resolved");
  }
  
  protected void setTypeModifiers(final JvmDeclaredType it, final /* PsiClass */Object psiClass) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nThe method or field PsiModifier is undefined for the type PsiBasedTypeFactory"
      + "\nhasModifierProperty cannot be resolved"
      + "\nABSTRACT cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\nenum cannot be resolved"
      + "\n! cannot be resolved"
      + "\nhasModifierProperty cannot be resolved"
      + "\nFINAL cannot be resolved");
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
  
  protected boolean isPrimitive(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiPrimitiveType cannot be resolved to a type.");
  }
  
  protected Object isClassType(final /* PsiType */Object type, final Class<?> clazz) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassType cannot be resolved to a type."
      + "\nresolve cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  protected Object isAnnotation(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassType cannot be resolved to a type."
      + "\nresolve cannot be resolved"
      + "\nannotationType cannot be resolved");
  }
  
  protected Object isEnum(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassType cannot be resolved to a type."
      + "\nresolve cannot be resolved"
      + "\nenum cannot be resolved");
  }
  
  protected boolean isArray(final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiArrayType cannot be resolved to a type.");
  }
}
