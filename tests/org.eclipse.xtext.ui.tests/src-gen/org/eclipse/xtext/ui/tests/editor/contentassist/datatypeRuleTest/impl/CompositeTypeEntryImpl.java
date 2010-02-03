/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Type Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeEntryImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeTypeEntryImpl extends MinimalEObjectImpl.Container implements CompositeTypeEntry
{
  /**
   * The cached value of the '{@link #getDataType() <em>Data Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataType()
   * @generated
   * @ordered
   */
  protected Type dataType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositeTypeEntryImpl()
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
    return DatatypeRuleTestPackage.Literals.COMPOSITE_TYPE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getDataType()
  {
    if (dataType != null && dataType.eIsProxy())
    {
      InternalEObject oldDataType = (InternalEObject)dataType;
      dataType = (Type)eResolveProxy(oldDataType);
      if (dataType != oldDataType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE, oldDataType, dataType));
      }
    }
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetDataType()
  {
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataType(Type newDataType)
  {
    Type oldDataType = dataType;
    dataType = newDataType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE, oldDataType, dataType));
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE:
        if (resolve) return getDataType();
        return basicGetDataType();
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE:
        setDataType((Type)newValue);
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE:
        setDataType((Type)null);
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY__DATA_TYPE:
        return dataType != null;
    }
    return super.eIsSet(featureID);
  }

} //CompositeTypeEntryImpl
