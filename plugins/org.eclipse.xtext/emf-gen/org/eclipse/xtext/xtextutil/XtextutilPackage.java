/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextutilPackage.java,v 1.13 2008/08/07 15:05:36 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.xtext.xtextutil.XtextutilFactory
 * @model kind="package"
 * @generated
 */
public interface XtextutilPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtextutil";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/2008/Xtext/Utilities";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtextutil";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtextutilPackage eINSTANCE = org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl
	 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getAbstractType()
	 * @generated
	 */
	int ABSTRACT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Meta Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__META_MODEL = 1;

	/**
	 * The number of structural features of the '<em>Abstract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtextutil.impl.ComplexTypeImpl
	 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getComplexType()
	 * @generated
	 */
	int COMPLEX_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Meta Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__META_MODEL = ABSTRACT_TYPE__META_MODEL;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__SUPER_TYPES = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__FEATURES = ABSTRACT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__ABSTRACT = ABSTRACT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl <em>Meta Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtextutil.impl.MetaModelImpl
	 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getMetaModel()
	 * @generated
	 */
	int META_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__TYPES = 1;

	/**
	 * The number of structural features of the '<em>Meta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtextutil.impl.DataTypeImpl
	 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Meta Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__META_MODEL = ABSTRACT_TYPE__META_MODEL;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtextutil.impl.FeatureImpl
	 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__LOWER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__UPPER_BOUND = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTAINMENT = 4;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type</em>'.
	 * @see org.eclipse.xtext.xtextutil.ComplexType
	 * @generated
	 */
	EClass getComplexType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextutil.ComplexType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Types</em>'.
	 * @see org.eclipse.xtext.xtextutil.ComplexType#getSuperTypes()
	 * @see #getComplexType()
	 * @generated
	 */
	EReference getComplexType_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextutil.ComplexType#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.eclipse.xtext.xtextutil.ComplexType#getFeatures()
	 * @see #getComplexType()
	 * @generated
	 */
	EReference getComplexType_Features();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.ComplexType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.xtextutil.ComplexType#isAbstract()
	 * @see #getComplexType()
	 * @generated
	 */
	EAttribute getComplexType_Abstract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.MetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model</em>'.
	 * @see org.eclipse.xtext.xtextutil.MetaModel
	 * @generated
	 */
	EClass getMetaModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipse.xtext.xtextutil.MetaModel#getDeclaration()
	 * @see #getMetaModel()
	 * @generated
	 */
	EReference getMetaModel_Declaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextutil.MetaModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.xtext.xtextutil.MetaModel#getTypes()
	 * @see #getMetaModel()
	 * @generated
	 */
	EReference getMetaModel_Types();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Type</em>'.
	 * @see org.eclipse.xtext.xtextutil.AbstractType
	 * @generated
	 */
	EClass getAbstractType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtextutil.AbstractType#getName()
	 * @see #getAbstractType()
	 * @generated
	 */
	EAttribute getAbstractType_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.xtextutil.AbstractType#getMetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Meta Model</em>'.
	 * @see org.eclipse.xtext.xtextutil.AbstractType#getMetaModel()
	 * @see #getAbstractType()
	 * @generated
	 */
	EReference getAbstractType_MetaModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.xtext.xtextutil.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.Feature#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature#getLowerBound()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.Feature#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature#getUpperBound()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.Feature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature#getType()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.Feature#isContainment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Containment</em>'.
	 * @see org.eclipse.xtext.xtextutil.Feature#isContainment()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Containment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtextutilFactory getXtextutilFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtextutil.impl.ComplexTypeImpl
		 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getComplexType()
		 * @generated
		 */
		EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_TYPE__SUPER_TYPES = eINSTANCE.getComplexType_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_TYPE__FEATURES = eINSTANCE.getComplexType_Features();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX_TYPE__ABSTRACT = eINSTANCE.getComplexType_Abstract();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl <em>Meta Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtextutil.impl.MetaModelImpl
		 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getMetaModel()
		 * @generated
		 */
		EClass META_MODEL = eINSTANCE.getMetaModel();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_MODEL__DECLARATION = eINSTANCE.getMetaModel_Declaration();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_MODEL__TYPES = eINSTANCE.getMetaModel_Types();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl
		 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getAbstractType()
		 * @generated
		 */
		EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TYPE__NAME = eINSTANCE.getAbstractType_Name();

		/**
		 * The meta object literal for the '<em><b>Meta Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TYPE__META_MODEL = eINSTANCE.getAbstractType_MetaModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtextutil.impl.DataTypeImpl
		 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtextutil.impl.FeatureImpl
		 * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__LOWER_BOUND = eINSTANCE.getFeature_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__UPPER_BOUND = eINSTANCE.getFeature_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__TYPE = eINSTANCE.getFeature_Type();

		/**
		 * The meta object literal for the '<em><b>Containment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__CONTAINMENT = eINSTANCE.getFeature_Containment();

	}

} //XtextutilPackage
