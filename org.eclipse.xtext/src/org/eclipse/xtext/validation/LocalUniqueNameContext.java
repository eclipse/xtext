/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;

/**
 * <p>A case-sensitive, local validation context to check unique names in the contents of 
 * a container {@link EObject} or within a list.
 * </p>
 * Sample usage in a validator:
 * 
 * <pre>
 * class MyDslValidator extends AbstractDeclarativeValidator {
 * 	&#64;Inject
 * 	private INamesAreUniqueValidationHelper helper;
 * 
 * 	&#64;Check
 * 	public void checkUniqueNames(Model model) {
 * 		helper.checkUniqueNames(new LocalUniqueNameContext(model, getCancelIndicator()), this);
 * 	}
 * }
 * </pre>
 * 
 * @see INamesAreUniqueValidationHelper#checkUniqueNames(Context, ValidationMessageAcceptor)
 * 
 * @since 2.22
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class LocalUniqueNameContext implements INamesAreUniqueValidationHelper.Context, ISelectable {

	private final List<IEObjectDescription> objectsToValidate;
	private final Map<String, Object> index;
	private final CancelIndicator ci;

	public LocalUniqueNameContext(EObject container, Function<EObject, String> nameFunction, CancelIndicator ci) {
		this(container, false, nameFunction, ci);
	}

	public LocalUniqueNameContext(EObject container, CancelIndicator ci) {
		this(container, LocalUniqueNameContext::tryGetName, ci);
	}

	public LocalUniqueNameContext(EObject container, boolean deep, CancelIndicator ci) {
		this(container, deep, LocalUniqueNameContext::tryGetName, ci);
	}

	public LocalUniqueNameContext(EObject container, boolean deep, Function<EObject, String> nameFunction, CancelIndicator ci) {
		this(deep ? () -> container.eAllContents() : container.eContents(), nameFunction, ci);
	}

	public <T extends EObject> LocalUniqueNameContext(Iterable<T> objects, Function<T, String> nameFunction, CancelIndicator ci) {
		Map<String, Object> index = new HashMap<>();
		List<IEObjectDescription> objectsToValidate = new ArrayList<>();
		for (T t : objects) {
			String name = nameFunction.apply(t);
			if (name != null) {
				IEObjectDescription description = EObjectDescription.create(name, t);
				objectsToValidate.add(description);
				index.merge(name, description, (p, n)->{
					if (p instanceof List<?>) {
						@SuppressWarnings("unchecked")
						List<Object> list = (List<Object>) p;
						list.add(n);
						return list;
					}
					List<Object> list = new ArrayList<>();
					list.add(p);
					list.add(n);
					return list;
				});
			}
		}
		this.objectsToValidate = objectsToValidate;
		this.index = index;
		this.ci = ci;
	}

	public LocalUniqueNameContext(List<? extends EObject> objects, CancelIndicator ci) {
		this(objects, LocalUniqueNameContext::tryGetName, ci);
	}

	@Override
	public boolean isUnique() {
		return objectsToValidate.size() == index.size();
	}

	@Override
	public final boolean isCaseSensitive(EObject candidate, EClass clusterType) {
		return true;
	}

	@Override
	public ISelectable getValidationScope(IEObjectDescription description, EClass clusterType) {
		return this;
	}

	@Override
	public List<IEObjectDescription> getObjectsToValidate() {
		return objectsToValidate;
	}

	@Override
	public CancelIndicator cancelIndicator() {
		return ci;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return getObjectsToValidate();
	}

	@Override
	public boolean isEmpty() {
		return index.isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		Preconditions.checkArgument(!ignoreCase);
		Object result = index.get(name.getFirstSegment());
		if (result == null) {
			return Collections.emptyList();
		}
		if (result instanceof IEObjectDescription) {
			if (EcoreUtil2.isAssignableFrom(type, ((IEObjectDescription) result).getEClass())) {
				return Collections.singletonList((IEObjectDescription)result);
			}
			return Collections.emptyList();
		}
		@SuppressWarnings("unchecked")
		List<IEObjectDescription> casted = (List<IEObjectDescription>) result;
		if (type == EcorePackage.Literals.EOBJECT) {
			return casted;
		}
		return FluentIterable.from(casted).filter(it -> EcoreUtil2.isAssignableFrom(type, it.getEClass()));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return FluentIterable.from(objectsToValidate).filter(it -> object == it.getEObjectOrProxy());
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return FluentIterable.from(objectsToValidate).filter(it -> EcoreUtil2.isAssignableFrom(type, it.getEClass()));
	}

	/**
	 * Read the value of an EAttribute 'name', if present. Returns null if 
	 * <ul>
	 * <li>the given object is null,<li> 
	 * <li>does not have an attribute 'name' of type String, or</li>
	 * <li>the value of the attribute 'name' itself is null.</li>
	 * </ul>
	 */
	private static String tryGetName(EObject obj) {
		if (obj == null) {
			return null;
		}
		EStructuralFeature name = obj.eClass().getEStructuralFeature("name");
		if (name != null && name.getEType() == EcorePackage.Literals.ESTRING) {
			return (String) obj.eGet(name);
		}
		return null;
	}
}
