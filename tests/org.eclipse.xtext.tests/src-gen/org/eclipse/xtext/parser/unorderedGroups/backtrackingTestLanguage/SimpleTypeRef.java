/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.SimpleTypeRef#getRawType <em>Raw Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.SimpleTypeRef#getActualArgumentsList <em>Actual Arguments List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getSimpleTypeRef()
 * @model
 * @generated
 */
public interface SimpleTypeRef extends TypeRef
{
  /**
   * Returns the value of the '<em><b>Raw Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Raw Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raw Type</em>' attribute.
   * @see #setRawType(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getSimpleTypeRef_RawType()
   * @model
   * @generated
   */
  String getRawType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.SimpleTypeRef#getRawType <em>Raw Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Raw Type</em>' attribute.
   * @see #getRawType()
   * @generated
   */
  void setRawType(String value);

  /**
   * Returns the value of the '<em><b>Actual Arguments List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual Arguments List</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Arguments List</em>' attribute list.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getSimpleTypeRef_ActualArgumentsList()
   * @model unique="false"
   * @generated
   */
  EList<String> getActualArgumentsList();

} // SimpleTypeRef
