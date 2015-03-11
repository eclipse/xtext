/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timeperiod</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeperiodImpl extends MinimalEObjectImpl.Container implements Timeperiod
{
  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected EList<TimeDef> time;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected EList<String> name;

  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected EList<String> alias;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeperiodImpl()
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
    return Bug348199TestLanguagePackage.Literals.TIMEPERIOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TimeDef> getTime()
  {
    if (time == null)
    {
      time = new EObjectContainmentEList<TimeDef>(TimeDef.class, this, Bug348199TestLanguagePackage.TIMEPERIOD__TIME);
    }
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getName()
  {
    if (name == null)
    {
      name = new EDataTypeEList<String>(String.class, this, Bug348199TestLanguagePackage.TIMEPERIOD__NAME);
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAlias()
  {
    if (alias == null)
    {
      alias = new EDataTypeEList<String>(String.class, this, Bug348199TestLanguagePackage.TIMEPERIOD__ALIAS);
    }
    return alias;
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
      case Bug348199TestLanguagePackage.TIMEPERIOD__TIME:
        return ((InternalEList<?>)getTime()).basicRemove(otherEnd, msgs);
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
      case Bug348199TestLanguagePackage.TIMEPERIOD__TIME:
        return getTime();
      case Bug348199TestLanguagePackage.TIMEPERIOD__NAME:
        return getName();
      case Bug348199TestLanguagePackage.TIMEPERIOD__ALIAS:
        return getAlias();
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
      case Bug348199TestLanguagePackage.TIMEPERIOD__TIME:
        getTime().clear();
        getTime().addAll((Collection<? extends TimeDef>)newValue);
        return;
      case Bug348199TestLanguagePackage.TIMEPERIOD__NAME:
        getName().clear();
        getName().addAll((Collection<? extends String>)newValue);
        return;
      case Bug348199TestLanguagePackage.TIMEPERIOD__ALIAS:
        getAlias().clear();
        getAlias().addAll((Collection<? extends String>)newValue);
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
      case Bug348199TestLanguagePackage.TIMEPERIOD__TIME:
        getTime().clear();
        return;
      case Bug348199TestLanguagePackage.TIMEPERIOD__NAME:
        getName().clear();
        return;
      case Bug348199TestLanguagePackage.TIMEPERIOD__ALIAS:
        getAlias().clear();
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
      case Bug348199TestLanguagePackage.TIMEPERIOD__TIME:
        return time != null && !time.isEmpty();
      case Bug348199TestLanguagePackage.TIMEPERIOD__NAME:
        return name != null && !name.isEmpty();
      case Bug348199TestLanguagePackage.TIMEPERIOD__ALIAS:
        return alias != null && !alias.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", alias: ");
    result.append(alias);
    result.append(')');
    return result.toString();
  }

} //TimeperiodImpl
