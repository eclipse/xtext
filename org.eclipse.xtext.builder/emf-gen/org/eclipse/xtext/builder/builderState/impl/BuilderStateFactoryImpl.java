/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStateFactoryImpl.java,v 1.12 2010/08/04 09:04:36 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.DataConverter;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.xtext.builder.builderState.*;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.EObjectDescription;
import org.eclipse.xtext.builder.builderState.ReferenceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Strings;

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
			BuilderStateFactory theBuilderStateFactory = (BuilderStateFactory)EPackage.Registry.INSTANCE.getEFactory(BuilderStatePackage.eNS_URI);
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION: return createEObjectDescription();
			case BuilderStatePackage.USER_DATA_ENTRY: return (EObject)createUserDataEntry();
			case BuilderStatePackage.REFERENCE_DESCRIPTION: return createReferenceDescription();
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
			case BuilderStatePackage.QUALIFIED_NAME:
				return createQualifiedNameFromString(eDataType, initialValue);
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
			case BuilderStatePackage.QUALIFIED_NAME:
				return convertQualifiedNameToString(eDataType, instanceValue);
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
	public IResourceDescription createResourceDescription() {
		ResourceDescriptionImpl resourceDescription = new ResourceDescriptionImpl();
		return resourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObjectDescription createEObjectDescription() {
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
	@Override
	public ReferenceDescription createReferenceDescription() {
		ReferenceDescriptionImpl referenceDescription = new ReferenceDescriptionImpl();
		return referenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI createEURIFromString(EDataType eDataType, String initialValue) {
		return URI.createURI(initialValue, true);
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
	 * @generated NOT
	 */
	public QualifiedName createQualifiedNameFromString(EDataType eDataType, String initialValue) {
		return QualifiedName.create(Strings.unpack(initialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertQualifiedNameToString(EDataType eDataType, Object instanceValue) {
		QualifiedName qn = (QualifiedName) instanceValue;
		String[] array = qn.getSegments().toArray(new String[qn.getSegmentCount()]);
		String packed = Strings.pack(array);
		if (packed == null)
			return "";
		return packed; 
	}

	private static final DataConverter<QualifiedName> QUALIFIED_NAME_DATA_CONVERTER =
		new DataConverter<QualifiedName>() {
			@Override
			public QualifiedName read(EObjectInputStream eObjectInputStream) throws IOException {
				return QualifiedName.createFromStream(eObjectInputStream);
			}

			@Override
			protected void doWrite(EObjectOutputStream eObjectOutputStream, QualifiedName value) throws IOException {
				value.writeToStream(eObjectOutputStream);
			}
		};

	private static final DataConverter<URI> URI_DATA_CONVERTER =
		new DataConverter<URI>() {
			@Override
			public URI read(EObjectInputStream eObjectInputStream) throws IOException {
				return eObjectInputStream.readURI();
			}

			@Override
			protected void doWrite(EObjectOutputStream eObjectOutputStream, URI value) throws IOException {
				eObjectOutputStream.writeURI(value);
			}
		};

	@Override
	public DataConverter<?> create(EDataType eDataType) {
		if (eDataType == BuilderStatePackage.Literals.QUALIFIED_NAME) {
			return QUALIFIED_NAME_DATA_CONVERTER;
		} else if (eDataType == BuilderStatePackage.Literals.EURI) {
			return URI_DATA_CONVERTER;
		} else {
			return super.create(eDataType);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuilderStatePackage getBuilderStatePackage() {
		return (BuilderStatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Deprecated
	public static BuilderStatePackage getPackage() {
		return BuilderStatePackage.eINSTANCE;
	}

} //BuilderStateFactoryImpl
