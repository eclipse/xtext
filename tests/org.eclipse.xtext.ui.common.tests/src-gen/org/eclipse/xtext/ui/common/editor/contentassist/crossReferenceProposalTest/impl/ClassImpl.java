/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.impl.ClassImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends MinimalEObjectImpl.Container implements org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class
{
  /**
   * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperClass()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class superClass;

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
  protected ClassImpl()
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
    return CrossReferenceProposalTestPackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class getSuperClass()
  {
    if (superClass != null && superClass.eIsProxy())
    {
      InternalEObject oldSuperClass = (InternalEObject)superClass;
      superClass = (org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class)eResolveProxy(oldSuperClass);
      if (superClass != oldSuperClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
      }
    }
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class basicGetSuperClass()
  {
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperClass(org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class newSuperClass)
  {
    org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class oldSuperClass = superClass;
    superClass = newSuperClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CrossReferenceProposalTestPackage.CLASS__NAME, oldName, name));
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
      case CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS:
        if (resolve) return getSuperClass();
        return basicGetSuperClass();
      case CrossReferenceProposalTestPackage.CLASS__NAME:
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
      case CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class)newValue);
        return;
      case CrossReferenceProposalTestPackage.CLASS__NAME:
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
      case CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class)null);
        return;
      case CrossReferenceProposalTestPackage.CLASS__NAME:
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
      case CrossReferenceProposalTestPackage.CLASS__SUPER_CLASS:
        return superClass != null;
      case CrossReferenceProposalTestPackage.CLASS__NAME:
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

} //ClassImpl
