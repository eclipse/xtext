/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB1;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Second Level B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl#getThirdLevelB1 <em>Third Level B1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl#getThirdLevelB2 <em>Third Level B2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecondLevelBImpl extends MinimalEObjectImpl.Container implements SecondLevelB
{
  /**
   * The cached value of the '{@link #getThirdLevelB1() <em>Third Level B1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThirdLevelB1()
   * @generated
   * @ordered
   */
  protected EList<ThirdLevelB1> thirdLevelB1;

  /**
   * The cached value of the '{@link #getThirdLevelB2() <em>Third Level B2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThirdLevelB2()
   * @generated
   * @ordered
   */
  protected EList<ThirdLevelB2> thirdLevelB2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SecondLevelBImpl()
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
    return ContentAssistContextTestPackage.Literals.SECOND_LEVEL_B;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ThirdLevelB1> getThirdLevelB1()
  {
    if (thirdLevelB1 == null)
    {
      thirdLevelB1 = new EObjectContainmentEList<ThirdLevelB1>(ThirdLevelB1.class, this, ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1);
    }
    return thirdLevelB1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ThirdLevelB2> getThirdLevelB2()
  {
    if (thirdLevelB2 == null)
    {
      thirdLevelB2 = new EObjectContainmentEList<ThirdLevelB2>(ThirdLevelB2.class, this, ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2);
    }
    return thirdLevelB2;
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1:
        return ((InternalEList<?>)getThirdLevelB1()).basicRemove(otherEnd, msgs);
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2:
        return ((InternalEList<?>)getThirdLevelB2()).basicRemove(otherEnd, msgs);
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1:
        return getThirdLevelB1();
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2:
        return getThirdLevelB2();
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1:
        getThirdLevelB1().clear();
        getThirdLevelB1().addAll((Collection<? extends ThirdLevelB1>)newValue);
        return;
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2:
        getThirdLevelB2().clear();
        getThirdLevelB2().addAll((Collection<? extends ThirdLevelB2>)newValue);
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1:
        getThirdLevelB1().clear();
        return;
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2:
        getThirdLevelB2().clear();
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
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B1:
        return thirdLevelB1 != null && !thirdLevelB1.isEmpty();
      case ContentAssistContextTestPackage.SECOND_LEVEL_B__THIRD_LEVEL_B2:
        return thirdLevelB2 != null && !thirdLevelB2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SecondLevelBImpl
