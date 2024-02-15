package com.samsung.tizen.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LimitTag extends SimpleTagSupport
{
	private String content;
	private int limitLength;
	private boolean removeTag;

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setLimitLength(int limitLength)
	{
		this.limitLength = limitLength;
	}

	public void setRemoveTag(boolean removeTag)
	{
		this.removeTag = removeTag;
	}

	public void doTag() throws JspException, IOException
	{
		String text = content;

		if (removeTag)
		{
			text = content.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
		}

		int idxEnd = 0;
		byte[] textByte = text.getBytes("euc-kr");
		if (textByte != null && limitLength < textByte.length)
		{
			for (int i = 0; i < limitLength; i++)
			{
				int ch = (int) textByte[i];
				if ((ch > 127) || (ch < 0))
				{
					idxEnd++;
					i++;
				}
				else
				{
					idxEnd++;
				}
			}

			text = text.substring(0, idxEnd) + "...";
		}

		getJspContext().getOut().write(text);
	}
}
