/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug332217TestLanguageFactoryImpl extends EFactoryImpl implements Bug332217TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug332217TestLanguageFactory init()
  {
    try
    {
      Bug332217TestLanguageFactory theBug332217TestLanguageFactory = (Bug332217TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(Bug332217TestLanguagePackage.eNS_URI);
      if (theBug332217TestLanguageFactory != null)
      {
        return theBug332217TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug332217TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug332217TestLanguageFactoryImpl()
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
      case Bug332217TestLanguagePackage.MODEL: return createModel();
      case Bug332217TestLanguagePackage.PROPERTY_PATH_PART: return createPropertyPathPart();
      case Bug332217TestLanguagePackage.TYPE_DESCRIPTION: return createTypeDescription();
      case Bug332217TestLanguagePackage.PARAMETER: return createParameter();
      case Bug332217TestLanguagePackage.OBJECT_REFERENCE: return createObjectReference();
      case Bug332217TestLanguagePackage.EXPRESSION: return createExpression();
      case Bug332217TestLanguagePackage.SCALAR_EXPRESSION: return createScalarExpression();
      case Bug332217TestLanguagePackage.COLLECTION_EXPRESSION: return createCollectionExpression();
      case Bug332217TestLanguagePackage.STRING_LITERAL: return createStringLiteral();
      case Bug332217TestLanguagePackage.STRING_FUNCTION: return createStringFunction();
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL: return createCollectionLiteral();
      case Bug332217TestLanguagePackage.COLLECTION_FUNCTION: return createCollectionFunction();
      case Bug332217TestLanguagePackage.TABLE_VIEW: return createTableView();
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT: return createViewContentElement();
      case Bug332217TestLanguagePackage.SECTION: return createSection();
      case Bug332217TestLanguagePackage.CELL: return createCell();
      case Bug332217TestLanguagePackage.COLLECTION_ITERATOR: return createCollectionIterator();
      case Bug332217TestLanguagePackage.VIEW_ACTION: return createViewAction();
      case Bug332217TestLanguagePackage.SELECTOR: return createSelector();
      case Bug332217TestLanguagePackage.EXTERNAL_OPEN: return createExternalOpen();
      case Bug332217TestLanguagePackage.STRING_CONCAT: return createStringConcat();
      case Bug332217TestLanguagePackage.STRING_REPLACE: return createStringReplace();
      case Bug332217TestLanguagePackage.STRING_URL_CONFORM: return createStringUrlConform();
      case Bug332217TestLanguagePackage.STRING_SPLIT: return createStringSplit();
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
      case Bug332217TestLanguagePackage.TABLE_VIEW_STYLE:
        return createTableViewStyleFromString(eDataType, initialValue);
      case Bug332217TestLanguagePackage.CELL_TYPE:
        return createCellTypeFromString(eDataType, initialValue);
      case Bug332217TestLanguagePackage.CELL_ACCESSORY:
        return createCellAccessoryFromString(eDataType, initialValue);
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
      case Bug332217TestLanguagePackage.TABLE_VIEW_STYLE:
        return convertTableViewStyleToString(eDataType, instanceValue);
      case Bug332217TestLanguagePackage.CELL_TYPE:
        return convertCellTypeToString(eDataType, instanceValue);
      case Bug332217TestLanguagePackage.CELL_ACCESSORY:
        return convertCellAccessoryToString(eDataType, instanceValue);
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
  public PropertyPathPart createPropertyPathPart()
  {
    PropertyPathPartImpl propertyPathPart = new PropertyPathPartImpl();
    return propertyPathPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDescription createTypeDescription()
  {
    TypeDescriptionImpl typeDescription = new TypeDescriptionImpl();
    return typeDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReference createObjectReference()
  {
    ObjectReferenceImpl objectReference = new ObjectReferenceImpl();
    return objectReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression createScalarExpression()
  {
    ScalarExpressionImpl scalarExpression = new ScalarExpressionImpl();
    return scalarExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionExpression createCollectionExpression()
  {
    CollectionExpressionImpl collectionExpression = new CollectionExpressionImpl();
    return collectionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringFunction createStringFunction()
  {
    StringFunctionImpl stringFunction = new StringFunctionImpl();
    return stringFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteral createCollectionLiteral()
  {
    CollectionLiteralImpl collectionLiteral = new CollectionLiteralImpl();
    return collectionLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionFunction createCollectionFunction()
  {
    CollectionFunctionImpl collectionFunction = new CollectionFunctionImpl();
    return collectionFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableView createTableView()
  {
    TableViewImpl tableView = new TableViewImpl();
    return tableView;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewContentElement createViewContentElement()
  {
    ViewContentElementImpl viewContentElement = new ViewContentElementImpl();
    return viewContentElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Section createSection()
  {
    SectionImpl section = new SectionImpl();
    return section;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cell createCell()
  {
    CellImpl cell = new CellImpl();
    return cell;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionIterator createCollectionIterator()
  {
    CollectionIteratorImpl collectionIterator = new CollectionIteratorImpl();
    return collectionIterator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewAction createViewAction()
  {
    ViewActionImpl viewAction = new ViewActionImpl();
    return viewAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector createSelector()
  {
    SelectorImpl selector = new SelectorImpl();
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalOpen createExternalOpen()
  {
    ExternalOpenImpl externalOpen = new ExternalOpenImpl();
    return externalOpen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringConcat createStringConcat()
  {
    StringConcatImpl stringConcat = new StringConcatImpl();
    return stringConcat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringReplace createStringReplace()
  {
    StringReplaceImpl stringReplace = new StringReplaceImpl();
    return stringReplace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringUrlConform createStringUrlConform()
  {
    StringUrlConformImpl stringUrlConform = new StringUrlConformImpl();
    return stringUrlConform;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringSplit createStringSplit()
  {
    StringSplitImpl stringSplit = new StringSplitImpl();
    return stringSplit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableViewStyle createTableViewStyleFromString(EDataType eDataType, String initialValue)
  {
    TableViewStyle result = TableViewStyle.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTableViewStyleToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CellType createCellTypeFromString(EDataType eDataType, String initialValue)
  {
    CellType result = CellType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCellTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CellAccessory createCellAccessoryFromString(EDataType eDataType, String initialValue)
  {
    CellAccessory result = CellAccessory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCellAccessoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug332217TestLanguagePackage getBug332217TestLanguagePackage()
  {
    return (Bug332217TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug332217TestLanguagePackage getPackage()
  {
    return Bug332217TestLanguagePackage.eINSTANCE;
  }

} //Bug332217TestLanguageFactoryImpl
