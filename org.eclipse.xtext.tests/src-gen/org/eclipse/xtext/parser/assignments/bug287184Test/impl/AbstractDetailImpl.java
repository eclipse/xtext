/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail;
import org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage;
import org.eclipse.xtext.parser.assignments.bug287184Test.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Detail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.AbstractDetailImpl#getDetailClass <em>Detail Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractDetailImpl extends MinimalEObjectImpl.Container implements AbstractDetail
{
  /**
   * The cached value of the '{@link #getDetailClass() <em>Detail Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailClass()
   * @generated
   * @ordered
   */
  protected Model detailClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractDetailImpl()
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
    return Bug287184TestPackage.Literals.ABSTRACT_DETAIL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model getDetailClass()
  {
    if (detailClass != null && detailClass.eIsProxy())
    {
      InternalEObject oldDetailClass = (InternalEObject)detailClass;
      detailClass = (Model)eResolveProxy(oldDetailClass);
      if (detailClass != oldDetailClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS, oldDetailClass, detailClass));
      }
    }
    return detailClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model basicGetDetailClass()
  {
    return detailClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetailClass(Model newDetailClass)
  {
    Model oldDetailClass = detailClass;
    detailClass = newDetailClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS, oldDetailClass, detailClass));
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
      case Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS:
        if (resolve) return getDetailClass();
        return basicGetDetailClass();
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
      case Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS:
        setDetailClass((Model)newValue);
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
      case Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS:
        setDetailClass((Model)null);
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
      case Bug287184TestPackage.ABSTRACT_DETAIL__DETAIL_CLASS:
        return detailClass != null;
    }
    return super.eIsSet(featureID);
  }

} //AbstractDetailImpl
