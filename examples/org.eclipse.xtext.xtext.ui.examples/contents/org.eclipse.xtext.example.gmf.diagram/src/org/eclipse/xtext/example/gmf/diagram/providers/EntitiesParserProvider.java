package org.eclipse.xtext.example.gmf.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimpleTypeNameEditPart;
import org.eclipse.xtext.example.gmf.diagram.parsers.MessageFormatParser;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;

/**
 * @generated
 */
public class EntitiesParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser entityName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getEntityName_4001Parser() {
		if (entityName_4001Parser == null) {
			EAttribute[] features = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getType_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getType_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			entityName_4001Parser = parser;
		}
		return entityName_4001Parser;
	}

	/**
	 * @generated
	 */
	private IParser simpleTypeName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getSimpleTypeName_4002Parser() {
		if (simpleTypeName_4002Parser == null) {
			EAttribute[] features = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getType_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getType_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			simpleTypeName_4002Parser = parser;
		}
		return simpleTypeName_4002Parser;
	}

	/**
	 * @generated
	 */
	private IParser simpleProperty_2001Parser;

	/**
	 * @generated
	 */
	private IParser getSimpleProperty_2001Parser() {
		if (simpleProperty_2001Parser == null) {
			EAttribute[] features = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getProperty_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getProperty_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			simpleProperty_2001Parser = parser;
		}
		return simpleProperty_2001Parser;
	}

	/**
	 * @generated
	 */
	private IParser referenceName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getReferenceName_4003Parser() {
		if (referenceName_4003Parser == null) {
			EAttribute[] features = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getProperty_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { EntitiesPackage.eINSTANCE
					.getProperty_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			referenceName_4003Parser = parser;
		}
		return referenceName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EntityNameEditPart.VISUAL_ID:
			return getEntityName_4001Parser();
		case SimpleTypeNameEditPart.VISUAL_ID:
			return getSimpleTypeName_4002Parser();
		case SimplePropertyEditPart.VISUAL_ID:
			return getSimpleProperty_2001Parser();
		case ReferenceNameEditPart.VISUAL_ID:
			return getReferenceName_4003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(EntitiesVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EntitiesVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EntitiesElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
