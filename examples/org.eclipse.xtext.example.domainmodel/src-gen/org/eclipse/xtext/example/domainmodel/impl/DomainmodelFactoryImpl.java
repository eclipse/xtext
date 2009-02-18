/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomainmodelFactoryImpl.java,v 1.2 2009/02/18 21:20:18 sefftinge Exp $
 */
package org.eclipse.xtext.example.domainmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.example.domainmodel.Attribute;
import org.eclipse.xtext.example.domainmodel.DataType;
import org.eclipse.xtext.example.domainmodel.DomainmodelFactory;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.File;
import org.eclipse.xtext.example.domainmodel.Import;
import org.eclipse.xtext.example.domainmodel.NamedElement;
import org.eclipse.xtext.example.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.Parameter;
import org.eclipse.xtext.example.domainmodel.Reference;
import org.eclipse.xtext.example.domainmodel.StructuralFeature;
import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.example.domainmodel.TypeRef;
import org.eclipse.xtext.example.domainmodel.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainmodelFactoryImpl extends EFactoryImpl implements DomainmodelFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DomainmodelFactory init()
  {
    try
    {
      DomainmodelFactory theDomainmodelFactory = (DomainmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.xtext/Domainmodel"); 
      if (theDomainmodelFactory != null)
      {
        return theDomainmodelFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DomainmodelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainmodelFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DomainmodelPackage.FILE: return createFile();
      case DomainmodelPackage.IMPORT: return createImport();
      case DomainmodelPackage.NAMED_ELEMENT: return createNamedElement();
      case DomainmodelPackage.PACKAGE: return createPackage();
      case DomainmodelPackage.TYPE: return createType();
      case DomainmodelPackage.DATA_TYPE: return createDataType();
      case DomainmodelPackage.ENTITY: return createEntity();
      case DomainmodelPackage.FEATURE: return createFeature();
      case DomainmodelPackage.STRUCTURAL_FEATURE: return createStructuralFeature();
      case DomainmodelPackage.ATTRIBUTE: return createAttribute();
      case DomainmodelPackage.REFERENCE: return createReference();
      case DomainmodelPackage.OPERATION: return createOperation();
      case DomainmodelPackage.PARAMETER: return createParameter();
      case DomainmodelPackage.TYPED_ELEMENT: return createTypedElement();
      case DomainmodelPackage.TYPE_REF: return createTypeRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File createFile()
  {
    FileImpl file = new FileImpl();
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement createNamedElement()
  {
    NamedElementImpl namedElement = new NamedElementImpl();
    return namedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.example.domainmodel.Package createPackage()
  {
    PackageImpl package_ = new PackageImpl();
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuralFeature createStructuralFeature()
  {
    StructuralFeatureImpl structuralFeature = new StructuralFeatureImpl();
    return structuralFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedElement createTypedElement()
  {
    TypedElementImpl typedElement = new TypedElementImpl();
    return typedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeRef createTypeRef()
  {
    TypeRefImpl typeRef = new TypeRefImpl();
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainmodelPackage getDomainmodelPackage()
  {
    return (DomainmodelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DomainmodelPackage getPackage()
  {
    return DomainmodelPackage.eINSTANCE;
  }

} //DomainmodelFactoryImpl
