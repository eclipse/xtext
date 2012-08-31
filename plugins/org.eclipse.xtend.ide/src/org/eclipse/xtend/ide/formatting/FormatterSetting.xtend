package org.eclipse.xtend.ide.formatting

import org.eclipse.xtend.lib.Data
import java.util.List

@Data
class FormatterSetting {
	SettingsData$Category category
	String name
	String label
	SettingsData$WidgetType type
	List<String> posibleValues
	
	def List<String> getPosibleValuesLabels(){
		return posibleValues?.map([it.toFirstUpper])?:emptyList
	}
}
