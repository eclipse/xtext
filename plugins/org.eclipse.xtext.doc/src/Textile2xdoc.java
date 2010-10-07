import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.internal.Lists;

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

/**
 * @author koehnlein - Initial contribution and API
 */
public class Textile2xdoc {

	public static void main(String[] args) {
		try {
			//new XdocStandaloneSetup().doSetup();
			new Textile2xdoc().transform();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transform() throws IOException {
		File sourceDir = new File("doc");
		File targetDir = new File("xdoc");
		targetDir.mkdir();
		FilenameFilter textileFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".textile");
			}
		};

		FileWriter index = new FileWriter(targetDir + File.separator + "Xtext.xdoc");
		index.write("document[Xtext Documentation]\n");
		FileWriter lastChapter = index;
		for (String sourceFileName : sourceDir.list(textileFilter)) {
			String sourceFullName = sourceDir.getName() + File.separator + sourceFileName;
			System.out.println(sourceFullName);
			String source = Files.readFileIntoString(sourceFullName);
			String target = transform(source);
			String targetFullName = targetDir.getName() + File.separator
					+ sourceFileName.replaceAll("\\.textile", ".xdoc");
			System.out.println("-->" + targetFullName);
			Files.writeStringIntoFile(targetFullName, target);
			if(!Strings.isEmpty(target)) {
				String sectionType = target.substring(0, target.indexOf(':'));
				String sectionLabel = target.substring(target.indexOf(':') + 1 , target.indexOf("["));
				if("chapter".equals(sectionType)) {
					index.write("\n\n" + sectionType + "-ref[" + sectionLabel + "]");
					if(lastChapter != index) 
						lastChapter.close();
					lastChapter = new FileWriter(targetFullName, true);
				} else {
					lastChapter.write("\n\n" + sectionType + "-ref[" + sectionLabel + "]");
				}
			}
			System.out.println();
		}
		index.close();
	}

	private String transform(String source) {
		return new TransformationBuilder(source).transformBrackets()

		.transformBlocks().transformEnumerations("#", "ol").transformEnumerations("\\*", "ul")

		.transformMarkup("\\*\\*", "\\*\\*", "e").transformMarkup("__", "__", "e").transformMarkup("_", "_", "e")
				.transformMarkup("\\*", "\\*", "e")

				.transformLabels().transformLinks().transformCodeRefs()

				.transformHeading("h1", "chapter").transformHeading("h2", "section").transformHeading("h3", "section2")
				.transformHeading("h4", "section3").transformHeading("h5", "section4")

				.transformParagraphs()

				.transformTables().transformImages()

				.transformNewlines()

				.toString();
	}

	public static class TransformationBuilder {

		public static final String LABEL_TERMINAL_CHARS = "\\,\\.\\)\\|\\:\\s\\]";
		public static final String HREF_TERMINAL_CHARS = ",\\)\\|\\s\\]";

		private List<Region> regions;

		public TransformationBuilder(String source) {
			createRegions(source);
		}

		public TransformationBuilder createRegions(String source) {
			List<String> bcSections = findBcSections(source,
					"^(bc\\.\\. *(.*?))\n((\\p{Alpha}\\p{Alnum}*((\\(\\#)|(\\.\\.? )))|\\Z)", Pattern.DOTALL
							| Pattern.MULTILINE);
			bcSections.addAll(findBcSections(source, "^(bc\\. *(.*?))$", Pattern.DOTALL | Pattern.MULTILINE));
			List<Pair<Integer, Integer>> bcLocations = Lists.newArrayList();
			for (String bcSection : bcSections) {
				Pair<Integer, Integer> bcLocation = Tuples.create(source.indexOf(bcSection), bcSection.length());
				if (!bcLocations.contains(bcLocation))
					bcLocations.add(bcLocation);
			}
			Collections.sort(bcLocations, new Comparator<Pair<Integer, Integer>>() {
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return (o1.getFirst() != o2.getFirst()) ? o1.getFirst() - o2.getFirst() : o2.getSecond()
							- o1.getSecond();
				}
			});
			int currentOffset = 0;
			regions = Lists.newArrayList();
			for (Pair<Integer, Integer> bcLocation : bcLocations) {
				if (currentOffset <= bcLocation.getFirst()) {
					if (currentOffset != bcLocation.getFirst()) {
						regions.add(new Region(source, currentOffset, bcLocation.getFirst() - currentOffset, false));
					}
					Region bcRegion = new Region(source, bcLocation.getFirst(), bcLocation.getSecond(), true);
					regions.add(bcRegion);
					currentOffset = bcLocation.getFirst() + bcLocation.getSecond();
				}
			}
			if (currentOffset < source.length())
				regions.add(new Region(source, currentOffset, source.length() - currentOffset, false));
			if (!toString().equals(source))
				throw new IllegalStateException();
			return this;
		}

		private List<String> findBcSections(String source, String regex, int flags) {
			List<String> matches = Lists.newArrayList();
			Pattern pattern = Pattern.compile(regex, flags);
			int currentOffset = 0;
			Matcher matcher = pattern.matcher(source);
			while (matcher.find(currentOffset)) {
				matches.add(matcher.group(1));
				currentOffset = matcher.start(1) + 1;
			}
			return matches;
		}

		private TransformationBuilder replaceAllMultiLine(String regex, String replacement) {
			return replaceAll(regex, replacement, Pattern.DOTALL | Pattern.MULTILINE);
		}

		private TransformationBuilder replaceAllSingleLine(String regex, String replacement) {
			return replaceAll(regex, replacement, Pattern.MULTILINE);
		}

		private TransformationBuilder replaceAll(String regex, String replacement, int flags) {
			for (Region region : regions) {
				if (!region.isProtected) {
					Matcher matcher = Pattern.compile(regex, flags).matcher(region.content);
					region.content = matcher.replaceAll(replacement);
				}
			}
			return this;
		}

		public TransformationBuilder transformBrackets() {
			// also convert braces in bc. environments 
			for (Region region : regions)
				region.content = region.content.replaceAll("\\[", "\\\\[").replaceAll("\\]", "\\\\]");
			return this;
		}

		public TransformationBuilder transformHeading(String textileHeading, String xdocHeading) {
			return replaceAllSingleLine("^" + textileHeading + "\\(#([^\\)]*)\\)\\.\\s(.*?)\\s*$",
					"\n" + xdocHeading + ":$1[$2]\n").replaceAllSingleLine("^" + textileHeading + "\\.\\s(.*?)\\s*$",
					"\n" + xdocHeading + "[$1]\n");
		}

		public TransformationBuilder transformMarkup(String textileStart, String textileEnd, String xdocMarkup) {
			return replaceAllSingleLine("(\\s)" + textileStart + "([^" + textileEnd + "\n]*?)" + textileEnd, "$1"
					+ xdocMarkup + "[$2]");
		}

		public TransformationBuilder transformCodeRefs() {
			for (String codeRef : findMultiLineMatches("(\\$\\{([^\\}]*)?\\})")) {
				if (codeRef.contains("/")) {
					String javaFQN = codeRef.substring(codeRef.lastIndexOf('/') + 1, codeRef.length() - 1);
					System.out.println(codeRef + " -> " + javaFQN);
					replaceAllMultiLine(Pattern.quote(codeRef), "codeRef[" + javaFQN + "]");
				}
			}
			return this;
		}

		public TransformationBuilder transformBlocks() {
			for (Region region : regions) {
				if (region.isProtected) {
					region.content = region.content.replaceAll("^bc\\.(\\.)? ", "\n\ncode[Java][") + "]\n\n";
				}
			}

			// perform same replace twice as we are matching the follow 
			// up tokens which could be the beginning of the next match
			return replaceAllMultiLine("^bc\\.\\. *(.*?)\n((\\p{Alpha}\\p{Alnum}*(\\(|\\.\\.? ))|\\z)", "code[$1]\n$2")
					.replaceAllMultiLine("^bc\\.\\. *(.*?)\n((\\p{Alpha}\\p{Alnum}*(\\(|\\.\\.? ))|\\z)",
							"code[$1]\n$2").replaceAllMultiLine("^bc\\. *(.*?)$", "code[$1]\n");
		}

		public TransformationBuilder transformLinks() {
			return replaceAllMultiLine("\"([^\"\n]*)\":#([^" + LABEL_TERMINAL_CHARS + "]*)", "ref:$2[$1]")
					.replaceAllMultiLine("\"([^\"\n]*)\":([^" + HREF_TERMINAL_CHARS + "]*)", "link[$2][$1]");
		}

		public TransformationBuilder transformEnumerations(String textileMarker, String xdocEnvironment) {
			return replaceAllMultiLine("((^" + textileMarker + "+ .*?$)+)(^\\s*$|\\z)",
					todo("revise indentation levels") + xdocEnvironment + "[\n$1]\n").replaceAllSingleLine(
					"^" + textileMarker + "+ (.*?)$", "item[$1]");
		}

		private String todo(String string) {
			return "todo[" + string + "]\n";
		}

		public TransformationBuilder transformTables() {
			replaceAllMultiLine("((^\\|.*?$)+)^ *$", "table[\n$1]\n");

			List<String> tableRows = findSingleLineMatches("^(\\|.*?)$");
			for (String tableRow : tableRows) {
				StringBuilder replaceBuffer = new StringBuilder("tr[");
				for (String td : tableRow.substring(1).split("\\|")) {
					replaceBuffer.append("td[");
					String tdContent = Strings.isEmpty(td.trim()) ? " " : td.trim();
					replaceBuffer.append(tdContent);
					replaceBuffer.append("]");
				}
				replaceBuffer.append("]");
				replaceAllMultiLine(Pattern.quote(tableRow), replaceBuffer.toString());
			}
			return this;
		}

		public TransformationBuilder transformLabels() {
			List<String> labels = findSingleLineMatches("#(\\p{Alpha}[^" + LABEL_TERMINAL_CHARS + "]*)");
			for (String label : labels) {
				String validLabel = label.replaceAll("[^\\p{Alnum}_]", "_");
				if (!label.equals(validLabel)) {
					System.out.println("Changing #" + label + " to #" + validLabel);
					replaceAllSingleLine("#" + Pattern.quote(label) + "([" + LABEL_TERMINAL_CHARS + "])", "#"
							+ validLabel + "$1");
				}
			}
			return this;
		}

		public TransformationBuilder transformParagraphs() {
			return replaceAllMultiLine("^p\\.\\s*", "");
		}

		public TransformationBuilder transformNewlines() {
			return replaceAllMultiLine("\\A\\n*", "").replaceAllMultiLine("^\\s+$", "\n").replaceAllMultiLine("\n*\\z",
					"");
		}

		public TransformationBuilder transformImages() {
			return replaceAllMultiLine("^\\!(\\{([^\\}]*)\\})?([^\\!]*?)(\\([^\\)]*?\\))?!$", "img[$3][ ][ $2][ $4]\n");
		}

		private List<String> findMatches(String regex, int flags) {
			List<String> matches = Lists.newArrayList();
			for (Region region : regions) {
				if (!region.isProtected) {
					Pattern pattern = Pattern.compile(regex, flags);
					int currentStart = 0;
					Matcher matcher = pattern.matcher(region.content);
					while (matcher.find(currentStart)) {
						matches.add(matcher.group(1));
						currentStart = matcher.start(1) + 1;
					}
				}
			}
			return matches;
		}

		private List<String> findMultiLineMatches(String regex) {
			return findMatches(regex, Pattern.MULTILINE | Pattern.DOTALL);
		}

		private List<String> findSingleLineMatches(String regex) {
			return findMatches(regex, Pattern.MULTILINE);
		}

		@Override
		public String toString() {
			StringBuilder r = new StringBuilder();
			for (Region region : regions)
				r.append(region.content);
			return r.toString();
		}

		class Region {
			boolean isProtected;
			private String content;

			Region(String document, int offset, int length, boolean isBlock) {
				this.content = document.substring(offset, offset + length);
				this.isProtected = isBlock;
			}
		}
	}
}
