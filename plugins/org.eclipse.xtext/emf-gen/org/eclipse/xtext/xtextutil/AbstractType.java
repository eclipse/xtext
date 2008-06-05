/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractType.java,v 1.12 2008/06/05 08:58:46 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.AbstractType#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType()
 * @model abstract="true"
 * @generated
 */
public interface AbstractType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Meta Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtextutil.MetaModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model</em>' container reference.
	 * @see #setMetaModel(MetaModel)
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType_MetaModel()
	 * @see org.eclipse.xtext.xtextutil.MetaModel#getTypes
	 * @model opposite="types" transient="false"
	 * @generated
	 */
	MetaModel getMetaModel();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.AbstractType#getMetaModel <em>Meta Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model</em>' container reference.
	 * @see #getMetaModel()
	 * @generated
	 */
	void setMetaModel(MetaModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof ComplexTypeImpl) { return XtextutilUtil.getQualifiedName((ComplexTypeImpl) this);} else if (this instanceof DataTypeImpl) { return XtextutilUtil.getQualifiedName((DataTypeImpl) this);} else {return XtextutilUtil.getQualifiedName((AbstractTypeImpl) this);}'"
	 * @generated
	 */
	String getQualifiedName();

} // AbstractType
