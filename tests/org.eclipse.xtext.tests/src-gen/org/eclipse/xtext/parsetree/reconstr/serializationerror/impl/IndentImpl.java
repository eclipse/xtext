/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl#getReq <em>Req</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl#getOpt <em>Opt</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndentImpl extends TestImpl implements Indent
{
  /**
   * The cached value of the '{@link #getReq() <em>Req</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReq()
   * @generated
   * @ordered
   */
  protected TwoRequired req;

  /**
   * The cached value of the '{@link #getOpt() <em>Opt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt()
   * @generated
   * @ordered
   */
  protected TwoOptions opt;

  /**
   * The cached value of the '{@link #getIndent() <em>Indent</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndent()
   * @generated
   * @ordered
   */
  protected EList<Indent> indent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndentImpl()
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
    return SerializationerrorPackage.Literals.INDENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoRequired getReq()
  {
    return req;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReq(TwoRequired newReq, NotificationChain msgs)
  {
    TwoRequired oldReq = req;
    req = newReq;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.INDENT__REQ, oldReq, newReq);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReq(TwoRequired newReq)
  {
    if (newReq != req)
    {
      NotificationChain msgs = null;
      if (req != null)
        msgs = ((InternalEObject)req).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationerrorPackage.INDENT__REQ, null, msgs);
      if (newReq != null)
        msgs = ((InternalEObject)newReq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationerrorPackage.INDENT__REQ, null, msgs);
      msgs = basicSetReq(newReq, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.INDENT__REQ, newReq, newReq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoOptions getOpt()
  {
    return opt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpt(TwoOptions newOpt, NotificationChain msgs)
  {
    TwoOptions oldOpt = opt;
    opt = newOpt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.INDENT__OPT, oldOpt, newOpt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpt(TwoOptions newOpt)
  {
    if (newOpt != opt)
    {
      NotificationChain msgs = null;
      if (opt != null)
        msgs = ((InternalEObject)opt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationerrorPackage.INDENT__OPT, null, msgs);
      if (newOpt != null)
        msgs = ((InternalEObject)newOpt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationerrorPackage.INDENT__OPT, null, msgs);
      msgs = basicSetOpt(newOpt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.INDENT__OPT, newOpt, newOpt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Indent> getIndent()
  {
    if (indent == null)
    {
      indent = new EObjectContainmentEList<Indent>(Indent.class, this, SerializationerrorPackage.INDENT__INDENT);
    }
    return indent;
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
      case SerializationerrorPackage.INDENT__REQ:
        return basicSetReq(null, msgs);
      case SerializationerrorPackage.INDENT__OPT:
        return basicSetOpt(null, msgs);
      case SerializationerrorPackage.INDENT__INDENT:
        return ((InternalEList<?>)getIndent()).basicRemove(otherEnd, msgs);
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
      case SerializationerrorPackage.INDENT__REQ:
        return getReq();
      case SerializationerrorPackage.INDENT__OPT:
        return getOpt();
      case SerializationerrorPackage.INDENT__INDENT:
        return getIndent();
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
      case SerializationerrorPackage.INDENT__REQ:
        setReq((TwoRequired)newValue);
        return;
      case SerializationerrorPackage.INDENT__OPT:
        setOpt((TwoOptions)newValue);
        return;
      case SerializationerrorPackage.INDENT__INDENT:
        getIndent().clear();
        getIndent().addAll((Collection<? extends Indent>)newValue);
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
      case SerializationerrorPackage.INDENT__REQ:
        setReq((TwoRequired)null);
        return;
      case SerializationerrorPackage.INDENT__OPT:
        setOpt((TwoOptions)null);
        return;
      case SerializationerrorPackage.INDENT__INDENT:
        getIndent().clear();
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
      case SerializationerrorPackage.INDENT__REQ:
        return req != null;
      case SerializationerrorPackage.INDENT__OPT:
        return opt != null;
      case SerializationerrorPackage.INDENT__INDENT:
        return indent != null && !indent.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IndentImpl
