/**
 * <copyright>
 * </copyright>
 *
 * $Id: AModel.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.grammarinheritance.ametamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.ametamodel.AModel#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage#getAModel()
 * @model
 * @generated
 */
public interface AModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.grammarinheritance.ametamodel.AType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage#getAModel_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<AType> getElements();

} // AModel
