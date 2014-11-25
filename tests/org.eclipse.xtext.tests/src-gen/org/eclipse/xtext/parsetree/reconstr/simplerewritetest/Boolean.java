/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#isBool <em>Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getBoolean()
 * @model
 * @generated
 */
public interface Boolean extends Expression
{
  /**
   * Returns the value of the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool</em>' attribute.
   * @see #setBool(boolean)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getBoolean_Bool()
   * @model
   * @generated
   */
  boolean isBool();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#isBool <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool</em>' attribute.
   * @see #isBool()
   * @generated
   */
  void setBool(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getBoolean_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Boolean
