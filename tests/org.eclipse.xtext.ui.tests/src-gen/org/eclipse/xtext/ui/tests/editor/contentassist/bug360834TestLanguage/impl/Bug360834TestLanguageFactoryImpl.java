/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug360834TestLanguageFactoryImpl extends EFactoryImpl implements Bug360834TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug360834TestLanguageFactory init()
  {
    try
    {
      Bug360834TestLanguageFactory theBug360834TestLanguageFactory = (Bug360834TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(Bug360834TestLanguagePackage.eNS_URI);
      if (theBug360834TestLanguageFactory != null)
      {
        return theBug360834TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug360834TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug360834TestLanguageFactoryImpl()
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
      case Bug360834TestLanguagePackage.MODEL: return createModel();
      case Bug360834TestLanguagePackage.ALTERNATIVE: return createAlternative();
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION: return createRecursiveClassDeclaration();
      case Bug360834TestLanguagePackage.MODIFIERS: return createModifiers();
      case Bug360834TestLanguagePackage.UNORDERED: return createUnordered();
      case Bug360834TestLanguagePackage.SIMPLE_CLASS_DECLARATION: return createSimpleClassDeclaration();
      case Bug360834TestLanguagePackage.CLASS_MEMBER: return createClassMember();
      case Bug360834TestLanguagePackage.UNORDERED_MODIFIERS: return createUnorderedModifiers();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug360834TestLanguagePackage.VISIBILITY:
        return createVisibilityFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug360834TestLanguagePackage.VISIBILITY:
        return convertVisibilityToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alternative createAlternative()
  {
    AlternativeImpl alternative = new AlternativeImpl();
    return alternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecursiveClassDeclaration createRecursiveClassDeclaration()
  {
    RecursiveClassDeclarationImpl recursiveClassDeclaration = new RecursiveClassDeclarationImpl();
    return recursiveClassDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modifiers createModifiers()
  {
    ModifiersImpl modifiers = new ModifiersImpl();
    return modifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unordered createUnordered()
  {
    UnorderedImpl unordered = new UnorderedImpl();
    return unordered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleClassDeclaration createSimpleClassDeclaration()
  {
    SimpleClassDeclarationImpl simpleClassDeclaration = new SimpleClassDeclarationImpl();
    return simpleClassDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassMember createClassMember()
  {
    ClassMemberImpl classMember = new ClassMemberImpl();
    return classMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedModifiers createUnorderedModifiers()
  {
    UnorderedModifiersImpl unorderedModifiers = new UnorderedModifiersImpl();
    return unorderedModifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Visibility createVisibilityFromString(EDataType eDataType, String initialValue)
  {
    Visibility result = Visibility.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVisibilityToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug360834TestLanguagePackage getBug360834TestLanguagePackage()
  {
    return (Bug360834TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug360834TestLanguagePackage getPackage()
  {
    return Bug360834TestLanguagePackage.eINSTANCE;
  }

} //Bug360834TestLanguageFactoryImpl
