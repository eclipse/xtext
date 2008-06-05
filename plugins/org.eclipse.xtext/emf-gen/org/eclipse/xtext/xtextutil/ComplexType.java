/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComplexType.java,v 1.2 2008/06/05 08:58:46 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.ComplexType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.ComplexType#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.ComplexType#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getComplexType()
 * @model
 * @generated
 */
public interface ComplexType extends AbstractType {
	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtextutil.ComplexType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getComplexType_SuperTypes()
	 * @model
	 * @generated
	 */
	EList<ComplexType> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtextutil.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getComplexType_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

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
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getComplexType_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.ComplexType#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // ComplexType
