package com.duxiu.modules.velocity.event;

import org.apache.commons.lang3.StringEscapeUtils;

import com.duxiu.modules.velocity.tools.EscapeTool;

public class EscapeHtmlReference extends org.apache.velocity.app.event.implement.EscapeHtmlReference {
	
	@Override
	protected String escape(Object text) {
		String txt = text.toString();
		return txt.startsWith(EscapeTool.NOESC) ? txt.substring(EscapeTool.NOESC.length()) : StringEscapeUtils.escapeHtml4(text.toString());
	}
	
}
