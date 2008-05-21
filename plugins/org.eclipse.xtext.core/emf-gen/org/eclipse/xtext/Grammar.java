/**
 * <copyright>
 * </copyright>
 *
 * $Id: Grammar.java,v 1.8 2008/05/21 12:02:34 jkohnlein Exp $
 */
package org.eclipse.xtext;

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
 *   <li>{@link org.eclipse.xtext.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getParserRules <em>Parser Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getLexerRules <em>Lexer Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject
{
  /**
   * Returns the value of the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.AbstractMetamodelDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Declarations</em>' containment reference list.
   * @see org.eclipse.xtext.XtextPackage#getGrammar_MetamodelDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<AbstractMetamodelDeclaration> getMetamodelDeclarations();

  /**
   * Returns the value of the '<em><b>Parser Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ParserRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parser Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parser Rules</em>' containment reference list.
   * @see org.eclipse.xtext.XtextPackage#getGrammar_ParserRules()
   * @model containment="true"
   * @generated
   */
  EList<ParserRule> getParserRules();

  /**
   * Returns the value of the '<em><b>Lexer Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.LexerRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lexer Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lexer Rules</em>' containment reference list.
   * @see org.eclipse.xtext.XtextPackage#getGrammar_LexerRules()
   * @model containment="true"
   * @generated
   */
  EList<LexerRule> getLexerRules();

} // Grammar
