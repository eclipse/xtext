/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates;

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
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesFactory
 * @model kind="package"
 * @generated
 */
public interface TemplatesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "templates";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/codetemplate/Codetemplates";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "templates";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TemplatesPackage eINSTANCE = org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplatesImpl <em>Codetemplates</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplatesImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getCodetemplates()
   * @generated
   */
  int CODETEMPLATES = 0;

  /**
   * The feature id for the '<em><b>Language</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATES__LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Templates</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATES__TEMPLATES = 1;

  /**
   * The number of structural features of the '<em>Codetemplates</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl <em>Codetemplate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getCodetemplate()
   * @generated
   */
  int CODETEMPLATE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__NAME = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__ID = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__CONTEXT = 3;

  /**
   * The feature id for the '<em><b>Keyword Context</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__KEYWORD_CONTEXT = 4;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE__BODY = 5;

  /**
   * The number of structural features of the '<em>Codetemplate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODETEMPLATE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.TemplateBodyImpl <em>Template Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplateBodyImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getTemplateBody()
   * @generated
   */
  int TEMPLATE_BODY = 2;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_BODY__PARTS = 0;

  /**
   * The number of structural features of the '<em>Template Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatePartImpl <em>Template Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatePartImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getTemplatePart()
   * @generated
   */
  int TEMPLATE_PART = 3;

  /**
   * The number of structural features of the '<em>Template Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_PART_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = TEMPLATE_PART_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = TEMPLATE_PART_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expecting Parameters</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXPECTING_PARAMETERS = TEMPLATE_PART_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__PARAMETERS = TEMPLATE_PART_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = TEMPLATE_PART_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.LiteralImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VALUE = TEMPLATE_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = TEMPLATE_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.DollarImpl <em>Dollar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.DollarImpl
   * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getDollar()
   * @generated
   */
  int DOLLAR = 6;

  /**
   * The feature id for the '<em><b>Escaped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOLLAR__ESCAPED = TEMPLATE_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dollar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOLLAR_FEATURE_COUNT = TEMPLATE_PART_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates <em>Codetemplates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Codetemplates</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplates
   * @generated
   */
  EClass getCodetemplates();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getLanguage <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Language</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getLanguage()
   * @see #getCodetemplates()
   * @generated
   */
  EReference getCodetemplates_Language();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getTemplates <em>Templates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Templates</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getTemplates()
   * @see #getCodetemplates()
   * @generated
   */
  EReference getCodetemplates_Templates();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate <em>Codetemplate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Codetemplate</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate
   * @generated
   */
  EClass getCodetemplate();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getName()
   * @see #getCodetemplate()
   * @generated
   */
  EAttribute getCodetemplate_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getId()
   * @see #getCodetemplate()
   * @generated
   */
  EAttribute getCodetemplate_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getDescription()
   * @see #getCodetemplate()
   * @generated
   */
  EAttribute getCodetemplate_Description();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getContext()
   * @see #getCodetemplate()
   * @generated
   */
  EReference getCodetemplate_Context();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getKeywordContext <em>Keyword Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Keyword Context</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getKeywordContext()
   * @see #getCodetemplate()
   * @generated
   */
  EAttribute getCodetemplate_KeywordContext();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getBody()
   * @see #getCodetemplate()
   * @generated
   */
  EReference getCodetemplate_Body();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.TemplateBody <em>Template Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Body</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplateBody
   * @generated
   */
  EClass getTemplateBody();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.codetemplates.templates.TemplateBody#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplateBody#getParts()
   * @see #getTemplateBody()
   * @generated
   */
  EReference getTemplateBody_Parts();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.TemplatePart <em>Template Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Part</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatePart
   * @generated
   */
  EClass getTemplatePart();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#isExpectingParameters <em>Expecting Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expecting Parameters</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Variable#isExpectingParameters()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_ExpectingParameters();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Variable#getParameters()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Literal#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Literal#getValue()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.codetemplates.templates.Dollar <em>Dollar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dollar</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Dollar
   * @generated
   */
  EClass getDollar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.codetemplates.templates.Dollar#isEscaped <em>Escaped</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escaped</em>'.
   * @see org.eclipse.xtext.ui.codetemplates.templates.Dollar#isEscaped()
   * @see #getDollar()
   * @generated
   */
  EAttribute getDollar_Escaped();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TemplatesFactory getTemplatesFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplatesImpl <em>Codetemplates</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplatesImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getCodetemplates()
     * @generated
     */
    EClass CODETEMPLATES = eINSTANCE.getCodetemplates();

    /**
     * The meta object literal for the '<em><b>Language</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODETEMPLATES__LANGUAGE = eINSTANCE.getCodetemplates_Language();

    /**
     * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODETEMPLATES__TEMPLATES = eINSTANCE.getCodetemplates_Templates();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl <em>Codetemplate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getCodetemplate()
     * @generated
     */
    EClass CODETEMPLATE = eINSTANCE.getCodetemplate();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODETEMPLATE__NAME = eINSTANCE.getCodetemplate_Name();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODETEMPLATE__ID = eINSTANCE.getCodetemplate_Id();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODETEMPLATE__DESCRIPTION = eINSTANCE.getCodetemplate_Description();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODETEMPLATE__CONTEXT = eINSTANCE.getCodetemplate_Context();

    /**
     * The meta object literal for the '<em><b>Keyword Context</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODETEMPLATE__KEYWORD_CONTEXT = eINSTANCE.getCodetemplate_KeywordContext();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODETEMPLATE__BODY = eINSTANCE.getCodetemplate_Body();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.TemplateBodyImpl <em>Template Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplateBodyImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getTemplateBody()
     * @generated
     */
    EClass TEMPLATE_BODY = eINSTANCE.getTemplateBody();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_BODY__PARTS = eINSTANCE.getTemplateBody_Parts();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatePartImpl <em>Template Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatePartImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getTemplatePart()
     * @generated
     */
    EClass TEMPLATE_PART = eINSTANCE.getTemplatePart();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Expecting Parameters</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__EXPECTING_PARAMETERS = eINSTANCE.getVariable_ExpectingParameters();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__PARAMETERS = eINSTANCE.getVariable_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.LiteralImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.codetemplates.templates.impl.DollarImpl <em>Dollar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.DollarImpl
     * @see org.eclipse.xtext.ui.codetemplates.templates.impl.TemplatesPackageImpl#getDollar()
     * @generated
     */
    EClass DOLLAR = eINSTANCE.getDollar();

    /**
     * The meta object literal for the '<em><b>Escaped</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOLLAR__ESCAPED = eINSTANCE.getDollar_Escaped();

  }

} //TemplatesPackage
