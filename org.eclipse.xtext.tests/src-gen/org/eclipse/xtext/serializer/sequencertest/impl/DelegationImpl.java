/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.Delegation;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DelegationImpl#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DelegationImpl#getNp <em>Np</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelegationImpl extends MinimalEObjectImpl.Container implements Delegation
{
  /**
   * The default value of the '{@link #getP() <em>P</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getP()
   * @generated
   * @ordered
   */
  protected static final String P_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getP() <em>P</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getP()
   * @generated
   * @ordered
   */
  protected String p = P_EDEFAULT;

  /**
   * The default value of the '{@link #getNp() <em>Np</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNp()
   * @generated
   * @ordered
   */
  protected static final int NP_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNp() <em>Np</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNp()
   * @generated
   * @ordered
   */
  protected int np = NP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DelegationImpl()
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
    return SequencertestPackage.Literals.DELEGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getP()
  {
    return p;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setP(String newP)
  {
    String oldP = p;
    p = newP;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION__P, oldP, p));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNp()
  {
    return np;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNp(int newNp)
  {
    int oldNp = np;
    np = newNp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION__NP, oldNp, np));
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
      case SequencertestPackage.DELEGATION__P:
        return getP();
      case SequencertestPackage.DELEGATION__NP:
        return getNp();
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
      case SequencertestPackage.DELEGATION__P:
        setP((String)newValue);
        return;
      case SequencertestPackage.DELEGATION__NP:
        setNp((Integer)newValue);
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
      case SequencertestPackage.DELEGATION__P:
        setP(P_EDEFAULT);
        return;
      case SequencertestPackage.DELEGATION__NP:
        setNp(NP_EDEFAULT);
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
      case SequencertestPackage.DELEGATION__P:
        return P_EDEFAULT == null ? p != null : !P_EDEFAULT.equals(p);
      case SequencertestPackage.DELEGATION__NP:
        return np != NP_EDEFAULT;
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
    result.append(" (p: ");
    result.append(p);
    result.append(", np: ");
    result.append(np);
    result.append(')');
    return result.toString();
  }

} //DelegationImpl
