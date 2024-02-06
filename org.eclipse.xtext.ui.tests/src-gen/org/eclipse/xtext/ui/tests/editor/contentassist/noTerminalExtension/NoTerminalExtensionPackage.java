/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.NoTerminalExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface NoTerminalExtensionPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "noTerminalExtension";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2018/contentAssistNoTerminalExtension";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "noTerminalExtension";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NoTerminalExtensionPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.PolygonBasedShapeImpl <em>Polygon Based Shape</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.PolygonBasedShapeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionPackageImpl#getPolygonBasedShape()
   * @generated
   */
  int POLYGON_BASED_SHAPE = 0;

  /**
   * The feature id for the '<em><b>Shape</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLYGON_BASED_SHAPE__SHAPE = 0;

  /**
   * The number of structural features of the '<em>Polygon Based Shape</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLYGON_BASED_SHAPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape <em>Polygon Based Node Shape</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionPackageImpl#getPolygonBasedNodeShape()
   * @generated
   */
  int POLYGON_BASED_NODE_SHAPE = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape <em>Polygon Based Shape</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Polygon Based Shape</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape
   * @generated
   */
  EClass getPolygonBasedShape();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape#getShape <em>Shape</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Shape</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape#getShape()
   * @see #getPolygonBasedShape()
   * @generated
   */
  EAttribute getPolygonBasedShape_Shape();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape <em>Polygon Based Node Shape</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Polygon Based Node Shape</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape
   * @generated
   */
  EEnum getPolygonBasedNodeShape();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  NoTerminalExtensionFactory getNoTerminalExtensionFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.PolygonBasedShapeImpl <em>Polygon Based Shape</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.PolygonBasedShapeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionPackageImpl#getPolygonBasedShape()
     * @generated
     */
    EClass POLYGON_BASED_SHAPE = eINSTANCE.getPolygonBasedShape();

    /**
     * The meta object literal for the '<em><b>Shape</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POLYGON_BASED_SHAPE__SHAPE = eINSTANCE.getPolygonBasedShape_Shape();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape <em>Polygon Based Node Shape</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionPackageImpl#getPolygonBasedNodeShape()
     * @generated
     */
    EEnum POLYGON_BASED_NODE_SHAPE = eINSTANCE.getPolygonBasedNodeShape();

  }

} //NoTerminalExtensionPackage
