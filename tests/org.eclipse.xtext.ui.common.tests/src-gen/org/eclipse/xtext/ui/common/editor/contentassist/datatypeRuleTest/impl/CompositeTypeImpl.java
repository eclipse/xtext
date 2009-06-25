/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.CompositeType;
import org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.CompositeTypeEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.impl.CompositeTypeImpl#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeTypeImpl extends TypeImpl implements CompositeType
{
  /**
   * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
  protected CompositeTypeEntry baseType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositeTypeImpl()
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
    return DatatypeRuleTestPackage.Literals.COMPOSITE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeTypeEntry getBaseType()
  {
    return baseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaseType(CompositeTypeEntry newBaseType, NotificationChain msgs)
  {
    CompositeTypeEntry oldBaseType = baseType;
    baseType = newBaseType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE, oldBaseType, newBaseType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaseType(CompositeTypeEntry newBaseType)
  {
    if (newBaseType != baseType)
    {
      NotificationChain msgs = null;
      if (baseType != null)
        msgs = ((InternalEObject)baseType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE, null, msgs);
      if (newBaseType != null)
        msgs = ((InternalEObject)newBaseType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE, null, msgs);
      msgs = basicSetBaseType(newBaseType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE, newBaseType, newBaseType));
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE:
        return basicSetBaseType(null, msgs);
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE:
        return getBaseType();
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE:
        setBaseType((CompositeTypeEntry)newValue);
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE:
        setBaseType((CompositeTypeEntry)null);
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
      case DatatypeRuleTestPackage.COMPOSITE_TYPE__BASE_TYPE:
        return baseType != null;
    }
    return super.eIsSet(featureID);
  }

} //CompositeTypeImpl
