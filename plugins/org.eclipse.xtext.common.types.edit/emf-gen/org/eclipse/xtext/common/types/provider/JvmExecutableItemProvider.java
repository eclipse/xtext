/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.xtext.common.types.JvmExecutable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmExecutableItemProvider extends JvmFeatureItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmExecutableItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addVarArgsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Var Args feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVarArgsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmExecutable_varArgs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmExecutable_varArgs_feature", "_UI_JvmExecutable_type"),
				 TypesPackage.Literals.JVM_EXECUTABLE__VAR_ARGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS);
			childrenFeatures.add(TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS);
			childrenFeatures.add(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((JvmExecutable)object).getSimpleName();
		return label == null || label.length() == 0 ?
			getString("_UI_JvmExecutable_type") :
			getString("_UI_JvmExecutable_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(JvmExecutable.class))
		{
			case TypesPackage.JVM_EXECUTABLE__VAR_ARGS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TypesPackage.JVM_EXECUTABLE__TYPE_PARAMETERS:
			case TypesPackage.JVM_EXECUTABLE__PARAMETERS:
			case TypesPackage.JVM_EXECUTABLE__EXCEPTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS,
				 TypesFactory.eINSTANCE.createJvmTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS,
				 TypesFactory.eINSTANCE.createJvmFormalParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmWildcardTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmAnyTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmMultiTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmDelegateTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmSynonymTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS,
				 TypesFactory.eINSTANCE.createJvmUnknownTypeReference()));
	}

}
