/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.bindings.keys.IKeyLookup;
import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.IViewportListener;
import org.eclipse.jface.text.IWidgetTokenKeeper;
import org.eclipse.jface.text.IWidgetTokenKeeperExtension;
import org.eclipse.jface.text.IWidgetTokenOwner;
import org.eclipse.jface.text.IWidgetTokenOwnerExtension;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.Geometry;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.refactoring.impl.Messages;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class RenameRefactoringPopup implements IWidgetTokenKeeper, IWidgetTokenKeeperExtension {

	/**
	 * Offset of info hover arrow from the left or right side.
	 */
	private static final int HAO = 10;

	/**
	 * Width of info hover arrow.
	 */
	private static final int HAW = 8;

	/**
	 * Height of info hover arrow.
	 */
	private static final int HAH = 10;

	/**
	 * Gap between linked position and popup.
	 */
	private static final int GAP = 2;

	private XtextEditor editor;
	private RenameRefactoringController controller;

	private Region region;
	private static final int WIDGET_PRIORITY = 1000;
	private static boolean MAC = Util.isMac();
	private boolean delayJobFinished = false;
	private static final int POPUP_VISIBILITY_DELAY = 300;
	private String openDialogBinding;
	private Shell popup;
	private GridLayout popupLayout;
	private ToolBar toolBar;
	private Image menuImage;
	private MenuManager menuManager;
	private boolean iSMenuUp = false;

	private RenameLinkedMode renameLinkedMode;

	public RenameRefactoringPopup(XtextEditor editor, RenameRefactoringController controller, RenameLinkedMode renameLinkedMode) {
		this.editor = editor;
		this.controller = controller;
		this.renameLinkedMode = renameLinkedMode;
	}
	
	protected void updateVisibility() {
		if (popup != null && !popup.isDisposed() && delayJobFinished) {
			boolean visible = false;
			if (renameLinkedMode.isCaretInLinkedPosition()) {
				StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
				Rectangle eArea = Geometry.toDisplay(textWidget, textWidget.getClientArea());
				Rectangle pBounds = popup.getBounds();
				pBounds.x -= GAP;
				pBounds.y -= GAP;
				pBounds.width += 2 * GAP;
				pBounds.height += 2 * GAP;
				if (eArea.intersects(pBounds)) {
					visible = true;
				}
			}
			if (visible && !popup.isVisible()) {
				ISourceViewer viewer = editor.getInternalSourceViewer();
				if (viewer instanceof IWidgetTokenOwnerExtension) {
					IWidgetTokenOwnerExtension widgetTokenOwnerExtension = (IWidgetTokenOwnerExtension) viewer;
					widgetTokenOwnerExtension.requestWidgetToken(this, WIDGET_PRIORITY);
				}
			} else if (!visible && popup.isVisible()) {
				releaseWidgetToken();
			}
			popup.setVisible(visible);
		}
	}

	protected void releaseWidgetToken() {
		ISourceViewer viewer = editor.getInternalSourceViewer();
		if (viewer instanceof IWidgetTokenOwner) {
			IWidgetTokenOwner widgetTokenOwner = (IWidgetTokenOwner) viewer;
			widgetTokenOwner.releaseWidgetToken(this);
		}
	}

	public void open() {
		
		// Must cache here, since editor context is not available in menu from popup shell:
		openDialogBinding = getOpenDialogBinding();
		Shell workbenchShell = editor.getSite().getShell();
		final Display display = workbenchShell.getDisplay();
		popup = new Shell(workbenchShell, SWT.ON_TOP | SWT.NO_TRIM | SWT.TOOL);
		popupLayout = new GridLayout(2, false);
		popupLayout.marginWidth = 1;
		popupLayout.marginHeight = 1;
		popupLayout.marginLeft = 4;
		popupLayout.horizontalSpacing = 0;
		popup.setLayout(popupLayout);
		createContent(popup);
		updatePopupLocation();
		new PopupVisibilityManager().start();

		// Leave linked mode when popup loses focus
		// (except when focus goes back to workbench window or menu is open):
		popup.addShellListener(new ShellAdapter() {
			@Override
			public void shellDeactivated(ShellEvent e) {
				if (iSMenuUp)
					return;

				final Shell editorShell = editor.getSite().getShell();
				display.asyncExec(new Runnable() {
					// post to UI thread since editor shell only gets activated after popup has lost focus
					@Override
					public void run() {
						Shell activeShell = display.getActiveShell();
						if (activeShell != editorShell) {
							controller.cancelLinkedMode();
						}
					}
				});
			}
		});

		if (!MAC) { // carbon and cocoa draw their own border...
			popup.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent pe) {
					pe.gc.drawPolygon(getPolygon(true));
				}
			});
		}

		UIJob delayJob = new UIJob(display, "Delayed RenameInformationPopup") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				delayJobFinished = true;
				if (popup != null && !popup.isDisposed()) {
					updateVisibility();
				}
				return Status.OK_STATUS;
			}
		};
		delayJob.setSystem(true);
		delayJob.setPriority(Job.INTERACTIVE);
		delayJob.schedule(POPUP_VISIBILITY_DELAY);
	}

	protected void createContent(Composite parent) {
		Display display = parent.getDisplay();
		ColorRegistry registry = JFaceResources.getColorRegistry();
		Color foreground= registry.get("org.eclipse.ui.workbench.HOVER_FOREGROUND"); //$NON-NLS-1$
		if (foreground == null) {
			foreground = display.getSystemColor(SWT.COLOR_INFO_FOREGROUND);
		}
		Color background= registry.get("org.eclipse.ui.workbench.HOVER_BACKGROUND"); //$NON-NLS-1$
		if (background == null) {
			background = display.getSystemColor(SWT.COLOR_INFO_BACKGROUND);
		}
		StyledText hint = new StyledText(popup, SWT.READ_ONLY | SWT.SINGLE);
		String enterKeyName = getEnterBinding();
		String hintTemplate = RefactoringUIMessages.RefactoringHintTemplate_0;
		hint.setText(Messages.format(hintTemplate, enterKeyName));
		hint.setForeground(foreground);
		hint.setStyleRange(new StyleRange(hintTemplate.indexOf("{0}"), enterKeyName.length(), null, null, SWT.BOLD)); //$NON-NLS-1$
		hint.setEnabled(false); // text must not be selectable
		addViewMenu(parent);
		recursiveSetBackgroundColor(parent, background);
	}

	protected static void recursiveSetBackgroundColor(Control control, Color color) {
		control.setBackground(color);
		if (control instanceof Composite) {
			Control[] children = ((Composite) control).getChildren();
			for (int i = 0; i < children.length; i++) {
				recursiveSetBackgroundColor(children[i], color);
			}
		}
	}

	protected ToolBar addViewMenu(final Composite parent) {
		toolBar = new ToolBar(parent, SWT.FLAT);
		final ToolItem menuButton = new ToolItem(toolBar, SWT.PUSH, 0);
		menuImage = Activator.getImageDescriptor("icons/elcl16/view_menu.gif").createImage();
		menuButton.setImage(menuImage);
		menuButton.setToolTipText("Menu");
		toolBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				showMenu(toolBar);
			}
		});
		menuButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showMenu(toolBar);
			}
		});
		toolBar.pack();
		return toolBar;
	}

	protected void showMenu(ToolBar toolBar) {
		Menu menu = getMenuManager().createContextMenu(toolBar);
		menu.setLocation(toolBar.toDisplay(0, toolBar.getSize().y));
		iSMenuUp = true;
		menu.setVisible(true);
	}

	protected MenuManager getMenuManager() {
		if (menuManager != null) {
			return menuManager;
		}

		menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener2() {

			@Override
			public void menuAboutToHide(IMenuManager manager) {
				iSMenuUp = false;
			}

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				boolean canRefactor = renameLinkedMode.isCurrentNameValid();
				IAction refactorAction = new Action("Rename...") {
					@Override
					public void run() {
						activateEditor();
						controller.startRefactoring(RefactoringType.REFACTORING_DIRECT);
					}
				};
				refactorAction.setAccelerator(SWT.CR);
				refactorAction.setEnabled(canRefactor);
				manager.add(refactorAction);

				IAction previewAction = new Action("Preview...") {
					@Override
					public void run() {
						activateEditor();
						controller.startRefactoring(RefactoringType.REFACTORING_PREVIEW);
					}
				};
				previewAction.setAccelerator(SWT.CTRL | SWT.CR);
				previewAction.setEnabled(canRefactor);
				manager.add(previewAction);

				IAction openDialogAction = new Action("Open Rename Dialog..." + '\t' + openDialogBinding) {
					@Override
					public void run() {
						activateEditor();
						controller.startRefactoring(RefactoringType.REFACTORING_DIALOG);
					}
				};
				manager.add(openDialogAction);
			}
		});
		return menuManager;
	}

	protected static String getEnterBinding() {
		return KeyStroke.getInstance(KeyLookupFactory.getDefault().formalKeyLookup(IKeyLookup.CR_NAME)).format();
	}

	protected Point computePopupLocation() {
		if (popup == null || popup.isDisposed())
			return null;

		LinkedPosition position = renameLinkedMode.getCurrentLinkedPosition();
		if (position == null)
			return null;
		ISourceViewer viewer = editor.getInternalSourceViewer();
		ITextViewerExtension5 viewer5 = (ITextViewerExtension5) viewer;
		int widgetOffset = viewer5.modelOffset2WidgetOffset(position.offset);

		StyledText textWidget = viewer.getTextWidget();
		Point pos = textWidget.getLocationAtOffset(widgetOffset);
		Point pSize = getExtent();
		pSize.y += HAH + 1;
		pos.x -= HAO;
		pos.y += textWidget.getLineHeight(widgetOffset);
		Point dPos = textWidget.toDisplay(pos);
		Rectangle displayBounds = textWidget.getDisplay().getClientArea();
		Rectangle dPopupRect = Geometry.createRectangle(dPos, pSize);
		Geometry.moveInside(dPopupRect, displayBounds);
		return new Point(dPopupRect.x, dPopupRect.y);
	}

	protected Point getExtent() {
		Point e = popup.getSize();
		e.y -= HAH;
		return e;
	}

	protected void updatePopupLocation() {
		packPopup();
		Point loc = computePopupLocation();

		if (loc != null && !loc.equals(popup.getLocation())) {
			popup.setLocation(loc);
		}
	}

	protected void packPopup() {
		popupLayout.marginTop = HAH;
		popupLayout.marginBottom = 0;
		popup.pack();
		Region oldRegion = region;
		region = new Region();
		region.add(getPolygon(false));
		popup.setRegion(region);
		Rectangle bounds = region.getBounds();
		popup.setSize(bounds.width, bounds.height + 2);
		if (oldRegion != null) {
			oldRegion.dispose();
		}
	}

	protected int[] getPolygon(boolean border) {
		Point e = getExtent();
		int b = border ? 1 : 0;
		boolean isRTL = (popup.getStyle() & SWT.RIGHT_TO_LEFT) != 0;
		int ha1 = isRTL ? e.x - HAO : HAO + HAW;
		int ha2 = isRTL ? e.x - HAO - HAW / 2 : HAO + HAW / 2;
		int ha3 = isRTL ? e.x - HAO - HAW : HAO;
		int[] poly;
		poly = new int[] { 0, HAH, ha3 + b, HAH, ha2, b, ha1 - b, HAH, e.x - b, HAH, e.x - b, e.y + HAH - b, 0,
				e.y + HAH - b, 0, HAH };
		return poly;
	}

	/**
	 * WARNING: only works in workbench window context!
	 * 
	 * @return the keybinding for Refactor &gt; Rename
	 */
	protected static String getOpenDialogBinding() {
		IBindingService bindingService = PlatformUI.getWorkbench().getAdapter(IBindingService.class);
		if (bindingService == null)
			return ""; //$NON-NLS-1$
		String binding = bindingService
				.getBestActiveBindingFormattedFor("org.eclipse.xtext.ui.refactoring.RenameElement");
		return binding == null ? "" : binding; //$NON-NLS-1$
	}

	@Override
	public boolean requestWidgetToken(IWidgetTokenOwner owner, int priority) {
		return false;
	}

	@Override
	public boolean setFocus(IWidgetTokenOwner owner) {
		if (toolBar != null && !toolBar.isDisposed())
			showMenu(toolBar);
		return true;
	}

	@Override
	public boolean requestWidgetToken(IWidgetTokenOwner owner) {
		return false;
	}

	public boolean ownsFocusShell() {
		if (iSMenuUp)
			return true;
		if (popup == null || popup.isDisposed())
			return false;
		Shell activeShell = popup.getDisplay().getActiveShell();
		if (popup == activeShell)
			return true;
		return false;
	}

	protected void activateEditor() {
		editor.getSite().getShell().setActive();
	}

	public void close() {
		if (popup != null) {
			if (!popup.isDisposed()) {
				popup.close();
			}
			popup = null;
		}
		releaseWidgetToken();
		if (region != null) {
			if (!region.isDisposed()) {
				region.dispose();
			}
		}
	}

	protected class PopupVisibilityManager implements IPartListener2, ControlListener, MouseListener, KeyListener, IViewportListener {

		protected void start() {
			editor.getSite().getWorkbenchWindow().getPartService().addPartListener(this);
			final ISourceViewer viewer = editor.getInternalSourceViewer();
			final StyledText textWidget = viewer.getTextWidget();
			textWidget.addControlListener(this);
			textWidget.addMouseListener(this);
			textWidget.addKeyListener(this);
			editor.getSite().getShell().addControlListener(this);
			viewer.addViewportListener(this);
			popup.addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					editor.getSite().getWorkbenchWindow().getPartService()
							.removePartListener(PopupVisibilityManager.this);
					if (!textWidget.isDisposed()) {
						textWidget.removeControlListener(PopupVisibilityManager.this);
						textWidget.removeMouseListener(PopupVisibilityManager.this);
						textWidget.removeKeyListener(PopupVisibilityManager.this);
					}
					editor.getSite().getShell().removeControlListener(PopupVisibilityManager.this);
					viewer.removeViewportListener(PopupVisibilityManager.this);
					if (menuImage != null) {
						menuImage.dispose();
						menuImage = null;
					}
					if (menuManager != null) {
						menuManager.dispose();
						menuManager = null;
					}
				}
			});
		}

		@Override
		public void partActivated(IWorkbenchPartReference partRef) {
			IWorkbenchPart fPart = editor.getEditorSite().getPart();
			if (partRef.getPart(false) == fPart) {
				updateVisibility();
			}
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
			IWorkbenchPart fPart = editor.getEditorSite().getPart();
			if (popup != null && !popup.isDisposed() && partRef.getPart(false) == fPart) {
				popup.setVisible(false);
			}
		}

		@Override
		public void viewportChanged(int verticalOffset) {
			updatePopupLocation();
			updateVisibility();
		}

		@Override
		public void mouseUp(MouseEvent e) {
			updatePopupLocation();
			updateVisibility();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			updatePopupLocation();
			updateVisibility();
		}

		@Override
		public void controlMoved(ControlEvent e) {
			updatePopupLocation();
			updateVisibility();
		}

		@Override
		public void controlResized(ControlEvent e) {
			updatePopupLocation();
			updateVisibility();
		}

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

}
