/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl#getPUBLIC <em>PUBLIC</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl#getPRIVATE <em>PRIVATE</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyAttributeImpl extends MinimalEObjectImpl.Container implements MyAttribute
{
  /**
   * The default value of the '{@link #getPUBLIC() <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPUBLIC()
   * @generated
   * @ordered
   */
  protected static final String PUBLIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPUBLIC() <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPUBLIC()
   * @generated
   * @ordered
   */
  protected String public_ = PUBLIC_EDEFAULT;

  /**
   * The default value of the '{@link #getPRIVATE() <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPRIVATE()
   * @generated
   * @ordered
   */
  protected static final String PRIVATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPRIVATE() <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPRIVATE()
   * @generated
   * @ordered
   */
  protected String private_ = PRIVATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyAttributeImpl()
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
    return Bug347012TestLanguagePackage.Literals.MY_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPUBLIC()
  {
    return public_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPUBLIC(String newPUBLIC)
  {
    String oldPUBLIC = public_;
    public_ = newPUBLIC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug347012TestLanguagePackage.MY_ATTRIBUTE__PUBLIC, oldPUBLIC, public_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPRIVATE()
  {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPRIVATE(String newPRIVATE)
  {
    String oldPRIVATE = private_;
    private_ = newPRIVATE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug347012TestLanguagePackage.MY_ATTRIBUTE__PRIVATE, oldPRIVATE, private_));
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
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PUBLIC:
        return getPUBLIC();
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PRIVATE:
        return getPRIVATE();
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
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PUBLIC:
        setPUBLIC((String)newValue);
        return;
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PRIVATE:
        setPRIVATE((String)newValue);
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
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PUBLIC:
        setPUBLIC(PUBLIC_EDEFAULT);
        return;
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PRIVATE:
        setPRIVATE(PRIVATE_EDEFAULT);
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
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PUBLIC:
        return PUBLIC_EDEFAULT == null ? public_ != null : !PUBLIC_EDEFAULT.equals(public_);
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE__PRIVATE:
        return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
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
    result.append(" (PUBLIC: ");
    result.append(public_);
    result.append(", PRIVATE: ");
    result.append(private_);
    result.append(')');
    return result.toString();
  }

} //MyAttributeImpl
