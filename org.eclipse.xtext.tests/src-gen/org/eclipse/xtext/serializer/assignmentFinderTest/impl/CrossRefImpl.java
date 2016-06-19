/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cross Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl#getCrossRef <em>Cross Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CrossRefImpl extends MinimalEObjectImpl.Container implements CrossRef
{
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
   * The cached value of the '{@link #getCrossRef() <em>Cross Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCrossRef()
   * @generated
   * @ordered
   */
  protected CrossRef crossRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CrossRefImpl()
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
    return AssignmentFinderTestPackage.Literals.CROSS_REF;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.CROSS_REF__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRef getCrossRef()
  {
    if (crossRef != null && crossRef.eIsProxy())
    {
      InternalEObject oldCrossRef = (InternalEObject)crossRef;
      crossRef = (CrossRef)eResolveProxy(oldCrossRef);
      if (crossRef != oldCrossRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssignmentFinderTestPackage.CROSS_REF__CROSS_REF, oldCrossRef, crossRef));
      }
    }
    return crossRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRef basicGetCrossRef()
  {
    return crossRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCrossRef(CrossRef newCrossRef)
  {
    CrossRef oldCrossRef = crossRef;
    crossRef = newCrossRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.CROSS_REF__CROSS_REF, oldCrossRef, crossRef));
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
      case AssignmentFinderTestPackage.CROSS_REF__NAME:
        return getName();
      case AssignmentFinderTestPackage.CROSS_REF__CROSS_REF:
        if (resolve) return getCrossRef();
        return basicGetCrossRef();
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
      case AssignmentFinderTestPackage.CROSS_REF__NAME:
        setName((String)newValue);
        return;
      case AssignmentFinderTestPackage.CROSS_REF__CROSS_REF:
        setCrossRef((CrossRef)newValue);
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
      case AssignmentFinderTestPackage.CROSS_REF__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssignmentFinderTestPackage.CROSS_REF__CROSS_REF:
        setCrossRef((CrossRef)null);
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
      case AssignmentFinderTestPackage.CROSS_REF__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssignmentFinderTestPackage.CROSS_REF__CROSS_REF:
        return crossRef != null;
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

} //CrossRefImpl
