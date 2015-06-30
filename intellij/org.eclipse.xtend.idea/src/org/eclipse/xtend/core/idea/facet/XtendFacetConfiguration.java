package org.eclipse.xtend.core.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorFacetEditorTab;

import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtend.core.XtendGenerator", storages = { @Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/XtendGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED) })
public class XtendFacetConfiguration extends AbstractFacetConfiguration<XtendGeneratorConfigurationState> {

	@Override
	public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
		XtendFacetForm view = new XtendFacetForm(editorContext.getFacet().getModule());
		@SuppressWarnings("unchecked")
		GeneratorFacetEditorTab<?, ?> controller = new GeneratorFacetEditorTab<XtendFacetConfiguration, XtendGeneratorConfigurationState>(
				editorContext.getFacet(), view);
		return new FacetEditorTab[] { controller };
	}

	@Override
	protected XtendGeneratorConfigurationState createNewState() {
		return new XtendGeneratorConfigurationState();
	}

}
