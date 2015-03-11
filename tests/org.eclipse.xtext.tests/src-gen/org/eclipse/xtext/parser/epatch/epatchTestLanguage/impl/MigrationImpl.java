/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl#getAsOp <em>As Op</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl#getEachOp <em>Each Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MigrationImpl extends MinimalEObjectImpl.Container implements Migration
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected Executable first;

  /**
   * The cached value of the '{@link #getAsOp() <em>As Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsOp()
   * @generated
   * @ordered
   */
  protected Executable asOp;

  /**
   * The cached value of the '{@link #getEachOp() <em>Each Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEachOp()
   * @generated
   * @ordered
   */
  protected Executable eachOp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MigrationImpl()
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
    return EpatchTestLanguagePackage.Literals.MIGRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Executable getFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirst(Executable newFirst, NotificationChain msgs)
  {
    Executable oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__FIRST, oldFirst, newFirst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(Executable newFirst)
  {
    if (newFirst != first)
    {
      NotificationChain msgs = null;
      if (first != null)
        msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__FIRST, null, msgs);
      if (newFirst != null)
        msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__FIRST, null, msgs);
      msgs = basicSetFirst(newFirst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__FIRST, newFirst, newFirst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Executable getAsOp()
  {
    return asOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAsOp(Executable newAsOp, NotificationChain msgs)
  {
    Executable oldAsOp = asOp;
    asOp = newAsOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__AS_OP, oldAsOp, newAsOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsOp(Executable newAsOp)
  {
    if (newAsOp != asOp)
    {
      NotificationChain msgs = null;
      if (asOp != null)
        msgs = ((InternalEObject)asOp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__AS_OP, null, msgs);
      if (newAsOp != null)
        msgs = ((InternalEObject)newAsOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__AS_OP, null, msgs);
      msgs = basicSetAsOp(newAsOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__AS_OP, newAsOp, newAsOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Executable getEachOp()
  {
    return eachOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEachOp(Executable newEachOp, NotificationChain msgs)
  {
    Executable oldEachOp = eachOp;
    eachOp = newEachOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__EACH_OP, oldEachOp, newEachOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEachOp(Executable newEachOp)
  {
    if (newEachOp != eachOp)
    {
      NotificationChain msgs = null;
      if (eachOp != null)
        msgs = ((InternalEObject)eachOp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__EACH_OP, null, msgs);
      if (newEachOp != null)
        msgs = ((InternalEObject)newEachOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.MIGRATION__EACH_OP, null, msgs);
      msgs = basicSetEachOp(newEachOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.MIGRATION__EACH_OP, newEachOp, newEachOp));
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
      case EpatchTestLanguagePackage.MIGRATION__FIRST:
        return basicSetFirst(null, msgs);
      case EpatchTestLanguagePackage.MIGRATION__AS_OP:
        return basicSetAsOp(null, msgs);
      case EpatchTestLanguagePackage.MIGRATION__EACH_OP:
        return basicSetEachOp(null, msgs);
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
      case EpatchTestLanguagePackage.MIGRATION__FIRST:
        return getFirst();
      case EpatchTestLanguagePackage.MIGRATION__AS_OP:
        return getAsOp();
      case EpatchTestLanguagePackage.MIGRATION__EACH_OP:
        return getEachOp();
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
      case EpatchTestLanguagePackage.MIGRATION__FIRST:
        setFirst((Executable)newValue);
        return;
      case EpatchTestLanguagePackage.MIGRATION__AS_OP:
        setAsOp((Executable)newValue);
        return;
      case EpatchTestLanguagePackage.MIGRATION__EACH_OP:
        setEachOp((Executable)newValue);
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
      case EpatchTestLanguagePackage.MIGRATION__FIRST:
        setFirst((Executable)null);
        return;
      case EpatchTestLanguagePackage.MIGRATION__AS_OP:
        setAsOp((Executable)null);
        return;
      case EpatchTestLanguagePackage.MIGRATION__EACH_OP:
        setEachOp((Executable)null);
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
      case EpatchTestLanguagePackage.MIGRATION__FIRST:
        return first != null;
      case EpatchTestLanguagePackage.MIGRATION__AS_OP:
        return asOp != null;
      case EpatchTestLanguagePackage.MIGRATION__EACH_OP:
        return eachOp != null;
    }
    return super.eIsSet(featureID);
  }

} //MigrationImpl
