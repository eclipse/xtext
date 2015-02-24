/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ParameterImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends PropertyPathPartImpl implements Parameter
{
  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected TypeDescription description;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterImpl()
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
    return Bug332217TestLanguagePackage.Literals.PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDescription getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(TypeDescription newDescription, NotificationChain msgs)
  {
    TypeDescription oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(TypeDescription newDescription)
  {
    if (newDescription != description)
    {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION, newDescription, newDescription));
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
      case Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION:
        return basicSetDescription(null, msgs);
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
      case Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION:
        return getDescription();
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
      case Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION:
        setDescription((TypeDescription)newValue);
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
      case Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION:
        setDescription((TypeDescription)null);
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
      case Bug332217TestLanguagePackage.PARAMETER__DESCRIPTION:
        return description != null;
    }
    return super.eIsSet(featureID);
  }

} //ParameterImpl
