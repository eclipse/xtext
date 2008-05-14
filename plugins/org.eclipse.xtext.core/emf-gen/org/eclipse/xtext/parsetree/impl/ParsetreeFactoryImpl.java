/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParsetreeFactoryImpl.java,v 1.1 2008/05/14 13:29:32 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParsetreeFactoryImpl extends EFactoryImpl implements ParsetreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParsetreeFactory init() {
		try {
			ParsetreeFactory theParsetreeFactory = (ParsetreeFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2008/xtext/parsetree"); 
			if (theParsetreeFactory != null) {
				return theParsetreeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParsetreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreeFactoryImpl() {
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
			case ParsetreePackage.PARSER_NODE: return createParserNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParserNode createParserNode() {
		ParserNodeImpl parserNode = new ParserNodeImpl();
		return parserNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreePackage getParsetreePackage() {
		return (ParsetreePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParsetreePackage getPackage() {
		return ParsetreePackage.eINSTANCE;
	}

} //ParsetreeFactoryImpl
