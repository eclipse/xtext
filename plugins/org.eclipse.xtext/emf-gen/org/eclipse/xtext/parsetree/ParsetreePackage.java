/**
 * <copyright>
 * </copyright>
 *
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
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.AbstractNodeImpl
	 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getAbstractNode()
	 * @generated
	 */
	int ABSTRACT_NODE = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Grammar Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__GRAMMAR_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Syntax Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__SYNTAX_ERROR = 3;

	/**
	 * The feature id for the '<em><b>Total Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__TOTAL_OFFSET = 4;

	/**
	 * The feature id for the '<em><b>Total Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__TOTAL_LINE = 5;

	/**
	 * The feature id for the '<em><b>Total Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__TOTAL_LENGTH = 6;

	/**
	 * The number of structural features of the '<em>Abstract Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.CompositeNodeImpl
	 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getCompositeNode()
	 * @generated
	 */
	int COMPOSITE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__PARENT = ABSTRACT_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Grammar Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__GRAMMAR_ELEMENT = ABSTRACT_NODE__GRAMMAR_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__ELEMENT = ABSTRACT_NODE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Syntax Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__SYNTAX_ERROR = ABSTRACT_NODE__SYNTAX_ERROR;

	/**
	 * The feature id for the '<em><b>Total Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__TOTAL_OFFSET = ABSTRACT_NODE__TOTAL_OFFSET;

	/**
	 * The feature id for the '<em><b>Total Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__TOTAL_LINE = ABSTRACT_NODE__TOTAL_LINE;

	/**
	 * The feature id for the '<em><b>Total Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__TOTAL_LENGTH = ABSTRACT_NODE__TOTAL_LENGTH;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__CHILDREN = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lookahead Leaf Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__LOOKAHEAD_LEAF_NODES = ABSTRACT_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.LeafNodeImpl
	 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getLeafNode()
	 * @generated
	 */
	int LEAF_NODE = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__PARENT = ABSTRACT_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Grammar Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__GRAMMAR_ELEMENT = ABSTRACT_NODE__GRAMMAR_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__ELEMENT = ABSTRACT_NODE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Syntax Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__SYNTAX_ERROR = ABSTRACT_NODE__SYNTAX_ERROR;

	/**
	 * The feature id for the '<em><b>Total Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__TOTAL_OFFSET = ABSTRACT_NODE__TOTAL_OFFSET;

	/**
	 * The feature id for the '<em><b>Total Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__TOTAL_LINE = ABSTRACT_NODE__TOTAL_LINE;

	/**
	 * The feature id for the '<em><b>Total Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__TOTAL_LENGTH = ABSTRACT_NODE__TOTAL_LENGTH;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__TEXT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__FEATURE = ABSTRACT_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__HIDDEN = ABSTRACT_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Leaf Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl <em>Syntax Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl
	 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getSyntaxError()
	 * @generated
	 */
	int SYNTAX_ERROR = 3;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ERROR__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ERROR__NODE = 1;

	/**
	 * The feature id for the '<em><b>Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ERROR__ISSUE_CODE = 2;

	/**
	 * The number of structural features of the '<em>Syntax Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ERROR_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.CompositeNode <em>Composite Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Node</em>'.
	 * @see org.eclipse.xtext.parsetree.CompositeNode
	 * @generated
	 */
	EClass getCompositeNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.CompositeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.xtext.parsetree.CompositeNode#getChildren()
	 * @see #getCompositeNode()
	 * @generated
	 */
	EReference getCompositeNode_Children();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.parsetree.CompositeNode#getLookaheadLeafNodes <em>Lookahead Leaf Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lookahead Leaf Nodes</em>'.
	 * @see org.eclipse.xtext.parsetree.CompositeNode#getLookaheadLeafNodes()
	 * @see #getCompositeNode()
	 * @generated
	 */
	EReference getCompositeNode_LookaheadLeafNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.AbstractNode <em>Abstract Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Node</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode
	 * @generated
	 */
	EClass getAbstractNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getParent()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grammar Element</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_GrammarElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getElement()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError <em>Syntax Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Syntax Error</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_SyntaxError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalOffset <em>Total Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Offset</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getTotalOffset()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_TotalOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLine <em>Total Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Line</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getTotalLine()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_TotalLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLength <em>Total Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Length</em>'.
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getTotalLength()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_TotalLength();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.LeafNode <em>Leaf Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Node</em>'.
	 * @see org.eclipse.xtext.parsetree.LeafNode
	 * @generated
	 */
	EClass getLeafNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.xtext.parsetree.LeafNode#getText()
	 * @see #getLeafNode()
	 * @generated
	 */
	EAttribute getLeafNode_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.eclipse.xtext.parsetree.LeafNode#getFeature()
	 * @see #getLeafNode()
	 * @generated
	 */
	EAttribute getLeafNode_Feature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see org.eclipse.xtext.parsetree.LeafNode#isHidden()
	 * @see #getLeafNode()
	 * @generated
	 */
	EAttribute getLeafNode_Hidden();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.SyntaxError <em>Syntax Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Error</em>'.
	 * @see org.eclipse.xtext.parsetree.SyntaxError
	 * @generated
	 */
	EClass getSyntaxError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.SyntaxError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.xtext.parsetree.SyntaxError#getMessage()
	 * @see #getSyntaxError()
	 * @generated
	 */
	EAttribute getSyntaxError_Message();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.parsetree.SyntaxError#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.eclipse.xtext.parsetree.SyntaxError#getNode()
	 * @see #getSyntaxError()
	 * @generated
	 */
	EReference getSyntaxError_Node();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.SyntaxError#getIssueCode <em>Issue Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Code</em>'.
	 * @see org.eclipse.xtext.parsetree.SyntaxError#getIssueCode()
	 * @see #getSyntaxError()
	 * @generated
	 */
	EAttribute getSyntaxError_IssueCode();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.CompositeNodeImpl
		 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getCompositeNode()
		 * @generated
		 */
		EClass COMPOSITE_NODE = eINSTANCE.getCompositeNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NODE__CHILDREN = eINSTANCE.getCompositeNode_Children();

		/**
		 * The meta object literal for the '<em><b>Lookahead Leaf Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NODE__LOOKAHEAD_LEAF_NODES = eINSTANCE.getCompositeNode_LookaheadLeafNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.AbstractNodeImpl
		 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getAbstractNode()
		 * @generated
		 */
		EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__PARENT = eINSTANCE.getAbstractNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Grammar Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__GRAMMAR_ELEMENT = eINSTANCE.getAbstractNode_GrammarElement();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__ELEMENT = eINSTANCE.getAbstractNode_Element();

		/**
		 * The meta object literal for the '<em><b>Syntax Error</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__SYNTAX_ERROR = eINSTANCE.getAbstractNode_SyntaxError();

		/**
		 * The meta object literal for the '<em><b>Total Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__TOTAL_OFFSET = eINSTANCE.getAbstractNode_TotalOffset();

		/**
		 * The meta object literal for the '<em><b>Total Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__TOTAL_LINE = eINSTANCE.getAbstractNode_TotalLine();

		/**
		 * The meta object literal for the '<em><b>Total Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__TOTAL_LENGTH = eINSTANCE.getAbstractNode_TotalLength();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.LeafNodeImpl
		 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getLeafNode()
		 * @generated
		 */
		EClass LEAF_NODE = eINSTANCE.getLeafNode();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_NODE__TEXT = eINSTANCE.getLeafNode_Text();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_NODE__FEATURE = eINSTANCE.getLeafNode_Feature();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_NODE__HIDDEN = eINSTANCE.getLeafNode_Hidden();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl <em>Syntax Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl
		 * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getSyntaxError()
		 * @generated
		 */
		EClass SYNTAX_ERROR = eINSTANCE.getSyntaxError();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNTAX_ERROR__MESSAGE = eINSTANCE.getSyntaxError_Message();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX_ERROR__NODE = eINSTANCE.getSyntaxError_Node();

		/**
		 * The meta object literal for the '<em><b>Issue Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNTAX_ERROR__ISSUE_CODE = eINSTANCE.getSyntaxError_IssueCode();

	}

} //ParsetreePackage
