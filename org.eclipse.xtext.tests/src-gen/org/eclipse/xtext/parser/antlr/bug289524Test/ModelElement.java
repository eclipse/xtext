/**
 */
package org.eclipse.xtext.parser.antlr.bug289524Test;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524Test.ModelElement#getContainments <em>Containments</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524Test.ModelElement#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug289524Test.Bug289524TestPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Containments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug289524Test.Contained}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Containments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containments</em>' containment reference list.
   * @see org.eclipse.xtext.parser.antlr.bug289524Test.Bug289524TestPackage#getModelElement_Containments()
   * @model containment="true"
   * @generated
   */
  EList<Contained> getContainments();

  /**
   * Returns the value of the '<em><b>Refs</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug289524Test.Contained}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refs</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' reference list.
   * @see org.eclipse.xtext.parser.antlr.bug289524Test.Bug289524TestPackage#getModelElement_Refs()
   * @model
   * @generated
   */
  EList<Contained> getRefs();

} // ModelElement
