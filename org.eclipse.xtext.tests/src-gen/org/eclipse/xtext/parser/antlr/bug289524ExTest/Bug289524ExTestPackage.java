/**
 */
package org.eclipse.xtext.parser.antlr.bug289524ExTest;

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
 * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug289524ExTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug289524ExTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/Bug289524ExTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug289524ExTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug289524ExTestPackage eINSTANCE = org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelImpl
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__REFS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Containments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__CONTAINMENTS = 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__REFS = 1;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ContainedImpl <em>Contained</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ContainedImpl
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getContained()
   * @generated
   */
  int CONTAINED = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINED__NAME = 0;

  /**
   * The number of structural features of the '<em>Contained</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINED_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Model#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refs</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Model#getRefs()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getContainments <em>Containments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Containments</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getContainments()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_Containments();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refs</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getRefs()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained <em>Contained</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contained</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained
   * @generated
   */
  EClass getContained();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained#getName()
   * @see #getContained()
   * @generated
   */
  EAttribute getContained_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug289524ExTestFactory getBug289524ExTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelImpl
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__REFS = eINSTANCE.getModel_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>Containments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__CONTAINMENTS = eINSTANCE.getModelElement_Containments();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__REFS = eINSTANCE.getModelElement_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ContainedImpl <em>Contained</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ContainedImpl
     * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.Bug289524ExTestPackageImpl#getContained()
     * @generated
     */
    EClass CONTAINED = eINSTANCE.getContained();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTAINED__NAME = eINSTANCE.getContained_Name();

  }

} //Bug289524ExTestPackage
