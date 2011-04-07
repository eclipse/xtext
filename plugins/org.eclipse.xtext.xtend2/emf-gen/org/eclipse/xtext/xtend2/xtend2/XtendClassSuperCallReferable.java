/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Class Super Call Referable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable#getXtendClass <em>Xtend Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClassSuperCallReferable()
 * @model
 * @generated
 */
public interface XtendClassSuperCallReferable extends JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Xtend Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperCallReferable <em>Super Call Referable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xtend Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xtend Class</em>' container reference.
	 * @see #setXtendClass(XtendClass)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClassSuperCallReferable_XtendClass()
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperCallReferable
	 * @model opposite="superCallReferable"
	 * @generated
	 */
	XtendClass getXtendClass();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable#getXtendClass <em>Xtend Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xtend Class</em>' container reference.
	 * @see #getXtendClass()
	 * @generated
	 */
	void setXtendClass(XtendClass value);

} // XtendClassSuperCallReferable
