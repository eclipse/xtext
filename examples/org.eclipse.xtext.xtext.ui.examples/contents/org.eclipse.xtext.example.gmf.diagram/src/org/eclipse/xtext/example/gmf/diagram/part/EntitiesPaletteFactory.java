package org.eclipse.xtext.example.gmf.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;

/**
 * @generated
 */
public class EntitiesPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createEntities1Group());
	}

	/**
	 * Creates "entities" palette tool group
	 * @generated
	 */
	private PaletteContainer createEntities1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Entities1Group_title);
		paletteContainer.setId("createEntities1Group"); //$NON-NLS-1$
		paletteContainer.add(createEntity1CreationTool());
		paletteContainer.add(createSimpleType2CreationTool());
		paletteContainer.add(createSuperType3CreationTool());
		paletteContainer.add(createSimpleProperty4CreationTool());
		paletteContainer.add(createReferenceProperty5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntity1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EntitiesElementTypes.Entity_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Entity1CreationTool_title,
				Messages.Entity1CreationTool_desc, types);
		entry.setId("createEntity1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EntitiesElementTypes
				.getImageDescriptor(EntitiesElementTypes.Entity_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSimpleType2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EntitiesElementTypes.SimpleType_1002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SimpleType2CreationTool_title,
				Messages.SimpleType2CreationTool_desc, types);
		entry.setId("createSimpleType2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EntitiesElementTypes
				.getImageDescriptor(EntitiesElementTypes.SimpleType_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSuperType3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EntitiesElementTypes.EntityExtends_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.SuperType3CreationTool_title,
				Messages.SuperType3CreationTool_desc, types);
		entry.setId("createSuperType3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(EntitiesDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.xtext.example.gmf.edit/icons/full/obj16/Generalization.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(EntitiesDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.xtext.example.gmf.edit/icons/full/obj16/Generalization.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSimpleProperty4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EntitiesElementTypes.SimpleProperty_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SimpleProperty4CreationTool_title,
				Messages.SimpleProperty4CreationTool_desc, types);
		entry.setId("createSimpleProperty4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EntitiesElementTypes
				.getImageDescriptor(EntitiesElementTypes.SimpleProperty_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReferenceProperty5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EntitiesElementTypes.Reference_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ReferenceProperty5CreationTool_title,
				Messages.ReferenceProperty5CreationTool_desc, types);
		entry.setId("createReferenceProperty5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EntitiesElementTypes
				.getImageDescriptor(EntitiesElementTypes.Reference_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
