/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitleImage <em>Title Image</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getSections <em>Sections</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView()
 * @model
 * @generated
 */
public interface TableView extends EObject
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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(Parameter)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_Content()
   * @model containment="true"
   * @generated
   */
  Parameter getContent();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(Parameter value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' containment reference.
   * @see #setTitle(ScalarExpression)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_Title()
   * @model containment="true"
   * @generated
   */
  ScalarExpression getTitle();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitle <em>Title</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' containment reference.
   * @see #getTitle()
   * @generated
   */
  void setTitle(ScalarExpression value);

  /**
   * Returns the value of the '<em><b>Title Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title Image</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title Image</em>' containment reference.
   * @see #setTitleImage(ScalarExpression)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_TitleImage()
   * @model containment="true"
   * @generated
   */
  ScalarExpression getTitleImage();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitleImage <em>Title Image</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title Image</em>' containment reference.
   * @see #getTitleImage()
   * @generated
   */
  void setTitleImage(ScalarExpression value);

  /**
   * Returns the value of the '<em><b>Style</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Style</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Style</em>' attribute.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle
   * @see #setStyle(TableViewStyle)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_Style()
   * @model
   * @generated
   */
  TableViewStyle getStyle();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getStyle <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Style</em>' attribute.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle
   * @see #getStyle()
   * @generated
   */
  void setStyle(TableViewStyle value);

  /**
   * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sections</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getTableView_Sections()
   * @model containment="true"
   * @generated
   */
  EList<Section> getSections();

} // TableView
