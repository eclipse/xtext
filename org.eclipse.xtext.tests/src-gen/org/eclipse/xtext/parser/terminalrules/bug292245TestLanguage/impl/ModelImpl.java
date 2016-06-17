/**
 */
package org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl#getFix <em>Fix</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl#getTick <em>Tick</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getFix() <em>Fix</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFix()
   * @generated
   * @ordered
   */
  protected EList<String> fix;

  /**
   * The cached value of the '{@link #getError() <em>Error</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getError()
   * @generated
   * @ordered
   */
  protected EList<String> error;

  /**
   * The cached value of the '{@link #getTick() <em>Tick</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTick()
   * @generated
   * @ordered
   */
  protected EList<String> tick;

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
    return Bug292245TestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFix()
  {
    if (fix == null)
    {
      fix = new EDataTypeEList<String>(String.class, this, Bug292245TestLanguagePackage.MODEL__FIX);
    }
    return fix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getError()
  {
    if (error == null)
    {
      error = new EDataTypeEList<String>(String.class, this, Bug292245TestLanguagePackage.MODEL__ERROR);
    }
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getTick()
  {
    if (tick == null)
    {
      tick = new EDataTypeEList<String>(String.class, this, Bug292245TestLanguagePackage.MODEL__TICK);
    }
    return tick;
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
      case Bug292245TestLanguagePackage.MODEL__FIX:
        return getFix();
      case Bug292245TestLanguagePackage.MODEL__ERROR:
        return getError();
      case Bug292245TestLanguagePackage.MODEL__TICK:
        return getTick();
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
      case Bug292245TestLanguagePackage.MODEL__FIX:
        getFix().clear();
        getFix().addAll((Collection<? extends String>)newValue);
        return;
      case Bug292245TestLanguagePackage.MODEL__ERROR:
        getError().clear();
        getError().addAll((Collection<? extends String>)newValue);
        return;
      case Bug292245TestLanguagePackage.MODEL__TICK:
        getTick().clear();
        getTick().addAll((Collection<? extends String>)newValue);
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
      case Bug292245TestLanguagePackage.MODEL__FIX:
        getFix().clear();
        return;
      case Bug292245TestLanguagePackage.MODEL__ERROR:
        getError().clear();
        return;
      case Bug292245TestLanguagePackage.MODEL__TICK:
        getTick().clear();
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
      case Bug292245TestLanguagePackage.MODEL__FIX:
        return fix != null && !fix.isEmpty();
      case Bug292245TestLanguagePackage.MODEL__ERROR:
        return error != null && !error.isEmpty();
      case Bug292245TestLanguagePackage.MODEL__TICK:
        return tick != null && !tick.isEmpty();
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
    result.append(" (fix: ");
    result.append(fix);
    result.append(", error: ");
    result.append(error);
    result.append(", tick: ");
    result.append(tick);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
