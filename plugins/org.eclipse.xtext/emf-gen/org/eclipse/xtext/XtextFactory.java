/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextFactory.java,v 1.13 2008/12/03 20:57:09 szarnekow Exp $
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.XtextPackage
 * @generated
 */
public interface XtextFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  XtextFactory eINSTANCE = org.eclipse.xtext.impl.XtextFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Generated Metamodel</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generated Metamodel</em>'.
	 * @generated
	 */
  GeneratedMetamodel createGeneratedMetamodel();

  /**
	 * Returns a new object of class '<em>Grammar</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar</em>'.
	 * @generated
	 */
  Grammar createGrammar();

  /**
	 * Returns a new object of class '<em>Abstract Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Rule</em>'.
	 * @generated
	 */
	AbstractRule createAbstractRule();

		/**
	 * Returns a new object of class '<em>Parser Rule</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parser Rule</em>'.
	 * @generated
	 */
  ParserRule createParserRule();

  /**
	 * Returns a new object of class '<em>Abstract Metamodel Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Metamodel Declaration</em>'.
	 * @generated
	 */
	AbstractMetamodelDeclaration createAbstractMetamodelDeclaration();

		/**
	 * Returns a new object of class '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Ref</em>'.
	 * @generated
	 */
  TypeRef createTypeRef();

  /**
	 * Returns a new object of class '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Element</em>'.
	 * @generated
	 */
	AbstractElement createAbstractElement();

		/**
	 * Returns a new object of class '<em>Alternatives</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternatives</em>'.
	 * @generated
	 */
	Alternatives createAlternatives();

		/**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	Group createGroup();

		/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

		/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

		/**
	 * Returns a new object of class '<em>Rule Call</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Call</em>'.
	 * @generated
	 */
  RuleCall createRuleCall();

  /**
	 * Returns a new object of class '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cross Reference</em>'.
	 * @generated
	 */
	CrossReference createCrossReference();

		/**
	 * Returns a new object of class '<em>Referenced Metamodel</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referenced Metamodel</em>'.
	 * @generated
	 */
  ReferencedMetamodel createReferencedMetamodel();

  /**
	 * Returns a new object of class '<em>Lexer Rule</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lexer Rule</em>'.
	 * @generated
	 */
  LexerRule createLexerRule();

  /**
	 * Returns a new object of class '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyword</em>'.
	 * @generated
	 */
  Keyword createKeyword();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  XtextPackage getXtextPackage();

} //XtextFactory
