/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

/**
 * Inspects the caller stack to decide whether it is ok to use an Xbase editor to edit a java file or whether the user
 * really expects the Java editor, e.g. by selecting a generated Java file explicitly in the package explorer.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.3
 */
public class StacktraceBasedEditorDecider {

	public enum Decision {
		FORCE_JAVA, /* FORCE_XBASE, */FAVOR_XBASE
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	public Decision decideAccordingToCaller() {
		Decision result = doDecideAccordingToCaller(true);
		return result;
	}

	protected Decision doDecideAccordingToCaller(boolean respectPackageExplorer) {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : trace) {
			//	if (isOpenTypeAction(element))
			//	return Decision.FORCE_XBASE;
			if (isSourceLookup(element))
				return Decision.FORCE_JAVA;
			if (isNavigationHistory(element))
				return Decision.FORCE_JAVA;
			if (respectPackageExplorer && isPackageExplorerOrNavigator(element))
				return Decision.FORCE_JAVA;
			if (isOpenResource(element))
				return Decision.FORCE_JAVA;
			if (isFileOpener(element))
				return Decision.FORCE_JAVA;
			if (isFileSearch(element))
				return Decision.FORCE_JAVA;
			if (isOpenCompareEditor(element))
				return Decision.FORCE_JAVA;
			if (isOpenSelectedMarkers(element))
				return Decision.FORCE_JAVA;
			if (isLightweightDecorationManager(element))
				return Decision.FORCE_JAVA;
		}
		return Decision.FAVOR_XBASE;
	}
	
	protected boolean isLightweightDecorationManager(StackTraceElement element) {
		return "org.eclipse.ui.internal.decorators.LightweightDecoratorDefinition".equals(element
				.getClassName()) && "decorate".equals(element.getMethodName());
	}

	protected boolean isOpenSelectedMarkers(StackTraceElement element) {
		return "org.eclipse.ui.internal.views.markers.ExtendedMarkersView".equals(element
				.getClassName()) && "openSelectedMarkers".equals(element.getMethodName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	public Decision decideAccordingToCallerForSimpleFileName() {
		return doDecideAccordingToCaller(false);
	}

	protected boolean isNavigationHistory(StackTraceElement element) {
		return "org.eclipse.ui.internal.NavigationHistory".equals(element.getClassName());
	}

	protected boolean isLineBasedOpenEditorAction() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		if (trace.length > 3) {
			StackTraceElement element = trace[2];
			boolean result = ("org.eclipse.jdt.internal.junit.ui.OpenTestAction".equals(element.getClassName()) || "org.eclipse.jdt.internal.junit.ui.OpenEditorAtLineAction"
					.equals(element.getClassName())) && "reveal".equals(element.getMethodName());
			if (result)
				return result;
			result = "org.eclipse.jdt.internal.debug.ui.console.JavaStackTraceHyperlink".equals(element.getClassName())
					&& "processSearchResult".equals(element.getMethodName());
			return result;
		}
		return false;
	}

	/**
	 * Happens when one select a stack element in the debugger. Since wie use JSR-45 we don't want to modify JDT's
	 * behavior.
	 * 
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isSourceLookup(StackTraceElement element) {
		return "org.eclipse.debug.internal.ui.sourcelookup.SourceLookupFacility".equals(element.getClassName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	public boolean isCalledFromFindReferences() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		for (StackTraceElement element : trace) {
			if (isFindReferences(element))
				return true;
		}
		return false;
	}

	public boolean isEditorUtilityIsOpenInEditor() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		for (StackTraceElement element : trace) {
			if (isEditorUtilityIsOpenInEditor(element))
				return true;
		}
		return false;
	}

	public boolean isJDI() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		for (StackTraceElement element : trace) {
			if (isJDIModelPresentationGetEditorID(element))
				return true;
		}
		return false;
	}

	public boolean isJavaStackTraceHyperlink() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		for (StackTraceElement element : trace) {
			if (isJavaStackTraceHyperlink(element))
				return true;
		}
		return false;
	}

	protected boolean isJavaStackTraceHyperlink(StackTraceElement ele) {
		return "org.eclipse.jdt.internal.debug.ui.console.JavaStackTraceHyperlink".equals(ele.getClassName());
	}

	public boolean isJDIModelPresentationGetEditorID(StackTraceElement element) {
		return "org.eclipse.jdt.internal.debug.ui.JDIModelPresentation".equals(element.getClassName())
				&& "getEditorId".equals(element.getMethodName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isEditorUtilityIsOpenInEditor(StackTraceElement element) {
		return "org.eclipse.jdt.internal.ui.javaeditor.EditorUtility".equals(element.getClassName())
				&& ("isOpenInEditor".equals(element.getMethodName()));
	}

	// org.eclipse.jdt.internal.junit.ui.OpenEditorAction.run()
	// invokes a selecAndReveal only for methods and no for a class
	// So we do always expect an selecAndReveal but we do not throw an error
	// if there is no invocation
	public boolean isOpenEditorAction() {
		StackTraceElement[] trace = new Exception().getStackTrace();
		for (StackTraceElement element : trace) {
			if (isOpenEditorAction(element))
				return true;
		}
		return false;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isOpenEditorAction(StackTraceElement element) {
		return "org.eclipse.jdt.internal.junit.ui.OpenEditorAction".equals(element.getClassName())
				&& ("run".equals(element.getMethodName()));
	}

	// It is currently not possible to supersede an open editor
	// thus if a Java editor for Foo.java is open and the user wants to
	// open Foo.xtend, the Open Type dialog will always reveal Foo.java since
	// the Editor input for Foo.java matches a currently open editor. In other words:
	// No new editor will be opened anyway so such a guard is pointless.
	//	protected boolean isOpenTypeAction(StackTraceElement element) {
	//		return "org.eclipse.jdt.internal.ui.actions.OpenTypeAction".equals(element.getClassName());
	//	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isFindReferences(StackTraceElement element) {
		return "org.eclipse.jdt.internal.ui.search.JavaSearchResultPage".equals(element.getClassName())
				&& "showMatch".equals(element.getMethodName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isPackageExplorerOrNavigator(StackTraceElement element) {
		return "org.eclipse.jdt.internal.ui.packageview.PackageExplorerActionGroup".equals(element.getClassName())
				&& "handleOpen".equals(element.getMethodName())
				|| "org.eclipse.ui.navigator.CommonViewer".equals(element.getClassName())
				&& "handleOpen".equals(element.getMethodName())
				|| "org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart".equals(element.getClassName())
				&& "linkToEditor".equals(element.getMethodName())
				|| "org.eclipse.jdt.internal.ui.navigator.JavaFileLinkHelper".equals(element.getClassName())
				&& "activateEditor".equals(element.getMethodName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isOpenResource(StackTraceElement element) {
		return "org.eclipse.ui.internal.ide.handlers.OpenResourceHandler".equals(element.getClassName())
				&& "execute".equals(element.getMethodName());
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isFileOpener(StackTraceElement element) {
		return "org.eclipse.xtext.ui.generator.trace.EditorInputBasedFileOpener".equals(element.getClassName())
				|| "org.eclipse.xtext.ui.generator.trace.StorageBasedTextEditorOpener".equals(element.getClassName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isFileSearch(StackTraceElement element) {
		return "org.eclipse.search.internal.ui.text.FileSearchPage".equals(element.getClassName())
				&& "showMatch".equals(element.getMethodName());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected boolean isOpenCompareEditor(StackTraceElement element) {
		return "org.eclipse.compare.CompareUI".equals(element.getClassName())
				&& "openCompareEditor".equals(element.getMethodName());
	}

}
