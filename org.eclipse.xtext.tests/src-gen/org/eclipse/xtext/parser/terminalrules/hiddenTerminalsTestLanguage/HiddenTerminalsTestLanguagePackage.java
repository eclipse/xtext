/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;

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
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface HiddenTerminalsTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hiddenTerminalsTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/HiddenTerminalsTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hiddenTerminalsTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HiddenTerminalsTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALID = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithoutHiddensImpl <em>Without Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithoutHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getWithoutHiddens()
   * @generated
   */
  int WITHOUT_HIDDENS = 1;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WITHOUT_HIDDENS__VALID = MODEL__VALID;

  /**
   * The feature id for the '<em><b>Spaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WITHOUT_HIDDENS__SPACES = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Without Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WITHOUT_HIDDENS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithHiddensImpl <em>With Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getWithHiddens()
   * @generated
   */
  int WITH_HIDDENS = 2;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WITH_HIDDENS__VALID = MODEL__VALID;

  /**
   * The number of structural features of the '<em>With Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WITH_HIDDENS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensImpl <em>Overriding Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getOverridingHiddens()
   * @generated
   */
  int OVERRIDING_HIDDENS = 3;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS__VALID = MODEL__VALID;

  /**
   * The feature id for the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS__CALLED = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Overriding Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl <em>Overriding Hiddens Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getOverridingHiddensCall()
   * @generated
   */
  int OVERRIDING_HIDDENS_CALL = 4;

  /**
   * The feature id for the '<em><b>Spaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS_CALL__SPACES = 0;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS_CALL__VALID = 1;

  /**
   * The number of structural features of the '<em>Overriding Hiddens Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDING_HIDDENS_CALL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl <em>Inheriting Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getInheritingHiddens()
   * @generated
   */
  int INHERITING_HIDDENS = 5;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS__VALID = MODEL__VALID;

  /**
   * The feature id for the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS__CALLED = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Hiding Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS__HIDING_CALLED = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Inheriting Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.DatatypeHiddensImpl <em>Datatype Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.DatatypeHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getDatatypeHiddens()
   * @generated
   */
  int DATATYPE_HIDDENS = 6;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_HIDDENS__VALID = MODEL__VALID;

  /**
   * The number of structural features of the '<em>Datatype Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_HIDDENS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl <em>Hiding Hiddens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getHidingHiddens()
   * @generated
   */
  int HIDING_HIDDENS = 7;

  /**
   * The feature id for the '<em><b>Space</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING_HIDDENS__SPACE = 0;

  /**
   * The feature id for the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING_HIDDENS__CALLED = 1;

  /**
   * The number of structural features of the '<em>Hiding Hiddens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING_HIDDENS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensCallImpl <em>Inheriting Hiddens Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensCallImpl
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getInheritingHiddensCall()
   * @generated
   */
  int INHERITING_HIDDENS_CALL = 8;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS_CALL__VALID = 0;

  /**
   * The number of structural features of the '<em>Inheriting Hiddens Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITING_HIDDENS_CALL_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model#isValid <em>Valid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Valid</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model#isValid()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Valid();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens <em>Without Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Without Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens
   * @generated
   */
  EClass getWithoutHiddens();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens#getSpaces <em>Spaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Spaces</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens#getSpaces()
   * @see #getWithoutHiddens()
   * @generated
   */
  EAttribute getWithoutHiddens_Spaces();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens <em>With Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>With Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens
   * @generated
   */
  EClass getWithHiddens();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens <em>Overriding Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Overriding Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens
   * @generated
   */
  EClass getOverridingHiddens();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled <em>Called</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Called</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled()
   * @see #getOverridingHiddens()
   * @generated
   */
  EReference getOverridingHiddens_Called();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall <em>Overriding Hiddens Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Overriding Hiddens Call</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall
   * @generated
   */
  EClass getOverridingHiddensCall();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#getSpaces <em>Spaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Spaces</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#getSpaces()
   * @see #getOverridingHiddensCall()
   * @generated
   */
  EAttribute getOverridingHiddensCall_Spaces();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#isValid <em>Valid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Valid</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#isValid()
   * @see #getOverridingHiddensCall()
   * @generated
   */
  EAttribute getOverridingHiddensCall_Valid();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens <em>Inheriting Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inheriting Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens
   * @generated
   */
  EClass getInheritingHiddens();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens#getCalled <em>Called</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Called</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens#getCalled()
   * @see #getInheritingHiddens()
   * @generated
   */
  EReference getInheritingHiddens_Called();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens#getHidingCalled <em>Hiding Called</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Hiding Called</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens#getHidingCalled()
   * @see #getInheritingHiddens()
   * @generated
   */
  EReference getInheritingHiddens_HidingCalled();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens <em>Datatype Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatype Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens
   * @generated
   */
  EClass getDatatypeHiddens();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens <em>Hiding Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hiding Hiddens</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens
   * @generated
   */
  EClass getHidingHiddens();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getSpace <em>Space</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Space</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getSpace()
   * @see #getHidingHiddens()
   * @generated
   */
  EAttribute getHidingHiddens_Space();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getCalled <em>Called</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Called</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getCalled()
   * @see #getHidingHiddens()
   * @generated
   */
  EReference getHidingHiddens_Called();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall <em>Inheriting Hiddens Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inheriting Hiddens Call</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall
   * @generated
   */
  EClass getInheritingHiddensCall();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall#isValid <em>Valid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Valid</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall#isValid()
   * @see #getInheritingHiddensCall()
   * @generated
   */
  EAttribute getInheritingHiddensCall_Valid();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HiddenTerminalsTestLanguageFactory getHiddenTerminalsTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VALID = eINSTANCE.getModel_Valid();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithoutHiddensImpl <em>Without Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithoutHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getWithoutHiddens()
     * @generated
     */
    EClass WITHOUT_HIDDENS = eINSTANCE.getWithoutHiddens();

    /**
     * The meta object literal for the '<em><b>Spaces</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WITHOUT_HIDDENS__SPACES = eINSTANCE.getWithoutHiddens_Spaces();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithHiddensImpl <em>With Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.WithHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getWithHiddens()
     * @generated
     */
    EClass WITH_HIDDENS = eINSTANCE.getWithHiddens();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensImpl <em>Overriding Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getOverridingHiddens()
     * @generated
     */
    EClass OVERRIDING_HIDDENS = eINSTANCE.getOverridingHiddens();

    /**
     * The meta object literal for the '<em><b>Called</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OVERRIDING_HIDDENS__CALLED = eINSTANCE.getOverridingHiddens_Called();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl <em>Overriding Hiddens Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getOverridingHiddensCall()
     * @generated
     */
    EClass OVERRIDING_HIDDENS_CALL = eINSTANCE.getOverridingHiddensCall();

    /**
     * The meta object literal for the '<em><b>Spaces</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OVERRIDING_HIDDENS_CALL__SPACES = eINSTANCE.getOverridingHiddensCall_Spaces();

    /**
     * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OVERRIDING_HIDDENS_CALL__VALID = eINSTANCE.getOverridingHiddensCall_Valid();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl <em>Inheriting Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getInheritingHiddens()
     * @generated
     */
    EClass INHERITING_HIDDENS = eINSTANCE.getInheritingHiddens();

    /**
     * The meta object literal for the '<em><b>Called</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INHERITING_HIDDENS__CALLED = eINSTANCE.getInheritingHiddens_Called();

    /**
     * The meta object literal for the '<em><b>Hiding Called</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INHERITING_HIDDENS__HIDING_CALLED = eINSTANCE.getInheritingHiddens_HidingCalled();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.DatatypeHiddensImpl <em>Datatype Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.DatatypeHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getDatatypeHiddens()
     * @generated
     */
    EClass DATATYPE_HIDDENS = eINSTANCE.getDatatypeHiddens();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl <em>Hiding Hiddens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getHidingHiddens()
     * @generated
     */
    EClass HIDING_HIDDENS = eINSTANCE.getHidingHiddens();

    /**
     * The meta object literal for the '<em><b>Space</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HIDING_HIDDENS__SPACE = eINSTANCE.getHidingHiddens_Space();

    /**
     * The meta object literal for the '<em><b>Called</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HIDING_HIDDENS__CALLED = eINSTANCE.getHidingHiddens_Called();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensCallImpl <em>Inheriting Hiddens Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensCallImpl
     * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguagePackageImpl#getInheritingHiddensCall()
     * @generated
     */
    EClass INHERITING_HIDDENS_CALL = eINSTANCE.getInheritingHiddensCall();

    /**
     * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INHERITING_HIDDENS_CALL__VALID = eINSTANCE.getInheritingHiddensCall_Valid();

  }

} //HiddenTerminalsTestLanguagePackage
