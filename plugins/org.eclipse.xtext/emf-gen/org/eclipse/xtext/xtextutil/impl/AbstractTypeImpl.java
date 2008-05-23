/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractTypeImpl.java,v 1.10 2008/05/23 08:22:20 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextutil.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.xtextutil.AbstractType;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl#getEClassifier <em>EClassifier</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractTypeImpl extends EObjectImpl implements AbstractType
{
  /**
   * The cached value of the '{@link #getEClassifier() <em>EClassifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEClassifier()
   * @generated
   * @ordered
   */
  protected EClassifier eClassifier;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractTypeImpl()
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
    return XtextutilPackage.Literals.ABSTRACT_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getEClassifier()
  {
    if (eClassifier != null && eClassifier.eIsProxy())
    {
      InternalEObject oldEClassifier = (InternalEObject)eClassifier;
      eClassifier = (EClassifier)eResolveProxy(oldEClassifier);
      if (eClassifier != oldEClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER, oldEClassifier, eClassifier));
      }
    }
    return eClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetEClassifier()
  {
    return eClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEClassifier(EClassifier newEClassifier)
  {
    EClassifier oldEClassifier = eClassifier;
    eClassifier = newEClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER, oldEClassifier, eClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.ABSTRACT_TYPE__NAME, oldName, name));
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
      case XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER:
        if (resolve) return getEClassifier();
        return basicGetEClassifier();
      case XtextutilPackage.ABSTRACT_TYPE__NAME:
        return getName();
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
      case XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)newValue);
        return;
      case XtextutilPackage.ABSTRACT_TYPE__NAME:
        setName((String)newValue);
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
      case XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)null);
        return;
      case XtextutilPackage.ABSTRACT_TYPE__NAME:
        setName(NAME_EDEFAULT);
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
      case XtextutilPackage.ABSTRACT_TYPE__ECLASSIFIER:
        return eClassifier != null;
      case XtextutilPackage.ABSTRACT_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(')');
    return result.toString();
  }

} //AbstractTypeImpl
