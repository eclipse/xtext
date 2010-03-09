/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl;

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

import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDefinitionImpl extends MinimalEObjectImpl.Container implements PackageDefinition
{
  /**
   * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected static final String NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected String namespace = NAMESPACE_EDEFAULT;

  /**
   * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContents()
   * @generated
   * @ordered
   */
  protected EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object> contents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageDefinitionImpl()
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
    return Bug304681TestLanguagePackage.Literals.PACKAGE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNamespace()
  {
    return namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamespace(String newNamespace)
  {
    String oldNamespace = namespace;
    namespace = newNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.PACKAGE_DEFINITION__NAMESPACE, oldNamespace, namespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object> getContents()
  {
    if (contents == null)
    {
      contents = new EObjectContainmentEList<org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object>(org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, this, Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS);
    }
    return contents;
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
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS:
        return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__NAMESPACE:
        return getNamespace();
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS:
        return getContents();
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
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__NAMESPACE:
        setNamespace((String)newValue);
        return;
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS:
        getContents().clear();
        getContents().addAll((Collection<? extends org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object>)newValue);
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
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__NAMESPACE:
        setNamespace(NAMESPACE_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS:
        getContents().clear();
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
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__NAMESPACE:
        return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
      case Bug304681TestLanguagePackage.PACKAGE_DEFINITION__CONTENTS:
        return contents != null && !contents.isEmpty();
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
    result.append(" (namespace: ");
    result.append(namespace);
    result.append(')');
    return result.toString();
  }

} //PackageDefinitionImpl
