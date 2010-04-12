/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStateFactoryImpl.java,v 1.11 2010/04/12 20:19:21 szarnekow Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.ignorecase.IIgnoreCaseResourceDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuilderStateFactoryImpl extends EFactoryImpl implements BuilderStateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BuilderStateFactory init() {
		try {
			BuilderStateFactory theBuilderStateFactory = (BuilderStateFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/builderstate/1.0"); 
			if (theBuilderStateFactory != null) {
				return theBuilderStateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BuilderStateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderStateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BuilderStatePackage.RESOURCE_DESCRIPTION: return (EObject)createResourceDescription();
			case BuilderStatePackage.EOBJECT_DESCRIPTION: return (EObject)createEObjectDescription();
			case BuilderStatePackage.USER_DATA_ENTRY: return (EObject)createUserDataEntry();
			case BuilderStatePackage.REFERENCE_DESCRIPTION: return (EObject)createReferenceDescription();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BuilderStatePackage.EURI:
				return createEURIFromString(eDataType, initialValue);
			case BuilderStatePackage.ESTRING_ARRAY:
				return createEStringArrayFromString(eDataType, initialValue);
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
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BuilderStatePackage.EURI:
				return convertEURIToString(eDataType, instanceValue);
			case BuilderStatePackage.ESTRING_ARRAY:
				return convertEStringArrayToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IIgnoreCaseResourceDescription createResourceDescription() {
		ResourceDescriptionImpl resourceDescription = new ResourceDescriptionImpl();
		return resourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEObjectDescription createEObjectDescription() {
		EObjectDescriptionImpl eObjectDescription = new EObjectDescriptionImpl();
		return eObjectDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createUserDataEntry() {
		UserDataEntryImpl userDataEntry = new UserDataEntryImpl();
		return userDataEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IReferenceDescription createReferenceDescription() {
		ReferenceDescriptionImpl referenceDescription = new ReferenceDescriptionImpl();
		return referenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI createEURIFromString(EDataType eDataType, String initialValue) {
		return URI.createURI(initialValue, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEURIToString(EDataType eDataType, Object instanceValue) {
		URI uri = (URI) instanceValue;
		return uri.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object[] createEStringArrayFromString(EDataType eDataType, String initialValue) {
		return (Object[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEStringArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderStatePackage getBuilderStatePackage() {
		return (BuilderStatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BuilderStatePackage getPackage() {
		return BuilderStatePackage.eINSTANCE;
	}

} //BuilderStateFactoryImpl
