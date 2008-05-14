/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParsetreePackage.java,v 1.1 2008/05/14 13:29:32 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.ParsetreeFactory
 * @model kind="package"
 * @generated
 */
public interface ParsetreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parsetree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/2008/xtext/parsetree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "parsetree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParsetreePackage eINSTANCE = org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.ParserNodeImpl <em>Parser Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.ParserNodeImpl
	 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getParserNode()
	 * @generated
	 */
	int PARSER_NODE = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_NODE__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_NODE__ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Grammar Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_NODE__GRAMMAR_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Parser Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_NODE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.ParserNode <em>Parser Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parser Node</em>'.
	 * @see org.eclipse.xtext.parsetree.ParserNode
	 * @generated
	 */
	EClass getParserNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.ParserNode#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.xtext.parsetree.ParserNode#getText()
	 * @see #getParserNode()
	 * @generated
	 */
	EAttribute getParserNode_Text();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.ParserNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.xtext.parsetree.ParserNode#getElement()
	 * @see #getParserNode()
	 * @generated
	 */
	EReference getParserNode_Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.ParserNode#getGrammarElement <em>Grammar Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grammar Element</em>'.
	 * @see org.eclipse.xtext.parsetree.ParserNode#getGrammarElement()
	 * @see #getParserNode()
	 * @generated
	 */
	EReference getParserNode_GrammarElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParsetreeFactory getParsetreeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.ParserNodeImpl <em>Parser Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.ParserNodeImpl
		 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getParserNode()
		 * @generated
		 */
		EClass PARSER_NODE = eINSTANCE.getParserNode();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARSER_NODE__TEXT = eINSTANCE.getParserNode_Text();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARSER_NODE__ELEMENT = eINSTANCE.getParserNode_Element();

		/**
		 * The meta object literal for the '<em><b>Grammar Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARSER_NODE__GRAMMAR_ELEMENT = eINSTANCE.getParserNode_GrammarElement();

	}

} //ParsetreePackage
