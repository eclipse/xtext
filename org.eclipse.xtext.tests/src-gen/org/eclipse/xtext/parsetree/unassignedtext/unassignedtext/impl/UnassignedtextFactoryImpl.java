/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnassignedtextFactoryImpl extends EFactoryImpl implements UnassignedtextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnassignedtextFactory init()
  {
    try
    {
      UnassignedtextFactory theUnassignedtextFactory = (UnassignedtextFactory)EPackage.Registry.INSTANCE.getEFactory(UnassignedtextPackage.eNS_URI);
      if (theUnassignedtextFactory != null)
      {
        return theUnassignedtextFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnassignedtextFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedtextFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case UnassignedtextPackage.MODEL: return createModel();
      case UnassignedtextPackage.CASE_INSENSITIVE_KEYWORD_RULE: return createCaseInsensitiveKeywordRule();
      case UnassignedtextPackage.PLURAL_RULE: return createPluralRule();
      case UnassignedtextPackage.MULTI_RULE: return createMultiRule();
      case UnassignedtextPackage.DATATYPE_RULE: return createDatatypeRule();
      case UnassignedtextPackage.COMMON_TERMINALS_RULE: return createCommonTerminalsRule();
      case UnassignedtextPackage.GROUP_RULE: return createGroupRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CaseInsensitiveKeywordRule createCaseInsensitiveKeywordRule()
  {
    CaseInsensitiveKeywordRuleImpl caseInsensitiveKeywordRule = new CaseInsensitiveKeywordRuleImpl();
    return caseInsensitiveKeywordRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PluralRule createPluralRule()
  {
    PluralRuleImpl pluralRule = new PluralRuleImpl();
    return pluralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MultiRule createMultiRule()
  {
    MultiRuleImpl multiRule = new MultiRuleImpl();
    return multiRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DatatypeRule createDatatypeRule()
  {
    DatatypeRuleImpl datatypeRule = new DatatypeRuleImpl();
    return datatypeRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CommonTerminalsRule createCommonTerminalsRule()
  {
    CommonTerminalsRuleImpl commonTerminalsRule = new CommonTerminalsRuleImpl();
    return commonTerminalsRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GroupRule createGroupRule()
  {
    GroupRuleImpl groupRule = new GroupRuleImpl();
    return groupRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnassignedtextPackage getUnassignedtextPackage()
  {
    return (UnassignedtextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnassignedtextPackage getPackage()
  {
    return UnassignedtextPackage.eINSTANCE;
  }

} //UnassignedtextFactoryImpl
