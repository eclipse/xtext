/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.impl;

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

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XClass;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XClassImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XClassImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XClassImpl#getTypeParams <em>Type Params</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XClassImpl extends MinimalEObjectImpl.Container implements XClass
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
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected JvmTypeReference extends_;

  /**
   * The cached value of the '{@link #getImplements() <em>Implements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplements()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeReference> implements_;

  /**
   * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctions()
   * @generated
   * @ordered
   */
  protected EList<XFunction> functions;

  /**
   * The cached value of the '{@link #getTypeParams() <em>Type Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParams()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeParameter> typeParams;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XClassImpl()
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
    return XbasePackage.Literals.XCLASS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLASS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtends(JvmTypeReference newExtends, NotificationChain msgs)
  {
    JvmTypeReference oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCLASS__EXTENDS, oldExtends, newExtends);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(JvmTypeReference newExtends)
  {
    if (newExtends != extends_)
    {
      NotificationChain msgs = null;
      if (extends_ != null)
        msgs = ((InternalEObject)extends_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLASS__EXTENDS, null, msgs);
      if (newExtends != null)
        msgs = ((InternalEObject)newExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLASS__EXTENDS, null, msgs);
      msgs = basicSetExtends(newExtends, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLASS__EXTENDS, newExtends, newExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmTypeReference> getImplements()
  {
    if (implements_ == null)
    {
      implements_ = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XbasePackage.XCLASS__IMPLEMENTS);
    }
    return implements_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XFunction> getFunctions()
  {
    if (functions == null)
    {
      functions = new EObjectContainmentEList<XFunction>(XFunction.class, this, XbasePackage.XCLASS__FUNCTIONS);
    }
    return functions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmTypeParameter> getTypeParams()
  {
    if (typeParams == null)
    {
      typeParams = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, XbasePackage.XCLASS__TYPE_PARAMS);
    }
    return typeParams;
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
      case XbasePackage.XCLASS__EXTENDS:
        return basicSetExtends(null, msgs);
      case XbasePackage.XCLASS__IMPLEMENTS:
        return ((InternalEList<?>)getImplements()).basicRemove(otherEnd, msgs);
      case XbasePackage.XCLASS__FUNCTIONS:
        return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
      case XbasePackage.XCLASS__TYPE_PARAMS:
        return ((InternalEList<?>)getTypeParams()).basicRemove(otherEnd, msgs);
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
      case XbasePackage.XCLASS__NAME:
        return getName();
      case XbasePackage.XCLASS__EXTENDS:
        return getExtends();
      case XbasePackage.XCLASS__IMPLEMENTS:
        return getImplements();
      case XbasePackage.XCLASS__FUNCTIONS:
        return getFunctions();
      case XbasePackage.XCLASS__TYPE_PARAMS:
        return getTypeParams();
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
      case XbasePackage.XCLASS__NAME:
        setName((String)newValue);
        return;
      case XbasePackage.XCLASS__EXTENDS:
        setExtends((JvmTypeReference)newValue);
        return;
      case XbasePackage.XCLASS__IMPLEMENTS:
        getImplements().clear();
        getImplements().addAll((Collection<? extends JvmTypeReference>)newValue);
        return;
      case XbasePackage.XCLASS__FUNCTIONS:
        getFunctions().clear();
        getFunctions().addAll((Collection<? extends XFunction>)newValue);
        return;
      case XbasePackage.XCLASS__TYPE_PARAMS:
        getTypeParams().clear();
        getTypeParams().addAll((Collection<? extends JvmTypeParameter>)newValue);
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
      case XbasePackage.XCLASS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XbasePackage.XCLASS__EXTENDS:
        setExtends((JvmTypeReference)null);
        return;
      case XbasePackage.XCLASS__IMPLEMENTS:
        getImplements().clear();
        return;
      case XbasePackage.XCLASS__FUNCTIONS:
        getFunctions().clear();
        return;
      case XbasePackage.XCLASS__TYPE_PARAMS:
        getTypeParams().clear();
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
      case XbasePackage.XCLASS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XbasePackage.XCLASS__EXTENDS:
        return extends_ != null;
      case XbasePackage.XCLASS__IMPLEMENTS:
        return implements_ != null && !implements_.isEmpty();
      case XbasePackage.XCLASS__FUNCTIONS:
        return functions != null && !functions.isEmpty();
      case XbasePackage.XCLASS__TYPE_PARAMS:
        return typeParams != null && !typeParams.isEmpty();
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

} //XClassImpl
