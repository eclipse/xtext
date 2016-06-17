/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NestedImpl#getNested <em>Nested</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedImpl extends MinimalEObjectImpl.Container implements Nested
{
  /**
   * The cached value of the '{@link #getNested() <em>Nested</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNested()
   * @generated
   * @ordered
   */
  protected EList<SomeContainer> nested;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NestedImpl()
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
    return PartialParserTestLanguagePackage.Literals.NESTED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SomeContainer> getNested()
  {
    if (nested == null)
    {
      nested = new EObjectContainmentEList<SomeContainer>(SomeContainer.class, this, PartialParserTestLanguagePackage.NESTED__NESTED);
    }
    return nested;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.NESTED__NESTED:
        return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case PartialParserTestLanguagePackage.NESTED__NESTED:
        return getNested();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PartialParserTestLanguagePackage.NESTED__NESTED:
        getNested().clear();
        getNested().addAll((Collection<? extends SomeContainer>)newValue);
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
      case PartialParserTestLanguagePackage.NESTED__NESTED:
        getNested().clear();
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
      case PartialParserTestLanguagePackage.NESTED__NESTED:
        return nested != null && !nested.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NestedImpl
