/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl;

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

import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recursive Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecursiveClassDeclarationImpl extends MinimalEObjectImpl.Container implements RecursiveClassDeclaration
{
  /**
   * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifiers()
   * @generated
   * @ordered
   */
  protected Modifiers modifiers;

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
   * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMembers()
   * @generated
   * @ordered
   */
  protected EList<RecursiveClassDeclaration> members;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecursiveClassDeclarationImpl()
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
    return Bug360834TestLanguagePackage.Literals.RECURSIVE_CLASS_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modifiers getModifiers()
  {
    return modifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModifiers(Modifiers newModifiers, NotificationChain msgs)
  {
    Modifiers oldModifiers = modifiers;
    modifiers = newModifiers;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS, oldModifiers, newModifiers);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifiers(Modifiers newModifiers)
  {
    if (newModifiers != modifiers)
    {
      NotificationChain msgs = null;
      if (modifiers != null)
        msgs = ((InternalEObject)modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS, null, msgs);
      if (newModifiers != null)
        msgs = ((InternalEObject)newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS, null, msgs);
      msgs = basicSetModifiers(newModifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS, newModifiers, newModifiers));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RecursiveClassDeclaration> getMembers()
  {
    if (members == null)
    {
      members = new EObjectContainmentEList<RecursiveClassDeclaration>(RecursiveClassDeclaration.class, this, Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS);
    }
    return members;
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
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS:
        return basicSetModifiers(null, msgs);
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS:
        return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS:
        return getModifiers();
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__NAME:
        return getName();
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS:
        return getMembers();
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
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS:
        setModifiers((Modifiers)newValue);
        return;
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS:
        getMembers().clear();
        getMembers().addAll((Collection<? extends RecursiveClassDeclaration>)newValue);
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
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS:
        setModifiers((Modifiers)null);
        return;
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS:
        getMembers().clear();
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
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MODIFIERS:
        return modifiers != null;
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug360834TestLanguagePackage.RECURSIVE_CLASS_DECLARATION__MEMBERS:
        return members != null && !members.isEmpty();
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

} //RecursiveClassDeclarationImpl
