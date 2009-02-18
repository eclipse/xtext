/**
 * <copyright>
 * </copyright>
 *
 * $Id: Model.java,v 1.2 2009/02/18 21:22:33 sefftinge Exp $
 */
package baseInheritanceTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link baseInheritanceTest.Model#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see baseInheritanceTest.BaseInheritanceTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
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
   * @see baseInheritanceTest.BaseInheritanceTestPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link baseInheritanceTest.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Model
