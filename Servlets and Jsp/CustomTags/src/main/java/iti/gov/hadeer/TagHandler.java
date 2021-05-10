package iti.gov.hadeer;

import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;
import java.io.*;

public class TagHandler implements Tag{
	private PageContext pc;
	private int num;
	public int getNum(){
		return num;
	}
	public void setNum(int num) {
		this.num= num;
	}
	public void setParent(Tag t){}
	public void setPageContext(PageContext p) 
	{
		pc = p;
	}
	public void release() {}
	public Tag getParent() {
		return null;
	}
	public int doStartTag() {
		try{
		pc.getOut().println("The value is"+ num);
		}catch(IOException e){
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() 
	{
		return EVAL_PAGE;
	}
	
}