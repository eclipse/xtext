/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting;

/**
 * @author dhuebner - Initial contribution and API
 */
public interface SettingsData {

	/**
	 * @author Dennis Huebner - Initial contribution and API
	 */
	public static enum Category {
		INDENTATION("indentation", "Indentation"), LINE_WRAPPING("line_wrapping", "Line wrapping");

		private String name;
		private String label;
		private boolean generic;

		private Category(String name, String label) {
			this(name, label, true);
		}

		private Category(String name, String label, boolean generic) {
			this.name = name;
			this.label = label;
			this.generic = generic;
		}

		public String getName() {
			return name;
		}

		public String getLabel() {
			return label;
		}

		public boolean isGeneric() {
			return generic;
		}
	}

	/**
	 * @author Dennis Huebner - Initial contribution and API
	 */
	public static enum WidgetType {
		COMBO_BOX, NUMBER_FIELD;
	}

}
