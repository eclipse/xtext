/**
 * <copyright>
 * </copyright>
 *
 * $Id: RootTemplateImpl.java,v 1.1 2008/06/06 16:15:42 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;

import org.eclipse.xtext.xtextgen.RootTemplate;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.RootTemplateImpl#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.RootTemplateImpl#getGenParameters <em>Gen Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootTemplateImpl extends EObjectImpl implements RootTemplate {
    /**
     * The default value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplatePath()
     * @generated
     * @ordered
     */
    protected static final String TEMPLATE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplatePath()
     * @generated
     * @ordered
     */
    protected String templatePath = TEMPLATE_PATH_EDEFAULT;

    /**
     * This is true if the Template Path attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean templatePathESet;

    /**
     * The cached value of the '{@link #getGenParameters() <em>Gen Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenParameters()
     * @generated
     * @ordered
     */
    protected EMap<String, String> genParameters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RootTemplateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XtextgenPackage.Literals.ROOT_TEMPLATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTemplatePath() {
        return templatePath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTemplatePath(String newTemplatePath) {
        String oldTemplatePath = templatePath;
        templatePath = newTemplatePath;
        boolean oldTemplatePathESet = templatePathESet;
        templatePathESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH, oldTemplatePath, templatePath, !oldTemplatePathESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetTemplatePath() {
        String oldTemplatePath = templatePath;
        boolean oldTemplatePathESet = templatePathESet;
        templatePath = TEMPLATE_PATH_EDEFAULT;
        templatePathESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH, oldTemplatePath, TEMPLATE_PATH_EDEFAULT, oldTemplatePathESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetTemplatePath() {
        return templatePathESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getGenParameters() {
        if (genParameters == null) {
            genParameters = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, XtextgenPackage.ROOT_TEMPLATE__GEN_PARAMETERS);
        }
        return genParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH:
                return getTemplatePath();
            case XtextgenPackage.ROOT_TEMPLATE__GEN_PARAMETERS:
                if (coreType) return getGenParameters();
                else return getGenParameters().map();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH:
                setTemplatePath((String)newValue);
                return;
            case XtextgenPackage.ROOT_TEMPLATE__GEN_PARAMETERS:
                ((EStructuralFeature.Setting)getGenParameters()).set(newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH:
                unsetTemplatePath();
                return;
            case XtextgenPackage.ROOT_TEMPLATE__GEN_PARAMETERS:
                getGenParameters().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case XtextgenPackage.ROOT_TEMPLATE__TEMPLATE_PATH:
                return isSetTemplatePath();
            case XtextgenPackage.ROOT_TEMPLATE__GEN_PARAMETERS:
                return genParameters != null && !genParameters.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (templatePath: ");
        if (templatePathESet) result.append(templatePath); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //RootTemplateImpl
