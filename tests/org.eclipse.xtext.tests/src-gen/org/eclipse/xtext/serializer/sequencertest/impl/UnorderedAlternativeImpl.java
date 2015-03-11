/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeValDelegate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedAlternativeImpl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedAlternativeImpl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedAlternativeImpl#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedAlternativeImpl#getVal4 <em>Val4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnorderedAlternativeImpl extends MinimalEObjectImpl.Container implements UnorderedAlternative
{
  /**
   * The cached value of the '{@link #getVal1() <em>Val1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected EList<String> val1;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected EList<Integer> val2;

  /**
   * The cached value of the '{@link #getVal3() <em>Val3</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal3()
   * @generated
   * @ordered
   */
  protected EList<UnorderedAlternativeVal> val3;

  /**
   * The cached value of the '{@link #getVal4() <em>Val4</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal4()
   * @generated
   * @ordered
   */
  protected EList<UnorderedAlternativeValDelegate> val4;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnorderedAlternativeImpl()
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
    return SequencertestPackage.Literals.UNORDERED_ALTERNATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal1()
  {
    if (val1 == null)
    {
      val1 = new EDataTypeEList<String>(String.class, this, SequencertestPackage.UNORDERED_ALTERNATIVE__VAL1);
    }
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getVal2()
  {
    if (val2 == null)
    {
      val2 = new EDataTypeEList<Integer>(Integer.class, this, SequencertestPackage.UNORDERED_ALTERNATIVE__VAL2);
    }
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnorderedAlternativeVal> getVal3()
  {
    if (val3 == null)
    {
      val3 = new EObjectContainmentEList<UnorderedAlternativeVal>(UnorderedAlternativeVal.class, this, SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3);
    }
    return val3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnorderedAlternativeValDelegate> getVal4()
  {
    if (val4 == null)
    {
      val4 = new EObjectContainmentEList<UnorderedAlternativeValDelegate>(UnorderedAlternativeValDelegate.class, this, SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4);
    }
    return val4;
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
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3:
        return ((InternalEList<?>)getVal3()).basicRemove(otherEnd, msgs);
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4:
        return ((InternalEList<?>)getVal4()).basicRemove(otherEnd, msgs);
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
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL1:
        return getVal1();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL2:
        return getVal2();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3:
        return getVal3();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4:
        return getVal4();
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
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL1:
        getVal1().clear();
        getVal1().addAll((Collection<? extends String>)newValue);
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL2:
        getVal2().clear();
        getVal2().addAll((Collection<? extends Integer>)newValue);
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3:
        getVal3().clear();
        getVal3().addAll((Collection<? extends UnorderedAlternativeVal>)newValue);
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4:
        getVal4().clear();
        getVal4().addAll((Collection<? extends UnorderedAlternativeValDelegate>)newValue);
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
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL1:
        getVal1().clear();
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL2:
        getVal2().clear();
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3:
        getVal3().clear();
        return;
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4:
        getVal4().clear();
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
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL1:
        return val1 != null && !val1.isEmpty();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL2:
        return val2 != null && !val2.isEmpty();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL3:
        return val3 != null && !val3.isEmpty();
      case SequencertestPackage.UNORDERED_ALTERNATIVE__VAL4:
        return val4 != null && !val4.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (val1: ");
    result.append(val1);
    result.append(", val2: ");
    result.append(val2);
    result.append(')');
    return result.toString();
  }

} //UnorderedAlternativeImpl
