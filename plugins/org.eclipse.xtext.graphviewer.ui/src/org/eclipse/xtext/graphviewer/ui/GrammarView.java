package org.eclipse.xtext.graphviewer.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.core.editor.BaseTextEditor;
import org.eclipse.xtext.ui.core.editor.model.XtextEditorModel;
import org.eclipse.xtext.ui.core.editor.outline.provider.XtextModelLabelProvider;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphContentProvider;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class GrammarView extends ViewPart {
    private GraphViewer viewer;
    private Action action1;
    private Action action2;
    private Action action3;

    static class MyContentProvider implements IGraphContentProvider {

        protected static final Object[] EMPTY_ARRAY = new Object[0];

        public Object getSource(Object rel) {
            if (rel instanceof EObject) {
                EObject eObject = (EObject) rel;
                return eObject.eContainer();
            }
            return null;
        }

        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof XtextEditorModel) {
                XtextEditorModel xtextEditorModel = (XtextEditorModel) inputElement;
                EObject astRoot = xtextEditorModel.getAstRoot();
                return astRoot.eContents().toArray();
            }
            return EMPTY_ARRAY;
        }

        public Object getDestination(Object rel) {
            if (rel instanceof EObject) {
                EObject eObject = (EObject) rel;
                return eObject;
            }
            return null;
        }

        public double getWeight(Object connection) {
            return 0;
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

    }

    static class MyLabelProvider extends LabelProvider {
        public Image getImage(Object element) {
            return null;
        }

        public String getText(Object element) {
            return element.toString();
        }

    }

    /**
     * The constructor.
     */
    public GrammarView() {
    }

    public void createPartControl(Composite parent) {
        viewer = new GraphViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        viewer.setContentProvider(new MyContentProvider());
        viewer.setLabelProvider(new XtextModelLabelProvider());
        viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
        // viewer.setLayoutAlgorithm(new CompositeLayoutAlgorithm(LayoutStyles.
        // NO_LAYOUT_NODE_RESIZING, new LayoutAlgorithm[] {
        // new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING
        // ),
        // new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }), true);

        viewer.setInput(getViewSite());

        setLinkingEnabled(true);
        makeActions();
        contributeToActionBars();
    }
    
    private void makeActions() {
        action1 = new Action() {
            public void run() {
                viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
            }
        };
        action1.setText("Springlayout");
        action1.setToolTipText("Activate Springlayout");
        action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
            getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
        
        action2 = new Action() {
            public void run() {
                 viewer.setLayoutAlgorithm(new CompositeLayoutAlgorithm(LayoutStyles.
                 NO_LAYOUT_NODE_RESIZING, new LayoutAlgorithm[] {
                 new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING
                 ),
                 new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }), true);
            }
        };
        action2.setText("Compositelayout");
        action2.setToolTipText("Activate Compositelayout");
        action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
                getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

        action3 = new Action() {
            public void run() {
                viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
            }
        };
        action3.setText("Radial Layout");
        action3.setToolTipText("Activate Radial Layout");
        action3.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
                getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
    }

    
    private void contributeToActionBars() {
        IActionBars bars = getViewSite().getActionBars();
        fillLocalPullDown(bars.getMenuManager());
    }

    private void fillLocalPullDown(IMenuManager manager) {
        manager.add(action1);
        manager.add(action2);
        manager.add(action3);
    }


    @Override
    public void dispose() {
        IWorkbenchPage page = getSite().getPage();
        if (page != null) {
            page.removePartListener(linkWithEditorListener);
        }
        viewer = null;
        super.dispose();
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    private IPartListener2 linkWithEditorListener = new IPartListener2() {
        public void partVisible(IWorkbenchPartReference partRef) {
        }

        public void partBroughtToTop(IWorkbenchPartReference partRef) {
        }

        public void partClosed(IWorkbenchPartReference partRef) {
        }

        public void partDeactivated(IWorkbenchPartReference partRef) {
        }

        public void partHidden(IWorkbenchPartReference partRef) {
        }

        public void partOpened(IWorkbenchPartReference partRef) {
        }

        public void partInputChanged(IWorkbenchPartReference partRef) {
            if (partRef instanceof IEditorReference) {
                editorActivated(((IEditorReference) partRef).getEditor(true));
            }
        }

        public void partActivated(IWorkbenchPartReference partRef) {
            if (partRef instanceof IEditorReference) {
                editorActivated(((IEditorReference) partRef).getEditor(true));
            }
        }

    };

    /**
     * An editor has been activated. Set the selection in this Packages Viewer
     * to be the editor's input, if linking is enabled.
     * 
     * @param editor
     *      the activated editor
     */
    void editorActivated(IEditorPart editor) {
        IEditorInput editorInput = editor.getEditorInput();
        if (editorInput == null)
            return;
        if (editor instanceof BaseTextEditor) {
            BaseTextEditor baseTextEditor = (BaseTextEditor) editor;
            XtextEditorModel model = baseTextEditor.getModel();
            viewer.setInput(model);
        }
        System.out.println("Editor " + editor.getTitle() + " activated.");
    }

    public void setLinkingEnabled(boolean enabled) {
        IWorkbenchPage page = getSite().getPage();
        if (enabled) {
            page.addPartListener(linkWithEditorListener);

            IEditorPart editor = page.getActiveEditor();
            if (editor != null) {
                editorActivated(editor);
            }
        }
        else {
            page.removePartListener(linkWithEditorListener);
        }
    }

}