/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenService.java,v 1.1 2008/06/06 16:15:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

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
 *   <li>{@link org.eclipse.xtext.xtextgen.GenService#getExtensionPointID <em>Extension Point ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenService()
 * @model
 * @generated
 */
public interface GenService extends GenClass {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='{return XtextgenUtil.serviceInterfaceName((GenServiceImpl) this);}'"
     * @generated
     */
    String serviceInterfaceName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='{return XtextgenUtil.extensionPointName((GenServiceImpl) this);}'"
     * @generated
     */
    String extensionPointName();

} // GenService
