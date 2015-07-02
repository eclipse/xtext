package org.eclipse.xtend.core.idea.facet;

import org.eclipse.xtext.idea.facet.GeneratorFacetEditorTab;
import org.eclipse.xtext.idea.facet.GeneratorFacetForm;
import org.eclipse.xtext.xbase.idea.facet.AbstractXbaseFacetConfiguration;

import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtend.core.XtendGenerator", storages = { @Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/XtendGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED) })
public class XtendFacetConfiguration extends AbstractXbaseFacetConfiguration implements PersistentStateComponent<XtendGeneratorConfigurationState>{

	@Override
	public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
		GeneratorFacetForm view = new XtendFacetForm(editorContext.getFacet().getModule());
		@SuppressWarnings("unchecked")
		GeneratorFacetEditorTab<XtendFacetConfiguration> controller = new GeneratorFacetEditorTab<XtendFacetConfiguration>(editorContext.getFacet(), view);
		return new FacetEditorTab[] { controller };
	}

	@Override
	protected XtendGeneratorConfigurationState createNewDefaultState() {
		return new XtendGeneratorConfigurationState(findDefaultOutputConfiguration());
	}

	@Override
	public XtendGeneratorConfigurationState getState() {
		return (XtendGeneratorConfigurationState) super.getState();
	}

	@Override
	public void loadState(XtendGeneratorConfigurationState state) {
		super.loadState(state);
	}

}
