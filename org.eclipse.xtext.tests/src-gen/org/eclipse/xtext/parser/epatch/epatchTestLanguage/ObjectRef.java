/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftRes <em>Left Res</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftFrag <em>Left Frag</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightRes <em>Right Res</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightFrag <em>Right Frag</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightMig <em>Right Mig</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef()
 * @model
 * @generated
 */
public interface ObjectRef extends NamedObject
{
  /**
   * Returns the value of the '<em><b>Left Res</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Res</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Res</em>' reference.
   * @see #setLeftRes(NamedResource)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef_LeftRes()
   * @model
   * @generated
   */
  NamedResource getLeftRes();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftRes <em>Left Res</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Res</em>' reference.
   * @see #getLeftRes()
   * @generated
   */
  void setLeftRes(NamedResource value);

  /**
   * Returns the value of the '<em><b>Left Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Frag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Frag</em>' attribute.
   * @see #setLeftFrag(String)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef_LeftFrag()
   * @model
   * @generated
   */
  String getLeftFrag();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftFrag <em>Left Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Frag</em>' attribute.
   * @see #getLeftFrag()
   * @generated
   */
  void setLeftFrag(String value);

  /**
   * Returns the value of the '<em><b>Right Res</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Res</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Res</em>' reference.
   * @see #setRightRes(NamedResource)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef_RightRes()
   * @model
   * @generated
   */
  NamedResource getRightRes();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightRes <em>Right Res</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Res</em>' reference.
   * @see #getRightRes()
   * @generated
   */
  void setRightRes(NamedResource value);

  /**
   * Returns the value of the '<em><b>Right Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Frag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Frag</em>' attribute.
   * @see #setRightFrag(String)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef_RightFrag()
   * @model
   * @generated
   */
  String getRightFrag();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightFrag <em>Right Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Frag</em>' attribute.
   * @see #getRightFrag()
   * @generated
   */
  void setRightFrag(String value);

  /**
   * Returns the value of the '<em><b>Right Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Mig</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Mig</em>' containment reference.
   * @see #setRightMig(Migration)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectRef_RightMig()
   * @model containment="true"
   * @generated
   */
  Migration getRightMig();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightMig <em>Right Mig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Mig</em>' containment reference.
   * @see #getRightMig()
   * @generated
   */
  void setRightMig(Migration value);

} // ObjectRef
