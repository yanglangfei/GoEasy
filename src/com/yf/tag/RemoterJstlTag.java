package com.yf.tag;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
public class RemoterJstlTag  extends TagSupport{
    private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest req=(HttpServletRequest) pageContext.getRequest();
			out.write(req.getRemoteAddr());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public String getId() {
		return super.getId();
	}

	@Override
	public Tag getParent() {
		return super.getParent();
	}

	@Override
	public Object getValue(String k) {
		return super.getValue(k);
	}

	@Override
	public Enumeration<String> getValues() {
		return super.getValues();
	}

	@Override
	public void release() {
		super.release();
	}

	@Override
	public void removeValue(String k) {
		super.removeValue(k);
	}

	@Override
	public void setId(String id) {
		super.setId(id);
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
	}

	@Override
	public void setParent(Tag t) {
		super.setParent(t);
	}

	@Override
	public void setValue(String k, Object o) {
		super.setValue(k, o);
	}
	
	
	
	

}
