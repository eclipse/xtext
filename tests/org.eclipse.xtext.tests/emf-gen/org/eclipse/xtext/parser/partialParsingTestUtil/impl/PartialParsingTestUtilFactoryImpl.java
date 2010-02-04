/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParsingTestUtilFactoryImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.partialParsingTestUtil.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialParsingTestUtilFactoryImpl extends EFactoryImpl implements PartialParsingTestUtilFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PartialParsingTestUtilFactory init() {
		try {
			PartialParsingTestUtilFactory thePartialParsingTestUtilFactory = (PartialParsingTestUtilFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/PartialParsingTestUtil"); 
			if (thePartialParsingTestUtilFactory != null) {
				return thePartialParsingTestUtilFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PartialParsingTestUtilFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialParsingTestUtilFactoryImpl() {
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN: return createCrossResourceContainerManyChildren();
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD: return createCrossResourceContainerOneChild();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossResourceContainerManyChildren createCrossResourceContainerManyChildren() {
		CrossResourceContainerManyChildrenImpl crossResourceContainerManyChildren = new CrossResourceContainerManyChildrenImpl();
		return crossResourceContainerManyChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossResourceContainerOneChild createCrossResourceContainerOneChild() {
		CrossResourceContainerOneChildImpl crossResourceContainerOneChild = new CrossResourceContainerOneChildImpl();
		return crossResourceContainerOneChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialParsingTestUtilPackage getPartialParsingTestUtilPackage() {
		return (PartialParsingTestUtilPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PartialParsingTestUtilPackage getPackage() {
		return PartialParsingTestUtilPackage.eINSTANCE;
	}

} //PartialParsingTestUtilFactoryImpl
