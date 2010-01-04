/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.domainmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.Reference#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends StructuralFeature
{
  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #setOpposite(Reference)
   * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getReference_Opposite()
   * @model
   * @generated
   */
  Reference getOpposite();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.domainmodel.Reference#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(Reference value);

} // Reference
