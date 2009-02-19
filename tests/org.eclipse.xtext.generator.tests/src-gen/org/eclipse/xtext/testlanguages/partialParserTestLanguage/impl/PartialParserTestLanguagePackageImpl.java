/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParserTestLanguagePackageImpl.java,v 1.4 2009/02/19 16:26:57 sefftinge Exp $
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Container;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Content;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguageFactory;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialParserTestLanguagePackageImpl extends EPackageImpl implements PartialParserTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass containerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass childrenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass childEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractChildrenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass firstConcreteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondConcreteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedEClass = null;

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
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PartialParserTestLanguagePackageImpl()
  {
    super(eNS_URI, PartialParserTestLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PartialParserTestLanguagePackage init()
  {
    if (isInited) return (PartialParserTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(PartialParserTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    PartialParserTestLanguagePackageImpl thePartialParserTestLanguagePackage = (PartialParserTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PartialParserTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PartialParserTestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    thePartialParserTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    thePartialParserTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePartialParserTestLanguagePackage.freeze();

    return thePartialParserTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContainer()
  {
    return containerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContainer_Name()
  {
    return (EAttribute)containerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContainer_Nested()
  {
    return (EReference)containerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContainer_Content()
  {
    return (EReference)containerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNested()
  {
    return nestedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNested_Nested()
  {
    return (EReference)nestedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContent()
  {
    return contentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChildren()
  {
    return childrenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChildren_Children()
  {
    return (EReference)childrenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChild()
  {
    return childEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChild_Value()
  {
    return (EReference)childEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractChildren()
  {
    return abstractChildrenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractChildren_AbstractChildren()
  {
    return (EReference)abstractChildrenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractChild()
  {
    return abstractChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractChild_Value()
  {
    return (EReference)abstractChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFirstConcrete()
  {
    return firstConcreteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFirstConcrete_ReferencedContainer()
  {
    return (EReference)firstConcreteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondConcrete()
  {
    return secondConcreteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondConcrete_ReferencedChildren()
  {
    return (EReference)secondConcreteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamed()
  {
    return namedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamed_Name()
  {
    return (EAttribute)namedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialParserTestLanguageFactory getPartialParserTestLanguageFactory()
  {
    return (PartialParserTestLanguageFactory)getEFactoryInstance();
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
    containerEClass = createEClass(CONTAINER);
    createEAttribute(containerEClass, CONTAINER__NAME);
    createEReference(containerEClass, CONTAINER__NESTED);
    createEReference(containerEClass, CONTAINER__CONTENT);

    nestedEClass = createEClass(NESTED);
    createEReference(nestedEClass, NESTED__NESTED);

    contentEClass = createEClass(CONTENT);

    childrenEClass = createEClass(CHILDREN);
    createEReference(childrenEClass, CHILDREN__CHILDREN);

    childEClass = createEClass(CHILD);
    createEReference(childEClass, CHILD__VALUE);

    abstractChildrenEClass = createEClass(ABSTRACT_CHILDREN);
    createEReference(abstractChildrenEClass, ABSTRACT_CHILDREN__ABSTRACT_CHILDREN);

    abstractChildEClass = createEClass(ABSTRACT_CHILD);
    createEReference(abstractChildEClass, ABSTRACT_CHILD__VALUE);

    firstConcreteEClass = createEClass(FIRST_CONCRETE);
    createEReference(firstConcreteEClass, FIRST_CONCRETE__REFERENCED_CONTAINER);

    secondConcreteEClass = createEClass(SECOND_CONCRETE);
    createEReference(secondConcreteEClass, SECOND_CONCRETE__REFERENCED_CHILDREN);

    namedEClass = createEClass(NAMED);
    createEAttribute(namedEClass, NAMED__NAME);
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
    childrenEClass.getESuperTypes().add(this.getContent());
    abstractChildrenEClass.getESuperTypes().add(this.getContent());
    firstConcreteEClass.getESuperTypes().add(this.getAbstractChild());
    secondConcreteEClass.getESuperTypes().add(this.getAbstractChild());

    // Initialize classes and features; add operations and parameters
    initEClass(containerEClass, Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContainer_Nested(), this.getNested(), null, "nested", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContainer_Content(), this.getContent(), null, "content", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedEClass, Nested.class, "Nested", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNested_Nested(), this.getContainer(), null, "nested", null, 0, -1, Nested.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contentEClass, Content.class, "Content", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(childrenEClass, Children.class, "Children", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChildren_Children(), this.getChild(), null, "children", null, 0, -1, Children.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChild_Value(), this.getNamed(), null, "value", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractChildrenEClass, AbstractChildren.class, "AbstractChildren", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractChildren_AbstractChildren(), this.getAbstractChild(), null, "abstractChildren", null, 0, -1, AbstractChildren.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractChildEClass, AbstractChild.class, "AbstractChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractChild_Value(), this.getNamed(), null, "value", null, 0, 1, AbstractChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(firstConcreteEClass, FirstConcrete.class, "FirstConcrete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFirstConcrete_ReferencedContainer(), this.getContainer(), null, "referencedContainer", null, 0, 1, FirstConcrete.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondConcreteEClass, SecondConcrete.class, "SecondConcrete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondConcrete_ReferencedChildren(), this.getChild(), null, "referencedChildren", null, 0, -1, SecondConcrete.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedEClass, Named.class, "Named", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamed_Name(), ecorePackage.getEString(), "name", null, 0, 1, Named.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //PartialParserTestLanguagePackageImpl
