/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependent Alternative2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DependentAlternative2Impl#getVal <em>Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DependentAlternative2Impl#isFlag <em>Flag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependentAlternative2Impl extends MinimalEObjectImpl.Container implements DependentAlternative2
{
  /**
   * The cached value of the '{@link #getVal() <em>Val</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected EList<String> val;

  /**
   * The default value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected static final boolean FLAG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected boolean flag = FLAG_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DependentAlternative2Impl()
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
    return SequencertestPackage.Literals.DEPENDENT_ALTERNATIVE2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal()
  {
    if (val == null)
    {
      val = new EDataTypeEList<String>(String.class, this, SequencertestPackage.DEPENDENT_ALTERNATIVE2__VAL);
    }
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFlag()
  {
    return flag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFlag(boolean newFlag)
  {
    boolean oldFlag = flag;
    flag = newFlag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DEPENDENT_ALTERNATIVE2__FLAG, oldFlag, flag));
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__VAL:
        return getVal();
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__FLAG:
        return isFlag();
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__VAL:
        getVal().clear();
        getVal().addAll((Collection<? extends String>)newValue);
        return;
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__FLAG:
        setFlag((Boolean)newValue);
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__VAL:
        getVal().clear();
        return;
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__FLAG:
        setFlag(FLAG_EDEFAULT);
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__VAL:
        return val != null && !val.isEmpty();
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2__FLAG:
        return flag != FLAG_EDEFAULT;
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
    result.append(" (val: ");
    result.append(val);
    result.append(", flag: ");
    result.append(flag);
    result.append(')');
    return result.toString();
  }

} //DependentAlternative2Impl
