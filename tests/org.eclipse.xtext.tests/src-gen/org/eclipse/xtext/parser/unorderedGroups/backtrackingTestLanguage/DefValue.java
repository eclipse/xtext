/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Def Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getValueExpr <em>Value Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#isImmutable <em>Immutable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue()
 * @model
 * @generated
 */
public interface DefValue extends Expression
{
  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue_Final()
   * @model
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeRef)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue_Type()
   * @model containment="true"
   * @generated
   */
  TypeRef getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRef value);

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
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Expr</em>' containment reference.
   * @see #setValueExpr(Expression)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue_ValueExpr()
   * @model containment="true"
   * @generated
   */
  Expression getValueExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#getValueExpr <em>Value Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Expr</em>' containment reference.
   * @see #getValueExpr()
   * @generated
   */
  void setValueExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Immutable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Immutable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Immutable</em>' attribute.
   * @see #setImmutable(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getDefValue_Immutable()
   * @model
   * @generated
   */
  boolean isImmutable();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue#isImmutable <em>Immutable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Immutable</em>' attribute.
   * @see #isImmutable()
   * @generated
   */
  void setImmutable(boolean value);

} // DefValue
