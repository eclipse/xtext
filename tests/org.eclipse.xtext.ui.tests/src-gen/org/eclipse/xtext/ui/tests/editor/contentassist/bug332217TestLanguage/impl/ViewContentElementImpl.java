/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Content Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewContentElementImpl#getIterator <em>Iterator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewContentElementImpl extends MinimalEObjectImpl.Container implements ViewContentElement
{
  /**
   * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIterator()
   * @generated
   * @ordered
   */
  protected CollectionIterator iterator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ViewContentElementImpl()
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
    return Bug332217TestLanguagePackage.Literals.VIEW_CONTENT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionIterator getIterator()
  {
    return iterator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIterator(CollectionIterator newIterator, NotificationChain msgs)
  {
    CollectionIterator oldIterator = iterator;
    iterator = newIterator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR, oldIterator, newIterator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIterator(CollectionIterator newIterator)
  {
    if (newIterator != iterator)
    {
      NotificationChain msgs = null;
      if (iterator != null)
        msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR, null, msgs);
      if (newIterator != null)
        msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR, null, msgs);
      msgs = basicSetIterator(newIterator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR, newIterator, newIterator));
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
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR:
        return basicSetIterator(null, msgs);
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
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR:
        return getIterator();
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
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR:
        setIterator((CollectionIterator)newValue);
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
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR:
        setIterator((CollectionIterator)null);
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
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT__ITERATOR:
        return iterator != null;
    }
    return super.eIsSet(featureID);
  }

} //ViewContentElementImpl
