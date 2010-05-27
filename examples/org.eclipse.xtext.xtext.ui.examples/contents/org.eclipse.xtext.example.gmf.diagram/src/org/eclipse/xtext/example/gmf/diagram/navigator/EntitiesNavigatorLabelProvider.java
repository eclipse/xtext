package org.eclipse.xtext.example.gmf.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityExtendsEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimpleTypeEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimpleTypeNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesParserProvider;

/**
 * @generated
 */
public class EntitiesNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EntitiesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EntitiesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EntitiesNavigatorItem
				&& !isOwnView(((EntitiesNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EntitiesNavigatorGroup) {
			EntitiesNavigatorGroup group = (EntitiesNavigatorGroup) element;
			return EntitiesDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof EntitiesNavigatorItem) {
			EntitiesNavigatorItem navigatorItem = (EntitiesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case SimplePropertyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/xtext/example/gmf/Entities?SimpleProperty", EntitiesElementTypes.SimpleProperty_2001); //$NON-NLS-1$
		case EntityExtendsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/xtext/example/gmf/Entities?Entity?extends", EntitiesElementTypes.EntityExtends_3002); //$NON-NLS-1$
		case ReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/xtext/example/gmf/Entities?Reference", EntitiesElementTypes.Reference_3001); //$NON-NLS-1$
		case EntityEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/xtext/example/gmf/Entities?Entity", EntitiesElementTypes.Entity_1001); //$NON-NLS-1$
		case ModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.eclipse.org/xtext/example/gmf/Entities?Model", EntitiesElementTypes.Model_79); //$NON-NLS-1$
		case SimpleTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/xtext/example/gmf/Entities?SimpleType", EntitiesElementTypes.SimpleType_1002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EntitiesDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& EntitiesElementTypes.isKnownElementType(elementType)) {
			image = EntitiesElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof EntitiesNavigatorGroup) {
			EntitiesNavigatorGroup group = (EntitiesNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EntitiesNavigatorItem) {
			EntitiesNavigatorItem navigatorItem = (EntitiesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (EntitiesVisualIDRegistry.getVisualID(view)) {
		case SimplePropertyEditPart.VISUAL_ID:
			return getSimpleProperty_2001Text(view);
		case EntityExtendsEditPart.VISUAL_ID:
			return getEntityExtends_3002Text(view);
		case ReferenceEditPart.VISUAL_ID:
			return getReference_3001Text(view);
		case EntityEditPart.VISUAL_ID:
			return getEntity_1001Text(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_79Text(view);
		case SimpleTypeEditPart.VISUAL_ID:
			return getSimpleType_1002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getModel_79Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntity_1001Text(View view) {
		IParser parser = EntitiesParserProvider.getParser(
				EntitiesElementTypes.Entity_1001,
				view.getElement() != null ? view.getElement() : view,
				EntitiesVisualIDRegistry.getType(EntityNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSimpleType_1002Text(View view) {
		IParser parser = EntitiesParserProvider.getParser(
				EntitiesElementTypes.SimpleType_1002,
				view.getElement() != null ? view.getElement() : view,
				EntitiesVisualIDRegistry
						.getType(SimpleTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSimpleProperty_2001Text(View view) {
		IParser parser = EntitiesParserProvider.getParser(
				EntitiesElementTypes.SimpleProperty_2001,
				view.getElement() != null ? view.getElement() : view,
				EntitiesVisualIDRegistry
						.getType(SimplePropertyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getReference_3001Text(View view) {
		IParser parser = EntitiesParserProvider.getParser(
				EntitiesElementTypes.Reference_3001,
				view.getElement() != null ? view.getElement() : view,
				EntitiesVisualIDRegistry
						.getType(ReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EntitiesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEntityExtends_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ModelEditPart.MODEL_ID.equals(EntitiesVisualIDRegistry
				.getModelID(view));
	}

}
