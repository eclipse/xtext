/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl#getDelimiter <em>Delimiter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringSplitImpl extends CollectionFunctionImpl implements StringSplit
{
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ScalarExpression value;

  /**
   * The cached value of the '{@link #getDelimiter() <em>Delimiter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelimiter()
   * @generated
   * @ordered
   */
  protected ScalarExpression delimiter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringSplitImpl()
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
    return Bug332217TestLanguagePackage.Literals.STRING_SPLIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ScalarExpression newValue, NotificationChain msgs)
  {
    ScalarExpression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_SPLIT__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(ScalarExpression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_SPLIT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_SPLIT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_SPLIT__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getDelimiter()
  {
    return delimiter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelimiter(ScalarExpression newDelimiter, NotificationChain msgs)
  {
    ScalarExpression oldDelimiter = delimiter;
    delimiter = newDelimiter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER, oldDelimiter, newDelimiter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelimiter(ScalarExpression newDelimiter)
  {
    if (newDelimiter != delimiter)
    {
      NotificationChain msgs = null;
      if (delimiter != null)
        msgs = ((InternalEObject)delimiter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER, null, msgs);
      if (newDelimiter != null)
        msgs = ((InternalEObject)newDelimiter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER, null, msgs);
      msgs = basicSetDelimiter(newDelimiter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER, newDelimiter, newDelimiter));
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
      case Bug332217TestLanguagePackage.STRING_SPLIT__VALUE:
        return basicSetValue(null, msgs);
      case Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER:
        return basicSetDelimiter(null, msgs);
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
      case Bug332217TestLanguagePackage.STRING_SPLIT__VALUE:
        return getValue();
      case Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER:
        return getDelimiter();
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
      case Bug332217TestLanguagePackage.STRING_SPLIT__VALUE:
        setValue((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER:
        setDelimiter((ScalarExpression)newValue);
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
      case Bug332217TestLanguagePackage.STRING_SPLIT__VALUE:
        setValue((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER:
        setDelimiter((ScalarExpression)null);
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
      case Bug332217TestLanguagePackage.STRING_SPLIT__VALUE:
        return value != null;
      case Bug332217TestLanguagePackage.STRING_SPLIT__DELIMITER:
        return delimiter != null;
    }
    return super.eIsSet(featureID);
  }

} //StringSplitImpl
