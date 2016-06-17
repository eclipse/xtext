/**
 */
package org.eclipse.xtext.parsetree.impl.commentAssociation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.commentAssociation.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.commentAssociation.Element#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.impl.commentAssociation.CommentAssociationPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
{
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
   * @see org.eclipse.xtext.parsetree.impl.commentAssociation.CommentAssociationPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.impl.commentAssociation.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference.
   * @see #setChild(Element)
   * @see org.eclipse.xtext.parsetree.impl.commentAssociation.CommentAssociationPackage#getElement_Child()
   * @model containment="true"
   * @generated
   */
  Element getChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.impl.commentAssociation.Element#getChild <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child</em>' containment reference.
   * @see #getChild()
   * @generated
   */
  void setChild(Element value);

} // Element
