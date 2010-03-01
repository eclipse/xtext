/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.parsetree.SyntaxError;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParsetreePackageImpl extends EPackageImpl implements ParsetreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leafNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxErrorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParsetreePackageImpl() {
		super(eNS_URI, ParsetreeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ParsetreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParsetreePackage init() {
		if (isInited) return (ParsetreePackage)EPackage.Registry.INSTANCE.getEPackage(ParsetreePackage.eNS_URI);

		// Obtain or create and register package
		ParsetreePackageImpl theParsetreePackage = (ParsetreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParsetreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParsetreePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theParsetreePackage.createPackageContents();

		// Initialize created meta-data
		theParsetreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParsetreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParsetreePackage.eNS_URI, theParsetreePackage);
		return theParsetreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeNode() {
		return compositeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNode_Children() {
		return (EReference)compositeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNode_LookaheadLeafNodes() {
		return (EReference)compositeNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNode() {
		return abstractNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_Parent() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_GrammarElement() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_Element() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_SyntaxError() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNode_TotalOffset() {
		return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNode_TotalLine() {
		return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNode_TotalLength() {
		return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeafNode() {
		return leafNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLeafNode_Text() {
		return (EAttribute)leafNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLeafNode_Feature() {
		return (EAttribute)leafNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLeafNode_Hidden() {
		return (EAttribute)leafNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxError() {
		return syntaxErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSyntaxError_Message() {
		return (EAttribute)syntaxErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSyntaxError_Node() {
		return (EReference)syntaxErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSyntaxError_IssueCode() {
		return (EAttribute)syntaxErrorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreeFactory getParsetreeFactory() {
		return (ParsetreeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		compositeNodeEClass = createEClass(COMPOSITE_NODE);
		createEReference(compositeNodeEClass, COMPOSITE_NODE__CHILDREN);
		createEReference(compositeNodeEClass, COMPOSITE_NODE__LOOKAHEAD_LEAF_NODES);

		abstractNodeEClass = createEClass(ABSTRACT_NODE);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__PARENT);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__GRAMMAR_ELEMENT);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__ELEMENT);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__SYNTAX_ERROR);
		createEAttribute(abstractNodeEClass, ABSTRACT_NODE__TOTAL_OFFSET);
		createEAttribute(abstractNodeEClass, ABSTRACT_NODE__TOTAL_LINE);
		createEAttribute(abstractNodeEClass, ABSTRACT_NODE__TOTAL_LENGTH);

		leafNodeEClass = createEClass(LEAF_NODE);
		createEAttribute(leafNodeEClass, LEAF_NODE__TEXT);
		createEAttribute(leafNodeEClass, LEAF_NODE__FEATURE);
		createEAttribute(leafNodeEClass, LEAF_NODE__HIDDEN);

		syntaxErrorEClass = createEClass(SYNTAX_ERROR);
		createEAttribute(syntaxErrorEClass, SYNTAX_ERROR__MESSAGE);
		createEReference(syntaxErrorEClass, SYNTAX_ERROR__NODE);
		createEAttribute(syntaxErrorEClass, SYNTAX_ERROR__ISSUE_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeNodeEClass.getESuperTypes().add(this.getAbstractNode());
		leafNodeEClass.getESuperTypes().add(this.getAbstractNode());

		// Initialize classes and features; add operations and parameters
		initEClass(compositeNodeEClass, CompositeNode.class, "CompositeNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeNode_Children(), this.getAbstractNode(), this.getAbstractNode_Parent(), "children", null, 0, -1, CompositeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeNode_LookaheadLeafNodes(), this.getLeafNode(), null, "lookaheadLeafNodes", null, 0, -1, CompositeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractNodeEClass, AbstractNode.class, "AbstractNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractNode_Parent(), this.getCompositeNode(), this.getCompositeNode_Children(), "parent", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNode_GrammarElement(), ecorePackage.getEObject(), null, "grammarElement", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNode_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNode_SyntaxError(), this.getSyntaxError(), this.getSyntaxError_Node(), "syntaxError", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNode_TotalOffset(), ecorePackage.getEInt(), "totalOffset", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNode_TotalLine(), ecorePackage.getEInt(), "totalLine", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNode_TotalLength(), ecorePackage.getEInt(), "totalLength", "-1", 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEString(), "serialize", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, this.getLeafNode(), "getLeafNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(abstractNodeEClass, this.getLeafNode(), "getLeafNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractNode(), "to", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, this.getSyntaxError(), "allSyntaxErrors", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEInt(), "totalEndLine", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEInt(), "getOffset", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEInt(), "getLine", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEInt(), "getLength", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractNodeEClass, ecorePackage.getEInt(), "endLine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(leafNodeEClass, LeafNode.class, "LeafNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLeafNode_Text(), ecorePackage.getEString(), "text", null, 0, 1, LeafNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLeafNode_Feature(), ecorePackage.getEString(), "feature", null, 0, 1, LeafNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLeafNode_Hidden(), ecorePackage.getEBoolean(), "hidden", null, 0, 1, LeafNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syntaxErrorEClass, SyntaxError.class, "SyntaxError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSyntaxError_Message(), ecorePackage.getEString(), "message", null, 0, 1, SyntaxError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSyntaxError_Node(), this.getAbstractNode(), this.getAbstractNode_SyntaxError(), "node", null, 0, 1, SyntaxError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSyntaxError_IssueCode(), ecorePackage.getEString(), "issueCode", null, 0, 1, SyntaxError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ParsetreePackageImpl
