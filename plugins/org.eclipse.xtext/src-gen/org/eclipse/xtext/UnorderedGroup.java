/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unordered Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.UnorderedGroup#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getUnorderedGroup()
 * @model
 * @generated
 */
public interface UnorderedGroup extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.XtextPackage#getUnorderedGroup_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getElements();

} // UnorderedGroup
