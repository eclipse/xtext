/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.AliasWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.AndWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.BooleanOperator;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.DoubleWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.ElementScope;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.FromEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Import;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.LongWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.MQLquery;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.NullWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.NumericAttributeWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.NumericOperator;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.OrWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.ResourceScope;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Scope;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.ScopeClause;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.SelectEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.StringOperator;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.VariableWhereEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.WhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug287941TestLanguagePackageImpl extends EPackageImpl implements Bug287941TestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mqLqueryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fromEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scopeClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resourceScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericAttributeWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass longWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringAttributeWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanAttributeWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceAliasWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subselectWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aliasWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andWhereEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum numericOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum stringOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum booleanOperatorEEnum = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug287941TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug287941TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug287941TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug287941TestLanguagePackage init()
  {
    if (isInited) return (Bug287941TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug287941TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug287941TestLanguagePackageImpl theBug287941TestLanguagePackage = (Bug287941TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug287941TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug287941TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug287941TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug287941TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug287941TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug287941TestLanguagePackage.eNS_URI, theBug287941TestLanguagePackage);
    return theBug287941TestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Imports()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Query()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMQLquery()
  {
    return mqLqueryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMQLquery_SelectEntries()
  {
    return (EReference)mqLqueryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMQLquery_FromEntries()
  {
    return (EReference)mqLqueryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMQLquery_WhereEntries()
  {
    return (EReference)mqLqueryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectEntry()
  {
    return selectEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectEntry_Select()
  {
    return (EReference)selectEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectEntry_Attribute()
  {
    return (EReference)selectEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFromEntry()
  {
    return fromEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFromEntry_Type()
  {
    return (EReference)fromEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFromEntry_Withoutsubtypes()
  {
    return (EAttribute)fromEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFromEntry_Alias()
  {
    return (EAttribute)fromEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFromEntry_ScopeClause()
  {
    return (EReference)fromEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScopeClause()
  {
    return scopeClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScopeClause_NotIn()
  {
    return (EAttribute)scopeClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScopeClause_Scope()
  {
    return (EReference)scopeClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScope()
  {
    return scopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScope_Uris()
  {
    return (EAttribute)scopeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResourceScope()
  {
    return resourceScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElementScope()
  {
    return elementScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhereEntry()
  {
    return whereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeWhereEntry()
  {
    return attributeWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeWhereEntry_Alias()
  {
    return (EReference)attributeWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeWhereEntry_Attribute()
  {
    return (EReference)attributeWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericAttributeWhereEntry()
  {
    return numericAttributeWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericAttributeWhereEntry_Operator()
  {
    return (EAttribute)numericAttributeWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleWhereEntry()
  {
    return doubleWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDoubleWhereEntry_Value()
  {
    return (EAttribute)doubleWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLongWhereEntry()
  {
    return longWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLongWhereEntry_Value()
  {
    return (EAttribute)longWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableWhereEntry()
  {
    return variableWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableWhereEntry_Operator()
  {
    return (EAttribute)variableWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableWhereEntry_RightAlias()
  {
    return (EReference)variableWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableWhereEntry_RightAttribute()
  {
    return (EReference)variableWhereEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringAttributeWhereEntry()
  {
    return stringAttributeWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringAttributeWhereEntry_Operator()
  {
    return (EAttribute)stringAttributeWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringAttributeWhereEntry_Pattern()
  {
    return (EAttribute)stringAttributeWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanAttributeWhereEntry()
  {
    return booleanAttributeWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanAttributeWhereEntry_Operator()
  {
    return (EAttribute)booleanAttributeWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanAttributeWhereEntry_IsTrue()
  {
    return (EAttribute)booleanAttributeWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullWhereEntry()
  {
    return nullWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNullWhereEntry_Alias()
  {
    return (EReference)nullWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNullWhereEntry_Feature()
  {
    return (EReference)nullWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNullWhereEntry_Operator()
  {
    return (EAttribute)nullWhereEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferenceAliasWhereEntry()
  {
    return referenceAliasWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceAliasWhereEntry_Alias()
  {
    return (EReference)referenceAliasWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceAliasWhereEntry_Reference()
  {
    return (EReference)referenceAliasWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceAliasWhereEntry_RightAlias()
  {
    return (EReference)referenceAliasWhereEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubselectWhereEntry()
  {
    return subselectWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubselectWhereEntry_Alias()
  {
    return (EReference)subselectWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubselectWhereEntry_Reference()
  {
    return (EReference)subselectWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubselectWhereEntry_NotIn()
  {
    return (EAttribute)subselectWhereEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubselectWhereEntry_SubQuery()
  {
    return (EReference)subselectWhereEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAliasWhereEntry()
  {
    return aliasWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAliasWhereEntry_Alias()
  {
    return (EReference)aliasWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAliasWhereEntry_RightAlias()
  {
    return (EReference)aliasWhereEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrWhereEntry()
  {
    return orWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrWhereEntry_Entries()
  {
    return (EReference)orWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndWhereEntry()
  {
    return andWhereEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndWhereEntry_Entries()
  {
    return (EReference)andWhereEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNumericOperator()
  {
    return numericOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getStringOperator()
  {
    return stringOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBooleanOperator()
  {
    return booleanOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287941TestLanguageFactory getBug287941TestLanguageFactory()
  {
    return (Bug287941TestLanguageFactory)getEFactoryInstance();
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
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__IMPORTS);
    createEReference(modelEClass, MODEL__QUERY);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    mqLqueryEClass = createEClass(MQ_LQUERY);
    createEReference(mqLqueryEClass, MQ_LQUERY__SELECT_ENTRIES);
    createEReference(mqLqueryEClass, MQ_LQUERY__FROM_ENTRIES);
    createEReference(mqLqueryEClass, MQ_LQUERY__WHERE_ENTRIES);

    selectEntryEClass = createEClass(SELECT_ENTRY);
    createEReference(selectEntryEClass, SELECT_ENTRY__SELECT);
    createEReference(selectEntryEClass, SELECT_ENTRY__ATTRIBUTE);

    fromEntryEClass = createEClass(FROM_ENTRY);
    createEReference(fromEntryEClass, FROM_ENTRY__TYPE);
    createEAttribute(fromEntryEClass, FROM_ENTRY__WITHOUTSUBTYPES);
    createEAttribute(fromEntryEClass, FROM_ENTRY__ALIAS);
    createEReference(fromEntryEClass, FROM_ENTRY__SCOPE_CLAUSE);

    scopeClauseEClass = createEClass(SCOPE_CLAUSE);
    createEAttribute(scopeClauseEClass, SCOPE_CLAUSE__NOT_IN);
    createEReference(scopeClauseEClass, SCOPE_CLAUSE__SCOPE);

    scopeEClass = createEClass(SCOPE);
    createEAttribute(scopeEClass, SCOPE__URIS);

    resourceScopeEClass = createEClass(RESOURCE_SCOPE);

    elementScopeEClass = createEClass(ELEMENT_SCOPE);

    whereEntryEClass = createEClass(WHERE_ENTRY);

    attributeWhereEntryEClass = createEClass(ATTRIBUTE_WHERE_ENTRY);
    createEReference(attributeWhereEntryEClass, ATTRIBUTE_WHERE_ENTRY__ALIAS);
    createEReference(attributeWhereEntryEClass, ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE);

    numericAttributeWhereEntryEClass = createEClass(NUMERIC_ATTRIBUTE_WHERE_ENTRY);
    createEAttribute(numericAttributeWhereEntryEClass, NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR);

    doubleWhereEntryEClass = createEClass(DOUBLE_WHERE_ENTRY);
    createEAttribute(doubleWhereEntryEClass, DOUBLE_WHERE_ENTRY__VALUE);

    longWhereEntryEClass = createEClass(LONG_WHERE_ENTRY);
    createEAttribute(longWhereEntryEClass, LONG_WHERE_ENTRY__VALUE);

    variableWhereEntryEClass = createEClass(VARIABLE_WHERE_ENTRY);
    createEAttribute(variableWhereEntryEClass, VARIABLE_WHERE_ENTRY__OPERATOR);
    createEReference(variableWhereEntryEClass, VARIABLE_WHERE_ENTRY__RIGHT_ALIAS);
    createEReference(variableWhereEntryEClass, VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE);

    stringAttributeWhereEntryEClass = createEClass(STRING_ATTRIBUTE_WHERE_ENTRY);
    createEAttribute(stringAttributeWhereEntryEClass, STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR);
    createEAttribute(stringAttributeWhereEntryEClass, STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN);

    booleanAttributeWhereEntryEClass = createEClass(BOOLEAN_ATTRIBUTE_WHERE_ENTRY);
    createEAttribute(booleanAttributeWhereEntryEClass, BOOLEAN_ATTRIBUTE_WHERE_ENTRY__OPERATOR);
    createEAttribute(booleanAttributeWhereEntryEClass, BOOLEAN_ATTRIBUTE_WHERE_ENTRY__IS_TRUE);

    nullWhereEntryEClass = createEClass(NULL_WHERE_ENTRY);
    createEReference(nullWhereEntryEClass, NULL_WHERE_ENTRY__ALIAS);
    createEReference(nullWhereEntryEClass, NULL_WHERE_ENTRY__FEATURE);
    createEAttribute(nullWhereEntryEClass, NULL_WHERE_ENTRY__OPERATOR);

    referenceAliasWhereEntryEClass = createEClass(REFERENCE_ALIAS_WHERE_ENTRY);
    createEReference(referenceAliasWhereEntryEClass, REFERENCE_ALIAS_WHERE_ENTRY__ALIAS);
    createEReference(referenceAliasWhereEntryEClass, REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE);
    createEReference(referenceAliasWhereEntryEClass, REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS);

    subselectWhereEntryEClass = createEClass(SUBSELECT_WHERE_ENTRY);
    createEReference(subselectWhereEntryEClass, SUBSELECT_WHERE_ENTRY__ALIAS);
    createEReference(subselectWhereEntryEClass, SUBSELECT_WHERE_ENTRY__REFERENCE);
    createEAttribute(subselectWhereEntryEClass, SUBSELECT_WHERE_ENTRY__NOT_IN);
    createEReference(subselectWhereEntryEClass, SUBSELECT_WHERE_ENTRY__SUB_QUERY);

    aliasWhereEntryEClass = createEClass(ALIAS_WHERE_ENTRY);
    createEReference(aliasWhereEntryEClass, ALIAS_WHERE_ENTRY__ALIAS);
    createEReference(aliasWhereEntryEClass, ALIAS_WHERE_ENTRY__RIGHT_ALIAS);

    orWhereEntryEClass = createEClass(OR_WHERE_ENTRY);
    createEReference(orWhereEntryEClass, OR_WHERE_ENTRY__ENTRIES);

    andWhereEntryEClass = createEClass(AND_WHERE_ENTRY);
    createEReference(andWhereEntryEClass, AND_WHERE_ENTRY__ENTRIES);

    // Create enums
    numericOperatorEEnum = createEEnum(NUMERIC_OPERATOR);
    stringOperatorEEnum = createEEnum(STRING_OPERATOR);
    booleanOperatorEEnum = createEEnum(BOOLEAN_OPERATOR);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    resourceScopeEClass.getESuperTypes().add(this.getScope());
    elementScopeEClass.getESuperTypes().add(this.getScope());
    attributeWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    numericAttributeWhereEntryEClass.getESuperTypes().add(this.getAttributeWhereEntry());
    doubleWhereEntryEClass.getESuperTypes().add(this.getNumericAttributeWhereEntry());
    longWhereEntryEClass.getESuperTypes().add(this.getNumericAttributeWhereEntry());
    variableWhereEntryEClass.getESuperTypes().add(this.getAttributeWhereEntry());
    stringAttributeWhereEntryEClass.getESuperTypes().add(this.getAttributeWhereEntry());
    booleanAttributeWhereEntryEClass.getESuperTypes().add(this.getAttributeWhereEntry());
    nullWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    referenceAliasWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    subselectWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    aliasWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    orWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());
    andWhereEntryEClass.getESuperTypes().add(this.getWhereEntry());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Imports(), this.getImport(), null, "imports", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Query(), this.getMQLquery(), null, "query", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mqLqueryEClass, MQLquery.class, "MQLquery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMQLquery_SelectEntries(), this.getSelectEntry(), null, "selectEntries", null, 0, -1, MQLquery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMQLquery_FromEntries(), this.getFromEntry(), null, "fromEntries", null, 0, -1, MQLquery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMQLquery_WhereEntries(), this.getWhereEntry(), null, "whereEntries", null, 0, -1, MQLquery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectEntryEClass, SelectEntry.class, "SelectEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelectEntry_Select(), this.getFromEntry(), null, "select", null, 0, 1, SelectEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSelectEntry_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, SelectEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fromEntryEClass, FromEntry.class, "FromEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFromEntry_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, FromEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFromEntry_Withoutsubtypes(), ecorePackage.getEBoolean(), "withoutsubtypes", null, 0, 1, FromEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFromEntry_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, FromEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFromEntry_ScopeClause(), this.getScopeClause(), null, "scopeClause", null, 0, 1, FromEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scopeClauseEClass, ScopeClause.class, "ScopeClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScopeClause_NotIn(), ecorePackage.getEBoolean(), "notIn", null, 0, 1, ScopeClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScopeClause_Scope(), this.getScope(), null, "scope", null, 0, 1, ScopeClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scopeEClass, Scope.class, "Scope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScope_Uris(), ecorePackage.getEString(), "uris", null, 0, -1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resourceScopeEClass, ResourceScope.class, "ResourceScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elementScopeEClass, ElementScope.class, "ElementScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(whereEntryEClass, WhereEntry.class, "WhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeWhereEntryEClass, AttributeWhereEntry.class, "AttributeWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeWhereEntry_Alias(), this.getFromEntry(), null, "alias", null, 0, 1, AttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeWhereEntry_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, AttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericAttributeWhereEntryEClass, NumericAttributeWhereEntry.class, "NumericAttributeWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericAttributeWhereEntry_Operator(), this.getNumericOperator(), "operator", null, 0, 1, NumericAttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleWhereEntryEClass, DoubleWhereEntry.class, "DoubleWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleWhereEntry_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, DoubleWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(longWhereEntryEClass, LongWhereEntry.class, "LongWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLongWhereEntry_Value(), ecorePackage.getELong(), "value", null, 0, 1, LongWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableWhereEntryEClass, VariableWhereEntry.class, "VariableWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableWhereEntry_Operator(), this.getNumericOperator(), "operator", null, 0, 1, VariableWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableWhereEntry_RightAlias(), this.getFromEntry(), null, "rightAlias", null, 0, 1, VariableWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableWhereEntry_RightAttribute(), ecorePackage.getEAttribute(), null, "rightAttribute", null, 0, 1, VariableWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringAttributeWhereEntryEClass, StringAttributeWhereEntry.class, "StringAttributeWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringAttributeWhereEntry_Operator(), this.getStringOperator(), "operator", null, 0, 1, StringAttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStringAttributeWhereEntry_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, StringAttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanAttributeWhereEntryEClass, BooleanAttributeWhereEntry.class, "BooleanAttributeWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanAttributeWhereEntry_Operator(), this.getBooleanOperator(), "operator", null, 0, 1, BooleanAttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBooleanAttributeWhereEntry_IsTrue(), ecorePackage.getEBoolean(), "isTrue", null, 0, 1, BooleanAttributeWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullWhereEntryEClass, NullWhereEntry.class, "NullWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNullWhereEntry_Alias(), this.getFromEntry(), null, "alias", null, 0, 1, NullWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNullWhereEntry_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 0, 1, NullWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNullWhereEntry_Operator(), this.getBooleanOperator(), "operator", null, 0, 1, NullWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceAliasWhereEntryEClass, ReferenceAliasWhereEntry.class, "ReferenceAliasWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReferenceAliasWhereEntry_Alias(), this.getFromEntry(), null, "alias", null, 0, 1, ReferenceAliasWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceAliasWhereEntry_Reference(), ecorePackage.getEReference(), null, "reference", null, 0, 1, ReferenceAliasWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceAliasWhereEntry_RightAlias(), this.getFromEntry(), null, "rightAlias", null, 0, 1, ReferenceAliasWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subselectWhereEntryEClass, SubselectWhereEntry.class, "SubselectWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubselectWhereEntry_Alias(), this.getFromEntry(), null, "alias", null, 0, 1, SubselectWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubselectWhereEntry_Reference(), ecorePackage.getEReference(), null, "reference", null, 0, 1, SubselectWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSubselectWhereEntry_NotIn(), ecorePackage.getEBoolean(), "notIn", null, 0, 1, SubselectWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubselectWhereEntry_SubQuery(), this.getMQLquery(), null, "subQuery", null, 0, 1, SubselectWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aliasWhereEntryEClass, AliasWhereEntry.class, "AliasWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAliasWhereEntry_Alias(), this.getFromEntry(), null, "alias", null, 0, 1, AliasWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAliasWhereEntry_RightAlias(), this.getFromEntry(), null, "rightAlias", null, 0, 1, AliasWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orWhereEntryEClass, OrWhereEntry.class, "OrWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrWhereEntry_Entries(), this.getWhereEntry(), null, "entries", null, 0, -1, OrWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andWhereEntryEClass, AndWhereEntry.class, "AndWhereEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndWhereEntry_Entries(), this.getWhereEntry(), null, "entries", null, 0, -1, AndWhereEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(numericOperatorEEnum, NumericOperator.class, "NumericOperator");
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.LESS_THEN);
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.GREATER_THEN);
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.LESS_EQUAL);
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.GREATER_EQUAL);
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.EQUAL);
    addEEnumLiteral(numericOperatorEEnum, NumericOperator.NOT_EQUAL);

    initEEnum(stringOperatorEEnum, StringOperator.class, "StringOperator");
    addEEnumLiteral(stringOperatorEEnum, StringOperator.EQUAL);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.NOT_EQUAL);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.LIKE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.NOT_LIKE);

    initEEnum(booleanOperatorEEnum, BooleanOperator.class, "BooleanOperator");
    addEEnumLiteral(booleanOperatorEEnum, BooleanOperator.EQUAL);
    addEEnumLiteral(booleanOperatorEEnum, BooleanOperator.NOT_EQUAL);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug287941TestLanguagePackageImpl
