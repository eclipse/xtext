/**
 */
package org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl#getIntValues <em>Int Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl#getDoubleValues <em>Double Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl#getDateValues <em>Date Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getIntValues() <em>Int Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValues()
   * @generated
   * @ordered
   */
  protected EList<Integer> intValues;

  /**
   * The cached value of the '{@link #getDoubleValues() <em>Double Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoubleValues()
   * @generated
   * @ordered
   */
  protected EList<Double> doubleValues;

  /**
   * The cached value of the '{@link #getDateValues() <em>Date Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateValues()
   * @generated
   * @ordered
   */
  protected EList<Date> dateValues;

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
    return EcoreTerminalsTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getIntValues()
  {
    if (intValues == null)
    {
      intValues = new EDataTypeEList<Integer>(Integer.class, this, EcoreTerminalsTestLanguagePackage.MODEL__INT_VALUES);
    }
    return intValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Double> getDoubleValues()
  {
    if (doubleValues == null)
    {
      doubleValues = new EDataTypeEList<Double>(Double.class, this, EcoreTerminalsTestLanguagePackage.MODEL__DOUBLE_VALUES);
    }
    return doubleValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Date> getDateValues()
  {
    if (dateValues == null)
    {
      dateValues = new EDataTypeEList<Date>(Date.class, this, EcoreTerminalsTestLanguagePackage.MODEL__DATE_VALUES);
    }
    return dateValues;
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
      case EcoreTerminalsTestLanguagePackage.MODEL__INT_VALUES:
        return getIntValues();
      case EcoreTerminalsTestLanguagePackage.MODEL__DOUBLE_VALUES:
        return getDoubleValues();
      case EcoreTerminalsTestLanguagePackage.MODEL__DATE_VALUES:
        return getDateValues();
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
      case EcoreTerminalsTestLanguagePackage.MODEL__INT_VALUES:
        getIntValues().clear();
        getIntValues().addAll((Collection<? extends Integer>)newValue);
        return;
      case EcoreTerminalsTestLanguagePackage.MODEL__DOUBLE_VALUES:
        getDoubleValues().clear();
        getDoubleValues().addAll((Collection<? extends Double>)newValue);
        return;
      case EcoreTerminalsTestLanguagePackage.MODEL__DATE_VALUES:
        getDateValues().clear();
        getDateValues().addAll((Collection<? extends Date>)newValue);
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
      case EcoreTerminalsTestLanguagePackage.MODEL__INT_VALUES:
        getIntValues().clear();
        return;
      case EcoreTerminalsTestLanguagePackage.MODEL__DOUBLE_VALUES:
        getDoubleValues().clear();
        return;
      case EcoreTerminalsTestLanguagePackage.MODEL__DATE_VALUES:
        getDateValues().clear();
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
      case EcoreTerminalsTestLanguagePackage.MODEL__INT_VALUES:
        return intValues != null && !intValues.isEmpty();
      case EcoreTerminalsTestLanguagePackage.MODEL__DOUBLE_VALUES:
        return doubleValues != null && !doubleValues.isEmpty();
      case EcoreTerminalsTestLanguagePackage.MODEL__DATE_VALUES:
        return dateValues != null && !dateValues.isEmpty();
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
    result.append(" (intValues: ");
    result.append(intValues);
    result.append(", doubleValues: ");
    result.append(doubleValues);
    result.append(", dateValues: ");
    result.append(dateValues);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
