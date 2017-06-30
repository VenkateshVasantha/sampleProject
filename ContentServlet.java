package com.venkat.content.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchContentURL")
public class ContentServlet extends HttpServlet {

	private List<String> contentSerachList;

	@Override
	public void init(ServletConfig config) throws ServletException {

		contentSerachList = new ArrayList<String>();

		contentSerachList.add("hello world");
		contentSerachList.add("Java is a programming language and a platform");
		contentSerachList.add("Java is a high level, robust, secured and object-oriented programming language");
		contentSerachList.add("HTML stands for Hyper Text Markup Language");
		contentSerachList.add("HTML is used to create web pages");
		contentSerachList.add("HTML is widely used language on the web");
		contentSerachList.add("JavaScript is the programming language of HTML and the Web");
		contentSerachList.add("JavaScript accepts both double and single quotes");
		contentSerachList.add("Be great in act, as you have been in thought");
		contentSerachList.add("What are the latest technologies in web development for UI developers?");
		contentSerachList.add("The latest trends in web development technologies have opened up numerous avenues for UI developers.");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String contentSearch = request.getParameter("contentName");
		
		if(!contentSearch.isEmpty()){
			
			int contentSearchLength = contentSearch.length();
			
			PrintWriter out = response.getWriter();//for using out.println()
			
			try{
				for (String contentDataName : contentSerachList) {
					if(contentDataName.length() >= contentSearchLength){
						if(contentSearch.equalsIgnoreCase(contentDataName.substring(0, contentSearchLength))){
						out.println(contentDataName);
						}
					}
				}
			}catch(StringIndexOutOfBoundsException exception){
				out.println("<br>System Error");
			}
		}
		
	}

}
