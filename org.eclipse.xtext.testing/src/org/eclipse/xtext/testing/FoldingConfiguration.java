package org.eclipse.xtext.testing;

public class FoldingConfiguration extends TextDocumentConfiguration {

	private String expectedFoldings;

	public String getExpectedFoldings() {
		return expectedFoldings;
	}

	public void setExpectedFoldings(String expectedFoldings) {
		this.expectedFoldings = expectedFoldings;
	}
	
}
