/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParsingTestUtilPackage.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilFactory
 * @model kind="package"
 * @generated
 */
public interface PartialParsingTestUtilPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "partialParsingTestUtil";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/PartialParsingTestUtil";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "partialParsingTestUtil";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PartialParsingTestUtilPackage eINSTANCE = org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerManyChildrenImpl <em>Cross Resource Container Many Children</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerManyChildrenImpl
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilPackageImpl#getCrossResourceContainerManyChildren()
	 * @generated
	 */
	int CROSS_RESOURCE_CONTAINER_MANY_CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Cross Resource Container Many Children</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_RESOURCE_CONTAINER_MANY_CHILDREN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerOneChildImpl <em>Cross Resource Container One Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerOneChildImpl
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilPackageImpl#getCrossResourceContainerOneChild()
	 * @generated
	 */
	int CROSS_RESOURCE_CONTAINER_ONE_CHILD = 1;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD = 0;

	/**
	 * The number of structural features of the '<em>Cross Resource Container One Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_RESOURCE_CONTAINER_ONE_CHILD_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren <em>Cross Resource Container Many Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Resource Container Many Children</em>'.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren
	 * @generated
	 */
	EClass getCrossResourceContainerManyChildren();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren#getChildren()
	 * @see #getCrossResourceContainerManyChildren()
	 * @generated
	 */
	EReference getCrossResourceContainerManyChildren_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild <em>Cross Resource Container One Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Resource Container One Child</em>'.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild
	 * @generated
	 */
	EClass getCrossResourceContainerOneChild();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild#getChild()
	 * @see #getCrossResourceContainerOneChild()
	 * @generated
	 */
	EReference getCrossResourceContainerOneChild_Child();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PartialParsingTestUtilFactory getPartialParsingTestUtilFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerManyChildrenImpl <em>Cross Resource Container Many Children</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerManyChildrenImpl
		 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilPackageImpl#getCrossResourceContainerManyChildren()
		 * @generated
		 */
		EClass CROSS_RESOURCE_CONTAINER_MANY_CHILDREN = eINSTANCE.getCrossResourceContainerManyChildren();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN = eINSTANCE.getCrossResourceContainerManyChildren_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerOneChildImpl <em>Cross Resource Container One Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerOneChildImpl
		 * @see org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilPackageImpl#getCrossResourceContainerOneChild()
		 * @generated
		 */
		EClass CROSS_RESOURCE_CONTAINER_ONE_CHILD = eINSTANCE.getCrossResourceContainerOneChild();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD = eINSTANCE.getCrossResourceContainerOneChild_Child();

	}

} //PartialParsingTestUtilPackage
