<?xml version='1.0'?>
<!--
        $Id: article.xsl,v 1.3 2009/06/03 10:29:47 pfriese Exp $
        author: Chris Aniszczyk <zx@us.ibm.com>
        author: Lawrence Mandel <lmandel@ca.ibm.com>
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:import href="docbook.xsl" />
	
	<xsl:param name="html.stylesheet" select="'book.css'" />
	<xsl:param name="admon.graphics" select="1" />
	<xsl:param name="admon.graphics.path">images/</xsl:param>
	<xsl:param name="admon.graphics.extension">.png</xsl:param>
	<xsl:param name="suppress.navigation" select="1" />
	<xsl:param name="bibliography.numbered" select="1" />
    <xsl:param name="html.cleanup" select="1"></xsl:param>

    <xsl:param name="generate.toc">
        appendix  toc,title
        article/appendix  nop
        article   toc,title
        book      nop
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
	
	<xsl:param name="ulink.target" select="'_new'"/>
	<xsl:param name="admon.style">
  		<xsl:text>margin-left: 0.38in; margin-right: 0.38in;</xsl:text>
	</xsl:param>
</xsl:stylesheet>