/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Exclusion List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNodeExclusionList()
 * @model
 * @generated
 */
public interface NodeExclusionList extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.serializer.contextFinderTest.Model}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference list.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNodeExclusionList_Ref()
   * @model
   * @generated
   */
  EList<Model> getRef();

} // NodeExclusionList
