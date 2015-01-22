/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test.impl;

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

import org.eclipse.xtext.parser.assignments.bug288432Test.Body;
import org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage;
import org.eclipse.xtext.parser.assignments.bug288432Test.Foo;
import org.eclipse.xtext.parser.assignments.bug288432Test.Parameter;
import org.eclipse.xtext.parser.assignments.bug288432Test.ParameterObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl#getFoo <em>Foo</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BodyImpl extends MinimalEObjectImpl.Container implements Body
{
  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameter;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected ParameterObject content;

  /**
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected EList<Foo> foo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BodyImpl()
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
    return Bug288432TestPackage.Literals.BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, Bug288432TestPackage.BODY__PARAMETER);
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterObject getContent()
  {
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContent(ParameterObject newContent, NotificationChain msgs)
  {
    ParameterObject oldContent = content;
    content = newContent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug288432TestPackage.BODY__CONTENT, oldContent, newContent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContent(ParameterObject newContent)
  {
    if (newContent != content)
    {
      NotificationChain msgs = null;
      if (content != null)
        msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug288432TestPackage.BODY__CONTENT, null, msgs);
      if (newContent != null)
        msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug288432TestPackage.BODY__CONTENT, null, msgs);
      msgs = basicSetContent(newContent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug288432TestPackage.BODY__CONTENT, newContent, newContent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Foo> getFoo()
  {
    if (foo == null)
    {
      foo = new EObjectContainmentEList<Foo>(Foo.class, this, Bug288432TestPackage.BODY__FOO);
    }
    return foo;
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
      case Bug288432TestPackage.BODY__PARAMETER:
        return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
      case Bug288432TestPackage.BODY__CONTENT:
        return basicSetContent(null, msgs);
      case Bug288432TestPackage.BODY__FOO:
        return ((InternalEList<?>)getFoo()).basicRemove(otherEnd, msgs);
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
      case Bug288432TestPackage.BODY__PARAMETER:
        return getParameter();
      case Bug288432TestPackage.BODY__CONTENT:
        return getContent();
      case Bug288432TestPackage.BODY__FOO:
        return getFoo();
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
      case Bug288432TestPackage.BODY__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection<? extends Parameter>)newValue);
        return;
      case Bug288432TestPackage.BODY__CONTENT:
        setContent((ParameterObject)newValue);
        return;
      case Bug288432TestPackage.BODY__FOO:
        getFoo().clear();
        getFoo().addAll((Collection<? extends Foo>)newValue);
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
      case Bug288432TestPackage.BODY__PARAMETER:
        getParameter().clear();
        return;
      case Bug288432TestPackage.BODY__CONTENT:
        setContent((ParameterObject)null);
        return;
      case Bug288432TestPackage.BODY__FOO:
        getFoo().clear();
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
      case Bug288432TestPackage.BODY__PARAMETER:
        return parameter != null && !parameter.isEmpty();
      case Bug288432TestPackage.BODY__CONTENT:
        return content != null;
      case Bug288432TestPackage.BODY__FOO:
        return foo != null && !foo.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BodyImpl
