/**
 * <copyright>
 * </copyright>
 *
 * $Id: Grammar.java,v 1.1 2009/02/06 09:46:51 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#getIdElements <em>Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#getSuperGrammarIdElements <em>Super Grammar Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject
{
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Id Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id Elements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id Elements</em>' attribute list.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar_IdElements()
   * @model unique="false"
   * @generated
   */
  EList<String> getIdElements();

  /**
   * Returns the value of the '<em><b>Super Grammar Id Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Grammar Id Elements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Grammar Id Elements</em>' attribute list.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar_SuperGrammarIdElements()
   * @model unique="false"
   * @generated
   */
  EList<String> getSuperGrammarIdElements();

  /**
   * Returns the value of the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractMetamodelDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Declarations</em>' containment reference list.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar_MetamodelDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<AbstractMetamodelDeclaration> getMetamodelDeclarations();

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getGrammar_Rules()
   * @model containment="true"
   * @generated
   */
  EList<AbstractRule> getRules();

} // Grammar
