/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextgenFactoryImpl.java,v 1.2 2008/06/09 12:52:54 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtextgen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextgenFactoryImpl extends EFactoryImpl implements XtextgenFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static XtextgenFactory init() {
        try {
            XtextgenFactory theXtextgenFactory = (XtextgenFactory)EPackage.Registry.INSTANCE.getEFactory("htpp://www.eclipse.org/xtext/2008/xtextgen"); 
            if (theXtextgenFactory != null) {
                return theXtextgenFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new XtextgenFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XtextgenFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case XtextgenPackage.GEN_SERVICE: return createGenService();
            case XtextgenPackage.GEN_MODEL: return createGenModel();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenService createGenService() {
        GenServiceImpl genService = new GenServiceImpl();
        return genService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenModel createGenModel() {
        GenModelImpl genModel = new GenModelImpl();
        return genModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XtextgenPackage getXtextgenPackage() {
        return (XtextgenPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static XtextgenPackage getPackage() {
        return XtextgenPackage.eINSTANCE;
    }

} //XtextgenFactoryImpl
