package org.eclipse.xtext.gmf.glue.edit.part;

public class StringUtil {

	public static int getNumLines(String s)  {
		int numLines = 1;
		for(char c: s.toCharArray()) {
			if(c=='\n') {
				++numLines;
			}
		}
		return numLines;
	}

	public static int getMaxColumns(String s)  {
		int maxColumns = 0;
		int currentColumns = 0;
		for(char c: s.toCharArray()) {
			if(c=='\n') {
				maxColumns = Math.max(maxColumns, currentColumns);
				currentColumns =0;
			} else {
				++ currentColumns;
			}
		}
		return Math.max(currentColumns, maxColumns);
	}
}
