/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.XtextPackage;

import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.ui.codetemplates.templates.Literal;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatePart;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesFactory;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatesPackageImpl extends EPackageImpl implements TemplatesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codetemplatesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codetemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templatePartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dollarEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TemplatesPackageImpl()
  {
    super(eNS_URI, TemplatesFactory.eINSTANCE);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link TemplatesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TemplatesPackage init()
  {
    if (isInited) return (TemplatesPackage)EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredTemplatesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    TemplatesPackageImpl theTemplatesPackage = registeredTemplatesPackage instanceof TemplatesPackageImpl ? (TemplatesPackageImpl)registeredTemplatesPackage : new TemplatesPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    XtextPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTemplatesPackage.createPackageContents();

    // Initialize created meta-data
    theTemplatesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTemplatesPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TemplatesPackage.eNS_URI, theTemplatesPackage);
    return theTemplatesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCodetemplates()
  {
    return codetemplatesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCodetemplates_Language()
  {
    return (EReference)codetemplatesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCodetemplates_Templates()
  {
    return (EReference)codetemplatesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCodetemplate()
  {
    return codetemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCodetemplate_Name()
  {
    return (EAttribute)codetemplateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCodetemplate_Id()
  {
    return (EAttribute)codetemplateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCodetemplate_Description()
  {
    return (EAttribute)codetemplateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCodetemplate_Context()
  {
    return (EReference)codetemplateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCodetemplate_KeywordContext()
  {
    return (EAttribute)codetemplateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCodetemplate_Body()
  {
    return (EReference)codetemplateEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTemplateBody()
  {
    return templateBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTemplateBody_Parts()
  {
    return (EReference)templateBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTemplatePart()
  {
    return templatePartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVariable_Name()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVariable_Type()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVariable_ExpectingParameters()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVariable_Parameters()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLiteral_Value()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDollar()
  {
    return dollarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDollar_Escaped()
  {
    return (EAttribute)dollarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TemplatesFactory getTemplatesFactory()
  {
    return (TemplatesFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    codetemplatesEClass = createEClass(CODETEMPLATES);
    createEReference(codetemplatesEClass, CODETEMPLATES__LANGUAGE);
    createEReference(codetemplatesEClass, CODETEMPLATES__TEMPLATES);

    codetemplateEClass = createEClass(CODETEMPLATE);
    createEAttribute(codetemplateEClass, CODETEMPLATE__NAME);
    createEAttribute(codetemplateEClass, CODETEMPLATE__ID);
    createEAttribute(codetemplateEClass, CODETEMPLATE__DESCRIPTION);
    createEReference(codetemplateEClass, CODETEMPLATE__CONTEXT);
    createEAttribute(codetemplateEClass, CODETEMPLATE__KEYWORD_CONTEXT);
    createEReference(codetemplateEClass, CODETEMPLATE__BODY);

    templateBodyEClass = createEClass(TEMPLATE_BODY);
    createEReference(templateBodyEClass, TEMPLATE_BODY__PARTS);

    templatePartEClass = createEClass(TEMPLATE_PART);

    variableEClass = createEClass(VARIABLE);
    createEAttribute(variableEClass, VARIABLE__NAME);
    createEAttribute(variableEClass, VARIABLE__TYPE);
    createEAttribute(variableEClass, VARIABLE__EXPECTING_PARAMETERS);
    createEAttribute(variableEClass, VARIABLE__PARAMETERS);

    literalEClass = createEClass(LITERAL);
    createEAttribute(literalEClass, LITERAL__VALUE);

    dollarEClass = createEClass(DOLLAR);
    createEAttribute(dollarEClass, DOLLAR__ESCAPED);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XtextPackage theXtextPackage = (XtextPackage)EPackage.Registry.INSTANCE.getEPackage(XtextPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    variableEClass.getESuperTypes().add(this.getTemplatePart());
    literalEClass.getESuperTypes().add(this.getTemplatePart());
    dollarEClass.getESuperTypes().add(this.getTemplatePart());

    // Initialize classes and features; add operations and parameters
    initEClass(codetemplatesEClass, Codetemplates.class, "Codetemplates", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCodetemplates_Language(), theXtextPackage.getGrammar(), null, "language", null, 0, 1, Codetemplates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCodetemplates_Templates(), this.getCodetemplate(), null, "templates", null, 0, -1, Codetemplates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(codetemplateEClass, Codetemplate.class, "Codetemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCodetemplate_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodetemplate_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodetemplate_Description(), theEcorePackage.getEString(), "description", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCodetemplate_Context(), theXtextPackage.getAbstractRule(), null, "context", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodetemplate_KeywordContext(), theEcorePackage.getEString(), "keywordContext", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCodetemplate_Body(), this.getTemplateBody(), null, "body", null, 0, 1, Codetemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(templateBodyEClass, TemplateBody.class, "TemplateBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTemplateBody_Parts(), this.getTemplatePart(), null, "parts", null, 0, -1, TemplateBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(templatePartEClass, TemplatePart.class, "TemplatePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariable_Type(), theEcorePackage.getEString(), "type", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariable_ExpectingParameters(), theEcorePackage.getEBoolean(), "expectingParameters", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariable_Parameters(), theEcorePackage.getEString(), "parameters", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dollarEClass, Dollar.class, "Dollar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDollar_Escaped(), theEcorePackage.getEBoolean(), "escaped", null, 0, 1, Dollar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TemplatesPackageImpl
