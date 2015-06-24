package org.eclipse.xtext.web.server.occurrences

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.util.ITextRegion
import java.util.ArrayList
import org.eclipse.xtext.web.server.IServiceResult

@Data
@ToString(skipNulls = true)
class OccurrencesResult implements IServiceResult {
	val writeRegions = new ArrayList<ITextRegion>
	val readRegions = new ArrayList<ITextRegion>
	
	new(Iterable<ITextRegion> readRegions, Iterable<ITextRegion> writeRegions) {
		this.readRegions += readRegions
		this.writeRegions += writeRegions
	}
}

