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
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA;
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1;
import org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Second Level A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl#getThirdLevelA1 <em>Third Level A1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl#getThirdLevelA2 <em>Third Level A2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecondLevelAImpl extends MinimalEObjectImpl.Container implements SecondLevelA
{
  /**
   * The cached value of the '{@link #getThirdLevelA1() <em>Third Level A1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThirdLevelA1()
   * @generated
   * @ordered
   */
  protected EList<ThirdLevelA1> thirdLevelA1;

  /**
   * The cached value of the '{@link #getThirdLevelA2() <em>Third Level A2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThirdLevelA2()
   * @generated
   * @ordered
   */
  protected EList<ThirdLevelA2> thirdLevelA2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SecondLevelAImpl()
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
    return ContentAssistContextTestPackage.Literals.SECOND_LEVEL_A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ThirdLevelA1> getThirdLevelA1()
  {
    if (thirdLevelA1 == null)
    {
      thirdLevelA1 = new EObjectContainmentEList<ThirdLevelA1>(ThirdLevelA1.class, this, ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1);
    }
    return thirdLevelA1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ThirdLevelA2> getThirdLevelA2()
  {
    if (thirdLevelA2 == null)
    {
      thirdLevelA2 = new EObjectContainmentEList<ThirdLevelA2>(ThirdLevelA2.class, this, ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2);
    }
    return thirdLevelA2;
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1:
        return ((InternalEList<?>)getThirdLevelA1()).basicRemove(otherEnd, msgs);
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2:
        return ((InternalEList<?>)getThirdLevelA2()).basicRemove(otherEnd, msgs);
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1:
        return getThirdLevelA1();
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2:
        return getThirdLevelA2();
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1:
        getThirdLevelA1().clear();
        getThirdLevelA1().addAll((Collection<? extends ThirdLevelA1>)newValue);
        return;
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2:
        getThirdLevelA2().clear();
        getThirdLevelA2().addAll((Collection<? extends ThirdLevelA2>)newValue);
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1:
        getThirdLevelA1().clear();
        return;
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2:
        getThirdLevelA2().clear();
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A1:
        return thirdLevelA1 != null && !thirdLevelA1.isEmpty();
      case ContentAssistContextTestPackage.SECOND_LEVEL_A__THIRD_LEVEL_A2:
        return thirdLevelA2 != null && !thirdLevelA2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SecondLevelAImpl
