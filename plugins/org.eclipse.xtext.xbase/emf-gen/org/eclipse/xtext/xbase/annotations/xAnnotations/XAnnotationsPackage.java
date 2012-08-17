/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory
 * @model kind="package"
 * @generated
 */
public interface XAnnotationsPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xAnnotations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Xtext/Xbase/XAnnotations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xAnnotations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XAnnotationsPackage eINSTANCE = org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl <em>XAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotation()
	 * @generated
	 */
	int XANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Element Value Pairs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__ELEMENT_VALUE_PAIRS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__ANNOTATION_TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__VALUE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValuePairImpl <em>XAnnotation Element Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValuePairImpl
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationElementValuePair()
	 * @generated
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>XAnnotation Element Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl <em>XAnnotation Element Value Binary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationElementValueBinaryOperation()
	 * @generated
	 */
	int XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XAnnotation Element Value Binary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationValueArrayImpl <em>XAnnotation Value Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationValueArrayImpl
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationValueArray()
	 * @generated
	 */
	int XANNOTATION_VALUE_ARRAY = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_VALUE_ARRAY__VALUES = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XAnnotation Value Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_VALUE_ARRAY_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation <em>XAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
	 * @generated
	 */
	EClass getXAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getElementValuePairs <em>Element Value Pairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Value Pairs</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getElementValuePairs()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_ElementValuePairs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation Type</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_AnnotationType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getValue()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair <em>XAnnotation Element Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation Element Value Pair</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair
	 * @generated
	 */
	EClass getXAnnotationElementValuePair();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getValue()
	 * @see #getXAnnotationElementValuePair()
	 * @generated
	 */
	EReference getXAnnotationElementValuePair_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getElement()
	 * @see #getXAnnotationElementValuePair()
	 * @generated
	 */
	EReference getXAnnotationElementValuePair_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation <em>XAnnotation Element Value Binary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation Element Value Binary Operation</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation
	 * @generated
	 */
	EClass getXAnnotationElementValueBinaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getLeftOperand()
	 * @see #getXAnnotationElementValueBinaryOperation()
	 * @generated
	 */
	EReference getXAnnotationElementValueBinaryOperation_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getRightOperand()
	 * @see #getXAnnotationElementValueBinaryOperation()
	 * @generated
	 */
	EReference getXAnnotationElementValueBinaryOperation_RightOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getOperator()
	 * @see #getXAnnotationElementValueBinaryOperation()
	 * @generated
	 */
	EAttribute getXAnnotationElementValueBinaryOperation_Operator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray <em>XAnnotation Value Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation Value Array</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray
	 * @generated
	 */
	EClass getXAnnotationValueArray();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray#getValues()
	 * @see #getXAnnotationValueArray()
	 * @generated
	 */
	EReference getXAnnotationValueArray_Values();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XAnnotationsFactory getXAnnotationsFactory();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl <em>XAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotation()
		 * @generated
		 */
		EClass XANNOTATION = eINSTANCE.getXAnnotation();

		/**
		 * The meta object literal for the '<em><b>Element Value Pairs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__ELEMENT_VALUE_PAIRS = eINSTANCE.getXAnnotation_ElementValuePairs();

		/**
		 * The meta object literal for the '<em><b>Annotation Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__ANNOTATION_TYPE = eINSTANCE.getXAnnotation_AnnotationType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__VALUE = eINSTANCE.getXAnnotation_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValuePairImpl <em>XAnnotation Element Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValuePairImpl
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationElementValuePair()
		 * @generated
		 */
		EClass XANNOTATION_ELEMENT_VALUE_PAIR = eINSTANCE.getXAnnotationElementValuePair();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_PAIR__VALUE = eINSTANCE.getXAnnotationElementValuePair_Value();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT = eINSTANCE.getXAnnotationElementValuePair_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl <em>XAnnotation Element Value Binary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationElementValueBinaryOperation()
		 * @generated
		 */
		EClass XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION = eINSTANCE.getXAnnotationElementValueBinaryOperation();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND = eINSTANCE.getXAnnotationElementValueBinaryOperation_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND = eINSTANCE.getXAnnotationElementValueBinaryOperation_RightOperand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR = eINSTANCE.getXAnnotationElementValueBinaryOperation_Operator();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationValueArrayImpl <em>XAnnotation Value Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationValueArrayImpl
		 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl#getXAnnotationValueArray()
		 * @generated
		 */
		EClass XANNOTATION_VALUE_ARRAY = eINSTANCE.getXAnnotationValueArray();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_VALUE_ARRAY__VALUES = eINSTANCE.getXAnnotationValueArray_Values();

	}

} //XAnnotationsPackage
