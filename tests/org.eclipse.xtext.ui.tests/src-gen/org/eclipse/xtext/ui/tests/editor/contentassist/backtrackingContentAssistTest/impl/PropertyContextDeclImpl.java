/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Context Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl#getInit <em>Init</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl#getDer <em>Der</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyContextDeclImpl extends ContextDeclImpl implements PropertyContextDecl
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected PropertyRef property;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeExp type;

  /**
   * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInit()
   * @generated
   * @ordered
   */
  protected Init init;

  /**
   * The cached value of the '{@link #getDer() <em>Der</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDer()
   * @generated
   * @ordered
   */
  protected Der der;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyContextDeclImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.PROPERTY_CONTEXT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyRef getProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(PropertyRef newProperty, NotificationChain msgs)
  {
    PropertyRef oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY, oldProperty, newProperty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperty(PropertyRef newProperty)
  {
    if (newProperty != property)
    {
      NotificationChain msgs = null;
      if (property != null)
        msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeExp getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeExp newType, NotificationChain msgs)
  {
    TypeExp oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeExp newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Init getInit()
  {
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInit(Init newInit, NotificationChain msgs)
  {
    Init oldInit = init;
    init = newInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT, oldInit, newInit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInit(Init newInit)
  {
    if (newInit != init)
    {
      NotificationChain msgs = null;
      if (init != null)
        msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT, null, msgs);
      if (newInit != null)
        msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT, null, msgs);
      msgs = basicSetInit(newInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT, newInit, newInit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Der getDer()
  {
    return der;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDer(Der newDer, NotificationChain msgs)
  {
    Der oldDer = der;
    der = newDer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER, oldDer, newDer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDer(Der newDer)
  {
    if (newDer != der)
    {
      NotificationChain msgs = null;
      if (der != null)
        msgs = ((InternalEObject)der).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER, null, msgs);
      if (newDer != null)
        msgs = ((InternalEObject)newDer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER, null, msgs);
      msgs = basicSetDer(newDer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER, newDer, newDer));
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
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY:
        return basicSetProperty(null, msgs);
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE:
        return basicSetType(null, msgs);
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT:
        return basicSetInit(null, msgs);
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER:
        return basicSetDer(null, msgs);
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
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY:
        return getProperty();
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE:
        return getType();
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT:
        return getInit();
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER:
        return getDer();
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
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY:
        setProperty((PropertyRef)newValue);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE:
        setType((TypeExp)newValue);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT:
        setInit((Init)newValue);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER:
        setDer((Der)newValue);
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
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY:
        setProperty((PropertyRef)null);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE:
        setType((TypeExp)null);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT:
        setInit((Init)null);
        return;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER:
        setDer((Der)null);
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
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__PROPERTY:
        return property != null;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__TYPE:
        return type != null;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__INIT:
        return init != null;
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL__DER:
        return der != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyContextDeclImpl
