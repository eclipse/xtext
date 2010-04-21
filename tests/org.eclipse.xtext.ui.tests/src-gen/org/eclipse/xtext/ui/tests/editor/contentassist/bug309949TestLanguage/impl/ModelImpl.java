/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getErrors() <em>Errors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrors()
   * @generated
   * @ordered
   */
  protected EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error> errors;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<Operation> operations;

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
  protected ModelImpl()
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
    return Bug309949TestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error> getErrors()
  {
    if (errors == null)
    {
      errors = new EObjectContainmentEList<org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error>(org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error.class, this, Bug309949TestLanguagePackage.MODEL__ERRORS);
    }
    return errors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, Bug309949TestLanguagePackage.MODEL__OPERATIONS);
    }
    return operations;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug309949TestLanguagePackage.MODEL__NAME, oldName, name));
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
      case Bug309949TestLanguagePackage.MODEL__ERRORS:
        return ((InternalEList<?>)getErrors()).basicRemove(otherEnd, msgs);
      case Bug309949TestLanguagePackage.MODEL__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
      case Bug309949TestLanguagePackage.MODEL__ERRORS:
        return getErrors();
      case Bug309949TestLanguagePackage.MODEL__OPERATIONS:
        return getOperations();
      case Bug309949TestLanguagePackage.MODEL__NAME:
        return getName();
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
      case Bug309949TestLanguagePackage.MODEL__ERRORS:
        getErrors().clear();
        getErrors().addAll((Collection<? extends org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error>)newValue);
        return;
      case Bug309949TestLanguagePackage.MODEL__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
        return;
      case Bug309949TestLanguagePackage.MODEL__NAME:
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
      case Bug309949TestLanguagePackage.MODEL__ERRORS:
        getErrors().clear();
        return;
      case Bug309949TestLanguagePackage.MODEL__OPERATIONS:
        getOperations().clear();
        return;
      case Bug309949TestLanguagePackage.MODEL__NAME:
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
      case Bug309949TestLanguagePackage.MODEL__ERRORS:
        return errors != null && !errors.isEmpty();
      case Bug309949TestLanguagePackage.MODEL__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case Bug309949TestLanguagePackage.MODEL__NAME:
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

} //ModelImpl
