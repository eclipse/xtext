/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenClassImpl.java,v 1.1 2008/06/06 16:15:42 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextgen.GenClass;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenClassImpl#getGenClassFQName <em>Gen Class FQ Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenClassImpl extends RootTemplateImpl implements GenClass {
    /**
     * The default value of the '{@link #getGenClassFQName() <em>Gen Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenClassFQName()
     * @generated
     * @ordered
     */
    protected static final String GEN_CLASS_FQ_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGenClassFQName() <em>Gen Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenClassFQName()
     * @generated
     * @ordered
     */
    protected String genClassFQName = GEN_CLASS_FQ_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenClassImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XtextgenPackage.Literals.GEN_CLASS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getGenClassFQName() {
        return genClassFQName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGenClassFQName(String newGenClassFQName) {
        String oldGenClassFQName = genClassFQName;
        genClassFQName = newGenClassFQName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_CLASS__GEN_CLASS_FQ_NAME, oldGenClassFQName, genClassFQName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String genClassPackageFQName() {
        if (this instanceof GenServiceImpl) { return XtextgenUtil.genClassPackageFQName((GenServiceImpl) this);} else {return XtextgenUtil.genClassPackageFQName((GenClassImpl) this);}
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String genClassName() {
        if (this instanceof GenServiceImpl) { return XtextgenUtil.genClassName((GenServiceImpl) this);} else {return XtextgenUtil.genClassName((GenClassImpl) this);}
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XtextgenPackage.GEN_CLASS__GEN_CLASS_FQ_NAME:
                return getGenClassFQName();
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
            case XtextgenPackage.GEN_CLASS__GEN_CLASS_FQ_NAME:
                setGenClassFQName((String)newValue);
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
            case XtextgenPackage.GEN_CLASS__GEN_CLASS_FQ_NAME:
                setGenClassFQName(GEN_CLASS_FQ_NAME_EDEFAULT);
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
            case XtextgenPackage.GEN_CLASS__GEN_CLASS_FQ_NAME:
                return GEN_CLASS_FQ_NAME_EDEFAULT == null ? genClassFQName != null : !GEN_CLASS_FQ_NAME_EDEFAULT.equals(genClassFQName);
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
        result.append(" (genClassFQName: ");
        result.append(genClassFQName);
        result.append(')');
        return result.toString();
    }

} //GenClassImpl
