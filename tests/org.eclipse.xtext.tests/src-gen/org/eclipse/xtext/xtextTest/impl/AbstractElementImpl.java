/**
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtextTest.AbstractElement;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.AbstractElementImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.AbstractElementImpl#isPredicated <em>Predicated</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.AbstractElementImpl#isFirstSetPredicated <em>First Set Predicated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractElementImpl extends MinimalEObjectImpl.Container implements AbstractElement
{
  /**
   * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected static final String CARDINALITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected String cardinality = CARDINALITY_EDEFAULT;

  /**
   * The default value of the '{@link #isPredicated() <em>Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPredicated()
   * @generated
   * @ordered
   */
  protected static final boolean PREDICATED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPredicated() <em>Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPredicated()
   * @generated
   * @ordered
   */
  protected boolean predicated = PREDICATED_EDEFAULT;

  /**
   * The default value of the '{@link #isFirstSetPredicated() <em>First Set Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirstSetPredicated()
   * @generated
   * @ordered
   */
  protected static final boolean FIRST_SET_PREDICATED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFirstSetPredicated() <em>First Set Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirstSetPredicated()
   * @generated
   * @ordered
   */
  protected boolean firstSetPredicated = FIRST_SET_PREDICATED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractElementImpl()
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
    return XtextTestPackage.Literals.ABSTRACT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCardinality()
  {
    return cardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCardinality(String newCardinality)
  {
    String oldCardinality = cardinality;
    cardinality = newCardinality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.ABSTRACT_ELEMENT__CARDINALITY, oldCardinality, cardinality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPredicated()
  {
    return predicated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPredicated(boolean newPredicated)
  {
    boolean oldPredicated = predicated;
    predicated = newPredicated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.ABSTRACT_ELEMENT__PREDICATED, oldPredicated, predicated));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFirstSetPredicated()
  {
    return firstSetPredicated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstSetPredicated(boolean newFirstSetPredicated)
  {
    boolean oldFirstSetPredicated = firstSetPredicated;
    firstSetPredicated = newFirstSetPredicated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.ABSTRACT_ELEMENT__FIRST_SET_PREDICATED, oldFirstSetPredicated, firstSetPredicated));
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
      case XtextTestPackage.ABSTRACT_ELEMENT__CARDINALITY:
        return getCardinality();
      case XtextTestPackage.ABSTRACT_ELEMENT__PREDICATED:
        return isPredicated();
      case XtextTestPackage.ABSTRACT_ELEMENT__FIRST_SET_PREDICATED:
        return isFirstSetPredicated();
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
      case XtextTestPackage.ABSTRACT_ELEMENT__CARDINALITY:
        setCardinality((String)newValue);
        return;
      case XtextTestPackage.ABSTRACT_ELEMENT__PREDICATED:
        setPredicated((Boolean)newValue);
        return;
      case XtextTestPackage.ABSTRACT_ELEMENT__FIRST_SET_PREDICATED:
        setFirstSetPredicated((Boolean)newValue);
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
      case XtextTestPackage.ABSTRACT_ELEMENT__CARDINALITY:
        setCardinality(CARDINALITY_EDEFAULT);
        return;
      case XtextTestPackage.ABSTRACT_ELEMENT__PREDICATED:
        setPredicated(PREDICATED_EDEFAULT);
        return;
      case XtextTestPackage.ABSTRACT_ELEMENT__FIRST_SET_PREDICATED:
        setFirstSetPredicated(FIRST_SET_PREDICATED_EDEFAULT);
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
      case XtextTestPackage.ABSTRACT_ELEMENT__CARDINALITY:
        return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
      case XtextTestPackage.ABSTRACT_ELEMENT__PREDICATED:
        return predicated != PREDICATED_EDEFAULT;
      case XtextTestPackage.ABSTRACT_ELEMENT__FIRST_SET_PREDICATED:
        return firstSetPredicated != FIRST_SET_PREDICATED_EDEFAULT;
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
    result.append(" (cardinality: ");
    result.append(cardinality);
    result.append(", predicated: ");
    result.append(predicated);
    result.append(", firstSetPredicated: ");
    result.append(firstSetPredicated);
    result.append(')');
    return result.toString();
  }

} //AbstractElementImpl
