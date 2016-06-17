/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Without Hiddens</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithoutHiddensImpl#getSpaces <em>Spaces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WithoutHiddensImpl extends ModelImpl implements WithoutHiddens
{
  /**
   * The cached value of the '{@link #getSpaces() <em>Spaces</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpaces()
   * @generated
   * @ordered
   */
  protected EList<String> spaces;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WithoutHiddensImpl()
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
    return HiddenTerminalsTestLanguagePackage.Literals.WITHOUT_HIDDENS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSpaces()
  {
    if (spaces == null)
    {
      spaces = new EDataTypeEList<String>(String.class, this, HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS__SPACES);
    }
    return spaces;
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
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS__SPACES:
        return getSpaces();
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
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS__SPACES:
        getSpaces().clear();
        getSpaces().addAll((Collection<? extends String>)newValue);
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
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS__SPACES:
        getSpaces().clear();
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
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS__SPACES:
        return spaces != null && !spaces.isEmpty();
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
    result.append(" (spaces: ");
    result.append(spaces);
    result.append(')');
    return result.toString();
  }

} //WithoutHiddensImpl
