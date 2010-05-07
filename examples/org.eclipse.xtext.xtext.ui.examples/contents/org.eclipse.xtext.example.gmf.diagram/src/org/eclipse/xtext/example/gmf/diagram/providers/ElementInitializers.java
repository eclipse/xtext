package org.eclipse.xtext.example.gmf.diagram.providers;

import org.eclipse.xtext.example.gmf.diagram.expressions.EntitiesOCLFactory;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;
import org.eclipse.xtext.example.gmf.entities.Entity;
import org.eclipse.xtext.example.gmf.entities.Reference;
import org.eclipse.xtext.example.gmf.entities.SimpleProperty;
import org.eclipse.xtext.example.gmf.entities.SimpleType;

/**
 * @generated
 */
public class ElementInitializers {
	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Entity_1001(Entity instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression(0,
					EntitiesPackage.eINSTANCE.getEntity(), null).evaluate(
					instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SimpleType_1002(SimpleType instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression(2,
					EntitiesPackage.eINSTANCE.getSimpleType(), null).evaluate(
					instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SimpleProperty_2001(SimpleProperty instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression(1,
					EntitiesPackage.eINSTANCE.getSimpleProperty(), null)
					.evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Reference_3001(Reference instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression(3,
					EntitiesPackage.eINSTANCE.getReference(), null).evaluate(
					instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = EntitiesDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			EntitiesDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}

}
