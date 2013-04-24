/**
 */
package org.eclipse.xtext.linking.lazy.bug311337;

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
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Factory
 * @model kind="package"
 * @generated
 */
public interface Bug311337Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug311337";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xtext.org/testlanguages/bug311337";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug311337";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug311337Package eINSTANCE = org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ModelImpl
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Def</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DEF = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__CHILD = 1;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__REF = 2;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ChildImpl <em>Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ChildImpl
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getChild()
   * @generated
   */
  int CHILD = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD__NAME = 0;

  /**
   * The feature id for the '<em><b>Link</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD__LINK = 1;

  /**
   * The number of structural features of the '<em>Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ReferenceImpl
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 3;

  /**
   * The feature id for the '<em><b>Ref Child</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__REF_CHILD = 0;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.NestedRefImpl <em>Nested Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.NestedRefImpl
   * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getNestedRef()
   * @generated
   */
  int NESTED_REF = 4;

  /**
   * The feature id for the '<em><b>Ref Child</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_REF__REF_CHILD = REFERENCE__REF_CHILD;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_REF__LEFT = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.lazy.bug311337.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.linking.lazy.bug311337.Model#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Def</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Model#getDef()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Def();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.lazy.bug311337.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Definition#getName()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Definition#getChild()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Child();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ref</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Definition#getRef()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.lazy.bug311337.Child <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Child
   * @generated
   */
  EClass getChild();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.lazy.bug311337.Child#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Child#getName()
   * @see #getChild()
   * @generated
   */
  EAttribute getChild_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.linking.lazy.bug311337.Child#getLink <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Link</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Child#getLink()
   * @see #getChild()
   * @generated
   */
  EReference getChild_Link();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.lazy.bug311337.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild <em>Ref Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref Child</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild()
   * @see #getReference()
   * @generated
   */
  EReference getReference_RefChild();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.lazy.bug311337.NestedRef <em>Nested Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Ref</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.NestedRef
   * @generated
   */
  EClass getNestedRef();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.linking.lazy.bug311337.NestedRef#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.linking.lazy.bug311337.NestedRef#getLeft()
   * @see #getNestedRef()
   * @generated
   */
  EReference getNestedRef_Left();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug311337Factory getBug311337Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ModelImpl
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Def</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DEF = eINSTANCE.getModel_Def();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__CHILD = eINSTANCE.getDefinition_Child();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__REF = eINSTANCE.getDefinition_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ChildImpl
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getChild()
     * @generated
     */
    EClass CHILD = eINSTANCE.getChild();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD__NAME = eINSTANCE.getChild_Name();

    /**
     * The meta object literal for the '<em><b>Link</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHILD__LINK = eINSTANCE.getChild_Link();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.ReferenceImpl
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Ref Child</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__REF_CHILD = eINSTANCE.getReference_RefChild();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.lazy.bug311337.impl.NestedRefImpl <em>Nested Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.NestedRefImpl
     * @see org.eclipse.xtext.linking.lazy.bug311337.impl.Bug311337PackageImpl#getNestedRef()
     * @generated
     */
    EClass NESTED_REF = eINSTANCE.getNestedRef();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_REF__LEFT = eINSTANCE.getNestedRef_Left();

  }

} //Bug311337Package
