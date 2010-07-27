/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ProvidedCapability;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ProvidedCapabilityImpl#getNameSpace <em>Name Space</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ProvidedCapabilityImpl#getCondExpr <em>Cond Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ProvidedCapabilityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ProvidedCapabilityImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidedCapabilityImpl extends MinimalEObjectImpl.Container implements ProvidedCapability
{
  /**
   * The default value of the '{@link #getNameSpace() <em>Name Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameSpace()
   * @generated
   * @ordered
   */
  protected static final String NAME_SPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNameSpace() <em>Name Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameSpace()
   * @generated
   * @ordered
   */
  protected String nameSpace = NAME_SPACE_EDEFAULT;

  /**
   * The cached value of the '{@link #getCondExpr() <em>Cond Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondExpr()
   * @generated
   * @ordered
   */
  protected Expression condExpr;

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
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProvidedCapabilityImpl()
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
    return BacktrackingTestLanguagePackage.Literals.PROVIDED_CAPABILITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNameSpace()
  {
    return nameSpace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameSpace(String newNameSpace)
  {
    String oldNameSpace = nameSpace;
    nameSpace = newNameSpace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME_SPACE, oldNameSpace, nameSpace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCondExpr()
  {
    return condExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondExpr(Expression newCondExpr, NotificationChain msgs)
  {
    Expression oldCondExpr = condExpr;
    condExpr = newCondExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR, oldCondExpr, newCondExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondExpr(Expression newCondExpr)
  {
    if (newCondExpr != condExpr)
    {
      NotificationChain msgs = null;
      if (condExpr != null)
        msgs = ((InternalEObject)condExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR, null, msgs);
      if (newCondExpr != null)
        msgs = ((InternalEObject)newCondExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR, null, msgs);
      msgs = basicSetCondExpr(newCondExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR, newCondExpr, newCondExpr));
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
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__VERSION, oldVersion, version));
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
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR:
        return basicSetCondExpr(null, msgs);
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
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME_SPACE:
        return getNameSpace();
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR:
        return getCondExpr();
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME:
        return getName();
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__VERSION:
        return getVersion();
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
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME_SPACE:
        setNameSpace((String)newValue);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR:
        setCondExpr((Expression)newValue);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME:
        setName((String)newValue);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__VERSION:
        setVersion((String)newValue);
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
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME_SPACE:
        setNameSpace(NAME_SPACE_EDEFAULT);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR:
        setCondExpr((Expression)null);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__VERSION:
        setVersion(VERSION_EDEFAULT);
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
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME_SPACE:
        return NAME_SPACE_EDEFAULT == null ? nameSpace != null : !NAME_SPACE_EDEFAULT.equals(nameSpace);
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__COND_EXPR:
        return condExpr != null;
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
    result.append(" (nameSpace: ");
    result.append(nameSpace);
    result.append(", name: ");
    result.append(name);
    result.append(", version: ");
    result.append(version);
    result.append(')');
    return result.toString();
  }

} //ProvidedCapabilityImpl
