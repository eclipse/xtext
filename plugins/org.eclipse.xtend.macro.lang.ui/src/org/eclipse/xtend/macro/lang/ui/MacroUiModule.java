/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.macro.lang.ui.contentassist.MacroProposalProvider;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MacroUiModule extends org.eclipse.xtend.macro.lang.ui.AbstractMacroUiModule {
	public MacroUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
//	public void configureDebugMode(Binder binder) {
//		if (Boolean.getBoolean("org.eclipse.xtext.xtend.debug")) {
//			binder.bindConstant().annotatedWith(Names.named(AbstractEditStrategy.DEBUG)).to(true);
//		}
//		// matches ID of org.eclipse.ui.contexts extension registered in plugin.xml
//		binder.bindConstant().annotatedWith(Names.named(XtextEditor.KEY_BINDING_SCOPE)).to("org.eclipse.xtend.ide.XtendEditorScope");
//	}
//	
//	public void configureOverrideIndicatorSupport(Binder binder) {
//		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("OverrideIndicatorModelListener")) //$NON-NLS-1$
//				.to(OverrideIndicatorModelListener.class);
//		binder.bind(IActionContributor.class).annotatedWith(Names.named("OverrideIndicatorRulerAction")).to( //$NON-NLS-1$
//				OverrideIndicatorRulerAction.class);
//	}
//
//	@Override
//	public Class<? extends IAnnotationHover> bindIAnnotationHover () {
//		return XtendAnnotationHover.class;
//	}
//
//	@Override
//	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
//		return XtendHighlightingConfiguration.class;
//	}
//
//	@Override
//	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
//		return TokenToAttributeIdMapper.class;
//	}
//
//	@Override
//	public Class<? extends ITokenScanner> bindITokenScanner() {
//		return RichStringAwareTokenScanner.class;
//	}
//
//	@Override
//	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
//		return XtendHighlightingCalculator.class;
//	}
//
//	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
//		return TokenTypeToPartitionMapper.class;
//	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return MacroProposalProvider.class;
	}

//	@Override
//	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
//		return AutoEditStrategyProvider.class;
//	}
//
//	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
//		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace"))
//				.to(ShowWhitespaceCharactersActionContributor.class);
//	}
//
//	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
//		return XtendDoubleClickStrategyProvider.class;
//	}
//
//	@Override
//	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
//		return XtendOutlineNodeComparator.class;
//	}
//
//	public Class<? extends QuickOutlineFilterAndSorter> bindQuickOutlineFilterAndSorter() {
//		return XtendQuickOutlineFilterAndSorter.class;
//	}
//
//	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
//		return XtendFoldingRegionProvider.class;
//	}
//
//	@Override
//	public Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
//		return ImportingTypesProposalProvider.class;
//	}
//
//	@Override
//	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
//		return XtendOutlinePage.class;
//	}
//
//	@Override
//	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
//		return XtendHyperlinkHelper.class;
//	}
//
//	@Override
//	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
//		return XtendHoverProvider.class;
//	}
//	
//	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
//		return SourceRelativeFileSystemAccess.class;
//	}
//	
//	@Override
//	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
//		return SingleLineCommentHelper.class;
//	}
//	
//	public Class<? extends XtextSourceViewer.Factory> bindSourceViewerFactory() {
//		return RichStringAwareSourceViewer.Factory.class;
//	}
//	
//	public Class<? extends ToggleSLCommentAction.Factory> bindToggleCommentFactory() {
//		return RichStringAwareToggleCommentAction.Factory.class;
//	}
//	
//	public Class<? extends IFoldingStructureProvider> bindIFoldingStructureProvider(){
//		return InitiallyCollapsableAwareFoldingStructureProvider.class;
//	}
//	
//	@Override
//	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
//		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361385
//		return XtendFormatterFactory.class;
//	}
//	
//	@Override
//	public Class<? extends IOccurrenceComputer> bindIOccurrenceComputer() {
//		return OccurrenceComputer.class;
//	}
//	
//	@Override
//	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
//		return XtendNatureAddingEditorCallback.class;
//	}
//	
//	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
//		return XtendResourceUiServiceProvider.class;
//	}
//	
//	@Override
//	public ICharacterPairMatcher bindICharacterPairMatcher() {
//		return new DefaultCharacterPairMatcher(new char[] { '(', ')', '{', '}', '[', ']', '«', '»' });
//	}
//	
//	@Override
//	public Class<? extends IRenameElementHandler> bindIRenameElementHandler() {
//		return XtendRenameElementHandler.class;
//	}
//	
//	public Class<? extends RenameElementProcessor> bindRenameElementProcessor() {
//		return XtendRenameElementProcessor.class;
//	}
//	
//	@Override
//	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
//		return XtendRenameStrategy.class;
//	}
//	
//	@Override
//	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
//		return XtendReferenceUpdater.class;
//	}
//
//	public Class<? extends XbaseDeclarativeHoverSignatureProvider> bindXbaseDeclarativeHoverSignatureProvider(){
//		return XtendHoverSignatureProvider.class;
//	}
//	
//	@Override
//	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider(){
//		return XtendHoverDocumentationProvider.class;
//	}
//
//	@Override
//	public Class<? extends org.eclipse.xtext.ui.editor.XtextEditor> bindXtextEditor() {
//		return XbaseEditor.class;
//	}
//	
//	@Override
//	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
//		return TemplateProposalProvider.class;
//	}
//
//	public Class<? extends ITraceInformation> bindTraceInformation() {
//		return FileBasedTraceInformation.class;
//	}
//	
//	public Class<? extends IEditedResourceProvider> bindIEditedResourceProvider() {
//		return FormatterResourceProvider.class;
//	}
//	
//	public void configureFilterSyntheticMembersContribution(Binder binder) {
//		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("FilterSyntheticsContribution")).to(ShowSyntheticMembersContribution.class);
//	} 
//
//	@Override
//	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator> bindXbaseUIValidator() {
//		return org.eclipse.xtend.ide.validator.XtendUIValidator.class;
//	}
//	
//	public Class<? extends IDiagnosticConverter> bindIDiagnosticConverter() {
//		return PreferenceAwareDiagnosticConverter.class;
//	}
}
