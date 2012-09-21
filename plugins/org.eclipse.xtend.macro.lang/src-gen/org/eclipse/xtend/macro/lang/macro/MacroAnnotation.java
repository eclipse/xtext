/**
 */
package org.eclipse.xtend.macro.lang.macro;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getMacroAnnotation()
 * @model
 * @generated
 */
public interface MacroAnnotation extends XtendTypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Target Type</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.xtend.macro.lang.macro.TargetType}.
   * The literals are from the enumeration {@link org.eclipse.xtend.macro.lang.macro.TargetType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Type</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Type</em>' attribute list.
   * @see org.eclipse.xtend.macro.lang.macro.TargetType
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getMacroAnnotation_TargetType()
   * @model unique="false"
   * @generated
   */
  EList<TargetType> getTargetType();

  /**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtend.core.xtend.XtendMember}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getMacroAnnotation_Members()
   * @model containment="true"
   * @generated
   */
  EList<XtendMember> getMembers();

} // MacroAnnotation
