/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getThrird <em>Thrird</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getForth <em>Forth</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getFifth <em>Fifth</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected SimpleModel first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected MandatoryModel second;

  /**
   * The cached value of the '{@link #getThrird() <em>Thrird</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThrird()
   * @generated
   * @ordered
   */
  protected LoopedModel thrird;

  /**
   * The cached value of the '{@link #getForth() <em>Forth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForth()
   * @generated
   * @ordered
   */
  protected GroupLoopedModel forth;

  /**
   * The cached value of the '{@link #getFifth() <em>Fifth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFifth()
   * @generated
   * @ordered
   */
  protected LoopedAlternativeModel fifth;

  /**
   * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected Bug304681Model model;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return UnorderedGroupsTestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleModel getFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirst(SimpleModel newFirst, NotificationChain msgs)
  {
    SimpleModel oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FIRST, oldFirst, newFirst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(SimpleModel newFirst)
  {
    if (newFirst != first)
    {
      NotificationChain msgs = null;
      if (first != null)
        msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FIRST, null, msgs);
      if (newFirst != null)
        msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FIRST, null, msgs);
      msgs = basicSetFirst(newFirst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FIRST, newFirst, newFirst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryModel getSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecond(MandatoryModel newSecond, NotificationChain msgs)
  {
    MandatoryModel oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__SECOND, oldSecond, newSecond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(MandatoryModel newSecond)
  {
    if (newSecond != second)
    {
      NotificationChain msgs = null;
      if (second != null)
        msgs = ((InternalEObject)second).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__SECOND, null, msgs);
      if (newSecond != null)
        msgs = ((InternalEObject)newSecond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__SECOND, null, msgs);
      msgs = basicSetSecond(newSecond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__SECOND, newSecond, newSecond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopedModel getThrird()
  {
    return thrird;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThrird(LoopedModel newThrird, NotificationChain msgs)
  {
    LoopedModel oldThrird = thrird;
    thrird = newThrird;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__THRIRD, oldThrird, newThrird);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThrird(LoopedModel newThrird)
  {
    if (newThrird != thrird)
    {
      NotificationChain msgs = null;
      if (thrird != null)
        msgs = ((InternalEObject)thrird).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__THRIRD, null, msgs);
      if (newThrird != null)
        msgs = ((InternalEObject)newThrird).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__THRIRD, null, msgs);
      msgs = basicSetThrird(newThrird, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__THRIRD, newThrird, newThrird));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupLoopedModel getForth()
  {
    return forth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetForth(GroupLoopedModel newForth, NotificationChain msgs)
  {
    GroupLoopedModel oldForth = forth;
    forth = newForth;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FORTH, oldForth, newForth);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForth(GroupLoopedModel newForth)
  {
    if (newForth != forth)
    {
      NotificationChain msgs = null;
      if (forth != null)
        msgs = ((InternalEObject)forth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FORTH, null, msgs);
      if (newForth != null)
        msgs = ((InternalEObject)newForth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FORTH, null, msgs);
      msgs = basicSetForth(newForth, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FORTH, newForth, newForth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopedAlternativeModel getFifth()
  {
    return fifth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFifth(LoopedAlternativeModel newFifth, NotificationChain msgs)
  {
    LoopedAlternativeModel oldFifth = fifth;
    fifth = newFifth;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FIFTH, oldFifth, newFifth);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFifth(LoopedAlternativeModel newFifth)
  {
    if (newFifth != fifth)
    {
      NotificationChain msgs = null;
      if (fifth != null)
        msgs = ((InternalEObject)fifth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FIFTH, null, msgs);
      if (newFifth != null)
        msgs = ((InternalEObject)newFifth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__FIFTH, null, msgs);
      msgs = basicSetFifth(newFifth, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FIFTH, newFifth, newFifth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug304681Model getModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(Bug304681Model newModel, NotificationChain msgs)
  {
    Bug304681Model oldModel = model;
    model = newModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__MODEL, oldModel, newModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(Bug304681Model newModel)
  {
    if (newModel != model)
    {
      NotificationChain msgs = null;
      if (model != null)
        msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__MODEL, null, msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestPackage.MODEL__MODEL, null, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__MODEL, newModel, newModel));
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
      case UnorderedGroupsTestPackage.MODEL__FIRST:
        return basicSetFirst(null, msgs);
      case UnorderedGroupsTestPackage.MODEL__SECOND:
        return basicSetSecond(null, msgs);
      case UnorderedGroupsTestPackage.MODEL__THRIRD:
        return basicSetThrird(null, msgs);
      case UnorderedGroupsTestPackage.MODEL__FORTH:
        return basicSetForth(null, msgs);
      case UnorderedGroupsTestPackage.MODEL__FIFTH:
        return basicSetFifth(null, msgs);
      case UnorderedGroupsTestPackage.MODEL__MODEL:
        return basicSetModel(null, msgs);
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
      case UnorderedGroupsTestPackage.MODEL__FIRST:
        return getFirst();
      case UnorderedGroupsTestPackage.MODEL__SECOND:
        return getSecond();
      case UnorderedGroupsTestPackage.MODEL__THRIRD:
        return getThrird();
      case UnorderedGroupsTestPackage.MODEL__FORTH:
        return getForth();
      case UnorderedGroupsTestPackage.MODEL__FIFTH:
        return getFifth();
      case UnorderedGroupsTestPackage.MODEL__MODEL:
        return getModel();
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
      case UnorderedGroupsTestPackage.MODEL__FIRST:
        setFirst((SimpleModel)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__SECOND:
        setSecond((MandatoryModel)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__THRIRD:
        setThrird((LoopedModel)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__FORTH:
        setForth((GroupLoopedModel)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__FIFTH:
        setFifth((LoopedAlternativeModel)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__MODEL:
        setModel((Bug304681Model)newValue);
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
      case UnorderedGroupsTestPackage.MODEL__FIRST:
        setFirst((SimpleModel)null);
        return;
      case UnorderedGroupsTestPackage.MODEL__SECOND:
        setSecond((MandatoryModel)null);
        return;
      case UnorderedGroupsTestPackage.MODEL__THRIRD:
        setThrird((LoopedModel)null);
        return;
      case UnorderedGroupsTestPackage.MODEL__FORTH:
        setForth((GroupLoopedModel)null);
        return;
      case UnorderedGroupsTestPackage.MODEL__FIFTH:
        setFifth((LoopedAlternativeModel)null);
        return;
      case UnorderedGroupsTestPackage.MODEL__MODEL:
        setModel((Bug304681Model)null);
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
      case UnorderedGroupsTestPackage.MODEL__FIRST:
        return first != null;
      case UnorderedGroupsTestPackage.MODEL__SECOND:
        return second != null;
      case UnorderedGroupsTestPackage.MODEL__THRIRD:
        return thrird != null;
      case UnorderedGroupsTestPackage.MODEL__FORTH:
        return forth != null;
      case UnorderedGroupsTestPackage.MODEL__FIFTH:
        return fifth != null;
      case UnorderedGroupsTestPackage.MODEL__MODEL:
        return model != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
