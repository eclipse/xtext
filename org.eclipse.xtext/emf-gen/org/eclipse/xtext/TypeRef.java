/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.TypeRef#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.xtext.TypeRef#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(AbstractMetamodelDeclaration)
	 * @see org.eclipse.xtext.XtextPackage#getTypeRef_Metamodel()
	 * @model
	 * @generated
	 */
	AbstractMetamodelDeclaration getMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.TypeRef#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(AbstractMetamodelDeclaration value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(EClassifier)
	 * @see org.eclipse.xtext.XtextPackage#getTypeRef_Classifier()
	 * @model
	 * @generated
	 */
	EClassifier getClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.TypeRef#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(EClassifier value);

} // TypeRef
