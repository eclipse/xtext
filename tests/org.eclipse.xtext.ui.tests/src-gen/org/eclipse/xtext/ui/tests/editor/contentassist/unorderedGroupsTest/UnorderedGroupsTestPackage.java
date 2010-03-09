/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestFactory
 * @model kind="package"
 * @generated
 */
public interface UnorderedGroupsTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unorderedGroupsTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/tests/2010/UnorderedGroupsTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unorderedGroupsTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnorderedGroupsTestPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SECOND = 1;

  /**
   * The feature id for the '<em><b>Thrird</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__THRIRD = 2;

  /**
   * The feature id for the '<em><b>Forth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FORTH = 3;

  /**
   * The feature id for the '<em><b>Fifth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIFTH = 4;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODEL = 5;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.SimpleModelImpl <em>Simple Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.SimpleModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getSimpleModel()
   * @generated
   */
  int SIMPLE_MODEL = 1;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Simple Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.MandatoryModelImpl <em>Mandatory Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.MandatoryModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getMandatoryModel()
   * @generated
   */
  int MANDATORY_MODEL = 2;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Mandatory Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANDATORY_MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedModelImpl <em>Looped Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getLoopedModel()
   * @generated
   */
  int LOOPED_MODEL = 3;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Looped Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.GroupLoopedModelImpl <em>Group Looped Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.GroupLoopedModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getGroupLoopedModel()
   * @generated
   */
  int GROUP_LOOPED_MODEL = 4;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Group Looped Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_LOOPED_MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedAlternativeModelImpl <em>Looped Alternative Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedAlternativeModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getLoopedAlternativeModel()
   * @generated
   */
  int LOOPED_ALTERNATIVE_MODEL = 5;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Looped Alternative Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPED_ALTERNATIVE_MODEL_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl <em>Bug304681 Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Model()
   * @generated
   */
  int BUG304681_MODEL = 6;

  /**
   * The feature id for the '<em><b>Short Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL__SHORT_DESCRIPTION = 0;

  /**
   * The feature id for the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL__LONG_DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Uid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL__UID = 2;

  /**
   * The feature id for the '<em><b>Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL__FLAG = 3;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL__FEATURES = 4;

  /**
   * The number of structural features of the '<em>Bug304681 Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_MODEL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681FeatureImpl <em>Bug304681 Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681FeatureImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Feature()
   * @generated
   */
  int BUG304681_FEATURE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_FEATURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Bug304681 Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681AttributeImpl <em>Bug304681 Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681AttributeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Attribute()
   * @generated
   */
  int BUG304681_ATTRIBUTE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_ATTRIBUTE__NAME = BUG304681_FEATURE__NAME;

  /**
   * The number of structural features of the '<em>Bug304681 Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_ATTRIBUTE_FEATURE_COUNT = BUG304681_FEATURE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ReferenceImpl <em>Bug304681 Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ReferenceImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Reference()
   * @generated
   */
  int BUG304681_REFERENCE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_REFERENCE__NAME = BUG304681_FEATURE__NAME;

  /**
   * The number of structural features of the '<em>Bug304681 Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG304681_REFERENCE_FEATURE_COUNT = BUG304681_FEATURE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFirst()
   * @see #getModel()
   * @generated
   */
  EReference getModel_First();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getSecond()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Second();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getThrird <em>Thrird</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Thrird</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getThrird()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Thrird();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getForth <em>Forth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Forth</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getForth()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Forth();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFifth <em>Fifth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fifth</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFifth()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Fifth();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getModel()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Model();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel <em>Simple Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel
   * @generated
   */
  EClass getSimpleModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#getVisibility()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isStatic()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isSynchronized()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Synchronized();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isAbstract()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#isFinal()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel#getName()
   * @see #getSimpleModel()
   * @generated
   */
  EAttribute getSimpleModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel <em>Mandatory Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mandatory Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel
   * @generated
   */
  EClass getMandatoryModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#getVisibility()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isStatic()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isSynchronized()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Synchronized();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isAbstract()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#isFinal()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel#getName()
   * @see #getMandatoryModel()
   * @generated
   */
  EAttribute getMandatoryModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel <em>Looped Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Looped Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel
   * @generated
   */
  EClass getLoopedModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getVisibility()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Visibility();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getStatic()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Static();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getSynchronized()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Synchronized();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getAbstract()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Abstract();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getFinal()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel#getName()
   * @see #getLoopedModel()
   * @generated
   */
  EAttribute getLoopedModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel <em>Group Looped Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group Looped Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel
   * @generated
   */
  EClass getGroupLoopedModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getVisibility()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Visibility();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getStatic()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Static();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getSynchronized()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Synchronized();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getAbstract()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Abstract();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getFinal()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel#getName()
   * @see #getGroupLoopedModel()
   * @generated
   */
  EAttribute getGroupLoopedModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel <em>Looped Alternative Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Looped Alternative Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel
   * @generated
   */
  EClass getLoopedAlternativeModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getVisibility()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Visibility();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getStatic()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Static();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getSynchronized()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Synchronized();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getAbstract()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Abstract();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getFinal()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedAlternativeModel#getName()
   * @see #getLoopedAlternativeModel()
   * @generated
   */
  EAttribute getLoopedAlternativeModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model <em>Bug304681 Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug304681 Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model
   * @generated
   */
  EClass getBug304681Model();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getShortDescription <em>Short Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Short Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getShortDescription()
   * @see #getBug304681Model()
   * @generated
   */
  EAttribute getBug304681Model_ShortDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getLongDescription <em>Long Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Long Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getLongDescription()
   * @see #getBug304681Model()
   * @generated
   */
  EAttribute getBug304681Model_LongDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getUid <em>Uid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uid</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getUid()
   * @see #getBug304681Model()
   * @generated
   */
  EAttribute getBug304681Model_Uid();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#isFlag <em>Flag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Flag</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#isFlag()
   * @see #getBug304681Model()
   * @generated
   */
  EAttribute getBug304681Model_Flag();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getFeatures()
   * @see #getBug304681Model()
   * @generated
   */
  EReference getBug304681Model_Features();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature <em>Bug304681 Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug304681 Feature</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature
   * @generated
   */
  EClass getBug304681Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature#getName()
   * @see #getBug304681Feature()
   * @generated
   */
  EAttribute getBug304681Feature_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Attribute <em>Bug304681 Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug304681 Attribute</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Attribute
   * @generated
   */
  EClass getBug304681Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Reference <em>Bug304681 Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug304681 Reference</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Reference
   * @generated
   */
  EClass getBug304681Reference();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnorderedGroupsTestFactory getUnorderedGroupsTestFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FIRST = eINSTANCE.getModel_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SECOND = eINSTANCE.getModel_Second();

    /**
     * The meta object literal for the '<em><b>Thrird</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__THRIRD = eINSTANCE.getModel_Thrird();

    /**
     * The meta object literal for the '<em><b>Forth</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FORTH = eINSTANCE.getModel_Forth();

    /**
     * The meta object literal for the '<em><b>Fifth</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FIFTH = eINSTANCE.getModel_Fifth();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MODEL = eINSTANCE.getModel_Model();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.SimpleModelImpl <em>Simple Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.SimpleModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getSimpleModel()
     * @generated
     */
    EClass SIMPLE_MODEL = eINSTANCE.getSimpleModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__VISIBILITY = eINSTANCE.getSimpleModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__STATIC = eINSTANCE.getSimpleModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__SYNCHRONIZED = eINSTANCE.getSimpleModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__ABSTRACT = eINSTANCE.getSimpleModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__FINAL = eINSTANCE.getSimpleModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_MODEL__NAME = eINSTANCE.getSimpleModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.MandatoryModelImpl <em>Mandatory Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.MandatoryModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getMandatoryModel()
     * @generated
     */
    EClass MANDATORY_MODEL = eINSTANCE.getMandatoryModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__VISIBILITY = eINSTANCE.getMandatoryModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__STATIC = eINSTANCE.getMandatoryModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__SYNCHRONIZED = eINSTANCE.getMandatoryModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__ABSTRACT = eINSTANCE.getMandatoryModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__FINAL = eINSTANCE.getMandatoryModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANDATORY_MODEL__NAME = eINSTANCE.getMandatoryModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedModelImpl <em>Looped Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getLoopedModel()
     * @generated
     */
    EClass LOOPED_MODEL = eINSTANCE.getLoopedModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__VISIBILITY = eINSTANCE.getLoopedModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__STATIC = eINSTANCE.getLoopedModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__SYNCHRONIZED = eINSTANCE.getLoopedModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__ABSTRACT = eINSTANCE.getLoopedModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__FINAL = eINSTANCE.getLoopedModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_MODEL__NAME = eINSTANCE.getLoopedModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.GroupLoopedModelImpl <em>Group Looped Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.GroupLoopedModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getGroupLoopedModel()
     * @generated
     */
    EClass GROUP_LOOPED_MODEL = eINSTANCE.getGroupLoopedModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__VISIBILITY = eINSTANCE.getGroupLoopedModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__STATIC = eINSTANCE.getGroupLoopedModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__SYNCHRONIZED = eINSTANCE.getGroupLoopedModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__ABSTRACT = eINSTANCE.getGroupLoopedModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__FINAL = eINSTANCE.getGroupLoopedModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP_LOOPED_MODEL__NAME = eINSTANCE.getGroupLoopedModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedAlternativeModelImpl <em>Looped Alternative Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.LoopedAlternativeModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getLoopedAlternativeModel()
     * @generated
     */
    EClass LOOPED_ALTERNATIVE_MODEL = eINSTANCE.getLoopedAlternativeModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__VISIBILITY = eINSTANCE.getLoopedAlternativeModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__STATIC = eINSTANCE.getLoopedAlternativeModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__SYNCHRONIZED = eINSTANCE.getLoopedAlternativeModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__ABSTRACT = eINSTANCE.getLoopedAlternativeModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__FINAL = eINSTANCE.getLoopedAlternativeModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPED_ALTERNATIVE_MODEL__NAME = eINSTANCE.getLoopedAlternativeModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl <em>Bug304681 Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Model()
     * @generated
     */
    EClass BUG304681_MODEL = eINSTANCE.getBug304681Model();

    /**
     * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG304681_MODEL__SHORT_DESCRIPTION = eINSTANCE.getBug304681Model_ShortDescription();

    /**
     * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG304681_MODEL__LONG_DESCRIPTION = eINSTANCE.getBug304681Model_LongDescription();

    /**
     * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG304681_MODEL__UID = eINSTANCE.getBug304681Model_Uid();

    /**
     * The meta object literal for the '<em><b>Flag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG304681_MODEL__FLAG = eINSTANCE.getBug304681Model_Flag();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUG304681_MODEL__FEATURES = eINSTANCE.getBug304681Model_Features();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681FeatureImpl <em>Bug304681 Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681FeatureImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Feature()
     * @generated
     */
    EClass BUG304681_FEATURE = eINSTANCE.getBug304681Feature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG304681_FEATURE__NAME = eINSTANCE.getBug304681Feature_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681AttributeImpl <em>Bug304681 Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681AttributeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Attribute()
     * @generated
     */
    EClass BUG304681_ATTRIBUTE = eINSTANCE.getBug304681Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ReferenceImpl <em>Bug304681 Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ReferenceImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getBug304681Reference()
     * @generated
     */
    EClass BUG304681_REFERENCE = eINSTANCE.getBug304681Reference();

  }

} //UnorderedGroupsTestPackage
