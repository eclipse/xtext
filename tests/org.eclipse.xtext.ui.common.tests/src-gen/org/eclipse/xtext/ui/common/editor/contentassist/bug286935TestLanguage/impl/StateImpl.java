/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State;
import org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl#getStateKind <em>State Kind</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl#getStateName <em>State Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State
{
  /**
   * The default value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsInitial()
   * @generated
   * @ordered
   */
  protected static final boolean IS_INITIAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsInitial()
   * @generated
   * @ordered
   */
  protected boolean isInitial = IS_INITIAL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinal()
   * @generated
   * @ordered
   */
  protected static final boolean IS_FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinal()
   * @generated
   * @ordered
   */
  protected boolean isFinal = IS_FINAL_EDEFAULT;

  /**
   * The default value of the '{@link #getStateKind() <em>State Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateKind()
   * @generated
   * @ordered
   */
  protected static final StateType STATE_KIND_EDEFAULT = StateType.NORMAL;

  /**
   * The cached value of the '{@link #getStateKind() <em>State Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateKind()
   * @generated
   * @ordered
   */
  protected StateType stateKind = STATE_KIND_EDEFAULT;

  /**
   * The default value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected static final String STATE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected String stateName = STATE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateImpl()
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
    return Bug286935TestLanguagePackage.Literals.STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsInitial()
  {
    return isInitial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsInitial(boolean newIsInitial)
  {
    boolean oldIsInitial = isInitial;
    isInitial = newIsInitial;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug286935TestLanguagePackage.STATE__IS_INITIAL, oldIsInitial, isInitial));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsFinal()
  {
    return isFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsFinal(boolean newIsFinal)
  {
    boolean oldIsFinal = isFinal;
    isFinal = newIsFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug286935TestLanguagePackage.STATE__IS_FINAL, oldIsFinal, isFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateType getStateKind()
  {
    return stateKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateKind(StateType newStateKind)
  {
    StateType oldStateKind = stateKind;
    stateKind = newStateKind == null ? STATE_KIND_EDEFAULT : newStateKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug286935TestLanguagePackage.STATE__STATE_KIND, oldStateKind, stateKind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStateName()
  {
    return stateName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateName(String newStateName)
  {
    String oldStateName = stateName;
    stateName = newStateName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug286935TestLanguagePackage.STATE__STATE_NAME, oldStateName, stateName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLabel()
  {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(String newLabel)
  {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug286935TestLanguagePackage.STATE__LABEL, oldLabel, label));
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
      case Bug286935TestLanguagePackage.STATE__IS_INITIAL:
        return isIsInitial();
      case Bug286935TestLanguagePackage.STATE__IS_FINAL:
        return isIsFinal();
      case Bug286935TestLanguagePackage.STATE__STATE_KIND:
        return getStateKind();
      case Bug286935TestLanguagePackage.STATE__STATE_NAME:
        return getStateName();
      case Bug286935TestLanguagePackage.STATE__LABEL:
        return getLabel();
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
      case Bug286935TestLanguagePackage.STATE__IS_INITIAL:
        setIsInitial((Boolean)newValue);
        return;
      case Bug286935TestLanguagePackage.STATE__IS_FINAL:
        setIsFinal((Boolean)newValue);
        return;
      case Bug286935TestLanguagePackage.STATE__STATE_KIND:
        setStateKind((StateType)newValue);
        return;
      case Bug286935TestLanguagePackage.STATE__STATE_NAME:
        setStateName((String)newValue);
        return;
      case Bug286935TestLanguagePackage.STATE__LABEL:
        setLabel((String)newValue);
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
      case Bug286935TestLanguagePackage.STATE__IS_INITIAL:
        setIsInitial(IS_INITIAL_EDEFAULT);
        return;
      case Bug286935TestLanguagePackage.STATE__IS_FINAL:
        setIsFinal(IS_FINAL_EDEFAULT);
        return;
      case Bug286935TestLanguagePackage.STATE__STATE_KIND:
        setStateKind(STATE_KIND_EDEFAULT);
        return;
      case Bug286935TestLanguagePackage.STATE__STATE_NAME:
        setStateName(STATE_NAME_EDEFAULT);
        return;
      case Bug286935TestLanguagePackage.STATE__LABEL:
        setLabel(LABEL_EDEFAULT);
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
      case Bug286935TestLanguagePackage.STATE__IS_INITIAL:
        return isInitial != IS_INITIAL_EDEFAULT;
      case Bug286935TestLanguagePackage.STATE__IS_FINAL:
        return isFinal != IS_FINAL_EDEFAULT;
      case Bug286935TestLanguagePackage.STATE__STATE_KIND:
        return stateKind != STATE_KIND_EDEFAULT;
      case Bug286935TestLanguagePackage.STATE__STATE_NAME:
        return STATE_NAME_EDEFAULT == null ? stateName != null : !STATE_NAME_EDEFAULT.equals(stateName);
      case Bug286935TestLanguagePackage.STATE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
    result.append(" (isInitial: ");
    result.append(isInitial);
    result.append(", isFinal: ");
    result.append(isFinal);
    result.append(", stateKind: ");
    result.append(stateKind);
    result.append(", stateName: ");
    result.append(stateName);
    result.append(", label: ");
    result.append(label);
    result.append(')');
    return result.toString();
  }

} //StateImpl
