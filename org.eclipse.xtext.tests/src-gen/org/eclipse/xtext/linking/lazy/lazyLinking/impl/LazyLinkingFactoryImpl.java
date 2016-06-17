/**
 */
package org.eclipse.xtext.linking.lazy.lazyLinking.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.lazy.lazyLinking.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LazyLinkingFactoryImpl extends EFactoryImpl implements LazyLinkingFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LazyLinkingFactory init()
  {
    try
    {
      LazyLinkingFactory theLazyLinkingFactory = (LazyLinkingFactory)EPackage.Registry.INSTANCE.getEFactory(LazyLinkingPackage.eNS_URI);
      if (theLazyLinkingFactory != null)
      {
        return theLazyLinkingFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LazyLinkingFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LazyLinkingFactoryImpl()
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
      case LazyLinkingPackage.MODEL: return createModel();
      case LazyLinkingPackage.TYPE: return createType();
      case LazyLinkingPackage.PROPERTY: return createProperty();
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY: return createUnresolvedProxyProperty();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnresolvedProxyProperty createUnresolvedProxyProperty()
  {
    UnresolvedProxyPropertyImpl unresolvedProxyProperty = new UnresolvedProxyPropertyImpl();
    return unresolvedProxyProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LazyLinkingPackage getLazyLinkingPackage()
  {
    return (LazyLinkingPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LazyLinkingPackage getPackage()
  {
    return LazyLinkingPackage.eINSTANCE;
  }

} //LazyLinkingFactoryImpl
