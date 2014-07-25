/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prefixed Unassigned</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.PrefixedUnassigned#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.FormattertestlanguagePackage#getPrefixedUnassigned()
 * @model
 * @generated
 */
public interface PrefixedUnassigned extends Root
{
  /**
   * Returns the value of the '<em><b>Delegate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delegate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delegate</em>' containment reference.
   * @see #setDelegate(PrefixedDelegate)
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.FormattertestlanguagePackage#getPrefixedUnassigned_Delegate()
   * @model containment="true"
   * @generated
   */
  PrefixedDelegate getDelegate();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.PrefixedUnassigned#getDelegate <em>Delegate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delegate</em>' containment reference.
   * @see #getDelegate()
   * @generated
   */
  void setDelegate(PrefixedDelegate value);

} // PrefixedUnassigned
