/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug287941TestLanguageFactoryImpl extends EFactoryImpl implements Bug287941TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug287941TestLanguageFactory init()
  {
    try
    {
      Bug287941TestLanguageFactory theBug287941TestLanguageFactory = (Bug287941TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/tmf/tests/2009/bug287941TestLanguage"); 
      if (theBug287941TestLanguageFactory != null)
      {
        return theBug287941TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug287941TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287941TestLanguageFactoryImpl()
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
      case Bug287941TestLanguagePackage.MODEL: return createModel();
      case Bug287941TestLanguagePackage.IMPORT: return createImport();
      case Bug287941TestLanguagePackage.MQ_LQUERY: return createMQLquery();
      case Bug287941TestLanguagePackage.SELECT_ENTRY: return createSelectEntry();
      case Bug287941TestLanguagePackage.FROM_ENTRY: return createFromEntry();
      case Bug287941TestLanguagePackage.SCOPE_CLAUSE: return createScopeClause();
      case Bug287941TestLanguagePackage.SCOPE: return createScope();
      case Bug287941TestLanguagePackage.RESOURCE_SCOPE: return createResourceScope();
      case Bug287941TestLanguagePackage.ELEMENT_SCOPE: return createElementScope();
      case Bug287941TestLanguagePackage.WHERE_ENTRY: return createWhereEntry();
      case Bug287941TestLanguagePackage.ATTRIBUTE_WHERE_ENTRY: return createAttributeWhereEntry();
      case Bug287941TestLanguagePackage.NUMERIC_ATTRIBUTE_WHERE_ENTRY: return createNumericAttributeWhereEntry();
      case Bug287941TestLanguagePackage.DOUBLE_WHERE_ENTRY: return createDoubleWhereEntry();
      case Bug287941TestLanguagePackage.LONG_WHERE_ENTRY: return createLongWhereEntry();
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY: return createVariableWhereEntry();
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY: return createStringAttributeWhereEntry();
      case Bug287941TestLanguagePackage.BOOLEAN_ATTRIBUTE_WHERE_ENTRY: return createBooleanAttributeWhereEntry();
      case Bug287941TestLanguagePackage.NULL_WHERE_ENTRY: return createNullWhereEntry();
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY: return createReferenceAliasWhereEntry();
      case Bug287941TestLanguagePackage.SUBSELECT_WHERE_ENTRY: return createSubselectWhereEntry();
      case Bug287941TestLanguagePackage.ALIAS_WHERE_ENTRY: return createAliasWhereEntry();
      case Bug287941TestLanguagePackage.OR_WHERE_ENTRY: return createOrWhereEntry();
      case Bug287941TestLanguagePackage.AND_WHERE_ENTRY: return createAndWhereEntry();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug287941TestLanguagePackage.NUMERIC_OPERATOR:
        return createNumericOperatorFromString(eDataType, initialValue);
      case Bug287941TestLanguagePackage.STRING_OPERATOR:
        return createStringOperatorFromString(eDataType, initialValue);
      case Bug287941TestLanguagePackage.BOOLEAN_OPERATOR:
        return createBooleanOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug287941TestLanguagePackage.NUMERIC_OPERATOR:
        return convertNumericOperatorToString(eDataType, instanceValue);
      case Bug287941TestLanguagePackage.STRING_OPERATOR:
        return convertStringOperatorToString(eDataType, instanceValue);
      case Bug287941TestLanguagePackage.BOOLEAN_OPERATOR:
        return convertBooleanOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MQLquery createMQLquery()
  {
    MQLqueryImpl mqLquery = new MQLqueryImpl();
    return mqLquery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectEntry createSelectEntry()
  {
    SelectEntryImpl selectEntry = new SelectEntryImpl();
    return selectEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry createFromEntry()
  {
    FromEntryImpl fromEntry = new FromEntryImpl();
    return fromEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopeClause createScopeClause()
  {
    ScopeClauseImpl scopeClause = new ScopeClauseImpl();
    return scopeClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope createScope()
  {
    ScopeImpl scope = new ScopeImpl();
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceScope createResourceScope()
  {
    ResourceScopeImpl resourceScope = new ResourceScopeImpl();
    return resourceScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementScope createElementScope()
  {
    ElementScopeImpl elementScope = new ElementScopeImpl();
    return elementScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhereEntry createWhereEntry()
  {
    WhereEntryImpl whereEntry = new WhereEntryImpl();
    return whereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeWhereEntry createAttributeWhereEntry()
  {
    AttributeWhereEntryImpl attributeWhereEntry = new AttributeWhereEntryImpl();
    return attributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericAttributeWhereEntry createNumericAttributeWhereEntry()
  {
    NumericAttributeWhereEntryImpl numericAttributeWhereEntry = new NumericAttributeWhereEntryImpl();
    return numericAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleWhereEntry createDoubleWhereEntry()
  {
    DoubleWhereEntryImpl doubleWhereEntry = new DoubleWhereEntryImpl();
    return doubleWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongWhereEntry createLongWhereEntry()
  {
    LongWhereEntryImpl longWhereEntry = new LongWhereEntryImpl();
    return longWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableWhereEntry createVariableWhereEntry()
  {
    VariableWhereEntryImpl variableWhereEntry = new VariableWhereEntryImpl();
    return variableWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringAttributeWhereEntry createStringAttributeWhereEntry()
  {
    StringAttributeWhereEntryImpl stringAttributeWhereEntry = new StringAttributeWhereEntryImpl();
    return stringAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAttributeWhereEntry createBooleanAttributeWhereEntry()
  {
    BooleanAttributeWhereEntryImpl booleanAttributeWhereEntry = new BooleanAttributeWhereEntryImpl();
    return booleanAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullWhereEntry createNullWhereEntry()
  {
    NullWhereEntryImpl nullWhereEntry = new NullWhereEntryImpl();
    return nullWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceAliasWhereEntry createReferenceAliasWhereEntry()
  {
    ReferenceAliasWhereEntryImpl referenceAliasWhereEntry = new ReferenceAliasWhereEntryImpl();
    return referenceAliasWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubselectWhereEntry createSubselectWhereEntry()
  {
    SubselectWhereEntryImpl subselectWhereEntry = new SubselectWhereEntryImpl();
    return subselectWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AliasWhereEntry createAliasWhereEntry()
  {
    AliasWhereEntryImpl aliasWhereEntry = new AliasWhereEntryImpl();
    return aliasWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrWhereEntry createOrWhereEntry()
  {
    OrWhereEntryImpl orWhereEntry = new OrWhereEntryImpl();
    return orWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndWhereEntry createAndWhereEntry()
  {
    AndWhereEntryImpl andWhereEntry = new AndWhereEntryImpl();
    return andWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericOperator createNumericOperatorFromString(EDataType eDataType, String initialValue)
  {
    NumericOperator result = NumericOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNumericOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringOperator createStringOperatorFromString(EDataType eDataType, String initialValue)
  {
    StringOperator result = StringOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStringOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperator createBooleanOperatorFromString(EDataType eDataType, String initialValue)
  {
    BooleanOperator result = BooleanOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287941TestLanguagePackage getBug287941TestLanguagePackage()
  {
    return (Bug287941TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug287941TestLanguagePackage getPackage()
  {
    return Bug287941TestLanguagePackage.eINSTANCE;
  }

} //Bug287941TestLanguageFactoryImpl
