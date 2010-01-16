/**
 * <copyright>
 * </copyright>
 *
 * $Id: XbaseFactoryImpl.java,v 1.2 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbaseFactoryImpl extends EFactoryImpl implements XbaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XbaseFactory init() {
		try {
			XbaseFactory theXbaseFactory = (XbaseFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/Xbase"); 
			if (theXbaseFactory != null) {
				return theXbaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XbaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactoryImpl() {
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
			case XbasePackage.XFILE: return createXFile();
			case XbasePackage.XIMPORT: return createXImport();
			case XbasePackage.XFUNCTION: return createXFunction();
			case XbasePackage.XCLASS: return createXClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XFile createXFile() {
		XFileImpl xFile = new XFileImpl();
		return xFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImport createXImport() {
		XImportImpl xImport = new XImportImpl();
		return xImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XFunction createXFunction() {
		XFunctionImpl xFunction = new XFunctionImpl();
		return xFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XClass createXClass() {
		XClassImpl xClass = new XClassImpl();
		return xClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbasePackage getXbasePackage() {
		return (XbasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XbasePackage getPackage() {
		return XbasePackage.eINSTANCE;
	}

} //XbaseFactoryImpl
