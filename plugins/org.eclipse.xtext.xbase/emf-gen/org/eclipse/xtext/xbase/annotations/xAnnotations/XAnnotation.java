/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmAnnotationType;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getElementValuePairs <em>Element Value Pairs</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation()
 * @model
 * @generated
 */
public interface XAnnotation extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Element Value Pairs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Value Pairs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Value Pairs</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_ElementValuePairs()
	 * @model containment="true"
	 * @generated
	 */
	EList<XAnnotationElementValuePair> getElementValuePairs();

	/**
	 * Returns the value of the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type</em>' reference.
	 * @see #setAnnotationType(JvmAnnotationType)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_AnnotationType()
	 * @model
	 * @generated
	 */
	JvmAnnotationType getAnnotationType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Type</em>' reference.
	 * @see #getAnnotationType()
	 * @generated
	 */
	void setAnnotationType(JvmAnnotationType value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getValues();

} // XAnnotation
