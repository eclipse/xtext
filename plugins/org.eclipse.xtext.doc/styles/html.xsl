<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:import href="file:../../../lib/docbook/xsl/html/chunk.xsl" />
	<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" omit-xml-declaration="yes" />

    <xsl:param name="html.stylesheet">../book.css</xsl:param>
    <xsl:param name="chunk.first.sections" select="0" />
    <xsl:param name="chunk.section.depth" select="0" />
    <xsl:param name="base.dir" select="'contents/'"></xsl:param>
    <xsl:param name="use.id.as.filename" select="1" />
    <xsl:param name="suppress.navigation" select="0" />
    <xsl:param name="chapter.autolabel" select="0" />
    <xsl:param name="generate.section.toc.level" select="1"></xsl:param>
    <xsl:param name="toc.max.depth">1</xsl:param>
    <xsl:param name="table.borders.with.css" select="1"></xsl:param>
    <xsl:param name="table.cell.border.color" select="'#000000'"></xsl:param>
    <xsl:param name="table.cell.border.thickness" select="'2'"></xsl:param>
    <xsl:param name="html.cellspacing" select="'0'"></xsl:param>
    <xsl:param name="html.cellpadding" select="'10'"></xsl:param>

    <xsl:param name="html.cleanup" select="1"></xsl:param>

    <xsl:param name="generate.toc">
        appendix  toc,title
        article/appendix  nop
        article   toc,title
        book      toc
        chapter   toc
        part      toc
        preface   toc,title
        qandadiv  toc
        qandaset  toc
        reference toc,title
        sect1     nop
        sect2     nop
        sect3     nop
        sect4     nop
        sect5     nop
        section   nop
        set       toc,title
    </xsl:param>

</xsl:stylesheet>