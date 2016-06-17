/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl#getRootDeclaration <em>Root Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnorderedImpl extends MinimalEObjectImpl.Container implements Unordered
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
   * The cached value of the '{@link #getRootDeclaration() <em>Root Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootDeclaration()
   * @generated
   * @ordered
   */
  protected SimpleClassDeclaration rootDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnorderedImpl()
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
    return Bug360834TestLanguagePackage.Literals.UNORDERED;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.UNORDERED__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleClassDeclaration getRootDeclaration()
  {
    return rootDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRootDeclaration(SimpleClassDeclaration newRootDeclaration, NotificationChain msgs)
  {
    SimpleClassDeclaration oldRootDeclaration = rootDeclaration;
    rootDeclaration = newRootDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION, oldRootDeclaration, newRootDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootDeclaration(SimpleClassDeclaration newRootDeclaration)
  {
    if (newRootDeclaration != rootDeclaration)
    {
      NotificationChain msgs = null;
      if (rootDeclaration != null)
        msgs = ((InternalEObject)rootDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION, null, msgs);
      if (newRootDeclaration != null)
        msgs = ((InternalEObject)newRootDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION, null, msgs);
      msgs = basicSetRootDeclaration(newRootDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION, newRootDeclaration, newRootDeclaration));
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
      case Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION:
        return basicSetRootDeclaration(null, msgs);
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
      case Bug360834TestLanguagePackage.UNORDERED__NAME:
        return getName();
      case Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION:
        return getRootDeclaration();
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
      case Bug360834TestLanguagePackage.UNORDERED__NAME:
        setName((String)newValue);
        return;
      case Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION:
        setRootDeclaration((SimpleClassDeclaration)newValue);
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
      case Bug360834TestLanguagePackage.UNORDERED__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION:
        setRootDeclaration((SimpleClassDeclaration)null);
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
      case Bug360834TestLanguagePackage.UNORDERED__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug360834TestLanguagePackage.UNORDERED__ROOT_DECLARATION:
        return rootDeclaration != null;
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

} //UnorderedImpl
