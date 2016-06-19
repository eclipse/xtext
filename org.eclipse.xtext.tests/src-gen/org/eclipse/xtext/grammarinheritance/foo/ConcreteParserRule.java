/**
 */
package org.eclipse.xtext.grammarinheritance.foo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.grammarinheritance.ametamodel.AType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getMagicNumber <em>Magic Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getConcreteParserRule()
 * @model
 * @generated
 */
public interface ConcreteParserRule extends RootRule
{
  /**
   * Returns the value of the '<em><b>Magic Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Magic Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Magic Number</em>' attribute.
   * @see #setMagicNumber(double)
   * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getConcreteParserRule_MagicNumber()
   * @model
   * @generated
   */
  double getMagicNumber();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getMagicNumber <em>Magic Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Magic Number</em>' attribute.
   * @see #getMagicNumber()
   * @generated
   */
  void setMagicNumber(double value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.grammarinheritance.ametamodel.AType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getConcreteParserRule_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AType> getElements();

} // ConcreteParserRule
