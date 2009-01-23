/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenService.java,v 1.6 2009/01/23 14:12:00 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getServiceInterfaceFQName <em>Service Interface FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getGenClassFQName <em>Gen Class FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getExtensionPointID <em>Extension Point ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#isUiService <em>Ui Service</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getGenParameters <em>Gen Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getPluginDependencies <em>Plugin Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService()
 * @model
 * @generated
 */
public interface GenService extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Interface FQ Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Interface FQ Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Interface FQ Name</em>' attribute.
	 * @see #setServiceInterfaceFQName(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_ServiceInterfaceFQName()
	 * @model
	 * @generated
	 */
	String getServiceInterfaceFQName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getServiceInterfaceFQName <em>Service Interface FQ Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Interface FQ Name</em>' attribute.
	 * @see #getServiceInterfaceFQName()
	 * @generated
	 */
	void setServiceInterfaceFQName(String value);

	/**
	 * Returns the value of the '<em><b>Gen Class FQ Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Class FQ Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Class FQ Name</em>' attribute.
	 * @see #setGenClassFQName(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_GenClassFQName()
	 * @model
	 * @generated
	 */
	String getGenClassFQName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getGenClassFQName <em>Gen Class FQ Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Class FQ Name</em>' attribute.
	 * @see #getGenClassFQName()
	 * @generated
	 */
	void setGenClassFQName(String value);

	/**
	 * Returns the value of the '<em><b>Extension Point ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Point ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Point ID</em>' attribute.
	 * @see #setExtensionPointID(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_ExtensionPointID()
	 * @model
	 * @generated
	 */
	String getExtensionPointID();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getExtensionPointID <em>Extension Point ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Point ID</em>' attribute.
	 * @see #getExtensionPointID()
	 * @generated
	 */
	void setExtensionPointID(String value);

	/**
	 * Returns the value of the '<em><b>Template Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Path</em>' attribute.
	 * @see #isSetTemplatePath()
	 * @see #unsetTemplatePath()
	 * @see #setTemplatePath(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_TemplatePath()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTemplatePath();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getTemplatePath <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Path</em>' attribute.
	 * @see #isSetTemplatePath()
	 * @see #unsetTemplatePath()
	 * @see #getTemplatePath()
	 * @generated
	 */
	void setTemplatePath(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getTemplatePath <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplatePath()
	 * @see #getTemplatePath()
	 * @see #setTemplatePath(String)
	 * @generated
	 */
	void unsetTemplatePath();

	/**
	 * Returns whether the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getTemplatePath <em>Template Path</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template Path</em>' attribute is set.
	 * @see #unsetTemplatePath()
	 * @see #getTemplatePath()
	 * @see #setTemplatePath(String)
	 * @generated
	 */
	boolean isSetTemplatePath();

	/**
	 * Returns the value of the '<em><b>Gen Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Parameters</em>' attribute.
	 * @see #setGenParameters(Map)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_GenParameters()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, String> getGenParameters();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#getGenParameters <em>Gen Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Parameters</em>' attribute.
	 * @see #getGenParameters()
	 * @generated
	 */
	void setGenParameters(Map<String, String> value);

	/**
	 * Returns the value of the '<em><b>Plugin Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtextgen.PluginDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Dependencies</em>' containment reference list.
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_PluginDependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<PluginDependency> getPluginDependencies();

	/**
	 * Returns the value of the '<em><b>Ui Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Service</em>' attribute.
	 * @see #setUiService(boolean)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService_UiService()
	 * @model
	 * @generated
	 */
	boolean isUiService();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenService#isUiService <em>Ui Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ui Service</em>' attribute.
	 * @see #isUiService()
	 * @generated
	 */
	void setUiService(boolean value);

} // GenService
