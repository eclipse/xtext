/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unordered Serialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isForth <em>Forth</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getFirstAsList <em>First As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getSecondAsList <em>Second As List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization()
 * @model
 * @generated
 */
public interface UnorderedSerialization extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' attribute.
   * @see #setFirst(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_First()
   * @model
   * @generated
   */
  boolean isFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isFirst <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' attribute.
   * @see #isFirst()
   * @generated
   */
  void setFirst(boolean value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' attribute.
   * @see #setSecond(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_Second()
   * @model
   * @generated
   */
  boolean isSecond();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isSecond <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' attribute.
   * @see #isSecond()
   * @generated
   */
  void setSecond(boolean value);

  /**
   * Returns the value of the '<em><b>Third</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third</em>' attribute.
   * @see #setThird(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_Third()
   * @model
   * @generated
   */
  boolean isThird();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isThird <em>Third</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Third</em>' attribute.
   * @see #isThird()
   * @generated
   */
  void setThird(boolean value);

  /**
   * Returns the value of the '<em><b>Forth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forth</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forth</em>' attribute.
   * @see #setForth(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_Forth()
   * @model
   * @generated
   */
  boolean isForth();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isForth <em>Forth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Forth</em>' attribute.
   * @see #isForth()
   * @generated
   */
  void setForth(boolean value);

  /**
   * Returns the value of the '<em><b>First As List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First As List</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First As List</em>' attribute list.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_FirstAsList()
   * @model unique="false"
   * @generated
   */
  EList<String> getFirstAsList();

  /**
   * Returns the value of the '<em><b>Second As List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second As List</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second As List</em>' attribute list.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getUnorderedSerialization_SecondAsList()
   * @model unique="false"
   * @generated
   */
  EList<String> getSecondAsList();

} // UnorderedSerialization
