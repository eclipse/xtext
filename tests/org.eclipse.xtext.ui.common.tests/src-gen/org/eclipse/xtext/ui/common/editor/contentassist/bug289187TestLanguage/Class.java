/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getImplementedInterfaces <em>Implemented Interfaces</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getClassNumber <em>Class Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getQuid <em>Quid</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EObject
{
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transient</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transient</em>' attribute.
   * @see #setTransient(boolean)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Transient()
   * @model
   * @generated
   */
  boolean isTransient();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#isTransient <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transient</em>' attribute.
   * @see #isTransient()
   * @generated
   */
  void setTransient(boolean value);

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
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Class</em>' reference.
   * @see #setSuperClass(Class)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_SuperClass()
   * @model
   * @generated
   */
  Class getSuperClass();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getSuperClass <em>Super Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Class</em>' reference.
   * @see #getSuperClass()
   * @generated
   */
  void setSuperClass(Class value);

  /**
   * Returns the value of the '<em><b>Implemented Interfaces</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implemented Interfaces</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implemented Interfaces</em>' reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_ImplementedInterfaces()
   * @model
   * @generated
   */
  EList<Class> getImplementedInterfaces();

  /**
   * Returns the value of the '<em><b>Class Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Number</em>' attribute.
   * @see #setClassNumber(int)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_ClassNumber()
   * @model
   * @generated
   */
  int getClassNumber();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getClassNumber <em>Class Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Number</em>' attribute.
   * @see #getClassNumber()
   * @generated
   */
  void setClassNumber(int value);

  /**
   * Returns the value of the '<em><b>Quid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quid</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quid</em>' attribute.
   * @see #setQuid(int)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Quid()
   * @model
   * @generated
   */
  int getQuid();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getQuid <em>Quid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quid</em>' attribute.
   * @see #getQuid()
   * @generated
   */
  void setQuid(int value);

  /**
   * Returns the value of the '<em><b>Documentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' attribute.
   * @see #setDocumentation(String)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Documentation()
   * @model
   * @generated
   */
  String getDocumentation();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Class#getDocumentation <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' attribute.
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(String value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Operation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage#getClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<Operation> getOperations();

} // Class
