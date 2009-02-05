/**
 * <copyright>
 * </copyright>
 *
 * $Id: Person.java,v 1.1 2009/02/05 19:05:39 jkohnlein Exp $
 */
package org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Person#getAge <em>Age</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Person#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.ReferenceGrammarPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject
{
  /**
   * Returns the value of the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Age</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Age</em>' attribute.
   * @see #setAge(int)
   * @see org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.ReferenceGrammarPackage#getPerson_Age()
   * @model
   * @generated
   */
  int getAge();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Person#getAge <em>Age</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Age</em>' attribute.
   * @see #getAge()
   * @generated
   */
  void setAge(int value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.ReferenceGrammarPackage#getPerson_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Person#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Person
