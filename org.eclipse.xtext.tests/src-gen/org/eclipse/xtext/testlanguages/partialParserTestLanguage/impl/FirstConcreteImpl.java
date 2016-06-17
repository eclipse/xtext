/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>First Concrete</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.FirstConcreteImpl#getReferencedContainer <em>Referenced Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FirstConcreteImpl extends AbstractChildImpl implements FirstConcrete
{
  /**
   * The cached value of the '{@link #getReferencedContainer() <em>Referenced Container</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedContainer()
   * @generated
   * @ordered
   */
  protected SomeContainer referencedContainer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FirstConcreteImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PartialParserTestLanguagePackage.Literals.FIRST_CONCRETE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SomeContainer getReferencedContainer()
  {
    if (referencedContainer != null && referencedContainer.eIsProxy())
    {
      InternalEObject oldReferencedContainer = (InternalEObject)referencedContainer;
      referencedContainer = (SomeContainer)eResolveProxy(oldReferencedContainer);
      if (referencedContainer != oldReferencedContainer)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER, oldReferencedContainer, referencedContainer));
      }
    }
    return referencedContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SomeContainer basicGetReferencedContainer()
  {
    return referencedContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedContainer(SomeContainer newReferencedContainer)
  {
    SomeContainer oldReferencedContainer = referencedContainer;
    referencedContainer = newReferencedContainer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER, oldReferencedContainer, referencedContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER:
        if (resolve) return getReferencedContainer();
        return basicGetReferencedContainer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER:
        setReferencedContainer((SomeContainer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER:
        setReferencedContainer((SomeContainer)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.FIRST_CONCRETE__REFERENCED_CONTAINER:
        return referencedContainer != null;
    }
    return super.eIsSet(featureID);
  }

} //FirstConcreteImpl
