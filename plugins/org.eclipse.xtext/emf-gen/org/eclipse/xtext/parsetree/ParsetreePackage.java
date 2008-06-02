/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParsetreePackage.java,v 1.2 2008/06/02 13:20:56 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree;

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
 * @see org.eclipse.xtext.parsetree.ParsetreeFactory
 * @model kind="package"
 * @generated
 */
public interface ParsetreePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "parsetree";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/parsetree";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "parsetree";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParsetreePackage eINSTANCE = org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.impl.AbstractNodeImpl
   * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getAbstractNode()
   * @generated
   */
  int ABSTRACT_NODE = 1;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__PARENT = 0;

  /**
   * The feature id for the '<em><b>Grammar Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__GRAMMAR_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Abstract Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.impl.CompositeNodeImpl
   * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getCompositeNode()
   * @generated
   */
  int COMPOSITE_NODE = 0;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_NODE__PARENT = ABSTRACT_NODE__PARENT;

  /**
   * The feature id for the '<em><b>Grammar Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_NODE__GRAMMAR_ELEMENT = ABSTRACT_NODE__GRAMMAR_ELEMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_NODE__ELEMENT = ABSTRACT_NODE__ELEMENT;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_NODE__CHILDREN = ABSTRACT_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Composite Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.impl.LeafNodeImpl
   * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getLeafNode()
   * @generated
   */
  int LEAF_NODE = 2;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__PARENT = ABSTRACT_NODE__PARENT;

  /**
   * The feature id for the '<em><b>Grammar Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__GRAMMAR_ELEMENT = ABSTRACT_NODE__GRAMMAR_ELEMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__ELEMENT = ABSTRACT_NODE__ELEMENT;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__TEXT = ABSTRACT_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__FEATURE = ABSTRACT_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Hidden</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE__HIDDEN = ABSTRACT_NODE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Leaf Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.CompositeNode <em>Composite Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Node</em>'.
   * @see org.eclipse.xtext.parsetree.CompositeNode
   * @generated
   */
  EClass getCompositeNode();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.CompositeNode#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.parsetree.CompositeNode#getChildren()
   * @see #getCompositeNode()
   * @generated
   */
  EReference getCompositeNode_Children();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.AbstractNode <em>Abstract Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Node</em>'.
   * @see org.eclipse.xtext.parsetree.AbstractNode
   * @generated
   */
  EClass getAbstractNode();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see org.eclipse.xtext.parsetree.AbstractNode#getParent()
   * @see #getAbstractNode()
   * @generated
   */
  EReference getAbstractNode_Parent();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Grammar Element</em>'.
   * @see org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement()
   * @see #getAbstractNode()
   * @generated
   */
  EReference getAbstractNode_GrammarElement();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.AbstractNode#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Element</em>'.
   * @see org.eclipse.xtext.parsetree.AbstractNode#getElement()
   * @see #getAbstractNode()
   * @generated
   */
  EReference getAbstractNode_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.LeafNode <em>Leaf Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Leaf Node</em>'.
   * @see org.eclipse.xtext.parsetree.LeafNode
   * @generated
   */
  EClass getLeafNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.eclipse.xtext.parsetree.LeafNode#getText()
   * @see #getLeafNode()
   * @generated
   */
  EAttribute getLeafNode_Text();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.parsetree.LeafNode#getFeature()
   * @see #getLeafNode()
   * @generated
   */
  EAttribute getLeafNode_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.LeafNode#isHidden <em>Hidden</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hidden</em>'.
   * @see org.eclipse.xtext.parsetree.LeafNode#isHidden()
   * @see #getLeafNode()
   * @generated
   */
  EAttribute getLeafNode_Hidden();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ParsetreeFactory getParsetreeFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.impl.CompositeNodeImpl
     * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getCompositeNode()
     * @generated
     */
    EClass COMPOSITE_NODE = eINSTANCE.getCompositeNode();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_NODE__CHILDREN = eINSTANCE.getCompositeNode_Children();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.impl.AbstractNodeImpl
     * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getAbstractNode()
     * @generated
     */
    EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_NODE__PARENT = eINSTANCE.getAbstractNode_Parent();

    /**
     * The meta object literal for the '<em><b>Grammar Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_NODE__GRAMMAR_ELEMENT = eINSTANCE.getAbstractNode_GrammarElement();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_NODE__ELEMENT = eINSTANCE.getAbstractNode_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.impl.LeafNodeImpl
     * @see org.eclipse.xtext.parsetree.impl.ParsetreePackageImpl#getLeafNode()
     * @generated
     */
    EClass LEAF_NODE = eINSTANCE.getLeafNode();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEAF_NODE__TEXT = eINSTANCE.getLeafNode_Text();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEAF_NODE__FEATURE = eINSTANCE.getLeafNode_Feature();

    /**
     * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEAF_NODE__HIDDEN = eINSTANCE.getLeafNode_Hidden();

  }

} //ParsetreePackage
