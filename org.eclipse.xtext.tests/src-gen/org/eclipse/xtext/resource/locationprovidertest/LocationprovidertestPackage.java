/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

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
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestFactory
 * @model kind="package"
 * @generated
 */
public interface LocationprovidertestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "locationprovidertest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/locationProviderTestLaguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "locationprovidertest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LocationprovidertestPackage eINSTANCE = org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.ModelImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 0;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__COMPONENTS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Singleref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__SINGLEREF = 1;

  /**
   * The feature id for the '<em><b>Multirefs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__MULTIREFS = 2;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ComponentImpl <em>Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.ComponentImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getComponent()
   * @generated
   */
  int COMPONENT = 2;

  /**
   * The feature id for the '<em><b>Mode</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__MODE = 0;

  /**
   * The feature id for the '<em><b>Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__TRANSITION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__NAME = 2;

  /**
   * The number of structural features of the '<em>Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.BusImpl <em>Bus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.BusImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getBus()
   * @generated
   */
  int BUS = 3;

  /**
   * The feature id for the '<em><b>Mode</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUS__MODE = COMPONENT__MODE;

  /**
   * The feature id for the '<em><b>Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUS__TRANSITION = COMPONENT__TRANSITION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUS__NAME = COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Port</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUS__PORT = COMPONENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUS_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ProcessorImpl <em>Processor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.ProcessorImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getProcessor()
   * @generated
   */
  int PROCESSOR = 4;

  /**
   * The feature id for the '<em><b>Mode</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__MODE = COMPONENT__MODE;

  /**
   * The feature id for the '<em><b>Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__TRANSITION = COMPONENT__TRANSITION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__NAME = COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__DATA = COMPONENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Processor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ModeImpl <em>Mode</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.ModeImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getMode()
   * @generated
   */
  int MODE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE__NAME = 0;

  /**
   * The number of structural features of the '<em>Mode</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.TransitionImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__SOURCE = 1;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__DESTINATION = 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.PortImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getPort()
   * @generated
   */
  int PORT = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = 0;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.DataImpl <em>Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.DataImpl
   * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getData()
   * @generated
   */
  int DATA = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA__NAME = 0;

  /**
   * The number of structural features of the '<em>Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Model#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Components</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Model#getComponents()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Components();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.resource.locationprovidertest.Element#getSingleref <em>Singleref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Singleref</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Element#getSingleref()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Singleref();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Element#getMultirefs <em>Multirefs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Multirefs</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Element#getMultirefs()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Multirefs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Component
   * @generated
   */
  EClass getComponent();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Component#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mode</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Component#getMode()
   * @see #getComponent()
   * @generated
   */
  EReference getComponent_Mode();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Component#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Component#getTransition()
   * @see #getComponent()
   * @generated
   */
  EReference getComponent_Transition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Component#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Component#getName()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Bus <em>Bus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bus</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Bus
   * @generated
   */
  EClass getBus();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Bus#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Port</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Bus#getPort()
   * @see #getBus()
   * @generated
   */
  EReference getBus_Port();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Processor <em>Processor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Processor</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Processor
   * @generated
   */
  EClass getProcessor();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.locationprovidertest.Processor#getData <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Processor#getData()
   * @see #getProcessor()
   * @generated
   */
  EReference getProcessor_Data();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Mode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mode</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Mode
   * @generated
   */
  EClass getMode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Mode#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Mode#getName()
   * @see #getMode()
   * @generated
   */
  EAttribute getMode_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Transition#getSource()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Source();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Transition#getDestination()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Destination();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Port#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Port#getName()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.locationprovidertest.Data <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Data
   * @generated
   */
  EClass getData();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.locationprovidertest.Data#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.locationprovidertest.Data#getName()
   * @see #getData()
   * @generated
   */
  EAttribute getData_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LocationprovidertestFactory getLocationprovidertestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.ModelImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__COMPONENTS = eINSTANCE.getModel_Components();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Singleref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__SINGLEREF = eINSTANCE.getElement_Singleref();

    /**
     * The meta object literal for the '<em><b>Multirefs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__MULTIREFS = eINSTANCE.getElement_Multirefs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.ComponentImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getComponent()
     * @generated
     */
    EClass COMPONENT = eINSTANCE.getComponent();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT__MODE = eINSTANCE.getComponent_Mode();

    /**
     * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT__TRANSITION = eINSTANCE.getComponent_Transition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.BusImpl <em>Bus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.BusImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getBus()
     * @generated
     */
    EClass BUS = eINSTANCE.getBus();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUS__PORT = eINSTANCE.getBus_Port();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ProcessorImpl <em>Processor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.ProcessorImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getProcessor()
     * @generated
     */
    EClass PROCESSOR = eINSTANCE.getProcessor();

    /**
     * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCESSOR__DATA = eINSTANCE.getProcessor_Data();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.ModeImpl <em>Mode</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.ModeImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getMode()
     * @generated
     */
    EClass MODE = eINSTANCE.getMode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODE__NAME = eINSTANCE.getMode_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.TransitionImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__DESTINATION = eINSTANCE.getTransition_Destination();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.PortImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__NAME = eINSTANCE.getPort_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.locationprovidertest.impl.DataImpl <em>Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.DataImpl
     * @see org.eclipse.xtext.resource.locationprovidertest.impl.LocationprovidertestPackageImpl#getData()
     * @generated
     */
    EClass DATA = eINSTANCE.getData();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA__NAME = eINSTANCE.getData_Name();

  }

} //LocationprovidertestPackage
