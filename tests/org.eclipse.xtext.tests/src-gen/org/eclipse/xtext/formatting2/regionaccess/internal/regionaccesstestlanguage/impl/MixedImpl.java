/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl#getEobj <em>Eobj</em>}</li>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl#getLit <em>Lit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MixedImpl extends RootImpl implements Mixed
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
   * The cached value of the '{@link #getEobj() <em>Eobj</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEobj()
   * @generated
   * @ordered
   */
  protected Mixed eobj;

  /**
   * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatype()
   * @generated
   * @ordered
   */
  protected static final String DATATYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatype()
   * @generated
   * @ordered
   */
  protected String datatype = DATATYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Mixed ref;

  /**
   * The default value of the '{@link #getLit() <em>Lit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLit()
   * @generated
   * @ordered
   */
  protected static final org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum LIT_EDEFAULT = org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum.LIT1;

  /**
   * The cached value of the '{@link #getLit() <em>Lit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLit()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum lit = LIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MixedImpl()
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
    return RegionaccesstestlanguagePackage.Literals.MIXED;
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
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed getEobj()
  {
    return eobj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEobj(Mixed newEobj, NotificationChain msgs)
  {
    Mixed oldEobj = eobj;
    eobj = newEobj;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__EOBJ, oldEobj, newEobj);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEobj(Mixed newEobj)
  {
    if (newEobj != eobj)
    {
      NotificationChain msgs = null;
      if (eobj != null)
        msgs = ((InternalEObject)eobj).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.MIXED__EOBJ, null, msgs);
      if (newEobj != null)
        msgs = ((InternalEObject)newEobj).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.MIXED__EOBJ, null, msgs);
      msgs = basicSetEobj(newEobj, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__EOBJ, newEobj, newEobj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDatatype()
  {
    return datatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDatatype(String newDatatype)
  {
    String oldDatatype = datatype;
    datatype = newDatatype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__DATATYPE, oldDatatype, datatype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Mixed)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionaccesstestlanguagePackage.MIXED__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Mixed newRef)
  {
    Mixed oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum getLit()
  {
    return lit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLit(org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum newLit)
  {
    org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum oldLit = lit;
    lit = newLit == null ? LIT_EDEFAULT : newLit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.MIXED__LIT, oldLit, lit));
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
      case RegionaccesstestlanguagePackage.MIXED__EOBJ:
        return basicSetEobj(null, msgs);
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
      case RegionaccesstestlanguagePackage.MIXED__NAME:
        return getName();
      case RegionaccesstestlanguagePackage.MIXED__EOBJ:
        return getEobj();
      case RegionaccesstestlanguagePackage.MIXED__DATATYPE:
        return getDatatype();
      case RegionaccesstestlanguagePackage.MIXED__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case RegionaccesstestlanguagePackage.MIXED__LIT:
        return getLit();
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
      case RegionaccesstestlanguagePackage.MIXED__NAME:
        setName((String)newValue);
        return;
      case RegionaccesstestlanguagePackage.MIXED__EOBJ:
        setEobj((Mixed)newValue);
        return;
      case RegionaccesstestlanguagePackage.MIXED__DATATYPE:
        setDatatype((String)newValue);
        return;
      case RegionaccesstestlanguagePackage.MIXED__REF:
        setRef((Mixed)newValue);
        return;
      case RegionaccesstestlanguagePackage.MIXED__LIT:
        setLit((org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum)newValue);
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
      case RegionaccesstestlanguagePackage.MIXED__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RegionaccesstestlanguagePackage.MIXED__EOBJ:
        setEobj((Mixed)null);
        return;
      case RegionaccesstestlanguagePackage.MIXED__DATATYPE:
        setDatatype(DATATYPE_EDEFAULT);
        return;
      case RegionaccesstestlanguagePackage.MIXED__REF:
        setRef((Mixed)null);
        return;
      case RegionaccesstestlanguagePackage.MIXED__LIT:
        setLit(LIT_EDEFAULT);
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
      case RegionaccesstestlanguagePackage.MIXED__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RegionaccesstestlanguagePackage.MIXED__EOBJ:
        return eobj != null;
      case RegionaccesstestlanguagePackage.MIXED__DATATYPE:
        return DATATYPE_EDEFAULT == null ? datatype != null : !DATATYPE_EDEFAULT.equals(datatype);
      case RegionaccesstestlanguagePackage.MIXED__REF:
        return ref != null;
      case RegionaccesstestlanguagePackage.MIXED__LIT:
        return lit != LIT_EDEFAULT;
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
    result.append(", datatype: ");
    result.append(datatype);
    result.append(", lit: ");
    result.append(lit);
    result.append(')');
    return result.toString();
  }

} //MixedImpl
