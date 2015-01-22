/**
 */
package org.eclipse.xtext.testlanguages.testLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.testlanguages.testLang.ReducibleComposite;
import org.eclipse.xtext.testlanguages.testLang.TerminalElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reducible Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.impl.ReducibleCompositeImpl#getActionFeature <em>Action Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReducibleCompositeImpl extends ReducibleElementImpl implements ReducibleComposite
{
  /**
   * The cached value of the '{@link #getActionFeature() <em>Action Feature</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActionFeature()
   * @generated
   * @ordered
   */
  protected EList<TerminalElement> actionFeature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReducibleCompositeImpl()
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
    return TestLangPackage.Literals.REDUCIBLE_COMPOSITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TerminalElement> getActionFeature()
  {
    if (actionFeature == null)
    {
      actionFeature = new EObjectContainmentEList<TerminalElement>(TerminalElement.class, this, TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE);
    }
    return actionFeature;
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
      case TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE:
        return ((InternalEList<?>)getActionFeature()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE:
        return getActionFeature();
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
      case TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE:
        getActionFeature().clear();
        getActionFeature().addAll((Collection<? extends TerminalElement>)newValue);
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
      case TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE:
        getActionFeature().clear();
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
      case TestLangPackage.REDUCIBLE_COMPOSITE__ACTION_FEATURE:
        return actionFeature != null && !actionFeature.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ReducibleCompositeImpl
