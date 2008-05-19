/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResolvedType.java,v 1.6 2008/05/19 10:08:41 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolved Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.ResolvedType#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getResolvedType()
 * @model
 * @generated
 */
public interface ResolvedType extends AbstractType
{
  /**
   * Returns the value of the '<em><b>Meta Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta Model</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Meta Model</em>' reference.
   * @see #setMetaModel(MetaModel)
   * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getResolvedType_MetaModel()
   * @model
   * @generated
   */
  MetaModel getMetaModel();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextutil.ResolvedType#getMetaModel <em>Meta Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Meta Model</em>' reference.
   * @see #getMetaModel()
   * @generated
   */
  void setMetaModel(MetaModel value);

} // ResolvedType
