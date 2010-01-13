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
	/**
	 * @generated
	 */
	public static void init_Entity_1001(Entity instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression("\'default\'",
					EntitiesPackage.eINSTANCE.getEntity()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_SimpleType_1002(SimpleType instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression("\'default\'",
					EntitiesPackage.eINSTANCE.getSimpleType()).evaluate(
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
	public static void init_SimpleProperty_2001(SimpleProperty instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression("\'default\'",
					EntitiesPackage.eINSTANCE.getSimpleProperty()).evaluate(
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
	public static void init_Reference_3001(Reference instance) {
		try {
			Object value_0 = EntitiesOCLFactory.getExpression("\'ref\'",
					EntitiesPackage.eINSTANCE.getReference())
					.evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
