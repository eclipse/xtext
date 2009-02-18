/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelImpl.java,v 1.1 2009/02/18 19:34:57 sefftinge Exp $
 */
package org.eclipse.xtext.parser.keywords.keywordsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage;
import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.keywords.keywordsTestLanguage.impl.ModelImpl#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.keywords.keywordsTestLanguage.impl.ModelImpl#isSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.keywords.keywordsTestLanguage.impl.ModelImpl#isThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.keywords.keywordsTestLanguage.impl.ModelImpl#isForth <em>Forth</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model
{
  /**
   * The default value of the '{@link #isFirst() <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirst()
   * @generated
   * @ordered
   */
  protected static final boolean FIRST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFirst() <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirst()
   * @generated
   * @ordered
   */
  protected boolean first = FIRST_EDEFAULT;

  /**
   * The default value of the '{@link #isSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSecond()
   * @generated
   * @ordered
   */
  protected static final boolean SECOND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSecond()
   * @generated
   * @ordered
   */
  protected boolean second = SECOND_EDEFAULT;

  /**
   * The default value of the '{@link #isThird() <em>Third</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThird()
   * @generated
   * @ordered
   */
  protected static final boolean THIRD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isThird() <em>Third</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThird()
   * @generated
   * @ordered
   */
  protected boolean third = THIRD_EDEFAULT;

  /**
   * The default value of the '{@link #isForth() <em>Forth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForth()
   * @generated
   * @ordered
   */
  protected static final boolean FORTH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isForth() <em>Forth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForth()
   * @generated
   * @ordered
   */
  protected boolean forth = FORTH_EDEFAULT;

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
    return KeywordsTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(boolean newFirst)
  {
    boolean oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KeywordsTestLanguagePackage.MODEL__FIRST, oldFirst, first));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(boolean newSecond)
  {
    boolean oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KeywordsTestLanguagePackage.MODEL__SECOND, oldSecond, second));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isThird()
  {
    return third;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThird(boolean newThird)
  {
    boolean oldThird = third;
    third = newThird;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KeywordsTestLanguagePackage.MODEL__THIRD, oldThird, third));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isForth()
  {
    return forth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForth(boolean newForth)
  {
    boolean oldForth = forth;
    forth = newForth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KeywordsTestLanguagePackage.MODEL__FORTH, oldForth, forth));
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
      case KeywordsTestLanguagePackage.MODEL__FIRST:
        return isFirst() ? Boolean.TRUE : Boolean.FALSE;
      case KeywordsTestLanguagePackage.MODEL__SECOND:
        return isSecond() ? Boolean.TRUE : Boolean.FALSE;
      case KeywordsTestLanguagePackage.MODEL__THIRD:
        return isThird() ? Boolean.TRUE : Boolean.FALSE;
      case KeywordsTestLanguagePackage.MODEL__FORTH:
        return isForth() ? Boolean.TRUE : Boolean.FALSE;
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
      case KeywordsTestLanguagePackage.MODEL__FIRST:
        setFirst(((Boolean)newValue).booleanValue());
        return;
      case KeywordsTestLanguagePackage.MODEL__SECOND:
        setSecond(((Boolean)newValue).booleanValue());
        return;
      case KeywordsTestLanguagePackage.MODEL__THIRD:
        setThird(((Boolean)newValue).booleanValue());
        return;
      case KeywordsTestLanguagePackage.MODEL__FORTH:
        setForth(((Boolean)newValue).booleanValue());
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
      case KeywordsTestLanguagePackage.MODEL__FIRST:
        setFirst(FIRST_EDEFAULT);
        return;
      case KeywordsTestLanguagePackage.MODEL__SECOND:
        setSecond(SECOND_EDEFAULT);
        return;
      case KeywordsTestLanguagePackage.MODEL__THIRD:
        setThird(THIRD_EDEFAULT);
        return;
      case KeywordsTestLanguagePackage.MODEL__FORTH:
        setForth(FORTH_EDEFAULT);
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
      case KeywordsTestLanguagePackage.MODEL__FIRST:
        return first != FIRST_EDEFAULT;
      case KeywordsTestLanguagePackage.MODEL__SECOND:
        return second != SECOND_EDEFAULT;
      case KeywordsTestLanguagePackage.MODEL__THIRD:
        return third != THIRD_EDEFAULT;
      case KeywordsTestLanguagePackage.MODEL__FORTH:
        return forth != FORTH_EDEFAULT;
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
    result.append(" (first: ");
    result.append(first);
    result.append(", second: ");
    result.append(second);
    result.append(", third: ");
    result.append(third);
    result.append(", forth: ");
    result.append(forth);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
