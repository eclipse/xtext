/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.FontLiteral#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isItalic <em>Italic</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isBold <em>Bold</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getFontLiteral()
 * @model
 * @generated
 */
public interface FontLiteral extends XExpression
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
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getFontLiteral_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Italic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Italic</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Italic</em>' attribute.
   * @see #setItalic(boolean)
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getFontLiteral_Italic()
   * @model
   * @generated
   */
  boolean isItalic();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isItalic <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Italic</em>' attribute.
   * @see #isItalic()
   * @generated
   */
  void setItalic(boolean value);

  /**
   * Returns the value of the '<em><b>Bold</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bold</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bold</em>' attribute.
   * @see #setBold(boolean)
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getFontLiteral_Bold()
   * @model
   * @generated
   */
  boolean isBold();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isBold <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bold</em>' attribute.
   * @see #isBold()
   * @generated
   */
  void setBold(boolean value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(boolean)
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getFontLiteral_Size()
   * @model
   * @generated
   */
  boolean isSize();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #isSize()
   * @generated
   */
  void setSize(boolean value);

} // FontLiteral
