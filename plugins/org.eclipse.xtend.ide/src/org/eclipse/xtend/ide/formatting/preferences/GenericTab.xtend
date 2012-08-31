package org.eclipse.xtend.ide.formatting.preferences

import java.util.Map
import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage$IModificationListener
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.xtend.ide.formatting.SettingsData$Category
import org.eclipse.xtend.ide.formatting.FormatterPreferenceInfra
import static org.eclipse.xtend.ide.formatting.preferences.AbstractModifyDialogTab.*
import org.eclipse.xtend.ide.formatting.FormatterSetting

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class GenericTab  extends AbstractModifyDialogTab {
	extension FormatterPreferenceInfra = new FormatterPreferenceInfra
	String previewContent
	Category category

	new(IModificationListener modifyListener, Map<String, String> workingValues, SettingsData$Category category) {
		super(modifyListener, workingValues);
		this.category = category
		this.previewContent = previewText(category).toString
	}

	override doCreatePreferences(Composite composite, int numColumns) {
		val Group generalGroup = createGroup(numColumns, composite, GENERAL_SETTINGS);
		for(FormatterSetting prefData: settingsByCategory(category)) {
			createPref(prefData, generalGroup, numColumns)
		}
	}

	override protected previewText() {
		return previewContent
	}
}