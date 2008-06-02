/**
 * <copyright>
 * </copyright>
 *
 * $Id: Grammar.java,v 1.8 2008/06/02 13:20:56 sefftinge Exp $
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
 *   <li>{@link org.eclipse.xtext.Grammar#getLexerRules <em>Lexer Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getParserRules <em>Parser Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getSuperGrammar <em>Super Grammar</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
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
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.XtextPackage#getGrammar_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.Grammar#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Grammar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Grammar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Grammar</em>' attribute.
   * @see #setSuperGrammar(String)
   * @see org.eclipse.xtext.XtextPackage#getGrammar_SuperGrammar()
   * @model
   * @generated
   */
  String getSuperGrammar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.Grammar#getSuperGrammar <em>Super Grammar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Grammar</em>' attribute.
   * @see #getSuperGrammar()
   * @generated
   */
  void setSuperGrammar(String value);

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

} // Grammar
