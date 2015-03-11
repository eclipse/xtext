/**
 */
package org.eclipse.xtext.formatting2.internal.formattertestlanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory
 * @model kind="package"
 * @generated
 */
public interface FormattertestlanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "formattertestlanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://formatter2/formattertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "formattertestlanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormattertestlanguagePackage eINSTANCE = org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.RootImpl
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.IDListImpl <em>ID List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.IDListImpl
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getIDList()
   * @generated
   */
  int ID_LIST = 1;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_LIST__IDS = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ID List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_LIST_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.KWListImpl <em>KW List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.KWListImpl
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getKWList()
   * @generated
   */
  int KW_LIST = 2;

  /**
   * The feature id for the '<em><b>Kw1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST__KW1 = ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Kw2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST__KW2 = ROOT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Kw3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST__KW3 = ROOT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Kw4</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST__KW4 = ROOT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Kw5</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST__KW5 = ROOT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>KW List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KW_LIST_FEATURE_COUNT = ROOT_FEATURE_COUNT + 5;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList <em>ID List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ID List</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
   * @generated
   */
  EClass getIDList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList#getIds()
   * @see #getIDList()
   * @generated
   */
  EAttribute getIDList_Ids();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList <em>KW List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>KW List</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList
   * @generated
   */
  EClass getKWList();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw1 <em>Kw1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw1</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw1()
   * @see #getKWList()
   * @generated
   */
  EAttribute getKWList_Kw1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw2 <em>Kw2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw2</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw2()
   * @see #getKWList()
   * @generated
   */
  EAttribute getKWList_Kw2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw3 <em>Kw3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw3</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw3()
   * @see #getKWList()
   * @generated
   */
  EAttribute getKWList_Kw3();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw4 <em>Kw4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw4</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw4()
   * @see #getKWList()
   * @generated
   */
  EAttribute getKWList_Kw4();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw5 <em>Kw5</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw5</em>'.
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList#isKw5()
   * @see #getKWList()
   * @generated
   */
  EAttribute getKWList_Kw5();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FormattertestlanguageFactory getFormattertestlanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.RootImpl
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.IDListImpl <em>ID List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.IDListImpl
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getIDList()
     * @generated
     */
    EClass ID_LIST = eINSTANCE.getIDList();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ID_LIST__IDS = eINSTANCE.getIDList_Ids();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.KWListImpl <em>KW List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.KWListImpl
     * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getKWList()
     * @generated
     */
    EClass KW_LIST = eINSTANCE.getKWList();

    /**
     * The meta object literal for the '<em><b>Kw1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KW_LIST__KW1 = eINSTANCE.getKWList_Kw1();

    /**
     * The meta object literal for the '<em><b>Kw2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KW_LIST__KW2 = eINSTANCE.getKWList_Kw2();

    /**
     * The meta object literal for the '<em><b>Kw3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KW_LIST__KW3 = eINSTANCE.getKWList_Kw3();

    /**
     * The meta object literal for the '<em><b>Kw4</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KW_LIST__KW4 = eINSTANCE.getKWList_Kw4();

    /**
     * The meta object literal for the '<em><b>Kw5</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KW_LIST__KW5 = eINSTANCE.getKWList_Kw5();

  }

} //FormattertestlanguagePackage
