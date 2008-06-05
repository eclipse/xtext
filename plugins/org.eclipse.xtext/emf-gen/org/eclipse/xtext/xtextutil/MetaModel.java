/**
 * <copyright>
 * </copyright>
 *
 * $Id: MetaModel.java,v 1.12 2008/06/05 08:58:46 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractMetamodelDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel()
 * @model
 * @generated
 */
public interface MetaModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(AbstractMetamodelDeclaration)
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_Declaration()
	 * @model
	 * @generated
	 */
	AbstractMetamodelDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(AbstractMetamodelDeclaration value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtextutil.AbstractType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtextutil.AbstractType#getMetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_Types()
	 * @see org.eclipse.xtext.xtextutil.AbstractType#getMetaModel
	 * @model opposite="metaModel" containment="true"
	 * @generated
	 */
	EList<AbstractType> getTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='{return XtextutilUtil.alias((MetaModelImpl) this);}'"
	 * @generated
	 */
	String alias();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='{return XtextutilUtil.isGenerate((MetaModelImpl) this);}'"
	 * @generated
	 */
	boolean isGenerate();

} // MetaModel
