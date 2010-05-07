package org.eclipse.xtext.example.gmf.diagram.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditor;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitiesValidationDecoratorProvider extends AbstractProvider
		implements IDecoratorProvider {

	/**
	 * @generated
	 */
	private static final String KEY = "validationStatus"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static final String MARKER_TYPE = EntitiesDiagramEditorPlugin.ID
			+ ".diagnostic"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static MarkerObserver fileObserver;

	/**
	 * @generated
	 */
	private static Map/*<String, List<IDecorator>>*/allDecorators = new HashMap();

	/**
	 * @generated
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart
				|| editPart instanceof AbstractConnectionEditPart) {
			Object model = editPart.getModel();
			if ((model instanceof View)) {
				View view = (View) model;
				if (!(view instanceof Edge) && !view.isSetElement()) {
					return;
				}
			}
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (((DiagramEditDomain) ed).getEditorPart() instanceof EntitiesDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new StatusDecorator(
						decoratorTarget));
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		View view = (View) decoratorTarget.getAdapter(View.class);
		return view != null
				&& ModelEditPart.MODEL_ID.equals(EntitiesVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	public static void refreshDecorators(View view) {
		refreshDecorators(ViewUtil.getIdStr(view), view.getDiagram());
	}

	/**
	 * @generated
	 */
	private static void refreshDecorators(String viewId, Diagram diagram) {
		final List decorators = viewId != null ? (List) allDecorators
				.get(viewId) : null;
		if (decorators == null || decorators.isEmpty() || diagram == null) {
			return;
		}
		final Diagram fdiagram = diagram;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				try {
					TransactionUtil.getEditingDomain(fdiagram).runExclusive(
							new Runnable() {

								public void run() {
									for (Iterator it = decorators.iterator(); it
											.hasNext();) {
										IDecorator decorator = (IDecorator) it
												.next();
										decorator.refresh();
									}
								}
							});
				} catch (Exception e) {
					EntitiesDiagramEditorPlugin.getInstance().logError(
							"Decorator refresh failure", e); //$NON-NLS-1$
				}
			}
		});
	}

	/**
	 * @generated
	 */
	public static class StatusDecorator extends AbstractDecorator {

		/**
		 * @generated
		 */
		private String viewId;

		/**
		 * @generated
		 */
		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View) getDecoratorTarget().getAdapter(
						View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(
						new Runnable() {

							public void run() {
								StatusDecorator.this.viewId = view != null ? ViewUtil
										.getIdStr(view) : null;
							}
						});
			} catch (Exception e) {
				EntitiesDiagramEditorPlugin.getInstance().logError(
						"ViewID access failure", e); //$NON-NLS-1$			
			}
		}

		/**
		 * @generated
		 */
		public void refresh() {
			removeDecoration();
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			if (editPart == null || editPart.getViewer() == null) {
				return;
			}

			// query for all the validation markers of the current resource
			String elementId = ViewUtil.getIdStr(view);
			if (elementId == null) {
				return;
			}
			int severity = IMarker.SEVERITY_INFO;
			IMarker foundMarker = null;
			IResource resource = WorkspaceSynchronizer
					.getFile(view.eResource());
			if (resource == null || !resource.exists()) {
				return;
			}
			IMarker[] markers = null;
			try {
				markers = resource.findMarkers(MARKER_TYPE, true,
						IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				EntitiesDiagramEditorPlugin.getInstance().logError(
						"Validation markers refresh failure", e); //$NON-NLS-1$
			}
			if (markers == null || markers.length == 0) {
				return;
			}
			Label toolTip = null;
			for (int i = 0; i < markers.length; i++) {
				IMarker marker = markers[i];
				String attribute = marker
						.getAttribute(
								org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
								""); //$NON-NLS-1$
				if (attribute.equals(elementId)) {
					int nextSeverity = marker.getAttribute(IMarker.SEVERITY,
							IMarker.SEVERITY_INFO);
					Image nextImage = getImage(nextSeverity);
					if (foundMarker == null) {
						foundMarker = marker;
						toolTip = new Label(marker.getAttribute(
								IMarker.MESSAGE, ""), //$NON-NLS-1$
								nextImage);
					} else {
						if (toolTip.getChildren().isEmpty()) {
							Label comositeLabel = new Label();
							FlowLayout fl = new FlowLayout(false);
							fl.setMinorSpacing(0);
							comositeLabel.setLayoutManager(fl);
							comositeLabel.add(toolTip);
							toolTip = comositeLabel;
						}
						toolTip.add(new Label(marker.getAttribute(
								IMarker.MESSAGE, ""), //$NON-NLS-1$
								nextImage));
					}
					severity = (nextSeverity > severity) ? nextSeverity
							: severity;
				}
			}
			if (foundMarker == null) {
				return;
			}

			// add decoration
			if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
				if (view instanceof Edge) {
					setDecoration(getDecoratorTarget().addConnectionDecoration(
							getImage(severity), 50, true));
				} else {
					int margin = -1;
					if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
						margin = MapModeUtil.getMapMode(
								((org.eclipse.gef.GraphicalEditPart) editPart)
										.getFigure()).DPtoLP(margin);
					}
					setDecoration(getDecoratorTarget()
							.addShapeDecoration(getImage(severity),
									IDecoratorTarget.Direction.NORTH_EAST,
									margin, true));
				}
				getDecoration().setToolTip(toolTip);
			}
		}

		/**
		 * @generated
		 */
		private Image getImage(int severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IMarker.SEVERITY_WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageName);
		}

		/**
		 * @generated
		 */
		public void activate() {
			if (viewId == null) {
				return;
			}

			// add self to global decorators registry
			List list = (List) allDecorators.get(viewId);
			if (list == null) {
				list = new ArrayList(2);
				list.add(this);
				allDecorators.put(viewId, list);
			} else if (!list.contains(this)) {
				list.add(this);
			}

			// start listening to changes in resources
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null) {
				return;
			}
			Diagram diagramView = view.getDiagram();
			if (diagramView == null) {
				return;
			}
			if (fileObserver == null) {
				FileChangeManager.getInstance().addFileObserver(
						fileObserver = new MarkerObserver(diagramView));
			}
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			if (viewId == null) {
				return;
			}

			// remove self from global decorators registry
			List list = (List) allDecorators.get(viewId);
			if (list != null) {
				list.remove(this);
				if (list.isEmpty()) {
					allDecorators.remove(viewId);
				}
			}

			// stop listening to changes in resources if there are no more decorators
			if (fileObserver != null && allDecorators.isEmpty()) {
				FileChangeManager.getInstance()
						.removeFileObserver(fileObserver);
				fileObserver = null;
			}
			super.deactivate();
		}
	}

	/**
	 * @generated
	 */
	static class MarkerObserver implements IFileObserver {

		/**
		 * @generated
		 */
		private Diagram diagram;

		/**
		 * @generated
		 */
		private MarkerObserver(Diagram diagram) {
			this.diagram = diagram;
		}

		/**
		 * @generated
		 */
		public void handleFileRenamed(IFile oldFile, IFile file) {
		}

		/**
		 * @generated
		 */
		public void handleFileMoved(IFile oldFile, IFile file) {
		}

		/**
		 * @generated
		 */
		public void handleFileDeleted(IFile file) {
		}

		/**
		 * @generated
		 */
		public void handleFileChanged(IFile file) {
		}

		/**
		 * @generated
		 */
		public void handleMarkerAdded(IMarker marker) {
			if (marker
					.getAttribute(
							org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
							null) != null) {
				handleMarkerChanged(marker);
			}
		}

		/**
		 * @generated
		 */
		public void handleMarkerDeleted(IMarker marker, Map attributes) {
			String viewId = (String) attributes
					.get(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID);
			refreshDecorators(viewId, diagram);
		}

		/**
		 * @generated
		 */
		public void handleMarkerChanged(IMarker marker) {
			if (!MARKER_TYPE.equals(getType(marker))) {
				return;
			}
			String viewId = marker
					.getAttribute(
							org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
							""); //$NON-NLS-1$
			refreshDecorators(viewId, diagram);
		}

		/**
		 * @generated
		 */
		private String getType(IMarker marker) {
			try {
				return marker.getType();
			} catch (CoreException e) {
				EntitiesDiagramEditorPlugin.getInstance().logError(
						"Validation marker refresh failure", e); //$NON-NLS-1$
				return ""; //$NON-NLS-1$
			}
		}
	}
}
