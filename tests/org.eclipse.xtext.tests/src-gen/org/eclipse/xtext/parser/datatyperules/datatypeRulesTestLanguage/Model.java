/**
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getVector <em>Vector</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDots <em>Dots</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDouble <em>Double</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(BigDecimal)
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel_Value()
   * @model
   * @generated
   */
  BigDecimal getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Vector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vector</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vector</em>' attribute.
   * @see #setVector(String)
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel_Vector()
   * @model
   * @generated
   */
  String getVector();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getVector <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vector</em>' attribute.
   * @see #getVector()
   * @generated
   */
  void setVector(String value);

  /**
   * Returns the value of the '<em><b>Dots</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dots</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dots</em>' attribute.
   * @see #setDots(String)
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel_Dots()
   * @model
   * @generated
   */
  String getDots();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDots <em>Dots</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dots</em>' attribute.
   * @see #getDots()
   * @generated
   */
  void setDots(String value);

  /**
   * Returns the value of the '<em><b>Double</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Double</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Double</em>' attribute.
   * @see #setDouble(double)
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getModel_Double()
   * @model
   * @generated
   */
  double getDouble();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDouble <em>Double</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Double</em>' attribute.
   * @see #getDouble()
   * @generated
   */
  void setDouble(double value);

} // Model
