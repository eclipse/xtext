/**
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl#getVector <em>Vector</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl#getDots <em>Dots</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl#getDouble <em>Double</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final BigDecimal VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected BigDecimal value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVector()
   * @generated
   * @ordered
   */
  protected static final String VECTOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVector()
   * @generated
   * @ordered
   */
  protected String vector = VECTOR_EDEFAULT;

  /**
   * The default value of the '{@link #getDots() <em>Dots</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDots()
   * @generated
   * @ordered
   */
  protected static final String DOTS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDots() <em>Dots</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDots()
   * @generated
   * @ordered
   */
  protected String dots = DOTS_EDEFAULT;

  /**
   * The default value of the '{@link #getDouble() <em>Double</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble()
   * @generated
   * @ordered
   */
  protected static final double DOUBLE_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getDouble() <em>Double</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble()
   * @generated
   * @ordered
   */
  protected double double_ = DOUBLE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return DatatypeRulesTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRulesTestLanguagePackage.MODEL__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(BigDecimal newValue)
  {
    BigDecimal oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRulesTestLanguagePackage.MODEL__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVector()
  {
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVector(String newVector)
  {
    String oldVector = vector;
    vector = newVector;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRulesTestLanguagePackage.MODEL__VECTOR, oldVector, vector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDots()
  {
    return dots;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDots(String newDots)
  {
    String oldDots = dots;
    dots = newDots;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRulesTestLanguagePackage.MODEL__DOTS, oldDots, dots));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getDouble()
  {
    return double_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDouble(double newDouble)
  {
    double oldDouble = double_;
    double_ = newDouble;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRulesTestLanguagePackage.MODEL__DOUBLE, oldDouble, double_));
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
      case DatatypeRulesTestLanguagePackage.MODEL__ID:
        return getId();
      case DatatypeRulesTestLanguagePackage.MODEL__VALUE:
        return getValue();
      case DatatypeRulesTestLanguagePackage.MODEL__VECTOR:
        return getVector();
      case DatatypeRulesTestLanguagePackage.MODEL__DOTS:
        return getDots();
      case DatatypeRulesTestLanguagePackage.MODEL__DOUBLE:
        return getDouble();
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
      case DatatypeRulesTestLanguagePackage.MODEL__ID:
        setId((String)newValue);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__VALUE:
        setValue((BigDecimal)newValue);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__VECTOR:
        setVector((String)newValue);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__DOTS:
        setDots((String)newValue);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__DOUBLE:
        setDouble((Double)newValue);
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
      case DatatypeRulesTestLanguagePackage.MODEL__ID:
        setId(ID_EDEFAULT);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__VECTOR:
        setVector(VECTOR_EDEFAULT);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__DOTS:
        setDots(DOTS_EDEFAULT);
        return;
      case DatatypeRulesTestLanguagePackage.MODEL__DOUBLE:
        setDouble(DOUBLE_EDEFAULT);
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
      case DatatypeRulesTestLanguagePackage.MODEL__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case DatatypeRulesTestLanguagePackage.MODEL__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case DatatypeRulesTestLanguagePackage.MODEL__VECTOR:
        return VECTOR_EDEFAULT == null ? vector != null : !VECTOR_EDEFAULT.equals(vector);
      case DatatypeRulesTestLanguagePackage.MODEL__DOTS:
        return DOTS_EDEFAULT == null ? dots != null : !DOTS_EDEFAULT.equals(dots);
      case DatatypeRulesTestLanguagePackage.MODEL__DOUBLE:
        return double_ != DOUBLE_EDEFAULT;
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
    result.append(" (id: ");
    result.append(id);
    result.append(", value: ");
    result.append(value);
    result.append(", vector: ");
    result.append(vector);
    result.append(", dots: ");
    result.append(dots);
    result.append(", double: ");
    result.append(double_);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
