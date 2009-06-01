/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage;
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel;
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA;
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>First Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl#getSecondLevelA <em>Second Level A</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl#getSecondLevelB <em>Second Level B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FirstLevelImpl extends MinimalEObjectImpl.Container implements FirstLevel
{
  /**
   * The cached value of the '{@link #getSecondLevelA() <em>Second Level A</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondLevelA()
   * @generated
   * @ordered
   */
  protected EList<SecondLevelA> secondLevelA;

  /**
   * The cached value of the '{@link #getSecondLevelB() <em>Second Level B</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondLevelB()
   * @generated
   * @ordered
   */
  protected EList<SecondLevelB> secondLevelB;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FirstLevelImpl()
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
    return ContentAssistContextTestPackage.Literals.FIRST_LEVEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SecondLevelA> getSecondLevelA()
  {
    if (secondLevelA == null)
    {
      secondLevelA = new EObjectContainmentEList<SecondLevelA>(SecondLevelA.class, this, ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A);
    }
    return secondLevelA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SecondLevelB> getSecondLevelB()
  {
    if (secondLevelB == null)
    {
      secondLevelB = new EObjectContainmentEList<SecondLevelB>(SecondLevelB.class, this, ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B);
    }
    return secondLevelB;
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
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A:
        return ((InternalEList<?>)getSecondLevelA()).basicRemove(otherEnd, msgs);
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B:
        return ((InternalEList<?>)getSecondLevelB()).basicRemove(otherEnd, msgs);
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
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A:
        return getSecondLevelA();
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B:
        return getSecondLevelB();
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
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A:
        getSecondLevelA().clear();
        getSecondLevelA().addAll((Collection<? extends SecondLevelA>)newValue);
        return;
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B:
        getSecondLevelB().clear();
        getSecondLevelB().addAll((Collection<? extends SecondLevelB>)newValue);
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
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A:
        getSecondLevelA().clear();
        return;
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B:
        getSecondLevelB().clear();
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
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_A:
        return secondLevelA != null && !secondLevelA.isEmpty();
      case ContentAssistContextTestPackage.FIRST_LEVEL__SECOND_LEVEL_B:
        return secondLevelB != null && !secondLevelB.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FirstLevelImpl
