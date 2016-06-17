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
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Replace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringReplaceImpl extends StringFunctionImpl implements StringReplace
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
   * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatch()
   * @generated
   * @ordered
   */
  protected ScalarExpression match;

  /**
   * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplacement()
   * @generated
   * @ordered
   */
  protected ScalarExpression replacement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringReplaceImpl()
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
    return Bug332217TestLanguagePackage.Literals.STRING_REPLACE;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__VALUE, oldValue, newValue);
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
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getMatch()
  {
    return match;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatch(ScalarExpression newMatch, NotificationChain msgs)
  {
    ScalarExpression oldMatch = match;
    match = newMatch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__MATCH, oldMatch, newMatch);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatch(ScalarExpression newMatch)
  {
    if (newMatch != match)
    {
      NotificationChain msgs = null;
      if (match != null)
        msgs = ((InternalEObject)match).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__MATCH, null, msgs);
      if (newMatch != null)
        msgs = ((InternalEObject)newMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__MATCH, null, msgs);
      msgs = basicSetMatch(newMatch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__MATCH, newMatch, newMatch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getReplacement()
  {
    return replacement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReplacement(ScalarExpression newReplacement, NotificationChain msgs)
  {
    ScalarExpression oldReplacement = replacement;
    replacement = newReplacement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT, oldReplacement, newReplacement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReplacement(ScalarExpression newReplacement)
  {
    if (newReplacement != replacement)
    {
      NotificationChain msgs = null;
      if (replacement != null)
        msgs = ((InternalEObject)replacement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT, null, msgs);
      if (newReplacement != null)
        msgs = ((InternalEObject)newReplacement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT, null, msgs);
      msgs = basicSetReplacement(newReplacement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT, newReplacement, newReplacement));
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
      case Bug332217TestLanguagePackage.STRING_REPLACE__VALUE:
        return basicSetValue(null, msgs);
      case Bug332217TestLanguagePackage.STRING_REPLACE__MATCH:
        return basicSetMatch(null, msgs);
      case Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT:
        return basicSetReplacement(null, msgs);
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
      case Bug332217TestLanguagePackage.STRING_REPLACE__VALUE:
        return getValue();
      case Bug332217TestLanguagePackage.STRING_REPLACE__MATCH:
        return getMatch();
      case Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT:
        return getReplacement();
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
      case Bug332217TestLanguagePackage.STRING_REPLACE__VALUE:
        setValue((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.STRING_REPLACE__MATCH:
        setMatch((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT:
        setReplacement((ScalarExpression)newValue);
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
      case Bug332217TestLanguagePackage.STRING_REPLACE__VALUE:
        setValue((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.STRING_REPLACE__MATCH:
        setMatch((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT:
        setReplacement((ScalarExpression)null);
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
      case Bug332217TestLanguagePackage.STRING_REPLACE__VALUE:
        return value != null;
      case Bug332217TestLanguagePackage.STRING_REPLACE__MATCH:
        return match != null;
      case Bug332217TestLanguagePackage.STRING_REPLACE__REPLACEMENT:
        return replacement != null;
    }
    return super.eIsSet(featureID);
  }

} //StringReplaceImpl
