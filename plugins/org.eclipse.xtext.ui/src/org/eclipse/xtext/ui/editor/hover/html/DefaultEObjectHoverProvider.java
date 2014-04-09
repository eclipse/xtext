/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import static org.eclipse.xtext.util.Strings.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.internal.text.html.BrowserInput;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension4;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.ibm.icu.text.MessageFormat;

/**
 * Returns a html string as documentation. Delegates to another IEObjectDocumentationProvider and adds
 * the objects type and label at the beginning.
 * 
 * @author Christoph Kulla - Initial contribution and API
 * @author Sven Efftinge
 */
public class DefaultEObjectHoverProvider implements IEObjectHoverProvider {

	@Inject
	private ILabelProvider labelProvider;

	@Inject 
	private IEObjectHoverDocumentationProvider decoratedProvider;
	
	@Inject
	private IQualifiedNameProvider nameProvider;

	protected String getHoverInfoAsHtml(EObject o) {
		if (!hasHover(o))
			return null;
		StringBuffer buffer = new StringBuffer();
		buffer.append (getFirstLine(o));
		String documentation = getDocumentation(o);
		if (documentation!=null && documentation.length()>0) {
			buffer.append("<p>");
			buffer.append(documentation);
			buffer.append("</p>");
		}
		return buffer.toString();
	}
	
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		String html = getHoverInfoAsHtml(element);
		if (html != null) {
			StringBuffer buffer = new StringBuffer(html);
			HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
			HTMLPrinter.addPageEpilog(buffer);
			html = buffer.toString();
			return new XtextBrowserInformationControlInput(previous, element, html, labelProvider);
		}
		return null;
	}

	protected boolean hasHover(EObject o) {
		return nameProvider.getFullyQualifiedName(o) !=null;
	}

	protected String getDocumentation(EObject o) {
		return decoratedProvider.getDocumentation(o);
	}

	protected String getFirstLine(EObject o) {
		String label = getLabel(o);
		return o.eClass().getName()+ ((label != null) ? " <b>"+label+"</b>" : "");
	}
	
	protected String getLabel (EObject o) {
		String text = getLabelProvider().getText(o);
		if(!isEmpty(text))
			return HTMLPrinter.convertToHTMLContent(text);
		else
			return null;
	}
	
	protected ILabelProvider getLabelProvider () {
		return labelProvider;
	}
	
	protected XtextElementLinks getElementLinks () {
		return elementLinks;
	}
	
	@Inject
	private IURIEditorOpener uriEditorOpener;

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.editor.hover.XtextEditorHover.styleSheetFileName")
	private String styleSheetFileName = "/XtextHoverStyleSheet.css"; //$NON-NLS-1$

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.editor.hover.XtextEditorHover.font")
	private String fontSymbolicName = "org.eclipse.jdt.ui.javadocfont"; //$NON-NLS-1$ 

	@Inject
	private XtextElementLinks elementLinks;

	private static String fgStyleSheet;

	private IInformationControlCreator hoverControlCreator;

	private IInformationControlCreator presenterControlCreator;

	protected static final class BackAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public BackAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_Back);
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_BACK));
			setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_BACK_DISABLED));

			update();
		}

		@Override
		public void run() {
			BrowserInformationControlInput previous = (BrowserInformationControlInput) fInfoControl.getInput()
					.getPrevious();
			if (previous != null) {
				fInfoControl.setInput(previous);
			}
		}

		public void update() {
			BrowserInformationControlInput current = fInfoControl.getInput();

			if (current != null && current.getPrevious() != null) {
				BrowserInput previous = current.getPrevious();
				setToolTipText(MessageFormat.format(XtextUIMessages.XtextBrowserInformationControlInput_BackTo,
						new Object[] { previous.getInputName() }));
				setEnabled(true);
			} else {
				setToolTipText(XtextUIMessages.XtextBrowserInformationControlInput_Back);
				setEnabled(false);
			}
		}
	}

	protected static final class ForwardAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public ForwardAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_Forward);
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));
			setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD_DISABLED));

			update();
		}

		@Override
		public void run() {
			BrowserInformationControlInput next = (BrowserInformationControlInput) fInfoControl.getInput().getNext();
			if (next != null) {
				fInfoControl.setInput(next);
			}
		}

		public void update() {
			BrowserInformationControlInput current = fInfoControl.getInput();

			if (current != null && current.getNext() != null) {
				setToolTipText(MessageFormat.format(XtextUIMessages.XtextBrowserInformationControlInput_ForwardTo,
						new Object[] { current.getNext().getInputName() }));
				setEnabled(true);
			} else {
				setToolTipText(XtextUIMessages.XtextBrowserInformationControlInput_Forward);
				setEnabled(false);
			}
		}
	}

	// This part is responsible for display the hover content in the 
	// JavaDoc view. A corresponding XtextDoc view is not available yet.
	// Therefore this code is disabled for later use.

	//	private static final class ShowInJavadocViewAction extends Action {
	//		private final BrowserInformationControl fInfoControl;
	//
	//		public ShowInJavadocViewAction(BrowserInformationControl infoControl) {
	//			fInfoControl= infoControl;
	//			setText(JavaHoverMessages.JavadocHover_showInJavadoc);
	//			setImageDescriptor(JavaPluginImages.DESC_OBJS_JAVADOCTAG); //TODO: better image
	//		}
	//
	//		/*
	//		 * @see org.eclipse.jface.action.Action#run()
	//		 */
	//		@Override
	//		public void run() {
	//			JavadocBrowserInformationControlInput infoInput= (JavadocBrowserInformationControlInput) fInfoControl.getInput(); //TODO: check cast
	//			fInfoControl.notifyDelayedInputChange(null);
	//			fInfoControl.dispose(); //FIXME: should have protocol to hide, rather than dispose
	//			try {
	//				JavadocView view= (JavadocView) JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
	//				view.setInput(infoInput);
	//			} catch (PartInitException e) {
	//				JavaPlugin.log(e);
	//			}
	//		}
	//	}

	/**
	 * Action that opens the current hover input element.
	 * @since 2.3
	 */
	protected class OpenDeclarationAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public OpenDeclarationAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_OpenDeclaration);
			setImageDescriptor(XtextPluginImages.DESC_OPEN_DECLARATION);
			setDisabledImageDescriptor(XtextPluginImages.DESC_OPEN_DECLARATION_DISABLED);
		}

		/*
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			if (fInfoControl.getInput() instanceof XtextBrowserInformationControlInput) {
				XtextBrowserInformationControlInput infoInput = (XtextBrowserInformationControlInput) fInfoControl
						.getInput();
				fInfoControl.notifyDelayedInputChange(null);
				fInfoControl.dispose();
				if (uriEditorOpener != null)
					uriEditorOpener.open(createURI(infoInput.getElement()), true);
			}
		}
	}

	protected org.eclipse.emf.common.util.URI createURI(EObject o) {
		return o.eResource().getURI().appendFragment(o.eResource().getURIFragment(o));
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected void addLinkListener(final BrowserInformationControl control) {
		addLinkListener(new XtextBrowserInformationControlAdapter(control));
	}
	
	/**
	 * @since 2.3
	 */
	protected void addLinkListener(final IXtextBrowserInformationControl control) {
		control.addLocationListener(elementLinks.createLocationListener(new XtextElementLinks.ILinkHandler() {

			public void handleXtextdocViewLink(URI linkTarget) {
				// TODO: enable when XtextDoc view available
				//				control.notifyDelayedInputChange(null);
				//				control.setVisible(false);
				//				control.dispose(); //FIXME: should have protocol to hide, rather than dispose
				//				try {
				//					JavadocView view= (JavadocView) JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
				//					view.setInput(linkTarget);
				//				} catch (PartInitException e) {
				//					JavaPlugin.log(e);
				//				}
			}

			public void handleInlineXtextdocLink(URI linkTarget) {
				XtextBrowserInformationControlInput hoverInfo = getHoverInfo(getTarget(linkTarget), null,
						(XtextBrowserInformationControlInput) control.getInput());
				if (control.hasDelayedInputChangeListener())
					control.notifyDelayedInputChange(hoverInfo);
				else
					control.setInput(hoverInfo);
			}

			public void handleDeclarationLink(URI linkTarget) {
				control.notifyDelayedInputChange(null);
				control.dispose(); //FIXME: should have protocol to hide, rather than dispose
				if (uriEditorOpener != null)
					uriEditorOpener.open(linkTarget, true);
			}

			public boolean handleExternalLink(URL url, Display display) {
				control.notifyDelayedInputChange(null);
				control.dispose(); //FIXME: should have protocol to hide, rather than dispose

				// open external links in real browser:
				OpenBrowserUtil.openExternal(url, display);
				return true;
			}

			public void handleTextSet() {
			}

			EObject getTarget(URI uri) {
				ResourceSet rs = ((XtextBrowserInformationControlInput) control.getInput()).getElement().eResource()
						.getResourceSet();
				return rs.getEObject(uri, true);
			}
		}));
	}

	public class PresenterControlCreator extends AbstractReusableInformationControlCreator {

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (BrowserInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				String font = "org.eclipse.jdt.ui.javadocfont"; // FIXME: mPreferenceConstants.APPEARANCE_JAVADOC_FONT;
				IXtextBrowserInformationControl control = new XtextBrowserInformationControl(parent, font, tbm);
				configureControl(control, tbm, font);
				return control;
			} else {
				return new DefaultInformationControl(parent,true);
			}
		}
		
		/**
		 * @since 2.3
		 */
		protected void configureControl(final IXtextBrowserInformationControl control, ToolBarManager tbm, String font){
				final BackAction backAction = new BackAction(control);
				backAction.setEnabled(false);
				tbm.add(backAction);
				final ForwardAction forwardAction = new ForwardAction(control);
				tbm.add(forwardAction);
				forwardAction.setEnabled(false);

				//				final ShowInJavadocViewAction showInJavadocViewAction= new ShowInJavadocViewAction(iControl);
				//				tbm.add(showInJavadocViewAction);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(control);
				tbm.add(openDeclarationAction);

				//				final SimpleSelectionProvider selectionProvider= new SimpleSelectionProvider();

				IInputChangedListener inputChangeListener = new IInputChangedListener() {
					public void inputChanged(Object newInput) {
						backAction.update();
						forwardAction.update();
				
						if (newInput == null) {
							//							selectionProvider.setSelection(new StructuredSelection());
						} else if (newInput instanceof XtextBrowserInformationControlInput) {
							//							XtextBrowserInformationControlInput input= (XtextBrowserInformationControlInput) newInput;
							//							Object inputElement = input.getInputElement();
							//							selectionProvider.setSelection(new StructuredSelection(inputElement));
							//							boolean isJavaElementInput= inputElement instanceof IJavaElement;
							//							showInJavadocViewAction.setEnabled(isJavaElementInput);
							openDeclarationAction.setEnabled(true);
						}
					}
				};
				control.addInputChangeListener(inputChangeListener);
				tbm.update(true);
				addLinkListener(control);
		}
	}

	public class HoverControlCreator extends AbstractReusableInformationControlCreator {

		private final IInformationControlCreator fInformationPresenterControlCreator;

		public HoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.java.hover.AbstractReusableInformationControlCreator#doCreateInformationControl(org.eclipse.swt.widgets.Shell)
		 */
		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				String font = "org.eclipse.jdt.ui.javadocfont"; // FIXME: PreferenceConstants.APPEARANCE_JAVADOC_FONT;
				IXtextBrowserInformationControl iControl = new XtextBrowserInformationControl(parent, font,
						tooltipAffordanceString) {
					/*
					 * @see org.eclipse.jface.text.IInformationControlExtension5#getInformationPresenterControlCreator()
					 */
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.java.hover.AbstractReusableInformationControlCreator#canReuse(org.eclipse.jface.text.IInformationControl)
		 */
		@Override
		public boolean canReuse(IInformationControl control) {
			if (!super.canReuse(control))
				return false;

			if (control instanceof IInformationControlExtension4) {
				String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
				((IInformationControlExtension4) control).setStatusText(tooltipAffordanceString);
			}

			return true;
		}
	}

	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null)
			presenterControlCreator = new PresenterControlCreator();
		return presenterControlCreator;
	}

	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null)
			hoverControlCreator = new HoverControlCreator(getInformationPresenterControlCreator());
		return hoverControlCreator;
	}

	protected String getStyleSheet() {
		if (fgStyleSheet == null)
			fgStyleSheet = loadStyleSheet();
		String css = fgStyleSheet;
		if (css != null) {
			FontData fontData = JFaceResources.getFontRegistry().getFontData(fontSymbolicName)[0];
			css = HTMLPrinter.convertTopLevelFont(css, fontData);
		}
		return css;
	}

	/**
	 * Loads and returns the hover style sheet.
	 * 
	 * @return the style sheet, or <code>null</code> if unable to load
	 */
	protected String loadStyleSheet() {
		URL styleSheetURL = Activator.getDefault().getBundle().getEntry(styleSheetFileName); 
		if (styleSheetURL != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(styleSheetURL.openStream()));
				StringBuffer buffer = new StringBuffer(1500);
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				return buffer.toString();
			} catch (IOException ex) {
				return ""; //$NON-NLS-1$
			} finally {
				try {
					if (reader != null)
						reader.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	public IInformationControlCreatorProvider getHoverInfo(final EObject object, final ITextViewer viewer, final IRegion region) {
		return new IInformationControlCreatorProvider2() {

			public IInformationControlCreator getHoverControlCreator() {
				return DefaultEObjectHoverProvider.this.getHoverControlCreator();
			}

			public Object getInfo() {
				return getHoverInfo(object, region, null);
			}

			public IInformationControlCreator getInformationPresenterControlCreator() {
				return DefaultEObjectHoverProvider.this.getInformationPresenterControlCreator();
			}};
	}

}

