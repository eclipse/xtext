<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" method="xml" indent="yes" />
	<xsl:strip-space elements="*" />

	<xsl:param name="mirrorsURL" />

	<xsl:template match="/">
		<xsl:processing-instruction name="artifactRepository">version='1.1.0'</xsl:processing-instruction>
		<xsl:apply-templates />
	</xsl:template>

	<!-- add p2.mirrorsURL property -->
	<xsl:template match="repository/properties">
		<properties size='{@size+1}'>
			<xsl:for-each select="property">
				<xsl:if test="@name = 'p2.mirrorsURL'">
					<xsl:message terminate="yes">
						<xsl:text>Property </xsl:text><xsl:value-of select="@*" /><xsl:text> is already set!</xsl:text>
					</xsl:message>
				</xsl:if>
			</xsl:for-each>
			<xsl:copy-of select="property" />
			<xsl:element name="property">
				<xsl:attribute name="name">p2.mirrorsURL</xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="$mirrorsURL" /></xsl:attribute>
			</xsl:element>
		</properties>
	</xsl:template>

	<xsl:template match="*">
		<xsl:copy>
			<xsl:for-each select="@*">
				<xsl:copy-of select="." />
			</xsl:for-each>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>

</xsl:stylesheet>