/**
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl#getLineCount <em>Line Count</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl#getCharCount <em>Char Count</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl#getCharSet <em>Char Set</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl#getRefChar <em>Ref Char</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleTermImpl extends MinimalEObjectImpl.Container implements SimpleTerm
{
  /**
   * The default value of the '{@link #getLineCount() <em>Line Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLineCount()
   * @generated
   * @ordered
   */
  protected static final int LINE_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLineCount() <em>Line Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLineCount()
   * @generated
   * @ordered
   */
  protected int lineCount = LINE_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getCharCount() <em>Char Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharCount()
   * @generated
   * @ordered
   */
  protected static final int CHAR_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCharCount() <em>Char Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharCount()
   * @generated
   * @ordered
   */
  protected int charCount = CHAR_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getCharSet() <em>Char Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharSet()
   * @generated
   * @ordered
   */
  protected static final String CHAR_SET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCharSet() <em>Char Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharSet()
   * @generated
   * @ordered
   */
  protected String charSet = CHAR_SET_EDEFAULT;

  /**
   * The default value of the '{@link #getRefChar() <em>Ref Char</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefChar()
   * @generated
   * @ordered
   */
  protected static final String REF_CHAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRefChar() <em>Ref Char</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefChar()
   * @generated
   * @ordered
   */
  protected String refChar = REF_CHAR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleTermImpl()
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
    return BacktrackingBug325745TestLanguagePackage.Literals.SIMPLE_TERM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLineCount()
  {
    return lineCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLineCount(int newLineCount)
  {
    int oldLineCount = lineCount;
    lineCount = newLineCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__LINE_COUNT, oldLineCount, lineCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCharCount()
  {
    return charCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharCount(int newCharCount)
  {
    int oldCharCount = charCount;
    charCount = newCharCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_COUNT, oldCharCount, charCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCharSet()
  {
    return charSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharSet(String newCharSet)
  {
    String oldCharSet = charSet;
    charSet = newCharSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_SET, oldCharSet, charSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRefChar()
  {
    return refChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefChar(String newRefChar)
  {
    String oldRefChar = refChar;
    refChar = newRefChar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__REF_CHAR, oldRefChar, refChar));
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
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__LINE_COUNT:
        return getLineCount();
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_COUNT:
        return getCharCount();
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_SET:
        return getCharSet();
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__REF_CHAR:
        return getRefChar();
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
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__LINE_COUNT:
        setLineCount((Integer)newValue);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_COUNT:
        setCharCount((Integer)newValue);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_SET:
        setCharSet((String)newValue);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__REF_CHAR:
        setRefChar((String)newValue);
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
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__LINE_COUNT:
        setLineCount(LINE_COUNT_EDEFAULT);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_COUNT:
        setCharCount(CHAR_COUNT_EDEFAULT);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_SET:
        setCharSet(CHAR_SET_EDEFAULT);
        return;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__REF_CHAR:
        setRefChar(REF_CHAR_EDEFAULT);
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
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__LINE_COUNT:
        return lineCount != LINE_COUNT_EDEFAULT;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_COUNT:
        return charCount != CHAR_COUNT_EDEFAULT;
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__CHAR_SET:
        return CHAR_SET_EDEFAULT == null ? charSet != null : !CHAR_SET_EDEFAULT.equals(charSet);
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM__REF_CHAR:
        return REF_CHAR_EDEFAULT == null ? refChar != null : !REF_CHAR_EDEFAULT.equals(refChar);
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
    result.append(" (lineCount: ");
    result.append(lineCount);
    result.append(", charCount: ");
    result.append(charCount);
    result.append(", charSet: ");
    result.append(charSet);
    result.append(", refChar: ");
    result.append(refChar);
    result.append(')');
    return result.toString();
  }

} //SimpleTermImpl
