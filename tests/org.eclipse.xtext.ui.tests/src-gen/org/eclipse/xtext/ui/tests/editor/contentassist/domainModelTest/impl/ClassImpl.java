/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.impl.ClassImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.impl.ClassImpl#getSubClasses <em>Sub Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends TypeImpl implements org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class
{
  /**
   * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperClass()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class superClass;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Property> properties;

  /**
   * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubClasses()
   * @generated
   * @ordered
   */
  protected EList<org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class> subClasses;

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
    return DomainModelTestPackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class getSuperClass()
  {
    if (superClass != null && superClass.eIsProxy())
    {
      InternalEObject oldSuperClass = (InternalEObject)superClass;
      superClass = (org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class)eResolveProxy(oldSuperClass);
      if (superClass != oldSuperClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainModelTestPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
      }
    }
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class basicGetSuperClass()
  {
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperClass(org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class newSuperClass)
  {
    org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class oldSuperClass = superClass;
    superClass = newSuperClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainModelTestPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Property> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<Property>(Property.class, this, DomainModelTestPackage.CLASS__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class> getSubClasses()
  {
    if (subClasses == null)
    {
      subClasses = new EObjectContainmentEList<org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class>(org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class.class, this, DomainModelTestPackage.CLASS__SUB_CLASSES);
    }
    return subClasses;
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
      case DomainModelTestPackage.CLASS__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case DomainModelTestPackage.CLASS__SUB_CLASSES:
        return ((InternalEList<?>)getSubClasses()).basicRemove(otherEnd, msgs);
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
      case DomainModelTestPackage.CLASS__SUPER_CLASS:
        if (resolve) return getSuperClass();
        return basicGetSuperClass();
      case DomainModelTestPackage.CLASS__PROPERTIES:
        return getProperties();
      case DomainModelTestPackage.CLASS__SUB_CLASSES:
        return getSubClasses();
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
      case DomainModelTestPackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class)newValue);
        return;
      case DomainModelTestPackage.CLASS__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Property>)newValue);
        return;
      case DomainModelTestPackage.CLASS__SUB_CLASSES:
        getSubClasses().clear();
        getSubClasses().addAll((Collection<? extends org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class>)newValue);
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
      case DomainModelTestPackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class)null);
        return;
      case DomainModelTestPackage.CLASS__PROPERTIES:
        getProperties().clear();
        return;
      case DomainModelTestPackage.CLASS__SUB_CLASSES:
        getSubClasses().clear();
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
      case DomainModelTestPackage.CLASS__SUPER_CLASS:
        return superClass != null;
      case DomainModelTestPackage.CLASS__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case DomainModelTestPackage.CLASS__SUB_CLASSES:
        return subClasses != null && !subClasses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClassImpl
