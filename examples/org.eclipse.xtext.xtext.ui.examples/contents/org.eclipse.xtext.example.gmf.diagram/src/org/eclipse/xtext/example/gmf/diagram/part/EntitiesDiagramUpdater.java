package org.eclipse.xtext.example.gmf.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityExtendsEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntitySimpleNameCompartmentEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimpleTypeEditPart;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;
import org.eclipse.xtext.example.gmf.entities.Entity;
import org.eclipse.xtext.example.gmf.entities.Model;
import org.eclipse.xtext.example.gmf.entities.Property;
import org.eclipse.xtext.example.gmf.entities.Reference;
import org.eclipse.xtext.example.gmf.entities.Type;

/**
 * @generated
 */
public class EntitiesDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<EntitiesNodeDescriptor> getSemanticChildren(View view) {
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_79SemanticChildren(view);
		case EntitySimpleNameCompartmentEditPart.VISUAL_ID:
			return getEntitySimpleNameCompartment_5001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesNodeDescriptor> getEntitySimpleNameCompartment_5001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Entity modelElement = (Entity) containerView.getElement();
		LinkedList<EntitiesNodeDescriptor> result = new LinkedList<EntitiesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getProperties().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = EntitiesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SimplePropertyEditPart.VISUAL_ID) {
				result.add(new EntitiesNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EntitiesNodeDescriptor> getModel_79SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model) view.getElement();
		LinkedList<EntitiesNodeDescriptor> result = new LinkedList<EntitiesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it
				.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = EntitiesVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EntityEditPart.VISUAL_ID) {
				result.add(new EntitiesNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SimpleTypeEditPart.VISUAL_ID) {
				result.add(new EntitiesNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getContainedLinks(View view) {
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_79ContainedLinks(view);
		case EntityEditPart.VISUAL_ID:
			return getEntity_1001ContainedLinks(view);
		case SimpleTypeEditPart.VISUAL_ID:
			return getSimpleType_1002ContainedLinks(view);
		case SimplePropertyEditPart.VISUAL_ID:
			return getSimpleProperty_2001ContainedLinks(view);
		case ReferenceEditPart.VISUAL_ID:
			return getReference_3001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getIncomingLinks(View view) {
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case EntityEditPart.VISUAL_ID:
			return getEntity_1001IncomingLinks(view);
		case SimpleTypeEditPart.VISUAL_ID:
			return getSimpleType_1002IncomingLinks(view);
		case SimplePropertyEditPart.VISUAL_ID:
			return getSimpleProperty_2001IncomingLinks(view);
		case ReferenceEditPart.VISUAL_ID:
			return getReference_3001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getOutgoingLinks(View view) {
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case EntityEditPart.VISUAL_ID:
			return getEntity_1001OutgoingLinks(view);
		case SimpleTypeEditPart.VISUAL_ID:
			return getSimpleType_1002OutgoingLinks(view);
		case SimplePropertyEditPart.VISUAL_ID:
			return getSimpleProperty_2001OutgoingLinks(view);
		case ReferenceEditPart.VISUAL_ID:
			return getReference_3001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getModel_79ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getEntity_1001ContainedLinks(
			View view) {
		Entity modelElement = (Entity) view.getElement();
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Reference_3001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Entity_Extends_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleType_1002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleProperty_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getReference_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getEntity_1001IncomingLinks(
			View view) {
		Entity modelElement = (Entity) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Reference_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Entity_Extends_3002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleType_1002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleProperty_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getReference_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getEntity_1001OutgoingLinks(
			View view) {
		Entity modelElement = (Entity) view.getElement();
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Reference_3001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Entity_Extends_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleType_1002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getSimpleProperty_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EntitiesLinkDescriptor> getReference_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<EntitiesLinkDescriptor> getContainedTypeModelFacetLinks_Reference_3001(
			Entity container) {
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		for (Iterator<?> links = container.getProperties().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Reference) {
				continue;
			}
			Reference link = (Reference) linkObject;
			if (ReferenceEditPart.VISUAL_ID != EntitiesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Entity dst = link.getType();
			result.add(new EntitiesLinkDescriptor(container, dst, link,
					EntitiesElementTypes.Reference_3001,
					ReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EntitiesLinkDescriptor> getIncomingTypeModelFacetLinks_Reference_3001(
			Entity target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != EntitiesPackage.eINSTANCE
					.getReference_Type()
					|| false == setting.getEObject() instanceof Reference) {
				continue;
			}
			Reference link = (Reference) setting.getEObject();
			if (ReferenceEditPart.VISUAL_ID != EntitiesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Entity) {
				continue;
			}
			Entity container = (Entity) link.eContainer();
			result.add(new EntitiesLinkDescriptor(container, target, link,
					EntitiesElementTypes.Reference_3001,
					ReferenceEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EntitiesLinkDescriptor> getIncomingFeatureModelFacetLinks_Entity_Extends_3002(
			Entity target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == EntitiesPackage.eINSTANCE
					.getEntity_Extends()) {
				result.add(new EntitiesLinkDescriptor(setting.getEObject(),
						target, EntitiesElementTypes.EntityExtends_3002,
						EntityExtendsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EntitiesLinkDescriptor> getOutgoingFeatureModelFacetLinks_Entity_Extends_3002(
			Entity source) {
		LinkedList<EntitiesLinkDescriptor> result = new LinkedList<EntitiesLinkDescriptor>();
		Entity destination = source.getExtends();
		if (destination == null) {
			return result;
		}
		result.add(new EntitiesLinkDescriptor(source, destination,
				EntitiesElementTypes.EntityExtends_3002,
				EntityExtendsEditPart.VISUAL_ID));
		return result;
	}

}
