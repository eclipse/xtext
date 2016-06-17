/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionFunction;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Expression;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringFunction;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug332217TestLanguagePackageImpl extends EPackageImpl implements Bug332217TestLanguagePackage
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
  private EClass propertyPathPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scalarExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableViewEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewContentElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cellEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionIteratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalOpenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringConcatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringReplaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringUrlConformEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringSplitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum tableViewStyleEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cellTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cellAccessoryEEnum = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug332217TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug332217TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug332217TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug332217TestLanguagePackage init()
  {
    if (isInited) return (Bug332217TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug332217TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug332217TestLanguagePackageImpl theBug332217TestLanguagePackage = (Bug332217TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug332217TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug332217TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug332217TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug332217TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug332217TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug332217TestLanguagePackage.eNS_URI, theBug332217TestLanguagePackage);
    return theBug332217TestLanguagePackage;
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
  public EReference getModel_Elements()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyPathPart()
  {
    return propertyPathPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyPathPart_Name()
  {
    return (EAttribute)propertyPathPartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDescription()
  {
    return typeDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDescription_Type()
  {
    return (EAttribute)typeDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDescription_Many()
  {
    return (EAttribute)typeDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter_Description()
  {
    return (EReference)parameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectReference()
  {
    return objectReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReference_Object()
  {
    return (EReference)objectReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReference_Tail()
  {
    return (EReference)objectReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScalarExpression()
  {
    return scalarExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionExpression()
  {
    return collectionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteral()
  {
    return stringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteral_Value()
  {
    return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringFunction()
  {
    return stringFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteral()
  {
    return collectionLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteral_Items()
  {
    return (EReference)collectionLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionFunction()
  {
    return collectionFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTableView()
  {
    return tableViewEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableView_Name()
  {
    return (EAttribute)tableViewEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableView_Content()
  {
    return (EReference)tableViewEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableView_Title()
  {
    return (EReference)tableViewEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableView_TitleImage()
  {
    return (EReference)tableViewEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableView_Style()
  {
    return (EAttribute)tableViewEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableView_Sections()
  {
    return (EReference)tableViewEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getViewContentElement()
  {
    return viewContentElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getViewContentElement_Iterator()
  {
    return (EReference)viewContentElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSection()
  {
    return sectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSection_Title()
  {
    return (EReference)sectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSection_Cells()
  {
    return (EReference)sectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCell()
  {
    return cellEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCell_Type()
  {
    return (EAttribute)cellEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCell_Text()
  {
    return (EReference)cellEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCell_Details()
  {
    return (EReference)cellEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCell_Image()
  {
    return (EReference)cellEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCell_Action()
  {
    return (EReference)cellEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCell_Accessory()
  {
    return (EAttribute)cellEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionIterator()
  {
    return collectionIteratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionIterator_Collection()
  {
    return (EReference)collectionIteratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getViewAction()
  {
    return viewActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelector()
  {
    return selectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSelector_Name()
  {
    return (EAttribute)selectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalOpen()
  {
    return externalOpenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalOpen_Url()
  {
    return (EReference)externalOpenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringConcat()
  {
    return stringConcatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringConcat_Values()
  {
    return (EReference)stringConcatEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringReplace()
  {
    return stringReplaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringReplace_Value()
  {
    return (EReference)stringReplaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringReplace_Match()
  {
    return (EReference)stringReplaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringReplace_Replacement()
  {
    return (EReference)stringReplaceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringUrlConform()
  {
    return stringUrlConformEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringUrlConform_Value()
  {
    return (EReference)stringUrlConformEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringSplit()
  {
    return stringSplitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringSplit_Value()
  {
    return (EReference)stringSplitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringSplit_Delimiter()
  {
    return (EReference)stringSplitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTableViewStyle()
  {
    return tableViewStyleEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCellType()
  {
    return cellTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCellAccessory()
  {
    return cellAccessoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug332217TestLanguageFactory getBug332217TestLanguageFactory()
  {
    return (Bug332217TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__ELEMENTS);

    propertyPathPartEClass = createEClass(PROPERTY_PATH_PART);
    createEAttribute(propertyPathPartEClass, PROPERTY_PATH_PART__NAME);

    typeDescriptionEClass = createEClass(TYPE_DESCRIPTION);
    createEAttribute(typeDescriptionEClass, TYPE_DESCRIPTION__TYPE);
    createEAttribute(typeDescriptionEClass, TYPE_DESCRIPTION__MANY);

    parameterEClass = createEClass(PARAMETER);
    createEReference(parameterEClass, PARAMETER__DESCRIPTION);

    objectReferenceEClass = createEClass(OBJECT_REFERENCE);
    createEReference(objectReferenceEClass, OBJECT_REFERENCE__OBJECT);
    createEReference(objectReferenceEClass, OBJECT_REFERENCE__TAIL);

    expressionEClass = createEClass(EXPRESSION);

    scalarExpressionEClass = createEClass(SCALAR_EXPRESSION);

    collectionExpressionEClass = createEClass(COLLECTION_EXPRESSION);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    stringFunctionEClass = createEClass(STRING_FUNCTION);

    collectionLiteralEClass = createEClass(COLLECTION_LITERAL);
    createEReference(collectionLiteralEClass, COLLECTION_LITERAL__ITEMS);

    collectionFunctionEClass = createEClass(COLLECTION_FUNCTION);

    tableViewEClass = createEClass(TABLE_VIEW);
    createEAttribute(tableViewEClass, TABLE_VIEW__NAME);
    createEReference(tableViewEClass, TABLE_VIEW__CONTENT);
    createEReference(tableViewEClass, TABLE_VIEW__TITLE);
    createEReference(tableViewEClass, TABLE_VIEW__TITLE_IMAGE);
    createEAttribute(tableViewEClass, TABLE_VIEW__STYLE);
    createEReference(tableViewEClass, TABLE_VIEW__SECTIONS);

    viewContentElementEClass = createEClass(VIEW_CONTENT_ELEMENT);
    createEReference(viewContentElementEClass, VIEW_CONTENT_ELEMENT__ITERATOR);

    sectionEClass = createEClass(SECTION);
    createEReference(sectionEClass, SECTION__TITLE);
    createEReference(sectionEClass, SECTION__CELLS);

    cellEClass = createEClass(CELL);
    createEAttribute(cellEClass, CELL__TYPE);
    createEReference(cellEClass, CELL__TEXT);
    createEReference(cellEClass, CELL__DETAILS);
    createEReference(cellEClass, CELL__IMAGE);
    createEReference(cellEClass, CELL__ACTION);
    createEAttribute(cellEClass, CELL__ACCESSORY);

    collectionIteratorEClass = createEClass(COLLECTION_ITERATOR);
    createEReference(collectionIteratorEClass, COLLECTION_ITERATOR__COLLECTION);

    viewActionEClass = createEClass(VIEW_ACTION);

    selectorEClass = createEClass(SELECTOR);
    createEAttribute(selectorEClass, SELECTOR__NAME);

    externalOpenEClass = createEClass(EXTERNAL_OPEN);
    createEReference(externalOpenEClass, EXTERNAL_OPEN__URL);

    stringConcatEClass = createEClass(STRING_CONCAT);
    createEReference(stringConcatEClass, STRING_CONCAT__VALUES);

    stringReplaceEClass = createEClass(STRING_REPLACE);
    createEReference(stringReplaceEClass, STRING_REPLACE__VALUE);
    createEReference(stringReplaceEClass, STRING_REPLACE__MATCH);
    createEReference(stringReplaceEClass, STRING_REPLACE__REPLACEMENT);

    stringUrlConformEClass = createEClass(STRING_URL_CONFORM);
    createEReference(stringUrlConformEClass, STRING_URL_CONFORM__VALUE);

    stringSplitEClass = createEClass(STRING_SPLIT);
    createEReference(stringSplitEClass, STRING_SPLIT__VALUE);
    createEReference(stringSplitEClass, STRING_SPLIT__DELIMITER);

    // Create enums
    tableViewStyleEEnum = createEEnum(TABLE_VIEW_STYLE);
    cellTypeEEnum = createEEnum(CELL_TYPE);
    cellAccessoryEEnum = createEEnum(CELL_ACCESSORY);
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
    parameterEClass.getESuperTypes().add(this.getPropertyPathPart());
    objectReferenceEClass.getESuperTypes().add(this.getExpression());
    objectReferenceEClass.getESuperTypes().add(this.getScalarExpression());
    objectReferenceEClass.getESuperTypes().add(this.getCollectionExpression());
    stringLiteralEClass.getESuperTypes().add(this.getExpression());
    stringLiteralEClass.getESuperTypes().add(this.getScalarExpression());
    stringFunctionEClass.getESuperTypes().add(this.getExpression());
    stringFunctionEClass.getESuperTypes().add(this.getScalarExpression());
    collectionLiteralEClass.getESuperTypes().add(this.getExpression());
    collectionLiteralEClass.getESuperTypes().add(this.getCollectionExpression());
    collectionFunctionEClass.getESuperTypes().add(this.getExpression());
    collectionFunctionEClass.getESuperTypes().add(this.getCollectionExpression());
    sectionEClass.getESuperTypes().add(this.getViewContentElement());
    cellEClass.getESuperTypes().add(this.getViewContentElement());
    collectionIteratorEClass.getESuperTypes().add(this.getPropertyPathPart());
    selectorEClass.getESuperTypes().add(this.getViewAction());
    externalOpenEClass.getESuperTypes().add(this.getViewAction());
    stringConcatEClass.getESuperTypes().add(this.getStringFunction());
    stringReplaceEClass.getESuperTypes().add(this.getStringFunction());
    stringUrlConformEClass.getESuperTypes().add(this.getStringFunction());
    stringSplitEClass.getESuperTypes().add(this.getCollectionFunction());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Elements(), this.getTableView(), null, "elements", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyPathPartEClass, PropertyPathPart.class, "PropertyPathPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyPathPart_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyPathPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeDescriptionEClass, TypeDescription.class, "TypeDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeDescription_Type(), ecorePackage.getEString(), "type", null, 0, 1, TypeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeDescription_Many(), ecorePackage.getEBoolean(), "many", null, 0, 1, TypeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameter_Description(), this.getTypeDescription(), null, "description", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectReferenceEClass, ObjectReference.class, "ObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectReference_Object(), this.getPropertyPathPart(), null, "object", null, 0, 1, ObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectReference_Tail(), this.getObjectReference(), null, "tail", null, 0, 1, ObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(scalarExpressionEClass, ScalarExpression.class, "ScalarExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(collectionExpressionEClass, CollectionExpression.class, "CollectionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringFunctionEClass, StringFunction.class, "StringFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(collectionLiteralEClass, CollectionLiteral.class, "CollectionLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionLiteral_Items(), this.getScalarExpression(), null, "items", null, 0, -1, CollectionLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionFunctionEClass, CollectionFunction.class, "CollectionFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tableViewEClass, TableView.class, "TableView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTableView_Name(), ecorePackage.getEString(), "name", null, 0, 1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableView_Content(), this.getParameter(), null, "content", null, 0, 1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableView_Title(), this.getScalarExpression(), null, "title", null, 0, 1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableView_TitleImage(), this.getScalarExpression(), null, "titleImage", null, 0, 1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTableView_Style(), this.getTableViewStyle(), "style", null, 0, 1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableView_Sections(), this.getSection(), null, "sections", null, 0, -1, TableView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(viewContentElementEClass, ViewContentElement.class, "ViewContentElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getViewContentElement_Iterator(), this.getCollectionIterator(), null, "iterator", null, 0, 1, ViewContentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSection_Title(), this.getScalarExpression(), null, "title", null, 0, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSection_Cells(), this.getCell(), null, "cells", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cellEClass, Cell.class, "Cell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCell_Type(), this.getCellType(), "type", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCell_Text(), this.getScalarExpression(), null, "text", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCell_Details(), this.getScalarExpression(), null, "details", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCell_Image(), this.getScalarExpression(), null, "image", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCell_Action(), this.getViewAction(), null, "action", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCell_Accessory(), this.getCellAccessory(), "accessory", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionIteratorEClass, CollectionIterator.class, "CollectionIterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionIterator_Collection(), this.getCollectionExpression(), null, "collection", null, 0, 1, CollectionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(viewActionEClass, ViewAction.class, "ViewAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(selectorEClass, Selector.class, "Selector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSelector_Name(), ecorePackage.getEString(), "name", null, 0, 1, Selector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalOpenEClass, ExternalOpen.class, "ExternalOpen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExternalOpen_Url(), this.getScalarExpression(), null, "url", null, 0, 1, ExternalOpen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringConcatEClass, StringConcat.class, "StringConcat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringConcat_Values(), this.getScalarExpression(), null, "values", null, 0, -1, StringConcat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringReplaceEClass, StringReplace.class, "StringReplace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringReplace_Value(), this.getScalarExpression(), null, "value", null, 0, 1, StringReplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStringReplace_Match(), this.getScalarExpression(), null, "match", null, 0, 1, StringReplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStringReplace_Replacement(), this.getScalarExpression(), null, "replacement", null, 0, 1, StringReplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringUrlConformEClass, StringUrlConform.class, "StringUrlConform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringUrlConform_Value(), this.getScalarExpression(), null, "value", null, 0, 1, StringUrlConform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringSplitEClass, StringSplit.class, "StringSplit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringSplit_Value(), this.getScalarExpression(), null, "value", null, 0, 1, StringSplit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStringSplit_Delimiter(), this.getScalarExpression(), null, "delimiter", null, 0, 1, StringSplit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(tableViewStyleEEnum, TableViewStyle.class, "TableViewStyle");
    addEEnumLiteral(tableViewStyleEEnum, TableViewStyle.PLAIN);
    addEEnumLiteral(tableViewStyleEEnum, TableViewStyle.GROUPED);

    initEEnum(cellTypeEEnum, CellType.class, "CellType");
    addEEnumLiteral(cellTypeEEnum, CellType.DEFAULT);
    addEEnumLiteral(cellTypeEEnum, CellType.VALUE1);
    addEEnumLiteral(cellTypeEEnum, CellType.VALUE2);
    addEEnumLiteral(cellTypeEEnum, CellType.SUBTITLE);

    initEEnum(cellAccessoryEEnum, CellAccessory.class, "CellAccessory");
    addEEnumLiteral(cellAccessoryEEnum, CellAccessory.NONE);
    addEEnumLiteral(cellAccessoryEEnum, CellAccessory.LINK);
    addEEnumLiteral(cellAccessoryEEnum, CellAccessory.DETAIL);
    addEEnumLiteral(cellAccessoryEEnum, CellAccessory.CHECK);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug332217TestLanguagePackageImpl
