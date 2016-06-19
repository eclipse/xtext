/**
 */
package org.eclipse.xtext.testlanguages.testLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.testlanguages.testLang.ChoiceElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl#isOptionalKeyword <em>Optional Keyword</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoiceElementImpl extends AbstractElementImpl implements ChoiceElement
{
  /**
   * The default value of the '{@link #isOptionalKeyword() <em>Optional Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOptionalKeyword()
   * @generated
   * @ordered
   */
  protected static final boolean OPTIONAL_KEYWORD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOptionalKeyword() <em>Optional Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOptionalKeyword()
   * @generated
   * @ordered
   */
  protected boolean optionalKeyword = OPTIONAL_KEYWORD_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChoiceElementImpl()
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
    return TestLangPackage.Literals.CHOICE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOptionalKeyword()
  {
    return optionalKeyword;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptionalKeyword(boolean newOptionalKeyword)
  {
    boolean oldOptionalKeyword = optionalKeyword;
    optionalKeyword = newOptionalKeyword;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.CHOICE_ELEMENT__OPTIONAL_KEYWORD, oldOptionalKeyword, optionalKeyword));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.CHOICE_ELEMENT__NAME, oldName, name));
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
      case TestLangPackage.CHOICE_ELEMENT__OPTIONAL_KEYWORD:
        return isOptionalKeyword();
      case TestLangPackage.CHOICE_ELEMENT__NAME:
        return getName();
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
      case TestLangPackage.CHOICE_ELEMENT__OPTIONAL_KEYWORD:
        setOptionalKeyword((Boolean)newValue);
        return;
      case TestLangPackage.CHOICE_ELEMENT__NAME:
        setName((String)newValue);
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
      case TestLangPackage.CHOICE_ELEMENT__OPTIONAL_KEYWORD:
        setOptionalKeyword(OPTIONAL_KEYWORD_EDEFAULT);
        return;
      case TestLangPackage.CHOICE_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
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
      case TestLangPackage.CHOICE_ELEMENT__OPTIONAL_KEYWORD:
        return optionalKeyword != OPTIONAL_KEYWORD_EDEFAULT;
      case TestLangPackage.CHOICE_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (optionalKeyword: ");
    result.append(optionalKeyword);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ChoiceElementImpl
