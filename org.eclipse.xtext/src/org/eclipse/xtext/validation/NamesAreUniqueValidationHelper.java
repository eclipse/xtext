/*******************************************************************************
 * Copyright (c) 2009, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class NamesAreUniqueValidationHelper implements INamesAreUniqueValidationHelper {

	private ImmutableSet<EClass> clusterTypes = getClusterTypes();

	@Inject
	private OperationCanceledManager operationCanceledManager = new OperationCanceledManager();

	/**
	 * <p>
	 * Initialize the set of clustering types. A type is considered to be clustering if any instance of that type has to
	 * have a unique name when it is transformed to an {@link org.eclipse.xtext.resource.IEObjectDescription}. Instances
	 * that do not belong to the same cluster may have the same exported name.
	 * </p>
	 * <p>
	 * A clustering type will often be some kind of root type in a type hierarchy.
	 * </p>
	 */
	protected ImmutableSet<EClass> getClusterTypes() {
		return ImmutableSet.of(EcorePackage.Literals.EOBJECT);
	}

	/**
	 * @deprecated Since Xtext 2.22 implementations should adhere to the context provided via
	 *             {@link #checkUniqueNames(org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context, ValidationMessageAcceptor)}.
	 */
	@Deprecated
	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, ValidationMessageAcceptor acceptor) {
		checkUniqueNames(descriptions, (CancelIndicator) null, acceptor);
	}

	/**
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * The cancel indicator will be queried everytime a description has been processed. It should provide a fast answer
	 * about its canceled state.
	 * 
	 * @deprecated Since Xtext 2.22 implementations should adhere to the context provided via
	 *             {@link #checkUniqueNames(org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context, ValidationMessageAcceptor)}.
	 */
	@Deprecated
	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator,
			ValidationMessageAcceptor acceptor) {
		Iterator<IEObjectDescription> iter = descriptions.iterator();
		if (!iter.hasNext())
			return;
		Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterToNames = Maps.newHashMap();
		while (iter.hasNext()) {
			IEObjectDescription description = iter.next();
			checkDescriptionForDuplicatedName(description, clusterToNames, acceptor);
			operationCanceledManager.checkCanceled(cancelIndicator);
		}
	}

	/**
	 * @since 2.22
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void checkUniqueNames(Context context, ValidationMessageAcceptor acceptor) {
		if (!NamesAreUniqueValidationHelper.class.equals(getClass()) && context instanceof UniqueInResourceContext) {
			checkUniqueNames(context.getObjectsToValidate(), context.cancelIndicator(), acceptor);
		} else {
			doCheckUniqueNames(context, acceptor);
		}
	}

	/**
	 * @since 2.22
	 */
	protected void doCheckUniqueNames(Context context, ValidationMessageAcceptor acceptor) {
		CancelIndicator cancelIndicator = context.cancelIndicator();
		for (IEObjectDescription description : context.getObjectsToValidate()) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			doCheckUniqueIn(description, context, acceptor);
		}
	}

	/**
	 * @since 2.22
	 */
	protected void doCheckUniqueIn(IEObjectDescription description, Context context,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		Preconditions.checkArgument(!object.eIsProxy());

		EClass clusterType = getClusterType(description);
		if (clusterType == null) {
			return;
		}
		ISelectable validationScope = context.getValidationScope(description, clusterType);
		if (validationScope.isEmpty()) {
			return;
		}
		boolean caseSensitive = context.isCaseSensitive(object, clusterType);
		Iterable<IEObjectDescription> sameNames = validationScope.getExportedObjects(clusterType, description.getName(),
				!caseSensitive);
		if (sameNames instanceof Collection<?>) {
			if (((Collection<?>) sameNames).size() <= 1) {
				return;
			}
		}
		for (IEObjectDescription candidate : sameNames) {
			EObject otherObject = candidate.getEObjectOrProxy();
			if (object != otherObject && getAssociatedClusterType(candidate.getEClass()) == clusterType
					&& !otherObject.eIsProxy() || !candidate.getEObjectURI().equals(description.getEObjectURI())) {
				if (isDuplicate(description, candidate)) {
					createDuplicateNameError(description, clusterType, acceptor);
					return;
				}
			}
		}
	}

	/**
	 * Called with two descriptions that have the same name. May be specialized to consider further information from the
	 * user data.
	 * 
	 * @since 2.22
	 */
	protected boolean isDuplicate(IEObjectDescription description, IEObjectDescription candidate) {
		return true;
	}

	/**
	 * @deprecated Use
	 *             {@link #doCheckUniqueIn(IEObjectDescription, org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context, ValidationMessageAcceptor)}
	 *             instead.
	 */
	@Deprecated
	protected void checkDescriptionForDuplicatedName(IEObjectDescription description,
			Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterTypeToName,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		EClass eClass = object.eClass();
		QualifiedName qualifiedName = description.getName();
		EClass clusterType = getAssociatedClusterType(eClass);
		Map<QualifiedName, IEObjectDescription> nameToDescription = clusterTypeToName.get(clusterType);
		if (nameToDescription == null) {
			nameToDescription = Maps.newHashMap();
			nameToDescription.put(qualifiedName, description);
			clusterTypeToName.put(clusterType, nameToDescription);
		} else {
			if (nameToDescription.containsKey(qualifiedName)) {
				IEObjectDescription prevDescription = nameToDescription.get(qualifiedName);
				if (prevDescription != null) {
					createDuplicateNameError(prevDescription, clusterType, acceptor);
					nameToDescription.put(qualifiedName, null);
				}
				createDuplicateNameError(description, clusterType, acceptor);
			} else {
				nameToDescription.put(qualifiedName, description);
			}
		}
	}

	protected void createDuplicateNameError(IEObjectDescription description, EClass clusterType,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		EStructuralFeature feature = getNameFeature(object);
		acceptor.acceptError(getDuplicateNameErrorMessage(description, clusterType, feature), object, feature,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, getErrorCode());
	}

	/**
	 * Returns <code>null</code>. Clients may override if they desire to attach an error code to the created errors.
	 */
	protected String getErrorCode() {
		// TODO use built-in codes to allow generic quickfixes
		return null;
	}

	/**
	 * Build the error message for duplicated names. The default implementation will provide error messages of this
	 * form:
	 * <ul>
	 * <li>Duplicate Entity 'Sample'</li>
	 * <li>Duplicate Property 'Sample' in Entity 'EntityName'</li>
	 * </ul>
	 * If the container information will be helpful to locate the error or to understand the error it will be used,
	 * otherwise only the simple format will be built. Clients may override different methods that influence the error
	 * message.
	 * 
	 * @see #getNameFeature(EObject)
	 * @see #getTypeLabel(EClass)
	 * @see #getContainerForErrorMessage(EObject)
	 * @see #isContainerInformationHelpful(IEObjectDescription, String)
	 * @see #isContainerInformationHelpful(IEObjectDescription, EObject, String, EStructuralFeature)
	 */
	public String getDuplicateNameErrorMessage(IEObjectDescription description, EClass clusterType,
			EStructuralFeature feature) {
		EObject object = description.getEObjectOrProxy();
		String shortName = String.valueOf(feature != null ? object.eGet(feature) : "<unnamed>");
		StringBuilder result = new StringBuilder(64);
		result.append("Duplicate ");
		result.append(getTypeLabel(clusterType));
		result.append(" '");
		result.append(shortName);
		result.append("'");
		if (isContainerInformationHelpful(description, shortName)) {
			EObject container = getContainerForErrorMessage(object);
			if (container != null) {
				String containerTypeLabel = getTypeLabel(container.eClass());
				EStructuralFeature containerNameFeature = getNameFeature(container);
				if (isContainerInformationHelpful(description, container, containerTypeLabel, containerNameFeature)) {
					result.append(" in ");
					result.append(containerTypeLabel);
					if (containerNameFeature != null) {
						String containerName = String.valueOf(container.eGet(containerNameFeature));
						if (containerName != null) {
							result.append(" '");
							result.append(containerName);
							result.append("'");
						}
					}
				}
			}
		}
		return result.toString();
	}

	protected boolean isContainerInformationHelpful(IEObjectDescription description, EObject container,
			String containerTypeLabel, EStructuralFeature containerNameFeature) {
		return containerTypeLabel != null && containerNameFeature != null;
	}

	protected boolean isContainerInformationHelpful(IEObjectDescription description, String shortName) {
		return true;
	}

	protected EObject getContainerForErrorMessage(EObject object) {
		return object.eContainer();
	}

	protected String getTypeLabel(EClass eClass) {
		String name = eClass.getName();
		return name;
	}

	protected EStructuralFeature getNameFeature(EObject object) {
		return object.eClass().getEStructuralFeature("name");
	}

	/**
	 * @see #getAssociatedClusterType(EClass)
	 * @since 2.22
	 * @return the cluster type or <code>null</code> if the given description does not participate in the unique name
	 *         validation.
	 */
	protected EClass getClusterType(IEObjectDescription description) {
		return getAssociatedClusterType(description.getEClass());
	}

	/**
	 * Return the type that describes the set of instances that should have unique names. The default information will
	 * return the topmost type or the first super type that is contained in the set of cluster types
	 * ({@link NamesAreUniqueValidationHelper#getClusterTypes()}). Only the first super type will be taken into account
	 * when walking the hierarchy.
	 * 
	 * Return <code>null</code> if objects of the given type are not subject to validation.
	 */
	protected EClass getAssociatedClusterType(EClass eClass) {
		if (clusterTypes.contains(eClass))
			return eClass;
		EList<EClass> superTypes = eClass.getESuperTypes();
		if (superTypes.isEmpty())
			return eClass;
		return getAssociatedClusterType(superTypes.get(0));
	}

}
