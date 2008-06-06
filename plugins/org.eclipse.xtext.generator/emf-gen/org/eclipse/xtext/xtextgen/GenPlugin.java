/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenPlugin.java,v 1.1 2008/06/06 16:15:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Plugin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenPlugin#getBundleID <em>Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenPlugin()
 * @model
 * @generated
 */
public interface GenPlugin extends RootTemplate {
    /**
     * Returns the value of the '<em><b>Bundle ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bundle ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Bundle ID</em>' attribute.
     * @see #setBundleID(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenPlugin_BundleID()
     * @model
     * @generated
     */
    String getBundleID();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenPlugin#getBundleID <em>Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Bundle ID</em>' attribute.
     * @see #getBundleID()
     * @generated
     */
    void setBundleID(String value);

} // GenPlugin
